   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling illustrate phase                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIllustratePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Illustrate Phase) ?id () ?groups))
       (createLDTitle (Illustrate Phase) ?goals)
       (createIllustratePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createIllustratePhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getLearnerCompetencyLevels ?levels ?learners ?c))
      ((distributeIllustrateGroupActivityByLevels (?c ?l) ?learners ?levels)))
   
   (:method (distributeIllustrateGroupActivityByLevels ?goal ?learners ())
      ()
      ())
   
   (:method (distributeIllustrateGroupActivityByLevels ?goal ?learners (?l . ?levels))
      ((first ?c ?goal)
       (filterLearnersByCompetencyLevel ?group ?learners ?c ?l)
       (remove ?rest ?learners ?group))
      ((createLDIllustrateGroupActivity (?goal) (?group))
       (distributeIllustrateGroupActivityByLevels ?goal ?rest ?levels)))
 
   
