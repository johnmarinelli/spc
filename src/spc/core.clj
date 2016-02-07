(ns spc.core
  (:use ring.adapter.jetty
        ring.middleware.not-modified
        clostache.parser)
  (:require [spc.handlers.index-handler :as index-handler]))

(def app
  (-> index-handler/index-handler
      (wrap-not-modified)))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (defonce server (run-jetty app { :port port }))))
