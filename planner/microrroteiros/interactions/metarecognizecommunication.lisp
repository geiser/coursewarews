   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling metarecognize-communication       ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMetarecognizeCommunicationInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (startLDElement! activity-structure ((identifier ?id)
                                            (structure-type selection))
               ((MetarecognizeCommunication Interactions) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeCommunication Interactions) ?goals)
       (createMetarecognizeCommunicationInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMetarecognizeCommunicationInteractions ?goals ?groups)
      ()
      ((createMetarecognizeCommunicationInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMetarecognizeCommunicationInteractions! ?goals ?groups)
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
      ((createLDMetarecognizeCommunicationWithMonitoringInteractions ?goals ?groups)
       (createLDMetarecognizeCommunicationWithInstigatingInteractions ?goals ?groups)))
   
   ;; fall-back
   (:method (createMetarecognizeCommunicationInteractions ?goals ?groups)
      ()
      ((createLDMetarecognizeCommunicationInteractionEnvironment ?goals ?groups)
       (createLDMetarecognizeCommunicationWithMonitoringInteractions ?goals ?groups)
       (createLDMetarecognizeCommunicationWithInstigatingInteractions ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMetarecognizeCommunicationInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MetarecognizeCommunication InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeCommunication InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))

