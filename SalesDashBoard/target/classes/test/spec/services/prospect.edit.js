'use strict';

describe('Service: prospect.edit', function () {

  // load the service's module
  beforeEach(module('dashboardApp'));

  // instantiate service
  var prospect.edit;
  beforeEach(inject(function (_prospect.edit_) {
    prospect.edit = _prospect.edit_;
  }));

  it('should do something', function () {
    expect(!!prospect.edit).toBe(true);
  });

});
