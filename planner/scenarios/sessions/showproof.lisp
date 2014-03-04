   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling show problem session              ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDShowProofSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((ShowProof Session) ?id ?goals ?groups))
       (createLDTitle (ShowProof Session) ?goals)
       (createShowProofSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createShowProofSession ?fgoals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?fcomp ?fgoals)
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?query hasLearningObjective ?fcomp ?levels ())
       (getOrBuildReadyAux ?aux ((class Auxiliary)
            (property hasLearningResourceType
                      (evidence proof demonstration)) . ?query) ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fcomp ?levels))
      ((createShowProofActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createShowProofActivity ?goals ?groups)
      ()
      ((createLDShowProofEnvironment ?goals ?groups)
       (createLDShowProofSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowProofEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((ShowProof Environment) ?id ?goals ?groups))
       (createLDTitle (ShowProof Environment) ?goals)
       (createShowProofEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   (:method (createShowProofEnvironment ?goals ?groups)
      ()
      ((distributeLearningObject ?goals ?groups)))
     
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowProofSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createShowProofSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createShowProofSessionDescription ?goals ?groups)
      ()
      ((createShowProofSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createShowProofSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class ShowProofActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createShowProofSessionDescription ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (assign ?activity (call BuildElement ((class ShowProofActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
