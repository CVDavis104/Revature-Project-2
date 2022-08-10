
let submitButtom = document.getElementById("signup-button");

submitButtom.addEventListener("click", (event)=> {
event.preventDefault();

let xhttp = new XMLHttpRequest

let firstname = document.getElementById("firstName-input").value;
let lastname = document.getElementById("lastName-input").value;
let mobilenumber = document.getElementById("mobilenumber-input").value;
let address = document.getElementById("address_input").value;
let email = document.getElementById("email-input").value
let username = document.getElementById("username-input").value;
let password = document.getElementById("password-input").value;
let country = document.getElementById("country-input").value;
let State = document.getElementById("State-input").value;
let zipcode = document.getElementById("Zaipcode-input").value;



// let add = address + state + country + zipcode;(concat this)





let signupInfo = {
firstname:firstname,
lastname:lastname,
mobilenumber: mobilenumber,
address: address,
email:email,
zipcode: zipcode,
password: password,
country: country,
State: State,



}


console.log(signupInfo);

function add(){ address + State + country + zipcode;
}

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

