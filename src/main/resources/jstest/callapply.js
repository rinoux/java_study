/**
 * Created by rinoux on 2017/2/13.
 */
function add(x, y) {
    this(x, y) //若是add.call(sub, 3, 1)，这里this为sub因此会输出2
    console.log(x + y) //这里正常调用输出4
}

function sub(x, y) {
    console.log(x - y)
}

add.call(sub, 3, 1) //call表示调用add函数的上下文this为sub，后面的参数列表随便
add.apply(sub, [3, 1]) //和call输出一致，区别在用apply第二个参数必需是数组

