'use strict';

angular.module('cartDetail').
    component('cartDetail',{
        templateUrl: "cart-detail/cart-detail.template.html",
        controller: ['$routeParams','$http',function CartDetailController($routeParams,$http){
            this.cartCount = $routeParams.cartCount;
            var self = this;
            $http.get('http://localhost:4000/cart').then(function(response){
                self.items = response.data;
                var item;
                self.totalPrice=0;
                for(item in self.items){
                    self.totalPrice += self.items[item].price;  
                }
            });

        }]
    });