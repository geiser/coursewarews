   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert group activity             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDExpertGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Expert GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Expert GroupActivity) ?goals)
       (createExpertGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createExpertGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDExpertSessions ?goals ?groups)))
   
   ;;
   (:method (createLDExpertSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Expert Sessions) ?id ?goals ?groups))
       (createLDTitle (Expert Sessions) ?goals)
       (createExpertSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createExpertSessions ?goals ?groups)
      ()
      ((createLDExpertSession ?goals ?groups)))
   
