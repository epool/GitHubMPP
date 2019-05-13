const autoprefixer = require('autoprefixer');

config.module.rules.push({
    test: /\.(sa|sc|c)ss$/,
    use: [
        {
            loader: 'file-loader',
            options: {
                name: '[name].bundle.css',
            },
        },
        {
            loader: 'extract-loader'
        },
        {
            loader: 'css-loader'
        },
        {
            loader: 'postcss-loader',
            options: {
                plugins: () => [autoprefixer()],
            },
        },
        {
            loader: 'sass-loader',
            options: {
                includePaths: ['./node_modules']
            }
        }
    ]
});