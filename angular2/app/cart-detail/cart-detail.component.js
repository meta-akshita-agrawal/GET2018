'use strict';

angular.module('cartDetail').
    component('cartDeatil',{
        templateUrl: "cart-detail/cart-detail.template.html",
        controller: ['$routeParams',function CartDetailController($routeParams){
            this.productId = $routeParams.productId;
        }]
    });