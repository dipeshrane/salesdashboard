'use strict';

describe('Controller: ParticipantCtrl', function () {

  // load the controller's module
  beforeEach(module('dashboardApp'));

  var ParticipantCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ParticipantCtrl = $controller('ParticipantCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
