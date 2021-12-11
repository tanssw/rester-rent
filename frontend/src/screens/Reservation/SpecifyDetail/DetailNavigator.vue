<template>
    <div class="d-flex align-items-center justify-content-center my-5">
        <div v-for="(section, index) in sections" :key="index" class="d-flex align-items-center">
            <div v-if="index" class="line"></div>
            <div @click="go(index)" :class="{'active': section.active, 'current': isCurrentStep(index)}" class="section-bullet text-center rounded-3 h6 mb-0 p-3">
                {{section.title}}
            </div>
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
.section-bullet.active, .section-bullet.current {
    border-color: var(--dark-salmon);
    color: var(--dark-salmon);
}
.section-bullet.current {
    border-bottom-width: 4px;
}
</style>
<script>
export default {
    props: {
        step: {
            type: Number
        },
        info: {
            type: Object
        }
    },
    emits: ['update:step'],
    watch: {
        // Check active on every step changed.
        step(newStep) {
            this.checkStep(newStep)
        },
        // Check active on every information changed.
        info: {
            handler() {
                this.checkStep(this.step)
            },
            deep: true
        }
    },
    data() {
        return {
            sections: [
                {title: 'Theme', key: 'theme', active: false},
                {title: 'Music', key: 'music', active: false},
                {title: 'Food', key: 'food', active: false},
            ]
        }
    },
    created() {
        this.checkStep(this.step)
    },
    methods: {
        checkStep(step) {
            let isValidStep = this.validateStep(step)
            if (!isValidStep) return

            let currentKey = this.sections[step].key
            let isObject = typeof this.info[currentKey] === 'object'
            if (this.info[currentKey] === null) return
            if (isObject && !Object.keys(this.info[currentKey]).length) return

            this.sections[step].active = true
        },
        isCurrentStep(step) {
            return step === this.step
        },
        validateStep(step) {
            // If step is more than length of sections
            if (step >= this.sections.length) return false
            // If step is less than first index (0)
            if (step < 0) return false

            return true
        },
        go(step) {
            this.$emit('update:step', step)
        }
    }
}
</script>