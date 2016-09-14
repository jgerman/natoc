(ns natoc.ex12
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/background 255)
  [0 0 0 0 0
   0 0 0 0 0
   0 0 0 0 0
   0 0 0 0 0]
  )

(defn update-state [state]
  (let [idx (rand-int (count state))]
       (assoc state idx (+ (nth state idx) 1)))
  )

(defn draw-state [state]
  (q/stroke 0)
  (q/fill 175)
  (let [ww (/ (q/width) (count state))]
    (doall (map #(q/rect (* %1 ww)
                         (- (q/height) %2)
                         (- ww 1)
                         %2)
                (iterate inc 0)
                state))))

(q/defsketch example
  :title "Ex12"
  :settings #(q/smooth 2)
  :setup setup
  :update update-state
  :draw draw-state
  :size [640 240]
  :middleware [m/fun-mode])
