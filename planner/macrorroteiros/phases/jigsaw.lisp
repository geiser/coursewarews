   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw phase                      ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDJigsawPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Jigsaw Phase) ?id () ?groups))
       (createLDTitle (Jigsaw Phase) ?goals)
       (createJigsawPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createJigsawPhase ?goals ?groups)
      ()
      ((createLDJigsawGroupActivity ?goals ?groups)))
  
