// a = "chandra";
// var a; //hoisting
// let a; //does not allow hoisting or redeclaration
let a = 0; 
const b = 12;
function get(){
    // a ="abc";
    console.log(a);
}
get();
// var a = 2; //let stop this from happening
// var b; //constant does not allow modification at all. include redeclaration
console.log(a);