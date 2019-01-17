import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Venu from "./views/Venu";
import ScheduleCourse from "./views/ScheduleCourse"

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/schedule-course',
      name: 'schedule-coursse',
      component: ScheduleCourse
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import(/* webpackChunkName: "about" */ './views/About.vue')
    },
    {
      path: '/venu',
      name: 'venu',
      component: Venu
    }
  ]
})
