angular.module('dispenserApp', ['ngMaterial', 'ngMessages', 'dispenserService'])
    .controller('DispenserCtrl', ['$scope', 'CoinDispenserService', function ($scope, CoinDispenserService) {

        $scope.dispenseCoinsFunc = function () {

            var dispense = {
                amount: this.amount,
                coinDenominations: this.denomination
            };

            if (dispense.amount !== undefined && dispense.coinDenominations !== undefined) {
                CoinDispenserService.dispenseCoins(dispense).then(function (value) {
                    console.log('Http response code' + value.status);
                    if (value.data) {
                        alert('Successfully retrieved coins, please collect your coins. \n\nCOINS: ' + value.data.toString());
                        this.dispenserForm.reset();
                    } else {
                        alert('Failed to retrieve coins for amount ' + dispense.amount + ', please try again later.');
                    }
                });
            } else {
                alert('Retrieval of coins failed.');
            }
        };

        $scope.clearFields = function () {

            this.dispenserForm.$valid();
            this.dispenserForm.$setPristine();
            this.dispenserForm.$setUntouched();
        };

    }]);