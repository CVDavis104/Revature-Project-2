let signUpButton = document.getElementById("sign-up-btn");

signUpButton.addEventListener("click", (event) => {
    event.preventDefault();

    let xhttp = new XMLHttpRequest();

    let address = document.getElementById("address-signup").value
    let first_name = document.getElementById("fname").value
    let last_name = document.getElementById("lname").value
    let email = document.getElementById("email").value
    let username = document.getElementById('username').value
    let password = document.getElementById("password").value
    let phone = document.getElementById("number").value

    let signupInfo = {

        firstname: first_name,
        lastname: last_name, 
        email: email,
        username: username,
        password: password,
        phonenumber: phone,
        address: address
        
    }
    console.log(signupInfo);

    xhttp.onreadystatechange = function() {

        if(this.readyState == 4 && xhttp.status === 200){
            console.log(xhttp.responseText);

            window.location.replace("index.html");

        }  else if(this.readyState == 4 && xhttp.status == 204){

            console.log(xhttp.responseText);
            alert("Failed to Make a New User: Status Code - " + xhttp.status)
        }
    };

    xhttp.open("POST",`http://localhost:8080/api/user`);

    xhttp.setRequestHeader("Content-Type","application/json");
    xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");

    xhttp.send(JSON.stringify(signupInfo));
    
    window.location.replace('login.html')
    // alert('Account created successfully')

});