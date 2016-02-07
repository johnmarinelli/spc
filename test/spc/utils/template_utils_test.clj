(ns spc.utils.template-utils-test
  (:require [clojure.test :refer :all]
            [spc.utils.template-utils :refer :all]))

(deftest template-path-test
  (let [template-str (template-path "test/mock")]
    (is (= template-str "templates/test/mock.mustache.html"))))

(deftest render-template-test 
  (let [template (render-template "test/mock" { :data "YEP" })]
    (is (= template "This is a template.  YEP\n"))))
