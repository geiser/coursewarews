   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling metarecognize-progress            ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMetarecognizeProgressInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (startLDElement! activity-structure ((identifier ?id)
                                            (structure-type sequence))
               ((MetarecognizeProgress Interactions) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeProgress Interactions) ?goals)
       (createMetarecognizeProgressInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMetarecognizeProgressInteractions ?goals ?groups)
      ()
      ((createMetarecognizeProgressInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMetarecognizeProgressInteractions! ?goals ?groups)
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
      ((createLDDemonHowSolveProblemILEvent ?goals ?groups)
       (createLDMonitoringILEvent ?goals ?groups)
       (createLDNotifyHowLearnerIsILEvent ?goals ?groups)))
   
   ;; fall-back
   (:method (createMetarecognizeProgressInteractions ?goals ?groups)
      ()
      ((createLDMetarecognizeProgressInteractionEnvironment ?goals ?groups)
       (createLDDemonHowSolveProblemILEvent ?goals ?groups)
       (createLDMonitoringILEvent ?goals ?groups)
       (createLDNotifyHowLearnerIsILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMetarecognizeProgressInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MetarecognizeProgress InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (MetarecognizeProgress InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
