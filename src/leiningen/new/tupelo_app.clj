(ns leiningen.new.tupelo-app
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main] ))

(def render (renderer "tupelo-app"))

(defn tupelo-app
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' tupelo-app project.")
    (->files data
      ["project.clj"                    (render "project.clj"   data) ]
      ["src/{{sanitized}}/core.clj"     (render "core_main.clj" data) ]
      ["src/tst/{{sanitized}}/core.clj" (render "core_tst.clj"  data) ]
    )))
