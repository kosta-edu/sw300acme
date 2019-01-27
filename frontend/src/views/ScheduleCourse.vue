<template>
    <div class="schedule-course">
        <h1>Make a course schedule</h1>
        <get-course v-if="step === 1" :selectedCourse.sync="selectedCourse" :step.sync="step"></get-course>
        <schedule-class v-if="step === 2" :selectedCourse="selectedCourse" :selectedClass.sync="selectedClass" :step.sync="step"></schedule-class>
        <venu-instructor v-if="step === 3" :selectedCourse="selectedCourse" :selectedClass.sync="selectedClass" :step.sync="step"></venu-instructor>
    </div>
</template>

<script>
    import GetCourse from "./GetCourse";
    import ScheduleClass from "./ScheduleClass";
    import VenuInstructor from "./VenuInstructor";

    export default {
        name: "schedule-course",
        components: {VenuInstructor, ScheduleClass, GetCourse},
        data() {
            return {
                step: 1,
                selectedCourse: null,
                selectedClass: null,
                errors: [],
            }
        },
        methods: {
        }
    }
</script>

<style scoped>
</style>