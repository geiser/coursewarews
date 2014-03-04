   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;; metarecognize-communication with instigating discussion and thinking  ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMetarecognizeCommunicationWithInstigatingInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (startLDElement! activity-structure ((identifier ?id)
                                            (structure-type sequence))
            ((MetarecognizeCommunication WithInstigating Interactions) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeCommunication WithInstigating Interactions) ?goals)
       (createMetarecognizeCommunicationWithInstigatingInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMetarecognizeCommunicationWithInstigatingInteractions ?goals ?groups)
      ()
      ((createMetarecognizeCommunicationWithInstigatingInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMetarecognizeCommunicationWithInstigatingInteractions! ?goals ?groups)
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
       (createLDInstDiscussionILEvent ?goals ?groups)
       (createLDInstThinkingILEvent ?goals ?groups)))
   
   ;; fall-back
   (:method (createMetarecognizeCommunicationWithInstigatingInteractions ?goals ?groups)
      ()
      ((createLDMetarecognizeCommunicationWithInstigatingInteractionEnvironment ?goals ?groups)
       (createLDSetLearningContextILEvent ?goals ?groups)
       (createLDInstDiscussionILEvent ?goals ?groups)
       (createLDInstThinkingILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMetarecognizeCommunicationWithInstigatingInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MetarecognizeCommunication WithInstigating InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeCommunication WithInstigating InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))

