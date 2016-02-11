(defproject spc "0.1.0-SNAPSHOT"
  :min-lein-version "2.0.0"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [ring/ring-mock "0.3.0"]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 [compojure "1.4.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.2-1003-jdbc4"]
                 [korma "0.4.2"]
                 [ragtime "0.5.2"]]
  :aliases {"migrate" ["run" "-m" "spc.migrate.do/migrate"]
            "rollback" ["run" "-m" "spc.migrate.do/rollback"]}
  :main spc.core)
