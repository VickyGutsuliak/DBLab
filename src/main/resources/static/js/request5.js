var app = angular.module("demo", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request5 = [];
    var type_id = 1;
    var date1='2017-01-01';
    var date2='2019-01-01';
    $http.get('/api/request5_medicine_type_buyers_list?id='+type_id+'&firstDate='+
        date1+'&secondDate='+date2)
        .then(function (response){
            $scope.request5=response.data;
            console.log(response);
            $http.get('/api/type/medicine').then(function (response){
                var types = response.data;
                var selector = document.getElementById("TypeOfMedicine");
                $(selector).empty();
                for (var i = 0; i < types.length; i++) {
                    var option = document.createElement("option");
                    option.text = types[i].nameOfType;
                    option.value = types[i].id;
                    selector.add(option);
                }
            });
        });

    $scope.request5_amount = 0;

    $http.get('/api/request5_medicine_type_buyers_amount?id='+type_id+'&firstDate='+
        date1+'&secondDate='+date2)
        .then(function (response){
        $scope.request5_amount = response.data;
        console.log(response);
    });


    this.update_request = function add() {
        var index = document.getElementById("TypeOfMedicine").selectedIndex;
        type_id= document.getElementById("TypeOfMedicine").options[index].value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regex=/^20[0-9][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))$/ ;
        if(!regex.test(date1.toString())||!regex.test(date2.toString())){
            errorMessage=errorMessage+'-невірний формат дати;\n';
            errorMessage=errorMessage+'Потріббний формат yyyy-mm-dd (рік-місяць-день);';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/request5_medicine_type_buyers_list?id='+type_id+'&firstDate='+
                date1+'&secondDate='+date2).then(function (response){
                $scope.request5=response.data;
                console.log(response);
            });

            $http.get('/api/request5_medicine_type_buyers_amount?id='+type_id+'&firstDate='+
                date1+'&secondDate='+date2)
                .then(function (response){
                    $scope.request5_amount = response.data;
                    console.log(response);
                });
        }
        else window.alert(errorMessage);
    };

});