'use strict';

describe('Controller: EmailsListCtrl', function () {

  // load the controller's module
  beforeEach(module('dashboardApp'));

  var EmailsListCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    EmailsListCtrl = $controller('EmailsListCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
