   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-reflection            ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        
   (:method (createLDLearningByReflectionStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningByReflection Strategy) ?id () ?groups))
       (createLDTitle (LearningByReflection Strategy) ?goals)
       (createLearningByReflectionStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningByReflectionStrategy ?goals ?groups)
      ()
      ((createLDAudienceRole ?goals ?groups)
       (createLDAudienceInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDAudienceInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
  
