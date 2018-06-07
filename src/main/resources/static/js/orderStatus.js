var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){
    /******************************OrderStatusCRUD*************************/
    $scope.orderStatus = [];
    $http.get('/api/order_status').then(function (response){
        $scope.orderStatus = response.data;
        console.log(response);
    });

    this.del_order_status = function del(id) {
        $http.get('/api/order_status/del?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

    this.insert_order_status = function add() {
        var id = document.getElementById("orderStatusId").value;
        var name = document.getElementById("orderStatusName").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*)$/ ;
        if(!regexName.test(name.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/order_status/add?id='+id+'&nameOfStatus='+name).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);
    };

    var idOrderStatus;
    this.start_update_order_status = function updt(id, status) {
        idOrderStatus=id;
        document.getElementById("orderStatusNameUPD").value = status;

    };

    this.update_order_status = function upd() {
        var name = document.getElementById("orderStatusNameUPD").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*)$/ ;
        if(!regexName.test(name.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/order_status/upd?id='+idOrderStatus+'&nameOfStatus='+name).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);


    };
});