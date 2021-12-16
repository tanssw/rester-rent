const mixin = {
    methods: {
        destroyToken() {
            localStorage.removeItem('RR-Token')
            localStorage.removeItem('RR-UID')
        }
    }
}

export default mixin