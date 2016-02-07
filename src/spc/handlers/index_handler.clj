(ns spc.handlers.index-handler
  (:use ring.util.response
        ring.middleware.content-type)
  (:require [spc.utils.template-utils :as template-utils]))

(defn index-handler [req]
  (-> (response (template-utils/render-template "index" { :name "world" }))
      (content-type "text/html")))

