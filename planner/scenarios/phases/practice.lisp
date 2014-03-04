   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice phase                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Practice Phase) ?id () ?groups))
       (createLDTitle (Practice Phase) ?goals)
       (createPracticePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createPracticePhase ?goals ?groups)
      ()
      ((createLDPracticeGroupActivity ?goals ?groups)))
   
