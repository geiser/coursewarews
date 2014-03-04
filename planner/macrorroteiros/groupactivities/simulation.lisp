   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw-group activity             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDSimulationGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Simulation GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Simulation GroupActivity) ?goals)
       (createSimulationGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createSimulationGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDSimulationSessions ?goals ?groups)))
   
   ;;
   (:method (createLDSimulationSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Simulation Sessions) ?id ?goals ?groups))
       (createLDTitle (Simulation Sessions) ?goals)
       (createSimulationSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createSimulationSessions ?goals ?groups)
      ()
      ((createLDSimulationSession ?goals ?groups)
       (createLDShareSession ?goals ?groups)))
   
