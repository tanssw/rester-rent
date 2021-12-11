<template>
    <header>
        
    </header>
    <div class="container-fluid">
        <div class="row flex-nowrap main-content">
        <SIDEBAR :section ="section" @change= "changeSec" />
        <div class="col py-3">
            <ORDER v-if= "section == 'order'"/>
            <PAYMENT v-if= "section == 'payment'"/>
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
import PAYMENT from "./component/Payment.vue"
import ORDER from "./component/Order.vue"
import SIDEBAR from "./component/Sidebar.vue"
export default {
    components: {
        PAYMENT, ORDER, SIDEBAR
    },
    data() {
        return {
            section: "order"
        }
    },
    methods: {
        changeSec(sec){
            this.section = sec
        }
    }

}
</script>