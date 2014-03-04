   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling monitoring                        ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDMonitoringILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Monitoring ILEvent) ?id ?goals ?groups))
       (createLDTitle (Monitoring ILEvent) ?goals)
       (createMonitoringILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createMonitoringILEvent ?goals ?groups)
      ()
      ((createMonitoringILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMonitoringILEvent! ?goals ?groups)
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
      ((createLDMonitoringILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createMonitoringILEvent ?goals ?groups)
      ()
      ((createLDMonitoringILEnvironment ?goals ?groups)
       (createLDMonitoringILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMonitoringILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Monitoring ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (Monitoring ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDMonitoringILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createMonitoringILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createMonitoringILEventDescription ?goals ?groups)
      ()
      ((createMonitoringILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createMonitoringILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class Checking)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class BeingChecked)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createMonitoringILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class Checking)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class BeingChecked)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
