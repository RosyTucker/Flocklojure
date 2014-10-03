(ns flocking.utils)

(defn clear-canvas
      [ctx dimensions]
      (.save ctx)
      (.setTransform ctx 1 0 0 1 0 0)
      (.clearRect ctx 0 0 (dimensions :width) (dimensions :height))
      (.restore ctx))

(defn length [nodes]
      (. nodes -length))

(defn item [nodes n]
      (.item nodes n))

(defn as-seq [nodes]
      (for [i (range (length nodes))] (item nodes i)))

(defn by-id [id]
      (.getElementById js/document (name id)))

(defn by-tag [tag]
      (as-seq
        (.getElementsByTagName js/document (name tag))))

(defn html [dom] (. dom -innerHTML))

(defn set-html! [dom content]
      (set! (. dom -innerHTML) content))

(defn get-context [target dim]
      (.getContext target "2d"))

(defn fill-rect [context color left top width height]
      (set! (.-fillStyle context) color)
      (.fillRect context left top width height))

(defn wait [update timestep]
      (js/setTimeout update timestep))

(defn rand-color []
      (str "rgb(" (rand-int 255) "," (rand-int 255) "," (rand-int 255) ")"))
