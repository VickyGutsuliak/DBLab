var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){
    /******************************TypeOfMedicineHasTypeOfUsingCRUD*************************/
    $scope.typeOfMedicineHasTypeOfUsing = [];
    $http.get('/api/type_medicine_has_type_using').then(function (response){
        $scope.typeOfProductionHasTypeOfUsing = response.data;
        console.log(response);
    });

    this.del_type_of_medicine_has_type_of_using = function del(id) {
        $http.get('/api/type_medicine_has_type_using/del?id=' + id).then(function (response) {
            window.location.reload();
        });
    };

    this.start_insert_type_of_medicine_has_type_of_using = function add() {

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

            $http.get('/api/type/using').then(function (response) {
                var types = response.data;
                var selector = document.getElementById("usingID");
                $(selector).empty();
                for (var i = 0; i < types.length; i++) {
                    var option = document.createElement("option");
                    option.text = types[i].nameOfType;
                    option.value = types[i].id;
                    console.log(option);
                    selector.add(option);
                }
            });
        });
    };

    this.insert_type_of_medicine_has_type_of_using = function add() {
        var id = document.getElementById("id").value;
        var indexOfMedicineType = document.getElementById("typeID").selectedIndex;
        var medicineType_id = document.getElementById("typeID").options[indexOfMedicineType].value;
        var indexOfUsingType = document.getElementById("usingID").selectedIndex;
        var usingType_id = document.getElementById("usingID").options[indexOfUsingType].value;


        $http.get('/api/type_medicine_has_type_using/add?id='+id+'&type_of_medicine_id='+medicineType_id
            +'&type_of_using_id='+usingType_id).then(function (response){
            window.location.reload();
        });
    };

    var idUpdate;
    this.start_update_type_of_medicine_has_type_of_using = function updt(id, type_medicine, type_using) {
        idUpdate = id;
        var medicineID, usingID, medicineName, usingName;

        $http.get('/api/type/medicine').then(function (response){
            var types = response.data;
            var selector = document.getElementById("typeIDUPD");
            $(selector).empty();
            for (var i = 0; i < types.length; i++) {
                var option = document.createElement("option");
                option.text = types[i].nameOfType;
                option.value = types[i].id;
                console.log(option);
                if(types[i].nameOfType==type_medicine)
                {
                    medicineID = i;
                    medicineName=types[i].nameOfType;

                }
                selector.add(option);
            }
            document.getElementById("typeIDUPD").selectedIndex=medicineID;

            $http.get('/api/type/using').then(function (response) {
                var types = response.data;
                var selector = document.getElementById("usingIDUPD");
                $(selector).empty();
                for (var i = 0; i < types.length; i++) {
                    var option = document.createElement("option");
                    option.text = types[i].nameOfType;
                    option.value = types[i].id;
                    console.log(option);
                    if(types[i].nameOfType==type_using)
                    {
                        usingID = i;
                        usingName=types[i].nameOfType;

                    }
                    selector.add(option);
                }
                document.getElementById("usingIDUPD").selectedIndex=usingID;
            });
            document.getElementById("usingIDUPD").value=usingName;
        });
        document.getElementById("typeIDUPD").value=medicineName;
    };

    this.update_type_of_medicine_has_type_of_using = function upd() {
        var indexOfMedicineType = document.getElementById("typeIDUPD").selectedIndex;
        var medicineType_id = document.getElementById("typeIDUPD").options[indexOfMedicineType].value;
        var indexOfUsingType = document.getElementById("usingIDUPD").selectedIndex;
        var usingType_id = document.getElementById("usingIDUPD").options[indexOfUsingType].value;


        $http.get('/api/type_medicine_has_type_using/upd?id='+idUpdate
            +'&type_of_medicine_id='+medicineType_id
            +'&type_of_using_id='+usingType_id).then(function (response){
            window.location.reload();
        });
    };


});