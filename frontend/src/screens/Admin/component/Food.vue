<template>
  <div class="p-5">
    <div class="row">
    <div v-for="(set, index) in FoodSet" :key="index" class="col-4 p-3">
        <div class="col-12">
          <div class="card" >
            <div class="card-body">
                <div class="row justify-content-between">
                    <div class="col-8 py-3">
                        <h5 class="card-title">{{set.fName}}</h5>
                    </div>
                    <div class="col-2" @click= "showMenu[index] = !showMenu[index]">
                        <span style="font-size: 48px;" v-if= "showMenu[index]" >
                            <i class="fas fa-sort-up"></i>
                        </span>
                        <span style="font-size: 48px;" v-else>
                            <i class="fas fa-sort-down"></i>
                        </span>
                    </div>
                </div>
                <template v-if= "showMenu[index]">
                    <div class="p-2">
                        <h6>Menu</h6>
                        <div class="p-1 col-11">
                            <template v-for= "(item, indexItem) in JSON.parse(set.menus)" :key="indexItem">
                                <div class="col-8 mx-3">
                                    <span> - {{ item }}</span>
                                </div>
                            </template>
                        </div>
                    </div>
                </template>
            </div>
            <ul class="list-group">
                <template v-for= "(option) in sizeOption" :key= "option.initial">
                    <button type="button" class="list-group-item list-group-item-action" v-if= "setSize != null">
                    <div class="row">
                        <div class="col-3">
                            {{ "SIZE "+ option.initial }}
                        </div>
                        <template v-if= "editable && this.setSize[index][option.initial].status">
                            <div class="col-3">
                                <div class="input-group justify-content-end"> 
                                    <input type="number" class="form-control-plaintext" id="size" 
                                        :value= "this.setSize[index][option.initial].size"
                                        @change= "setSize[index][option.initial].size = $event.target.value"
                                        style="width: 3.5vw;"
                                    >
                                    <span class="float-end">
                                        <i class="fas fa-users"></i>
                                    </span>
                                </div>
                            </div>
                            <div class="col-3">
                                <span class="float-end">
                                    <div class="input-group justify-content-end"> 
                                    <input type="number" class="form-control-plaintext" id="size" 
                                        :value= "this.setSize[index][option.initial].price"
                                        @change= "setSize[index][option.initial].price = $event.target.value"
                                        style="width: 3.5vw;"
                                    >
                                    <span class="float-end">
                                        $
                                    </span>
                                </div>
                                </span>
                            </div>
                        </template>
                        <template v-else>
                        <div class="col-3">
                            <span class="float-end">
                                {{ this.setSize[index][option.initial].size}}
                                <i class="fas fa-users"></i>
                            </span>
                        </div>
                        <div class="col-3">
                            <span class="float-end">
                                {{ this.setSize[index][option.initial].price }} $
                            </span>
                        </div>
                        </template>
                        <div class="col-3 align-items-center" :class= "!editable ? 'invisible':''" >
                            <a v-if= "!this.setSize[index][option.initial].status" class="btn btn-outline-info p-1"
                                @click= "addSize(option.size, set)"
                            >
                                <span> Add </span>
                            </a>
                            <div class="btn-group" role="group" aria-label="First group" v-else>
                                <a class="btn btn-outline-info" @click= "editSize(setSize[index][option.initial], set, option.size)">
                                    <i class="fas fa-pen"></i>
                                </a>
                                <a class="btn btn-outline-danger" @click= "delSize(setSize[index][option.initial].id)">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </div>
                        </div>
                    </div>
                    </button>
                </template>
            </ul>
            <div class="card-body">
               <div class="d-flex justify-content-end align-items-center">
                    <button @click= "editable = !editable" class="btn btn-warning px-5 py-2">EDIT</button>
                </div>
            </div>
          </div>
        </div>
    </div>
    </div>
  </div>
  <div id="myModal" class="modal fade" role="dialog">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <div class="modal-body">
                  <h4>Are you sure to Delete this Menu?</h4>
              </div>
              <div class="modal-footer justify-content-end align-items-center">
                  <button class="btn px-2" data-bs-dismiss="modal">cancle</button>
                  <button @click= "deleteFood" class="btn btn-danger px-5 ">Delete</button>
              </div>
            </div>
          </div>
    </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      header:{
        headers: {
            token: localStorage.getItem('RR-Token'),
            userId: localStorage.getItem('RR-UID')
        }
      },
      FoodSet: [],
      showMenu: [],
      setSize: {},
      sizeOption: [
          {size: "Small", initial: "S"},
          {size: "Medium", initial: "M"},
          {size: "Large", initial: "L"},
          {size: "Extra Large", initial: "XL"},
      ],
      editable: false,
      modal: null
    };
  },
  methods: {
    async getFood() {
      // Get Theme
      const path = `${process.env.VUE_APP_API_TARGET}/getFood`;
      const result = await axios.get(path);
      const food = result.data;
      this.FoodSet = food;
      await this.setFoodData(food.length);
    },
    async addSize(size, food){
        try {
            const path = `${process.env.VUE_APP_API_TARGET}/addFood`;
            const data = {
                "fname": food.fName,
                "menus": food.menus,
                "capacity": 0,
                "price": 0,
                "size": size
            }
            console.log(data)
            const result = await axios.patch(path, data, this.header);
            await this.getFood();
        } catch(error) {
            this.checkUnauthorized(error)
        }
    },
    async delSize(id){
        try {
            const path = `${process.env.VUE_APP_API_TARGET}/delFood/${id}`;
            const result = await axios.delete(path, this.header);
            await this.getFood();
        } catch(error) {
            this.checkUnauthorized(error)
        }
    },
    async editSize(food, set, size){
        try {
            const path = `${process.env.VUE_APP_API_TARGET}/updFoodOption/${food.id}`;
            const data = {
                "id": food.id,
                "fname": set.fName,
                "menus": set.menus,
                "capacity": food.size,
                "price": food.price,
                "size": size
            }
            const result = await axios.patch(path, data, this.header);
            await this.getFood();
        } catch(error) {
            this.checkUnauthorized(error)
        }
    },
    async setFoodData(size){
        for (let i = 0; i < size; i++) {
            this.showMenu[i] = false
            this.setSize[i] = {
                'S' : this.optionsFilter('Small', this.FoodSet[i].options),
                'M' : this.optionsFilter('Medium', this.FoodSet[i].options),
                "L" : this.optionsFilter('Large', this.FoodSet[i].options), 
                "XL": this.optionsFilter('Extra Large', this.FoodSet[i].options)
            } 
        }
        console.log(this.setSize)
    },
    optionsFilter(size, opt){
        var food = opt.filter( x => x.size == size);
        return (food.length == 0) ? {size: "-", price: "-", status: false, id: null} : {size: food[0].capacity, price: food[0].price, status: true, id: food[0].id}
    }
  },
  async created() {
    await this.getFood();
  },
  mounted() {
    this.modal = new bootstrap.Modal(document.getElementById("myModal"), {
      keyboard: false,
    });
  },
};
</script>

<style>
</style>