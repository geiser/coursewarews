   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling knowledge-transmission            ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDKnowlTransmissionILEvent ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((KnowlTransmission ILEvent) ?id ?goals ?groups))
       (createLDTitle (KnowlTransmission ILEvent) ?goals)
       (createKnowlTransmissionILEvent ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   ;;
   (:method (createKnowlTransmissionILEvent ?goals ?groups)
      ()
      ((createKnowlTransmissionILEvent! ?goals ?groups)))
   
   ;; mandatory
   (:method (createKnowlTransmissionILEvent! ?goals ?groups)
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
      ((createLDKnowlTransmissionILEventDescription ?goals ?groups)))
   
   ;; fall-back
   (:method (createKnowlTransmissionILEvent ?goals ?groups)
      ()
      ((createLDKnowlTransmissionILEnvironment ?goals ?groups)
       (createLDKnowlTransmissionILEventDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;; (TODO) - optional and mandatory for ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDKnowlTransmissionILEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((KnowlTransmission ILEnvironment) ?id ?goals ?groups))
       (createLDTitle (KnowlTransmission ILEnvironment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDKnowlTransmissionILEventDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createKnowlTransmissionILEventDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createKnowlTransmissionILEventDescription ?goals ?groups)
      ()
      ((createKnowlTransmissionILEventDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createKnowlTransmissionILEventDescription! ?goals (?instructors ?learners))
      ((getElement ?iactivity ((class Explanation)
                               (class ILEventDescription)))
       (getElement ?lactivity ((class ReceivingExplanation)
                               (class ILEventDescription))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
   ;; fall-back
   (:method (createKnowlTransmissionILEventDescription ?goals (?instructors ?learners))
      ((assign ?iactivity (call BuildElement ((class Explanation)
                                              (class ILEventDescription))))
       (assign ?lactivity (call BuildElement ((class ReceivingExplanation)
                                              (class ILEventDescription)))))
      ((createLDInstructItem ?iactivity ?instructors)
       (createLDLearningItem ?lactivity ?learners)))
   
