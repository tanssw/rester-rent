<template>
    <div class="mb-5">
        <h4 class="fw-light mb-4">ระบุวันที่ต้องการจอง</h4>
        <calendar is-expanded trim-weeks class="custom-calendar">
            <template v-slot:day-content="{day}">
                <div>
                    <button @click="select(day.id)" class="date d-flex justify-content-center h5 mb-0 p-3 w-100 border-0">
                        <div :class="{'active': checkActiveDate(day.id)}" class="day-box rounded-3 d-flex align-items-center justify-content-center">
                            {{day.day}}
                        </div>
                    </button>
                </div>
            </template>
        </calendar>
    </div>
</template>
<style scoped>
.date {
    color: #333;
    transition: .125s;
    background-color: white;
}
.date:hover {
    color: var(--light-emerald);
}
.day-box {
    width: 3rem;
    height: 3rem;
    transition: .125s;
}
.day-box.active {
    background: var(--light-emerald);
    color: white;
}
</style>
<script>
import { Calendar } from 'v-calendar'

export default {
    components: {
        Calendar
    },
    props: {
        selected: {type: String, required: true}
    },
    emits: ['update:selected'],
    methods: {
        select(date) {
            this.$emit('update:selected', date)
        },
        checkActiveDate(date) {
            return date === this.selected
        }
    }
}
</script>