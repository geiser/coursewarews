   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   demonstrating-how-solve-problem and clarifying-problem              ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDemonHowSolveProblemClarifyingProblemInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((DemonHowSolveProblemClarifyingProblem Interactions) ?id ?goals ?groups))
       (createLDTitle (DemonHowSolveProblem ProblemDetail Iteractions) ?goals)
       (createDemonHowSolveProblemClarifyingProblemInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createDemonHowSolveProblemClarifyingProblemInteractions ?goals ?groups)
      ()
      ((createDemonHowSolveProblemClarifyingProblemInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDemonHowSolveProblemClarifyingProblemInteractions! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getRelateds ?interactions (?e) -1 isPartOf
                    ((class Interactions)
                     (property hasCurrentUoL ?u)))
       (buildPropertyQuery ?tmpQuery hasGoal ?goals
                           ((class InteractionEnvironment)
                            (property hasCurrentUoL ?u)))
       (buildPropertyQuery ?query hasParticipant ?learners ?tmpQuery)
       (getRelateds ?environments ?interactions 1 inverseIsPartOf ?query)
       (different ?environments ()))
      ((createLDDemonHowSolveProblemILEvent ?goals ?groups)
       (createLDClarifyingProblemILEvent ?goals ?groups)))

   ;; fall-back
   (:method (createDemonHowSolveProblemClarifyingProblemInteractions ?goals ?groups)
      ()
      ((createLDDemonHowSolveProblemClarifyingProblemInteractionEnvironment ?goals ?groups)
       (createLDDemonHowSolveProblemILEvent ?goals ?groups)
       (createLDClarifyingProblemILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDemonHowSolveProblemClarifyingProblemInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((DemonHowSolveProblemClarifyingProblem InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (DemonHowSolveProblem ClarifyingProblem InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
