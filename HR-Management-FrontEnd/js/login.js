$(document).ready(function () {
    console.log("RunApp");
    // LoadData();
});

// function LoadData(){
//     http://localhost:8080/api/v1/employees
//     $.ajax({
//         cache: true,
//         url: 'http://localhost:8080/api/test/all',
//         type: 'GET',
//         dataType: 'json',
//         ansync : false,
//         success: function(rs){
//             console.log(rs);
//         },
//         error: function(rs){
//             console.log(rs);
//         },
//     });
// }


$("#login-form").submit(function( event ) {
    event.preventDefault();
    var username = document.getElementById("login-username").value;
    var password = document.getElementById("login-password").value;

    var test = JSON.stringify({
        "username" : username,
        "password" : password
    });


    if(username && password){
        $.ajax({
            cache: true,
            type: 'POST',
            url: API_URL + '/api/auth/signin',
            contentType : "application/json;charset=UTF-8",
            data:  JSON.stringify({
                "username" : username,
                "password" : password
            }),
            dataType : "json",
            async : false,
            error : function(request) {
                console.log("fail");
                
            },
            success : function(data) {
                localStorage.setItem("token", data.data.accessToken);
                console.log("success");
            }
        });
    } else{
        alert('Please enter your username and password !!');
    }

});