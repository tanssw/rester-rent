<template>
    <div id="roomDescModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-body p-5">
                    <div class="row mb-4">
                        <div class="col-4"></div>
                        <div class="col-8">
                            <h4>{{room.title}}</h4>
                            <div>ขนาด: {{room.size}}</div>
                            <div>รองรับได้สูงสุด {{room.maximum}} คน</div>
                        </div>
                    </div>
                    <div class="mb-4">
                        <h5>รายละเอียด</h5>
                        <div>{{room.description}}</div>
                    </div>
                    <div class="d-flex justify-content-end align-items-center">
                        <h4 class="fw-light me-4 mb-0">
                            {{room.price}}
                            <span class="small">บาท/ชั่วโมง</span>
                        </h4>
                        <button @click="confirmSelect" class="btn btn-emerald px-5 py-2">เลือกห้องนี้</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        room: {
            type: Object,
            required: true
        }
    },
    data() {
        return {
            modal: null
        }
    },
    mounted() {
        const element = document.getElementById('roomDescModal')
        this.modal = new bootstrap.Modal(element, {keyboard: false})
    },
    methods: {
        toggle() {
            this.modal.toggle()
        },
        confirmSelect() {
            this.$emit('select')
            this.modal.hide()
        }
    }
}
</script>