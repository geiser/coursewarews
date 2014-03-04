   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling cognitive-apprenticeship          ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDCogApprenticeshipCLScenario ?goals ?groups)
      ()
      ((createLDCogApprenticeshipCLScenario! ?goals ?groups)))
   
   ;; mandatory (auxiliary)
   (:method (createLDCogApprenticeshipCLScenario! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((CogApprenticeship CLScenario) ?id ?goals ?groups))
       (!!changeCLGrouping ())
       (createLDTitle (CogApprenticeship CLScenario) ?goals)
       (createCogApprenticeshipCLScenario ?goals ?groups)
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
   
   ;; fall-back (fundamental)
   (:method (createLDCogApprenticeshipCLScenario ((?c ?ml) (?c ?al)) (?masters ?apprentices))
      ((hasKnowledgeType ?c Fundamental)
       (equivalent (autonomous any) ?ml)
       (or (equivalent (rough any) ?al)
           (equivalent (explanatory any) ?al)
           (equivalent (associative any) ?al))
       ;; get goals
       (getCurrentLearningResourceType ?types)
       (getLearnerPropertyQuery ?tmpq1 ?c ?masters)
       (buildPropertyQuery ?q1 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?ml) . ?tmpq1))
       (getOrBuildReadyAux ?maux ?q1 ?masters)
       (getGoalFromAuxiliary ?mgoal ?maux ?c ?ml)
       (getLearnerPropertyQuery ?tmpq2 ?c ?apprentices)
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?al) . ?tmpq2))
       (getOrBuildReadyAux ?aaux ?q2 ?apprentices)
       (getGoalFromAuxiliary ?agoal ?aaux ?c ?al)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
               ((CogApprenticeship CLScenario) ?id (?mgoal ?agoal) (?masters ?apprentices)))
       (!!changeCLGrouping ())
       (!!changeFundCompetency ?c)
       (createLDTitle (CogApprenticeship CLScenario) (?mgoal ?agoal))
       (createCogApprenticeshipCLScenario (?mgoal ?agoal) (?masters ?apprentices))
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
    
   ;; Method to create clscenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createCogApprenticeshipCLScenario ?goals ?groups)
      ()
      ((createCogApprenticeshipCLScenario! ?goals ?groups)))
   
   (:method (createCogApprenticeshipCLScenario! ((?mc ?ml) (?ac ?al)) (?masters ?apprentices))
      ((hasKnowledgeType ?mc Auxiliary)
       (equivalent (autonomous any) ?ml)
       (hasKnowledgeType ?ac Auxiliary)
       (or (equivalent (rough any) ?al)
           (equivalent (explanatory any) ?al))
       ;; get fund competency
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getCurrentLearningResourceType ?types)
       ;; get goals
       (getLearnerPropertyQuery ?tmpq2 ?c ?apprentices)
       (getPropertyValue ?kl ?al hasKnowledgeLevel)
       (getLevel ?als3kl (associative ?kl))
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?als3kl) . ?tmpq2))
       (getOrBuildReadyAux ?aauxs3kl ?q2 ?apprentices)
       (getGoalFromAuxiliary ?agoals3kl ?aauxs3kl ?c ?als3kl))
      ((createLDCogApprenticeshipPhase ((?mc ?ml) (?ac ?al)) (?masters ?apprentices))
       (createLDCogApprenticeshipPhase ((?mc ?ml) ?agoals3kl) (?masters ?apprentices))))
   
   (:method (createCogApprenticeshipCLScenario! ((?mc ?ml) (?ac ?al)) (?masters ?apprentices))
      ((hasKnowledgeType ?mc Auxiliary)
       (equivalent (autonomous any) ?ml)
       (hasKnowledgeType ?ac Auxiliary)
       (equivalent (associative any) ?al)
       ;; get fund competency
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?c ?e hasFundCompetency)
       (getCurrentLearningResourceType ?types)
       ;; get goals
       (getLearnerPropertyQuery ?tmpq2 ?c ?apprentices)
       (getPropertyValue ?kl ?al hasKnowledgeLevel)
       (getLevel ?als2kl (explanatory ?kl))
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?als2kl) . ?tmpq2))
       (getOrBuildReadyAux ?aauxs2kl ?q2 ?apprentices)
       (getGoalFromAuxiliary ?agoals2kl ?aauxs3kl ?c ?als2kl))
      ((createLDCogApprenticeshipPhase ((?mc ?ml) ?agoals2kl) (?masters ?apprentices))
       (createLDCogApprenticeshipPhase ((?mc ?ml) (?ac ?al)) (?masters ?apprentices))))
   
   ;; fall-back
   (:method (createCogApprenticeshipCLScenario ?goals ?groups)
      ()
      ((!!addInWorldState (createCogApprenticeshipCLScenario fall-back ?goals ?groups))))
   
