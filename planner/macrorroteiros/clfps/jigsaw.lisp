   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Method used to modeling jigsaw pattern  (clfps - macroscript)         ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;   

   (:method (createLDScript! ?goals ?groups)
      relative-jigsaw-uol
      ((getCompFromGoals ?c ?goals)
       (hasKnowledgeType ?c Auxiliary)
       (getPropertyValue ?aux ?c hasKnowledge)
       (getPropertyValues ?types ?aux hasLearningResourceType)
       (not (exist simulation ?types))
       ;(getRelateds ?subauxs ?aux inverseIsPartOf
       ;             ((class Auxiliary)))
       (assign ?subauxs (call GetRelated ?aux inverseIsPartOf))
       (length ?nrosubauxs ?subauxs)
       (different ?subauxs ())
       (call > ?nrosubauxs 1)
       (length ?nrolearners (call ConcatList ?groups))
       (call >= ?nrolearners (call * 2 ?nrosubauxs))
       (getElement ?e ((class CurrentLDElement)))
       (getRelateds ?lds (?e) -1 isPartOf
                    ((class Jigsaw)
                     (class Script)))
       (same ?lds ())
       )
      ;; complexity
      (:relative 3 ((assign ?learners (call ConcatList ?groups))
                    (length ?nrolearners ?learners)
                    (filterByQuery ?explearners ?learners
                                   ((property hasCLExperience (high very-high))))
                    (length ?nroexplearners ?explearners)
                    (call > ?nroexplearners (call / ?nrolearners 2))))
      ;; skills and attitudes
      (:relative 1 ((getRelateds ?pi-variants (positive-interdependence) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?attitude1 ?u hasAttitude)
                    (or (same ?attitude1 positive-interdependence)
                        (exist ?attitude1 ?pi-variants))))
      (:relative 1 ((getRelateds ?ia-variants (individual-accountability) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?attitude2 ?u hasAttitude)
                    (or (same ?attitude2 individual-accountability)
                        (exist ?attitude2 ?ia-variants))))
      (:relative 1 ((getRelateds ?d-variants (discussion) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?skill1 ?u hasSkill)
                    (or (same ?skill1 discussion)
                        (exist ?skill1 ?d-variants))))
      (
       (createLDJigsawScript ?goals ?groups)
       ))
   
   ;; Method to create script (TODO) do auxiliary
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDJigsawScript ?goals ?groups)
      ()
      ((createLDJigsawScript! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDJigsawScript! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((Jigsaw Script) ?id ?goals ?groups))
       (createLDTitle (Jigsaw Script) ?goals)
       (createJigsawScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; fall-back
   (:method (createLDJigsawScript ?fgoals ?groups)
      ((getCompFromGoals ?fc ?fgoals)
       (hasKnowledgeType ?fc Fundamental)
       (assign ?learners (call ConcatList ?groups))
       (getLearnerPropertyQuery ?tmpq1 ?fc ?learners)
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?tmpq2 hasLearningObjective ?fc ?levels ?tmpq1)
       (getCurrentLearningResourceType ?types)
       (buildPropertyQuery ?query hasLearningResourceType ?types
                           ((class Auxiliary) . ?tmpq2))
       (getElements ?unsortauxs ?query)
       (sortByAlreadySeen ?auxs ?unsortauxs ?learners)
       (assignIterator ?aux ?auxs)
       (getRelateds ?subauxs (?aux) 1 inverseIsPartOf
                    ((class Auxiliary)))
       (length ?nrosubauxs ?subauxs)
       (call > ?nrosubauxs 1)
       (call >= ?nrolearners (call * 2 ?nrosubauxs)) 
       (getGoalsFromAuxiliary ?goals ?aux ?fc ?levels)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((Jigsaw Script) ?id ?goals ?groups))
       (!!changeFundCompetency ?fc)
       (createLDTitle (Jigsaw Script) ?goals)
       (createJigsawScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; Method to create script
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createJigsawScript ?goals ?groups)
      ()
      ((createJigsawScript! ?goals ?groups)))
   
   ;; mandatory (auxiliary)
   (:method (createJigsawScript! ?goals ?groups)
      ((getCompFromGoals ?c ?goals)
       (hasKnowledgeType ?c Auxiliary)
       (getPropertyValue ?aux ?c hasKnowledge)
       (assign ?subauxs (call GetRelated ?aux inverseIsPartOf))
       ;(getRelateds ?subauxs (?aux) 1 inverseIsPartOf
       ;             ((class Auxiliary)))
       (length ?nrosubauxs ?subauxs)
       (call > ?nrosubauxs 1)
       (assign ?learners (call ConcatList ?groups))
       (length ?nrolearners ?learners)
       (call >= ?nrolearners (call * 2 ?nrosubauxs))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?fc ?e hasFundCompetency)
       (getGoalsFromAuxiliaries ?subgoals ?subauxs ?fc)
       )
      (
       (createLDIndividualPhase ?subgoals (?learners))
       (createLDExpertPhase ?subgoals (?learners))
       (createLDJigsawPhase ?goals ?groups)
       ))
   
   ;; fall-back (auxiliary create sub part)
   (:method (createJigsawScript ?goals ?groups)
      ()
      ((!!addInWorldState (createJigsawScript fall-back ?goals ?groups))))
  
