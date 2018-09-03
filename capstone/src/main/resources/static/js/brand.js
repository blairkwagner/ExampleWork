$(document).ready(function () {
    getBrand();

    function brandHtml(b) {
        return ` <div class="panel panel-default"><center>
    <div class="panel-body">${b.name}</center></div>
  </div>
</div>`;
    }

    function getBrand() {
        $('#brandContent').empty();
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/brand',
            success: function (brands) {
                brands.forEach(function (b) {
                    $("#brandContent").append(brandHtml(b));
                });

            },
        });
    }
    $('#addBrandBtn').click(function () {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/brand',
            contentType: "application/json",
            data: JSON.stringify({
                name: $('#brandColumn').val()
            }),

            success: function () {

                getBrand();
                $('form')[0].reset()

            }
        });
    });
});

 