<template>
    <div id="roomDescModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-body p-5">
                    <h3 class="mb-4">{{food.fName}}</h3>
                    <div class="mb-4">
                        <h5 class="mb-3">รายการอาหาร</h5>
                        <div class="row">
                            <div v-for="(menu, index) in menu" :key="index" class="col-6">
                                <div class="py-2">
                                    <span class="fw-light">— {{ menu }}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mb-5">
                        <h5 class="mb-3">เลือกขนาดที่ต้องการ</h5>
                        <div v-for="(size, index) in food.options" :key="index" class="row align-items-center my-4">
                            <div class="col fw-bold">{{sizeToText(size.size)}}</div>
                            <div class="col">รองรับได้ {{size.capacity}} คน</div>
                            <div class="col">ราคา {{size.price}} บาท</div>
                            <div class="col-1 text-end">
                                <label :for="`size-${food.fName}-${size.id}`">
                                    <span v-if="isChosenSize(size.id)">
                                        <i class="far fa-check-square fa-lg text-emerald"></i>
                                    </span>
                                    <span v-else>
                                        <i class="far fa-square fa-lg text-secondary"></i>
                                    </span>
                                </label>
                                <input v-model="selectedSize" :id="`size-${food.fName}-${size.id}`" name="size" type="radio" :value="size.id" class="d-none">
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end align-items-center">
                        <button @click="confirmSelect()" :disabled="!isSelected" class="btn btn-emerald btn-confirm px-5 py-2">
                            ยืนยัน
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>
.btn-confirm:disabled {
    background-color: grey;
}
</style>
<script>
export default {
    props: {
        food: {
            type: Object
        },
        menu: {
            type: Array
        }
    },
    data() {
        return {
            modal: null,
            selectedSize: null
        }
    },
    computed: {
        isSelected() {
            return !(this.selectedSize === null)
        }
    },
    mounted() {
        const element = document.getElementById('roomDescModal')
        element.addEventListener('hide.bs.modal', () => {this.resetState()})
        this.modal = new bootstrap.Modal(element, {keyboard: false})
    },
    methods: {
        toggle() {
            this.modal.toggle()
        },
        confirmSelect() {
            let food = JSON.parse(JSON.stringify(this.food))
            food.size = food.options.find(size => size.id === this.selectedSize)
            delete food.options
            this.$emit('select', food)
            this.modal.hide()
        },
        resetState() {
            this.selectedSize = null
        },
        sizeToText(size) {
            switch (size.toLowerCase()) {
                case 'small': return "ขนาดเล็ก"
                case 'medium': return "ขนาดกลาง"
                case 'large': return "ขนาดใหญ่"
                case 'extra large': return "ขนาดใหญ่พิเศษ"
            }
        },
        isChosenSize(sizeId) {
            return this.selectedSize === sizeId
        }
    }
}
</script>