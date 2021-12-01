<template>
    <div class="mb-5">
        <h4 class="fw-light mb-4">เลือกห้องสำหรับจัดงาน</h4>
        <div class="row g-5">
            <div v-for="(room, index) in rooms" :key="index" class="col-6">
                <div @click="showDescription(room)" class="room-card cursor-pointer rounded-3 p-3">
                    <div class="row">
                        <div class="col-3">

                        </div>
                        <div class="col-9 d-flex">
                            <div class="flex-grow-1">
                                <h4>{{room.title}}</h4>
                                <div>ขนาด: {{room.size}}</div>
                                <div>รองรับได้สูงสุด {{room.maximum}} คน</div>
                            </div>
                            <div class="my-auto">
                                <i class="fas fa-info-circle fa-2x text-secondary"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <room-desc-modal ref="roomDescModal" :room="selected" />
    </div>
</template>
<style scoped>
.room-card {
    border: 1px solid #ddd;
    transition: .25s;
}
.room-card:hover {
    border-color: var(--salmon);
}
.room-card.active {
    border-color: var(--salmon);
}
</style>
<script>
import mockedRoomList from '@/assets/mock/rooms.json'

import RoomDescModal from './RoomDescModal.vue'

export default {
    components: {
        RoomDescModal
    },
    data() {
        return {
            selected: {},
            rooms: mockedRoomList
        }
    },
    methods: {
        showDescription(room) {
            this.selected = room
            this.$refs.roomDescModal.toggle()
        }
    }
}
</script>