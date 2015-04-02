'use strict';

describe('Controller: EmailsEditCtrl', function () {

  // load the controller's module
  beforeEach(module('dashboardApp'));

  var EmailsEditCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EmailsEditCtrl = $controller('EmailsEditCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
