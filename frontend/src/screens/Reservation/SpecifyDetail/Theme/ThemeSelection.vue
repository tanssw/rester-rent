<template>
    <div>
        <div class="row g-5 align-items-center mb-5">
            <div v-for="(theme, index) in themes" :key="index" class="col-3 text-center">
                <div class="d-flex justify-content-center">
                    <div @click="openModal(theme)" :class="{'active': checkSelected(theme)}" class="theme-card">
                        <div class="image rounded-circle mx-auto"></div>
                        <h5 class="fw-light py-1 rounded-3 mt-4 mb-0">{{theme.title}}</h5>
                    </div>
                </div>
            </div>
        </div>
        <theme-info-modal ref="themeInfoModal" :theme="focus" @confirm="selectTheme" />
    </div>
</template>
<style scoped>
.theme-card {
    cursor: pointer;
    transition: .25s;
}
.theme-card > h5 {
    border: 1px solid white;
    transition: .125s
}
.theme-card:not(.active):hover > h5 {
    color: var(--emerald)
}
.theme-card.active > h5 {
    border-color: var(--lighter-emerald);
    color: var(--lighter-emerald);
}
.image {
    width: 8rem;
    height: 8rem;
    background: #ddd;
}
</style>
<script>
import mockedThemes from '@/assets/mock/themes.json'

import ThemeInfoModal from './ThemeInfoModal.vue'

export default {
    components: {
        ThemeInfoModal
    },
    props: {
        selected: {
            type: Number
        }
    },
    emits: ['update:selected'],
    data() {
        return {
            focus: {},
            themes: mockedThemes
        }
    },
    methods: {
        openModal(theme) {
            this.focus = theme
            this.$refs.themeInfoModal.toggle()
        },
        selectTheme() {
            this.$emit('update:selected', this.focus)
        },
        checkSelected(theme) {
            return this.selected.id === theme.id
        }
    }
}
</script>