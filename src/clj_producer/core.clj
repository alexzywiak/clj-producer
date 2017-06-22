(ns clj-producer.core
  (:gen-class)
  (:require [org.httpkit.server :refer :all]
            [clj-producer.producer :as producer]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (defn handler [req]
    (with-channel req channel
      (on-close channel (fn [status]
                          (println "channel closed")))
      (if (websocket? channel)
        (println "WebSocket channel")
        (println "HTTP channel"))
      (on-receive channel (fn [data]
                            (producer/broadcast data)))))
  (run-server handler {:port 8090}))
