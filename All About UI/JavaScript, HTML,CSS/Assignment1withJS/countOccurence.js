function count(s, c)
    {
        let r= 0;
 
        for (let i = 0; i < s.length; i++)
        {
            if (s.charAt(i) == c)
            r++;
        }
        return r;
    }

let test = "ABCDAEFGABCDAEFG";
console.log(count(test,'A'));