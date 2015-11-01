angular
        .module('myApp', ['ngResource'])
        .service('CustomerService', function($log, $resource) {
            return {
                getAll: function() {
                    var userResource = $resource('api/customer', {}, {
                        query: {method: 'GET', params: {}, isArray: true}
                    });
                    return userResource.query();
                },
                save: function(customer) {
                    var userResource = $resource('api/customer', customer, {
                        save: {method: 'POST'}
                    });
                    return userResource.save();
                },
                update: function(customer) {
                    var userResource = $resource('api/customer', customer, {
                        update: {method: 'PUT'}
                    });
                    return userResource.update();
                },
                remove: function(customer) {
                    var userResource = $resource('api/customer', customer, {
                        delete: {method: 'DELETE'}
                    });
                    return userResource.delete();
                },
            }
        })
        .controller('CustomerController', function($scope, CustomerService, $timeout) {
            function generateList() {
                console.log('Calling Get List');
                $scope.customers = CustomerService.getAll();
                $scope.currentcustomer = '';
            }

            function refresh() {
                $timeout(generateList, 500);
            }

            generateList();

            $scope.isNewCustomer = function(customer) {
                if (customer == '') {
                    return true;
                }

                return false;
            }

            $scope.setModel = function(customer) {
                $scope.currentcustomer = angular.copy(customer);
            }

            $scope.remove = function(customer) {
                customer.retired = true;
                var returns = CustomerService.remove(customer);
                returns.$promise.then(refresh());
            }

            $scope.submitForm = function(customer) {
                var returns = "";

                if($scope.isNewCustomer(customer)){
                    returns = CustomerService.save(customer);
                }else{
                    returns = CustomerService.update(customer);
                }
                
                returns.$promise.then(refresh());
            }



        });
