   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert session                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:method (createLDPairSession ?goals ?groups)
      ()
      ((createLDPairSession! ?goals ?groups)))

   ;; mandatory
   (:method (createLDPairSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class PairSession))
                         (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
               ((PairSession UoL) ?id ?goals ?skills ?attits ?groups))
       (createLDTitle (PairSession UoL) ?goals)
       (!startLDElement method)
       (createPairSession ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
   
   ;; fall-back
   (:method (createLDPairSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Pair Session) ?id ?goals ?groups))
       (createLDTitle (Pair Session) ?goals)
       (createPairSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createPairSession ?goals ?groups)
      ()
      ((createLDSolutionOutput ?goals ?groups)
       (createPairActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createPairActivity ?goals ?groups)
      ()
      ((createPairActivity! ?goals ?groups)))
   
   ;; mandatory
   (:method (createPairActivity! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType UoL ?e))
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; fall-back
   (:method (createPairActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDPairEnvironment ?goals ?groups)
       (createLDPairSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPairEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Pair Environment) ?id ?goals ?groups))
       (createLDTitle (Pair Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPairSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createPairSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createPairSessionDescription ?goals ?groups)
      ()
      ((createPairSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createPairSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class PairActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createPairSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class PairActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
