let str1 = "Chandra is a 'Java FullStack Trainer'"; 
let str2 = 'Chandra is a "Java FullStack Trainer"';
let str3 = "Chandra is a \"Java FullStack Trainer\""; //excape character is the same with java

//template literal
let str4 = `String "that supports 
    multiple lines but does it )(*&*@HN(#*@! _RJ AAS>D
        "@_O@_!E*TF
        @RJ@#)(T QW:D{QE@!!@"W>?}@?E!@+_!@+( @Y &T$&T^SMALC?> ?~))))
    print the same way in the console????`; //you acn use anydouble quote or single qoute here
console.log(str4);
let A = new String ("ABCDEFG");
let B = new String ("ABCDEFG");
let C = "ABCDEFG";
let D = "ABCDEFG";
console.log(A == B); //false these two are two different objects with field of same value
console.log(C == D); //true // they are comparing the value and they are the same 
console.log(A == D); //true //they are comparing the value and they are the same
console.log(A === D); //false they different data types
console.log(A.length); 
console.log(C.slice(-8,-3,4));
console.log(str1.replace("Chandra","Chandrakant")); //only replace the first occurence
console.log(str2.split(" ")); // you can use regular expression here :)