var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3_all = [];
    $http.get('/api/request3_all').then(function (response){
        $scope.request3_all = response.data;
        console.log(response);
    });
});