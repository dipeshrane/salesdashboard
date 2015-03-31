'use strict';

describe('Controller: ProspectViewCtrl', function () {

  // load the controller's module
  beforeEach(module('dashboardApp'));

  var ProspectViewCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProspectViewCtrl = $controller('ProspectViewCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
