(ns natoc.ex12
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(defn setup []
  (q/background 255)
  {:location (->PVector 100 100) :velocity (->PVector 2.5 5)}
  )

(defn check-and-invert
  "Checks the key in PVector v and inv")
(defn update-state [state]
  (let [location (add (:location state) (:velocity state))
        new-x-speed (if (or (< new-x 0) (> new-x (q/width)))
                      (* -1 (:x-speed state))
                      (:x-speed state))
        new-y-speed (if (or (< new-y 0) (> new-y (q/height)))
                      (* -1 (:y-speed state))
                      (:y-speed state))]
    {:location location
     :velocity (->PVector new-x-speed new-y-speed)})
  )

(defn draw-state [state]
  (q/background 255)
  (q/stroke 0)
  (q/fill 175)
  (q/ellipse (:x (:location state))
             (:y (:location state))
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
