var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request11_type = [];
    var type_id = 1;
    $http.get('/api/request11_type?id='+type_id)
        .then(function (response){
            $scope.request11_type=response.data;
            console.log(response);
            $http.get('/api/medicine').then(function (response){
                var medicines = response.data;
                var selector = document.getElementById("TypeOfMedicine");
                $(selector).empty();
                for (var i = 0; i < medicines.length; i++) {
                    var option = document.createElement("option");
                    option.text = medicines[i].typeOfMedicine.nameOfType;
                    option.value = medicines[i].id;
                    selector.add(option);
                }
            });
        });

    this.update_request = function add() {
        var index = document.getElementById("TypeOfMedicine").selectedIndex;
        type_id= document.getElementById("TypeOfMedicine").options[index].value;

        $http.get('/api/request11_type?id='+type_id).then(function (response){
            $scope.request11_type=response.data;
            console.log(response);
        });
    };
});