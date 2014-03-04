   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling ld conference-service             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDConferenceService ?goals ?groups)
      ()
      ((!startLDElement service ((identifier (call GetUUID serv))
                                 (isvisible true)))
       (createConferenceService ?goals ?groups)
       (!endLDElement service)))
   
   (:method (createConferenceService ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nro ?learners)
       (filterByQuery ?introverts ?learners
                      ((property hasPersonality introversion)))
       (length ?nrointroverts ?introverts)
       (call > ?nrointroverts (call / ?nro 2)))
      ((createLDAsynchronousConference ?goals ?learners))
      
      ()
      ((createLDSynchronousConference ?goals (call ConcatList ?groups))))
   
   ;; Method to create asynchronous conference
   ;; (TODO) - optional and mandatory
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDAsynchronousConference ?goals ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (assign ?service (call BuildElement ((class Service)
                                            (property hasCurrentUoL ?u)
                                            (property hasType asynchronous) . ?query))))
      ((!startLDElement conference ((conference-type asynchronous)))
       (createLDTitle (Asynchronous Conference) ?goals)
       (createConference ?goals ?learners)
       (createLDItem ?service)
       (!endLDElement conference)))
   
   ;; Method to create synchronous conference
   ;; (TODO) - optional and mandatory
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDSynchronousConference ?goals ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (assign ?service (call BuildElement ((class Service)
                                            (property hasCurrentUoL ?u)
                                            (property hasType synchronous) . ?query))))
      ((!startLDElement conference ((conference-type synchronous)))
       (createLDTitle (Synchronous Conference) ?goals)
       (createConference ?goals ?learners)
       (createLDItem ?service)
       (!endLDElement conference)))
   
   ;;
   (:method (createConference ?goals ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?ungroups ?learner hasGroup)
       (filterByQuery ?groups ?ungroups ((class Group)
                                         (property hasCurrentUoL ?u)))
       (getPropertyValues ?unroles ?learner hasRole)
       (filterByQuery ?roles ?unroles ((class Role)
                                       (class LDLearner)
                                       (property hasCurrentUoL ?u)))
       (assign ?refs (call Union (?groups ?roles))))
      ((distributeParticipants ?refs)))
   
   ;;
   (:method (distributeParticipants ())
      ()
      ())
   
   (:method (distributeParticipants (?ref . ?refs))
      ()
      ((!startLDElement participant ((role-ref ?ref)))
       (!endLDElement participant)
       (distributeParticipants ?refs)))
   
