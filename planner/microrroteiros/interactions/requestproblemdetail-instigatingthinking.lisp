   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   request-problem-detail and instigating-thinking                     ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDReqProblemDetailInstThinkingInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((ReqProblemDetailInstThinking Interactions) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail InstThinking Iteractions) ?goals)
       (createReqProblemDetailInstThinkingInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createReqProblemDetailInstThinkingInteractions ?goals ?groups)
      ()
      ((createReqProblemDetailInstThinkingInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createReqProblemDetailInstThinkingInteractions! ?goals ?groups)
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
       (createLDInstThinkingILEvent ?goals ?groups)))
   
   ;; fall-back
   (:method (createReqProblemDetailInstThinkingInteractions ?goals ?groups)
      ()
      ((createLDReqProblemDetailInstThinkingInteractionEnvironment ?goals ?groups)
       (createLDReqProblemDetailILEvent ?goals ?groups)
       (createLDInstThinkingILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDReqProblemDetailInstThinkingInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((ReqProblemDetailInstThinking InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail InstThinking InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
