   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and method used to modeling individual session   ;;
   ;; (TODO) - Mandatory and fall-back
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIndividualSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((Individual Session) ?id ?goals ?groups))
       (createLDTitle (Individual Session) ?goals)
       (createIndividualSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;;
   (:method (createIndividualSession ?goals ?groups)
      ()
      ((createIndividualActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:method (createIndividualActivity ?goals ?groups)
      ()
      ((createLDIndividualEnvironment ?goals ?groups)
       (createLDIndividualSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDIndividualEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Individual Environment) ?id ?goals ?groups))
       (createLDTitle (Individual Environment) ?goals)
       (createIndividualEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   (:method (createIndividualEnvironment ?goals ?groups)
      ()
      ((distributeLearningObject ?goals ?groups)))
     
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDIndividualSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createIndividualSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   ;;
   (:method (createIndividualSessionDescription ?goals ?groups)
      ()
      ((createIndividualSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createIndividualSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class IndividualActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createIndividualSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class IndividualActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))

