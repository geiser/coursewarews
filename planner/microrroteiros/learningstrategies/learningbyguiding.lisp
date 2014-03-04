   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-guiding               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDLearningByGuidingStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningByGuiding Strategy) ?id () ?groups))
       (createLDTitle (LearningByGuiding Strategy) ?goals)
       (createLearningByGuidingStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningByGuidingStrategy ?goals ?groups)
      ()
      ((createLDMasterRole ?goals ?groups)
       (createLDMasterInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDMasterInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
  
