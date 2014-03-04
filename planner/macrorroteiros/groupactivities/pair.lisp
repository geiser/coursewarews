   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert group activity             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPairGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Pair GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Pair GroupActivity) ?goals)
       (createPairGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createPairGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDPairSessions ?goals ?groups)))
   
   ;;
   (:method (createLDPairSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Pair Sessions) ?id ?goals ?groups))
       (createLDTitle (Pair Sessions) ?goals)
       (createPairSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createPairSessions ?goals ?groups)
      ()
      ((createLDPairSession ?goals ?groups)))
   
