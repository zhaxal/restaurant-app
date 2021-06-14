window.onload = function() {
};


function checkAvailability(){
    console.log("getTables")
    var people = $('#people').val();
    var from = $('#from').val();
    var hours = parseInt($('#hour').val());
    var minutes = parseInt($('#minute').val());
    minutes = minutes + hours * 60;
    var to = new Date(from);
    to.setMinutes(to.getMinutes()+minutes);
    from = new Date(from);
    if (from<=to){
        $.ajax({
            type: 'GET',
            url: '/table/restaurant/get?id='+restaurantId,
            dataType: "json",
            success: function(data){
                var tables = document.getElementById("tables");
                tables.innerHTML = "";
                data.forEach(table => {
                    $.ajax({
                        type: 'GET',
                        url: '/reservations/table/get?id='+table.id,
                        dataType: "json",
                        success: function(r){
                            var counter = 0;

                            r.forEach(reservation => {
                                var dbFrom = new Date(reservation.reservedFrom);
                                var dbTo = new Date(reservation.reservedTo);


                                if(table.seats >= people){
                                    if(!(from <= dbTo && from >= dbFrom ||
                                        dbFrom <= to && dbTo >= to)){
                                        counter++;
                                    }
                                }else{
                                    alert("no seats");
                                }

                            });
                            if (counter === r.length){
                            var t = document.createElement("a");
                            t.appendChild(document.createTextNode(table.id));
                            t.style.left= 100+"px";
                            t.style.backgroundImage = "url('table_6.png')";
                            t.href = '/menu?restaurant_id='+restaurantId+'&table_id='+table.id+'&f='+from.getTime()+'&t='+to.getTime();
                            tables.appendChild(t);
                            }
                        }
                    });
                })
            }
        });
}else {
    alert("Your inputs are incorrect");
}
}





