'use strict';

describe('Service: prospect', function () {

  // load the service's module
  beforeEach(module('dashboardApp'));

  // instantiate service
  var prospect;
  beforeEach(inject(function (_prospect_) {
    prospect = _prospect_;
  }));

  it('should do something', function () {
    expect(!!prospect).toBe(true);
  });

});
