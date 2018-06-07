var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){
    /******************************MedicinesCRUD*************************/
    $scope.medicines = [];
    $http.get('/api/medicine').then(function (response){
        $scope.medicines = response.data;
        console.log(response);
    });

    this.del_medicine = function del(id) {
        $http.get('/api/medicine/del?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

    this.start_insert_medicine = function add() {

        $http.get('/api/type/medicine').then(function (response){
            var types = response.data;
            var selector = document.getElementById("typeID");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].nameOfType;
                option.value = types[i].id;
                console.log(option);
                selector.add(option);
            }
        });
    };

    this.insert_medicine = function add() {
        var id = document.getElementById("medicineID").value;
        var nameOfMedicine = document.getElementById("medicineName").value;
        var indexOfType = document.getElementById("typeID").selectedIndex;
        var typeOfMedicineID = document.getElementById("typeID").options[indexOfType].value;
        var criticalRate = document.getElementById("criticalRate").value;
        var amount = document.getElementById("amount").value;
        var price = document.getElementById("price").value;
        var manufactureDate = document.getElementById("manufactureDate").value;
        var expirationTerm = document.getElementById("expirationTerm").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*[0-9]*)$/ ;
        var regexInt=/^[0-9]+$/ ;
        var regexDouble=/^([1-9][0-9]+)|([1-9][0-9]+\.[0-9]+)$/ ;
        if(!regexName.test(nameOfMedicine.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if(!regexInt.test(criticalRate.toString())||!regexInt.test(amount.toString())
            ||!regexInt.test(expirationTerm.toString())){
            errorMessage=errorMessage+'-невірний формат цілого числа;\n';
            errorMessage=errorMessage+'Потрібний формат: ціле число;';
            isValid=false;
        }
        if(!regexDouble.test(price.toString())){
            errorMessage=errorMessage+'-невірний формат дробового числа;\n';
            errorMessage=errorMessage+'Потрібний формат: дробове число;';
            isValid=false;
        }
        /*var regex=/^(20[0-9][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01])))|0$/;
        if(!regex.test(manufactureDate.toString())){
            errorMessage=errorMessage+'-невірний формат дати;\n';
            errorMessage=errorMessage+'Потріббний формат yyyy-mm-dd (рік-місяць-день);';
            isValid=false;
        }*/
        if (isValid) {
            if(manufactureDate==0) manufactureDate=null;
            $http.get('/api/medicine/add?id='+id+'&nameOfMedicine='+nameOfMedicine
                +'&type_id='+typeOfMedicineID+'&criticalRate='+criticalRate+'&amount='+amount
                +'&price='+price+'&manufactureDate='+manufactureDate+'&expirationTerm='+expirationTerm)
                .then(function (response){
                    window.location.reload();
                });
        }
    };

    var idMedicine;
    this.start_update_medicine = function updt(id, name, criticalRate, amount, price,
                                               manufactureDate, expirationTerm, type) {
        idMedicine = id;
        document.getElementById("medicineNameUPD").value = name;
        document.getElementById("criticalRateUPD").value = criticalRate;
        document.getElementById("amountUPD").value = amount;
        document.getElementById("priceUPD").value = price;
        document.getElementById("manufactureDateUPD").value = manufactureDate;
        document.getElementById("expirationTermUPD").value = expirationTerm;

        var typeId, typeName;
        $http.get('/api/type/medicine').then(function (response){
            var types = response.data;
            var selector = document.getElementById("typeIDUPD");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].nameOfType;
                option.value = types[i].id;
                console.log(option);
                if(types[i].nameOfType==type)
                {
                    typeId = i;
                    typeName=types[i].nameOfType;

                }
                selector.add(option);
            }
            document.getElementById("typeIDUPD").selectedIndex=typeId;
        });
        document.getElementById("typeIDUPD").value=typeName;
    };

    this.update_medicine = function upd() {
        var nameOfMedicine = document.getElementById("medicineNameUPD").value;
        var indexOfType = document.getElementById("typeIDUPD").selectedIndex;
        var typeOfMedicineID = document.getElementById("typeIDUPD").options[indexOfType].value;
        var criticalRate = document.getElementById("criticalRateUPD").value;
        var amount = document.getElementById("amountUPD").value;
        var price = document.getElementById("priceUPD").value;
        var manufactureDate = document.getElementById("manufactureDateUPD").value;
        var expirationTerm = document.getElementById("expirationTermUPD").value;

        var isValid=true;
        var errorMessage='Помилка: неправильні вхідні дані!\n';
        var regexName=/^([А-ЯІЄЇ'][а-яієї']+)|([А-ЯІЄЇ'][а-яієї']+(\s[а-яієї']+)*)$/ ;
        var regexInt=/^[0-9]+$/ ;
        var regexDouble=/^([1-9][0-9]+)|([1-9][0-9]+\.[0-9]+)$/ ;
        if(!regexName.test(nameOfMedicine.toString())){
            errorMessage=errorMessage+'-невірний формат Імені;\n';
            errorMessage=errorMessage+'Потрібний формат Перша буква з великої, далі малі, кирилицею;';
            isValid=false;
        }
        if(!regexInt.test(criticalRate.toString())||!regexInt.test(amount.toString())
            ||!regexInt.test(expirationTerm.toString())){
            errorMessage=errorMessage+'-невірний формат цілого числа;\n';
            errorMessage=errorMessage+'Потрібний формат: ціле число;';
            isValid=false;
        }
        if(!regexDouble.test(price.toString())){
            errorMessage=errorMessage+'-невірний формат дробового числа;\n';
            errorMessage=errorMessage+'Потрібний формат: дробове число;';
            isValid=false;
        }
        var regex=/^20[0-9][0-9]-((0[1-9])|(1[0-2]))-((0[1-9])|([12][0-9])|(3[01]))$/ ;
        if(!regex.test(manufactureDate.toString())){
            errorMessage=errorMessage+'-невірний формат дати;\n';
            errorMessage=errorMessage+'Потріббний формат yyyy-mm-dd (рік-місяць-день);';
            isValid=false;
        }
        if (isValid) {
            $http.get('/api/medicine/upd?id='+idMedicine+'&nameOfMedicine='+nameOfMedicine
                +'&type_id='+typeOfMedicineID+'&criticalRate='+criticalRate+'&amount='+amount
                +'&price='+price+'&manufactureDate='+manufactureDate+'&expirationTerm='+expirationTerm)
                .then(function (response){
                    window.location.reload();
                });
        }
        else window.alert(errorMessage);

    };



});