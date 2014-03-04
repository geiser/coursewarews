   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling ld learning objects               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (distributeLearningObject () ())
      ()
      ())
    
   (:method (distributeLearningObject (?goal . ?goals) (?group . ?groups))
      ()
      ((createLDLearningObject ?goal ?group)
       (distributeLearningObject ?goals ?groups)))
  
   ;; Method to create one learning object for learners
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDLearningObject ?goal ?learners)
      ()
      ((createLDLearningObject! ?goal ?learners)))
   
   ;; mandatory (auxiliary)
   (:method (createLDLearningObject! (?c ?l) ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?lobjects (?e) 1 inverseIsPartOf
                    ((class LearningObject)
                     (property hasCompetency ?c)))
       (different ?lobjects ())
       (getPropertyValues ?auxs ?lobjects hasKnowledge))
      ((!!addInWorldStateAsAlreadySeen ?auxs ?learners)))
   
   ;; fall-back
   (:method (createLDLearningObject ?goal ?learners)
      ((assign ?id (call GetUUID lo)))
      ((!startLDElement learning-object ((identifier ?id))
                        ((LearningObject) ?id (?goal) (?learners)))
       (createLDTitle (LearningObject) (?goal))
       (createLearningObject ?goal ?learners)
       (!endLDElement learning-object ?id)))
   
   ;;
   (:method (createLearningObject (?c ?l) ?learners)
      ((getPropertyValue ?aux ?c hasKnowledge)
       (getRelateds ?variants (?aux) -1 isVariantOf
                    ((class Auxiliary)
                     (property hasLearningObjective ?c ?l))))
      ((createLDItem ?aux ?learners)
       (distributeItem ?variants ?learners)))
   
