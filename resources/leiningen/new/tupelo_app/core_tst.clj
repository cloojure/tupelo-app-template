(ns tst.{{name}}.core
  (:use {{name}}.core tupelo.core tupelo.test)
  (:require 
    [tupelo.string :as ts] ))

(dotest
  (is= (spyx (+ 2 3)))
  (throws? (/ 5 0))
  (isnt false)
)

