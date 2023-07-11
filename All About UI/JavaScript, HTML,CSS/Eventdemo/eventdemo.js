function onclicktext()
{
    document.getElementById('h1').innerHTML = "Text Clicked";
}
function displayDate()
{
    let date = new Date();
    document.getElementById('h1').innerHTML = date.toISOString(); 
}
function checkCookies(){
    let cookie = "";
    if(navigator.cookieEnabled===true)
        cookie = "enabled";
    else cookie = "disabled";
    document.getElementById('cookie').innerHTML = cookie;
}
function changeText()
{
    t1 = document.getElementById('t1').value;
    t1= t1.toLowerCase();
    document.getElementById('h1').innerHTML = t1;
}
function change(){
    document.getElementById('b2').style.backgroundColor = 'red';
}