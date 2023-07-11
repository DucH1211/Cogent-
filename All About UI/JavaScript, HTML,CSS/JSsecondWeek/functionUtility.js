// let number = [12,14,15,17,18,54];
// a = number.filter(x=>x%3===0);
// console.log(a);
// b = number.filter(x=>x%3==0).reduce((x,y)=>x+y);
// console.log(b);
//example with String

// var input = prompt("Enter something:");
input = "chandra";
let str = "Hello123 World314";
str = str.split("").filter(x=>isNaN(x));
console.log(str);

let strArray=["chandra","chandrakant","chandrashekhar","Evan"];
strArray =strArray.filter(x=>x.toLowerCase().startsWith(input));
console.log(strArray);


// let strA = ["chandra","chandrakant","chandrashekhar","Evan"]; //doesnt work
// strA = strA.filter(x=>x.match(`/${input}/gi`));
// console.log(strA);

// let strBray = ["Chandra","kant","Pandey"];
// tempStr = strBray.reduce((x,y)=>x+" "+y);
// tempStrmap = strBray.map(x=>"Mr." + x);
// console.log(tempStr);
// console.log(tempStrmap);
 
// let number = [1,2,4,5,8,9,36];
// tempNum = number.forEach(x=>console.log(x*=3)); //Consumer
