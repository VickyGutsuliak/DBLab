var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){

    /******************************IngredientsCRUD*************************/
    $scope.ingredients = [];
    $http.get('/api/ingredients').then(function (response){
        $scope.ingredients = response.data;
        console.log(response);
    });

    this.del_ingredients = function del(id) {
        $http.get('/api/ingredients/del?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

    this.insert_ingredients = function add() {
        var id = document.getElementById("ingredientsId").value;
        var name = document.getElementById("ingredientsName").value;
        var criticalRate = document.getElementById("ingredientsCriticalRate").value;
        var amount = document.getElementById("ingredientsAmount").value;
        var price = document.getElementById("ingredientsPrice").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*)$/ ;
        var regexInt=/^[0-9]+$/ ;
        var regexDouble=/^([1-9])|([1-9][0-9]+)|([1-9][0-9]+\.[0-9]+)$/ ;
        if(!regexName.test(name.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if(!regexInt.test(criticalRate.toString())||!regexInt.test(amount.toString())){
            errorMessage=errorMessage+'-невірний формат цілого числа;\n';
            errorMessage=errorMessage+'Потрібний формат: ціле число;';
            isValid=false;
        }
        if(!regexDouble.test(price.toString())){
            errorMessage=errorMessage+'-невірний формат дробового числа;\n';
            errorMessage=errorMessage+'Потрібний формат: дробове число;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/ingredients/add?id='+id+'&name='+name+'&criticalRate='+criticalRate+
                '&amount='+amount+'&price='+price).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);
    };

    var idIngredients;
    this.start_update_ingredients = function updt(id, ingredientsNameUPD, ingredientsCriticalRateUPD, ingredientsAmountUPD, ingredientsPriceUPD) {
        idIngredients=id;
        document.getElementById("ingredientsNameUPD").value = ingredientsNameUPD;
        document.getElementById("ingredientsCriticalRateUPD").value = ingredientsCriticalRateUPD;
        document.getElementById("ingredientsAmountUPD").value = ingredientsAmountUPD;
        document.getElementById("ingredientsPriceUPD").value = ingredientsPriceUPD;
    };

    this.update_ingredients = function upd() {
        var name = document.getElementById("ingredientsNameUPD").value;
        var criticalRate = document.getElementById("ingredientsCriticalRateUPD").value;
        var amount = document.getElementById("ingredientsAmountUPD").value;
        var price = document.getElementById("ingredientsPriceUPD").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*)$/ ;
        var regexInt=/^[0-9]+$/ ;
        var regexDouble=/^([1-9])|([1-9][0-9]+)|([1-9][0-9]+\.[0-9]+)$/ ;
        if(!regexName.test(name.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if(!regexInt.test(criticalRate.toString())||!regexInt.test(amount.toString())){
            errorMessage=errorMessage+'-невірний формат цілого числа;\n';
            errorMessage=errorMessage+'Потрібний формат: ціле число;';
            isValid=false;
        }
        if(!regexDouble.test(price.toString())){
            errorMessage=errorMessage+'-невірний формат дробового числа;\n';
            errorMessage=errorMessage+'Потрібний формат: дробове число;';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/ingredients/upd?id='+idIngredients+'&name='+name+'&criticalRate='+criticalRate+
                '&amount='+amount+'&price='+price).then(function (response){
                window.location.reload();
            });
        }
        else window.alert(errorMessage);
    };
});