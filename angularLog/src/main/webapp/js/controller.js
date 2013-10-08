/**
 * Copyright 2013 Tim Down.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
'use strict';

angular.module('ng-logging').controller('LoggingController', function ($scope, $log) {

    $scope.logMessage = '';

    $scope.info = function () {
        $log.info($scope.logMessage);
    };

    $scope.doException = function () {
        throw new Error("Some Exception occurred that needs to be logged");
    }

});