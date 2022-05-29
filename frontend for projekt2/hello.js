


const greetingId = document.querySelector('.greeting-id');
const greetingContent = document.querySelector('.greeting-content');


const director = document.querySelector('.director');
const year = document.querySelector('.year');

//const input = document.getElementsByClassName('.input');
//input[0].remove();
const input = document.querySelector('#id');


//const button = document.querySelector('.action_button');
const buttons = document.getElementsByClassName('action_button');

buttons[0].addEventListener('click',(e)=>{
   
    var url_addr = "http://localhost:8080/movie/get?id=" + input.value;
    $.ajax({
        url: url_addr
    }).then(function(data, status, jqxhr) {
        greetingId.innerHTML =  data.id;
        greetingContent.innerHTML =   data.title;
        director.innerHTML =  data.director;
        year.innerHTML =  data.year;
        
       console.log(jqxhr);
    });
});








