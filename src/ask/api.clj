(ns ask.api
  (:require [org.httpkit.server :as ws]))

(def channels (ref []))

(defn add-new-channel [channel]
  (dosync
    (alter channels conj channel)))

(defn send-message [channel message]
  (ws/send! channel message))

(defn notify-all-channels [message]
  (doseq [channel @channels] (send-message channel message)))

(defn audience-handler [request]
  (ws/with-channel request
                   channel
                   (ws/on-receive channel notify-all-channels)))

(defn big-screen-handler [request]
  (ws/with-channel request
                   channel
                   (add-new-channel channel)))
