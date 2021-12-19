$(document).ready(function() {

});

$("#view").click(function( event ) {

    $.ajax({
        cache: true,
        url: 'http://localhost:8080/api/test/all',
        type: 'GET',
        dataType: 'json',
        ansync : false,
        success: function(rs){
            console.log(rs);
        },
        error: function(rs){
            console.log(rs);
        },
    });

});