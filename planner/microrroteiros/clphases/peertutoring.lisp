   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling peer-tutoring                     ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPeerTutoringPhase ?goals ?groups)
      ((assign ?id (call GetUUID act))
       (assign ?as (call GetUUID as)))
      ((!startLDElement act ((identifier ?id))
                        ((PeerTutoring Phase) ?id ?goals ?groups))
       (createLDTitle (PeerTutoring Phase) ?goals)
       (!!addInWorldState (class CurrentLDInteractions ?as))
       (createPeerTutoringPhase ?goals ?groups)
       (!!removeFromWorldState (class CurrentLDInteractions ?as))
       (!endLDElement act ?id)))
   
   ;; (TODO) - optional and mandatory
   (:method (createPeerTutoringPhase (?ogoal ?egoal) (?tutors ?tutees))
      ()
      ((createLDLearningByTeachingStrategy (?ogoal) (?tutors))
       (createLDLearningByBeingTaughtStrategy (?egoal) (?tutees))
       (createLDPeerTutoringInteractions (?ogoal ?egoal) (?tutors ?tutees))))
   
