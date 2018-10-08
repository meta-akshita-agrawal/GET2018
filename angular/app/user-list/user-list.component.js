'use strict';

angular.module('userList').
    component('userList',{
        templateUrl: 'user-list/user-list.template.html',
        controller: function UserListController($scope,$http){
            var self= this;

            $http.get('http://localhost:3000/users').then(function(response){
                self.users = response.data;
            });

            $scope.putData=function(){
                var userData={
                    "id":9,
                    "name":"akshitaag",
                    "phone":"978977897",
                    "location":"mumbai"
                };
            
                // $http.post('users/users.json',JSON.stringify(data)).then(function(response){
                //     if(response.data){
                //         $scope.msg="succesfull";
                //     }
                //     else{
                //         $scope.msg="error";
                //     }
                // });


                $http({
                    method:'PUT',
                    url:'http://localhost:3000/users/9',
                    data: userData,
                    dataType:'json'
                });
            };
        }
    });