var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request9_list = [];
    $http.get('/api/request9_list').then(function (response){
        $scope.request9_list = response.data;
        console.log(response);
    });

    $scope.request9_amount = 0;
    $http.get('/api/request9_amount').then(function (response){
        $scope.request9_amount = response.data;
        console.log(response);
    });
});