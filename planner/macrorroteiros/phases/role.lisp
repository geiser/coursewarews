   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling role phase                        ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDRolePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Role Phase) ?id () ?groups))
       (createLDTitle (Role Phase) ?goals)
       (createRolePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createRolePhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nro ?goals)
       (duplicate ?grouping ?learners ?nro)
       (getCompsFromGoals ?comps ?goals))
      ((distributeRoleGroupActivityByComps ?goals ?grouping ?comps)))
   
   ;;
   (:method (distributeRoleGroupActivityByComps ?goals ?groups ())
      ()
      ())
   
   (:method (distributeRoleGroupActivityByComps ?goals ?groups (?c . ?comps))
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
      ((distributeRoleGroupActivityByCLGroups ?clgrouping)
       (distributeRoleGroupActivityByComps ?goals ?groups ?comps)))
   
   ;;
   (:method (distributeRoleGroupActivityByCLGroups ())
      ()
      ())
   
   (:method (distributeRoleGroupActivityByCLGroups (?clg . ?clgroups))
      ((getGoalsFromCLGrouping ?goals ?clg)
       (getGroupsFromCLGrouping ?groups ?clg))
      ((!!changeCLGrouping ?clg)
       (createLDRoleGroupActivity ?goals ?groups)
       (distributeRoleGroupActivityByCLGroups ?clgroups)))
   
