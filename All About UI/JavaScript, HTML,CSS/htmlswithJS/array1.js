// //All about arrays in JavaScript
// const array = new Array(12,56,"array",65,32);
// console.log(array);
a1 = [12,34,56,"nums"];
const nums = a1;
// console.log(nums);
// console.log(a1);
// nums.push(75);
// console.log(nums);
// nums.pop();
// console.log(a1);
// //array in javascript is similar to arrayList
const a = [12,"Chandra",23.56,nums];
console.log(a);
console.log(typeof(a))
console.log(Array.isArray(a)); //check if it is Array or not
console.log(a instanceof Array);
console.log("Length:" + a.length);
console.log("Access at index 0: " + a[7]); //undefined
console.log(a.length);
a[7] = 6;
// console.log(a.length);
// console.log();
console.log("For loop")
for(let i = 0; i < a.length; i ++)
{
    console.log(a[i]);
}
console.log("For in loop (foreach)")
for(let i in a)
{
    console.log(a[i]);
}

a2 = {id:3,name:"chandra",age:45};
console.log("For in loop")
for(let i in a2)
{
    console.log(i);
    console.log(a2[i]);
}
// for(let i of a2) {}//for each iterable
i = 0;
while(i < a.length){
    console.log(a[i]);
    i++;
}