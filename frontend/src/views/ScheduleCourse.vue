<template>
    <div class="schedule-course">
        <h1>Make a course schedule</h1>
{{step}}
        <get-course v-if="step === 1" :selectedCourse.sync="selectedCourse" :step.sync="step"></get-course>{{selectedCourse}}
        <schedule-class v-if="step === 2"></schedule-class>
    </div>
</template>

<script>
    import GetCourse from "./GetCourse";
    import ScheduleClass from "./ScheduleClass";

    export default {
        name: "schedule-course",
        components: {ScheduleClass, GetCourse},
        data() {
            return {
                step: 1,
                selectedCourse: null,
                errors: [],
            }
        },
        methods: {
        }
    }
</script>

<style scoped>
</style>