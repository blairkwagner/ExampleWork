$(document).ready(function () {
    getAllContacts();

    function getAllContacts() {
        $('#contactContent').empty();
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/contact',

            success: function (Contact) {
                Contact.forEach(function (contacts) {


                });
            }


        });
    }


    $('#addContactBtn').click(function () {

        var Contact = {

            "name": $("#name").val(),
            "email": $("#email").val(),
            "phoneNumber": $("#phoneNumber").val(),
            "message": $("#message").val(),

        };
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/contact',
            contentType: "application/json",
            data: JSON.stringify(Contact),

            success: function () {

                getAllContacts();

                $('form')[0].reset()



            }
        });
    });
});


 