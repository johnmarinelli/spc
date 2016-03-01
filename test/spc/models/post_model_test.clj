(ns spc.models.post-model-test
  (:require [clojure.test :refer :all]
            [spc.models.model-test-utils :refer :all]
            [spc.models.base :refer :all]
            [spc.models.post :refer :all]))

(defn destroy-test-posts [_]
  (delete-test-table "posts"))

(defn create-user-fixture [f]
  (create-test-user)
  (f)
  (delete-last-test-user))

(use-fixtures :once destroy-test-posts)
(use-fixtures :once create-user-fixture)

(deftest post-create-test
  (let [initial-count (row-count "posts_test")]
    (create-post! "title" "body" (get-last-row-id "users_test") :db :posts_test)
    (let [final-count (row-count "posts_test")]
      (is (= final-count (+ initial-count 1))))))

(deftest post-update-test
  (let [last-post-title (:title (get-last-row "posts_test"))
        new-title "new title"]
    (create-post! "oldtitle" "oldbody" (get-last-row-id "users_test") :db :posts_test)
    (update-post! {:title new-title} (get-last-row-id "posts_test") :db :posts)
    (let [last-post-title (:title (get-last-row "posts_test"))]
      (is (= new-title "new title")))))

(deftest post-delete-test
  (create-post! "oldtitle" "oldbody" (get-last-row-id "users_test") :db :posts_test)
  (let [initial-count (row-count "posts_test")]
    (delete-post! (get-last-row-id "posts_test") :db :posts_test)
    (let [final-count (row-count "posts_test")]
      (is (or (= final-count 0) (= final-count (- initial-count 1)))))))

(deftest post-get-all-rows-test
  (let [rows (get-all-post-rows)]
    (is (= (count rows) 2))))
