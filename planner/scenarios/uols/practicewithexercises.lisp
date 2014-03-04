   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice-with-exercises uol       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPracticeWithExercisesUoL ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class PracticeWithExercises))
                           (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
            ((PracticeWithExercises UoL) ?id ?goals ?skills ?attits ?groups))
       (!!changeLearningResourceType (exercise))
       (createLDTitle (PracticeWithExercises UoL) ?goals)
       (!startLDElement method)
       (createPracticeWithExercisesUoL ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))

   (:method (createPracticeWithExercisesUoL ?goals ?groups)
      ()
      ((createLDPracticeWithExercisesScript ?goals ?groups)))
 
