(ns spc.core)
(use 'ring.util.response)

(defn handler [req]
  (response "Hello worldssss"))

(def app
  (-> handler))
