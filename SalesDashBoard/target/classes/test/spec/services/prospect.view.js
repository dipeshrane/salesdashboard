'use strict';

describe('Service: prospect.view', function () {

  // load the service's module
  beforeEach(module('dashboardApp'));

  // instantiate service
  var prospect.view;
  beforeEach(inject(function (_prospect.view_) {
    prospect.view = _prospect.view_;
  }));

  it('should do something', function () {
    expect(!!prospect.view).toBe(true);
  });

});
