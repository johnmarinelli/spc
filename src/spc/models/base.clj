; base model.  takes care of db connections
(ns spc.models.base
  (require [clojure.java.jdbc :as sql]))

(def db-connection { 
  :classname "org.postgresql.Driver" 
  :subprotocol "postgresql" 
  :subname (str "//localhost:" (or (System/getenv "SPC_POSTGRES_PORT") 5432) "/" (System/getenv "SPC_POSTGRES_DATABASE"))
  :password (System/getenv "SPC_POSTGRES_PASSWORD")
})

(defn insert [^clojure.lang.Keyword table ^clojure.lang.PersistentArrayMap item]
  (sql/insert! db-connection table item))

; todo: lmao remove this when figure out how to dynamic sql w/ mutliple params
(defn get-row [^clojure.lang.Keyword table ^Integer id]
  (first (sql/query db-connection [(str "SELECT * FROM " table " WHERE ID = " id)])))

(defn update-row [^clojure.lang.Keyword table ^clojure.lang.PersistentArrayMap new-vals ^Integer id]
  (sql/update! db-connection table new-vals ["id = ?" id]))

(defn delete [^clojure.lang.Keyword table ^Integer id]
  (sql/delete! db-connection table ["id = ?" id]))
