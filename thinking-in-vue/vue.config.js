module.exports = {
  runtimeCompiler: true,
  lintOnSave: false,
  devServer: {
    port: 8080,
    disableHostCheck: true
  },
  productionSourceMap: process.env.NODE_ENV != 'production',
  css: {
    sourceMap: process.env.NODE_ENV != 'production'
  },
  // 以下是pwa配置
  pwa: {
    iconPaths: {
      favicon32     : 'favicon.png',
      favicon16     : 'favicon.png',
      appleTouchIcon: 'favicon.png',
      maskIcon      : 'favicon.png',
      msTileImage   : 'favicon.png'
    }
  }
}
