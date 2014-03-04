   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Method used to modeling tps pattern  (clfps - macroscript)            ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;   
    
   (:method (createLDScript! ?goals ?groups)
      relative-think-pair-share-uol
      ((getCompFromGoals ?c ?goals)
       (hasKnowledgeType ?c Auxiliary)
       (getPropertyValue ?aux ?c hasKnowledge)
       (getPropertyValues ?types ?aux hasLearningResourceType)
       (exist questionnaire ?types)
       (assign ?learners (call ConcatList ?groups))
       (length ?nrolearners ?learners)
       (call >= ?nrolearners 4)
       (getElement ?e ((class CurrentLDElement)))
       (getRelateds ?lds (?e) -1 isPartOf
                    ((class Script)
                     (class ThinkPairShare)))
       (same ?lds ()))
      ;; complexity
      (:relative 3 ((assign ?learners (call ConcatList ?groups))
                    (length ?nrolearners ?learners)
                    (filterByQuery ?explearners ?learners
                                   ((property hasCLExperience (low very-low))))
                    (length ?nroexplearners ?explearners)
                    (call > ?nroexplearners (call / ?nrolearners 2))))
      ;; skills and attitudes
      (:relative 1 ((getRelateds ?pi-variants (positive-interdependence) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?attitude1 ?u hasAttitude)
                    (or (same ?attitude1 positive-interdependence)
                        (exist ?attitude1 ?pi-variants))))
      (:relative 1 ((getRelateds ?fsa-variants (focus-students-attention) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?skill1 ?u hasSkill)
                    (or (same ?skill1 focus-students-attention)
                        (exist ?skill1 ?fsa-variants))))
      (:relative 1 ((getRelateds ?d-variants (discussion) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?skill2 ?u hasSkill)
                    (or (same ?skill2 discussion)
                        (exist ?skill2 ?d-variants))))
      (:relative 1 ((getRelateds ?ltm-variants (long-term-memory) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?skill3 ?u hasSkill)
                    (or (same ?skill3 long-term-memory)
                        (exist ?skill3 ?ltm-variants))))
      (:relative 1 ((getRelateds ?ar-variants (analytical-reasoning) -1 isVariantOf)
                    (getElement ?e ((class CurrentLDElement)))
                    (getPropertyValue ?u ?e hasCurrentUoL)
                    (getPropertyValue ?skill4 ?u hasSkill)
                    (or (same ?skill4 analytical-reasoning)
                        (exist ?skill4 ?ar-variants))))
      ((createLDThinkPairShareScript ?goals ?groups)))
   
   ;; Method to create script (TODO) do auxiliary
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDThinkPairShareScript ?goals ?groups)
      ()
      ((createLDThinkPairShareScript! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDThinkPairShareScript! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((ThinkPairShare Script) ?id ?goals ?groups))
       (createLDTitle (ThinkPairShare Script) ?goals)
       (createThinkPairShareScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; fall-back
   (:method (createLDThinkPairShareScript ?fgoals ?groups)
      ((getCompFromGoals ?fc ?fgoals)
       (hasKnowledgeType ?fc Fundamental)
       (assign ?learners (call ConcatList ?groups))
       (getLearnerPropertyQuery ?tmpq1 ?fc ?learners)
       (getLevelsFromGoals ?levels ?fgoals)
       (buildPropertyQuery ?tmpq2 hasLearningObjective ?fc ?levels ?tmpq1)
       (getCurrentLearningResourceType ?types)
       (buildPropertyQuery ?query hasLearningResourceType ?types
               ((class Auxiliary)
                (property hasLearningResourceType questionnaire) . ?tmpq2))
       (getOrBuildReadyAux ?aux ?query ?learners)
       (getGoalsFromAuxiliary ?goals ?aux ?fc ?levels)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((ThinkPairShare Script) ?id ?goals ?groups))
       (!!changeFundCompetency ?fc)
       (createLDTitle (ThinkPairShare Script) ?goals)
       (createThinkPairShareScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;; Method to create script
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createThinkPairShareScript ?goals ?groups)
      ()
      ((createThinkPairShareScript! ?goals ?groups)))
   
   ;; mandatory
   (:method (createThinkPairShareScript! ?goals ?groups)
      ((getCurrentLearningResourceType ?types))
      ((!!changeLearningResourceType (questionnaire . ?types))
       (createLDIndividualPhase ?goals ?groups)
       (createLDPairPhase ?goals ?groups)
       (createLDSharePhase ?goals ?groups)))
   
   ;; fall-back
   (:method (createThinkPairShareScript ?goals ?groups)
      ()
      ((!!addInWorldState (createThinkPairShareScript fall-back ?goals ?groups))))
   
