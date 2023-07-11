//another way:
// const person = new Object();
// person.id = 21;
// person.id = 32; //overriding it will change the value
// person.name = "Chandra";
// person.age = 45;
// person.gender = "Male";
//...
// person.getAge = function(){
//     return this.age;
// };
//You can add as many property as you like using this syntax.


//old way easy, confusing way
const person = {id:21,name:'Chandra',age:45,
    getAge(){
        return this.age;
    },
    toString(){
        return `id: ${this.id} \nname: ${this.name} \nage: ${this.age}`;
    }
};
person.id = 2344;
person['name'] = 'Chandrakant';
age = 'newAge';
person[`${age}`] = 23;
console.log(person);
console.log(person.toString());
console.log(typeof person);