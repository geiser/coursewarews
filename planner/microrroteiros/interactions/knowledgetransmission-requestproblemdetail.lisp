   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   knowledge-transmission and request-problem-detail                   ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDKnowlTransmissionReqProblemDetailInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((KnowlTransmissionReqProblemDetail Interactions) ?id ?goals ?groups))
       (createLDTitle (KnowlTransmission ProblemDetail Iteractions) ?goals)
       (createKnowlTransmissionReqProblemDetailInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createKnowlTransmissionReqProblemDetailInteractions ?goals ?groups)
      ()
      ((createKnowlTransmissionReqProblemDetailInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createKnowlTransmissionReqProblemDetailInteractions! ?goals ?groups)
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
      ((createLDKnowlTransmissionILEvent ?goals ?groups)
       (createLDReqProblemDetailILEvent ?goals ?groups)))

   ;; fall-back
   (:method (createKnowlTransmissionReqProblemDetailInteractions ?goals ?groups)
      ()
      ((createLDKnowlTransmissionReqProblemDetailInteractionEnvironment ?goals ?groups)
       (createLDKnowlTransmissionILEvent ?goals ?groups)
       (createLDReqProblemDetailILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDKnowlTransmissionReqProblemDetailInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((KnowlTransmissionReqProblemDetail InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (KnowlTransmission ReqProblemDetail InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
