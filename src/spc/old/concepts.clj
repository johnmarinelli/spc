(ns spc.core)
(use 'ring.util.response)


(defn handler [req]
  { :status 200 :body "Hello Worldss" })

(defn wrap-res-status [handler status]
  (fn [req]
    (let [res (handler req)]
      (assoc-in res [:status] status))))

(defn wrap-content-type [handler content-type]
  (fn [req]
    (let [res (handler req)]
      (assoc-in res [:headers "Content-Type"] content-type))))

(defn print-handler [handler]
  (println (handler :body)))

(def app
  (-> handler 
    ; middleware
    (wrap-res-status 200)
    (wrap-content-type "text/html")
    (print-handler)))

