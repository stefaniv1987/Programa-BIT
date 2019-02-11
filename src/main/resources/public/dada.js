$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/smartParking/disponibilidad"
    }).then(function(data) {
       $('.dios').append(data);
    });
});