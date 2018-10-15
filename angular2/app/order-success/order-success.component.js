'use strict';

angular.module('orderSuccess').
    component('orderSuccess',{
        templateUrl:"order-success/order-success.template.html",
        controller:['$routeParams',function OrderSuccessController($routeParams){
            this.cartCount = $routeParams.cartCount;
        }]
    });