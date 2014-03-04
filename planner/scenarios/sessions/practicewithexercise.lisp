   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice-with-exercise            ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeWithExerciseSession ?goals ?groups)
      ()
      ((createLDPracticeWithExerciseSession! ?goals ?groups)))
   
   ;; mandatory (clfp/clscenario)
   (:method (createLDPracticeWithExerciseSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class WithExercise)
                                       (class PracticeSession)) (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
            ((PracticeSession WithExercise UoL) ?id ?goals ?skills ?attits ?groups))
       (!!changeLearningResourceType (exercise))
       (createLDTitle (PracticeSession WithExercise UoL) ?goals)
       (!startLDElement method)
       (createPracticeWithExerciseSession ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
   
   ;; fall-back
   (:method (createLDPracticeWithExerciseSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Practice WithExercise Session) ?id ?goals ?groups))
       (createLDTitle (Practice WithExercise Session) ?goals)
       (createPracticeWithExerciseSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; (TODO) - optional and mandatory
   (:method (createPracticeWithExerciseSession ?fgoals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (getLearnerPropertyQuery ?tmpQuery ?learners ?fcomp hasMotivation)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ?tmpQuery)
       (getOrBuildReadyAux ?aux ((class Auxiliary)
            (property hasLearningResourceType exercise) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels)
       (getRelateds ?inputs ?aux inverseIsRequiredBy))
      ((createLDInputs ?inputs ?learners)
       (createPracticeWithExerciseActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createPracticeWithExerciseActivity ?goals ?groups)
      ()
      ((createPracticeWithExerciseActivity! ?goals ?groups)))
   
   (:method (createPracticeWithExerciseActivity! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType UoL ?e))
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; fall-back
   (:method (createPracticeWithExerciseActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDPracticeWithExerciseEnvironment ?goals ?groups)
       (createLDPracticeWithExerciseSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPracticeWithExerciseEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Practice WithExercise Environment) ?id ?goals ?groups))
       (createLDTitle (Practice WithExercise Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPracticeWithExerciseSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createPracticeWithExerciseSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   ;; optional
   (:method (createPracticeWithExerciseSessionDescription ?goals ?groups)
      ()
      ((createPracticeWithExerciseSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createPracticeWithExerciseSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class PracticeWithExerciseActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createPracticeWithExerciseSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class PracticeWithExerciseActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Methods used to modeling practice-with-exercise (difficults)          ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeWithExerciseSession ?goals ?groups ?difficults)
      ()
      ((createLDPracticeWithExerciseSession! ?goals ?groups ?difficults)))
   
   ;; mandatory (clfp/clscenario)
   (:method (createLDPracticeWithExerciseSession! ?goals ?groups ?difficults)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude)
       (assign ?id (call BuildElement ((class UoL)
                                       (class WithExercise)
                                       (class PracticeSession)) (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
               ((PracticeSession WithExercise UoL) ?id ?goals ?skills ?attits ?groups))
       (!!changeLearningResourceType (exercise))
       (createLDTitle (PracticeSession WithExercise UoL) ?goals ?difficults)
       (!startLDElement method)
       (createPracticeWithExerciseSession ?goals ?groups ?difficults)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
      
   ;; fall-back
   (:method (createLDPracticeWithExerciseSession ?goals ?groups ?difficults)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Practice WithExercise Session) ?id ?goals ?groups))
       (createLDTitle (Practice WithExercise Session) ?goals ?difficults)
       (createPracticeWithExerciseSession ?goals ?groups ?difficults)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; (TODO) - optional and mandatory
   (:method (createPracticeWithExerciseSession ?fgoals ?groups ?difficults)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (getLearnerPropertyQuery ?tmpQuery ?learners ?difficults)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ())
       (getOrBuildReadyAux ?aux ((class Auxiliary)
               (property hasLearningResourceType exercise) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels)
       (getRelateds ?inputs ?aux inverseIsRequiredBy))
      ((createLDInputs ?inputs ?learners)
       (createPracticeWithExerciseActivity ?goals ?groups)))
   
