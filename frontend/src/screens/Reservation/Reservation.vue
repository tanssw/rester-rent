<template>
    <div>
        <section-navigator />
        <reserve-calendar />
    </div>
</template>
<script>
import SectionNavigator from './components/SectionNavigator.vue'
import ReserveCalendar from './components/ReserveCalendar.vue'

export default {
    components: {
        SectionNavigator,
        ReserveCalendar
    }
}
</script>