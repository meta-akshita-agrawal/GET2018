'use strict';

angular.module('orders').
    component('orders',{
        templateUrl:"orders/orders.template.html",
        controller:function OrdersController($http,$scope){
            this.cartCount = 0;
            var self=this;

            $http.get('http://localhost:3000/cart').then(function(response){
                self.items = response.data;
                var item;
                for(item in self.items){
                    self.cartCount += self.items[item].count;
                }
            });

            $http.get('http://localhost:3000/orders').then(function(response){
                self.orders = response.data;
                console.log(self.orders[0].userId);
            });

            $scope.getOrder=function(orderId){
            
                $http.get('http://localhost:3000/orders/'+ orderId).then(function(response){
                    self.items = response.data.items;
                    var item;
                    self.totalPrice=0;
                    for(item in self.items){
                        self.totalPrice += self.items[item].price;  
                    }
                });
            }
            //console.log(self.orders[0].user-id);
        }
    });