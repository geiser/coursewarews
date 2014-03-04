   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling resume discussion output          ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 
   (:method (createLDResumeDiscussionOutput ?goals ?groups)
      ()
      ((!startLDElement learning-objectives)
       (createResumeDiscussionOutput ?goals ?groups)
       (!endLDElement learning-objectives)))
   
   ;; (TODO) - optional and mandatory
   (:method (createResumeDiscussionOutput ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getPropertyValue ?title ?c hasTitle)
       (buildPropertyQuery ?tmpQuery hasParticipant (call ConcatList ?groups)
                           ((class Output)
                            (class ResumeDiscussion)
                            (property hasTitle (call ConcatText Resume of ?title))
                            (relation isPartOf ?e)))
       (buildPropertyQuery ?query hasGoal ?goals ?tmpQuery)
       (assign ?output (call BuildElement ?query)))
      ((createLDItem ?output)))
   
