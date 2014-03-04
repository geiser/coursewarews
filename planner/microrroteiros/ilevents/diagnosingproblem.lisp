   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling diagnosing-problem                ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDiagProblemILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((DiagProblem ILEvent) ?id ?goals ?groups))
       (createLDTitle (DiagProblem ILEvent) ?goals)
       (createDiagProblemILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createDiagProblemILEvent ?goals ?groups)
      ()
      ((createDiagProblemILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDiagProblemILEvent! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getRelateds ?interactions (?e) -1 isPartOf
                    ((class Interactions)
                     (property hasCurrentUoL ?u)))
       (buildPropertyQuery ?tmpQuery hasGoal ?goals
                           ((class InteractionEnvironment)
                            (property hasCurrentUoL ?u)))
       (buildPropertyQuery ?query hasParticipant ?learners ?tmpQuery)
       (getRelateds ?environments ?interactions 1 inverseIsPartOf ?query)
       (different ?environments ()))
      ((createLDDiagProblemILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createDiagProblemILEvent ?goals ?groups)
      ()
      ((createLDDiagProblemILEnvironment ?goals ?groups)
       (createLDDiagProblemILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDiagProblemILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((DiagProblem ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (DiagProblem ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDiagProblemILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createDiagProblemILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createDiagProblemILEventDescription ?goals ?groups)
      ()
      ((createDiagProblemILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDiagProblemILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class Diagnosis)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ReceivingDiagnosis)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createDiagProblemILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class Diagnosis)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ReceivingDiagnosis)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
  
