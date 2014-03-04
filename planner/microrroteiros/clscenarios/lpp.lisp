   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling lpp                               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDLPPCLScenario ?goals ?groups)
      ()
      ((createLDLPPCLScenario! ?goals ?groups)))
   
   ;; mandatory (auxiliary)
   (:method (createLDLPPCLScenario! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((LPP CLScenario) ?id ?goals ?groups))
       (!!changeCLGrouping ())
       (createLDTitle (LPP CLScenario) ?goals)
       (createLPPCLScenario ?goals ?groups)
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
   
   ;; fall-back (fundamental)
   (:method (createLDLPPCLScenario ((?c ?fl) (?c ?pl)) (?fulls ?peripherals))
      ((hasKnowledgeType ?c Fundamental)
       (or (equivalent (autonomous tuning) ?fl)
           (equivalent (autonomous restructuring) ?fl)
           (equivalent (associative restructuring) ?fl))
       (or (equivalent (rough any) ?pl)
           (equivalent (associative any) ?pl))
       ;; get goals
       (getCurrentLearningResourceType ?types)
       (getLearnerPropertyQuery ?tmpq1 ?c ?fulls)
       (buildPropertyQuery ?q1 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?fl) . ?tmpq1))
       (getOrBuildReadyAux ?faux ?q1 ?fulls)
       (getGoalFromAuxiliary ?fgoal ?faux ?c ?fl)
       (getLearnerPropertyQuery ?tmpq2 ?c ?peripherals)
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?pl) . ?tmpq2))
       (getOrBuildReadyAux ?paux ?q2 ?peripherals)
       (getGoalFromAuxiliary ?pgoal ?paux ?c ?pl)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
               ((LPP CLScenario) ?id (?fgoal ?pgoal) (?fulls ?peripherals)))
       (!!changeCLGrouping ())
       (!!changeFundCompetency ?c)
       (createLDTitle (LPP CLScenario) (?fgoal ?pgoal))
       (createLPPCLScenario (?fgoal ?pgoal) (?fulls ?peripherals))
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
    
   ;; Method to create clscenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLPPCLScenario ?goals ?groups)
      ()
      ((createLPPCLScenario! ?goals ?groups)))
   
   (:method (createLPPCLScenario! ((?fc ?fl) (?pc ?pl)) (?fulls ?peripherals))
      ((hasKnowledgeType ?fc Auxiliary)
       (or (equivalent (autonomous tuning) ?fl)
           (equivalent (autonomous restructuring) ?fl)
           (equivalent (associative restructuring) ?fl))
       (hasKnowledgeType ?pc Auxiliary)
       (equivalent (associative any) ?pl)
       ;; get fund competency
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getCurrentLearningResourceType ?types)
       ;; get goals
       (getLearnerPropertyQuery ?tmpq2 ?c ?peripherals)
       (getPropertyValue ?kl ?pl hasKnowledgeLevel)
       (getLevel ?pls1kl (rough ?kl))
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?pls1kl) . ?tmpq2))
       (getOrBuildReadyAux ?pauxs1kl ?q2 ?peripherals)
       (getGoalFromAuxiliary ?pgoals1kl ?pauxs1kl ?c ?pls1kl))
      ((createLDLPPPhase ((?fc ?fl) ?pgoals1kl) (?fulls ?peripherals))
       (createLDLPPPhase ((?fc ?fl) (?pc ?pl)) (?fulls ?peripherals))))
   
   (:method (createLPPCLScenario! ((?fc ?fl) (?pc ?pl)) (?fulls ?peripherals))
      ((hasKnowledgeType ?fc Auxiliary)
       (or (equivalent (autonomous tuning) ?fl)
           (equivalent (autonomous restructuring) ?fl)
           (equivalent (associative restructuring) ?fl))
       (hasKnowledgeType ?pc Auxiliary)
       (equivalent (rough any) ?pl)
       ;; get fund competency
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getCurrentLearningResourceType ?types)
       ;; get goals
       (getLearnerPropertyQuery ?tmpq2 ?c ?peripherals)
       (getPropertyValue ?kl ?pl hasKnowledgeLevel)
       (getLevel ?pls3kl (associative ?kl))
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                     ((class Auxiliary)
                      (property hasLearningObjective ?c ?pls3kl) . ?tmpq2))
       (getOrBuildReadyAux ?pauxs3kl ?q2 ?peripherals)
       (getGoalFromAuxiliary ?pgoals3kl ?pauxs3kl ?c ?pls3kl))
      ((createLDLPPPhase ((?fc ?fl) (?pc ?pl)) (?fulls ?peripherals))
       (createLDLPPPhase ((?fc ?fl) ?pgoals3kl) (?fulls ?peripherals))))
   
   ;; fall-back
   (:method (createLPPCLScenario ?goals ?groups)
      ()
      ((!!addInWorldState (createLPPCLScenario fall-back ?goals ?groups))))
   
