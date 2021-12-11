<template>
    <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100 sticky-top">
                <a href="/" class="d-flex align-items-center pt-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <span class="fs-5 d-none d-sm-inline">ADMIN</span>
                </a>
                <div class="liness mx-1 rounded-pill my-3" ></div>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                    <li>
                        <a href="#" data-bs-toggle="collapse" class="nav-link px-3 align-middle" v-on:click = "changeSec('home')">
                            <i class="fas fa-tachometer-alt"></i> <span class="ms-1 d-none d-sm-inline">Dashboard</span> 
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link px-3 align-middle" v-on:click = "changeSec('order')">
                            <i class="far fa-calendar-check"></i> <span class="ms-1 d-none d-sm-inline">Orders</span>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="nav-link px-3 align-middle" v-on:click = "changeSec('payment')">
                            <i class="fas fa-money-check-alt"></i><span class="ms-1 d-none d-sm-inline"> Payment</span>
                        </a>
                    </li>
                </ul>
                <hr>
            </div>
    </div>
</template>

<script>
export default {
    props: {
        section: {
            type: String,
            required: true
        }
    },
    methods: {
        changeSec(sec){
            // console.log(sec)
            this.$emit("change", sec);
        }
    }
}
</script>

<style>

</style>