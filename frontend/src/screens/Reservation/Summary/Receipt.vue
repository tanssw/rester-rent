<template>
    <div class="border rounded-3 fw-light p-5">
        <div class="row mb-5">
            <div class="col">
                <h2 class="fw-bold text-emerald mb-0">
                    <i class="fas fa-concierge-bell"></i>
                    Rester Rent
                </h2>
            </div>
            <div class="col text-end">
                <div class="my-2">วันที่ {{reserveDate}}</div>
                <div class="my-2">เวลา {{reserveTime}}</div>
            </div>
        </div>
        <div>
            <div class="d-flex justify-content-between">
                <h5>รายละเอียด</h5>
                <h5>ราคา</h5>
            </div>
            <div v-for="(item, index) in list" :key="index" class="d-flex justify-content-between my-3">
                <div>{{item.title}}</div>
                <div>{{item.price}}</div>
            </div>
            <div class="d-flex justify-content-between fw-bold mt-4">
                <div>ราคารวม</div>
                <div>{{total}}</div>
            </div>
        </div>
    </div>
</template>
<script>
import dayjs from 'dayjs'

export default {
    props: {
        total: {
            type: Number
        },
        detail: {
            type: Object
        }
    },
    emits: ['update:total'],
    data() {
        return {

        }
    },
    computed: {
        reserveDate() {
            let date = this.detail.reservation.date
            return date ? dayjs(date).format('DD/MM/YYYY') : '[ไม่ได้ระบุ]'
        },
        reserveTime() {
            let reservation = this.detail.reservation
            let startAt = reservation.startAt
            let endAt = reservation.endAt
            return (startAt && endAt) ? `${startAt}:00 - ${endAt}:00` : '[ไม่ได้ระบุ]'
        },
        existing() {
            let reservation = this.detail.reservation
            let spec = this.detail.spec

            return {
                hasRoom: Object.keys(reservation.room).length,
                hasTheme: Object.keys(spec.theme).length,
                hasBand: Object.keys(spec.music.band).length,
                hasFood: Object.keys(spec.food).length
            }
        },
        list() {
            let reservation = this.detail.reservation
            let spec = this.detail.spec

            let musicTitle = (spec.music.type === 'audio') ? 'เครื่องเสียงภายในห้อง' : `ดนตรีสด วง ${spec.music.band.name}`
            let musicPrice = (spec.music.type === 'audio') ? 0 : spec.music.band.price

            let list = []
            if (this.existing.hasRoom) list.push({title: `ห้อง ${reservation.room.name}`, price: reservation.room.price})
            if (this.existing.hasTheme) list.push({title: `ธีมงาน ${spec.theme.tname}`, price: spec.theme.price})
            if (this.existing.hasRoom || this.existing.hasBand) list.push({title: musicTitle, price: musicPrice})
            if (this.existing.hasFood) list.push({title: `ชุดอาหาร ${spec.food.fName}`, price: spec.food.size.price})

            return list
        }
    },
}
</script>