var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request12 = [];
    var medicine_id = 10;
    $http.get('/api/request12?id='+medicine_id)
        .then(function (response){
            $scope.request12=response.data;
            console.log(response);
            $http.get('/api/for_request12').then(function (response){
                var medicines = response.data;
                var selector = document.getElementById("MadeMedicine");
                $(selector).empty();
                for (var i = 0; i < medicines.length; i++) {
                    var option = document.createElement("option");
                    option.text = medicines[i].nameOfMedicine;
                    option.value = medicines[i].id;
                    selector.add(option);
                }
            });
        });

    $scope.request12_medicine = 0;
    $http.get('/api/request12_medicine?id='+medicine_id)
        .then(function (response){
            $scope.request12_medicine = response.data;
            console.log(response);
        });

    this.update_request = function add() {
        var index = document.getElementById("MadeMedicine").selectedIndex;
        medicine_id= document.getElementById("MadeMedicine").options[index].value;

        $http.get('/api/request12?id='+medicine_id).then(function (response){
            $scope.request12=response.data;
            console.log(response);
        });

        $http.get('/api/request12_medicine?id='+medicine_id).then(function (response){
            $scope.request12_medicine=response.data;
            console.log(response);
        });
    };
});