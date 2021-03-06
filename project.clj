(defproject captionapp "0.1.0-SNAPSHOT"
  :description "A simple web app that will display posted messages. Molly is making it as part of ClojureBridge.MN. Huzzah!"
  :url "https://github.com/mollyocr/chatter"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                [compojure "1.3.1"]
                [ring/ring-defaults "0.1.2"]
                [ring/ring-jetty-adapter "1.3.2"]
                [hiccup "1.0.5"]
                [hickory "0.5.4"]
                [environ "1.0.0"]]
 :plugins [[lein-ring "0.8.13"]
           [lein-environ "1.0.0"]]
 :ring {:handler captionapp.handler/app
        :init captionapp.handler/init
        :destroy captionapp.handler/destroy}
 :aot :all
 :profiles
 {:dev
  {:dependencies [[javax.servlet/servlet-api "2.5"]
                  [ring-mock "0.1.5"]]}
  :production
  {:ring
   {:open-browser? false, :stacktraces? false, :auto-reload? false}
   :env {production true}}}
 :uberjar-name "captionapp-standalone.jar")
