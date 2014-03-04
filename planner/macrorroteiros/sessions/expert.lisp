   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert session                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:method (createLDExpertSession ?goals ?groups)
      ()
      ((createLDExpertSession! ?goals ?groups)))

   ;; mandatory
   (:method (createLDExpertSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class ExpertSession))
                         (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
               ((ExpertSession UoL) ?id ?goals ?skills ?attits ?groups))
       (createLDTitle (ExpertSession UoL) ?goals)
       (!startLDElement method)
       (createExpertSession ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
   
   ;; fall-back
   (:method (createLDExpertSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Expert Session) ?id ?goals ?groups))
       (createLDTitle (Expert Session) ?goals)
       (createExpertSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createExpertSession ?goals ?groups)
      ()
      ((createLDResumeDiscussionOutput ?goals ?groups)
       (createExpertActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createExpertActivity ?goals ?groups)
      ()
      ((createExpertActivity! ?goals ?groups)))
   
   ;; mandatory
   (:method (createExpertActivity! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType UoL ?e))
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; fall-back
   (:method (createExpertActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDExpertEnvironment ?goals ?groups)
       (createLDExpertSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDExpertEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Expert Environment) ?id ?goals ?groups))
       (createLDTitle (Expert Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDExpertSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createExpertSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createExpertSessionDescription ?goals ?groups)
      ()
      ((createExpertSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createExpertSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class ExpertActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createExpertSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class ExpertActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
