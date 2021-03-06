(defproject clj-producer "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.2.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/tools.logging "0.2.3"]
                 [org.apache.kafka/kafka-clients "0.10.2.1"]
                 [org.clojure/core.async "0.3.443"]
                 [cheshire "5.7.1"]]
  :main ^:skip-aot clj-producer.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
