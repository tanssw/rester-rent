import { createWebHistory, createRouter } from 'vue-router'

import Reservation from './screens/Reservation/Reservation.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {path: '/', component: Reservation}
    ]
})

export default router