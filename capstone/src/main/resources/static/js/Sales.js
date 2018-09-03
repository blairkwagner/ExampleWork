$(document).ready(function () {
getVehicles();


 function getVehicles() {
        $('#vehicleContent').empty();
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/vehicles',
            success: function (Vehicles) {
                Vehicles.forEach(function (Vehicle) {
                 
                });

            },
        });
    }
    
    
    });