   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling master role                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMasterRole ?goals ?groups)
      ()
      ((createLDMasterRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDMasterRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class Master)
                                   (class LDLearner)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDMasterRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((Master Instructional Role LDLearner) ?id () (?learners)))
       (createLDTitle (Master Role LDLearner) ())
       (createMasterRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createMasterRole ?role ?learners)
      ()
      ((addUsersToRole ?learners ?role)
       ;(createLDMasterInformation ?goals ?learners)
       ))
   
   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMasterInformation ?role ?learners)
      ()
      ((createLDMasterInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDMasterInformation! ?role ?learners)
      ((getElement ?description ((class Master)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDMasterInformation ?role ?learners)
      ((assign ?description (call BuildElement ((class Master)
                                                (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
