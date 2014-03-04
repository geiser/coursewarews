   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert session                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:method (createLDRoleSession ?goals ?groups)
      ()
      ((createLDRoleSession! ?goals ?groups)))

   ;; mandatory
   (:method (createLDRoleSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class RoleSession))
                         (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
               ((RoleSession UoL) ?id ?goals ?skills ?attits ?groups))
       (createLDTitle (RoleSession UoL) ?goals)
       (!startLDElement method)
       (createRoleSession ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
   
   ;; fall-back
   (:method (createLDRoleSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Role Session) ?id ?goals ?groups))
       (createLDTitle (Role Session) ?goals)
       (createRoleSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createRoleSession ?goals ?groups)
      ()
      ((createRoleActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createRoleActivity ?goals ?groups)
      ()
      ((createRoleActivity! ?goals ?groups)))
   
   ;; mandatory
   (:method (createRoleActivity! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType UoL ?e))
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; fall-back
   (:method (createRoleActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDRoleEnvironment ?goals ?groups)
       (createLDRoleSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDRoleEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Role Environment) ?id ?goals ?groups))
       (createLDTitle (Role Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDRoleSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createRoleSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createRoleSessionDescription ?goals ?groups)
      ()
      ((createRoleSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createRoleSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class RoleActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createRoleSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class RoleActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
