const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
        '/courses',
        createProxyMiddleware({
            target: 'http://localhost:8080',
            changeOrigin: true,
            logLevel: 'debug', // Enables detailed logs
            onProxyReq: (proxyReq, req) => {
                console.log(`[Proxy Request] ${req.method} ${req.url}`);
            },
            onProxyRes: (proxyRes, req, res) => {
                console.log(`[Proxy Response] ${proxyRes.statusCode} ${req.url}`);
            },
            onError: (err, req, res) => {
                console.error('[Proxy Error]', err.message);
            },
        })
    );
};
