   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling motivation session                ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMotivationSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((Motivation Session) ?id ?goals ?groups))
       (createLDTitle (Motivation Session) ?goals)
       (createMotivationSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createMotivationSession ?fgoals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ())
       (getOrBuildReadyAux ?aux ((class Auxiliary)
               (property hasDifficult (very-easy easy))
               (property hasLearningResourceType exercise) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels))
      ((createMotivationActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createMotivationActivity ?goals ?groups)
      ()
      ((createLDMotivationEnvironment ?goals ?groups)
       (createLDMotivationSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMotivationEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Motivation Environment) ?id ?goals ?groups))
       (createLDTitle (Motivation Environment) ?goals)
       (createMotivationEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
      
   (:method (createMotivationEnvironment ?goals ?groups)
      ()
      ((distributeLearningObject ?goals ?groups)))
 
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMotivationSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createMotivationSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createMotivationSessionDescription ?goals ?groups)
      ()
      ((createMotivationSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMotivationSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class MotivationActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createMotivationSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class MotivationActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
