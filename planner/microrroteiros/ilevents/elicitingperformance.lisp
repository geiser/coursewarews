   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling eliciting-performance             ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDElicitPerformanceILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((ElicitPerformance ILEvent) ?id ?goals ?groups))
       (createLDTitle (ElicitPerformance ILEvent) ?goals)
       (createElicitPerformanceILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createElicitPerformanceILEvent ?goals ?groups)
      ()
      ((createElicitPerformanceILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createElicitPerformanceILEvent! ?goals ?groups)
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
      ((createLDElicitPerformanceILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createElicitPerformanceILEvent ?goals ?groups)
      ()
      ((createLDElicitPerformanceILEnvironment ?goals ?groups)
       (createLDElicitPerformanceILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDElicitPerformanceILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((ElicitPerformance ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (ElicitPerformance ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDElicitPerformanceILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createElicitPerformanceILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createElicitPerformanceILEventDescription ?goals ?groups)
      ()
      ((createElicitPerformanceILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createElicitPerformanceILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class GivingPerformance)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ReceivingPerformance)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createElicitPerformanceILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class GivingPerformance)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ReceivingPerformance)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
    
