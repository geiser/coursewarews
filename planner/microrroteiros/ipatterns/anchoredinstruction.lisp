   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling anchrored instruction             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDAnchoredInstructionInteractions ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?strategies (?e) 1 inverseIsPartOf
                    ((class Strategy)))
       (getElement ?id ((class CurrentLDInteractions))))
      ((!!changeCurrentLDElement ?strategies)
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((AnchoredInstruction Interactions) ?id ?goals ?groups))
       (createLDTitle (AnchoredInstruction Interactions) ?goals)
       (createAnchoredInstructionInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!!changeCurrentLDElement (?e))))
  
   ;; (TODO) - optional and mandatory
   (:method (createAnchoredInstructionInteractions (?igoal ?hgoal) ?groups)
      ((last ?hl ?hgoal)
       (equivalent (any accretion) ?hl))
      ((createLDAnchoredInstructionInteractionEnvironment (?igoal ?hgoal) ?groups)
       (createLDReqProblemDetailNotifyHowLearnerIsInteractions (?igoal ?hgoal) ?groups)))
   
   (:method (createAnchoredInstructionInteractions (?igoal ?hgoal) ?groups)
      ((last ?hl ?hgoal)
       (equivalent (any tuning) ?hl))
      ((createLDAnchoredInstructionInteractionEnvironment (?igoal ?hgoal) ?groups)
       (createLDDiagProblemILEvent (?igoal ?hgoal) ?groups)
       (createLDMetadiagnosingInteractions (?igoal ?hgoal) ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDAnchoredInstructionInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((AnchoredInstruction InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (AnchoredInstruction InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
  
