
/**
 * 2.Function Expression
 * @param   :name
 * @return  :name
*/
add1=function(name)
{
    console.log(name);
    return name;
}
let a = add1("ABC");

/** 
 * Arrow Function
 * @param   :...name
 * @return  : name
*/
add2 = (...name)=>{ 
    console.log("arrow function expression runs");
    console.log(name);
    return name;
}

result = add2("BCD","AOSID");

name1 = ['Chandra','Mahesh'];
result = add1(...name1); //spread operator, this depends on which function accepts iterable params
result = add2(...name1);
abc = "asasoidoi";
result = add2(abc); //this will not turn abc into iterable but as a single object
result = add2(...abc); //... will turn abc into iterable

result = add1(abc);
result = add2(abc);

//spread only accept iterable
//noniterable will not work: //this below will make error.
// anum = 123; 
// result = add2(...anum);

