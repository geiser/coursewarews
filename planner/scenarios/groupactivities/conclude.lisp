   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice group activity           ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDConcludeGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Conclude GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Conclude GroupActivity) ?goals)
       (createConcludeGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createConcludeGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDConcludeWithSummarySession ?goals ?groups)))
   
