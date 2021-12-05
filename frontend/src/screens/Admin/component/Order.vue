<template>
    <div class="order p-5 rounded shadow">
        <h4>Orders</h4>
        <h6><i class="fas fa-calendar-alt"></i>&nbsp;in last 30 days revenue</h6>
        <table class="table is-fullwidth mt-3">
            <thead>
            <tr>
                <th scope="col" width="10%">Order#</th>
                <th scope="col" width="15%">Content</th>
                <th scope="col" width="15%">Status</th>
                <th scope="col" width="15%">Income</th>
                <th scope="col" width="20%">View Details</th>
                <th scope="col" width="15%">Actions</th>
            </tr>
            </thead>
            <tbody>
                <template v-for= "order in Orders" :key= "order.id">
                    <tr>
                    <th scope="row">{{ order.id }}</th>
                    <td>{{ order.content }}</td>
                    <td>
                        <span class="badge rounded-pill" :class= "order.status">
                            <span class="dot"/>
                            {{ order.status}}
                        </span>
                    </td>
                    <td>{{"$"+ order.income.toFixed(2).toString() }}</td>
                    <td>
                        <button type="button" class="btn btn-primary btn-sm px-4 rounded-pill"
                             data-bs-toggle = "modal" data-bs-target = "#myModal"
                        >
                            View Details
                        </button>
                    </td>
                    <td class="d-grid gap-2 d-md-flex">
                        <button type="button" class="btn btn-success btn-sm px-3 rounded-pill">
                            <i class="fas fa-check-circle"></i>
                        </button>
                        <button type="button" class="btn btn-danger btn-sm px-3 rounded-pill">
                            <i class="fas fa-times-circle"></i>
                        </button>
                    </td>
                    </tr>
                </template>
            </tbody>
        </table>
    </div>
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <span>detail Orders</span>
                </div>
            </div>
        </div>
    </div>
</template>


<style src="../statusOrder.css"></style>
<style>
    .order {
        height: auto;
        width: 75vw;
    }

    /* h6, h4 , th, td{
        color: azure;
    } */

    tbody {
        overflow: auto;
    }
</style>

<script>
import Order from "../dummy_data/Orders.js"
export default {
    data() {
        return {
            Orders: Order,
            modalDetail: [],
            modal: null
        }
    },
    methods: {
        showModal(detailData){
            this.modalDetail = detailData;
            //show modal ยังไงวะ
            console.log("aaa");
            this.modal.toggle();
        }
    },
    mounted() {
        this.modal = new bootstrap.Modal(document.getElementById("myModal"), {keyboard: false})
    }

}
</script>