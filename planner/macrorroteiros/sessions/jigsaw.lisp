   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw session                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDJigsawSession ?goals ?groups)
      ()
      ((createLDJigsawSession! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDJigsawSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class JigsawSession))
                         (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
                        ((JigsawSession UoL) ?id ?goals ?skills ?attits ?groups))
       (createLDTitle (JigsawSession UoL) ?goals)
       (!startLDElement method)
       (createJigsawSession ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
   
   ;; fall-back
   (:method (createLDJigsawSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Jigsaw Session) ?id ?goals ?groups))
       (createLDTitle (Jigsaw Session) ?goals)
       (createJigsawSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createJigsawSession ?goals ?groups)
      ()
      ((createJigsawSession! ?goals ?groups)))
   
   ;; mandatory
   (:method (createJigsawSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?sessions (?e) 1 isPartOf
                    ((class Jigsaw)
                     (class Sessions)))
       (assign ?learners (call ConcatList ?groups))
       (getRelateds ?resumes ?sessions 3 inverseIsPartOf
                    ((class Output)
                     (class ResumeDiscussion)
                     (property hasParticipant ?learners)))) 
      ((createLDInputs ?resumes ?learners)
       (createJigsawActivity ?goals ?groups)))
   
   ;; fall-back
   (:method (createJigsawSession ?goals ?groups)
      ()
      ((createJigsawActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createJigsawActivity ?goals ?groups)
      ()
      ((createJigsawActivity! ?goals ?groups)))
   
   ;; mandatory 
   (:method (createJigsawActivity! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType UoL ?e))
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; fall-back
   (:method (createJigsawActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDJigsawEnvironment ?goals ?groups)
       (createLDJigsawSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDJigsawEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Jigsaw Environment) ?id ?goals ?groups))
       (createLDTitle (Jigsaw Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDJigsawSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createJigsawSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createJigsawSessionDescription ?goals ?groups)
      ()
      ((createJigsawSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createJigsawSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class JigsawActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createJigsawSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class JigsawActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
