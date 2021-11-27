<template>
    <div class="container-fluid background h-100 d-flex justify-content-center align-items-center">
        <div class="container bg-white rounded-3 shadow-lg p-5">
            <router-view />
        </div>
    </div>
</template>
<style scoped>
.background {
    background: var(--emerald);
}
</style>