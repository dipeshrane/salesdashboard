'use strict';

describe('Controller: ParticipantListCtrl', function () {

  // load the controller's module
  beforeEach(module('dashboardApp'));

  var ParticipantListCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ParticipantListCtrl = $controller('ParticipantListCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
