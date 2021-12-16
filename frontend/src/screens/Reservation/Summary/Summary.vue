<template>
    <div>
        <div class="mb-4">
            <h5 class="text-danger fw-light text-center">
                กรุณาตรวจสอบรายละเอียดให้เรียบร้อยก่อนกดยืนยันการจอง
            </h5>
        </div>
        <div class="row justify-content-center">
            <div class="col-8">
                <receipt :total="totalPrice" :detail="detail" />
                <div class="mt-5">
                    <div class="row mb-3 align-items-center">
                        <span class="col-3">ชื่อลูกค้า</span>
                        <div class="col-9">
                            <input v-model="name" type="email" placeholder="ชื่อ นามสกุล" :class="{'border-emerald': name}" class="form-control px-4 py-3">
                        </div>
                    </div>
                    <div class="row mb-5 align-items-center">
                        <span class="col-3">อีเมลสำหรับติดต่อ</span>
                        <div class="col-9">
                            <input v-model="email" type="email" placeholder="customer@example.com" :class="{'border-emerald': validEmail}" class="form-control px-4 py-3">
                        </div>
                    </div>
                    <div class="text-center">
                        <div v-if="isError" class="text-danger h6 mb-4">
                            เกิดข้อผิดพลาดระหว่างดำเนินการ กรุณาลองใหม่ในภายหลัง
                        </div>
                        <button @click="requestOrder()" :disabled="!validInformation" class="btn btn-emerald py-3 px-5">
                            ยืนยันการจอง
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <success-modal ref="successModal" />
    </div>
</template>
<script>
import dayjs from 'dayjs'
import axios from 'axios'

import Receipt from './Receipt.vue'
import SuccessModal from './SuccessModal.vue'

export default {
    components: {
        Receipt,
        SuccessModal
    },
    props: {
        reservation: {
            type: Object
        },
        spec: {
            type: Object
        }
    },
    data() {
        return {
            name: null,
            email: null,
            isError: false
        }
    },
    computed: {
        detail() {
            return {
                reservation: this.reservation,
                spec: this.spec
            }
        },
        validEmail() {
            let re = /\S+@\S+\.\S+/
            return re.test(this.email)
        },
        validInformation() {
            return this.name && this.validEmail
        },
        existing() {
            let reservation = this.reservation
            let spec = this.spec

            return {
                hasRoom: Object.keys(reservation.room).length,
                hasTheme: Object.keys(spec.theme).length,
                hasBand: Object.keys(spec.music.band).length,
                hasFood: Object.keys(spec.food).length
            }
        },
        totalPrice() {
            let reservation = this.reservation
            let spec = this.spec

            let musicPrice = (spec.music.type === 'audio') ? 0 : spec.music.band.price

            let total = 0
            if (this.existing.hasRoom) total += reservation.room.price
            if (this.existing.hasTheme) total += spec.theme.price
            if (this.existing.hasRoom || this.existing.hasBand) total += musicPrice
            if (this.existing.hasFood) total += spec.food.size.price

            return total
        },
    },
    methods: {
        formatSpec(exist, id, price) {
            if (exist) return {id: id, price: price}
            return {id: null, price: 0}
        },
        async requestOrder() {
            let reservation = this.reservation
            let spec = this.spec

            let startDate = dayjs(`${reservation.date} ${reservation.startAt}:00`, 'YYYY-MM-DD H:mm').format()
            let endDate = dayjs(`${reservation.date} ${reservation.endAt}:00`, 'YYYY-MM-DD H:mm').format()

            let theme = this.formatSpec(this.existing.hasTheme, spec.theme.id, spec.theme.price)
            let food = this.formatSpec(this.existing.hasFood, spec.food.id, spec.food.price)
            let music = this.formatSpec(this.existing.hasBand, spec.music.band.id, spec.music.band.price)

            let body = {
                fullname: this.name,
                mail: this.email,
                start_date: startDate,
                end_date: endDate,
                income: this.totalPrice,
                details: {
                    theme: theme,
                    food: food,
                    music: music,
                    location: {id: reservation.room.id, price: reservation.room.price}
                }
            }

            try {
                let path = `${process.env.VUE_APP_API_TARGET}/addOrder`
                await axios.patch(path, body)
                this.$refs.successModal.tempShow()
            } catch (error) {
                this.isError = true
                console.log(error)
            }

        }
    }
}
</script>