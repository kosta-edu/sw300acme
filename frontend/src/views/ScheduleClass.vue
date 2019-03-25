<template>
  <div>
    <h2>{{selectedCourse.title}}</h2>
    <v-expansion-panel>
      <v-expansion-panel-content v-for="(item, i) in classes" :key="i" class="grey lighten-4">
        <div slot="header">
          <h3>
            CLASS {{ item.id }}
            <v-chip label color="primary" text-color="white">{{ item.status }}</v-chip>
            <v-chip label outline color="primary">
              <v-icon left>supervisor_account</v-icon>
              {{ item.evaluationRate }} %
            </v-chip>
          </h3>
        </div>
        <v-card>
          <v-card-text v-if="item.classDayList.length > 0">
            <v-card v-for="(classes, j) in item.classDayList" :key="j">
              <v-list subheader style="padding: 15px;">
                <h2>Number : {{ classes.number }}</h2>
                Date : {{ classes.date | moment("YYYY-MM-DD") }}
                <br>
                Start time : {{ classes.startTime | moment("HH:mm:ss") }}
                <br>
                End time : {{ classes.endTime | moment("HH:mm:ss") }}
                <br>
                Instructor pay : {{ classes.instructorPay }}
                <br>
              </v-list>
              <v-card-actions>
                <v-btn flat color="primary" @click="selectClass(i, j)">Select</v-btn>
              </v-card-actions>
              <v-divider></v-divider>
            </v-card>
          </v-card-text>
          <v-card-text v-else>Do not exist classes.</v-card-text>
        </v-card>
      </v-expansion-panel-content>
      <span v-if="classes.length <= 0">
        <h3>Do Not Exist Classes.</h3>
      </span>
    </v-expansion-panel>
  </div>
</template>

<script>
export default {
  name: "ScheduleClass",
  props: {
    selectedCourse: null,
    selectedClass: null,
    step: 0
  },
  data() {
    return {
      courseId: 0,
      classes: [],
      errors: []
    };
  },
  methods: {
    selectClass(i, j) {
      this.$emit("update:selectedClass", this.classes[i].classDayList[j]);
      this.$emit("update:step", this.step + 1);
    }
  },
  created() {
    const idxArr = this.selectedCourse._links.self.href.split("/");
    if (idxArr.length > 0) {
      this.courseId = idxArr[idxArr.length - 1];
      this.axios
        .get("/schedule-service/course-clazzes?courseId=" + this.courseId)
        .then(res => {
          this.classes = res.data;
        })
        .catch(e => this.errors.push(e));
    }
  }
};
</script>

<style scoped>
</style>