'use strict';

angular.module('shippingDetail').
    component('shippingDetail',{
        templateUrl:"shipping-detail/shipping-detail.template.html",
        controller:['$routeParams','$http','$scope',function ShippingDetailController($routeParams,$http,$scope){
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

            $http.get('http://localhost:3001/shipping').then(function(response){
                self.shipping = response.data;
                console.log(self.shipping[0].name);
            });
            
            $scope.placeOrder=function(){
                $http({
                    method:'PUT',
                    data:self.shipping[0],
                    url:'http://localhost:3001/shipping/'+self.shipping[0].id,
                    dataType:'json'
                }).then(function(response){
                    console.log("successfull");
                });
                $http.get('http://localhost:4000/cart').then(function(response){
                    self.items = response.data;
                });

                var today = new Date();
                var dd = today.getDate();
                var mm = today.getMonth()+1; //January is 0!
                var yyyy = today.getFullYear();

                today = mm + '/' + dd + '/' + yyyy;


                var orderData={
                    "items":self.items,
                    "customerName":self.shipping[0].name,
                    "date":today
                }

                $http({
                    method:'POST',
                    url:'http://localhost:3002/orders',
                    data:orderData,
                    dataType:'json'
                });

                var item=1;
                for(item in self.items){
                    console.log(item.id);
                    $http.delete('http://localhost:4000/cart/' + self.items[item].id, item).then(function(response){
                        console.log("successfull");
                    })
                }
                window.location="#!/products/order-success/" + 0;   
            }
            
        }]
    });