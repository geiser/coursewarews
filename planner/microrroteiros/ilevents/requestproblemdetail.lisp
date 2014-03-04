   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling request-problem-detail            ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDReqProblemDetailILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((ReqProblemDetail ILEvent) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail ILEvent) ?goals)
       (createReqProblemDetailILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createReqProblemDetailILEvent ?goals ?groups)
      ()
      ((createReqProblemDetailILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createReqProblemDetailILEvent! ?goals ?groups)
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
      ((createLDReqProblemDetailILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createReqProblemDetailILEvent ?goals ?groups)
      ()
      ((createLDReqProblemDetailILEnvironment ?goals ?groups)
       (createLDReqProblemDetailILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDReqProblemDetailILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((ReqProblemDetail ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDReqProblemDetailILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createReqProblemDetailILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createReqProblemDetailILEventDescription ?goals ?groups)
      ()
      ((createReqProblemDetailILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createReqProblemDetailILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class AskProblems)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class PointProblems)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createReqProblemDetailILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class AskProblems)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class PointProblems)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
