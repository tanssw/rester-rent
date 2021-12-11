<template>
    <div>
        Payment
        <template v-for= "payment in Payments" :key= "payment.proof_of_payment">
            <div>{{ payment }}</div>
        </template>
    </div>
</template>

<style>
    .main {
        height: 89vh;
        background-color: var(--emerald);
        opacity: 5%;
    }
</style>

<script>
import Payment from "../dummy_data/Payment.js";
export default {
    data() {
        return {
            Payments: Payment
        }
    }
}
</script>