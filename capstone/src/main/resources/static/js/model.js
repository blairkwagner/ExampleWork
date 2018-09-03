$(document).ready(function () {
    getModels();
    getBrand();


    function modelHtml(m) {
        return ` <div class="panel panel-default"><center>
    <div class="panel-body">${m.brands.name} ${m.name}</center></div>
  </div>
</div>`;
    }

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
        $('#modelContent').empty();
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/model',
            success: function (models) {
                models.forEach(function (m) {
                    $("#modelContent").append(modelHtml(m));
                });
            },
        });
    }




    $('#addModelBtn').click(function () {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/model',
            contentType: "application/json",
            data: JSON.stringify({
                brands: {
                    id: $("#brandContent").val()
                },

                name: $('#modelColumn').val()
            }),
            success: function () {

                getModels();
                
                $('form')[0].reset()
            }
        });
    });
});



