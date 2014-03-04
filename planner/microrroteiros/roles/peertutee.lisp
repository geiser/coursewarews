   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling peer-tutee                        ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
     
   (:method (createLDPeerTuteeRole ?goals ?groups)
      ()
      ((createLDPeerTuteeRole! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDPeerTuteeRole! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?roles ?learner hasRole)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?roles ((class Role)
                                   (class PeerTutee)
                                   (class LDLearner)
                                   (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasRole ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDPeerTuteeRole ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID role)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
            ((PeerTutee Learning Role LDLearner) ?id () (?learners)))
       (createLDTitle (PeerTutee Role LDLearner) ())
       (createPeerTuteeRole ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createPeerTuteeRole ?role ?learners)
      ()
      ((addUsersToRole ?learners ?role)
       ;(createLDPeerTuteeInformation ?role ?learners)
       ))
   
   ;; Method to create information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPeerTuteeInformation ?role ?learners)
      ()
      ((createLDPeerTuteeInformation! ?role ?learners)))
   
   ;; mandatory
   (:method (createLDPeerTuteeInformation! ?role ?learners)
      ((getElement ?description ((class PeerTutee)
                                 (class RoleDescription))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;; fallback
   (:method (createLDPeerTuteeInformation ?role ?learners)
      ((assign ?description (call BuildElement ((class PeerTutee)
                                                (class RoleDescription)))))
      ((!startLDElement information)
       (createLDItem ?description)
       (distributeItem ?learners)
       (!endLDElement information)))
   
