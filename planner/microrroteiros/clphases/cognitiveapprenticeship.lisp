   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling cognitive-apprenticeship          ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDCogApprenticeshipPhase ?goals ?groups)
      ((assign ?id (call GetUUID act))
       (assign ?as (call GetUUID as)))
      ((!startLDElement act ((identifier ?id))
            ((CogApprenticeship Phase) ?id ?goals ?groups))
       (createLDTitle (CogApprenticeship Phase) ?goals)
       (!!addInWorldState (class CurrentLDInteractions ?as))
       (createCogApprenticeshipPhase ?goals ?groups)
       (!!removeFromWorldState (class CurrentLDInteractions ?as))
       (!endLDElement act ?id)))
   
   ;; (TODO) - optional and mandatory
   (:method (createCogApprenticeshipPhase (?mgoal ?agoal) (?masters ?apprentices))
      ()
      ((createLDLearningByApprenticeshipStrategy (?mgoal) (?masters))
       (createLDLearningByGuidingStrategy (?agoal) (?apprentices))
       (createLDCogApprenticeshipInteractions (?mgoal ?agoal) (?masters ?apprentices))))
   
