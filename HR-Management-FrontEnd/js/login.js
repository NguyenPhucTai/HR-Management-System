$(document).ready(function () {
    console.log("RunApp");
    LoadData();
});

function LoadData(){

    $.ajax({
        cache: true,
        url: 'http://localhost:8080/api/v1/employees',
        type: 'GET',
        dataType: 'json',
        ansync : false,
        success: function(rs){
            console.log(rs);
        },
        error: function(rs){
            console.log('Error');
        },
    });

}

$("#login-form").submit(function( event ) {
    var username = document.getElementById("login-username").value;
    var password = document.getElementById("login-password").value;
    event.preventDefault();
});