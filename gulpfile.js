var gulp = require('gulp');

var clean = require('gulp-clean');
gulp.task('clean', function () {
    gulp.src('./src/main/resources/static/js/*', { read: true }).pipe(clean());
    gulp.src('./src/main/resources/static/css/*', { read: true }).pipe(clean());
    gulp.src('./src/main/resources/static/webfonts/*', { read: true }).pipe(clean());
    gulp.src('./app/public/*', { read: true }).pipe(clean());
});

gulp.task('build', function () {
    gulp.src('./node_modules/jquery/dist/jquery.min.js').pipe(gulp.dest('./src/main/resources/static/js'));
    gulp.src('./node_modules/stompjs/lib/stomp.min.js').pipe(gulp.dest('./src/main/resources/static/js'));
    gulp.src('./node_modules/sockjs-client/dist/sockjs.min.js').pipe(gulp.dest('./src/main/resources/static/js'));
    gulp.src('./node_modules/bootstrap/dist/css/bootstrap.min.css').pipe(gulp.dest('./src/main/resources/static/css'));
    gulp.src('./node_modules/bootstrap/dist/js/bootstrap.min.js').pipe(gulp.dest('./src/main/resources/static/js'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/css/all.min.css').pipe(gulp.dest('./src/main/resources/static/css'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-brands-400.eot').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-brands-400.ttf').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-brands-400.woff2').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-regular-400.svg').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-regular-400.woff').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-solid-900.eot').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-solid-900.ttf').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-solid-900.woff2').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-brands-400.svg').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-brands-400.woff').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-regular-400.eot').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-regular-400.ttf').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-regular-400.woff2').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-solid-900.svg').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/@fortawesome/fontawesome-free/webfonts/fa-solid-900.woff').pipe(gulp.dest('./src/main/resources/static/webfonts'));
    gulp.src('./node_modules/popper.js/dist/umd/popper.min.js').pipe(gulp.dest('./src/main/resources/static/js'));
    gulp.src('./node_modules/datatables.net/js/jquery.dataTables.min.js').pipe(gulp.dest('./src/main/resources/static/js'));
    gulp.src('./node_modules/datatables.net-bs4/js/dataTables.bootstrap4.min.js').pipe(gulp.dest('./src/main/resources/static/js'));
    gulp.src('./node_modules/datatables.net-bs4/css/dataTables.bootstrap4.min.css').pipe(gulp.dest('./src/main/resources/static/css'));
});
