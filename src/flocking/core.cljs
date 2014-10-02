(ns flocking.core
  (:require [flocking.utils :as utils]))
(enable-console-print!)

(defn header []
      (let [header (utils/by-id :header)]
           (utils/set-html! header "Hello World")))

(defn canvas []
      (let [target (utils/by-id :canvas)
            context (utils/get-context target "2d")]
           (loop [x 80]
                 (when (> x 0)
                 (println x)
                 (utils/fill-rect context (+ x 100) (+ x 50) x x)
                 (recur (dec x))))))

(defn ^:export flock []
      (header)
      (canvas))