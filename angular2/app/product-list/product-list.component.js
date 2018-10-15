'use strict';

angular.module('productList').
    component('productList',{
        templateUrl: 'product-list/product-list.template.html',
        controller: function ProductsController($scope,$http){
            var self = this;
            this.cartCount = 0;

            $http.get('http://localhost:3000/products').then(function(response){
                self.products = response.data;
            });

            $scope.addCart=function(product){
                self.cartCount = self.cartCount + 1;
                





                

                //self.increment(cartData);

                
                //console.log(product.count);

                $http.get('http://localhost:4000/cart/' + product.id).then(function successCallback(response){
                    response.data.count += 1;
                    response.data.price = response.data.count * response.data.price;
                    $http({
                        method: 'PUT',
                        url:'http://localhost:4000/cart/' + product.id,
                        data: response.data,
                        dataType:'json'
                    });
                },function errorCallback(response){
            
                        var cartData = {
                            "id":product.id,
                            "title":product.title,
                            "price":product.price,
                            "imageUrl":product.imageUrl,
                            "count":1
                        }

                        $http({
                            method: 'POST',
                            url:'http://localhost:4000/cart/',
                            data: cartData,
                            dataType:'json'
                        })
                    
                });
            }


            
        }
    });