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

            $scope.submitFilter=function(){
                $scope.SearchList = $scope.searchText;
            }

            $scope.addCart=function(product){
                self.cartCount = self.cartCount + 1;
                

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
                }).then(function successCallback(response){
                    console.log("successfull");
                },function errorCallback(response){
                    if(response.status == 500){
                        cartData.count += 1;
                        cartData.price = cartData.price * cartData.count;
                        $http({
                            method: 'PUT',
                            url:'http://localhost:4000/cart/' + cartData.id,
                            data: cartData,
                            dataType:'json'
                        })
                    }
                });
            }
        }
    });