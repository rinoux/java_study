/**
 * Created by rinoux on 2017/2/13.
 */

var Person = {
    name : 'Tom',
    birthDate : new Date('1990-08-12'),
    gender : 'male',
    getAge : function () {
        var today = new Date();
        var diff = today.getTime() - this.birthDate.getTime();
        var year = 1000 * 60 * 60 *24 * 365.25;
        return Math.floor(diff / year)
    },
    extend:function (info) {
        var tmp = Object.create(this);
        for (var key in info) {
            if (info.hasOwnProperty(key)) {
                tmp[key] = info[key];
            }
        }
        return tmp;
    }
};

var Teacher = Person.extend({
    job : 'teacher',
    subject : 'math',
    yearsExp : 4
});



var mat = Object.create(Person);//从原型创建对象第一种方式
mat.name = 'Mat';
mat.married = 'no';
mat.birthDate = new Date('1988-09-06');

mat.gender = 'male';

console.log(mat.getAge());

var terry = Person.extend({
    name : 'Terry',
    gender : 'female',
    birthDate : new Date('1993-01-03')
});

console.log(terry.getAge());
console.log(mat.married);

console.log(Person.isPrototypeOf(Teacher));//true

var patrick = Teacher.extend({
    name : 'Patrick',
    birthDate : new Date('1978-11-23')
});

console.log(Teacher.isPrototypeOf(patrick));
console.log(Person.isPrototypeOf(patrick));
console.log(terry.isPrototypeOf(patrick));

console.log(patrick.subject);