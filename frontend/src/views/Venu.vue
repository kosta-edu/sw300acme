<template>
    <div class="venu">
        <h1>Venu</h1>
        <v-btn color="primary" @click="getVuneList">GetVenu</v-btn>
        <h2>{{ response }}</h2>
    </div>
</template>

<script>
    export default {
        name: "venu",

        data() {
            return {
                response: [],
                errors: []
            }
        },
        methods: {
            getVuneList () {
                axios.get('http://localhost:8080/venus')
                    .then(response => {
                        this.response = response.data;
                    })
                    .catch(e => {
                        this.errors.push(e);
                    })
            }
        }
    }
</script>

<style scoped>

</style>