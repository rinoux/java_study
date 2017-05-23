/**
 * Created by rinoux on 2017/2/15.
 */


var myModule = (function () {
    var events = [];

    return {//返回的对象，包含变量和函数
        x : 10,
        addEmUp : function (x, y) {
            return x + y;
        },
        addEvents : function (eventName, target, fn) {
            events.push({eventName : eventName, target : target, fn : fn})
        },
        listEvents : function (eventName) {
            return events.filter(evtObj => evtObj.eventName === eventName);
        }
    }
})();

var myModule2 = (function ($) {
    var events = [];

    return {//返回的对象，包含变量和函数
        x : 10,
        addEmUp : function (x, y) {
            return x + y;
        },
        addEvents : function (eventName, target, fn) {
            events.push({eventName : eventName, target : target, fn : fn});
            $(target).on(eventName, fn);
        },
        listEvents : function (eventName) {
            return events.filter(evtObj => evtObj.eventName === eventName);
        }
    }
})(jQuery);

console.log(myModule2.x)

console.log(myModule.x === 10)