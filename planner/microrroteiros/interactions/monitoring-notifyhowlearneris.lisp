   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   monitoring and notify-how-learner-is                                ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMonitoringNotifyHowLearnerIsInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((MonitoringNotifyHowLearnerIs Interactions) ?id ?goals ?groups))
       (createLDTitle (Monitoring ProblemDetail Iteractions) ?goals)
       (createMonitoringNotifyHowLearnerIsInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMonitoringNotifyHowLearnerIsInteractions ?goals ?groups)
      ()
      ((createMonitoringNotifyHowLearnerIsInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMonitoringNotifyHowLearnerIsInteractions! ?goals ?groups)
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
       (createLDNotifyHowLearnerIsILEvent ?goals ?groups)))

   ;; fall-back
   (:method (createMonitoringNotifyHowLearnerIsInteractions ?goals ?groups)
      ()
      ((createLDMonitoringNotifyHowLearnerIsInteractionEnvironment ?goals ?groups)
       (createLDMonitoringILEvent ?goals ?groups)
       (createLDNotifyHowLearnerIsILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMonitoringNotifyHowLearnerIsInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MonitoringNotifyHowLearnerIs InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (Monitoring NotifyHowLearnerIs InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
