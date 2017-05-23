/**
 * Created by rinoux on 2017/2/13.
 */

var obj1 = new Object()

obj1.name = 'obj1'
obj1.describe = function () {
    console.log('I am ' + this.name)
}

var obj2 = {
    name : 'obj2',
    describe : function () {
        console.log('I am ' + this.name)
    }
}
obj1.describe()
obj2.describe()

//var obj3 = Object.preventExtensions(obj2)
var obj3 = obj2


obj3.extra = function () {
    console.log('I am extended')
}

obj3.name = 'obj3'
obj3.describe()

//注意还有defineProperties
Object.defineProperty(obj3, 'greeting', {get:function () {
    return 'hello world'
}})

console.log(obj3.greeting)

