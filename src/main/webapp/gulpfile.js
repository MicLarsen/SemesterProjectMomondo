var gulp = require('gulp');
var p = require('gulp-load-plugins')();


gulp.task('styles', function () {
    return gulp.src(['assets/sass/**/*.scss', 'app/**/*.scss'])
        .pipe(p.plumber())
        .pipe(p.sass({outputStyle: 'compressed'})
            .on('error', function (err) {
                p.notify().write(err);
                this.emit('end');
            }))
        .pipe(p.autoprefixer('last 2 version'))
        .pipe(p.rename({suffix: '.min'}))
        .pipe(gulp.dest('dist/css'))
        .pipe(p.livereload())
});

gulp.task('scripts', function () {
    return gulp.src('app/**/*.js')
        .pipe(p.plumber())
        .pipe(p.babel({presets: ['es2015']}).on('error', function (err) {
            p.notify().write(err);
            this.emit('end');
        }))
        .pipe(p.concat('app.js').on('error', function (err) {
            p.notify().write(err);
            this.emit('end');
        }))
        .pipe(p.uglify({mangle: false}).on('error', function (err) {
            p.notify().write(err);
            this.emit('end');
        }))
        .pipe(p.rename({suffix: '.min'}))
        .pipe(gulp.dest('dist/js'))
        .pipe(p.livereload());
});

gulp.task('dependencies', function () {
    return gulp.src([
        'assets/components/angular/angular.js',
        'assets/components/angular-animate/angular-animate.js',
        'assets/components/angular-bootstrap/ui-bootstrap.js',
        'assets/components/angular-ui-router/release/angular-ui-router.js',
        'assets/components/ui-bootstrap-custom/ui-bootstrap-custom-tpls-2.0.2.min.js',
        'assets/components/angular-toastr/dist/angular-toastr.tpls.js'
    ])
        .pipe(p.plumber())
        .pipe(p.concat('dependencies.js').on('error', function (err) {
            p.notify().write(err);
            this.emit('end');
        }))
        .pipe(p.uglify({mangle: false}).on('error', function (err) {
            p.notify().write(err);
            this.emit('end');
        }))
        .pipe(p.rename({suffix: '.min'}))
        .pipe(gulp.dest('dist/js'));
});

gulp.task('images', function () {
    return gulp.src('assets/img/**/*')
        .pipe(p.plumber())
        .pipe(p.cache(p.imagemin({optimizationLevel: 5, progressive: true, interlaced: true})))
        .pipe(gulp.dest('dist/img'))
});

gulp.task('html', function () {
    return gulp.src([
        'app/**/*.html',
        './index.html'
    ])
        .pipe(p.livereload())
});


gulp.task('default', function () {
    gulp.start(
        'html',
        'styles',
        'scripts',
        'dependencies',
        'watch'
    );
});

gulp.task('watch', function () {

    p.livereload.listen();
    gulp.watch('app/**/*.js', ['scripts']);
    gulp.watch('assets/sass/**/*.scss', ['styles']);
    gulp.watch('app/**/*.scss', ['styles']);
    gulp.watch('app/**/*.html', ['html']);
    gulp.watch('./index.html', ['html']);
});