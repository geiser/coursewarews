   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-apprenticeship        ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDLearningByApprenticeshipStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningByApprenticeship Strategy) ?id () ?groups))
       (createLDTitle (LearningByApprenticeship Strategy) ?goals)
       (createLearningByApprenticeshipStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningByApprenticeshipStrategy ?goals ?groups)
      ()
      ((createLDApprenticeshipRole ?goals ?groups)
       (createLDApprenticeshipInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDApprenticeshipInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
   
