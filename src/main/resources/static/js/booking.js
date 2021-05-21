window.onload = function() {
    showTables();
};

function showTables(){
    console.log("getTables")
    $.ajax({
        type: 'GET',
        url: '/table/restaurant/get?id='+restaurantId,
        dataType: "json",
        success: function(data){
            console.log("table list")
            var mainDiv = document.getElementById("tables");
            var tables = document.createElement("div");
            tables.id = "list";
            mainDiv.appendChild(tables);
            data.forEach(table => {
                var t = document.createElement("button");
                t.appendChild(document.createTextNode(table.id))
                tables.appendChild(t);
            })
        }
    });
}

function checkAvailability(){
    console.log("getTables")
    var people = $('#people').val();
    var from = $('#from').val();
    var to = $('#to').val();
    if (from<=to){
        $.ajax({
            type: 'GET',
            url: '/table/restaurant/get?id='+restaurantId,
            dataType: "json",
            success: function(data){
                var mainDiv = document.getElementById("tables");
                document.getElementById("list").remove();
                var tables = document.createElement("div");
                tables.id = "list";
                mainDiv.appendChild(tables);
                data.forEach(table => {
                    $.ajax({
                        type: 'GET',
                        url: '/reservations/table/get?id='+table.id,
                        dataType: "json",
                        success: function(reservation){


                            from = new Date(from).toISOString().slice(0, 19).replace('T', ' ');
                            to = new Date(to).toISOString().slice(0, 19).replace('T', ' ');
                            var dbFrom = new Date(reservation.reservedFrom).toISOString().slice(0, 19).replace('T', ' ');
                            var dbTo = new Date(reservation.reservedTo).toISOString().slice(0, 19).replace('T', ' ')

                            if(table.seats >= people){
                                if(!(from <= dbTo && from >= dbFrom ||
                                    dbFrom <= to && dbTo >= to)){
                                var t = document.createElement("button");
                                t.appendChild(document.createTextNode(table.id))
                                tables.appendChild(t);
                                }
                            }else{
                                alert("no seats");
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





