/**
 * Created by rinoux on 2017/2/10.
 */


var items = ['one', 'two', 'three'];
var itemsRefer = items //一个引用不能指向另外一个引用，这里itemsRefer实际上指向的是['one', 'two', 'three']这个数组

items = ['two', 'three'] //更改了items的指向

console.log(items == itemsRefer) //false
/*********************************************************************/
var str = 'hello '
var strRefer = str

str += 'world' //和java一样，这里重新创建了一个字符串对象，而原对象不会发生改变

console.log(str == strRefer)//false
/*********************************************************************/

var foo = 'test'//全局变量，在基于js的浏览器里实际上是作为window 对象的属性存在，使用window.foo可以调用到；在这里foo属于全局上下文

if (true) {
    var foo = 'new test'//此处不是函数，只是个语句块，处于全局作用域
}

console.log(foo) //new test

function test() {
    var foo = 'func test' //函数有自己的作用域，这里已经进入到函数的作用域，没办法更改全局变量
}

test()

console.log(foo) //new test

/*********************************************************************/




