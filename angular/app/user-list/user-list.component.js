'use strict';

angular.module('userList').
    component('userList',{
        templateUrl: 'user-list/user-list.template.html',
        controller: function UserListController($scope,$http){
            var self= this;

            $http.get('http://localhost:3000/users').then(function(response){
                self.users = response.data;
            });

            $scope.postData=function(){
                $http({
                    method:'POST',
                    url:'http://localhost:3000/users/',
                    data: $scope.user,
                    dataType:'json'
                });

                window.location.reload();
            };

            $scope.putData=function(){
                
            }
        }
    });