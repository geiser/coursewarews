   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling metadiagnosing                    ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMetadiagnosingInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
               ((Metadiagnosing Interactions) ?id ?goals ?groups))
       (createLDTitle (Metadiagnosing Interactions) ?goals)
       (createMetadiagnosingInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMetadiagnosingInteractions ?goals ?groups)
      ()
      ((createMetadiagnosingInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMetadiagnosingInteractions! ?goals ?groups)
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
      ((createLDMetadiagElicitPerformanceInteractions ?goals ?groups)
       (createLDShowSolutionInstDiscussionInteractions ?goals ?groups)))
   
   ;; fall-back
   (:method (createMetadiagnosingInteractions ?goals ?groups)
      ()
      ((createLDMetadiagnosingInteractionEnvironment ?goals ?groups)
       (createLDMetadiagElicitPerformanceInteractions ?goals ?groups)
       (createLDShowSolutionInstDiscussionInteractions ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMetadiagnosingInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((Metadiagnosing InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (Metadiagnosing InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
