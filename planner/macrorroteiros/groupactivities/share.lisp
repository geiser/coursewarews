   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw-group activity             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDShareGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Share GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Share GroupActivity) ?goals)
       (createShareGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createShareGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDShareSessions ?goals ?groups)))
   
   ;;
   (:method (createLDShareSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Share Sessions) ?id ?goals ?groups))
       (createLDTitle (Share Sessions) ?goals)
       (createShareSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createShareSessions ?goals ?groups)
      ()
      ((createLDDiscussionSession ?goals ?groups)
       (createLDShareSession ?goals ?groups)))
   
