<template>
    <div class="mb-5">
        <div class="row gx-5">
            <div class="col-4">
                <div @click="choose(key)" v-for="(option, key, index) in options" :key="key" :class="{'mt-3': index, 'active': checkActive(key)}" class="option cursor-pointer d-flex justify-content-between align-items-center p-3 border rounded-3">
                    <span>{{option.title}}</span>
                    <span v-if="checkActive(key)">
                        <i class="fas fa-check-circle fa-lg text-lighter-emerald"></i>
                    </span>
                </div>
            </div>
            <div class="col-8">
                <h3 class="text-capitalize mb-3">{{options[selectedType].title}}</h3>
                <audio-detail v-if="selectedType === 'audio'" />
                <band-detail v-else-if="selectedType === 'band'" :selected="selectedBand" :date="date" @select="selectBand" />
            </div>
        </div>
    </div>
</template>
<style scoped>
.option {
    transition: .125s;
}
.option.active {
    border-color: var(--lighter-emerald) !important;
}
</style>
<script>
import AudioDetail from './AudioDetail.vue'
import BandDetail from './BandDetail.vue'

export default {
    components: {
        AudioDetail,
        BandDetail
    },
    props: {
        selectedType: {
            type: String
        },
        selectedBand: {
            type: Object
        },
        date: {
            type: String
        }
    },
    emits: ['update:selectedType', 'update:selectedBand'],
    data() {
        return {
            options: {
                audio: {title: 'Audio Set'},
                band: {title: 'Live Band'}
            }
        }
    },
    methods: {
        checkActive(id) {
            return this.selectedType === id
        },
        choose(id) {
            this.$emit('update:selectedType', id)
        },
        selectBand(band) {
            this.$emit('update:selectedBand', band)
        }
    }
}
</script>