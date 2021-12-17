<template>
    <div class="px-3">
        <div class="col-12 p-5 rounded shadow">
            <div class="row">
            <div class="col-2">
                <h1>THEME</h1>
            </div>
            <div class="col-2"
                data-bs-toggle="modal"
                data-bs-target="#themeInfoModal"    
                @click= "addTheme()"
            >        
                <span style="font-size: 30px;"><i class="fas fa-plus-circle"></i></span>
            </div>
            </div>
            <template v-for= "theme in Themes" :key= "theme.id">
                <div class="card w-75 px-3 m-4">
                    <div class="card-body">
                        <div class="d-flex flex-row justify-content-between">
                            <div class="row">
                                <div class="col-3">
                                    <template v-if= "theme.image != ''">
                                        <img :src= "theme.image" class="rounded float-start img-thumbnail">
                                    </template>
                                    <template v-else>
                                        <div style="margin-right: 48vw" ></div>
                                    </template>
                                </div>
                                <div class="col-8 px-3">
                                    <h4 class="card-title">{{ theme.name}}</h4>
                                    <span class="card-text"> {{theme.details}}</span>
                                </div>
                            </div>
                            <div class="p-3" 
                                data-bs-toggle="modal"
                                data-bs-target="#themeInfoModal"    
                                @click= "themeDetails(theme)"
                            >
                                <span style="font-size: 48px;"><i class="fas fa-info-circle"></i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </template>
        </div>
        <div class="col-12 p-5 rounded shadow">
            <div class="row">
            <div class="col-2">
                <h1>Accessory</h1>
            </div>
            <div class="col-2"
                data-bs-toggle="modal"
                data-bs-target="#accessoryModal"       
            >        
                <span style="font-size: 30px;"><i class="fas fa-plus-circle"></i></span>
            </div>
            </div>
            <div>
                <div class="row">
                    <div v-for = "acc in Accessory" :key= "acc.id" class="col-3 rounded card">
                        <div class="row">
                            <div class="col-2">
                                <div class="image ratio ratio-1x1 rounded-3"></div>
                            </div>
                            <div class="col">
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-10">
                                            <p class="card-text">{{acc.aname}}</p>
                                        </div>
                                        <div class="col-2 justify-content-end" @click= "deleteAccessory(acc)">
                                            <i class="far fa-trash-alt"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="themeInfoModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-body p-5">
                    <div class="row mb-3">
                        <div class="col-8">
                            <template v-if= "!editable" >
                                <h3>{{themeDetail.name}}</h3>
                                <div>{{themeDetail.details}}</div>
                            </template>
                            <template v-else>
                                <input type="text" class="form-control" 
                                    :value= "themeDetail.name" 
                                    @change= "update('name',$event.target.value)"
                                    placeholder="Theme Title"
                                >
                                <textarea class="form-control mt-2" placeholder="Details for Theme"
                                  :value = "themeDetail.details"
                                  @change= "update('details', $event.target.value)"
                                  style="height: 12vh">
                                </textarea>
                            </template>
                            
                        </div>
                        <div class="col-4">
                            <template v-if= "themeDetail.image != ''">
                            <div class="image ratio ratio-4x3 rounded-3">
                                <img :src= "themeDetail.image" class="rounded float-start img-thumbnail">
                            </div>
                            </template>
                        </div>
                    </div>
                    <div class="mb-5">
                        <h4 class="mb-3">รายการของประกอบฉาก</h4>
                        <div class="row">
                            <div v-for="(item, index) in themeDetail.accessory" :key="index" class="col-6">
                                <div class="row">
                                    <div class="col-3">
                                        <div class="image ratio ratio-1x1 rounded-3"></div>
                                    </div>
                                    <div class="col-7">
                                        <h6 class="mb-0">{{item.name}}</h6>
                                        <span>x{{item.quantity}}</span>
                                    </div>
                                    <template v-if = "editable">
                                        <div class="col-1" @click= "deleteItem(item, index)">
                                            <i class="far fa-trash-alt"></i>
                                        </div>
                                    </template>
                                </div>
                            </div>
                            <template v-if = "editable">
                                <div v-for= "(item, index) in newAcc" :key= "index" class="col-6">
                                    <div class="row">
                                        <div class="col-3">
                                            <div class="image ratio ratio-1x1 rounded-3"></div>
                                        </div>
                                        <div class="col-7">
                                            <select v-model= "item.name" style="position: absolute; opacity: 0">
                                                <option v-for= "(accItem, index) in accFilter" v-bind:value= "accItem.name" :key= "index">
                                                    {{ accItem.name }}
                                                </option>
                                            </select>
                                            <h6 class="mb-0">
                                                {{item.name == "" ? 'selected Item' : item.name}}
                                                <i class="fas fa-caret-down"></i>
                                            </h6>
                                            <div class="input-group">
                                                <span class="py-2" >x</span>
                                                <input type="number" class="form-control-plaintext" id="price" 
                                                    min= "1"
                                                    style="width: 3vw"
                                                    v-model= "item.quantity"
                                                >
                                            </div>
                                        </div>
                                        <div class="col-1" @click= "deleteItemEdit(index)">                                         
                                            <i class="far fa-trash-alt"></i> 
                                        </div> 
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="row">
                                        <div class="col-3">
                                            <div class="image ratio ratio-1x1 rounded-3"></div>
                                        </div>
                                        <div class="col-5 mx-5">
                                            <button class="btn btn-outline-primary"
                                            @click= "addItem()">                          
                                                ADD ITEM
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </template>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end align-items-center">
                        <template v-if= "!editable" >
                            <h4 class="fw-light me-4 mb-0">
                                {{parseInt(themeDetail.price)}}
                                <span class="small">บาท</span>
                            </h4>
                            <button type="button" class="btn btn-secondary px-5 py-2 mx-2" data-bs-dismiss="modal">Close</button>
                            <button @click= "editable = !editable" class="btn btn-warning px-5 py-2">EDIT</button>                        
                        </template>
                        <template v-else>
                            <div class="input-group justify-content-end me-4"> 
                                <input type="number" class="form-control-plaintext" id="price" 
                                    :value= "themeDetail.price"
                                    @change= "update('price', parseInt($event.target.value))"
                                    style="width: 4vw;"
                                >
                                <span class="py-2 fw-light">บาท</span>
                            </div>
                            <button @click= "editableConfirm(themeDetail.id)" class="btn btn-primary px-5 py-2">CONFIRM</button>
                        </template>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="accessoryModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-md">
            <div class="modal-content">
                <div class="modal-body">
                    <h3>Add New Accessory</h3>
                    <div class="input-group p-3">
                        <span class="input-group-text">Name </span>
                        <input type="text" aria-label="Name Accessory" 
                            class="form-control"
                            :value= "newAccName"
                            @change= "changeAccName($event.target.value)"
                        >
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="d-flex justify-content-end align-items-center">
                        <button data-bs-dismiss="modal" class="btn px-2 py-2 mx-3">Cancle</button>
                        <button @click= "addAccessory" data-bs-dismiss="modal" class="btn btn-emerald px-2 py-2">Confirm</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import THEMES from '../dummy_data/Theme';
import axios from 'axios';
export default {
    data(){
        return {
            header: {
                headers: {
                    token: localStorage.getItem('RR-Token'),
                    userId: localStorage.getItem('RR-UID')
                }
            },
            newAccName: "",
            Themes: THEMES,
            modal: null,
            modal2: null,
            theme: [],
            themeDetail: {},
            editable: false,
            addNewTheme: false,
            newAcc: [],
            accItem: {},
            test: 'aaaaa',
            accFilter: [],
            Accessory: null
        }
    },
    mounted() {
        
        this.modal = new bootstrap.Modal(document.getElementById("themeInfoModal"), {
            keyboard: false,
            backdrop: "static"
        });

        this.modal2 = new bootstrap.Modal(document.getElementById("accessoryModal"), {
            keyboard: false
        });
    },
    methods: {
        async requestAccessory(){
            // Get Acc
            const path = `${process.env.VUE_APP_API_TARGET}/getAcc`;
            const result = await axios.get(path);
            const acc = result.data;
            this.Accessory = acc;
        },
        async addAccessory(){
            const path = `${process.env.VUE_APP_API_TARGET}/addAcc`;
            const data = { "name": this.newAccName}
            const result = await axios.patch(path, data, this.header);
            await this.requestAccessory();
        },
        async deleteAccessory(acc){
            const path = `${process.env.VUE_APP_API_TARGET}/delAcc/${acc.id}`;
            const data = { "name": acc.aname }
            const result = await axios.delete(path, {
                headers: this.header.headers, 
                data: data
            });
            await this.requestAccessory();
            alert('Delete Accessory '+acc.aname);
        },
        themeDetails(data){
            this.themeDetail = data;
        },
        addItem(){
            this.newAcc.push({
                name: "",
                quantity: 1
            });
            this.accFilters();
        },
        editableConfirm(id){
            // validate later
            if (true){
                this.newAcc.map((x) => {
                    var idAcc = this.acc.find((acc) => acc.name == x.name);
                    this.themeDetail.accessory.push({...x, "id": idAcc.id});
                });

                if (!this.addNewTheme){
                    var index = this.Themes.findIndex(x => x.id == id);
                    this.Themes[index] = this.themeDetail
                }
                else if (this.addNewTheme){ 
                    this.addNewTheme = false;
                    this.Themes.push(this.themeDetail);
                }
                this.editable = false;
                this.newAcc = []
            } 
        },
        deleteItem(item, i){
            alert('Delete Item '+ item.name);
            this.themeDetail.accessory.splice(i, 1);
        },
        deleteItemEdit(i){
            this.newAcc.splice(i, 1);
        },
        addTheme(){
            this.themeDetail = {
                "name": "",
                "image": "",
                "details": "",
                "price": 0,
                "accessory": []
            }
            this.editable = true;
            this.addNewTheme = true;
        },
        update(key, val){
            this.themeDetail[key] = val;
        },
        changeAccName(val){
            this.newAccName = val
        },
        accFilters() {
            var checkName1 = this.themeDetail.accessory.map( x => {
                return x.name
            });
            var checkName2 = this.newAcc.map( x => {
                return x.name
            });
            
            this.accFilter = this.acc.filter( x => !checkName1.includes(x.name) && !checkName2.includes(x.name) )
        }
    },
    async created() {
        await this.requestAccessory()
    }
}
</script>