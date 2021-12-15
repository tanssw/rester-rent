import { createApp } from 'vue'

import router from './router'
import App from './App.vue'

import { initializeApp } from 'firebase/app'
import { firebaseConfig } from './config/firebaseConfig'

initializeApp(firebaseConfig)

const app = createApp(App)
app.use(router)
app.mount('#app')