   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-diagnosing            ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDLearningByDiagnosingStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningByDiagnosing Strategy) ?id () ?groups))
       (createLDTitle (LearningByDiagnosing Strategy) ?goals)
       (createLearningByDiagnosingStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningByDiagnosingStrategy ?goals ?groups)
      ()
      ((createLDAnchoredInstructorRole ?goals ?groups)
       (createLDAnchoredInstructorInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDAnchoredInstructorInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
  
