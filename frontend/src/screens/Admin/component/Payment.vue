<template>
  <div class="container-fluid">
    <div class="row flex-nowrap main-content">
      <SIDEBAR />
      <div class="col py-3">
        <div>
          <div class="col-11 mx-5 p-5 rounded shadow">
            <div class="row justify-content-between">
              <div class="col-4">
                <h4>Bill Payment</h4>
                <h6>
                  <i class="fas fa-calendar-alt"></i>&nbsp;in last 30 days
                  revenue
                </h6>
              </div>
              <div class="col-4">
                <input
                  class="form-control form-control-md rounded"
                  type="text"
                  placeholder="SEARCH"
                  v-model="searchText"
                  @change="search"
                />
              </div>
            </div>
            <div class="table-responsive my-2 box-table">
              <table class="table is-fullwidth table-fixed">
                <thead class="table-light">
                  <tr>
                    <th scope="col">Order#</th>
                    <th scope="col">Payment#</th>
                    <th scope="col">
                        Date
                        <button type="button" class="btn btn-sm" @click="sortDate()">
                          <span v-if= "sortByDate">
                            <i class="fas fa-sort-amount-up"/>
                          </span>
                          <span v-else>
                            <i class="fas fa-sort-amount-down"/>
                          </span>                        
                        </button>
                    </th>
                    <th scope="col">
                      Actions
                      <button type="button" class="btn btn-sm" @click="sortStatus()">
                        <span v-if= "sortByStatus">
                          <i class="fas fa-sort-amount-up"/>
                        </span>
                        <span v-else>
                          <i class="fas fa-sort-amount-down"/>
                        </span>                           
                      </button>
                    </th>
                  </tr>
                </thead>
                <tbody>
                  <template v-for="payment in PaymentResult" :key="payment.no">
                    <tr>
                      <td>{{ payment.no }}</td>
                      <td>{{ payment.proof_of_payment }}</td>
                      <td>{{ dateFormat(payment.date) }}</td>
                      <td class="d-grid gap-2 d-md-flex">
                        <button
                          type="button"
                          class="btn btn-success btn-sm px-1 rounded"
                          @click="showModal(payment.no)"
                          v-if="!payment.status"
                          data-bs-toggle="modal"
                          data-bs-target="#myModal"
                        >
                          <span
                            ><i class="fas fa-check-circle"></i>
                            &nbsp;CONFIRM</span
                          >
                        </button>
                        <span
                          class="badge rounded-pill bg-secondary"
                          v-if="payment.status"
                        >
                          <span class="dot bg-light" />
                          Payment has been reviewed.
                        </span>
                      </td>
                    </tr>
                  </template>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--Toast-->
    <div class="position-fixed bottom-0 end-0 p-5" style="z-index: 11">
        <div id="toast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <strong class="me-auto">Confirm Order</strong>
                <small>a moment ago</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                {{ "Payment Order "+ notify + " Confirm Success!" }}
            </div>
        </div>
    </div>
    
  <!--Modal-->
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm Payment</h5>
            </div>
            <div class="modal-body">
                <p>{{ "Confirm payment for order ID " + paymentConfirm + " ?" }}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">cancle</button>
                <button type="button" class="btn btn-primary" 
                    @click= "confirmPayment(paymentConfirm); toast.show()" 
                    data-bs-dismiss="modal">Confirm
                </button>
            </div>
        </div>
        </div>
    </div>
</template>

<style scoped>
.main {
  height: 89vh;
  background-color: var(--emerald);
  opacity: 5%;
}
</style>

<script>
import Payment from "../dummy_data/Payment.js";
import SIDEBAR from './Sidebar.vue';
import dayjs from "dayjs";
export default {
  components: {
    SIDEBAR,
  },
  data() {
    return {
      Payments: Payment,
      sortByDate: false,
      sortByStatus: false,
      searchText: "",
      modal: null,
      toast: null,
      paymentConfirm: null,
      notify: ""
    };
  },
  computed: {
    PaymentResult() {
      return this.Payments.filter((x) => {
        if (x.proof_of_payment.includes(this.searchText) || x.no.includes(this.searchText)) {
          return x;
        }
      });
    }
  },
  methods: {
    showModal(id) {
      this.paymentConfirm = id;
      this.modal.toggle();
    },
    sortDate() {
      function compare(a, b) {
        let dayA = dayjs(a.date);
        let dayB = dayjs(b.date);
        if (_this.sortByDate){
          if (dayA > dayB) {
            return 1;
          } else if (dayA < dayB) {
            return -1;
          } else {
            return 0;
          }
        }
        else {
          if (dayA > dayB) {
            return -1;
          } else if (dayA < dayB) {
            return 1;
          } else {
            return 0;
          }
        }
        
      }
      var _this = this;
      this.sortByDate = !this.sortByDate;
      this.Payments.sort(compare);
    },
    sortStatus(){
      function compare(a, b) {
        if (_this.sortByStatus){
          if (a.status && !b.status) {
            return 1;
          } else if (!a.status && b.status) {
            return -1;
          } else {
            return 0;
          }
        }
        else {
          if (a.status && !b.status) {
            return -1;
          } else if (!a.status && b.status) {
            return 1;
          } else {
            return 0;
          }
        }
        
      }
      var _this = this;
      this.sortByStatus = !this.sortByStatus;
      this.Payments.sort(compare);
    },
    search() {
      console.log(this.searchText);
    },
    confirmPayment(no) {
      console.log(no);
      this.notify = no;
      this.Payments.map((x) => {
        if (x.no == no){
          x.status = true;
        }
      })
    },
    dateFormat(date){
        return dayjs(date).format("MM/DD/YYYY HH:mm");
    }
  },
  mounted() {
    this.modal = new bootstrap.Modal(document.getElementById("myModal"), {
      keyboard: false,
    });
    this.toast = new bootstrap.Toast(document.getElementById("toast"), {
        autohide: true,
        delay: 3000
    });
  },
};
</script>