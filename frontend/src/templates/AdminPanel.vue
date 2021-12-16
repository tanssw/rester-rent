<template>
    <div class="container-fluid">
        <div class="row flex-nowrap main-content">
            <div class="col-auto col-md-3 col-xl-2 p-0 bg-dark text-white">
                <div class="d-flex vh-100 flex-column">
                    <div class="flex-grow-1">
                        <div class="header-box p-3">
                            <div class="d-none d-sm-inline">
                                <h4 class="mb-0">Rester Rent</h4>
                                <div class="fw-light">Management</div>
                            </div>
                        </div>
                        <ul class="p-3" id="menu">
                            <li @click="goTo(nav.pathName)" v-for="(nav, index) in navigations" :key="index" :class="{'mt-3': index}" class="d-flex align-items-center cursor-pointer">
                                <div class="icon-box">
                                    <i :class="nav.icon"></i>
                                </div>
                                <span class="ms-3 d-none d-sm-inline fw-light">{{nav.title}}</span>
                            </li>
                        </ul>
                    </div>
                    <div class="p-3">
                        <button class="btn btn-outline-danger w-100">Sign Out</button>
                    </div>
                </div>
            </div>
            <div class="body-content col">
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
    height: 1px;
    background-color: gainsboro;
}
.main-content {
    height: 100vh;
    background-color: white;
    overflow: hidden;
}
.header-box {
    border-bottom: 1px solid grey;
}
.body-content {
    overflow-x: hidden;
    overflow-y: scroll;
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