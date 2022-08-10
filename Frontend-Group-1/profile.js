
let profileButton = document.getElementById("Save Profile");


saveprofileButton.addEventListener("click", (event) => {
    event.preventDefault(); 
    let xhttp = new XMLHttpRequest();
   
    let firstName = document.getElementById("first-Name-input").value;
    let lastName = document.getElementById("last-Name-input").value;
    let mobilenumber=document.getElementById("mobilenumber-input").value;
    let address=document.getElementById("address-input").value;
    let State=document.getElementById("State-input");
    let country=document.getElementById("country-input")
    let email=getElementById.getElementById("email-input");


    let profile = {
        firstName:firstName,
        lastName:lastName,
        mobilenumber:mobilenumber,
        address:address,
        State:State,
        country:country,
        email:email
    }



    console.log(profile);

    //function add(){ firstName + lastName + mobilenumber + address + State + country + email;}
   
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
                alert("Failed to Save Profile: Status Code -" + xhttp.status)
            }
        };
       
        xhttp.open("POST", `http://localhost:8080/Revature-Project-2/user`);
        xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");
        xhttp.setRequestHeader("Content-Type", "application/json");
        console.log(xhttp);
        
        xhttp.send(JSON.stringify(profileInfo));
})
