   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling resume discussion output          ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 
   (:method (createLDSolutionOutput ?goals ?groups)
      ()
      ((!startLDElement learning-objectives)
       (createSolutionOutput ?goals ?groups)
       (!endLDElement learning-objectives)))
   
   ;; (TODO) - optional and mandatory
   (:method (createSolutionOutput ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getPropertyValue ?title ?c hasTitle)
       (buildPropertyQuery ?tmpQuery hasParticipant (call ConcatList ?groups)
                        ((class Output)
                         (class Solution)
                         (property hasTitle (call ConcatText Solution for ?title))
                         (relation isPartOf ?e)))
       (buildPropertyQuery ?query hasGoal ?goals ?tmpQuery)
       (assign ?output (call BuildElement ?query)))
      ((createLDItem ?output)))
   
