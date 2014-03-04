   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling peer-tutoring                     ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDPeerTutoringInteractions ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?strategies (?e) 1 inverseIsPartOf
                    ((class Strategy)))
       (getElement ?id ((class CurrentLDInteractions))))
      ((!!changeCurrentLDElement ?strategies)
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
                        ((PeerTutoring Interactions) ?id ?goals ?groups))
       (createLDTitle (PeerTutoring Interactions) ?goals)
       (createPeerTutoringInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!!changeCurrentLDElement (?e))))
   
   ;; (TODO) - optional and mandatory
   (:method (createPeerTutoringInteractions ?goals ?groups)
      ()
      ((createLDPeerTutoringInteractionEnvironment ?goals ?groups)
       (createLDKnowlTransmissionReqProblemDetailInteractions ?goals ?groups)
       (createLDMetarecognizeProgressInteractions ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPeerTutoringInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((PeerTutoring InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (PeerTutoring InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
