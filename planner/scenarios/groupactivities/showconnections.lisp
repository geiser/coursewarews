   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling show connections group activity   ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDShowConnectionsGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((ShowConnections GroupActivity) ?id ?goals ?groups))
       (createLDTitle (ShowConnections GroupActivity) ?goals)
       (createShowConnectionsGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createShowConnectionsGroupActivity ?goals ?groups)
      ((getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getElements ?theorems ((class Fundamental)
                               (property hasLearningResourceType theorem)
                               (relation inverseIsRequiredBy ?c)))
       (different ?theorems ())
       (length ?nro ?theorems)
       (assign ?learners (call ConcatList ?groups))
       (assign ?tgoals (call GetProduct ?theorems (?l)))
       (duplicate ?tgroups ?learners ?nro))
      ((createLDGroup ?goals ?groups)
       (createLDShowConnectionsByTheoremWithProofSessions ?tgoals ?tgroups)))
   
   (:method (createShowConnectionsGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDShowConnectionsByCMapSession ?goals ?groups)))
   
   ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowConnectionsByTheoremWithProofSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((ShowConnectionsByTheoremWithProof Sessions) ?id ?goals ?groups))
       (createLDTitle (ShowConnectionsByTheoremWithProof Sessions) ?goals)
       (createShowConnectionsByTheoremWithProofSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createShowConnectionsByTheoremWithProofSessions ?goals ?groups)
      ()
      ((distributeShowTheoremWithProofSessions ?goals ?groups)))
  
   ;; 
   (:method (distributeShowTheoremWithProofSessions () ())
      ()
      ())
   
   (:method (distributeShowTheoremWithProofSessions (?goal . ?goals) (?group . ?groups))
      ()
      ((createLDDevelopConnectionSessions (?goal) (?group))     
       (distributeShowTheoremWithProofSessions ?goals ?groups)))
   
   ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDevelopConnectionSessions ?goals ?groups)
      ()
      ((!startLDElement ativity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((DevelopConnection Sessions) ?id ?goals ?groups))
       (createDevelopConnectionSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createDevelopConnectionSessions ?goals ?groups)
      ()
      ((createLDDevelopSession ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
