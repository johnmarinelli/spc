(ns spc.core
  (:use ring.adapter.jetty)
  (:use ring.util.response))

(defn handler [req]
  (response "Hello worldssss"))

(def app
  (-> handler))

(defn -main []
  (defonce server (run-jetty app { :port 8000 })))
