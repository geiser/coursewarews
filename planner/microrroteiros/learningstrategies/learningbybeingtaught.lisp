   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-being-taught          ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDLearningByBeingTaughtStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningByBeingTaught Strategy) ?id () ?groups))
       (createLDTitle (LearningByBeingTaught Strategy) ?goals)
       (createLearningByBeingTaughtStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningByBeingTaughtStrategy ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?clscenarios (?e) 3 isPartOf
                    ((class CLScenario)
                     (class PeerTutoring)))
       (different ?clscenarios ()))
      ((createLDPeerTuteeRole ?goals ?groups)
       (createLDPeerTuteeInteractions ?goals ?groups)))
   
   (:method (createLearningByBeingTaughtStrategy ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?clscenarios (?e) 3 isPartOf
                    ((class CLScenario)
                     (class AnchoredInstruction)))
       (different ?clscenarios ()))
      ((createLDAnchorHolderRole ?goals ?groups)
       (createLDAnchorHolderInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDPeerTuteeInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
   
   (:method (createLDAnchorHolderInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
  
