<template>
    <div id="successModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body p-5">
                    <div class="d-flex align-items-center justify-content-center">
                        <i class="far fa-calendar-check fa-5x text-emerald"></i>
                        <div class="ms-4">
                            <h4 class="text-emerald">ดำเนินการเสร็จสิ้น</h4>
                            <span>ทางร้านจะติดต่อกลับทางอีเมลของท่านในไม่ช้า</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    mounted() {
        const element = document.getElementById('successModal')
        this.modal = new bootstrap.Modal(element, {keyboard: false})
    },
    methods: {
        tempShow() {
            this.modal.show()
            setTimeout(() => {this.modal.hide()}, 2000)
        }
    }
}
</script>