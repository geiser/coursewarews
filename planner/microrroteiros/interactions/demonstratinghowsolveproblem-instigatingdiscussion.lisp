   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling                                   ;;
   ;;   demonstrating-how-solve-problem and instigating-discussion          ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDemonHowSolveProblemInstDiscussionInteractions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type selection))
           ((DemonHowSolveProblemInstDiscussion Interactions) ?id ?goals ?groups))
       (createLDTitle (DemonHowSolveProblem ProblemDetail Iteractions) ?goals)
       (createDemonHowSolveProblemInstDiscussionInteractions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   ;;
   (:method (createDemonHowSolveProblemInstDiscussionInteractions ?goals ?groups)
      ()
      ((createDemonHowSolveProblemInstDiscussionInteractions! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDemonHowSolveProblemInstDiscussionInteractions! ?goals ?groups)
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
       (createLDInstDiscussionILEvent ?goals ?groups)))

   ;; fall-back
   (:method (createDemonHowSolveProblemInstDiscussionInteractions ?goals ?groups)
      ()
      ((createLDDemonHowSolveProblemInstDiscussionInteractionEnvironment ?goals ?groups)
       (createLDDemonHowSolveProblemILEvent ?goals ?groups)
       (createLDInstDiscussionILEvent ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDemonHowSolveProblemInstDiscussionInteractionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
            ((DemonHowSolveProblemInstDiscussion InteractionEnvironment) ?id ?goals ?groups))
       (createLDTitle (DemonHowSolveProblem InstDiscussion InteractionEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
