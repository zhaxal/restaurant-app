DG.then(function() {
    var map = DG.map('map', {
        center: [51.14, 71.43],
        zoom: 12
    });
    console.log("getRestaurants")
    $.ajax({
        type: 'GET',
        url: "/restaurants/get/all",
        dataType: "json",
        success: function(data){
            data.forEach(restaurant => {
                var id = restaurant.id;
                var name = restaurant.name;
                var rating = restaurant.rating;
                var address = restaurant.address;
                var popup = DG.popup({
                    sprawling: true
                }).setContent('<a style="color: white">Name: '+name+'</a></br>' +
                    '<a style="color: white">Rating: '+rating+'</a></br>' +
                    '<a style="color: white">Address: '+address+'</a></br>' +
                    '<a href="/booking?id='+ id +'" style="color: white;text-underline: none">Place order</a></br>');
                DG.marker([restaurant.x, restaurant.y]).addTo(map).bindPopup(popup)})
        }
    });

});

