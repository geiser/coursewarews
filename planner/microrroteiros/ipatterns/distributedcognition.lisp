   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to distributed-cognition                      ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDistCognitionInteractions ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?strategies (?e) 1 inverseIsPartOf
                    ((class Strategy)))
       (getElement ?id ((class CurrentLDInteractions))))
      ((!!changeCurrentLDElement ?strategies)
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
	          ((DistCognition Interactions) ?id ?goals ?groups))
       (createLDTitle (DistCognition Interactions) ?goals)
       (createDistCognitionInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!!changeCurrentLDElement (?e))))
   
   ;; (TODO) - optional and mandatory
   (:method (createDistCognitionInteractions ?goals ?groups)
      ()
      ((createLDDistCognitionInteractionEnvironment ?goals ?groups)
       (createLDDemonHowSolveProblemInstDiscussionInteractions ?goals ?groups)
       (createLDReqProblemDetailInstThinkingInteractions ?goals ?groups)
       (createLDNotifyHowLearnerIsILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDistCognitionInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((DistCognition InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (DistCognition InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
