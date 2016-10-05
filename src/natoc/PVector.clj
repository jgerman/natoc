(ns natoc.PVector)

(defprotocol PVectorP
  (add [x y]))

(defrecord PVector [x y]
  PVectorP
  (add [x y]
    (->PVector (+ (:x x) (:x y)) (+ (:y x) (:y y)))))
