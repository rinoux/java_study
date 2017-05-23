/**
 * Created by rinoux on 2017/2/13.
 */

class Person {
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }

    toString() {
        return this.name + 'is ' + this.age +': years old';
    }
}

var terry = new Person('Terry', 23, 'programmer');
console.log(terry.toString());


class Student extends Person {
    constructor(name, age, grade) {
        super(name, age);
        this.grade = grade;
    }

    toString(){
        return super.toString() + ', '+ this.grade + ' grade.'
    }

    static mySchool() {
        return 'Queensland first primary school';
    }
}

var mick = new Student('Mick', 12, 5);
console.log(mick.age);
console.log(Student.mySchool())
