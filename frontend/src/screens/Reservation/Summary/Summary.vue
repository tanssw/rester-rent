<template>
    <div>
        <div class="mb-4">
            <h5 class="text-danger fw-light text-center">
                กรุณาตรวจสอบรายละเอียดให้เรียบร้อยก่อนกดยืนยันการจอง
            </h5>
        </div>
        <div class="row justify-content-center">
            <div class="col-8">
                <receipt :detail="detail" />
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
                        <button :disabled="!validInformation" class="btn btn-emerald py-3 px-5">
                            ยืนยันการจอง
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
import Receipt from './Receipt.vue'

export default {
    components: {
        Receipt
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
            email: null
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
        }
    }
}
</script>