'use strict';

angular.module('productList').
    component('productList',{
        templateUrl: 'product-list/product-list.template.html',
        controller: function ProductsController($scope,$http){
            var self = this;
            this.count = 0;

            $http.get('http://localhost:3000/products').then(function(response){
                self.products = response.data;
            });

            $scope.addCart=function(product){
                self.count = self.count + 1;

                $http({
                    method: 'POST',
                    url:'http://localhost:4000/cart/',
                    data: product,
                    dataType:'json'
                }).then(function successCallback(response){
                    console.log("successfull");
                },function errorCallback(response){
                    if(response.status == 500){
                        console.log("duplicate id error");
                        $http({
                            method:'PUT',

                        })
                    }
                });
            }
        }
    });