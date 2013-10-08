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

/**
 * The main angularPrime demo app module.
 *
 * @type {angular.Module}
 */

var demo = angular.module('ng-logging', [ ]);

demo.config(function($provide) {
    $provide.decorator('$log', function($delegate, $sniffer) {

        var _info = $delegate.info; //Saving the original behavior
        var _error = $delegate.error; //Saving the original behavior

        var log = log4javascript.getLogger();
        var ajaxAppender = new log4javascript.AjaxAppender("loggingServlet");
        ajaxAppender.setThreshold(log4javascript.Level.ALL);
        log.addAppender(ajaxAppender);

        $delegate.info = function(msg){
            _info(msg);
            log.info(msg);
        };

        $delegate.error = function(msg){
            _error(msg);
            log.error(msg);
        };

        $delegate.fatal = function(msg, exception){ //Adding additional method
            _error(msg);
            log.error(msg, exception);
        };

        return $delegate;
    });
});

demo.config(function($provide) {
    $provide.decorator('$exceptionHandler', function($delegate, $log) {
        return function(exception, cause) {
            $log.fatal(exception, cause);
            $delegate(cause, exception);

        };
    });
});

