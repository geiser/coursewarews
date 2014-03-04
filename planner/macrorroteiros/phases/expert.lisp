   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert phase                      ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDExpertPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Expert Phase) ?id () ?groups))
       (createLDTitle (Expert Phase) ?goals)
       (createExpertPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createExpertPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nro ?goals)
       (duplicate ?grouping ?learners ?nro)
       (getCompsFromGoals ?comps ?goals))
      ((distributeExpertGroupActivityByComps ?goals ?grouping ?comps)))
   
   ;;
   (:method (distributeExpertGroupActivityByComps ?goals ?groups ())
      ()
      ())
   
   (:method (distributeExpertGroupActivityByComps ?goals ?groups (?c . ?comps))
      ((getElement ?e ((class CurrentLDElement)))
       (getRelated ?script ?e isPartOf)
       (getRelateds ?phases (?script) 1 inverseIsPartOf
                    ((class Phase)
                     (class Individual)))
       (getRelateds ?activities ?phases 1 inverseIsPartOf
                    ((class Individual)
                     (class GroupActivity)
                     (property hasCompetency ?c)))
       (getPropertyValues ?participants ?activities hasParticipant)
       (getIndGoals ?indGoals ?goals ?groups (?c) ?participants)
       (assign ?clgrouping (call GetCLGrouping ?indGoals)))
      ((distributeExpertGroupActivityByCLGroups ?clgrouping)
       (distributeExpertGroupActivityByComps ?goals ?groups ?comps)))
   
   ;;
   (:method (distributeExpertGroupActivityByCLGroups ())
      ()
      ())
   
   (:method (distributeExpertGroupActivityByCLGroups (?clg . ?clgroups))
      ((getGoalsFromCLGrouping ?goals ?clg)
       (getGroupsFromCLGrouping ?groups ?clg))
      ((!!changeCLGrouping ?clg)
       (createLDExpertGroupActivity ?goals ?groups)
       (distributeExpertGroupActivityByCLGroups ?clgroups)))
   
