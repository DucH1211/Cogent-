
function check_palindrome(str) {
    let j = str.length - 1;
    for (let i = 0; i < j / 2; i++) { 
        let x = str[i];//first half
        let y = str[j - i];//other half
        if (x != y) {
            return false;
        }
    }
    return true;
 
}
 
function is_palindrome(str) {
    let ans = check_palindrome(str);
    if (ans == true) {
        console.log("is palindrome ");
    }
    else {
        console.log("is not palindrome");
    }
}


let test = 123321; //can be both number or string.
is_palindrome(test);