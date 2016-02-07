(ns spc.handlers.index-handler-test
  (:require [clojure.test :refer :all]
            [spc.handlers.index-handler :refer :all]
            [ring.mock.request :as mock]))

(deftest index-handler-test
  (let [res (index-handler (mock/request :get "/"))]
    (is (= (:status res) 200))
    (is (= (:headers res) { "Content-Type" "text/html" }))))
