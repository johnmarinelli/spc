(ns spc.models.like-model-test
  (:require [clojure.test :refer :all]
            [spc.models.model-test-utils :refer :all]
            [spc.models.like :refer :all]))

(defn create-post-fixture [f]
  (create-test-post)
  (f)
  (delete-last-test-post))

(use-fixtures :once create-post-fixture)

(deftest like-create-test
  (let [initial-count (row-count "likes_test")]
    (create-like! (get-last-row-id "posts_test") :db :likes_test)
    (let [final-count (row-count "likes_test")]
      (is (= final-count (+ initial-count 1))))))

(deftest like-delete-test
  (create-like! (get-last-row-id "posts_test") :db :likes_test)
  (let [initial-count (row-count "likes_test")]
    (delete-like! (get-last-row-id "likes_test") :db :likes_test)
    (let [final-count (row-count "likes_test")]
      (is (or (= final-count 0) (= final-count (- initial-count 1)))))))
