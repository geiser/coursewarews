   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling show problem session              ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDShowProblemSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((ShowProblem Session) ?id ?goals ?groups))
       (createLDTitle (ShowProblem Session) ?goals)
       (createShowProblemSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createShowProblemSession ?fgoals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ())
       (getOrBuildReadyAux ?aux ((class Auxiliary)
               (property hasLearningResourceType real-world-problem) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels))
      ((createShowProblemActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createShowProblemActivity ?goals ?groups)
      ()
      ((createLDShowProblemEnvironment ?goals ?groups)
       (createLDShowProblemSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowProblemEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((ShowProblem Environment) ?id ?goals ?groups))
       (createLDTitle (ShowProblem Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowProblemSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createShowProblemSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createShowProblemSessionDescription ?goals ?groups)
      ()
      ((createShowProblemSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createShowProblemSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class ShowProblemActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createShowProblemSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class ShowProblemActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
