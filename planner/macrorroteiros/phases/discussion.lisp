   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling discussion phase                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDiscussionPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Discussion Phase) ?id () ?groups))
       (createLDTitle (Discussion Phase) ?goals)
       (createDiscussionPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   ;;
   (:method (createDiscussionPhase ?goals ?groups)
      ()
      ((createDiscussionPhase! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDiscussionPhase! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelated ?p ?e isPartOf)
       (nroGroupsInPhase ?p ?nroGroups)
       (getIndGoals ?indGoals ?goals ?groups)
       (assign ?clgrouping (call GetCLGrouping ?indGoals ?nroGroups)))
      ((distributeDiscussionGroupActivityByCLGroups ?clgrouping))
      ;; fall-back
      ()
      ((createLDDiscussionGroupActivity ?goals ?groups)))

   ;; fall-back
   (:method (createDiscussionPhase ?goals ?groups)
      ()
      ((createLDDiscussionGroupActivity ?goals ?groups)))
   
   ;;
   (:method (distributeDiscussionGroupActivityByCLGroups ())
      ()
      ())
   
   (:method (distributeDiscussionGroupActivityByCLGroups (?clg . ?clgroups))
      ((getGoalsFromCLGrouping ?goals ?clg)
       (getGroupsFromCLGrouping ?groups ?clg))
      ((!!changeCLGrouping ?clg)
       (createLDDiscussionGroupActivity ?goals ?groups)
       (distributeDiscussionGroupActivityByCLGroups ?clgroups)))
   
