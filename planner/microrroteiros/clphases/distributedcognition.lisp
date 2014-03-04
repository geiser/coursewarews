   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling distribute-cognition              ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDistCognitionPhase ?goals ?groups)
      ((assign ?id (call GetUUID act))
       (assign ?as (call GetUUID as)))
      ((!startLDElement act ((identifier ?id))
            ((DistCognition Phase) ?id ?goals ?groups))
       (createLDTitle (DistCognition Phase) ?goals)
       (!!addInWorldState (class CurrentLDInteractions ?as))
       (createDistCognitionPhase ?goals ?groups)
       (!!removeFromWorldState (class CurrentLDInteractions ?as))
       (!endLDElement act ?id)))
   
   ;; (TODO) - optional and mandatory
   (:method (createDistCognitionPhase (?igoal ?lgoal) (?instructors ?learners))
      ()
      ((createLDLearningByDiscussionInstructionalStrategy (?igoal) (?instructors))
       (createLDLearningByDiscussionLearningStrategy (?lgoal) (?learners))
       (createLDDistCognitionInteractions (?igoal ?lgoal) (?instructors ?learners))))
   
