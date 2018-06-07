var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request6_types_expiration_term = [];
    $http.get('/api/request6_type_of_medicine_expiration_term').then(function (response){
        $scope.request6_types_expiration_term = response.data;
        console.log(response);
    });
});