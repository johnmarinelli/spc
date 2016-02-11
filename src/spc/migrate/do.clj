(ns spc.migrate.do
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]))

(def uri 
  (str "jdbc:postgresql://localhost:" 
       (or (System/getenv "SPC_POSTGRES_PORT") 5432)
       "/" 
       (or (System/getenv "SPC_POSTGRES_DATABASE") "spc")
       "?user=" 
       (or (System/getenv "SPC_POSTGRES_USER") "postgres")
       "&password=" 
       (System/getenv "SPC_POSTGRES_PASSWORD")))

(defn load-config []
  {:datastore (jdbc/sql-database uri)
   :migrations (jdbc/load-resources "migrations")})

(defn migrate []
  (repl/migrate (load-config)))

(defn rollback []
  (repl/rollback (load-config)))
