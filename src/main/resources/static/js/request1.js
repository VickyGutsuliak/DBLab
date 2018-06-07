var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1_1 = [];
    $http.get('/api/request1_1').then(function (response){
        $scope.request1_1 = response.data;
        console.log(response);
    });

    $scope.request1_2 = [];

    $http.get('/api/request1_2').then(function (response){
        $scope.request1_2 = response.data;
        console.log(response);
    });

});