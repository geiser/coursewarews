   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling lpp                               ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDLPPInteractions ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?strategies (?e) 1 inverseIsPartOf
                    ((class Strategy)))
       (getElement ?id ((class CurrentLDInteractions))))
      ((!!changeCurrentLDElement ?strategies)
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
                        ((LPP Interactions) ?id ?goals ?groups))
       (createLDTitle (LPP Interactions) ?goals)
       (createLPPInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!!changeCurrentLDElement (?e))))
   
   ;; (TODO) - optional and mandatory
   (:method (createLPPInteractions (?fgoal ?pgoal) ?groups)
      ((last ?plevel ?pgoal)
       (equivalent (rough any) ?plevel))
      ((createLDLPPInteractionEnvironment (?fgoal ?pgoal) ?groups)
       (createLDDemonHowSolveProblemInstDiscussionInteractions (?fgoal ?pgoal) ?groups)
       (createLDReqProblemDetailILEvent (?fgoal ?pgoal) ?groups)))
   
   (:method (createLPPInteractions (?fgoal ?pgoal) ?groups)
      ((last ?plevel ?pgoal)
       (equivalent (associative any) ?plevel))
      ((createLDLPPInteractionEnvironment (?fgoal ?pgoal) ?groups)
       (createLDNotifyHowLearnerIsILEvent (?fgoal ?pgoal) ?groups)
       (createLDDemonHowSolveProblemInstDiscussionInteractions (?fgoal ?pgoal) ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDLPPInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((LPP InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (LPP InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
