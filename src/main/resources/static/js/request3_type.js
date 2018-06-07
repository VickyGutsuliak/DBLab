var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3_type = [];
    var type_id = 1;
    $http.get('/api/request3_type?id='+type_id)
        .then(function (response){
            $scope.request3_type=response.data;
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

    this.update_request = function add() {
        var index = document.getElementById("TypeOfMedicine").selectedIndex;
        type_id= document.getElementById("TypeOfMedicine").options[index].value;

        $http.get('/api/request3_type?id='+type_id).then(function (response){
            $scope.request3_type=response.data;
            console.log(response);
        });
    };
});