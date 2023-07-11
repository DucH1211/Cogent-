// Function to check prime number
function p() {
             
    var n, i, flag = true;
    n = 17;
    for(i = 2; i <= n - 1; i++)
        if (n % i == 0) {
            flag = false;
            break;
        }
         
        // Check and display alert message
    if (flag == true)
        console.log(n + " is prime");
    else
    console.log(n + " is not prime");
}
p();