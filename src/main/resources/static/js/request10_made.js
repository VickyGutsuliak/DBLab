var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request10 = [];
    var med_id = 10;
    $http.get('/api/request10_made_medicines?id='+med_id)
        .then(function (response){
            $scope.request10=response.data;
            console.log(response);
            $http.get('/api/for_request12').then(function (response){
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
        med_id= document.getElementById("Medicine").options[index].value;

        $http.get('/api/request10_made_medicines?id='+med_id).then(function (response){
            $scope.request10=response.data;
            console.log(response);
        });
    };
});