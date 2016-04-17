(defproject alc-calc "0.1.0-SNAPSHOT"
  :description "Calculate alcoholic drinks using standard national measurements."
  :url "www.google.com"
  :license {:name "Eclipse Public License v1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [http-kit "2.1.19"]
                 [ring/ring-core "1.4.0"]
                 [bidi "2.0.6"]
                 [metosin/ring-http-response "0.6.5"]
                 [ring-middleware-format "0.7.0" :exclusions [ring]]]
  :plugins [[lein-ring "0.9.7"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.11"]]
                   :source-paths ["dev"]}
             :production {}}
  :ring {:port 4000
         :handler server/app}
  :uberjar-name "alc-calc.jar"
  :repl-options {:init-ns server})

