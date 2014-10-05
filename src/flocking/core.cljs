(ns flocking.core
  (:require [flocking.utils :as utils])
  (:import [java.lang.Integer]))

(enable-console-print!)

(def num-boids 1000)
(def time-step 50)
(def repulsion-zone 50)
(def boid-size 10)
(def orientation-zone 100)
(def attraction-zone 150)
(def dimensions {:width 1200 :height 800})

(defn boid-position [x y] {:x x :y y})
(defn boid-velocity [dx dy] {:dx dx :dy dy})
(defn boid [position velocity] {:position position :velocity velocity})
(defn rand-position [max-x max-y] (boid-position (rand-int max-x) (rand-int max-y)))
(defn rand-velocity [max-dx max-dy] (boid-velocity (rand-int max-dx) (rand-int max-dy)))


(def initial-positions (map (fn [](rand-position (dimensions :width) (dimensions :height))) (range num-boids)))

(defn render [positions]
      (let [canvas (utils/by-id :flocking-canvas) context (utils/get-context canvas "2d")]
           (utils/clear-canvas context dimensions)
           (doseq [position positions]
                  (utils/fill-rect context (utils/rand-color) (position :x) (position :y) boid-size boid-size))) positions)

(defn update [positions] (map (fn [position] (boid-position (+ 10 (position :x)) (+ 10 (position :y))) ) positions))

(defn game-loop [positions] (utils/wait (fn [] (game-loop (render (update positions)))) time-step))

(defn ^:export flock [] (game-loop initial-positions))