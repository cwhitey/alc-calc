(ns server
  (:require [clojure.pprint :refer [pprint]]
            [ring.adapter.jetty :as jetty]
            [ring.util.http-response :refer [ok content-type header] :as resp]
            [ring.middleware.format :refer [wrap-restful-format]]
            [bidi.ring :as bidi]))

(defn index [_]
  (-> "<html><h1>Hello</h1></html>"
      (ok)
      (content-type "text/html; charset=UTF-8")))

(defn echo-name [req]
  (ok (-> req :route-params :name)))

(def routes ["/" {""              {:get index}
                  ["name/" :name] {:get echo-name}}])

(def app (-> routes
             (bidi/make-handler)
             (wrap-restful-format :formats [:json])))

(defn -main [& [port]]
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty app {:port port :join? false})))
