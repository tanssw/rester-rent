<template>
    <div class="container-fluid">
        <div class="row flex-nowrap main-content">
        <SIDEBAR/>
        <div class="col py-3">
            
        </div>
        </div>
    </div>
</template>

<style>
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
import SIDEBAR from "./component/Sidebar.vue"
export default {
    components: {
        SIDEBAR
    }
}
</script>