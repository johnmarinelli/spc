(ns spc.core
  (:use ring.adapter.jetty
        ring.util.response))

(defn handler [req]
  (response "Hello worldssss"))

(def app
  (-> handler))

(defn -main []
  ([let port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (defonce server (run-jetty app { :port port }))))
