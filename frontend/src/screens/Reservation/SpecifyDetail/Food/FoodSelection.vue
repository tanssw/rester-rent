<template>
    <div class="mb-5">
        <div class="row">
            <div v-for="(food, index) in foods" :key="index" class="col-4">
                <div @click="viewDetail(food)" :class="{'active': checkSelected(food.fName)}" class="food-card rounded-3 cursor-pointer p-4">
                    <div class="d-flex align-items-center justify-content-between">
                        <div class="row flex-grow-1">
                            <h5 :class="{'text-emerald': checkSelected(food.fName)}"  class="fw-light mb-0">{{food.fName}}</h5>
                        </div>
                        <span v-if="checkSelected(food.fName)">
                            <i class="fas fa-check fa-lg text-emerald"></i>
                        </span>
                        <span v-else>
                            <i class="fas fa-list fa-lg text-secondary"></i>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <food-modal ref="foodModal" :menu="focusItem" :food="focus" @select="selectFood" />
    </div>
</template>
<style scoped>
.food-card {
    border: 1px solid lightgrey;
}
.food-card.active {
    border-color: var(--lighter-emerald);
}
.image {
    background: lightgrey;
}
</style>
<script>
import FoodModal from './FoodModal.vue'

import mockedFoods from '@/assets/mock/foods.json'

import axios from 'axios'

export default {
    components: {
        FoodModal
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
            focusItem: [],
            foods: []
        }
    },
    methods: {
        checkSelected(name) {
            return this.selected.fName === name
        },
        viewDetail(food) {
            this.focus = food
            let strMenu = food.menus
            let arrayMenu = JSON.parse(strMenu)
            this.focusItem = arrayMenu
            this.$refs.foodModal.toggle()
        },
        selectFood(food) {
            this.focus = {}
            this.focusItem = []
            this.$emit('update:selected', food)
        },
        compareName(a, b) {
            if ( a.fName < b.fName ){
                return -1;
            }
            if ( a.fName > b.fName ){
                return 1;
            }
            return 0;
        },
        async requestFood() {
            // Get Foods from backend
            const path = `${process.env.VUE_APP_API_TARGET}/getFood`
            const result = await axios.get(path)
            const foods = result.data
            return foods
        }
    },
    async created() {
        this.foods = await this.requestFood()
        this.foods.sort(this.compareName)
    }
}
</script>