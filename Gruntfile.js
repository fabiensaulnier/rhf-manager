module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    jsbeautifier : {
      files : ["src/main/resources/html/lib/**/*.js", '!src/main/resources/html/lib/angular/*.js'],
      options : {
        js: {
          indentChar: " ",
          indentSize: 2,
          indentWithTabs: false
        }
      }
    }

  });

  // Load the plugin that provides the "uglify" task.
  grunt.loadNpmTasks('grunt-jsbeautifier');

  // Default task(s).
  grunt.registerTask('default', ['jsbeautifier']);

};