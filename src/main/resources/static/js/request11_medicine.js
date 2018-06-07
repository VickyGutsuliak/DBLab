var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request11_medicine = [];
    var medicine_id = 1;
    $http.get('/api/request11_medicine?id='+medicine_id)
        .then(function (response){
            $scope.request11_medicine=response.data;
            console.log(response);
            $http.get('/api/medicine').then(function (response){
                var medicines = response.data;
                var selector = document.getElementById("Medicine");
                $(selector).empty();
                for (var i = 0; i < medicines.length; i++) {
                    var option = document.createElement("option");
                    option.text = medicines[i].nameOfMedicine;
                    option.value = medicines[i].id;
                    selector.add(option);
                }
            });
        });

    this.update_request = function add() {
        var index = document.getElementById("Medicine").selectedIndex;
        medicine_id= document.getElementById("Medicine").options[index].value;

        $http.get('/api/request11_medicine?id='+medicine_id).then(function (response){
            $scope.request11_medicine=response.data;
            console.log(response);
        });
    };
});