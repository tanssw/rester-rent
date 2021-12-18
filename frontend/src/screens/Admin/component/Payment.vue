<template>
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
                    <th scope="col">Payment#</th>
                    <th scope="col">Contact</th>
                    <th scope="col">Amount</th>
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
                  <template v-for="(payment, index) in PaymentResult" :key="index">
                    <tr>
                      <td>{{ payment.reference}}</td>
                      <td>{{ payment.mail }}</td>
                      <td>{{ payment.amount }}</td>
                      <td>{{ dateFormat(payment.date_time) }}</td>
                      <td class="d-grid gap-2 d-md-flex">
                        <button
                          type="button"
                          class="btn btn-success btn-sm px-1 rounded"
                          @click="showModal(payment.reference)"
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
import axios from 'axios';
import dayjs from "dayjs";
export default {
  data() {
    return {
      header:{
        headers: {
            token: localStorage.getItem('RR-Token'),
            userId: localStorage.getItem('RR-UID')
        }
      },
      Payments: [],
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
      if (this.Payments != []){
        return this.Payments.filter((x) => {
          if ( x.reference.includes(this.searchText) || x.mail.includes(this.searchText)) {
            return x;
          }
        });
      }
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
    confirmPayment(reference) {
      this.notify = reference;
      this.Payments.map(async(x) => {
        if (x.reference == reference){
          await this.updatePayment(x);
          x.status = true;
        }
      })
    },
    dateFormat(date){
        return date;
    },
    async getPayment(){
      const path = `${process.env.VUE_APP_API_TARGET}/getPayment`;
      const result = await axios.get(path);
      const data = result.data;
      this.Payments = data;
    },
    async updatePayment(x){
        var data = x;
        data.status = true;
        try {
            const path = `${process.env.VUE_APP_API_TARGET}/updPayment`;
            const result = await axios.patch(path, data, this.header);
            await this.requestAccessory();
        } catch(error) {
            this.checkUnauthorized(error)
        }
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
  async created() {
    await this.getPayment();
  }
};
</script>