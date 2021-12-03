import { createWebHistory, createRouter } from 'vue-router'

// Templates
import CustomerTemplate from './templates/CustomerTemplate.vue'

// Screens
import Reservation from './screens/Reservation/Reservation.vue'
import AdminPanel from './screens/Admin/AdminPanel.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            component: CustomerTemplate,
            children: [
                {path: '', component: Reservation, name: 'reservation'}
            ]
        },
        {
            path: '/admin',
            component: AdminPanel,
            children: [
                {path: '', component: AdminPanel, name: 'AdminPanel'}
            ]
        }
    ]
})

export default router