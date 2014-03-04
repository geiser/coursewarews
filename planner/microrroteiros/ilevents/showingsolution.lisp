   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling showing-solution                  ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDShowSolutionILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((ShowSolution ILEvent) ?id ?goals ?groups))
       (createLDTitle (ShowSolution ILEvent) ?goals)
       (createShowSolutionILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createShowSolutionILEvent ?goals ?groups)
      ()
      ((createShowSolutionILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createShowSolutionILEvent! ?goals ?groups)
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
      ((createLDShowSolutionILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createShowSolutionILEvent ?goals ?groups)
      ()
      ((createLDShowSolutionILEnvironment ?goals ?groups)
       (createLDShowSolutionILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowSolutionILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((ShowSolution ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (ShowSolution ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowSolutionILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createShowSolutionILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createShowSolutionILEventDescription ?goals ?groups)
      ()
      ((createShowSolutionILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createShowSolutionILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class Explanation)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ReceivingExplanation)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createShowSolutionILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class Explanation)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ReceivingExplanation)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
