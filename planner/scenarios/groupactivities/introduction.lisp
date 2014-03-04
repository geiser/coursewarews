   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling introduction group activity       ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIntroductionGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Introduction GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Introduction GroupActivity) ?goals)
       (createIntroductionGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createIntroductionGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDIntroductionSessions ?goals ?groups)))
   
   ;;
   (:method (createLDIntroductionSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Introduction Sessions) ?id ?goals ?groups))
       (createLDTitle (Introduction Sessions) ?goals)
       (createIntroductionSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createIntroductionSessions ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nro ?learners)
       (filterByQuery ?notanxious ?learners
                      ((property hasPersonality (very-low low medium))))
       (length ?nronotanxious ?notanxious)
       (call > ?nronotanxious (call / ?nro 2)))
      ((createLDMotivationSession ?goals ?groups)
       (createLDShowProblemSession ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
   (:method (createIntroductionSessions ?goals ?groups)
      ()
      ((createLDShowProblemSession ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
