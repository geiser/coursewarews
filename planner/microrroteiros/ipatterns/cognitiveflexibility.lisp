   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling lpp                               ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDCogFlexibilityInteractions ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?strategies (?e) 1 inverseIsPartOf
                    ((class Strategy)))
       (getElement ?id ((class CurrentLDInteractions))))
      ((!!changeCurrentLDElement ?strategies)
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
                        ((CogFlexibility Interactions) ?id ?goals ?groups))
       (createLDTitle (CogFlexibility Interactions) ?goals)
       (createCogFlexibilityInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!!changeCurrentLDElement (?e))))
   
   ;; (TODO) - optional and mandatory
   (:method (createCogFlexibilityInteractions ?goals ?groups)
      ()
      ((createLDCogFlexibilityInteractionEnvironment ?goals ?groups)
       (createLDKnowlTransmissionILEvent ?goals ?groups)
       (createLDMetarecognizeCommunicationInteractions ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDCogFlexibilityInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((CogFlexibility InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (CogFlexibility InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
