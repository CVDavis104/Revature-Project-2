// ! This products.js is not being utilized 

let shop = document.getElementById('shop');

let shopItemsData = [{
    id: "sdfsf",
    name: "Peter From Family Guy",
    price: 100,
    desc: "Remember that time peter fell in Family Guy? You can relive that moment every time you look at this model!",
    img: "assets/Peter1.jpg"
},{
    id: "dfdfs",
    name: "Venom",
    price: 50,
    desc: "lorem",
    img: "assets/Venom1.jpg"
},{
    id: "cvxcv",
    name: "Goku",
    price: 60,
    desc: "lorem",
    img: "assets/Goku1.jpg"
},{
    id: "hhhhhh",
    name: "Batman",
    price: 80,
    desc: "lorem",
    img: "assets/Batman1.jpg"
},{
    id: "hghg",
    name: "Charizard",
    price: 200,
    desc: "lorem",
    img: "assets/Charizard1.jpg"
}];

let basket = JSON.parse(localStorage.getItem("data")) || []

let generateShop =()=>{
    return (shop.innerHTML = shopItemsData.map((x)=>{
        let {id, name, price, desc, img} = x
        let search = basket.find((x) => x.id === id) || [];
        return `<div class="item" id=product-id-${id}>
        <img width="219" src=${img} alt="">
        <div class="details">
            <h3>${name}</h3>
            <p>${desc}</p>
            <div class="price-quantity">
                <h2>$${price}</h2>
                <div class="buttons">
                    <i onclick="decrement(${id})" class="bi bi-dash-lg"></i>
                    <div id=${id} class="quantity">
                    ${search.item === undefined? 0: search.item}
                    </div>
                    <i onclick="increment(${id})" class="bi bi-plus-lg"></i>
                </div>
            </div>
        </div>
    </div>
    `;
    }).join("")) 
}

generateShop();

let increment = (id) => {
    let selectedItem = id
    let search = basket.find((x) => x.id === selectedItem.id)
    if(search === undefined){
    basket.push({
        id: selectedItem.id,
        item: 1,
      })
    } 
    else {
        search.item += 1;
    }
    localStorage.setItem("data", JSON.stringify(basket));
    // console.log(basket);
    update(selectedItem.id);
};

let decrement = (id) => {
    let selectedItem = id
    let search = basket.find((x) => x.id === selectedItem.id)
    if(search.item === 0) 
    return; 
    else {
        search.item -= 1;
    }
    localStorage.setItem("data", JSON.stringify(basket));
    // console.log(basket);
    update(selectedItem.id);
}


let update = (id) => {
    let search = basket.find((x) => x.id === id);
    // console.log(search.item);
    document.getElementById(id).innerHTML = search.item;
    calculation();
};

let calculation =  () => {
    let cartIcon = document.getElementById("cartAmount")
    cartIcon.innerHTML = basket.map((x) => x.item).reduce((x, y) => x+y, 0 )
   
};

calculation();