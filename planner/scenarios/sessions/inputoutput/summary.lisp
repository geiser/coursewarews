   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling summary output                    ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 
   (:method (createLDSummaryOutput ?goals ?groups)
      ()
      ((!startLDElement learning-objectives)
       (createSummaryOutput ?goals ?groups)
       (!endLDElement learning-objectives)))
   
   ;; (TODO) - optional and mandatory
   (:method (createSummaryOutput ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getPropertyValue ?title ?c hasTitle)
       (buildPropertyQuery ?tmpQuery hasParticipant (call ConcatList ?groups)
                           ((class Output)
                            (class Summary)
                            (property hasTitle (call ConcatText Summary of ?title))
                            (relation isPartOf ?e)))
       (buildPropertyQuery ?query hasGoal ?goals ?tmpQuery)
       (assign ?output (call BuildElement ?query)))
      ((createLDItem ?output)))

