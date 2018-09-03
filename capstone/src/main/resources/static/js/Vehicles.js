$(document).ready(function () {
    getVehicles();
    getBrand();
    getModels();
    Getvehicle_types();



    function vehicleHtml(v) {
        return `  <div class="card img-fluid" style="width:200px">
                    <img class="card-img-top" src="car.jpg" alt="Card image" style="width:180%">
                    <div class="card-img-overlay">
                        <h4 class="card-title">${v.year} ${v.models.brands.name} ${v.models.name}</h4>
                        <p>Body style: ${v.type.type}</p>
                        <p>Transmission: ${v.transmissionType}</p>
                        <p>Mileage: ${v.mileage}</p>
                        <p>Description: ${v.description}</p>
                        <p>Vin Number: ${v.vinNumber}</p>
                        <p>MSRP: ${v.msrp}</p>
                        <p>Sale Price: ${v.salePrice}</p>
        <p>New: ${v.new}</p>
                        <a href="editvehicle.html" class="btn btn-outline-warning">Edit</a>
                        <a href="contact.html" class="btn btn-outline-success">Contact Us</a>

                    </div>
                </div>`;
    }

    function getVehicles() {

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/vehicles',
            success: function (vehicle) {
                vehicle.forEach(function (Vehicles) {

                    $("#vehiclesContent").append("<p>" + Vehicles.year + "</p>");
                });
            },
        });
    }

    function getBrand() {

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/brand',
            success: function (brand) {
                brand.forEach(function (brands) {


                    $("#brandContent").append("<p>" + brands.id + "\">" + brands.name + "</p>");
                });
            }


        });
    }
    function getModels() {
        $('#modelContent').empty();
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/model',
            success: function (models) {
                models.forEach(function (model) {
                    $("#modelContent").append("<p>" + model.brands.name + model.name + "</p>");
                });
            },
        });
    }
    function Getvehicle_types() {

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/vehicleTypes',
            success: function (vehicleType) {
                vehicleType.forEach(function (vehicleTypes) {


                    $("#vehicleTypeContent").append("<p>" + vehicleTypes.id + "\">" + vehicleTypes.type + "</p>");
                });
            },
        });
    }




    $('#searchVehicleBtn').click(function () {

        var criteria = {

            search: $("#search").val()

        };
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/search',
            contentType: "application/json",
            data: JSON.stringify(criteria),
            success: function (vehicle) {
                vehicle.forEach(function (v) {

                    $("#searchContent").append(vehicleHtml(v));
                });
            },
        });
    });


});


