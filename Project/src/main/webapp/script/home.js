let navbar = document.querySelector('.navbar');
document.querySelector('#menu-btn').onclick = () => {
	navbar.classList.toggle('active');

	cartItem.classList.remove('active');
	Searchform.classList.remove('active');
}
let Searchform = document.querySelector('.cart-items-container');
document.querySelector('#cart-btn').onclick = () => {
	Searchform.classList.toggle('active');
	navbar.classList.remove('active');
	cartItem.classList.remove('active');

}
let cartItem = document.querySelector('.search-form');
document.querySelector('#search-btn').onclick = () => {
	cartItem.classList.toggle('active');
	navbar.classList.remove('active');
	Searchform.classList.remove('active');
}

window.onscroll = () => {
	navbar.classList.remove('active');
	cartItem.classList.remove('active');
	Searchform.classList.remove('active');
}