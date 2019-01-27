import Vue from 'vue'
import './plugins/axios'
import './plugins/vuetify'
import App from './App.vue'
import 'vuetify/dist/vuetify.min.css'
import router from './router'

Vue.config.productionTip = false

Vue.use(require('vue-moment'))

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
