//noinspection JSUnresolvedFunction
/**
 * Created by rinoux on 2017/1/19.
 */


var events = require('events');
var fs = require('fs');

fs.readFile('text.txt', function (err, data) {
    if (err) {
        console.log('error while reading file');
        return;
    }
    console.log(data.toString());
})

var eventEmitter = new events.EventEmitter();

var connectHandler = function connect() {
    console.log('connected!');
    eventEmitter.emit('data_received');
}

eventEmitter.on('connection', connectHandler);
eventEmitter.on('data_received', function () {
    console.log('data received successfully!')
});

eventEmitter.emit('connection');
console.log('program executed!');