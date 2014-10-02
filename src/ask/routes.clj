(ns ask.routes
  (:use [ask.handler :only [my-handler]])
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes app-routes
           (GET "/" [request] (my-handler request))
           (route/resources "/")
           (route/not-found "Not Found"))

(def app
  (handler/site app-routes))