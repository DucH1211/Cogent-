//same chars different order same length: "abcd" "bacd" 
function areAnagram(str1,str2)
    {
        let n1 = str1.length;
        let n2 = str2.length;
        if (n1 != n2)
            return false;

        sample1 = str1.split("");
        sample2 = str2.split("");
        sample1.sort();
        sample2.sort();
        // console.log(sample1);
        // console.log(sample2);
        // Compare sorted strings
        for (let i = 0; i < n1; i++)
            if (sample1[i] != sample2[i])
                return false;
   
        return true;
    }
let test1 = "ABCD";
let test2 = "BCAD";
console.log(areAnagram(test1,test2));