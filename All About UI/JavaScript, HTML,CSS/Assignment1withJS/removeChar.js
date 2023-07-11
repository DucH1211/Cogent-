function removeChar(s, c)
{
    let j, count = 0, n = s.length;
    let t = s.split(""); //split chars into a char array
     
    for(let i = j = 0; i < n; i++)
    {
        if (t[i] != c)
            t[j++] = t[i];
        else
            count++;
    }
      
    while (count > 0)
    {
        t[j++] = '';
        count--;
    }
    console.log(t.join("")); //.join concat everything splitted
}

let s = "oqifqoiwjoqwijd";
removeChar(s,'i');
console.log(s);

