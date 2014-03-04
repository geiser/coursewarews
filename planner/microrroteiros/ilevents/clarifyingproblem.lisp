   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling clarifying-problem                ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
       
   (:method (createLDClarifyingProblemILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((ClarifyingProblem ILEvent) ?id ?goals ?groups))
       (createLDTitle (ClarifyingProblem ILEvent) ?goals)
       (createClarifyingProblemILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createClarifyingProblemILEvent ?goals ?groups)
      ()
      ((createClarifyingProblemILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createClarifyingProblemILEvent! ?goals ?groups)
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
      ((createLDClarifyingProblemILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createClarifyingProblemILEvent ?goals ?groups)
      ()
      ((createLDClarifyingProblemILEnvironment ?goals ?groups)
       (createLDClarifyingProblemILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDClarifyingProblemILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((ClarifyingProblem ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (ClarifyingProblem ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDClarifyingProblemILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createClarifyingProblemILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createClarifyingProblemILEventDescription ?goals ?groups)
      ()
      ((createClarifyingProblemILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createClarifyingProblemILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class IdentifyingProblem)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ExternalizationProblem)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createClarifyingProblemILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class IdentifyingProblem)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ExternalizationProblem)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
