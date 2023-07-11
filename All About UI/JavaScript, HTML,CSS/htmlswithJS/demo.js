console.log("hi"); //Scripting Language
age =23;
console.log(typeof(age))
age = 23.5;
console.log(typeof(age)) //number type is for all numbers
age = "chandra";
console.log(typeof(age));
age = 'chandra';
console.log(typeof(age)); //both "" or '' is considered string
age = true;
console.log(typeof(age));
age = false;
console.log(typeof(age));
var a = null;
console.log(a)
a = BigInt(222656666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666);
console.log(a);
a =Symbol('ABC');
console.log(a);
console.log("Chandra" + 2 + 3)
console.log(2+3 + "Chandra");
//1.number type
//2. string
//3. boolean
//4. undefined
//5. null
//6. Null
//7. Bigint
//Symbol : like ENUM final variable

//operator
//+,-,/,*, ++,--,**
//Assignment new: **=
// ===, !==, 

//Example of == in javascript;\
a='2',b = 2;
console.log(a==b) //this is true
console.groupCollapsed(a===b) //this is false strict comparison
//4. logical operator (&&, ||, !)
//instanceof(), typeof():  type operators
//Bitwise Operator 
//(&,|,~,<<,>>,<<,>>>)