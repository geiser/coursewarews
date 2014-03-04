   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-practice              ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
     
   (:method (createLDLearningByPracticeStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningByPractice Strategy) ?id () ?groups))
       (createLDTitle (LearningByPractice Strategy) ?goals)
       (createLearningByPracticeStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningByPracticeStrategy ?goals ?groups)
      ()
      ((createLDPeripheralRole ?goals ?groups)
       (createLDPeripheralInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDPeripheralInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
   
