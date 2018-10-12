'use strict';

angular.module('cartDetail').
    component('cartDetail',{
        templateUrl: "cart-detail/cart-detail.template.html",
        controller: ['$routeParams',function CartDetailController($routeParams){
            this.productId = $routeParams.productId;
        }]
    });