angular
        .module('myApp', ['ngResource'])
        .service('CustomerRestService', function($resource) {
            return {
                getAll: function() {
                    var customerResource = $resource('api/customer', {}, {
                        execute: {method: 'GET', params: {}, isArray: true}
                    });
                    return customerResource;
                },
                save: function(customer) {
                    var customerResource = $resource('api/customer', customer, {
                        execute: {method: 'POST'}
                    });
                    return customerResource;
                },
                update: function(customer) {
                    var customerResource = $resource('api/customer', customer, {
                        execute: {method: 'PUT'}
                    });
                    return customerResource;
                },
                remove: function(customer) {
                    var customerResource = $resource('api/customer', customer, {
                        execute: {method: 'DELETE'}
                    });
                    return customerResource;
                },
            }
        })
        .controller('CustomerController', function($scope, CustomerRestService) {


            $scope.fetchCustomerList = function() {
                CustomerRestService.getAll().execute().$promise.then(function(response) {
                    $scope.customers = response;
                    $scope.resetCurrentCustomer();
                });
            }

            $scope.resetCurrentCustomer = function() {
                $scope.currentcustomer = '';
            }

            $scope.isNewCustomer = function(customer) {
                try {
                    if (customer !== '' && customer.id > 0) {
                        return false;
                    }
                } catch (e) {
                }

                return true;
            }

            $scope.setModel = function(customer) {
                $scope.currentcustomer = angular.copy(customer);
            }

            $scope.remove = function(customer) {
                CustomerRestService.remove(customer).execute().$promise.then(function() {
                    $scope.fetchCustomerList();
                });
            }

            $scope.submitForm = function(customer) {
                if ($scope.isNewCustomer(customer)) {
                    CustomerRestService.save(customer).execute().$promise.then(function() {
                        $scope.fetchCustomerList();
                    });
                } else {

                    CustomerRestService.update(customer).execute().$promise.then(function() {
                        $scope.fetchCustomerList();
                    });
                }
            }

            $scope.fetchCustomerList();

        });
