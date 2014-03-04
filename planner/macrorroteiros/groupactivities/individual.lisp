   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling individual group activity         ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIndividualGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Individual GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Individual GroupActivity) ?goals)
       (createIndividualGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createIndividualGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDIndividualSessions ?goals ?groups)))
   
   ;;
   (:method (createLDIndividualSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Individual Sessions) ?id ?goals ?groups))
       (createLDTitle (Individual Sessions) ?goals)
       (createIndividualSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createIndividualSessions ?goals ?groups)
      ()
      ((createLDIndividualSession ?goals ?groups)))
   
