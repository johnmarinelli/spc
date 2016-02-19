(ns spc.handlers.post-handler
  (:use ring.util.response
        ring.middleware.content-type)
  (:require [spc.utils.template-utils :as template-utils]))

(defn post-handler [req]
  (let [path (:compojure/route req)]
    (case path
      [:get "/post/new"] (-> (response (template-utils/render-template "post/new" {}))
                             (content-type "text/html")))))
