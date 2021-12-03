<template>
    <div>
        <section-navigator :step="step" @change="toStep" />
        <div v-if="step === 1" class="section-container">
            <reserve-calendar v-model:selected="date" />
            <select-room />
            <select-time />
        </div>
        <div v-else-if="step === 2">
            <specify-detail />
        </div>
    </div>
</template>
<script>
import SectionNavigator from './components/SectionNavigator.vue'

import ReserveCalendar from './SelectDate/ReserveCalendar.vue'
import SelectRoom from './SelectDate/SelectRoom.vue'
import SelectTime from './SelectDate/SelectTime.vue'

import SpecifyDetail from './SpecifyDetail/SpecifyDetail.vue'

export default {
    components: {
        SectionNavigator,
        ReserveCalendar,
        SelectRoom,
        SelectTime,
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
        },
    }
}
</script>