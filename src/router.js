import Vue from 'vue';
import VueRouter from 'vue-router';
import TestingHome from './views/TestingHome.vue';
import TestingLogin from './views/TestingLogin.vue';
import TestingRegister from './views/TestingRegister.vue';
import TestingProfile from './views/TestingProfile.vue';
import BoardAdmin from './views/BoardAdmin.vue';
import shopping from './views/shopping.vue';
Vue.use(VueRouter);
export const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: TestingHome
    },
    {
      path: '/home',
      component:  TestingHome
    },
    {
      path: '/login',
      component:  TestingLogin
    },
    {
      path: '/register',
      component:  TestingRegister
    },
    {
      path: '/profile',
      name: 'TestingProfile',
      // () => import('./views/TestingProfile.vue')
      component: TestingProfile
    },
    {
      path: '/admin',
      name: 'admin',
      // () => import('./views/BoardAdmin.vue')
      component: BoardAdmin
    },
    {
      path: '/mod',
      name: 'moderator',
      // lazy-loaded
      component: () => import('./views/BoardModerator.vue')
    },
    {
      path: '/user',
      name: 'user',
      // lazy-loaded
      component: () => import('./views/BoardUser.vue')
    }, {
      path: '/shopping',
      
      // lazy-loaded
      component: shopping
    },{
      path: '/viewShop',
      name: 'viewShop',
      // lazy-loaded
      component: () => import('./views/viewShop.vue')
    }
  ]
});