// app.js
document.addEventListener('DOMContentLoaded', () => {
    // Пример загрузки товаров с сервера
    fetch('/api/products')
        .then(response => response.json())
        .then(products => {
            const grid = document.querySelector('.product-grid');
            products.forEach(product => {
                const card = document.createElement('div');
                card.classList.add('product-card');
                card.innerHTML = `
                    <img src="${product.image}" alt="${product.name}">
                    <h3>${product.name}</h3>
                    <p>Цена: ${product.price} ₽</p>
                        <button onclick="addToCart(${product.id})">В корзину</button>
                        grid.appendChild(card);
            });
        });
});

function addToCart(productId) {
// Логика добавления в корзину
console.log(`Товар с ID ${productId} добавлен в корзину`);
}