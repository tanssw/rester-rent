<template>
    <div class="container-fluid">
        <div class="row flex-nowrap main-content">
        <SIDEBAR/>
        <div class="col py-3">
            <router-view/>
        </div>
        </div>
    </div>
</template>

<style scoped>
    .liness {
        width: 100%;
        height: 0.4vh;
        background-color: gainsboro;
    }
    .main-content {
        background-color: white;
    }
</style>

<script>
import SIDEBAR from "../screens/Admin/component/Sidebar.vue"
export default {
    components: {
        SIDEBAR
    }
}
</script>