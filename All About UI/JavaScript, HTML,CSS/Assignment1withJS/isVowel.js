function isVowel(x) //check vowel or consonance
    {
        if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'
        ||x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U')
            return true;
        else
            return false;
    }

function countVowel(str)
{
    let v = 0, c = 0;
    for(let i = 0 ; i < str.length; i++)
    {
        if(isVowel(str[i]))
            v++;
        else
            c++;
    }
    console.log("vowel count: " + v);
    console.log("consonance count: " + c);
}

let test = "oqioqinfoibgoinlkvnbgh gnkcmvnzljv";
countVowel(test);


function countCharacterType(str) {
    var vowels = 0,
      consonant = 0,
      specialChar = 0,
      digit = 0;


    for (var i = 0; i < str.length; i++) {
        var ch = str[i];

        if ((ch >= "a" && ch <= "z") ||
        (ch >= "A" && ch <= "Z")) {
            // To handle upper case letters
            ch = ch.toLowerCase();

        if (ch == "a" || ch == "e" || ch == "i" ||
            ch == "o" || ch == "u")
            vowels++;
        else consonant++;
      } else if (ch >= "0" && ch <= "9") digit++;
      else specialChar++;

      console.log("vowel: " + vowels);
      console.log("consonant: " + consonant);
      console.log("SpecialChar: " + specialChar);
      console.log("digit: " + digit);
    }
}
let test2 = "oqioqinfoibgoinlkvnbgh gnkcmvnzljv";
countCharacterType(test2);