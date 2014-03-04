   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice group activity           ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Practice GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Practice GroupActivity) ?goals)
       (createPracticeGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createPracticeGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDPracticeWithExercisesUoL ?goals ?groups)))

