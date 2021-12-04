<template>
    <div>
        <div class="text-end">
            <button @click="openConfirmation()" class="btn btn-lighter-emerald btn-next px-3 py-2" :disabled="!isValid">
                <div class="d-flex align-items-center">
                    <span class="fw-light">ระบุรายละเอียด</span>
                    <i class="fas fa-chevron-right ms-2"></i>
                </div>
            </button>
        </div>
        <confirm-modal :reservation="reservation" ref="confirmModal" />
    </div>
</template>
<style scoped>
.btn-next {
    transition: .25s;
}
.btn-next:disabled {
    background: grey;
}
</style>
<script>
import ConfirmModal from './ConfirmModal.vue'

export default {
    components: {
        ConfirmModal
    },
    props: {
        reservation: {
            type: Object,
            required: true
        },
        isValid: {
            type: Boolean,
            required: true
        }
    },
    methods: {
        openConfirmation() {
            this.$refs.confirmModal.toggle()
        }
    }
}
</script>