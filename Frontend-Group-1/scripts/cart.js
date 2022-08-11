
let button = document.getElementById('addtocartp')
let user = localStorage.getItem('currentUser')
myUser = JSON.parse(user)
let product1 = localStorage.getItem('allProducts')
console.log(product1)
let productAdd1 = JSON.parse(product1)
console.log(productAdd1)


 async function addToCartButton (){

    let userid = myUser.id;
    let productid = productAdd1[0].id

    let cartInfo = {
        userid: userid,
        productid: productid,
        productqty: 10
    }
    console.log(cartInfo);
     //the url for our backend
     try {
      const raw_response = await fetch(`http://localhost:8080/api/usercart`,
        {
          method: "POST", //the http verb
          headers: { //headers
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*"
           },
           body: JSON.stringify(cartInfo)
   
        });
    
        if (!raw_response.ok) {
         
        }
        console.log(json_data);
        const json_data = await raw_response.json();
        setTimeout( () => {
        },1000)
    } catch (error) {
      //this catch block is for network errors
      //console.log(error);
  }
};

async function getCartById(){
    try {
        const raw_response = await fetch(`http://localhost:8080/api/usercarts`,
        {   method: 'GET',
            headers:{
                "Content-Type":"application/json",
                "Access-Control-Allow-Origin": "*", 
            },
           
        });

        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        const data = await raw_response.json();

        console.log(data);
        // console.log(JSON.stringify(data));
        localStorage.setItem('currentCart',JSON.stringify(data));

    }catch(error){
        console.log(error)
    }
};

getCartById()

async function getAllProducts(){
    try {
        const raw_response = await fetch(`http://localhost:8080/api/products`,
        {   method: 'GET',
            headers:{
                "Content-Type":"application/json",
                "Access-Control-Allow-Origin": "*", 
            },
           
        });

        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        const data = await raw_response.json();

        // console.log(data);
        // console.log(JSON.stringify(data));
        localStorage.setItem('allProducts',JSON.stringify(data));

    }catch(error){
        console.log(error)
    }
};

getAllProducts()

// Listing all the products in user's cart
let cartStorage = localStorage.getItem('currentCart')

let cartList1 = document.getElementById('cartp')
cartList1.innerText = `${productAdd1[0].name}` + ' QTY: 2'

let cartList2 = document.getElementById('cartg')
cartList2.innerText = `${productAdd1[1].name}` + ' QTY: 4' 

let cartList3 = document.getElementById('cartb')
cartList3.innerText = `${productAdd1[2].name}` + ' QTY: 1'

let cartList4 = document.getElementById('cartc')
cartList4.innerText = `${productAdd1[3].name}` + ' QTY: 3' 

let cartList5 = document.getElementById('cartv')
cartList5.innerText = `${productAdd1[4].name}` + ' QTY: 2' 




// let addToCartG = document.getElementById('addtocartg')
// let addToCartB = document.getElementById('addtocartb')
// let addToCartC = document.getElementById('addtocartc')
// let addToCartV = document.getElementById('addtocartv')







// let cartPdisplay = document.getElementById('cartp')
// cartPdisplay.innerText = 'Peter'
// let cartGdisplay = document.getElementById('cartg')
// cartGdisplay.innerText = 'Goku'
// let cartBdisplay = document.getElementById('cartb')
// cartBdisplay.innerText = 'Batman'
// let cartCdisplay = document.getElementById('cartc')
// cartCdisplay.innerText = 'Charizard'
// let cartVdisplay = document.getElementById('cartv')
// cartVdisplay.innerText = 'Venom'

