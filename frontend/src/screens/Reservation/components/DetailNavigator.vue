<template>
    <div class="d-flex align-items-center justify-content-center my-5">
        <div v-for="(section, index) in sections" :key="index" class="d-flex align-items-center">
            <div v-if="index" class="line"></div>
            <div :class="{'active': section.active}" class="section-bullet text-center rounded-3 h6 mb-0 p-3">{{section.title}}</div>
        </div>
    </div>
</template>
<style scoped>
.line {
    width: 6rem;
    height: 1px;
    background-color: #aaa;
}
.section-bullet {
    min-width: 8rem;
    border: 1px solid #aaa;
    color: #888;
    cursor: pointer;
}
.section-bullet.active {
    border-color: var(--salmon);
    color: var(--salmon);
}
</style>
<script>
export default {
    data() {
        return {
            sections: [
                {title: 'Theme', active: true},
                {title: 'Music', active: false},
                {title: 'Food', active: false},
            ]
        }
    }
}
</script>