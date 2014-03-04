   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   request-problem-detail and showing-solution                         ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDReqProblemDetailShowSolutionInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((ReqProblemDetailShowSolution Interactions) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail ShowSolution Iteractions) ?goals)
       (createReqProblemDetailShowSolutionInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createReqProblemDetailShowSolutionInteractions ?goals ?groups)
      ()
      ((createReqProblemDetailShowSolutionInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createReqProblemDetailShowSolutionInteractions! ?goals ?groups)
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
      ((createLDReqProblemDetailILEvent ?goals ?groups)
       (createLDShowSolutionILEvent ?goals ?groups)))
   
   ;; fall-back
   (:method (createReqProblemDetailShowSolutionInteractions ?goals ?groups)
      ()
      ((createLDReqProblemDetailShowSolutionInteractionEnvironment ?goals ?groups)
       (createLDReqProblemDetailILEvent ?goals ?groups)
       (createLDShowSolutionILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDReqProblemDetailShowSolutionInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((ReqProblemDetailShowSolution InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (ReqProblemDetail ShowSolution InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
