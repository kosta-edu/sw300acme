<template>
    <div class="get-course">
        <v-btn color="primary" @click="getCourseList">GetVenu</v-btn>
        <v-list>
            <v-list-group
                    v-for="(item, idx) in response"
                    :key="idx"

                    no-action
            >
                <v-list-tile slot="activator">
                    <v-list-tile-content>
                        <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                    </v-list-tile-content>
                </v-list-tile>

                <v-list-tile>
                    <v-list-tile-content>
                        <v-list-tile-title>{{ item.description }}</v-list-tile-title>
                        <v-btn color="primary" @click="selectCourse(idx)">Select</v-btn>
                    </v-list-tile-content>
                </v-list-tile>
            </v-list-group>
            <span v-if="response.length <= 0">Please, get venu!</span>
        </v-list>
    </div>
</template>

<script>
    export default {
        name: "GetCourse",
        props: {
            selectedCourse: null,
            step: 0,
        },
        data() {
            return {
                response: [],
                errors: [],
            }
        },
        methods: {
            getCourseList () {
                axios.get('http://localhost:8080/courses')
                    .then((res) => {
                        this.response = res.data._embedded.course;
                    })
                    .catch(e => this.errors.push(e));
            },
            selectCourse(idx) {
                this.$emit('update:selectedCourse', this.response[idx]);
                this.$emit('update:step', this.step + 1);
            }
        }
    }
</script>

<style scoped>

</style>