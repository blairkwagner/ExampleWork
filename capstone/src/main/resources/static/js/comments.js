$(document).ready(function () {
    getAllContacts();
    
     function commentHtml(c) {
        return `<div class="panel panel-info">
  <div class="panel-heading">Customer Review from: ${c.name}</div>
         <div class="panel-heading">Contact Information: Email: ${c.email} Phone:${c.phoneNumber} </div>
  <div class="panel-body">Message: ${c.message}</div>
</div>`; 
    
    }
    function getAllContacts() {
      
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/contact',

            success: function (Contact) {
                Contact.forEach(function (c) {
    $("#contactContent").append(commentHtml(c));

                });
            }


        });
    }
    });

   

