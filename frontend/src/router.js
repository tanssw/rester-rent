import { createWebHistory, createRouter } from 'vue-router'

// Templates
import CustomerTemplate from './templates/CustomerTemplate.vue'
import AdminPanel from './templates/AdminPanel.vue'
// Screens
import Reservation from './screens/Reservation/Reservation.vue'
import SignIn from './screens/Admin/SignIn/SignIn.vue'
import Payment from './screens/Admin/component/Payment.vue'
import Order from './screens/Admin/component/Order.vue'

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
            path: '/admin/signin',
            component: SignIn,
            name: 'signin'
        },
        {
            path: '/admin',
            component: AdminPanel,
            children: [
                { path: 'payment', component: Payment, name: 'Payment'},
                { path: 'order', component: Order, name: 'Order'}
            ]
        },
    ]
})

export default router