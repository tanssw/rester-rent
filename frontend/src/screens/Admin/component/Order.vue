<template>
  <div class="row px-3">
          <div class="col-12 p-5 rounded shadow">
            <h4>Order รอการดำเนินการ</h4>
            <table class="table is-fullwidth table-fixed">
              <thead class="table-light">
                <tr>
                  <th scope="col">Order#</th>
                  <th scope="col">Contact</th>
                  <th scope="col">Total</th>
                  <th scope="col">Details</th>
                  <th scope="col">Actions</th>
                </tr>
              </thead>
              <tbody>
                <template
                  v-for="order in Orders.filter(
                    (x) => x.status == 'รอการดำเนินการ'
                  ).slice(
                    pageOrderWait * perPage - perPage,
                    pageOrderWait * perPage
                  )"
                  :key="order._id"
                >
                  <tr>
                    <th scope="row">{{ order._id }}</th>
                    <td>{{ order.mail }}</td>
                    <td>{{ "$" + order.income.toFixed(2).toString() }}</td>
                    <td>
                      <button
                        type="button"
                        class="btn btn-primary btn-sm px-4 rounded-pill"
                        data-bs-toggle="modal"
                        data-bs-target="#myModal"
                        @click= "showModal(order)"
                      >
                        View Details
                      </button>
                    </td>
                    <td class="d-grid gap-2 d-md-flex">
                      <button
                        type="button"
                        class="btn btn-success btn-sm px-3 rounded"
                        @click="confirmOrder(order)"
                      >
                        <i class="fas fa-check-circle"></i>
                      </button>
                      <button
                        type="button"
                        class="btn btn-danger btn-sm px-3 rounded"
                        @click="rejectOrder(order)"
                      >
                        <i class="fas fa-times-circle"></i>
                      </button>
                    </td>
                  </tr>
                </template>
              </tbody>
            </table>
            <div class="d-flex justify-content-between">
              <div>
                {{
                  "Showing " +
                  (pageOrderWait != 1
                    ? pageOrderWait * perPage - (perPage - 1)
                    : "1") +
                  " to " +
                  (pageOrderWait * perPage <=
                  Orders.filter((x) => x.status == "รอการดำเนินการ").length
                    ? pageOrderWait * perPage
                    : Orders.filter((x) => x.status == "รอการดำเนินการ")
                        .length) +
                  " of " +
                  Orders.filter((x) => x.status == "รอการดำเนินการ").length +
                  " entries"
                }}
              </div>
              <div class="btn-group px-1" role="group">
                <button
                  type="button"
                  class="btn btn-outline-secondary"
                  :class="pageOrderWait == 1 ? 'disabled' : ''"
                  @click="pageOrderWait--"
                >
                  Prev
                </button>
                <button
                  type="button"
                  class="btn"
                  :class="
                    pageOrderWait % 2 == 1
                      ? 'btn-primary disabled'
                      : 'btn-outline-secondary'
                  "
                  @click="pageOrderWaitSelect(0)"
                >
                  {{
                    pageOrderWait % 2 == 1 ? pageOrderWait : pageOrderWait - 1
                  }}
                </button>
                <button
                  type="button"
                  class="btn"
                  :class="
                    pageOrderWait % 2 == 0
                      ? 'btn-primary disabled'
                      : 'btn-outline-secondary'
                  "
                  @click="pageOrderWaitSelect(1)"
                >
                  {{
                    pageOrderWait % 2 == 0 ? pageOrderWait : pageOrderWait + 1
                  }}
                </button>
                <button
                  type="button"
                  class="btn btn-outline-secondary"
                  :class="
                    pageOrderWait * perPage >=
                    Orders.filter((x) => x.status == 'รอการดำเนินการ').length
                      ? 'disabled'
                      : ''
                  "
                  @click="pageOrderWait++"
                >
                  Next
                </button>
              </div>
            </div>
          </div>
  </div>
  <div class="col-12 p-5 rounded shadow">
          <h4>Orders</h4>
          <h6>
            <i class="fas fa-calendar-alt"></i>&nbsp;in last 30 days revenue
          </h6>
          <div class="table-responsive my-2 box-table">
            <table class="table is-fullwidth table-fixed">
              <thead class="table-light">
                <tr>
                  <th scope="col">Order#</th>
                  <th scope="col">Contact</th>
                  <th scope="col" width="20%">Status</th>
                  <th scope="col">Total</th>
                  <th scope="col">Details</th>
                </tr>
              </thead>
              <tbody>
                <template
                  v-for="order in Orders.slice(
                    pageOrder * perPage - perPage,
                    pageOrder * perPage
                  )"
                  :key="order.id"
                >
                  <tr>
                    <th scope="row">{{ order._id }}</th>
                    <td>{{ order.mail }}</td>
                    <td>
                      <span class="badge rounded-pill" :class="order.status">
                        <span class="dot" />
                        {{ order.status }}
                      </span>
                    </td>
                    <td>{{ "$" + order.income.toFixed(2).toString() }}</td>
                    <td>
                      <button
                        type="button"
                        class="btn btn-primary btn-sm px-4 rounded-pill"
                        data-bs-toggle="modal"
                        data-bs-target="#myModal"
                        @click= "showModal(order)"
                      >
                        View Details
                      </button>
                    </td>
                  </tr>
                </template>
              </tbody>
            </table>
          </div>
          <div class="d-flex justify-content-between">
            <div>
              {{
                "Showing " +
                (pageOrder != 1 ? pageOrder * perPage - (perPage - 1) : "1") +
                " to " +
                (pageOrder * perPage <= Orders.length
                  ? pageOrder * perPage
                  : Orders.length) +
                " of " +
                Orders.length +
                " entries"
              }}
            </div>
            <div class="btn-group px-1" role="group">
              <button
                type="button"
                class="btn btn-outline-secondary"
                :class="pageOrder == 1 ? 'disabled' : ''"
                @click="pageOrder--"
              >
                Prev
              </button>
              <button
                type="button"
                class="btn"
                :class="
                  pageOrder % 2 == 1
                    ? 'btn-primary disabled'
                    : 'btn-outline-secondary'
                "
                @click="pageOrderSelect(0)"
              >
                {{ pageOrder % 2 == 1 ? pageOrder : pageOrder - 1 }}
              </button>
              <button
                type="button"
                class="btn"
                :class="
                  pageOrder % 2 == 0
                    ? 'btn-primary disabled'
                    : 'btn-outline-secondary'
                "
                @click="pageOrderSelect(1)"
              >
                {{ pageOrder % 2 == 0 ? pageOrder : pageOrder + 1 }}
              </button>
              <button
                type="button"
                class="btn btn-outline-secondary"
                :class="pageOrder * perPage >= Orders.length ? 'disabled' : ''"
                @click="pageOrder++"
              >
                Next
              </button>
            </div>
          </div>
  </div>
  <div id="myModal" class="modal fade" role="dialog">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-body">
                <h4>Detail Orders</h4>
                <div class="col-12">
                  <div class="row"> 
                    <div class="col-8">
                      <h6>{{ "Customer Name: "+modalDetail.fullname }}</h6>
                    </div>
                    <div class="col-8">
                      <h6>{{ "Price: "+modalDetail.income+"$" }}</h6>
                    </div>
                  </div>
                  <h6>{{ "Start time: "+ modalDetail.start_date }} </h6>
                  <h6>{{ "End time: "+ modalDetail.end_date }}</h6>
                </div>
              </div>
            </div>
          </div>
  </div>
</template>

<style src="../statusOrder.css"></style>
<style scoped>
@media only screen and (max-height: 1200px) {
  .box-table {
    height: 28vh;
  }
}

@media only screen and (max-height: 768px) {
  .box-table {
    height: 36vh;
  }
}
</style>

<script>
import Order from "../dummy_data/Orders.js";
import axios from 'axios';
export default {
  data() {
    return {
      header:{
        headers: {
          token: localStorage.getItem('RR-Token'),
          userId: localStorage.getItem('RR-UID')
        }
      },
      Orders: Order,
      modalDetail: {},
      modal: null,
      pageOrder: 1,
      perPage: 4,
      pageOrderWait: 1,
      dataOrder: null,
    };
  },
  methods: {
    async getOrders(){
      const path = `${process.env.VUE_APP_API_TARGET}/getOrder`;
      const result = await axios.get(path);
      const data = result.data;
      this.Orders = data;
    },
    showModal(order) {
      this.modalDetail = order;
    },
    pageOrderSelect(num) {
      if (!num) {
        this.pageOrder--;
      } else if (num && (this.pageOrder + 1) * 5 < this.Orders.length) {
        this.pageOrder++;
      }
    },
    pageOrderWaitSelect(num) {
      if (!num) {
        this.pageOrderWait--;
      } else if (
        num &&
        (this.pageOrderWait + 1) * 5 <
          this.Orders.filter((x) => x.status == "รอการดำเนินการ").length
      ) {
        this.pageOrderWait++;
      }
    },
    async confirmOrder(order) {
        var data = order;
        data.status = "รอการชำระเงิน";
        try {
            const path = `${process.env.VUE_APP_API_TARGET}/updOrder`;
            const result = await axios.patch(path, data, this.header);
            await this.requestAccessory();
        } catch(error) {
            this.checkUnauthorized(error)
        }
    },
    async rejectOrder(order) {
      var data = order;
        data.status = "ยกเลิกการดำเนินการ";
        try {
            const path = `${process.env.VUE_APP_API_TARGET}/updOrder`;
            const result = await axios.patch(path, data, this.header);
            await this.requestAccessory();
        } catch(error) {
            this.checkUnauthorized(error)
        }
    },
  },
  mounted() {
    this.modal = new bootstrap.Modal(document.getElementById("myModal"), {
      keyboard: false,
    });
  },
  async created() {
      await this.getOrders();
  }
};
</script>
