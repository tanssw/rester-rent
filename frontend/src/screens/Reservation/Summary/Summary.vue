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
                <div class="text-center mt-5">
                    <div class="d-flex align-items-center my-5">
                        <span>อีเมลสำหรับติดต่อ</span>
                        <div class="flex-grow-1 ms-4">
                            <input v-model="email" type="email" placeholder="customer@example.com" :class="{'border-emerald': validEmail}" class="form-control px-4 py-3">
                        </div>
                    </div>
                    <button :disabled="!validEmail" class="btn btn-emerald py-3 px-5">
                        ยืนยันการจอง
                    </button>
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
        }
    }
}
</script>