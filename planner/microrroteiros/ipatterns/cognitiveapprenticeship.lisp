   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling cognitive apprenticeship          ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDCogApprenticeshipInteractions ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?strategies (?e) 1 inverseIsPartOf
                    ((class Strategy)))
       (getElement ?id ((class CurrentLDInteractions))))
      ((!!changeCurrentLDElement ?strategies)
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
                        ((CogApprenticeship Interactions) ?id ?goals ?groups))
       (createLDTitle (CogApprenticeship Interactions) ?goals)
       (createCogApprenticeshipInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!!changeCurrentLDElement (?e))))
   
   ;; (TODO) - optional and mandatory
   (:method (createCogApprenticeshipInteractions (?mgoal ?agoal) ?groups)
      ((last ?al ?agoal)
       (or (equivalent (rough any) ?al)
           (equivalent (explanatory any) ?al)))
      ((createLDCogApprenticeshipInteractionEnvironment (?mgoal ?agoal) ?groups)
       (createLDSetLearningContextILEvent (?mgoal ?agoal) ?groups)
       (createLDDemonHowSolveProblemClarifyingProblemInteractions (?mgoal ?agoal) ?groups)))
   
   (:method (createCogApprenticeshipInteractions (?mgoal ?agoal) ?groups)
      ((last ?al ?agoal)
       (equivalent (associative any) ?al))
      ((createLDCogApprenticeshipInteractionEnvironment (?mgoal ?agoal) ?groups)
       (createLDMonitInstThinkWithMetademonInteractions (?mgoal ?agoal) ?groups)
       (createLDMonitoringNotifyHowLearnerIsInteractions (?mgoal ?agoal) ?groups)
       (createLDMonitoringInstThinkingInteractions (?mgoal ?agoal) ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDCogApprenticeshipInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((CogApprenticeship InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (CogApprenticeship InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))

