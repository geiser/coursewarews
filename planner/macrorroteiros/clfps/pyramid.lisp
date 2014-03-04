   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Method used to modeling pyramid pattern  (clfps - macroscript)        ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;   
   
   (:method (createLDScript! ?goals ?groups)
      relative-pyramid-uol
      ((getCompFromGoals ?c ?goals)
       (hasKnowledgeType ?c Auxiliary)
       (getPropertyValue ?aux ?c hasKnowledge)
       (getPropertyValues ?difficults ?aux hasDifficult)
       (exist very-difficult ?difficults)
       (length ?nrolearners (call ConcatList ?groups))
       (call >= ?nrolearners 8)
       (getElement ?e ((class CurrentLDElement)))
       (getRelateds ?lds (?e) -1 isPartOf
                    ((class Script)
                     (class Pyramid)))
       (same ?lds ()))
      ;; complexity
      (:relative 3 ((assign ?learners (call ConcatList ?groups))
                    (length ?nroLearners ?learners)
                    (filterByQuery ?expLearners ?learners
                                   ((property hasCLExperience (medium low))))
                    (length ?nroExpLearners ?expLearners)
                    (call > ?nroExpLearners (call / ?nroLearners 2))))
      ;; skills and attitudes
      (:relative 1 ((getRelateds ?pi-variants (positive-interdependence) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?attitude1 ?u hasAttitude)
                    (or (same ?attitude1 positive-interdependence)
                        (exist ?attitude1 ?pi-variants))))
      (:relative 1 ((getRelateds ?d-variants (discussion) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?skill1 ?u hasSkill)
                    (or (same ?skill1 discussion)
                        (exist ?skill1 ?d-variants))))
      ((createLDPyramidScript ?goals ?groups)))
   
   ;; Method to create script (TODO) do auxiliary
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPyramidScript ?goals ?groups)
      ()
      ((createLDPyramidScript! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDPyramidScript! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((Pyramid Script) ?id ?goals ?groups))
       (createLDTitle (Pyramid Script) ?goals)
       (createPyramidScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; fall-back
   (:method (createLDPyramidScript ?fgoals ?groups)
      ((getCompFromGoals ?fc ?fgoals)
       (hasKnowledgeType ?fc Fundamental)
       (assign ?learners (call ConcatList ?groups))
       (getLearnerPropertyQuery ?tmpq1 ?fc ?learners (difficult very-difficult))
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?tmpq2 hasLearningObjective ?fc ?levels ?tmpq1)
       (getCurrentLearningResourceType ?types)
       (buildPropertyQuery ?query hasLearningResourceType ?types
                           ((class Auxiliary) . ?tmpq2))
       (getOrBuildReadyAux ?aux ?query ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fc ?levels)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((Pyramid Script) ?id ?goals ?groups))
       (!!changeFundCompetency ?fc)
       (createLDTitle (Pyramid Script) ?goals)
       (createPyramidScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; Method to create script
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createPyramidScript ?goals ?groups)
      ()
      ((createPyramidScript! ?goals ?groups)))
   
   ;; mandatory
   (:method (createPyramidScript! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups)))
      ((createLDIndividualPhase ?goals (?learners))
       (distributePyramidDiscussionPhase ?goals ?groups)))
   
   ;; fall-back
   (:method (createPyramidScript ?goals ?groups)
      ()
      ((!!addInWorldState (createPyramidScript fall-back ?goals ?groups))))
   
   ;; Method to distribute discussion phase
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (distributePyramidDiscussionPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nrolearners ?learners)
       (getElement ?e ((class CurrentLDElement)))
       (getRelateds ?phases (?e) 1 inverseIsPartOf
                    ((class Phase)
                     (class Discussion)))
       (length ?nrophases ?phases)
       (assign ?nroGroups (call Floor (call / ?nrolearners
                                (call ^ 2 (call + ?nrophases 1)))))
       (call > ?nroGroups 1))
      ((!!addInWorldState (nroGroupsInPhase ?e ?nroGroups))
       (createLDDiscussionPhase ?goals ?groups)
       (!!removeFromWorldState (nroGroupsInPhase ?e ?nroGroups))
       (distributePyramidDiscussionPhase ?goals ?groups))
      ;; fall-back
      ()
      ((createLDDiscussionPhase ?goals ?groups)))

