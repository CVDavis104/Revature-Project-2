
var loginButton = document.getElementById("login-btn");

// var userName = username;
// var userPassword = userpassword;





async function loginUser(event){
    event.preventDefault();
   
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        console.log(email)
        console.log(password)  

        let loginBody = {
            email:email,
            password:password
        };
        console.log(loginBody)

        let JsonLoginBody = JSON.stringify(loginBody);
        console.log(JsonLoginBody)

    try{
        const raw_response = await fetch(`http://localhost:8080/api/userLogin`, 
            {
                method:"POST",
                headers:{
                    "Content-Type":"application/json",
                    "Access-Control-Allow-Origin": "*"
            },
             body:JsonLoginBody
        });

      const content = await raw_response.json();

      console.log(email)
      console.log(password) 
      console.log(raw_response)
      console.log(content);
      localStorage.setItem('currentUser' , JSON.stringify(content));
      console.log(localStorage)
      alert('Successfully logged in!')
      window.location.replace("index.html");
    }catch(error){
      console.log(error)
      alert('Invalid username and password!')
    }

};