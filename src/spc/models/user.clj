(ns spc.models.user
  (require [spc.models.base :refer :all]))

; user model
; todo: implement security hashing w/ salt
(def user 
  (ref (fn [username pw email] {:username username :salt "salt" :password pw :email email})))

(defn create-user! [username pw email & {:keys [db] :or {db :users}}]
  (insert db (user username pw email)))

(defn get-user [id & {:keys [db] :or {db :users}}]
  (get-row db id))

(defn update-user! [new-vals id & {:keys [db] :or {db :users}}]
  (update-row db new-vals id))

(defn delete-user! [id & {:keys [db] :or {db :users}}]
  (delete db id))
