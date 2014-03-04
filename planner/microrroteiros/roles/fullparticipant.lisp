   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling full-participants                 ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; Method to create learning role
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDFullParticipantLearnerRole ?goals ?groups)
      ()
      ((createLDFullParticipantLearnerRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDFullParticipantLearnerRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class LDLearner)
                                   (class FullParticipantLearner)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDFullParticipantLearnerRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((FullParticipantLearner Learning Role LDLearner) ?id () (?learners)))
       (createLDTitle (FullParticipantLearner Role LDLearner) ())
       (createFullParticipantRole ?goals ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createFullParticipantRole ?goals ?learners)
      ((getElement ?e ((class CurrentLDElement))))
      ((addUsersToRole ?learners ?e)
       ;(createLDFullParticipantInformation ?goals ?learners)
       ))
   
   ;; Method to create instructional role
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDFullParticipantInstructorRole ?goals ?groups)
      ()
      ((createLDFullParticipantInstructorRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDFullParticipantInstructorRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class LDLearner)
                                   (class FullParticipantInstructor)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDFullParticipantInstructorRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((FullParticipantInstructor Instructional Role LDLearner) ?id () (?learners)))
       (createLDTitle (FullParticipantInstructor Role LDLearner) ())
       (createFullParticipantRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))

   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDFullParticipantInformation ?role ?learners)
      ()
      ((createLDFullParticipantInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDFullParticipantInformation! ?role ?learners)
      ((getElement ?description ((class FullParticipant)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDFullParticipantInformation ?role ?learners)
      ((assign ?description (call BuildElement ((class FullParticipant)
                                                (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
