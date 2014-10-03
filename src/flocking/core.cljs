(ns flocking.core
  (:require [flocking.utils :as utils])
  (:import [java.lang.Integer]))

(enable-console-print!)

(def num-boids 1000)
(def time-step 50)
(def dimensions {:width 1200 :height 800})

(defn boid-position [x y] {:x x :y y})

(def initial-positions (map (fn [x] (boid-position (rand-int (dimensions :width)) (rand-int (dimensions :height)))) (range num-boids)))

(defn render [positions]
      (let [canvas (utils/by-id :flocking-canvas) context (utils/get-context canvas "2d")]
           (utils/clear-canvas context dimensions)
           (doseq [position positions]
                  (utils/fill-rect context (utils/rand-color) (position :x) (position :y) 10 10)))
      positions)

(defn update [positions] (map (fn [position] (boid-position (+ 10 (position :x)) (+ 10 (position :y))) ) positions))

(defn game-loop [positions] (utils/wait (fn [] (game-loop (render (update positions)))) time-step))

(defn ^:export flock []
      (game-loop initial-positions)
      )