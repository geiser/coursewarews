   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling anchor-holder role                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDAnchoredInstructorRole ?goals ?groups)
      ()
      ((createLDAnchoredInstructorRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDAnchoredInstructorRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class LDLearner)
                                   (class AnchoredInstructor)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDAnchoredInstructorRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((AnchoredInstructor Instructional Role LDLearner) ?id () (?learners)))
       (createLDTitle (AnchoredInstructor Role LDLearner) ())
       (createAnchoredInstructorRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createAnchoredInstructorRole ?role ?learners)
      ()
      ((addUsersToRole ?learners ?role)
       ;(createLDAnchoredInstructorInformation ?role ?learners)
      ))
   
   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDAnchoredInstructorInformation ?role ?learners)
      ()
      ((createLDAnchoredInstructorInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDAnchoredInstructorInformation! ?role ?learners)
      ((getElement ?description ((class AnchoredInstructor)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDAnchoredInstructorInformation ?role ?learners)
      ((assign ?description (call BuildElement ((class AnchoredInstructor)
                                                (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
