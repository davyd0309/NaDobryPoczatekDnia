/**
 * Created by Judyta on 04.03.2017.
 */

app.controller('loginController',function($scope,$window){


    $scope.login = "";
    $scope.password="";

    $scope.checkLogin = function(){
        $window.location.href = 'zaloguj';
    }




})