
let submitButtom = document.getElementById("signup-button");

submitButtom.addEventListener("click", (event)=> {
event.preventDefault();

let xhttp = new XMLHttpRequest

let firstname = document.getElementById("firstName-input").value;
let lastname = document.getElementById("lastName-input").value;
let mobilenumber = document.getElementById("mobilenumber-input").value;
let email = document.getElementById("email-input").value
let password = document.getElementById("password-input").value;



// let add = address + state + country + zipcode;(concat this)





let signupInfo = {
firstname:firstname,
lastname:lastname,
mobilenumber: mobilenumber,
email:email,
password: password,



}


console.log(signupInfo);



xhttp.onreadystatechange = function(){

    if(this.readyState == 4 && xhttp.status == 200){

        console.log(xhttp.responseText);


window.location.replace("index.html")


} else if(this.readyState == 4 && xhttp.status === 204){
    console.log(xhttp.responseText)
    console.log ()
    alert("Failed.Status Code:"+ xhttp.status)
}
};


xhttp.open("POST",`http://localhost:8080/HoroscopeApp/signUp`)

xhttp.setRequestHeader("Content-Type","application/json");
xhttp.setRequestHeader("Access-Control-Allow-Origin","*");
xhttp.send(JSON.stringify(signupInfo));
});

