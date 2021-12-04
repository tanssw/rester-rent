<template>
    <div class="mb-5">
        <h4 class="fw-light mb-4">เลือกห้องสำหรับจัดงาน</h4>
        <div class="row g-5">
            <div v-for="(room, index) in rooms" :key="index" class="col-4">
                <div @click="showDescription(room)" :class="{'active': checkSelectedRoom(room.id)}" class="room-card cursor-pointer rounded-3 p-3">
                    <div class="row">
                        <div class="col-3">

                        </div>
                        <div class="col-9 d-flex">
                            <div class="flex-grow-1">
                                <h5>{{room.title}}</h5>
                                <div class="small">
                                    <div>ขนาด: {{room.size}}</div>
                                    <div>รองรับได้สูงสุด {{room.maximum}} คน</div>
                                </div>
                            </div>
                            <div class="my-auto">
                                <i class="fas fa-info-circle fa-2x text-secondary"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <room-desc-modal ref="roomDescModal" :room="focus" @select="selectRoom" />
    </div>
</template>
<style scoped>
.room-card {
    border: 2px solid #ddd;
    transition: .25s;
}
.room-card:hover {
    border-color: #aaa;
}
.room-card.active {
    border-color: var(--light-emerald);
}
</style>
<script>
import mockedRoomList from '@/assets/mock/rooms.json'

import RoomDescModal from './RoomDescModal.vue'

export default {
    components: {
        RoomDescModal
    },
    props: {
        selected: {
            type: Object,
            required: true
        }
    },
    emits: ['update:selected'],
    data() {
        return {
            focus: {},
            rooms: mockedRoomList
        }
    },
    methods: {
        showDescription(room) {
            this.focus = room
            this.$refs.roomDescModal.toggle()
        },
        selectRoom() {
            this.$emit('update:selected', this.focus)
            this.focus = {}
        },
        checkSelectedRoom(roomId) {
            return this.selected.id === roomId
        }
    }
}
</script>