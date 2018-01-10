(ns tst.{{name}}.core
  (:use {{name}}.core tupelo.core tupelo.test)
  (:require 
    [clojure.string :as str] ))

(dotest
  (is= (spyx (+ 2 3)))
  (throws? (/ 5 0))
  (isnt false)
)

