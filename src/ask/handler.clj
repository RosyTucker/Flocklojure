(ns ask.handler
  (:require [ask.templates :as templates]))

(defn my-handler [request]
  (templates/render-template "home"
                             {:name "Rosy"}))

