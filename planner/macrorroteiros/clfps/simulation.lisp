   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Method used to modeling simulation pattern  (clfps - macroscript)     ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;   
   
   (:method (createLDScript! ?goals ?groups)
      relative-simulation-uol
      ((getCompFromGoals ?c ?goals)
       (hasKnowledgeType ?c Auxiliary)
       (getPropertyValue ?aux ?c hasKnowledge)
       (getPropertyValues ?types ?aux hasLearningResourceType)
       (exist simulation ?types)
       (getRelateds ?subauxs (?aux) 1 inverseIsPartOf
                    ((class Auxiliary)))
       (length ?nrosubauxs ?subauxs)
       (call > ?nrosubauxs 1)
       (length ?nrolearners (call ConcatList ?groups))
       (call >= ?nrolearners (call * 2 ?nrosubauxs))
       (getElement ?e ((class CurrentLDElement)))
       (getRelateds ?lds (?e) -1 isPartOf
                    ((class Script)
                     (class Simulation)))
       (same ?lds ()))
      ;; complexity
      (:relative 3 ((assign ?learners (call ConcatList ?groups))
                    (length ?nrolearners ?learners)
                    (filterByQuery ?explearners ?learners
                                   ((property hasCLExperience (medium low))))
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
      ((createLDSimulationScript ?goals ?groups)))
   
   ;; Method to create script (TODO) do auxiliary
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDSimulationScript ?goals ?groups)
      ()
      ((createLDSimulationScript! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDSimulationScript! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((Simulation Script) ?id ?goals ?groups))
       (createLDTitle (Simulation Script) ?goals)
       (createSimulationScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; fall-back
   (:method (createLDSimulationScript ?fgoals ?groups)
      ((getCompFromGoals ?fc ?fgoals)
       (hasKnowledgeType ?fc Fundamental)
       (assign ?learners (call ConcatList ?groups))
       (getLearnerPropertyQuery ?tmpq1 ?fc ?learners)
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?tmpq2 hasLearningObjective ?fc ?levels ?tmpq1)
       (getCurrentLearningResourceType ?types)
       (buildPropertyQuery ?query hasLearningResourceType ?types
                  ((class Auxiliary)
                   (property hasLearningResourceType simulation) . ?tmpq2))
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
                        ((Simulation Script) ?id ?goals ?groups))
       (!!changeFundCompetency ?fc)
       (createLDTitle (Simulation Script) ?goals)
       (createSimulationScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; Method to create script
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createSimulationScript ?goals ?groups)
      ()
      ((createSimulationScript! ?goals ?groups)))
   
   ;; mandatory (auxiliary)
   (:method (createSimulationScript! ?goals ?groups)
      ((getCompFromGoals ?c ?goals)
       (hasKnowledgeType ?c Auxiliary)
       (getPropertyValue ?aux ?c hasKnowledge)
       (getCurrentLearningResourceType ?types)
       (getRelateds ?subauxs (?aux) 1 inverseIsPartOf
                    ((class Auxiliary)))
       (length ?nrosubauxs ?subauxs)
       (call > ?nrosubauxs 1)
       (assign ?learners (call ConcatList ?groups))
       (length ?nrolearners ?learners)
       (call >= ?nrolearners (call * 2 ?nrosubauxs))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?fc ?e hasFundCompetency)
       (getGoalsFromAuxiliaries ?subgoals ?subauxs ?fc))
      ((!!changeLearningResourceType (simulation . ?types))
       (createLDIndividualPhase ?subgoals (?learners))
       (createLDRolePhase ?subgoals (?learners))
       (createLDSimulationPhase ?goals ?groups)))
   
   ;; fall-back (auxiliary create sub part)
   (:method (createSimulationScript ?goals ?groups)
      ()
      ((!!addInWorldState (createSimulationScript fall-back ?goals ?groups))))
   
