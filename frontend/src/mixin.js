const mixin = {
    methods: {
        destroyToken() {
            localStorage.removeItem('RR-Token')
            localStorage.removeItem('RR-UID')
        },
        checkUnauthorized(error) {
            const status = error.response.status
            if (status !== 401) return
            this.destroyToken()
            this.$router.push({name: 'signin'})
        }
    }
}

export default mixin