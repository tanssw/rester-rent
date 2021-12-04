<template>
    <div class="mb-5">
        <h4 class="fw-light mb-4">ระบุช่วงเวลาที่ต้องการจอง</h4>
        <div class="d-flex align-items-center justify-content-center">
            <select v-model="selected.startAt" @change="selectStart()" class="form-select p-3 fw-light">
                <option :value="null" disabled>เวลาเริ่มต้น</option>
                <option :value="time.value" v-for="(time, index) in filteredStartOptions" :key="index">{{time.display}}</option>
            </select>
            <i class="fas fa-long-arrow-alt-right fa-3x mx-5 text-secondary"></i>
            <select v-model="selected.endAt" @change="selectEnd()" class="form-select p-3 fw-light">
                <option :value="null" disabled>เวลาสิ้นสุด</option>
                <option :value="time.value" v-for="(time, index) in filteredEndOptions" :key="index">{{time.display}}</option>
            </select>
        </div>
    </div>
</template>
<style scoped>
option:hover {
    background: var(--emerald)
}
</style>
<script>
export default {
    props: {
        startAt: {
            type: String,
            required: true
        },
        endAt: {
            type: String,
            required: true
        }
    },
    emits: ['update:startAt', 'update:endAt'],
    data() {
        return {
            selected: {
                startAt: null,
                endAt: null
            },
            option: {
                startAt: [],
                endAt: []
            }
        }
    },
    computed: {
        filteredStartOptions() {
            if (!this.selected.endAt) return this.option.startAt
            return this.option.startAt.filter(time => time.value < this.selected.endAt)
        },
        filteredEndOptions() {
            if (!this.selected.startAt) return this.option.endAt
            return this.option.endAt.filter(time => time.value > this.selected.startAt)
        },
    },
    created() {
        // Create list of time in HH:mm format from 06:00 - 24:00
        const START_HOUR = 6
        const END_HOUR = 24
        let runner = START_HOUR
        while (runner <= END_HOUR) {
            let hour = runner < 10 ? `0${runner}:00` : runner === 24 ? `00:00` : `${runner}:00`
            this.option.startAt.push({value: runner, display: hour})
            this.option.endAt.push({value: runner, display: hour})
            runner++
        }
    },
    methods: {
        selectStart() {
            this.$emit('update:startAt', this.selected.startAt)
        },
        selectEnd() {
            this.$emit('update:endAt', this.selected.endAt)
        }
    }
}
</script>