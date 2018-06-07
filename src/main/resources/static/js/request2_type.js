var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request2_type = [];
    var type_id = 1;
    $http.get('/api/request2_list_selected_type?id='+type_id)
        .then(function (response){
            $scope.request2_type=response.data;
            console.log(response);
            $http.get('/api/type/medicine').then(function (response){
                var types = response.data;
                var selector = document.getElementById("TypeOfMedicine");
                $(selector).empty();
                for (var i = 0; i < types.length; i++) {
                    var option = document.createElement("option");
                    option.text = types[i].nameOfType;
                    option.value = types[i].id;
                    selector.add(option);
                }
            });
        });

    $scope.request2_type_amount = 0;

    $http.get('/api/request2_amount_selected_type?id='+type_id)
        .then(function (response){
        $scope.request2_type_amount = response.data;
        console.log(response);
    });


    this.update_request = function add() {
        var index = document.getElementById("TypeOfMedicine").selectedIndex;
        type_id= document.getElementById("TypeOfMedicine").options[index].value;

        $http.get('/api/request2_list_selected_type?id='+type_id).then(function (response){
            $scope.request2_type=response.data;
            console.log(response);
        });

        $http.get('/api/request2_amount_selected_type?id='+type_id)
            .then(function (response){
                $scope.request2_type_amount = response.data;
                console.log(response);
            });
    };

});