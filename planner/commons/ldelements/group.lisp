   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axioms and methods to build ld group                                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDGroup ?goals ?groups)
      ()
      ((createLDGroup! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDGroup! ?goals ?lgroups)
      ((assign ?learners (call ConcatList ?lgroups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?groups ?learner hasGroup)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?groups ((class Group)
                                    (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasGroup ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDGroup ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID group)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
                        ((Group) ?id () (?learners)))
       (createLDTitle (Group) ())
       (createGroup ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createGroup ?group ?learners)
      ()
      ((addUsersToGroup ?learners ?group)
       ;(createLDInformation ?group ?learners)
       ))
   
   (:method (createLDInformation ?group ?learners)
      ()
      ((!startLDElement information)
       (distributeItem ?learners)
       (!endLDElement information)))
   
