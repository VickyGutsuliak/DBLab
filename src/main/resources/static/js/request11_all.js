var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request11_all = 0;
    $http.get('/api/request11_all').then(function (response){
        $scope.request11_all = response.data;
        console.log(response);
    });
});