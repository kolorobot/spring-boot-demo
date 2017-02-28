(function () {

    "use strict";

    const todoApp = angular.module("todoApp", []);

    todoApp.controller("TodoCtrl", function ($http) {

        const vm = this;
        const newTask = {title: '', done: false};

        let init = function () {
            console.info("Init");
            $http.get("http://localhost:8080/task").then((response) => {
                vm.tasks = response.data.content;
            })
        };
        init();

        let save = function (form) {
            console.info("Save");
            $http.post("http://localhost:8080/task", vm.task).then(function (response) {
                vm.tasks.push(response.data);
            });

            vm.task = angular.copy(newTask);
            form.$setPristine();
        };

        let refresh = function () {
            init();
        };

        vm.task = angular.copy(newTask);
        vm.tasks = [];
        vm.save = save;
        vm.refresh = refresh;
    });

})();