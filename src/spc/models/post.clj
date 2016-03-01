(ns spc.models.post
  (require [spc.models.base :refer :all]))

; post model
(def post 
  (ref (fn [title body user-id] {:title title :body body :user_id user-id })))

(defn create-post! [title body user-id & {:keys [db] :or {db :posts}}] 
  (insert db (post title body user-id)))

(defn get-post [post-id & {:keys [db] :or {db :posts}}]
  (get-row db post-id))

(defn get-all-post-rows []
  (get-rows :posts))

(defn update-post! [new-vals id & {:keys [db] :or {db :posts}}]
  (update-row db new-vals id))

(defn delete-post! [id & {:keys [db] :or {db :posts}}]
  (delete db id))
