<template>
    <div>
        <div class="mb-4">
            <h5 class="text-danger fw-light text-center">
                กรุณาตรวจสอบรายละเอียดให้เรียบร้อยก่อนกดยืนยันการจอง
            </h5>
        </div>
        <receipt :detail="detail" />
        <div class="text-center mt-5">
            <button class="btn btn-emerald py-3 px-5">
                ยืนยันการจอง
            </button>
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