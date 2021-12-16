import { createWebHistory, createRouter } from 'vue-router'

// Templates
import CustomerTemplate from './templates/CustomerTemplate.vue'

// Screens
import Reservation from './screens/Reservation/Reservation.vue'
import SignIn from './screens/Admin/SignIn/SignIn.vue'
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
            path: '/admin/signin',
            component: SignIn,
            name: 'signin'
        },
        {
            path: '/admin',
            component: AdminPanel,
            children: [
                {path: '', component: AdminPanel, name: 'AdminPanel'},
            ]
        }
    ]
})

router.beforeEach((to, from, next) => {

    // Router Guard for Sign-in Page
    if (to.name === 'signin') {
        const token = localStorage.getItem('RR-Token')
        if (token) return next({name: 'AdminPanel'})
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