let loginButton = document.getElementById("login-button");

console.log(loginButton);

loginButton.addEventListener('click', (event) => {
    event.preventDefault(); // this prevents the default behavior, bypassing the login credentials

    // Execute our AJAX call
    // 1. Create our XMLHTTPRequest object

    let xhttp = new XMLHttpRequest();

    // 2. Get the values from our form

    let username = document.getElementById("email").value;

    let password = document.getElementById('password').value;

    // Here we are creating a "loginInfo" object
    let loginInfo = {
        email:username,
        pass_word:password
    }

    console.log(loginInfo);

    /*
        A readyState is a property which signifies that state that the request is currently in.
        There are several states:
        0: UNSENT - opening of the request has yet to be called
        1: OPENED - open() has been called
        2: HEADERS_RECEIVED: send() has been called[aka the request has been sent], and the headers of the response as well as the status are now available.
        3: LOADING: downloading the response. Therefore, the responseText (which is a xhr property) is holding partial data.
        4: DONE: the entire operation is now complete
        Why need readyStates?
        Ofter you can implement other transitions or animations to your webpages by triggering them at given readyStates.
        ex. loading screens
    */

        // When 'send' is clicked in Step 4, this function is triggered

        xhttp.onreadystatechange = function(){
            // 200 status is ok
            // indicates everything was processed correctly

            if(this.readyState == 4 && xhttp.status == 200){

                console.log(xhttp.responseText);

                let data = JSON.parse(xhttp.responseText);

                console.log(data);

                // Global Caching Function

                localStorage.setItem('currentUser', JSON.stringify(data));

                window.location.replace("index.html")

                // 204 status is a invalid login

            } else if(this.readyState == 4 && xhttp.status == 204){
                console.log(xhttp.responseText)
                alert("Failed to Login: Status Code -" + xhttp.status)
            }





        };

        // 3. 'Open' the request

        // by inserting 'user' or our 'resource', it indicates the mapping, and the what logic is in the POST method

        xhttp.open("GET", `http://localhost:8080/`);

        xhttp.setRequestHeader("Access-Control-Allow-Origin", "*");

        xhttp.setRequestHeader("Content-Type", "application/json");

        console.log(xhttp);

        // 4. 'Send' status

        xhttp.send(JSON.stringify(loginInfo))

    })