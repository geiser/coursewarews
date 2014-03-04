   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling learning-by-discussion            ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDLearningByDiscussionInstructionalStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((LearningByDiscussion Instructional Strategy) ?id () ?groups))
       (createLDTitle (LearningByDiscussion Instructional Strategy) ?goals)
       (createLearningByDiscussionStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))
  
   ;;
   (:method (createLearningByDiscussionStrategy ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Instructional ?e))
      ((createLDFullParticipantInstructorRole ?goals ?groups)
       (createLDFullParticipantInteractions ?goals ?groups)))
   
   ;; Method to create learning-by-discussion learning
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDLearningByDiscussionLearningStrategy ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((LearningByDiscussion Learning Strategy) ?id () ?groups))
       (createLDTitle (LearningByDiscussion Learning Strategy) ?goals)
       (createLearningByDiscussionStrategy ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   ;;
   (:method (createLearningByDiscussionStrategy ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Learning ?e))
      ((createLDFullParticipantLearnerRole ?goals ?groups)
       (createLDFullParticipantInteractions ?goals ?groups)))
   
   ;; (TODO) - optional and mandatory
   (:method (createLDFullParticipantInteractions ?goals ?groups)
      ((getElement ?as ((class CurrentLDInteractions))))
      ((!startLDElement activity-structure-ref ((ref ?as)))
       (!endLDElement activity-structure-ref)))
  
