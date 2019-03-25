<template>
  <div>
    <v-expansion-panel>
      <v-expansion-panel-content v-for="(item, idx) in response" :key="idx" class="grey lighten-4">
        <div slot="header">
          <h3>{{ item.title }}</h3>
        </div>
        <v-card>
          <v-card-text>
            Title : {{ item.title }}
            <br>
            Duration : {{ item.duration }}
            <br>
            Max enrollment : {{ item.maxEnrollment }}
            <br>
            Min enrollment : {{ item.minEnrollment }}
            <br>
            Unit price : {{ item.unitPrice }}
            <br>
            <br>
            <v-btn color="primary" @click="selectCourse(idx)">Select</v-btn>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
      <span v-if="response.length <= 0">
        <h3>Do not exist course.</h3>
      </span>
    </v-expansion-panel>
  </div>
</template>

<script>
export default {
  name: "GetCourse",
  props: {
    selectedCourse: null,
    step: 0
  },
  data() {
    return {
      response: [],
      errors: []
    };
  },
  methods: {
    getCourseList() {
      this.axios
        .get("/courses")
        .then(res => {
          this.response = res.data._embedded.course;
        })
        .catch(e => this.errors.push(e));
    },
    selectCourse(idx) {
      this.$emit("update:selectedCourse", this.response[idx]);
      this.$emit("update:step", this.step + 1);
    }
  },
  created() {
    this.getCourseList();
  }
};
</script>

<style scoped>
</style>