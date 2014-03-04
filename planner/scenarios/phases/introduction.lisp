   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling introduction phase                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIntroductionPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Introduction Phase) ?id () ?groups))
       (createLDTitle (Introduction Phase) ?goals)
       (createIntroductionPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createIntroductionPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getLearnerCompetencyLevels ?levels ?learners ?c))
      ((distributeIntroductionGroupActivityByLevels (?c ?l) ?learners ?levels)))
   
   (:method (distributeIntroductionGroupActivityByLevels ?goal ?learners ())
      ()
      ())
   
   (:method (distributeIntroductionGroupActivityByLevels ?goal ?learners (?l . ?levels))
      ((first ?c ?goal)
       (filterLearnersByCompetencyLevel ?group ?learners ?c ?l)
       (remove ?rest ?learners ?group))
      ((createLDIntroductionGroupActivity (?goal) (?group))
       (distributeIntroductionGroupActivityByLevels ?goal ?rest ?levels)))
   
