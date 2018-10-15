'use strict';

angular.module('orders').
    component('orders',{
        templateUrl:"orders/orders.template.html",
        controller:['$routeParams','$http',function OrdersController($routeParams,$http){
            this.cartCount = $routeParams.cartCount;
            var self=this;

            $http.get('http://localhost:3002/orders').then(function(response){
                self.orders = response.data;
                console.log(self.orders[0].userId);
            });

            //console.log(self.orders[0].user-id);
        }]
    });