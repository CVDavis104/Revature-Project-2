// navbar

const navbar = document.querySelector('.navbar');

window.addEventListener('scroll', () => {
    if(scrollY >= 180){
        navbar.classList.add('bg');
    } else{
        navbar.classList.remove('bg');
    }
})

const createNavbar = () => {
    let navbar = document.querySelector('.navbar');

    navbar.innerHTML += `
    
        <ul class="links-container">
        <li class="link-item"><a href="/index.html" class="link active">home</a></li>
            <li class="link-item"><a href="/product.html" class="link">products</a></li>
            <li class="link-item"><a href="#" class="link">about</a></li>
            <li class="link-item"><a href="#" class="link">contact</a></li>
            <li class="link-item"><a href="profile.html" class="link">profile</a></li>
        </ul>
        <div class="user-interactions">
            <div class="search-box">
                <input type="text" class="search" placeholder="search item">
                <button class="search-btn"><img src="../assets/search.png" alt=""></button>
            </div>
            <div class="cart" onclick="location.href = '/cart.html'">
                <img src="../assets/cart.png" class="cart-icon" alt="">
                <span class="cart-item-count">00</span>
            </div>
            <div class="user">
                <img src="../assets/user.png" class="user-icon" alt="">
                <div class="user-icon-popup">
                    <p>login to your account</p>
                    <a>login</a>
                </div>
            </div>
        </div>

    `
}

createNavbar();

// user icon popup

let userIcon = document.querySelector('.user-icon');
let userPopupIcon = document.querySelector('.user-icon-popup');

userIcon.addEventListener('click', () => userPopupIcon.classList.toggle('active'))


let text = userPopupIcon.querySelector('p');
let actionBtn = userPopupIcon.querySelector('a');
let userStorage = localStorage.getItem('currentUser')

// Navbar to show that user is logged in 
if(user = userStorage){ // user is logged in
    let userStorage = localStorage.getItem('currentUser')
    let user = JSON.parse(userStorage);
    console.log(user)
    text.innerHTML = `logged in as, ${user.firstname}`;
    console.log(text.innerHTML)
    actionBtn.innerHTML = 'log out';
    actionBtn.addEventListener('click', () => logout());
} else{
    text.innerHTML = 'login to your account';
    actionBtn.innerHTML = 'login';
    actionBtn.addEventListener('click', () => location.href = '/login.html');
}

const logout = () => {
    localStorage.clear()
    location.reload();
    alert('You have logged out!')
}

// search box

let searchBtn = document.querySelector('.search-btn')
let searchBox = document.querySelector('.search');

searchBtn.addEventListener('click', () => {
    if(searchBox.value.length){
        location.href = `/search/${searchBox.value}`;
    }
})

// nav cart count

const updateNavCartCounter = () => {
    let cartCounter = document.querySelector('.cart-item-count');
    console.log(cartCounter)
    let cartItem = JSON.parse(localStorage.getItem('cart'));
    console.log(cartItem)
    let cartButton = document.getElementById('addtocart')
    console.log(cartButton)

    if(cartItem == null){
        cartCounter.innerHTML = '00';
    } else{
        if(cartItem.length > 9){
            cartCounter.innerHTML = '9+';
        } else if(cartItem.length <= 9){
            cartCounter.innerHTML = `0${cartItem.length}`
        }
    }
}

updateNavCartCounter();