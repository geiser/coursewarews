   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw phase                      ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDSimulationPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Simulation Phase) ?id () ?groups))
       (createLDTitle (Simulation Phase) ?goals)
       (createSimulationPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createSimulationPhase ?goals ?groups)
      ()
      ((createLDSimulationGroupActivity ?goals ?groups)))
  
