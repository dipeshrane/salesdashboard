'use strict';

describe('Service: participant', function () {

  // load the service's module
  beforeEach(module('dashboardApp'));

  // instantiate service
  var participant;
  beforeEach(inject(function (_participant_) {
    participant = _participant_;
  }));

  it('should do something', function () {
    expect(!!participant).toBe(true);
  });

});
