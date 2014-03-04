   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   request-problem-detail and notify-how-learner-is                    ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDReqProblemDetailNotifyHowLearnerIsInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((ReqProblemDetailNotifyHowLearnerIs Interactions) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail NotifyHowLearnerIs Iteractions) ?goals)
       (createReqProblemDetailNotifyHowLearnerIsInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createReqProblemDetailNotifyHowLearnerIsInteractions ?goals ?groups)
      ()
      ((createReqProblemDetailNotifyHowLearnerIsInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createReqProblemDetailNotifyHowLearnerIsInteractions! ?goals ?groups)
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
      ((createLDReqProblemDetailILEvent ?goals ?groups)
       (createLDNotifyHowLearnerIsILEvent ?goals ?groups)))
   
   ;; fall-back
   (:method (createReqProblemDetailNotifyHowLearnerIsInteractions ?goals ?groups)
      ()
      ((createLDReqProblemDetailNotifyHowLearnerIsInteractionEnvironment ?goals ?groups)
       (createLDReqProblemDetailILEvent ?goals ?groups)
       (createLDNotifyHowLearnerIsILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDReqProblemDetailNotifyHowLearnerIsInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((ReqProblemDetailNotifyHowLearnerIs InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail NotifyHowLearnerIs InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
