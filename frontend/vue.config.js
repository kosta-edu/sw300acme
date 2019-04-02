module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://acmeapi:8090',
                ws: true,
                changeOrigin: true
            }
        }
    },
    outputDir: 'target/dist',
    assetsDir: 'static'
}