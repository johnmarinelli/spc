(ns spc.handlers.post-handler
  (:use ring.util.response
        ring.middleware.content-type)
  (:require [spc.utils.template-utils :as template-utils]
            [spc.models.post :refer :all]))

(defn post-handler [req]
  (let [path (:compojure/route req)]
    (case path
      [:get "/post/new"] (-> (response (template-utils/render-template "post/new" {}))
                             (content-type "text/html"))
      [:post "/post/create"] (let [title   (:title (:params req))
                                   body    (:body (:params req))
                                   user_id (Integer. (:user_id (:params req)))]
                               (create-post! title body user_id)))))
