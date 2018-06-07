var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){

    /******************************DatesCRUD*************************/
    $scope.dates = [];
    $http.get('/api/dates').then(function (response){
        $scope.dates = response.data;
        console.log(response);
    });

    this.del_dates = function del(id) {
        $http.get('/api/dates/del?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

    this.start_insert_dates = function add() {

        $http.get('/api/order_status').then(function (response){
            var orderStatus = response.data;
            var selector = document.getElementById("orderStatusID");
            $(selector).empty();
            for (var i = 0; i < orderStatus.length; i++) {
                var option = document.createElement("option");
                option.text = orderStatus[i].nameOfStatus;
                option.value = orderStatus[i].id;
                console.log(option);
                selector.add(option);
            }
        });
    };

    this.insert_date = function add() {
        var id = document.getElementById("datesId").value;
        var dateOfOrdering = document.getElementById("dateOfOrdering").value;
        var dateOfReceiving = document.getElementById("dateOfReceiving").value;
        var indexOfOrderStatus = document.getElementById("orderStatusID").selectedIndex;
        var orderStatus = document.getElementById("orderStatusID").options[indexOfOrderStatus].value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regex=/^20[0-9][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))$/ ;
        if(!regex.test(dateOfOrdering.toString())||!regex.test(dateOfReceiving.toString())){
            errorMessage=errorMessage+'-невірний формат дати;\n';
            errorMessage=errorMessage+'Потріббний формат yyyy-mm-dd (рік-місяць-день);';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/dates/add?id='+id+'&dateOfOrdering='+dateOfOrdering+'&dateOfReceiving='
                +dateOfReceiving+'&orderStatus_id='+orderStatus).then(function (response){
                setTimeout(function(){
                    window.location.reload();
                });
            });
        }else window.alert(errorMessage);
    };

    var idDates;
    this.start_update_dates = function updt(id, ordering, receiving, orderStatusN) {
        idDates = id;
        document.getElementById("dateOfOrderingUPD").value = ordering;
        document.getElementById("dateOfReceivingUPD").value = receiving;

        var orderStatusID, orderStatusName;
        $http.get('/api/order_status').then(function (response){
            var orderStatus = response.data;
            var selector = document.getElementById("orderStatusIDUPD");
            $(selector).empty();
            for (var i = 0; i < orderStatus.length; i++) {
                var option = document.createElement("option");
                option.text = orderStatus[i].nameOfStatus;
                option.value = orderStatus[i].id;
                console.log(option);
                if(orderStatus[i].nameOfStatus==orderStatusN)
                {
                    orderStatusID = i;
                    orderStatusName=orderStatus[i].nameOfStatus;

                }
                selector.add(option);
            }
            document.getElementById("orderStatusIDUPD").selectedIndex=orderStatusID;
        });
        document.getElementById("orderStatusIDUPD").value=orderStatusName;
    };

    this.update_date = function upd() {
        var dateOfOrdering = document.getElementById("dateOfOrderingUPD").value;
        var dateOfReceiving = document.getElementById("dateOfReceivingUPD").value;
        var indexOfOrderStatus = document.getElementById("orderStatusIDUPD").selectedIndex;
        var orderStatus = document.getElementById("orderStatusIDUPD").options[indexOfOrderStatus].value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regex=/^20[0-9][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))$/ ;
        if(!regex.test(dateOfOrdering.toString())||!regex.test(dateOfReceiving.toString())){
            errorMessage=errorMessage+'-невірний формат дати;\n';
            errorMessage=errorMessage+'Потрібний формат yyyy-mm-dd (рік-місяць-день);';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/dates/upd?id='+idDates+'&dateOfOrdering='+dateOfOrdering+'&dateOfReceiving='
                +dateOfReceiving+'&orderStatus_id='+orderStatus).then(function (response){
                setTimeout(function(){
                    window.location.reload();
                });
            });
        }else window.alert(errorMessage);


    };
});