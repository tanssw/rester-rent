<template>
    <div class="mb-5">
        <div class="row">
            <div v-for="(food, index) in foods" :key="index" class="col-4">
                <div @click="viewDetail(food)" :class="{'active': checkSelected(food.id)}" class="food-card rounded-3 cursor-pointer p-4">
                    <div class="d-flex align-items-center justify-content-between">
                        <div class="row flex-grow-1">
                            <h5 :class="{'text-emerald': checkSelected(food.id)}"  class="fw-light mb-0">{{food.fname}}</h5>
                        </div>
                        <span v-if="checkSelected(food.id)">
                            <i class="fas fa-check fa-lg text-emerald"></i>
                        </span>
                        <span v-else>
                            <i class="fas fa-list fa-lg text-secondary"></i>
                        </span>
                    </div>
                </div>
            </div>
        </div>
        <food-modal ref="foodModal" :food="focus" @select="selectFood" />
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
            foods: mockedFoods
        }
    },
    methods: {
        checkSelected(id) {
            return this.selected.id === id
        },
        viewDetail(food) {
            this.focus = food
            this.$refs.foodModal.toggle()
        },
        selectFood(food) {
            this.focus = {}
            this.$emit('update:selected', food)
        }
    }
}
</script>