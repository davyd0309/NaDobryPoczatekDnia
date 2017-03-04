/**
 * Created by Judyta on 04.03.2017.
 */

app.controller('loginController',function($scope){

    $scope.first = 1;
    $scope.second = 2;

    $scope.updateValue = function(){
        $scope.calculation = $scope.first + $scope.second;
    }

})