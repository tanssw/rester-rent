<template>
    <div class="mt-4">
        <h4 class="fw-light">กรุณาเลือกวงดนตรี</h4>
        <div>รายชื่อวงดนตรีที่สามารถขึ้นเล่นได้ในวันที่ {{formattedDate}}</div>
        <div class="mt-4">
            <div @click="showDetail(band)" v-for="(band, index) in bands" :key="index" :class="{'mt-3': index, 'active': checkActive(band)}" class="band-card cursor-pointer d-flex justify-content-between align-items-center rounded-3 p-3">
                <div class="row flex-grow-1">
                    <div class="col-2">
                        <div class="image w-100 rounded-3 ratio ratio-4x3"></div>
                    </div>
                    <div class="col-10">
                        <h4>{{band.name}}</h4>
                        <div class="text-secondary">{{band.type}}</div>
                    </div>
                </div>
                <div>
                    <span v-if="checkActive(band)">
                        <i class="fas fa-check-circle fa-2x text-lighter-emerald"></i>
                    </span>
                    <span v-else>
                        <i class="fas fa-info-circle fa-2x text-secondary"></i>
                    </span>
                </div>
            </div>
        </div>
        <band-modal ref="bandModal" :band="focus" :range="range" @select="selectBand" />
    </div>
</template>
<style scoped>
.band-card {
    border: 1px solid grey;
}
.band-card.active {
    border-color: var(--lighter-emerald);
}
.image {
    background: lightgrey
}
</style>
<script>
import dayjs from 'dayjs'

import BandModal from './BandModal.vue'

import mockedMusics from '@/assets/mock/musics.json'

export default {
    components: {
        BandModal
    },
    props: {
        date: {
            type: String
        },
        selected: {
            type: Object
        },
        range: {
            type: Number
        }
    },
    data() {
        return {
            focus: {},
            bands: mockedMusics
        }
    },
    computed: {
        formattedDate() {
            return this.date ? dayjs(this.date).format('DD MMM YYYY') : ''
        }
    },
    methods: {
        showDetail(band) {
            this.focus = band
            this.$refs.bandModal.toggle()
        },
        checkActive(band) {
            return this.selected.id === band.id
        },
        selectBand(band) {
            this.focus = {}
            this.$emit('select', band)
        }
    }
}
</script>