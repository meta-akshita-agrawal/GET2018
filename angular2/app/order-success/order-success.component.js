'use strict';

angular.module('orderSuccess').
    component('orderSuccess',{
        templateUrl:"order-success/order-success.template.html",
        controller:function OrderSuccessController($http){
            this.cartCount = 0;

            $http.get('http://localhost:3000/cart').then(function(response){
                self.items = response.data;
                var item;
                for(item in self.items){
                    self.cartCount += self.items[item].count;
                }
            });
        }
    });