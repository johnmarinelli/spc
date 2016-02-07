(ns spc.utils.template-utils
  (:use clostache.parser))

(defn template-path [template-name]
  (str "templates/" template-name ".mustache.html"))

(defn render-template [template-name params]
  (render-resource (template-path template-name) params))

