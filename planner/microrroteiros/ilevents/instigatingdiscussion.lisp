   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling instigating-discussion            ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDInstDiscussionILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((InstDiscussion ILEvent) ?id ?goals ?groups))
       (createLDTitle (InstDiscussion ILEvent) ?goals)
       (createInstDiscussionILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createInstDiscussionILEvent ?goals ?groups)
      ()
      ((createInstDiscussionILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createInstDiscussionILEvent! ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getRelateds ?interactions (?e) -1 isPartOf
                    ((class Interactions)
                     (property hasCurrentUoL ?u)))
       (buildPropertyQuery ?tmpQuery hasGoal ?goals
                           ((class InteractionEnvironment)
                            (property hasCurrentUoL ?u)))
       (buildPropertyQuery ?query hasParticipant ?learners ?tmpQuery)
       (getRelateds ?environments ?interactions 1 inverseIsPartOf ?query)
       (different ?environments ()))
      ((createLDInstDiscussionILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createInstDiscussionILEvent ?goals ?groups)
      ()
      ((createLDInstDiscussionILEnvironment ?goals ?groups)
       (createLDInstDiscussionILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDInstDiscussionILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((InstDiscussion ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (InstDiscussion ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDInstDiscussionILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createInstDiscussionILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createInstDiscussionILEventDescription ?goals ?groups)
      ()
      ((createInstDiscussionILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createInstDiscussionILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class RequestOpinion)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ExposingOpinion)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createInstDiscussionILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class RequestOpinion)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ExposingOpinion)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
