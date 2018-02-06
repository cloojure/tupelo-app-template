(ns leiningen.new.tupelo-app
  (:require [leiningen.new.templates :refer [renderer raw-resourcer name-to-path ->files]]
            [leiningen.core.main :as main] ))

(def render (renderer "tupelo-app"))
(def raw    (raw-resourcer "tupelo-app"))

(defn tupelo-app
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' tupelo-app project.")
    (->files data
      ["project.clj"                              (render "project.clj"     data) ]
      ["README.adoc"                              (render "README.adoc"     data) ]
      ["LICENSE"                                  (render "LICENSE"         data) ]
      ["generate-docs.bash"                       (render "generate-docs.bash" data) :executable true]
      ["src/{{sanitized}}/core.clj"               (render "core_main.clj"   data) ]
      ["src/tst/{{sanitized}}/core.clj"           (render "core_tst.clj"    data) ]
      ["src/_bootstrap.clj"                       (render "_bootstrap.clj"  data) ]
      ["src-java/{{sanitized}}/Calc.java"         (render "Calc.java"       data) ]
      [".gitignore"                               (raw    "gitignore.txt")        ]
      ["resources/clojure.png"                    (raw    "clojure.png")          ]
      ["resources/thomas-paine.txt"               (raw    "thomas-paine.txt")     ]
      ; "doc" ; <= creates empty dir
    )))
