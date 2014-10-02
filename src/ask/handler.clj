(ns ask.handler
  (:require [clostache.parser :as template]))

(defn my-handler [request]
  (template/render "Hello {{name}}!"
                 {:name "Rosy"}))
