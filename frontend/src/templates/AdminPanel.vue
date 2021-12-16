<template>
    <div class="container-fluid">
        <div class="row flex-nowrap main-content">
            <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
                <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100 sticky-top">
                    <div class="d-flex align-items-center pt-3 mb-md-0 me-md-auto text-white text-decoration-none">
                        <div class="d-none d-sm-inline">
                            <h4 class="mb-0">Rester Rent</h4>
                            <div class="fw-light">Management</div>
                        </div>
                    </div>
                    <div class="line mx-1 rounded-pill my-3" ></div>
                    <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                        <li @click="goTo(nav.pathName)" v-for="(nav, index) in navigations" :key="index" class="d-flex align-items-center my-2 cursor-pointer">
                            <div class="icon-box">
                                <i :class="nav.icon"></i>
                            </div>
                            <span class="ms-3 d-none d-sm-inline fw-light">{{nav.title}}</span>
                        </li>
                    </ul>
                    <hr>
                </div>
            </div>
            <div class="col py-3">
                <router-view/>
            </div>
        </div>
    </div>
</template>
<style scoped>
.icon-box {
    width: 1.5em !important;
    overflow: hidden;
}
.line {
    width: 100%;
    height: 0.4vh;
    background-color: gainsboro;
}
.main-content {
    background-color: white;
}
</style>
<script>
export default {
    data() {
        return {
            navigations: [
                {
                    title: 'Dashboard',
                    pathName: 'dashboard',
                    icon: 'fas fa-tachometer-alt'
                },
                {
                    title: 'Orders',
                    pathName: 'order',
                    icon: 'far fa-calendar-check'
                },
                {
                    title: 'Payment',
                    pathName: 'payment',
                    icon: 'fas fa-money-check-alt'
                },
                {
                    title: 'Theme',
                    pathName: 'theme',
                    icon: 'fas fa-money-check-alt'
                },
            ]
        }
    },
    methods: {
        goTo(pathName) {
            this.$router.push({name: pathName})
        }
    }
}
</script>