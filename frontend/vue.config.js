module.exports = {
    devServer: {
        host: 'localhost',
        proxy: {
            '^/(api)': {
                target: process.env.VUE_APP_API_SERVER,
                changeOrigin: true
            }
        }
    }
}