$(document).ready(function () {
    getModels();
    getBrand();
    vehicle_types();
    getVehicles();

    function getBrand() {

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/brand',

            success: function (brand) {
                brand.forEach(function (brands) {

                    $("#brandContent").append("<option value=\"" + brands.id + "\">" + brands.name + "</option>");
                });
            }


        });
    }
    function getModels() {

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/model',
            success: function (model) {
                model.forEach(function (models) {


                    $("#modelContent").append("<option value=\"" + models.id + "\">" + models.name + "</option>");
                });
            },
        });
    }

    function vehicle_types() {

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/vehicleTypes',
            success: function (vehicleType) {
                vehicleType.forEach(function (vehicleTypes) {


                    $("#vehicleTypeContent").append("<option value=\"" + vehicleTypes.id + "\">" + vehicleTypes.type + "</option>");
                });
            },
        });
    }
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



    $('#editVehicleBtn').click(function () {

        var Vehicles = {

            "color": $("#color").val(),
            "interiorColor": $("#interiorColor").val(),
            "year": $("#year").val(),
            "transmissionType": $("#transmissionType").val(),
            "mileage": $("#mileage").val(),
            "msrp": $("#msrp").val(),
            "vinNumber": $("#vinNumber").val(),
            "salePrice": $("#salePrice").val(),
            "description": $("#description").val(),
            "models": {
                "id": $("#modelContent").val(),
                "name": $("#modelContent").val(),
                "brands": {
                    "id": $("#brandContent").val(),
                    "name": $("#brandContent").val()
                }
            },
            "type": {
                "id": $("#vehicleTypeContent").val(),
                "type": $("#vehicleTypeContent").val()
            },
            "new": $("#new").val()
        };
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/vehicles',
            contentType: "application/json",
            data: JSON.stringify(Vehicles),

            success: function () {
                getVehicles();


            }
        });
    });
    
    $('#deleteVehicleBtn').click(function () {

        var Vehicles = {

            "color": $("#color").val(),
            "interiorColor": $("#interiorColor").val(),
            "year": $("#year").val(),
            "transmissionType": $("#transmissionType").val(),
            "mileage": $("#mileage").val(),
            "msrp": $("#msrp").val(),
            "vinNumber": $("#vinNumber").val(),
            "salePrice": $("#salePrice").val(),
            "description": $("#description").val(),
            "models": {
                "id": $("#modelContent").val(),
                "name": $("#modelContent").val(),
                "brands": {
                    "id": $("#brandContent").val(),
                    "name": $("#brandContent").val()
                }
            },
            "type": {
                "id": $("#vehicleTypeContent").val(),
                "type": $("#vehicleTypeContent").val()
            },
            "new": $("#new").val()
        };
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/api/vehicles',
            contentType: "application/json",
            data: JSON.stringify(Vehicles),

            success: function () {
                getVehicles();


            }
        });
    });
});


