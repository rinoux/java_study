/**
 * Created by rinoux on 2016/11/28.
 */

var newObj = {
    name : '',
    getName : function () {
        return this.name
    },
    setName : function (name) {
        this.name = name
        console.log(this)
    },
    print : function (t) {
        alert(t)
    }
}

newObj.setName("hello")