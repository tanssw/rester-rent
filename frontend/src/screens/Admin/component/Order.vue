<template>
    <div class="order p-5 rounded shadow">
        <h4>Orders</h4>
        <h6><i class="fas fa-calendar-alt"></i>&nbsp;in last 30 days revenue</h6>
        <div class="table-responsive my-3 box-table">
        <table class="table is-fullwidth table-fixed">
            <thead class="table-light">
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
                <template v-for= "order in Orders.slice(page * 5 - 5,page * 5)" :key= "order.id">
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
        <div class="d-flex justify-content-between">
            <div>
                {{"Showing "+ ((page != 1) ? (page*5)-4 : "1") +" to "+ ((page*5 <= Orders.length) ? page*5 : Orders.length) +" of "+ Orders.length +" entries"}}
            </div>
            <div class="btn-group px-1" role="group">
                <button type="button" class="btn btn-outline-secondary" :class= "page == 1 ? 'disabled': ''"
                    @click= "page--"
                >
                    Prev
                </button>
                <button type="button" class="btn" :class= "page%2 == 1 ? 'btn-primary disabled':'btn-outline-secondary'"
                    @click= "pageSelect(0)"
                >
                    {{ page%2 == 1 ? page : page-1 }}
                </button>
                <button type="button" class="btn" :class= "page%2 == 0 ? 'btn-primary disabled':'btn-outline-secondary'"
                    @click= "pageSelect(1)" >
                    {{ page%2 == 0 ? page : page+1 }}
                </button>
                <button type="button" class="btn btn-outline-secondary" :class= "page*5 >= Orders.length ? 'disabled': ''"
                    @click= "page++">
                    Next
                </button>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class=""></div>
        </div>
    </div>
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-body">
                    <h4>Detail Orders</h4>
                    <span>
                        Theme, Music, Food
                    </span>
                </div>
            </div>
        </div>
    </div>
</template>


<style src="../statusOrder.css"></style>
<style>
    .order {
        width: 75vw;
    }

    .box-table {
        height: 32vh;
    }

</style>

<script>
import Order from "../dummy_data/Orders.js"
export default {
    data() {
        return {
            Orders: Order,
            modalDetail: [],
            modal: null,
            page: 1
        }
    },
    methods: {
        showModal(detailData){
            this.modalDetail = detailData;
            this.modal.toggle();
        },
        pageSelect(num) {
            if (!num) {
                this.page--
            }
            else if (num && (this.page+1)*5 < this.Orders.length){
                this.page++
            }
        }
    },
    mounted() {
        this.modal = new bootstrap.Modal(document.getElementById("myModal"), {keyboard: false})
    }

}
</script>