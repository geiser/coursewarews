   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling conclude phase                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDConcludePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Conclude Phase) ?id () ?groups))
       (createLDTitle (Conclude Phase) ?goals)
       (createConcludePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createConcludePhase ?goals ?groups)
      ()
      ((createLDConcludeGroupActivity ?goals ?groups)))
 
