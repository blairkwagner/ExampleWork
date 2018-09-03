$(document).ready(function() {
  getSnacks();





    $('#makePurchaseBtn').click(function() {
      $("#changeMsg").val('');
      var itemNum = $('#itemNum').val();
      var money = document.getElementById('balance').value;
      $.ajax({
        type: 'GET',
        url:  'http://localhost:8080/money/' + money + '/' + 'item/' + itemNum,
        //check with corbin about equation
        success: function() {
          itemCost$ = $('#item' + itemNum + 'Price').text();
          itemCost = Math.round(parseFloat(itemCost$.substring(1,itemCost$.length)) * 100);
          money = Math.round(parseFloat(money) * 100);
          var updatedBalance = ((money - itemCost) / 100).toString();
          $('#balance').val(updatedBalance);
          $('#message').val('Thank You! COME AGAIN:)');
          getSnacks();
        },
        error: function(response) {
          var obj = JSON.parse(response.responseText);
          $('#message').val(obj.message);

        });
}
//check equations from stack over flow
  $('#changeBtn').click(function() {
    var balanceInPennies = Math.round(parseFloat($('#balance').val()) * 100);
    var quarters = Math.floor(balanceInPennies / 25);
    balanceInPennies %= 25;
    var dimes = Math.floor(balanceInPennies / 10);
    balanceInPennies %= 10;
    var nickels = Math.floor(balanceInPennies / 5);
    balanceInPennies %= 5;
    var change = {"quarters":quarters, "dimes":dimes, "nickels":nickels,"pennies":balanceInPennies};
    displayChange(change);
    $('#balance').val('0.00');
    $('#itemNum').val('');
    $('#message').val('');
  });

  $('#addDollarBtn').click(function() {
    $("#changeMsg").val('');
    var balance = parseFloat(document.getElementById('balance').value) + 1.00;
    document.getElementById('balance').value = balance.toString();
  });
  $('#addQuarterBtn').click(function() {
    $("#changeMsg").val('');
    var balance = parseFloat($('#balance').val()) + .25;
    $('#balance').val(balance.toString());
  });
  $('#addDimeBtn').on('click', function() {
    $("#changeMsg").val('');
    var balance = Math.round(parseFloat(document.getElementById('balance').value) * 100 + 10) / 100;
    document.getElementById('balance').value = balance.toString();
  });
  $('#addNickelBtn').click(function() {
    $("#changeMsg").val('');
    var balance = Math.round(parseFloat($('#balance').val()) * 100 + 5) / 100;
    $('#balance').val(balance.toString());
  });
});

function getSnacks() {
  $('#snackColumn').empty();
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8080/items',
    success: function(snacks) {
      var rowNumber = 0;
      for (i = 1; i <= snacks.length; i++) {
        if ((i-1)%3 == 0) {
          rowNumber++;
          /// called in html
          $('#snackColumn').append('<div id="row' + rowNumber + '" class="row"></div>');
        }
        var panel = '<div class="col-sm-4"><div class="item panel panel-default"><div class="panel-body">';
        panel += '<p class="text-left itemNumber">' + snacks[i - 1].id + '</p>';
        panel += '<p class="text-center">' + snacks[i - 1].name + '</p>';
        panel += '<p class="text-center" id="item' + i + 'Price">$' + snacks[i - 1].price + '</p>';
        panel += '<br><p class="text-center">Quantity Left: ' + snacks[i - 1].quantity + '</p>';
        panel += '</div></div></div>';
        $('#row' + rowNumber).append(panel);
      }
      $('.panel-body').hover(function() {
        $(this).css("background-color","lightblue");},
        function() {
          $(this).css("background-color","white");
        });
        $('.panel-body').click(function() {
          $('#itemNum').val($(this).find('.itemNumber').text());
        });
      },
      error: function() {
        alert('Error: Unable to connect.. Please try again later.');
      }
    });
  }
  // needs work!
  function displayChange(change) {
    var changeMsg ="Quarters " + "" +  change.quarters +" ";
    changeMsg += "Dimes  "+ change.dimes + "  ";
    changeMsg +=  "Nickels "  + change.nickels + "  ";
    changeMsg += "Pennies  " + change.pennies + "  ";

    $('#changeMsg').val(changeMsg);
  }
}
