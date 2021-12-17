<template>
    <div>
        <div class="row g-5 align-items-center mb-5">
            <div v-for="(theme, index) in themes" :key="index" class="col-3 text-center">
                <div class="d-flex justify-content-center">
                    <div @click="openModal(theme)" :class="{'active': checkSelected(theme)}" class="theme-card">
                        <img :src="theme.image" class="image rounded-circle mx-auto"/>
                        <h5 class="fw-light py-1 rounded-3 mt-4 mb-0">{{theme.tname}}</h5>
                    </div>
                </div>
            </div>
        </div>
        <theme-info-modal ref="themeInfoModal" :accessory="focusItem" :theme="focus" @confirm="selectTheme" />
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
import ThemeInfoModal from './ThemeInfoModal.vue'

import axios from 'axios'

export default {
    components: {
        ThemeInfoModal
    },
    props: {
        selected: {
            type: Object
        }
    },
    emits: ['update:selected'],
    data() {
        return {
            focus: {},
            themes: [],
            accessories: [],
            focusItem: [],
        }
    },
    methods: {
        getItem(themeId) {
            let accessory = this.accessories
            let matchAccessory = accessory.filter(item => {
                if(themeId == item.id) return item
            })
            return matchAccessory[0].accessories
        },
        openModal(theme) {
            this.focus = theme
            this.focusItem = this.getItem(theme.id)
            this.$refs.themeInfoModal.toggle()
        },
        selectTheme() {
            this.$emit('update:selected', this.focus)
        },
        checkSelected(theme) {
            return this.selected.id === theme.id
        },
        async requestTheme() {
            // Get Theme from backend
            const path = `${process.env.VUE_APP_API_TARGET}/getTheme`
            const result = await axios.get(path)
            const themes = result.data
            return themes
        },
        async requestAccessory() {
            // Get Accessory from backend
            const path = `${process.env.VUE_APP_API_TARGET}/getThemeAcc`
            const result = await axios.get(path)
            const accessories = result.data
            return accessories
        }
    },
    async created() {
        this.themes = await this.requestTheme()
        this.accessories = await this.requestAccessory()
        
    }
}
</script>