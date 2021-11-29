<template>
    <div>
        <calendar is-expanded trim-weeks class="custom-calendar">
            <template v-slot:day-content="{day}">
                <div>
                    <button @click="select(day.id)" class="date h5 fw-light mb-0 p-4 text-center w-100 border-0 bg-white">
                        {{ day.day }}
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
</style>
<script>
import { Calendar } from 'v-calendar'

export default {
    components: {
        Calendar
    },
    methods: {
        select(date) {
            // TODO: Function when date selected
            console.log(date)
        }
    }
}
</script>