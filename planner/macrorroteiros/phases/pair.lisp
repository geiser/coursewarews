   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert phase                      ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPairPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Pair Phase) ?id () ?groups))
       (createLDTitle (Pair Phase) ?goals)
       (createPairPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createPairPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nrolearners ?learners)
       (assign ?nrogroups (call Floor (call / ?nrolearners 2)))
       (getIndGoals ?indGoals ?goals ?groups)
       (assign ?clgrouping (call GetCLGrouping ?indGoals ?nrogroups)))
      ((distributePairGroupActivityByCLGroups ?clgrouping)))
   
   ;;
   (:method (distributePairGroupActivityByCLGroups ())
      ()
      ())
   
   (:method (distributePairGroupActivityByCLGroups (?clg . ?clgroups))
      ((getGoalsFromCLGrouping ?goals ?clg)
       (getGroupsFromCLGrouping ?groups ?clg))
      ((!!changeCLGrouping ?clg)
       (createLDPairGroupActivity ?goals ?groups)
       (distributePairGroupActivityByCLGroups ?clgroups)))
   
