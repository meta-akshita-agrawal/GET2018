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

            this.addCart=function(){
                console.log("m here");
                self.count = self.count + 1;
            }
        }
    });