(ns natoc.core
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 15)
  (q/background 255)
  {:x (/ (q/width) 2)
   :y (/ (q/height) 2)})

(defn update-state [state]
  (let [dir (rand-int 4)]
    (cond
      (== dir 0) {:x (+ 1 (:x state))
                  :y (:y state)}
      (== dir 1) {:x (- (:x state) 1)
                  :y (:y state)}
      (== dir 2) {:x (:x state)
                  :y (+ 1 (:y state))}
      :else      {:x (:x state)
                  :y (- (:y state) 1)})))

(defn draw-state [state]
  (q/stroke 0)
  (q/point (:x state) (:y state))
  )

(q/defsketch example
  :title "Oh so many grey circles"
  :settings #(q/smooth 2)
  :setup setup
  :update update-state
  :draw draw-state
  :size [323 200]
  :middleware [m/fun-mode])
