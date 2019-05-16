(function () {
    'use strict';

    angular
        .module('app')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['$http']; //access to restcontroller we need a dependancy to http

    function AdminController($http) {
        var adm = this;
        adm.admin=[];
        adm.getAll=getAll;
        adm.deleteuser=deleteuser;

        init();
        function init() {
            getAll();

        }

        function getAll() {
            var url="/admin/all";
            var admindata=$http.get(url);
            admindata.then(function (response) {
                adm.admin=response.data;
            });

        }

        function deleteuser(id) {
            var url="/admin/delete/"+id;
            var admindata=$http.post(url);
            admindata.then(function (response) {
                adm.admin=response.data;
            });

        }
        function createuser() {
            var url="/admin/create/";
            var admindata=$http.post(url);
            admindata.then(function (response) {
                adm.admin=response.data;
            });

        }
    }
})();
