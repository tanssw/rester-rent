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
                <music-selection v-if="specStep === 1" v-model:selectedType="spec.music.type" v-model:selectedBand="spec.music.band" :date="reservation.date" :range="reserveTimeRange" />
                <food-selection v-if="specStep === 2" v-model:selected="spec.food" />
            </div>
            <detail-bottom-navigator v-model:step="specStep" :detail="spec" @confirm="nextStep" />
        </div>
        <div v-else-if="step === 2">
            <reserve-summary :reservation="reservation" :spec="spec" />
        </div>
    </div>
</template>
<script>
import dayjs from 'dayjs'

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

import ReserveSummary from './Summary/Summary.vue'

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
        // 3rd Section's Components
        ReserveSummary
    },
    data() {
        return {
            step: 0,
            specStep: 0,
            reservation: {
                date: null,
                room: {},
                startAt: null,
                endAt: null
            },
            spec: {
                theme: {},
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
        },
        reserveTimeRange() {
            return this.reservation.endAt - this.reservation.startAt
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