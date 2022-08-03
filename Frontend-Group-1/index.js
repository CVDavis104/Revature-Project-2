
let loginButton = document.getElementById("login-button");


loginButton.addEventListener("click", (event) => {
    event.preventDefault(); 
    let xhttp = new XMLHttpRequest();
   
    let username = document.getElementById("email-sign-in").value;
    let password = document.getElementById("password-sign-in").value;
    // Here we are creating a "loginInfo" object
    let loginInfo = {
        email:username,
        pass_word:password
    }
    console.log(loginInfo);
   
        xhttp.onreadystatechange = function(){
            // 200 status is ok
            // indicates everything was processed correctly
            if(this.readyState == 4 && xhttp.status == 200){
                console.log(xhttp.responseText);
                let data = JSON.parse(xhttp.responseText);
                console.log(data);
                // Global Caching Function
                localStorage.setItem('currentUser', JSON.stringify(data));
                window.location.replace("welcome.html")
                // 204 status is a invalid login
            } else if(this.readyState == 4 && xhttp.status == 204){
                console.log(xhttp.responseText)
                alert("Failed to Login: Status Code -" + xhttp.status)
            }
        };
       
        xhttp.open("POST", `http://localhost:8080/Horoscope/user`);
        xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
        xhttp.setRequestHeader("Content-Type", "application/json");
        console.log(xhttp);
        
        xhttp.send(JSON.stringify(loginInfo));
})
