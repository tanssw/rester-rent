<template>
    <div class="d-flex justify-content-center align-items-center mb-5">
        <div class="flex-shrink-1 flex-md-grow-1"></div>
        <div v-for="(section, index) in sections" :key="index" :class="{active: section.active}" class="section flex-grow-1 flex-md-shrink-1 text-center mx-2">
            <div class="section-text text-secondary text-capitalize small mb-2 mx-3 d-none d-md-block">{{section.title}}</div>
            <div class="section-indicator p-1 rounded-pill"></div>
        </div>
        <div class="flex-shrink-1 flex-md-grow-1"></div>
    </div>
</template>
<style scoped>
@media only screen and (max-width: 768px) {
    .section-indicator {
        width: 100%;
        background: lightgrey;
    }
}
@media only screen and (min-width: 768px) {
    .section-indicator {
        min-width: 8rem;
        background: lightgrey;
    }
}
.section.active:nth-child(2) > .section-indicator {
    background: var(--lighter-salmon);
}
.section.active:nth-child(3) > .section-indicator {
    background: var(--light-salmon);
}
.section.active:nth-child(4) > .section-indicator {
    background: var(--salmon);
}
</style>
<script>
export default {
    data() {
        return {
            sections: [
                {title: 'Select Date', active: true},
                {title: 'Specify Details', active: false},
                {title: 'Verify Reservation', active: false},
            ]
        }
    }
}
</script>