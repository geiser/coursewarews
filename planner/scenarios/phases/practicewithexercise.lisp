   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice-with-exercise phase      ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeWithExercisePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Practice Phase) ?id () ?groups))
       (createLDTitle (Practice Phase) ?goals)
       (createPracticeWithExercisePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createPracticeWithExercisePhase ?goals ?groups)
      ((getIndGoals ?indGoals ?goals ?groups)
       (assign ?clgrouping (call GetCLGrouping ?indGoals)))
      ((distributePracticeWithExerciseGroupActivityByCLGroups ?clgrouping)))
   
   ;;
   (:method (distributePracticeWithExerciseGroupActivityByCLGroups ())
      ()
      ())
   
   (:method (distributePracticeWithExerciseGroupActivityByCLGroups (?clg . ?clgroups))
      ((getGoalsFromCLGrouping ?goals ?clg)
       (getGroupsFromCLGrouping ?groups ?clg))
      ((!!changeCLGrouping ?clg)
       (createLDPracticeWithExerciseGroupActivity ?goals ?groups)
       (distributePracticeWithExerciseGroupActivityByCLGroups ?clgroups)))

