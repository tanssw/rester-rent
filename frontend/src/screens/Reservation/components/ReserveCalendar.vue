<template>
    <div>
        <calendar is-expanded class="custom-calendar">
            <template v-slot:day-content="{day}">
                <div>
                    <div class="p-4 text-center">{{ day.day }}</div>
                </div>
            </template>
        </calendar>
    </div>
</template>
<style scoped>
.vc-header {
    padding: 16px !important
}
</style>
<script>
import { Calendar } from 'v-calendar'

export default {
    components: {
        Calendar
    }
}
</script>