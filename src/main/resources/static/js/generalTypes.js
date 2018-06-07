var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){

    /******************************GeneralTypesCRUD*************************/
    $scope.generalTypes = [];
    $http.get('/api/general_types').then(function (response){
        $scope.generalTypes = response.data;
        console.log(response);
    });

    this.del_general_types = function del(id) {
        $http.get('/api/general_types/del?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

    this.insert_general_type = function add() {
        var id = document.getElementById("generalTypeId").value;
        var name = document.getElementById("generalTypeName").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*)$/ ;
        if(!regexName.test(name.toString())){
            errorMessage=errorMessage+'-невірний формат типу;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/general_types/add?id='+id+'&generalType='+name).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);
    };

    var idGenType;
    this.start_update_general_type = function updt(id, type) {
        idGenType=id;
        document.getElementById("generalTypeNameUPD").value = type;
        console.log(id+type);
    };

    this.update_general_type = function upd() {
        var name = document.getElementById("generalTypeNameUPD").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*)$/ ;
        if(!regexName.test(name.toString())){
            errorMessage=errorMessage+'-невірний формат типу;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/general_types/upd?id='+idGenType+'&generalType='+name).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);


    };
});