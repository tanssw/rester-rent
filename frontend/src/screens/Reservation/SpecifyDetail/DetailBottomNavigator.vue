<template>
    <div class="d-flex align-items-center justify-content-between">
        <button @click="prev()" class="btn btn-outline-secondary px-3 py-2" :disabled="isFirstStep">
            <i class="fas fa-chevron-left"></i>
        </button>
        <button v-if="!isLastStep" @click="next()" class="btn btn-outline-secondary px-3 py-2">
            <i class="fas fa-chevron-right"></i>
        </button>
        <button v-else @click="confirm()" class="btn btn-lighter-emerald px-3 py-2" :disabled="isIncompleted">
            ดำเนินการต่อ
        </button>
    </div>
</template>
<script>
export default {
    props: {
        step: {
            type: Number
        },
        detail: {
            type: Object
        }
    },
    emits: ['update:step'],
    data() {
        return {
            steps: [0, 1, 2]
        }
    },
    computed: {
        isFirstStep() {
            return this.step === this.steps[0]
        },
        isLastStep() {
            return this.step === this.steps[this.steps.length - 1]
        },
        isIncompleted() {
            let detail = this.detail
            if (detail.music.type === 'band' && !Object.keys(detail.music.band).length) return true
            return false
        }
    },
    methods: {
        validateStep(step) {
            return this.steps.includes(step)
        },
        prev() {
            let prevStep = this.step - 1
            if (!this.validateStep(prevStep)) return
            this.$emit('update:step', prevStep)
        },
        next() {
            let nextStep = this.step + 1
            if (!this.validateStep(nextStep)) return
            this.$emit('update:step', nextStep)
        },
        confirm() {
            this.$emit('confirm')
        }
    }
}
</script>