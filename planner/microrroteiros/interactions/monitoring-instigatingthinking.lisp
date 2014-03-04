   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   monitoring and instigating-thinking                                 ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMonitoringInstThinkingInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((MonitoringInstThinking Interactions) ?id ?goals ?groups))
       (createLDTitle (Monitoring InstThinking Iteractions) ?goals)
       (createMonitoringInstThinkingInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMonitoringInstThinkingInteractions ?goals ?groups)
      ()
      ((createMonitoringInstThinkingInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMonitoringInstThinkingInteractions! ?goals ?groups)
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
      ((createLDMonitoringILEvent ?goals ?groups)
       (createLDInstThinkingILEvent ?goals ?groups)))

   ;; fall-back
   (:method (createMonitoringInstThinkingInteractions ?goals ?groups)
      ()
      ((createLDMonitoringInstThinkingInteractionEnvironment ?goals ?groups)
       (createLDMonitoringILEvent ?goals ?groups)
       (createLDInstThinkingILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMonitoringInstThinkingInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MonitoringInstThinking InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (Monitoring InstThinking InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
