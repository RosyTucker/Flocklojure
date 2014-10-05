(ns flocking.core
  (:require [flocking.utils :as utils]))

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
(defn rand-velocity [max-dx max-dy] (boid-velocity (rand max-dx) (rand max-dy)))
(defn rand-boid [] (boid (rand-position (dimensions :width) (dimensions :height))(rand-velocity 1 1)))

(def initial-boids (map (fn [] (rand-boid)) (range num-boids)))

(defn render [boids]
      (let [canvas (utils/by-id :flocking-canvas) context (utils/get-context canvas "2d")]
           (utils/clear-canvas context dimensions)
           (doseq [current-boid boids]
                  (utils/fill-rect context (utils/rand-color) ((current-boid :position) :x) ((current-boid :position) :y)
                                   boid-size boid-size))) boids)

(defn update [boids] (map (fn [current-boid]
                            (boid (boid-position (+ 10 ((current-boid :position) :x)) (+ 10 ((current-boid :position) :y)))
                                   (boid-velocity (+ 10 ((current-boid :velocity) :dx)) (+ 10 ((current-boid :velocity) :dy)))
                                   )) boids))

(defn game-loop [boids] (utils/wait (fn [] (game-loop (render (update boids)))) time-step))

(defn ^:export flock []
  (game-loop initial-boids)
  )