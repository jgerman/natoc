(ns natoc.ex11
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/background 255)
  {:x-speed 1 :y-speed 3.3 :x 100 :y 100}
  )

(defn update-state [state]
  (let [new-x (+ (:x state) (:x-speed state))
        new-y (+ (:y state) (:y-speed state))
        new-x-speed (if (or (< new-x 0) (> new-x (q/width)))
                      (* -1 (:x-speed state))
                      (:x-speed state))
        new-y-speed (if (or (< new-y 0) (> new-y (q/height)))
                      (* -1 (:y-speed state))
                      (:y-speed state))]
    {:x new-x
     :y new-y
     :x-speed new-x-speed
     :y-speed new-y-speed})
  )

(defn draw-state [state]
  (q/background 255)
  (q/stroke 0)
  (q/fill 175)
  (q/ellipse (:x state)
             (:y state)
             16 16)
  state)

(q/defsketch example
  :title "Ex12"
  :settings #(q/smooth 2)
  :setup setup
  :update update-state
  :draw draw-state
  :size [640 360]
  :middleware [m/fun-mode])
