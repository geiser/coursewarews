   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling notifying-how-learner-is          ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDNotifyHowLearnerIsILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((NotifyHowLearnerIs ILEvent) ?id ?goals ?groups))
       (createLDTitle (NotifyHowLearnerIs ILEvent) ?goals)
       (createNotifyHowLearnerIsILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createNotifyHowLearnerIsILEvent ?goals ?groups)
      ()
      ((createNotifyHowLearnerIsILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createNotifyHowLearnerIsILEvent! ?goals ?groups)
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
      ((createLDNotifyHowLearnerIsILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createNotifyHowLearnerIsILEvent ?goals ?groups)
      ()
      ((createLDNotifyHowLearnerIsILEnvironment ?goals ?groups)
       (createLDNotifyHowLearnerIsILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDNotifyHowLearnerIsILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((NotifyHowLearnerIs ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (NotifyHowLearnerIs ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDNotifyHowLearnerIsILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createNotifyHowLearnerIsILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createNotifyHowLearnerIsILEventDescription ?goals ?groups)
      ()
      ((createNotifyHowLearnerIsILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createNotifyHowLearnerIsILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class GivingInformation)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ReceivingInformation)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createNotifyHowLearnerIsILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class GivingInformation)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ReceivingInformation)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
