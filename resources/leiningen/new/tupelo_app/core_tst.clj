(ns tst.{{name}}.core
  (:use {{name}}.core tupelo.core tupelo.test)
  (:require 
    [clojure.string :as str]
    [clojure.java.io :as io] )
  (:import [{{name}} Calc] ))

(dotest
  (is= (spyx (+ 2 3)))
  (throws? (/ 5 0))
  (isnt false)

  (let [crisis-txt (slurp (io/resource "thomas-paine.txt")) ]
    (is (truthy? (re-find #"THESE are the times" crisis-txt))))

  (is= 5.0 (Calc/add 2 3))
)

