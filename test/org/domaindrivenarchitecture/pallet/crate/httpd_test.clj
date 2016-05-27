; Licensed to the Apache Software Foundation (ASF) under one
; or more contributor license agreements. See the NOTICE file
; distributed with this work for additional information
; regarding copyright ownership. The ASF licenses this file
; to you under the Apache License, Version 2.0 (the
; "License"); you may not use this file except in compliance
; with the License. You may obtain a copy of the License at
;
; http://www.apache.org/licenses/LICENSE-2.0
;
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.

(ns org.domaindrivenarchitecture.pallet.crate.httpd-test
  (:require
    [clojure.test :refer :all]    
    [clojure.set :as cloj-set]
    [schema.core :as s]
    [org.domaindrivenarchitecture.pallet.crate.httpd :as sut]
    
  ))

(def partial-config
  {:fqdn "localhost.localdomain"
   :listening-port "42"
   :server-admin-email "max@masterman.com"
   :httpd {; Webserver Configuration
           :letsencrypt true
           :letsencrypt-mail "new value"
          }
   :consider-jk false})

(deftest merge-releaseapps
  (testing
    "default-httpd-webserver-configuration match schema?"
    (is (s/validate sut/HttpdConfig (sut/merge-config partial-config)))))


(run-tests)
