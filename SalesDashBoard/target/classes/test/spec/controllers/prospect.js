'use strict';

describe('Controller: ProspectCtrl', function () {

  // load the controller's module
  beforeEach(module('dashboardApp'));

  var ProspectCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ProspectCtrl = $controller('ProspectCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
