<template>
    <div class="mb-5">
        <h4 class="fw-light mb-4">ระบุช่วงเวลาที่ต้องการจอง</h4>
        <div class="d-flex align-items-center justify-content-center">
            <select class="form-select p-3 fw-light">
                <option :value="time" v-for="(time, index) in option.startAt" :key="index">{{time}}</option>
            </select>
            <i class="fas fa-long-arrow-alt-right fa-3x mx-5 text-secondary"></i>
            <select class="form-select p-3 fw-light">
                <option :value="time" v-for="(time, index) in option.endAt" :key="index">{{time}}</option>
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
    data() {
        return {
            option: {
                startAt: [],
                endAt: []
            }
        }
    },
    created() {
        const START_HOUR = 6
        const END_HOUR = 24

        let runner = START_HOUR
        while (runner <= END_HOUR) {
            let hour = runner.length < 2 ? `0${runner}:00` : `${runner}:00`
            this.option.startAt.push(hour)
            this.option.endAt.push(hour)
            runner++
        }
    }
}
</script>