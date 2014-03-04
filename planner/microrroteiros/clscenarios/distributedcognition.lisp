   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling distributed-cognition             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
      
   (:method (createLDDistCognitionCLScenario ?goals ?groups)
      ()
      ((createLDDistCognitionCLScenario! ?goals ?groups)))
   
   ;; mandatory (auxiliary)
   (:method (createLDDistCognitionCLScenario! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((DistCognition CLScenario) ?id ?goals ?groups))
       (!!changeCLGrouping ())
       (createLDTitle (DistCognition CLScenario) ?goals)
       (createDistCognitionCLScenario ?goals ?groups)
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
   
   ;; fall-back (fundamental)
   (:method (createLDDistCognitionCLScenario ((?c ?il) (?c ?ll)) (?instructors ?learners))
      ((hasKnowledgeType ?c Fundamental)
       (or (equivalent (autonomous tuning) ?il)
           (equivalent (autonomous restructuring) ?il)
           (equivalent (associative restructuring) ?il))
       (or (equivalent (autonomous tuning) ?ll)
           (equivalent (autonomous restructuring) ?ll)
           (equivalent (associative restructuring) ?ll))
       ;; get goals
       (getCurrentLearningResourceType ?types)
       (getLearnerPropertyQuery ?tmpq1 ?c ?instructors)
       (buildPropertyQuery ?q1 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?il) . ?tmpq1))
       (getOrBuildReadyAux ?iaux ?q1 ?instructors)
       (getGoalFromAuxiliary ?igoal ?iaux ?c ?il)
       (getLearnerPropertyQuery ?tmpq2 ?c ?learners)
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?ll) . ?tmpq2))
       (getOrBuildReadyAux ?laux ?q2 ?learners)
       (getGoalFromAuxiliary ?lgoal ?laux ?c ?ll)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
               ((DistCognition CLScenario) ?id (?igoal ?lgoal) (?instructors ?learners)))
       (!!changeCLGrouping ())
       (!!changeFundCompetency ?c)
       (createLDTitle (DistCognition CLScenario) (?igoal ?lgoal))
       (createDistCognitionCLScenario (?igoal ?lgoal) (?instructors ?learners))
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
       
   ;; Method to create clscenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createDistCognitionCLScenario ?goals ?groups)
      ()
      ((createDistCognitionCLScenario! ?goals ?groups)))
   
   (:method (createDistCognitionCLScenario! ((?ic ?il) (?lc ?ll)) (?instructors ?learners))
      ((hasKnowledgeType ?ic Auxiliary)
       (or (equivalent (autonomous tuning) ?il)
           (equivalent (autonomous restructuring) ?il)
           (equivalent (associative restructuring) ?il))
       (hasKnowledgeType ?lc Auxiliary)
       (or (equivalent (autonomous tuning) ?ll)
           (equivalent (autonomous restructuring) ?ll)
           (equivalent (associative restructuring) ?ll)))
      ((createLDDistCognitionPhase ((?ic ?il) (?lc ?ll)) (?instructors ?learners))))
  
   (:method (createDistCognitionCLScenario ?goals ?groups)
      ()
      ((!!addInWorldState (createDistCognitionCLScenario fall-back ?goals ?groups))))
   
