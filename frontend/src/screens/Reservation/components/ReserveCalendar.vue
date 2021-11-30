<template>
    <div>
        <div class="d-flex justify-content-between align-items-centerr mb-4">
            <h3 class="mb-0">
                <span class="text-secondary fw-light">Selected Date:&nbsp;</span>
                <span class="text-emerald">{{selected}}</span>
            </h3>
            <button class="btn btn-primary">Select</button>
        </div>
        <calendar is-expanded trim-weeks class="custom-calendar">
            <template v-slot:day-content="{day}">
                <div>
                    <button @click="select(day.id)" class="date h5 fw-light mb-0 p-4 text-center w-100 border-0 bg-white">
                        {{day.day}}
                    </button>
                </div>
            </template>
        </calendar>
    </div>
</template>
<style scoped>
.date {
    color: #333;
    transition: .25s;
}
.date:hover {
    color: var(--salmon);
}
.btn-select {

}
</style>
<script>
import dayjs from 'dayjs'

import { Calendar } from 'v-calendar'

export default {
    components: {
        Calendar
    },
    data() {
        return {
            selected: null
        }
    },
    methods: {
        select(date) {
            // TODO: Function when date selected
            this.selected = dayjs(date).format('DD MMMM YYYY')
        }
    }
}
</script>