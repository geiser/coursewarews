   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling demonstrating-how-solve-problem   ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDemonHowSolveProblemILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((DemonHowSolveProblem ILEvent) ?id ?goals ?groups))
       (createLDTitle (DemonHowSolveProblem ILEvent) ?goals)
       (createDemonHowSolveProblemILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createDemonHowSolveProblemILEvent ?goals ?groups)
      ()
      ((createDemonHowSolveProblemILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDemonHowSolveProblemILEvent! ?goals ?groups)
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
      ((createLDDemonHowSolveProblemILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createDemonHowSolveProblemILEvent ?goals ?groups)
      ()
      ((createLDDemonHowSolveProblemILEnvironment ?goals ?groups)
       (createLDDemonHowSolveProblemILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDemonHowSolveProblemILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((DemonHowSolveProblem ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (DemonHowSolveProblem ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDemonHowSolveProblemILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createDemonHowSolveProblemILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createDemonHowSolveProblemILEventDescription ?goals ?groups)
      ()
      ((createDemonHowSolveProblemILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDemonHowSolveProblemILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class Demonstration)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ObservingDemonstration)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createDemonHowSolveProblemILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class Demonstration)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ObservingDemonstration)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
