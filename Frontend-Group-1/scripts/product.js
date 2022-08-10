// product page setting

// let productName = document.querySelector('.product-title');
// let shortDes = document.querySelector('.product-des');
// let price = document.querySelector('.price');
// let detail = document.querySelector('.des');
// let productImage = document.querySelector('.product-image');
// let title = document.querySelector('title');

// let cartBtn = document.querySelector('.cart-btn');

// const setData = (data) => {
//     productName.innerHTML = title.innerHTML = data.name;
//     productImage.src = data.image;
//     shortDes.innerHTML = data.shortDes;
//     detail.innerHTML = data.detail;
//     price.innerHTML = `$${data.price}`;

//     cartBtn.addEventListener('click', () => {
//         cartBtn.innerHTML = add_product_to_cart(data);
//     })
// }

// const fetchProductData = () => {
//     fetch('/get-products', {
//         method: 'post',
//         headers: new Headers({'Content-Type': 'application/json'}),
//         body: JSON.stringify({id: productId})
//     }).then(res => res.json())
//     .then(data => {
//         setData(data)
//         getProducts(data.tags[0]).then(res => createProductCards(res, 'similar products', '.best-selling-product-section'))
//     })
//     .catch(err => {
//         console.log(err)
//         // alert('no product found');
//         // location.replace('/404.html');
//     })
// }

// let productId = null;
// if(location.pathname != '/add-product'){
//     productId = decodeURI(location.pathname.split('/').pop());
//     fetchProductData();
// }

let preveiwContainer = document.querySelector('.products-preview');
let previewBox = preveiwContainer.querySelectorAll('.preview');

document.querySelectorAll('.products-container .product').forEach(product =>{
  product.onclick = () =>{
    preveiwContainer.style.display = 'flex';
    let name = product.getAttribute('data-name');
    previewBox.forEach(preview =>{
      let target = preview.getAttribute('data-target');
      if(name == target){
        preview.classList.add('active');
      }
    });
  };
});

// previewBox.forEach(close =>{
//   close.querySelector('.fa-times').onclick = () =>{
//     close.classList.remove('active');
//     preveiwContainer.style.display = 'none';
//   };
// });