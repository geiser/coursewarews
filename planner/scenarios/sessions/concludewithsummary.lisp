
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling show problem session              ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDConcludeWithSummarySession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((ConcludeWithSummary Session) ?id ?goals ?groups))
       (createLDTitle (ConcludeWithSummary Session) ?goals)
       (createConcludeWithSummarySession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createConcludeWithSummarySession ?fgoals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ())
       (getOrBuildReadyAux ?aux ((class Auxiliary)
            (property hasLearningResourceType
                      (evidence proof demonstration)) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels))
      ((createLDSummaryOutput ?goals ?groups)
       (createConcludeWithSummaryActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createConcludeWithSummaryActivity ?goals ?groups)
      ()
      ((createLDConcludeWithSummaryEnvironment ?goals ?groups)
       (createLDConcludeWithSummarySessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDConcludeWithSummaryEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((ConcludeWithSummary Environment) ?id ?goals ?groups))
       (createLDTitle (ConcludeWithSummary Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDConcludeWithSummarySessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createConcludeWithSummarySessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createConcludeWithSummarySessionDescription ?goals ?groups)
      ()
      ((createConcluseWithSummarySessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createConcludeWithSummarySessionDescription! ?goals ?groups)
      ((getElement ?activity ((class ConcludeWithSummaryActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createConcludeWithSummarySessionDescription ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (assign ?activity (call BuildElement ((class ConcludeWithSummaryActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
