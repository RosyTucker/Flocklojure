(ns flocking.utils)

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

(defn fill-rect [context left top width height]
      (.fillRect context left top width height))