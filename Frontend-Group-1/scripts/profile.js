//this finds current user and logs it in console
let userStorage = localStorage.getItem('currentUser');
console.log(userStorage);
let user = JSON.parse(userStorage);





// Interpolate database info to profile.

let firstNameProfile = document.getElementById("fname-display");
    firstNameProfile.innerText = `First Name: ${user.firstname}`

let lastNameProfile = document.getElementById("lname-display")
    lastNameProfile.innerText =`Last Name: ${user.lastname}`

let phoneProfile = document.getElementById("phone-display")
    phoneProfile.innerText =`Phone: ${user.phonenumber}`

let addressProfile = document.getElementById("address-display")
    addressProfile.innerText =`Address: ${user.address}`

let userEmailProfile = document.getElementById("email-display")
    userEmailProfile.innerText =`Email: ${user.email}`

let usernameProfile = document.getElementById("username-display")
    usernameProfile.innerText =`Username: ${user.username}`

let userPasswordProfile = document.getElementById("password-display")
    userPasswordProfile.innerText =`Password: ${user.password}`


            

let button = document.getElementById("upadate-profile-button");


let userId = user.id;

// Function of updating user profiles
 async function updateUserInfo(event){
    event.preventDefault();

    //Data grabbed for user information
    
    

    let firstNameUpdate = document.getElementById("fname-input").value;
    
    let lastNameUpdate = document.getElementById('lname-input').value;

    let phoneUpdate = document.getElementById('phone-input').value;

    let addressUpdate = document.getElementById('address-input').value;

    let emailUpdate = document.getElementById('email-input').value;

    let usernameUpdate = document.getElementById('username-input').value;

    let passwordUpdate = document.getElementById('password-input').value;

    




 //  Block of information to be updated 
 let updateInfo ={

        firstname:firstNameUpdate,
        lastname:lastNameUpdate,
        phonenumber: phoneUpdate,
        address:addressUpdate,
        email:emailUpdate,
        username:usernameUpdate,
        password:passwordUpdate,
        id:userId,
       
    
    
 };

 let jsonUpdateInfo = JSON.stringify(updateInfo);

//  Logging to ensure the right data is collected
 console.log(updateInfo);
 console.log(jsonUpdateInfo);
 

    try {
        const raw_response = await fetch(`http://localhost:8080/api/userupdate`,
            {

                method:"PUT",
                headers:{
                    "Content-Type":"application/json",
                    "Access-Control-Allow-Origin": "*",
                
            },
            body:jsonUpdateInfo
        });

        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        // Checking to make sure it goes past error.

        console.log("This made it past the error")        

        
        const data = await raw_response.json();
        
        window.location.reload('index.html')
        
    } catch (error) {
        alert("There is an error: " + error)
        
    }
    alert('Profile successfully updated')
};

