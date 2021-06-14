function addToCart(id){
    var cart = document.getElementById("cart");

    $.ajax({
        type: 'GET',
        url: '/meals?id='+id,
        dataType: "json",
        success: function(meal){
            cart.innerHTML += '<tbody id="'+meal.id+'">\n'+
                '<td class="mealId">'+meal.id+'</td>\n' +
                '<td>'+meal.name+'</td>\n' +
                '                <td>'+meal.price+'</td>\n' +
                '                <td><button onclick="deleteFromCart('+meal.id+')" class="btn-danger">Delete</button></td>' +
                '</tbody>';

        }
    });
}

function deleteFromCart(id){
    document.getElementById(id).remove();
}

function makeOrder(){
    $.ajax({
        type: 'POST',
        url: '/reservations/add?table_id='+tableId+'&from='+from+'&to='+to,
        dataType: "json",
        success: function(current){
            setTimeout(function() {
                $.ajax({
                    type: 'GET',
                    url: '/reservations/date/get?curr_time='+current,
                    dataType: "json",
                    success: function(reservation_id){
                        $('#cart tr').each(function() {
                            var mealId = $(this).find(".mealId").html();
                            if(isNaN(mealId)){
                            }else{
                                $.ajax({
                                    type: 'POST',
                                    url: '/reservationmeals/add?reservation_id='+reservation_id+'&meal_id='+mealId,
                                    dataType: "json",
                                    success: function(){

                                    }
                                });
                            }
                        });
                        setTimeout(function () {
                            window.location.href = "/profile";
                        },300);

                    }
                });
            }, 500);

        }
    });


}
