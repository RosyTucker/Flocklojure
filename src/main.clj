(ns main
  (:use [ask.routes :only [app]]
        [org.httpkit.server :only [run-server]]))

(defonce server (atom nil))

(defn -main [& args]
  (reset! server (run-server #'app {:port 8080}))
  (println "Running server on 8080."))
