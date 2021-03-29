import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(ElementUI);
Vue.config.productionTip = false

Vue.prototype.msgSuccess = function (msg) {
    this.$message({showClose: true, message: msg, type: "success"})
}

Vue.prototype.msgError = function (msg) {
    this.$message({showClose: true, message: msg, type: "error"})
}

Vue.prototype.msgInfo = function (msg) {
    this.$message({showClose: true, message: msg, type: "info"})
}
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
