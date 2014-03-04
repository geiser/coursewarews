   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling resume discussion output          ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 
   (:method (createLDSimulationOutput ?goals ?groups)
      ()
      ((!startLDElement learning-objectives)
       (createSimulationOutput ?goals ?groups)
       (!endLDElement learning-objectives)))
   
   ;; (TODO) - optional and mandatory
   (:method (createSimulationOutput ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getPropertyValue ?title ?c hasTitle)
       (buildPropertyQuery ?tmpQuery hasParticipant (call ConcatList ?groups)
                        ((class Output)
                         (class Simulation)
                         (property hasTitle (call ConcatText Result of simulation in ?title))
                         (relation isPartOf ?e)))
       (buildPropertyQuery ?query hasGoal ?goals ?tmpQuery)
       (assign ?output (call BuildElement ?query)))
      ((createLDItem ?output)))
   
