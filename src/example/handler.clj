(ns example.handler
  (:require [example.templates :as templates]))

(defn my-handler [request]
  (templates/render-template "home"
                             {:message "Hello World"}))

