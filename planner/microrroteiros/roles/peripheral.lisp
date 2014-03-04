   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling peripheral role                   ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
     
   (:method (createLDPeripheralRole ?goals ?groups)
      ()
      ((createLDPeripheralRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDPeripheralRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class LDLearner)
                                   (class Peripheral)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
     ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDPeripheralRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((Peripheral Learning Role LDLearner) ?id () (?learners)))
       (createLDTitle (Peripheral Role LDLearner) ())
       (createPeripheralRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createPeripheralRole ?role ?learners)
      ()
      ((addUsersToRole ?learners ?role)
       ;(createLDPeripheralInformation ?role ?learners)
       ))
   
   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPeripheralInformation ?role ?learners)
      ()
      ((createLDPeripheralInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDPeripheralInformation! ?role ?learners)
      ((getElement ?description ((class Peripheral)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDPeripheralInformation ?role ?learners)
      ((assign ?description (call BuildElement ((class Peripheral)
                                                (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
