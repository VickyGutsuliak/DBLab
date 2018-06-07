var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request8_list = [];
    $http.get('/api/request8_list').then(function (response){
        $scope.request8_list = response.data;
        console.log(response);
    });

    $scope.request8_amount = 0;
    $http.get('/api/request8_amount').then(function (response){
        $scope.request8_amount = response.data;
        console.log(response);
    });
});