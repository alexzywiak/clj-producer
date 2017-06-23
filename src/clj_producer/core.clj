(ns clj-producer.core
  (:gen-class)
  (:require [org.httpkit.server :refer :all]
            [clj-producer.producer :as producer])
  (:import [java.net InetAddress]))

(def host-name (.getHostName (. InetAddress getLocalHost)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (defn handler [req]
    (with-channel req channel
      (on-close channel (fn [status]
                          (println "channel closed")))
      (on-receive channel (fn [data]
                            (println host-name)
                            (producer/broadcast data)))))
  (run-server handler {:port 8090}))
