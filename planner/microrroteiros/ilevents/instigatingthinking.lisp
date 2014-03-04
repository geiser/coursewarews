   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling instigating-thinking              ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDInstThinkingILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((InstThinking ILEvent) ?id ?goals ?groups))
       (createLDTitle (InstThinking ILEvent) ?goals)
       (createInstThinkingILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createInstThinkingILEvent ?goals ?groups)
      ()
      ((createInstThinkingILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createInstThinkingILEvent! ?goals ?groups)
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
      ((createLDInstThinkingILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createInstThinkingILEvent ?goals ?groups)
      ()
      ((createLDInstThinkingILEnvironment ?goals ?groups)
       (createLDInstThinkingILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDInstThinkingILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((InstThinking ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (InstThinking ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDInstThinkingILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createInstThinkingILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createInstThinkingILEventDescription ?goals ?groups)
      ()
      ((createInstThinkingILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createInstThinkingILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class Argumentation)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ReceivingArguments)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createInstThinkingILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class Argumentation)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ReceivingArguments)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
