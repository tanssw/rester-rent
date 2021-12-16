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
                { path: 'payment', component: Payment, name: 'payment'},
                { path: 'order', component: Order, name: 'order'}
            ]
        },
    ]
})

router.beforeEach((to, from, next) => {

    // Router Guard for Sign-in Page
    if (to.name === 'signin') {
        const token = localStorage.getItem('RR-Token')
        if (token) return next({name: 'order'})
        return next()
    }

    let paths = to.path.split('/')
    paths.shift()

    // Router Guard for another admin page
    if (paths[0] === 'admin' && !paths.includes('signin')) {
        const token = localStorage.getItem('RR-Token')
        if (token) return next()
        return next({name: 'signin'})
    }

    return next()

})

export default router