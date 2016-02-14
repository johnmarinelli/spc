(ns spc.models.user-model-test
  (:require [clojure.test :refer :all]
            [clojure.java.jdbc :as sql]
            [spc.models.base :refer :all]
            [spc.models.user :refer :all]))

(defn row-count [table]
  (:count (first (sql/query db-connection [(str "SELECT COUNT(*) FROM " table)]))))

(defn get-last-row [table]
  (first (sql/query db-connection [(str "SELECT * FROM " table " ORDER BY created_at DESC LIMIT 1")])))

(defn get-last-row-id [table]
  (:id (get-last-row table)))

(deftest user-create-test
  (let [initial-count (row-count "users_test")]
    (create-user! "username" "pw" "email" :db :users_test)
    (let [final-count (row-count "users_test")]
      (is (= final-count (+ initial-count 1))))))

(deftest user-update-test
  (let [last-user-email (:email (get-last-row "users_test"))
        new-email "new@email.com"]
    (update-user! {:email new-email} (get-last-row-id "users_test") :db :users_test)
    (let [last-user-new-email (:email (get-last-row "users_test"))]
      (is (= last-user-new-email new-email)))))

(deftest user-delete-test
  (let [initial-count (row-count "users_test")]
    (delete-user! (get-last-row-id "users_test") :db :users_test)
    (let [final-count (row-count "users_test")]
      (is (= final-count (- initial-count 1))))))
