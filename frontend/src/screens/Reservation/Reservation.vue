<template>
    <div>
        <section-navigator v-model:step="step" />
        <div v-if="step === 0">
            <reserve-calendar v-model:selected="reservation.date" />
            <select-room v-model:selected="reservation.room" />
            <select-time v-model:startAt="reservation.startAt" v-model:endAt="reservation.endAt" />
            <confirm-selection :reservation="reservation" :isValid="isValid" @confirm="nextStep" />
        </div>
        <div v-else-if="step === 1">
            <theme-selection v-model:selected="spec.theme" />
        </div>
    </div>
</template>
<script>
import SectionNavigator from './components/SectionNavigator.vue'

import ReserveCalendar from './SelectDate/ReserveCalendar.vue'
import SelectRoom from './SelectDate/SelectRoom.vue'
import SelectTime from './SelectDate/SelectTime.vue'
import ConfirmSelection from './SelectDate/ConfirmSelection.vue'

import ThemeSelection from './SpecifyDetail/ThemeSelection.vue'

export default {
    components: {
        SectionNavigator,
        // 1st Section's Components
        ReserveCalendar,
        SelectRoom,
        SelectTime,
        ConfirmSelection,
        // 2nd Section's Components
        ThemeSelection
    },
    data() {
        return {
            step: 1,
            reservation: {
                date: null,
                room: {},
                startAt: null,
                endAt: null
            },
            spec: {
                theme: null,
                music: null,
                food: null
            }
        }
    },
    computed: {
        isValid() {
            let reserve = this.reservation
            if (!reserve.date) return false
            if (!reserve.startAt) return false
            if (!reserve.endAt) return false
            if (!Object.keys(reserve.room).length) return false
            return true
        }
    },
    methods: {
        nextStep() {
            let nextStep = this.step + 1
            if (![0, 1, 2].includes(nextStep)) return
            this.step = nextStep
        }
    }
}
</script>