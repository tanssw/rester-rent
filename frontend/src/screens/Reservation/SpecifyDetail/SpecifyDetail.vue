<template>
    <div>
        <div class="row g-5 align-items-center">
            <div v-for="(theme, index) in themes" :key="index" class="col-3 text-center">
                <div class="d-flex flex-column align-items-center">
                    <div class="image rounded-circle"></div>
                    <h5 class="fw-light mt-4 mb-0">{{theme.title}}</h5>
                </div>
            </div>
        </div>
    </div>
</template>
<style scoped>
.image {
    width: 8rem;
    height: 8rem;
    background: #ddd;
}
</style>
<script>
import mockedThemes from '@/assets/mock/themes.json'
export default {
    data() {
        return {
            themes: mockedThemes
        }
    }
}
</script>