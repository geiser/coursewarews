   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;; metarecognize-communication with monitoring                           ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMetarecognizeCommunicationWithMonitoringInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (startLDElement! activity-structure ((identifier ?id)
                                            (structure-type sequence))
            ((MetarecognizeCommunication WithMonitoring Interactions) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeCommunication WithMonitoring Interactions) ?goals)
       (createMetarecognizeCommunicationWithMonitoringInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMetarecognizeCommunicationWithMonitoringInteractions ?goals ?groups)
      ()
      ((createMetarecognizeCommunicationWithMonitoringInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMetarecognizeCommunicationWithMonitoringInteractions! ?goals ?groups)
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
      ((createLDSetLearningContextILEvent ?goals ?groups)
       (createLDElicitPerformanceILEvent ?goals ?groups)
       (createLDMonitoringILEvent ?goals ?groups)))
   
   ;; fall-back
   (:method (createMetarecognizeCommunicationWithMonitoringInteractions ?goals ?groups)
      ()
      ((createLDMetarecognizeCommunicationWithMonitoringInteractionEnvironment ?goals ?groups)
       (createLDSetLearningContextILEvent ?goals ?groups)
       (createLDElicitPerformanceILEvent ?goals ?groups)
       (createLDMonitoringILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMetarecognizeCommunicationWithMonitoringInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MetarecognizeCommunication WithMonitoring InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeCommunication WithMonitoring InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))

