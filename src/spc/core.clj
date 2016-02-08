(ns spc.core
  (:use ring.adapter.jetty
        ring.middleware.not-modified
        clostache.parser)
  (:require [spc.handlers.index-handler :as index-handler]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  (GET "/" [] (-> index-handler/index-handler 
                  (wrap-not-modified)))
  (route/resources "/"))

(def app
  (-> (handler/site main-routes)))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (defonce server (run-jetty app { :port port }))))
