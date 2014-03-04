   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling cognitive-flexibility             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDCogFlexibilityPhase ?goals ?groups)
      ((assign ?id (call GetUUID act))
       (assign ?as (call GetUUID as)))
      ((!startLDElement act ((identifier ?id))
            ((CogFlexibility Phase) ?id ?goals ?groups))
       (createLDTitle (CogFlexibility Phase) ?goals)
       (!!addInWorldState (class CurrentLDInteractions ?as))
       (createCogFlexibilityPhase ?goals ?groups)
       (!!removeFromWorldState (class CurrentLDInteractions ?as))
       (!endLDElement act ?id)))
   
   ;; (TODO) - optional and mandatory
   (:method (createCogFlexibilityPhase (?pgoal ?agoal) (?panelists ?audiences))
      ()
      ((createLDLearningBySelfexpressionStrategy (?pgoal) (?panelists))
       (createLDLearningByReflectionStrategy (?agoal) (?audiences))
       (createLDCogFlexibilityInteractions (?pgoal ?agoal) (?panelists ?audiences))))
   
