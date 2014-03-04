   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-selfexpression        ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        
   (:method (createLDLearningBySelfexpressionStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningBySelfexpression Strategy) ?id () ?groups))
       (createLDTitle (LearningBySelfexpression Strategy) ?goals)
       (createLearningBySelfexpressionStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningBySelfexpressionStrategy ?goals ?groups)
      ()
      ((createLDPanelistRole ?goals ?groups)
       (createLDPanelistInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDPanelistInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
  
