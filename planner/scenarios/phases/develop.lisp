   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling develop phase                     ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDevelopPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Develop Phase) ?id () ?groups))
       (createLDTitle (Develop Phase) ?goals)
       (createDevelopPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createDevelopPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getLearnerCompetencyLevels ?levels ?learners ?c))
      ((distributeDevelopGroupActivityByLevels (?c ?l) ?learners ?levels)))
   
   (:method (distributeDevelopGroupActivityByLevels ?goal ?learners ())
      ()
      ())
   
   (:method (distributeDevelopGroupActivityByLevels ?goal ?learners (?l . ?levels))
      ((first ?c ?goal)
       (filterLearnersByCompetencyLevel ?group ?learners ?c ?l)
       (remove ?rest ?learners ?group))
      ((createLDDevelopGroupActivity (?goal) (?group))
       (distributeDevelopGroupActivityByLevels ?goal ?rest ?levels)))
   
