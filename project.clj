(defproject alc-drinks "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "TODO: Choose a license"
            :url "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.4.0"]
                 [bidi "2.0.6"]
                 [metosin/ring-http-response "0.6.5"]
                 [ring-middleware-format "0.7.0" :exclusions [ring]]]
  :plugins [[lein-ring "0.9.7"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}}
  :ring {:port 4000
         :handler server/app}
  :uberjar-name "alc-drinks.jar"
  :repl-options {:init-ns server})

