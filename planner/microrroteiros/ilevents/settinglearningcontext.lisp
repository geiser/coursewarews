   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling setting-learning-context          ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDSetLearningContextILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((SetLearningContext ILEvent) ?id ?goals ?groups))
       (createLDTitle (SetLearningContext ILEvent) ?goals)
       (createSetLearningContextILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createSetLearningContextILEvent ?goals ?groups)
      ()
      ((createSetLearningContextILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createSetLearningContextILEvent! ?goals ?groups)
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
      ((createLDSetLearningContextILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createSetLearningContextILEvent ?goals ?groups)
      ()
      ((createLDSetLearningContextILEnvironment ?goals ?groups)
       (createLDSetLearningContextILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDSetLearningContextILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((SetLearningContext ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (SetLearningContext ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDSetLearningContextILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createSetLearningContextILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createSetLearningContextILEventDescription ?goals ?groups)
      ()
      ((createSetLearningContextILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createSetLearningContextILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class GivingInformation)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ReceivingInformation)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createSetLearningContextILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class GivingInformation)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ReceivingInformation)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))

