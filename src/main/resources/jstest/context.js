/**
 * Created by rinoux on 2017/2/10.
 */

function setFoo(fooInput) {
    this.foo = fooInput
}

var foo = 5;

console.log('foo at the window level is set to:' + foo)//5

var obj = {
    foo : 10
}

console.log('foo inside obj is set to:' + obj.foo)//10

setFoo(15)

console.log('now at window level foo is set to :' + foo) //在浏览器环境下foo此时为15， 在当前直接运行，依旧为5

obj.setFoo = setFoo
obj.setFoo(20)
console.log('foo inside of obj is now set to :'+ obj.foo) //20


function sendMsg(arg1, arg2) {
    if (arguments.length === 2) {
        console.log('suitable params count')
    } else {
        console.log('params count error')
    }
}

sendMsg('hello')
sendMsg('hi', 'shabi')