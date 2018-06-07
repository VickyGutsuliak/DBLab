var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){

    /******************************BuyerCRUD*************************/
    $scope.buyers = [];
    $http.get('/api/buyers').then(function (response) {
        $scope.buyers = response.data;
        console.log(response);
    });

    this.del_buyer = function del(id) {
        $http.get('/api/buyers/del?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

    this.insert_buyer = function add() {
        var id = document.getElementById("buyerId").value;
        var pib = document.getElementById("buyerPIB").value;
        var age = document.getElementById("buyerAge").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^[А-ЯІЄЇ][а-яієї']+\s[А-ЯІЄЇ][а-яієї']+\s?[А-ЯІЄЇ'][а-яієї']+$/ ;
        var regexAge=/^1[6-9]|[2-9][0-9]$/ ;
        if(!regexName.test(pib.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Прізвище Ім\'я По-Батькові;\n';
            isValid=false;
        }
        if(!regexAge.test(age.toString())){
            errorMessage=errorMessage+'-невірний формат віку;\n';
            errorMessage=errorMessage+'Потрібний формат: якщо перша цифра 1, то друга від 6 до 9\n' +
                'якщо перша від двох до 9, друга будь-яка цифра;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/buyers/add?id='+id+'&PIB='+pib+'&age='+age).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);

    };

    var idBuyer;
    this.start_update_buyer = function updt(id, PIB, age) {
        idBuyer=id;
        document.getElementById("buyerPIBUPD").value = PIB;
        document.getElementById("buyerAgeUPD").value = age;
    };

    this.update_buyer = function upd() {
        var pib = document.getElementById("buyerPIBUPD").value;
        var age = document.getElementById("buyerAgeUPD").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^[А-ЯІЄЇ][а-яієї']+\s[А-ЯІЄЇ][а-яієї']+\s?[А-ЯІЄЇ'][а-яієї']+$/ ;
        var regexAge=/^1[6-9]|[2-9][0-9]$/ ;
        if(!regexName.test(pib.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Прізвище Ім\'я По-Батькові;\n';
            isValid=false;
        }
        if(!regexAge.test(age.toString())){
            errorMessage=errorMessage+'-невірний формат віку;\n';
            errorMessage=errorMessage+'Потрібний формат: якщо перша цифра 1, то друга від 6 до 9\n' +
                'якщо перша від двох до 9, друга будь-яка цифра;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/buyers/upd?id='+idBuyer+'&PIB='+pib+'&age='+age).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);
    };
});