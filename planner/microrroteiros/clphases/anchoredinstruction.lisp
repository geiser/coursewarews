   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling anchored-instruction              ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDAnchoredInstructionPhase ?goals ?groups)
      ((assign ?id (call GetUUID act))
       (assign ?as (call GetUUID as)))
      ((!startLDElement act ((identifier ?id))
            ((AnchoredInstruction Phase) ?id ?goals ?groups))
       (createLDTitle (AnchoredInstruction Phase) ?goals)
       (!!addInWorldState (class CurrentLDInteractions ?as))
       (createAnchoredInstructionPhase ?goals ?groups)
       (!!removeFromWorldState (class CurrentLDInteractions ?as))
       (!endLDElement act ?id)))
   
   ;; (TODO) - optional and mandatory
   (:method (createAnchoredInstructionPhase (?igoal ?hgoal) (?instructors ?holders))
      ()
      ((createLDLearningByDiagnosingStrategy (?igoal) (?instructors))
       (createLDLearningByBeingTaughtStrategy (?hgoal) (?holders))
       (createLDAnchoredInstructionInteractions (?igoal ?hgoal) (?instructors ?holders))))
   
