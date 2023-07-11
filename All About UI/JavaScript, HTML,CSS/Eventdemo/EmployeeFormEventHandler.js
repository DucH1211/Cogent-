document.addEventListener('DOMContentLoaded',()=>
{
    const form = document.getElementById('studentForm');
    console.log(form);
    if(form)
    form.addEventListener("submit", validateForm);
})
function validateForm(event){
    //preferable using querySelectAll Here? -- foreach here
    let firstname = document.getElementById('firstName');
    let lastname = document.getElementById('lastName');
    let email = document.getElementById('email');
    let gender = document.getElementsByName('gender');
    let age = document.getElementById('age');
    let education = document.getElementById('education');
    // let dob = document.getElementById('dob'); //not used here
    if(!validateEmail(email)
    ||!validateRadio(gender)
    || !validateNumber(age))
    {
        document.getElementById('message2').innerHTML = "Form Submit Fail";
        alert("fail to submit");
    }else{
        document.getElementById('message').innerHTML = "Message Here:";
        document.getElementById('message2').innerHTML ="Form Submit Success";
        alert("submit success");
    }
}
function validateRadio(element)
{
    var valid = false;
    var i = 0;
    while(!valid && i < element.length)
    {
        if(element[i].checked) valid = true;
        i++;
    }
    if(!valid) {
        alert('Must checked a value: ' + element.value.toUpperCase());
        document.getElementById('message').innerHTML = "Gender not Checked";
    }
    return valid;
}
function validateEmail(element)
{
    var regexPattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if(!regexPattern.test(element.value))
        {   
            alert("invalid email");
            document.getElementById('message').innerHTML = "Invalid Email";
            return false;
        }
    return true;
}
function validateNumber(element){
    if(typeof element.value == "number")
        {
            alert("not a number");
            document.getElementById('message').innerHTML = "Invalid Input Type, Not a Number";
            return false;
        }
    return true;
}
// function validateTextBox(element){
//     if(element.value.trim()==="")
//     {
//         text1 = element.name;
//         document.getElementById('message').innerHTML = "TextBox is Empty " + text1;
//         alert(text1.toUpperCase() + " Text Box is Empty");
//         return false;
//     }
//     return true;
// }
// function buttonClickedTest(){
    
//     document.getElementById("message").innerHTML = "Button Clicked!";
// }

// form validation with eventListener
// ...
