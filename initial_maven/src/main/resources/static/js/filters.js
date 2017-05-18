angular.module('kahveciEfendi').filter('makeDigits', function() {
  return function(input) {
    return input.toLocaleString();
  };
});

