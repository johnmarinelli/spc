(ns spc.core
  (:use ring.adapter.jetty
        ring.middleware.not-modified
        clostache.parser)
  (:require [spc.handlers.index-handler :as index-handler]
            [spc.handlers.post-handler :as post-handler]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [compojure.response :as response]))

(defroutes main-routes
  (GET "/" [] (-> index-handler/index-handler 
                  (wrap-not-modified)))
  (GET "/post/new" [] (-> post-handler/post-handler))
  (POST "/post/create" [] (-> post-handler/post-handler)) ;this is dumb
  (GET "/posts" [] (-> post-handler/post-handler))
  (route/resources "/"))

(def app
  (-> (handler/site main-routes)))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "5000"))]
    (defonce server (run-jetty app { :port port }))))
