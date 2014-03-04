   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-teaching-strategy     ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
        
   (:method (createLDLearningByTeachingStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
            ((LearningByTeaching Strategy) ?id () ?groups))
       (createLDTitle (LearningByTeaching Strategy) ?goals)
       (createLearningByTeachingStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))

   ;;
   (:method (createLearningByTeachingStrategy ?goals ?groups)
      ()
      ((createLDPeerTutorRole ?goals ?groups)
       (createLDPeerTutorInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDPeerTutorInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
  
