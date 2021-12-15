<template>
    <div class="container-fluid background py-5">
        <div class="container bg-white rounded-3 shadow-lg p-5 my-5">
            <router-view />
        </div>
    </div>
</template>
<style scoped>
.background {
    background: var(--emerald);
    min-height: 100vh;
}
</style>