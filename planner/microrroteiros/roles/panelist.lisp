   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling panelist                          ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDPanelistRole ?goals ?groups)
      ()
      ((createLDPanelistRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDPanelistRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class Panelist)
                                   (class LDLearner)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDPanelistRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((Panelist Instructional Role LDLearner) ?id () (?learners)))
       (createLDTitle (Panelist Role LDLearner) ())
       (createPanelistRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createPanelistRole ?role ?learners)
      ()
      ((addUsersToRole ?learners ?role)
       ;(createLDPanelistInformation ?role ?learners)
       ))
   
   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPanelistInformation ?role ?learners)
      ()
      ((createLDPanelistInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDPanelistInformation! ?role ?learners)
      ((getElement ?description ((class Panelist)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDPanelistInformation ?role ?learners)
      ((assign ?description (call BuildElement ((class Panelist)
                                                (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
