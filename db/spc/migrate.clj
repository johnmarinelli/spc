(ns db.spc.migrate
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(def uri 
  (str "jdbc:postgresql://localhost:" 
       (or (System/getenv "POSTGRES_PORT") 5432) 
       "/" 
       (System/getenv "POSTGRES_DATABASE") 
       "?user=" 
       (System/getenv "POSTGRES_USER") 
       "&password=" 
       (System/getenv "POSTGRES_PASSWORD")))

(defn load-config []
  {:datastore (jdbc/sql-database uri)
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (load-config)))

(defn rollback []
  (repl/rollback (load-config)))
