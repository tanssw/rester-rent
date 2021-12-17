<template>
    <div>
        <h3 class="fw-light mb-5">
            <i class="fas fa-file-invoice me-1"></i>
            ส่งหลักฐานการโอนเงิน
        </h3>
        <div class="row g-5">
            <div class="col-6">
                <div v-for="(input, key, index) in inputs" :key="index" :class="{'mt-4': index}" class="row align-items-center">
                    <div class="col-3">
                        {{input.title}}
                        <span class="text-danger">*</span>
                    </div>
                    <div class="col-9">
                        <input v-model="input.value" :type="input.type" :placeholder="input.placeholder" class="form-control p-3">
                    </div>
                </div>
                <div class="text-end mt-4">
                    <span v-if="isError" class="text-danger small me-3">
                        เกิดข้อผิดพลาดในการดำเนินการ กรุณาลองใหม่ในภายหลัง
                    </span>
                    <button @click="sendPayment()" :disabled="!isValid" class="btn btn-emerald px-4 py-2">ส่งหลักฐาน</button>
                </div>
            </div>
            <div class="col-6">
                <h5 class="mb-4">การส่งหลักฐานการโอนเงิน</h5>
                <ul>
                    <li>กรุณาดำเนินการโอนเงินหลังจากได้รับการอนุมัติ</li>
                    <li>ดำเนินการส่งหลักฐานการโอนเงินโดยทันที</li>
                    <li>พนักงานมีสิทธิ์ยกเลิกรายการของท่าน หากไม่ดำเนินการโอนเงินภายใน 3 วัน</li>
                    <li>พนักงานจะติดต่อท่านทางอีเมลที่ท่านได้แนบไว้เท่านั้น</li>
                </ul>
            </div>
        </div>
        <success-modal ref="successModal"/>
    </div>
</template>
<style scoped>
li {
    margin: 1em auto;
}
</style>
<script>
import axios from 'axios'
import dayjs from 'dayjs'

import SuccessModal from './SuccessModal.vue'

export default {
    components: {
        SuccessModal
    },
    data() {
        return {
            inputs: {
                referenceNo: {
                    title: 'รหัสอ้างอิง',
                    type: 'text',
                    placeholder: 'รหัสอ้างอิง / เลขที่รายการ',
                    value: ''
                },
                date: {
                    title: 'วันที่',
                    type: 'date',
                    placeholder: '',
                    value: ''
                },
                time: {
                    title: 'เวลา',
                    type: 'time',
                    placeholder: '',
                    value: ''
                },
                amount: {
                    title: 'จำนวนเงิน',
                    type: 'number',
                    placeholder: '0000.00',
                    value: ''
                },
                email: {
                    title: 'อีเมลที่ใช้ติดต่อ',
                    type: 'email',
                    placeholder: 'example@resterrent.com',
                    value: ''
                }
            },
            isError: false
        }
    },
    computed: {
        isValid() {
            let values = Object.values(this.inputs).map(input => input.value)
            let notFilled = values.filter(value => value === '')
            return !notFilled.length
        },
    },
    methods: {
        async sendPayment() {

            let date = this.inputs.date.value
            let time = this.inputs.time.value

            try {
                const path = `${process.env.VUE_APP_API_TARGET}/addPayment`
                const body = {
                    amount: this.inputs.amount.value,
                    mail: this.inputs.email.value,
                    date_time: dayjs(`${date} ${time}`, 'YYYY-MM-DD HH:mm'),
                    reference: this.inputs.referenceNo.value
                }
                await axios.patch(path, body)
                this.$refs.successModal.tempShow()
            } catch (error) {
                this.isError = true
            }

        }
    }
}
</script>