<template>
    <div id="confirmationModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-body p-5">
                    TODO: Display overall information for date selection
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    data() {
        return {
            modal: null
        }
    },
    mounted() {
        const element = document.getElementById('confirmationModal')
        this.modal = new bootstrap.Modal(element, {keyboard: false})
    },
    methods: {
        toggle() {
            this.modal.toggle()
        },
        confirm() {
            this.modal.hide()
        }
    }
}
</script>