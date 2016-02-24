(ns spc.models.model-test-utils
  (:require [clojure.java.jdbc :as sql]
            [spc.models.base :refer :all]))

(defn delete-test-table [table]
  sql/delete! db-connection (str table "_test"))

(defn row-count [table]
  (:count (first (sql/query db-connection [(str "SELECT COUNT(*) FROM " table)]))))

(defn get-last-row [table]
  (first (sql/query db-connection [(str "SELECT * FROM " table " ORDER BY created_at DESC LIMIT 1")])))

(defn get-last-row-id [table]
  (:id (get-last-row table)))

(defn create-test-user []
  (sql/insert! db-connection :users_test {:username "u" :salt "s" :password "p" :email "e"}))

(defn delete-last-test-user []
  (sql/delete! db-connection :users_test ["id = ?" (get-last-row-id "users_test")]))

(defn create-test-post []
  (sql/insert! db-connection :posts_test {:title "title" :body "body" :user_id (get-last-row-id "users_test")}))

(defn delete-last-test-post []
  (sql/delete! db-connection :posts_test ["id = ?" (get-last-row-id "posts_test")]))
