/**
 * Created by rinoux on 2017/1/19.
 */


var events = require('events');

var eventsEmitter = new events.EventEmitter();

eventsEmitter.on('event_name', function (arg1, arg2) {
    console.log('this is event listener', arg1, arg2);
});

eventsEmitter.addListener('event_name', function (arg1, arg2) {
   console.log('this is listner by add', arg1, arg2);
});

eventsEmitter.emit('event_name', 'idiot', 'fool');
