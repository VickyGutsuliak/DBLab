var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request2_all = [];
    $http.get('/api/request2_list_all').then(function (response){
        $scope.request2_all = response.data;
        console.log(response);
    });

    $scope.request2_all_amount = [];

    $http.get('/api/request2_amount_all').then(function (response){
        $scope.request2_all_amount = response.data;
        console.log(response);
    });

});