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
                        <span class="flex-grow-1">อีเมลสำหรับติดต่อ</span>
                        <input type="email" placeholder="customer@example.com" class="form-control px-4 py-3">
                    </div>
                    <button class="btn btn-emerald py-3 px-5">
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
    computed: {
        detail() {
            return {
                reservation: this.reservation,
                spec: this.spec
            }
        }
    }
}
</script>