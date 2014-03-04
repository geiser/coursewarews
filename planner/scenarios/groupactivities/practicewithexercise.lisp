   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Methods used to modeling practice-with-exercise group activity        ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeWithExerciseGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((PracticeWithExercise GroupActivity) ?id ?goals ?groups))
       (createLDTitle (PracticeWithExercise GroupActivity) ?goals)
       (createPracticeWithExerciseGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createPracticeWithExerciseGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDPracticeWithExerciseSession ?goals ?groups)))

