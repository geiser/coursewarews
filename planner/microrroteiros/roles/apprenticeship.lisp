   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling apprenticeship role               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDApprenticeshipRole ?goals ?groups)
      ()
      ((createLDApprenticeshipRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDApprenticeshipRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class LDLearner)
                                   (class Apprenticeship)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDApprenticeshipRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((Apprenticeship Learning Role LDLearner) ?id () (?learners)))
       (createLDTitle (Apprenticeship Role LDLearner) ())
       (createApprenticeshipRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createApprenticeshipRole ?role ?learners)
      ()
      ((addUsersToRole ?learners ?role)
       ;(createLDApprenticeshipInformation ?role ?learners)
       ))
   
   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDApprenticeshipInformation ?role ?learners)
      ()
      ((createLDApprenticeshipInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDApprenticeshipInformation! ?role ?learners)
      ((getElement ?description ((class Apprenticeship)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDApprenticeshipInformation ?role ?learners)
      ((assign ?description (call BuildElement ((class Apprenticeship)
                                                (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
  
