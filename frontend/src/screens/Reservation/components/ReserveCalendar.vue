<template>
    <div>
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h4 v-if="selected" class="mb-0">
                <span class="text-secondary fw-light">Selected Date:&nbsp;</span>
                <span class="text-emerald">{{selected}}</span>
            </h4>
            <h4 v-else class="mb-0">Select the date you would like to reserve</h4>
            <button @click="choose()" class="btn btn-emerald d-flex align-items-center">
                <span class="me-2">Next</span>
                <i class="fas fa-chevron-right"></i>
            </button>
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
            this.selected = dayjs(date).format('DD MMMM YYYY')
        },
        choose() {
            if (!this.selected) return
            this.$emit('confirm', this.selected)
        }
    }
}
</script>