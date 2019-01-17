<template>
  <v-app id="sw300">
    <v-toolbar app clipped-left>
      <v-toolbar-side-icon @click.stop="drawerRight = !drawerRight"></v-toolbar-side-icon>
      <v-img
              :src="require('./assets/kosta2.png')"
              contain
              height="50"
      ></v-img>

    </v-toolbar>
    <v-navigation-drawer
            v-model="drawerRight"
            fixed
            left
            clipped
            app

    >
      <v-list dense>
        <v-list-tile
          router
          :to="item.to"
          :key="item.title"
          v-for="item in items"
        >
          <v-list-tile-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>{{ item.title }}</v-list-tile-title>
          </v-list-tile-content>

        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-content>
      <v-container fluid>
        <router-view/>
      </v-container>
    </v-content>
  </v-app>
</template>
<script>
  export default {
    data: () => ({
      drawerRight: null,
      items: [
        {title: 'Home', icon: 'home', to: '/'},
        {title: 'Schedule Class', icon: 'home', to: '/schedule-course'},
        {title: 'Venu', icon: 'location_on', to:'/venu'},
        {title: 'About', icon: 'question_answer', to: '/about'},
      ]
    }),
    props: {
      source: String
    }
  }
</script>