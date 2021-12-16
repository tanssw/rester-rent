<template>
    <div class="px-3">
        <div class="col-12 p-5 rounded shadow">
            <div class="row">
            <div class="col-2">
                <h1>THEME</h1>
            </div>
            <div class="col-2">
                <button class="btn btn-md btn-light">
                    <span style="font-size: 26px;"><i class="fas fa-plus-circle"></i></span>
                </button>
            </div>
            </div>
            <template v-for= "theme in Themes" :key= "theme.id">
                <div class="card w-75 px-3 m-4">
                    <div class="card-body">
                        <div class="d-flex flex-row justify-content-between">
                            <div class="row">
                                <div class="col-3">
                                    <img :src= "theme.image" class="rounded float-start img-thumbnail">
                                </div>
                                <div class="col-8 px-3">
                                    <h4 class="card-title">{{ theme.name}}</h4>
                                    <span class="card-text"> {{theme.details}}</span>
                                </div>
                            </div>
                            <div class="p-3" 
                            data-bs-toggle="modal"
                            data-bs-target="#themeInfoModal">
                                <span style="font-size: 48px;"><i class="fas fa-info-circle"></i></span>
                            </div>
                        </div>
                    </div>
                </div>
            </template>
        </div>   
    </div>

    <div id="themeInfoModal" tabindex="-1" class="modal fade">
        <div class="modal-dialog modal-dialog-centered modal-lg">
            <div class="modal-content">
                <div class="modal-body p-5">
                    <div class="row mb-3">
                        <div class="col-8">
                            <h3>title</h3>
                            <div>description</div>
                        </div>
                        <div class="col-4">
                            <div class="image ratio ratio-4x3 rounded-3"></div>
                        </div>
                    </div>
                    <div class="mb-5">
                        <h4 class="mb-3">รายการของประกอบฉาก</h4>
                        <div class="row">
                            <div v-for="(item, index) in theme.items" :key="index" class="col-6">
                                <div class="row">
                                    <div class="col-3">
                                        <div class="image ratio ratio-1x1 rounded-3"></div>
                                    </div>
                                    <div class="col-9">
                                        <h6 class="mb-0">{{item.title}}</h6>
                                        <span>x{{item.quantity}}</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end align-items-center">
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import THEMES from '../dummy_data/Theme'
export default {
    data(){
        return {
            Themes: THEMES,
            modal: null,
            theme: []
        }
    },
    mounted() {
        this.modal = new bootstrap.Modal(document.getElementById("themeInfoModal"), {
            keyboard: false,
        });
    }
}
</script>