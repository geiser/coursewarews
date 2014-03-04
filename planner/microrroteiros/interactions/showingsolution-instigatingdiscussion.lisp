   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   showing-solution and instigating-discussion                         ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDShowSolutionInstDiscussionInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((ShowSolutionInstDiscussion Interactions) ?id ?goals ?groups))
       (createLDTitle (ShowSolution InstDiscussion Iteractions) ?goals)
       (createShowSolutionInstDiscussionInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createShowSolutionInstDiscussionInteractions ?goals ?groups)
      ()
      ((createShowSolutionInstDiscussionInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createShowSolutionInstDiscussionInteractions! ?goals ?groups)
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
      ((createLDShowSolutionILEvent ?goals ?groups)
       (createLDInstDiscussionILEvent ?goals ?groups)))
   
   ;; fall-back
   (:method (createShowSolutionInstDiscussionInteractions ?goals ?groups)
      ()
      ((createLDShowSolutionInstDiscussionInteractionEnvironment ?goals ?groups)
       (createLDShowSolutionILEvent ?goals ?groups)
       (createLDInstDiscussionILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowSolutionInstDiscussionInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((ShowSolutionInstDiscussion InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (ShowSolution InstDiscussion InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
 
