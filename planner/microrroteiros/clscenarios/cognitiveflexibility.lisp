   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling cognitive-flexibility             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    
   (:method (createLDCogFlexibilityCLScenario ?goals ?groups)
      ()
      ((createLDCogFlexibilityCLScenario! ?goals ?groups)))
   
   ;; mandatory (auxiliary)
   (:method (createLDCogFlexibilityCLScenario! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((CogFlexibility CLScenario) ?id ?goals ?groups))
       (!!changeCLGrouping ())
       (createLDTitle (CogFlexibility CLScenario) ?goals)
       (createCogFlexibilityCLScenario ?goals ?groups)
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
   
   ;; fall-back (fundamental)
   (:method (createLDCogFlexibilityCLScenario ((?c ?pl) (?c ?al)) (?panelists ?audiences))
      ((hasKnowledgeType ?c Fundamental)
       (equivalent (associative any) ?pl)
       (equivalent (any restructuring) ?al)
       ;; get goals
       (getCurrentLearningResourceType ?types)
       (getLearnerPropertyQuery ?tmpq1 ?c ?panelists)
       (buildPropertyQuery ?q1 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?pl) . ?tmpq1))
       (getOrBuildReadyAux ?paux ?q1 ?panelists)
       (getGoalFromAuxiliary ?pgoal ?paux ?c ?pl)
       (getLearnerPropertyQuery ?tmpq2 ?c ?audiences)
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?al) . ?tmpq2))
       (getOrBuildReadyAux ?aaux ?q2 ?audiences)
       (getGoalFromAuxiliary ?agoal ?aaux ?c ?al)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
              ((CogFlexibility CLScenario) ?id (?pgoal ?agoal) (?panelists ?audiences)))
       (!!changeCLGrouping ())
       (!!changeFundCompetency ?c)
       (createLDTitle (CogFlexibility CLScenario) (?pgoal ?agoal))
       (createCogFlexibilityCLScenario (?pgoal ?agoal) (?panelists ?audiences))
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
       
   ;; Method to create clscenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  
   (:method (createCogFlexibilityCLScenario ?goals ?groups)
      ()
      ((createCogFlexibilityCLScenario! ?goals ?groups)))
   
   (:method (createCogFlexibilityCLScenario! ((?pc ?pl) (?ac ?al)) (?panelists ?audiences))
      ((hasKnowledgeType ?pc Auxiliary)
       (equivalent (associative any) ?pl)
       (hasKnowledgeType ?ac Auxiliary)
       (equivalent (any restructuring) ?al))
      ((createLDCogFlexibilityPhase ((?pc ?pl) (?ac ?al)) (?panelists ?audiences))))
   
   ;; fall-back
   (:method (createLDCogFlexibilityCLScenario ?goals ?groups)
      ()
      ((!!addInWorldState (createLDCogFlexibilityCLScenario fall-back ?goals ?groups))))
   
