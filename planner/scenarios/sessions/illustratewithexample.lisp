   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling illustrate-with-example           ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:method (createLDIllustrateWithExampleSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((Illustrate WithExample Session) ?id ?goals ?groups))
       (createLDTitle (Illustrate WithExample Session) ?goals)
       (createIllustrateWithExampleSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; (TODO) - optional and mandatory
   (:method (createIllustrateWithExampleSession ?fgoals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (getLearnerPropertyQuery ?tmpQuery ?learners ?fcomp hasMotivation)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ?tmpQuery)
       (getOrBuildReadyAux ?aux ((class Auxiliary)
               (property hasLearningResourceType example) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels)
       (getRelateds ?inputs ?aux inverseIsRequiredBy))
      ((createLDInputs ?inputs ?learners)
       (createIllustrateWithExampleActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createIllustrateWithExampleActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDIllustrateWithExampleEnvironment ?goals ?groups)
       (createLDIllustrateWithExampleSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDIllustrateWithExampleEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Illustrate WithExample Environment) ?id ?goals ?groups))
       (createLDTitle (Illustrate WithExample Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDIllustrateWithExampleSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createIllustrateWithExampleSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   ;; optional
   (:method (createIllustrateWithExampleSessionDescription ?goals ?groups)
      ()
      ((createIllustrateWithExampleSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createIllustrateWithExampleSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class IllustrateWithExampleActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createIllustrateWithExampleSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class IllustrateWithExampleActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Methods used to modeling practice-with-exercise (difficults)          ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:method (createLDIllustrateWithExampleSession ?goals ?groups ?difficults)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((Illustrate WithExample Session) ?id ?goals ?groups))
       (createLDTitle (Illustrate WithExample Session) ?goals ?difficults)
       (createIllustrateWithExampleSession ?goals ?groups ?difficults)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; (TODO) - optional and mandatory
   (:method (createIllustrateWithExampleSession ?fgoals ?groups ?difficults)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (getLearnerPropertyQuery ?tmpQuery ?learners ?difficults)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ?tmpQuery)
       (getOrBuildReadyAux ?aux ((class Auxiliary)
               (property hasLearningResourceType example) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels)
       (getRelateds ?inputs ?aux inverseIsRequiredBy))
      ((createLDInputs ?inputs ?learners)
       (createIllustrateWithExampleActivity ?goals ?groups)))
   
