var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request6_types_critical_rate = [];
    $http.get('/api/request6_type_of_medicine_critical_rate').then(function (response){
        $scope.request6_types_critical_rate = response.data;
        console.log(response);
    });
});