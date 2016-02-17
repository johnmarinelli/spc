(ns spc.models.like
  (require [spc.models.base :refer :all]))

; like model
(def like
  (ref (fn [post-id] {:post_id post-id})))

(defn create-like! [post-id & {:keys [db] :or {db :likes}}]
  (insert db (like post-id)))

(defn delete-like! [id & {:keys [db] :or {db :likes}}]
  (delete db id))
