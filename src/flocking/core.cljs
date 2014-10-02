(ns flocking.core
(:use [flocking.utils :only [set-html! by-id]]))
(enable-console-print!)

(defn ^:export flock []
      (println "Hello world!")
      (let [header (by-id :header)]
           (set-html! header "Hello World")))
