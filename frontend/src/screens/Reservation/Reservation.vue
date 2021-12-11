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
            <detail-navigator v-model:step="specStep" :info="spec" />
            <div>
                <theme-selection v-if="specStep === 0" v-model:selected="spec.theme" />
                <music-selection v-if="specStep === 1" v-model:selectedType="spec.music.type" v-model:selectedBand="spec.music.band" :date="reservation.date" />
                <food-selection v-if="specStep === 2" v-model:selected="spec.food" />
            </div>
            <detail-bottom-navigator v-model:step="specStep" :detail="spec" />
        </div>
    </div>
</template>
<script>
import SectionNavigator from './components/SectionNavigator.vue'
import DetailNavigator from './SpecifyDetail/DetailNavigator.vue'
import DetailBottomNavigator from './SpecifyDetail/DetailBottomNavigator.vue'

import ReserveCalendar from './SelectDate/ReserveCalendar.vue'
import SelectRoom from './SelectDate/SelectRoom.vue'
import SelectTime from './SelectDate/SelectTime.vue'
import ConfirmSelection from './SelectDate/ConfirmSelection.vue'

import ThemeSelection from './SpecifyDetail/Theme/ThemeSelection.vue'
import MusicSelection from './SpecifyDetail/Music/MusicSelection.vue'
import FoodSelection from './SpecifyDetail/Food/FoodSelection.vue'

export default {
    components: {
        SectionNavigator,
        // 1st Section's Components
        ReserveCalendar,
        SelectRoom,
        SelectTime,
        ConfirmSelection,
        // 2nd Section's Components
        DetailNavigator,
        DetailBottomNavigator,
        ThemeSelection,
        MusicSelection,
        FoodSelection,
    },
    data() {
        return {
            step: 1,
            specStep: 0,
            reservation: {
                date: null,
                room: {},
                startAt: null,
                endAt: null
            },
            spec: {
                theme: null,
                music: {
                    type: 'audio',
                    band: {}
                },
                food: {}
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