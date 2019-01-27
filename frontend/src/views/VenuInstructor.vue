<template>
    <div>
        <h2>{{selectedCourse.title}}</h2>
        <h3><span class="group pa-2"><v-icon>fiber_manual_record</v-icon></span>Venu</h3>
        <v-select
                :items="venus"
                label="Select Venus"
                item-text="name"
                item-value="_links.self.href"
                v-model="selectedVenu"
                solo
        ></v-select>
        <h3><span class="group pa-2"><v-icon>fiber_manual_record</v-icon></span>Instructor</h3>
        <v-select
                :items="instructors"
                label="Select Instructor"
                item-text="name"
                item-value="_links.self.href"
                v-model="selectedInstructor"
                solo
        ></v-select>
        <v-btn color="primary" @click="initPage">Complete</v-btn>
    </div>
</template>

<script>
    export default {
        name: "VenuInstructor",
        props: {
            selectedCourse: null,
            selectedClass: null,
            step: 0,
        },
        data() {
          return {
              venus: [],
              instructors: [],
              selectedVenu: null,
              selectedInstructor: null,
              classId: null,
          }
        },
        watch: {
            selectedVenu(value) {
                const idxArr = value.split('/');
                axios.post('http://localhost:8080/schedule-service/associate-venu', {
                    classDayId: Number(this.getClassId()),
                    venuId: Number(idxArr[idxArr.length-1]),
                }).then(() => {
                    alert('selected venu!');
                }).catch((error) => {
                    console.log(error);
                });
            },
            selectedInstructor(value) {
                const idxArr = value.split('/');
                axios.post('http://localhost:8080/schedule-service/associate-instructor', {
                    classDayId: Number(this.getClassId()),
                    instructorId: Number(idxArr[idxArr.length-1]),
                }).then(() => {
                    alert('selected instructor!');
                }).catch((error) => {
                    console.log(error);
                });
            },
        },
        methods: {
            getClassId() {
                if (this.classId === null) this.classId = this.selectedClass.id;
                return this.classId;
            },
            initPage() {
                this.$emit('update:step', 1);
            },
        },
        created() {
            axios.get('http://localhost:8080/venus')
                .then((res) => {
                    this.venus = res.data._embedded.venu;
                })
                .catch(e => this.errors.push(e));
            axios.get('http://localhost:8080/instructors')
                .then((res) => {
                    const instructors = res.data._embedded.instructor;
                    for (let i = 0; i < instructors.length; i ++) {
                        instructors[i] = { ...instructors[i], name: instructors[i].firstName + instructors[i].lastName };
                    }
                    this.instructors = instructors;
                })
                .catch(e => this.errors.push(e));
        }
    }
</script>

<style scoped>

</style>