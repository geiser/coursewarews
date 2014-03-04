   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling develop group activity            ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDevelopGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Develop GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Develop GroupActivity) ?goals)
       (createDevelopGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createDevelopGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (!!addInWorldState (createLDDevelopSession ?goals ?groups))
       ))
 


