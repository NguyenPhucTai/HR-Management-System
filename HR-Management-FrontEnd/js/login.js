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
    event.preventDefault();
    var username = document.getElementById("login-username").value;
    var password = document.getElementById("login-password").value;
    if(username && password){
        $.ajax({
            cache: true,
            type: 'POST',
            url: API_URL + '/signin',
            contentType : "application/json;charset=UTF-8",
            dataType:  JSON.stringify({
                "username" : username,
                "password" : password
            }),
            dataType : "json",
            async : false,
            error : function(request) {
                alert('Login unsuccessful please try again !!')
            },
            success : function(data) {
                alert("FAIL");
            }
        });
    } else{
        alert('Please enter your username and password !!');
    }

});