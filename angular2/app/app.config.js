'use strict';

angular.module('shoppingApp').
    config(['$locationProvider','$routeProvider',
        function config($locationProvider,$routeProvider){

            $locationProvider.hashPrefix('!');

            $routeProvider.
                when('/products',{
                    template:'<product-list></product-list>'
                }).
                when('/products/:productId',{
                    template:'<cart-detail></cart-detail>'
                }).
                otherwise('/products');
        }
    ]);