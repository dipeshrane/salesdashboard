'use strict';

describe('Controller: EmailsCtrl', function () {

  // load the controller's module
  beforeEach(module('dashboardApp'));

  var EmailsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EmailsCtrl = $controller('EmailsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
