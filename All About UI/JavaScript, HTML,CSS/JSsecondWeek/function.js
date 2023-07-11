// //function declaration
// function get(name)
// {
//     if(typeof name==='string')
//     {
//         if(isNaN(name))
//         {
//             return "This String is not a Number, try using isNaN(is Not a Number)"
//         }
//         console.log("Get function runs");
//         return name;
//     }else
//         return "Notthing to do here";
    
// }
// let a = get("String"); //this is acceptable, user have to take care of parameters,
// //compiler wont be able to do it for ya :(
// console.log("A: " + a);

function exponent(multiply)  //a function that takes a function as a parameter.
{
    exp = multiply(multiply.a,multiply.b)**2;
    return exp; //you can return a function type.
}
function multiply(a,b)
{
    return a*b;
}
let result = exponent(multiply(4,5));
console.log(result);
result(multiply);