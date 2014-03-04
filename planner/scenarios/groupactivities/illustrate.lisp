   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice group activity           ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIllustrateGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Illustrate GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Illustrate GroupActivity) ?goals)
       (createIllustrateGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createIllustrateGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
