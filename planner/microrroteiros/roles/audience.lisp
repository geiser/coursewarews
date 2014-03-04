   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling audience                          ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
      
   (:method (createLDAudienceRole ?goals ?groups)
      ()
      ((createLDAudienceRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDAudienceRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class Audience)
                                   (class LDLearner)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDAudienceRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((Audience Learning Role LDLearner) ?id () (?learners)))
       (createLDTitle (Audience Role LDLearner) ())
       (createAudienceRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createAudienceRole ?role ?learners)
      ()
      ((addUsersToRole ?learners ?role)
       ;(createLDAudienceInformation ?goals ?learners)
       ))
   
   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDAudienceInformation ?role ?learners)
      ()
      ((createLDAudienceInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDAudienceInformation! ?role ?learners)
      ((getElement ?description ((class Audience)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDAudienceInformation ?role ?learners)
      ((assign ?description (call BuildElement
                                  ((class Audience)
                                   (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
