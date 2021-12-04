$(document).ready(function () {
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
