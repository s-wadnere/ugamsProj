document.getElementById("pagenumber").addEventListener("change", fetchdata());
function fetchdata(){
var pageno = document.getElementById("pagenumber").innerHTML;
console.log(pageno);
var xhr = new XMLHttpRequest();
xhr.open("GET", "https://reqres.in/api/users?page="+pageno, true);
xhr.onload = function(){
console.log(xhr.responseText);
var json = JSON.parse(xhr.responseText);

var data = json["data"];
console.log(data);

const markup = json.data.map(el => {
return `
<li class="cardlist-container column">
<div class="image-container">
<img class="round" src="${el.avatar}">

</div>
<div class="usernames">
<span class="firstName">${el.first_name}</span>
<span class="lastName">${el.last_name}</span>

</div>
<p class="email">${el.email}</p>
</li>
`
});
console.log(markup);
document.querySelector('.list-container').innerHTML = markup.join('');



};
xhr.send();



}