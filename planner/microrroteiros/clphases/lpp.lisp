   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling lpp                               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDLPPPhase ?goals ?groups)
      ((assign ?id (call GetUUID act))
       (assign ?as (call GetUUID as)))
      ((!startLDElement act ((identifier ?id))
                        ((LPP Phase) ?id ?goals ?groups))
       (createLDTitle (LPP Phase) ?goals)
       (!!addInWorldState (class CurrentLDInteractions ?as))
       (createLPPPhase ?goals ?groups)
       (!!removeFromWorldState (class CurrentLDInteractions ?as))
       (!endLDElement act ?id)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLPPPhase (?fgoal ?pgoal) (?fulls ?peripherals))
      ()
      ((createLDLearningByDiscussionInstructionalStrategy (?fgoal) (?fulls))
       (createLDLearningByPracticeStrategy (?pgoal) (?peripherals))
       (createLDLPPInteractions (?fgoal ?pgoal) (?fulls ?peripherals))))
   
