   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   monitoring and instigating-thinking and metademonstration           ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMonitInstThinkWithMetademonInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
           ((MonitInstThinkWithMetademon Interactions) ?id ?goals ?groups))
       (createLDTitle (Monitoring InstThinking WithMetademon Iteractions) ?goals)
       (createMonitInstThinkWithMetademonInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMonitInstThinkWithMetademonInteractions ?goals ?groups)
      ()
      ((createMonitInstThinkWithMetademonInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMonitInstThinkWithMetademonInteractions! ?goals ?groups)
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
      ((createLDMonitoringInstThinkingInteractions ?goals ?groups)
       (createLDReqProblemDetailShowSolutionInteractions ?goals ?groups)
       (createLDDemonHowSolveProblemClarifyingProblemInteractions ?goals ?groups)))
   
   ;; fall-back
   (:method (createMonitInstThinkWithMetademonInteractions ?goals ?groups)
      ()
      ((createLDMonitInstThinkWithMetademonInteractionEnvironment ?goals ?groups)
       (createLDMonitoringInstThinkingInteractions ?goals ?groups)
       (createLDReqProblemDetailShowSolutionInteractions ?goals ?groups)
       (createLDDemonHowSolveProblemClarifyingProblemInteractions ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMonitInstThinkWithMetademonInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MonitInstThinkWithMetademon InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (Monitoring InstThinking WithMetademon InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
