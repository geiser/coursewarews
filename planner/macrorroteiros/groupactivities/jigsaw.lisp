   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw-group activity             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDJigsawGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Jigsaw GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Jigsaw GroupActivity) ?goals)
       (createJigsawGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createJigsawGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDJigsawSessions ?goals ?groups)))
   
   ;;
   (:method (createLDJigsawSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Jigsaw Sessions) ?id ?goals ?groups))
       (createLDTitle (Jigsaw Sessions) ?goals)
       (createJigsawSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createJigsawSessions ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getRelated ?rp ?e isPartOf)
       (getCompFromGoals ?comp ?goals)
       (getPropertyValue ?aux ?comp hasKnowledge)
       (getRelateds ?subAuxs (?aux) 1 inverseIsPartOf
                    ((class Auxiliary)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getGoalsFromAuxiliaries ?subGoals ?subAuxs ?c))
      ((!!changeCLGrouping ())
       (distributeDiscussionSessionJigsaw ?subGoals ?learners)
       (!!changeCLGrouping ?rp)
       (createLDJigsawSession ?goals ?groups)))
   
   ;;
   (:method (distributeDiscussionSessionJigsaw () ?learners)
      ()
      ())
   
   (:method (distributeDiscussionSessionJigsaw (?goal . ?goals) ?learners)
      ()
      ((createLDDiscussionSession (?goal) (?learners))
       (distributeDiscussionSessionJigsaw ?goals ?learners)))
   
