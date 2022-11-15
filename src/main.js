import Vue from 'vue';
import App from './App.vue';
import { router } from './router';
import store from './store';
import Vuesax from 'vuesax'
import VeeValidate from 'vee-validate';
import 'vuesax/dist/vuesax.css' //Vuesax styles
import 'material-icons/iconfont/material-icons.css';
import VueApexCharts from 'vue-apexcharts'
import '@/assets/tailwind.css'

Vue.use(VueApexCharts)
Vue.component('apexchartToo', VueApexCharts)



Vue.config.productionTip = false;
Vue.use(VeeValidate);
Vue.use(Vuesax, {
  // options here
})

new Vue({
 router,
  store,
  render: h => h(App)
}).$mount('#app');