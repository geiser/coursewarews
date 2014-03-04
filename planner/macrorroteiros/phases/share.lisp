   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw phase                      ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDSharePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Share Phase) ?id () ?groups))
       (createLDTitle (Share Phase) ?goals)
       (createSharePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createSharePhase ?goals ?groups)
      ()
      ((createLDShareGroupActivity ?goals ?groups)))
   
