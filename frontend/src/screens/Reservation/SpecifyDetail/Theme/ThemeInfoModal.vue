<template>
    <div id="themeInfoModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-body p-5">
                    <div class="row mb-3">
                        <div class="col-8">
                            <h3>{{theme.title}}</h3>
                            <div>{{theme.description}}</div>
                        </div>
                        <div class="col-4">
                            <div class="image ratio ratio-4x3 rounded-3"></div>
                        </div>
                    </div>
                    <div class="mb-5">
                        <h4 class="mb-3">รายการของประกอบฉาก</h4>
                        <div class="row">
                            <div v-for="(item, index) in theme.items" :key="index" class="col-6">
                                <div class="row">
                                    <div class="col-3">
                                        <div class="image ratio ratio-1x1 rounded-3"></div>
                                    </div>
                                    <div class="col-9">
                                        <h6 class="mb-0">{{item.title}}</h6>
                                        <span>x{{item.quantity}}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end align-items-center">
                        <h4 class="fw-light me-4 mb-0">
                            {{theme.price}}
                            <span class="small">บาท</span>
                        </h4>
                        <button @click="confirmSelect" class="btn btn-emerald px-5 py-2">เลือก</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>
.image {
    background: #ddd;
}
</style>
<script>
export default {
    props: {
        theme: {
            type: Object
        }
    },
    data() {
        return {
            modal: null
        }
    },
    mounted() {
        const element = document.getElementById('themeInfoModal')
        this.modal = new bootstrap.Modal(element, {keyboard: false})
    },
    methods: {
        toggle() {
            this.modal.toggle()
        },
        confirmSelect() {
            this.$emit('confirm')
            this.modal.hide()
        }
    }
}
</script>