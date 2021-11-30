<template>
    <div>
        <section-navigator :step="step" @change="toStep" />
        <reserve-calendar v-if="step === 1" @next="nextStep" />
        <specify-detail v-else-if="step === 2" />
    </div>
</template>
<script>
import SectionNavigator from './components/SectionNavigator.vue'
import ReserveCalendar from './components/ReserveCalendar.vue'
import SpecifyDetail from './components/SpecifyDetail.vue'

export default {
    components: {
        SectionNavigator,
        ReserveCalendar,
        SpecifyDetail
    },
    data() {
        return {
            step: 1,
            date: null
        }
    },
    methods: {
        nextStep() {
            let nextStep = this.step + 1
            if (![1, 2, 3].includes(nextStep)) return
            this.step = nextStep
        },
        toStep(step) {
            this.step = step
        }
    }
}
</script>