   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling metadiagnosing-elicitperformance  ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMetadiagElicitPerformanceInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
               ((MetadiagElicitPerformance Interactions) ?id ?goals ?groups))
       (createLDTitle (MetadiagElicitPerformance Interactions) ?goals)
       (createMetadiagElicitPerformanceInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createMetadiagElicitPerformanceInteractions ?goals ?groups)
      ()
      ((createMetadiagElicitPerformanceInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMetadiagElicitPerformanceInteractions! ?goals ?groups)
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
   (:method (createMetadiagElicitPerformanceInteractions ?goals ?groups)
      ()
      ((createLDMetadiagElicitPerformanceInteractionEnvironment ?goals ?groups)
       (createLDSetLearningContextILEvent ?goals ?groups)
       (createLDElicitPerformanceILEvent ?goals ?groups)
       (createLDMonitoringILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMetadiagElicitPerformanceInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((MetadiagElicitPerformance InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (MetadiagElicitPerformance InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
 
