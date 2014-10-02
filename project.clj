(defproject flocking "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]
            [lein-simpleton "1.3.0"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "flocking"
              :source-paths ["src/flocking"]
              :compiler {
                :output-to "flocking.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
