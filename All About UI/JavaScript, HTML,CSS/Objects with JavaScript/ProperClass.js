module.exports = class person{
    static count = 0;
    constructor(_id,_name,_age)//this is constructor overriding. it already have an constructor
    {   
        this._id=id;
        this._age = age;
        this._name = name;
    }
    
    display(){ // you can make your function private too.
        console.log(this._id);
    }

    static put(){
        console.log("static method ran.");
    }
}

// const p = new person(1,"ABAIJSD",43); //const dont allow you to change the reference. doesnt make object immutable

// p.display();
// person.put(); //static function same as java.
// // console.log("age:" + p.#age); not allowed
// console.log(person.count);
// // export {person};