   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling prerequisites session             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDevelopSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((Develop Session) ?id ?goals ?groups))
       (createLDTitle (Develop Session) ?goals)
       (createDevelopSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createDevelopSession ?fgoals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (getLearnerPropertyQuery ?tmpQuery ?learners (very-easy easy))
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ?tmpQuery)
       (getOrBuildReadyAux ?aux ((class Auxiliary)
            (property hasLearningResourceType example) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels)
       (getPropertyValue ?knowl ?fcomp hasKnowledge)
       (getRelateds ?prerequisites ?knowl inverseIsRequiredBy))
      ((createLDInputs ?prerequisites ?learners)
       (createDevelopActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createDevelopActivity ?goals ?groups)
      ()
      ((createLDDevelopEnvironment ?goals ?groups)
       (createLDDevelopSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDevelopEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Develop Environment) ?id ?goals ?groups))
       (createLDTitle (Develop Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDevelopSessionDescription ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency))
      ((!startLDElement activity-description)
       (createDevelopSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createDevelopSessionDescription ?goals ?groups)
      ()
      ((createDevelopSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDevelopSessionDescription! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getPropertyValue ?knowl ?c hasKnowledge))
      ((createLDItem ?knowl)))
   
   ;; fall-back
   (:method (createDevelopSessionDescription ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getPropertyValue ?title ?c hasTitle)
       (assign ?knowl (call BuildElement ((class Knowledge)
                                          (class Fundamental)
                                          (property hasTitle ?title)))))
      ((createLDItem ?knowl)))
   
