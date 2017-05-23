/**
 * Created by rinoux on 2017/2/14.
 */

function getModule() {
    var FOO = {};//FOO就是一个模块

    FOO.x = 10;

    FOO.addEmUp = function (x, y) {
        return x + y;
    };

    var events = [];
    FOO.addEvents = function (eventName, target, fn) {
        events.push({
            eventName : eventName,
            target : target,
            fn : fn
        })
    };

    FOO.listEvents = function (eventName) {
      return events.filter(eventObj => eventObj.eventName === eventName)
    };

    return FOO;
}

var myNameSpace = getModule();

myNameSpace.addEvents('a');
console.log(myNameSpace.listEvents('a'));