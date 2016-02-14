(ns spc.models.post
  (require [spc.models.base :refer :all]))

; post model
(def post 
  (ref (fn [title body user_id] {:title title :body body :user_id user_id })))

(defn create-post! [title body user_id & {:keys [db] 
  ())

(defn get-post [post_id]


