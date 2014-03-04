   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice-with-exercises script    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPracticeWithExercisesScript ?goals ?groups)
      ((getCompFromGoals ?comp ?goals)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((PracticeWithExercises Script) ?id ?goals ?groups))
       (createLDTitle (PracticeWithExercises Script) ?goals)
       (createPracticeWithExercisesScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   (:method (createPracticeWithExercisesScript ?goals ?groups)
      ()
      ((distributePracticeWithExercisePhase ?goals ?groups)))
   
   ;;
   (:method (distributePracticeWithExercisePhase ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?phases (?e) 1 inverseIsPartOf
                    ((class Phase)
                     (class PracticeWithExercise)))
       (length ?nro ?phases)
       (or (reachedGoals ?goals ?groups)
           (call >= ?nro 2)))
      ()
      ;;fall-back
      ()
      ((createLDPracticeWithExercisePhase ?goals ?groups)
       (distributePracticeWithExercisePhase ?goals ?groups)))
 
