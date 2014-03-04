   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert group activity             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDiscussionGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Discussion GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Discussion GroupActivity) ?goals)
       (createDiscussionGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createDiscussionGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDDiscussionSessions ?goals ?groups)))
   
   ;;
   (:method (createLDDiscussionSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Discussion Sessions) ?id ?goals ?groups))
       (createLDTitle (Discussion Sessions) ?goals)
       (createDiscussionSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createDiscussionSessions ?goals ?groups)
      ()
      ((createLDDiscussionSession ?goals ?groups)))
   
