   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw session                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDSimulationSession ?goals ?groups)
      ()
      ((createLDSimulationSession! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDSimulationSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class SimulationSession))
                         (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
                        ((SimulationSession UoL) ?id ?goals ?skills ?attits ?groups))
       (createLDTitle (SimulationSession UoL) ?goals)
       (!startLDElement method)
       (createSimulationSession ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
   
   ;; fall-back
   (:method (createLDSimulationSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Simulation Session) ?id ?goals ?groups))
       (createLDTitle (Simulation Session) ?goals)
       (createSimulationSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;; (TODO) - optional and mandatory
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createSimulationSession ?goals ?groups)
      ()
      ((createLDSimulationOutput ?goals ?groups)
       (createSimulationActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createSimulationActivity ?goals ?groups)
      ()
      ((createSimulationActivity! ?goals ?groups)))
   
   ;; mandatory 
   (:method (createSimulationActivity! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType UoL ?e))
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; fall-back
   (:method (createSimulationActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDSimulationEnvironment ?goals ?groups)
       (createLDSimulationSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDSimulationEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Simulation Environment) ?id ?goals ?groups))
       (createLDTitle (Simulation Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDSimulationSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createSimulationSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createSimulationSessionDescription ?goals ?groups)
      ()
      ((createSimulationSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createSimulationSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class SimulationActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createSimulationSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class SimulationActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
