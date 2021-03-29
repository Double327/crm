import Vue from 'vue'
import Vuex from 'vuex'
import app from '../src/store/modules/app'
import user from '../src/store/modules/user'
import tagsView from '../src/store/modules/tagsView'
import permission from '../src/store/modules/permission'
import settings from '../src/store/modules/settings'
import getters from '@/store/getters'

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    app,
    user,
    tagsView,
    permission,
    settings,
  },
  getters
});

export default store
