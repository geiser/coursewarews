   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling peer-tutoring                     ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPeerTutoringCLScenario ?goals ?groups)
      ()
      ((createLDPeerTutoringCLScenario! ?goals ?groups)))
   
   ;; mandatory (auxiliary)
   (:method (createLDPeerTutoringCLScenario! ?goals ?groups)
      ((assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((PeerTutoring CLScenario) ?id ?goals ?groups))
       (!!changeCLGrouping ())
       (createLDTitle (PeerTutoring CLScenario) ?goals)
       (createPeerTutoringCLScenario ?goals ?groups)
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
   
   ;; fall-back (fundamental)
   (:method (createLDPeerTutoringCLScenario ((?c ?ol) (?c ?el)) (?tutors ?tutees))
      ((hasKnowledgeType ?c Fundamental)
       (equivalent (any tuning) ?ol)
       (equivalent (any accretion) ?el)
       ;; get goals
       (getCurrentLearningResourceType ?types)
       (getLearnerPropertyQuery ?tmpq1 ?c ?tutors)
       (buildPropertyQuery ?q1 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?ol) . ?tmpq1))
       (getOrBuildReadyAux ?oaux ?q1 ?tutors)
       (getGoalFromAuxiliary ?ogoal ?oaux ?c ?ol)
       (getLearnerPropertyQuery ?tmpq2 ?c ?tutees)
       (buildPropertyQuery ?q2 hasLearningResourceType ?types
                           ((class Auxiliary)
                            (property hasLearningObjective ?c ?el) . ?tmpq2))
       (getOrBuildReadyAux ?eaux ?q2 ?tutees)
       (getGoalFromAuxiliary ?egoal ?eaux ?c ?el)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
              ((PeerTutoring CLScenario) ?id (?ogoal ?egoal) (?tutors ?tutees)))
       (!!changeCLGrouping ())
       (!!changeFundCompetency ?c)
       (createLDTitle (PeerTutoring CLScenario) (?ogoal ?egoal))
       (createPeerTutoringCLScenario (?ogoal ?egoal) (?tutors ?tutees))
       (!endLDElement play ?id)
       (createLDILEventConditions ?groups)
       ))
      
   ;; Method to create clscenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createPeerTutoringCLScenario ?goals ?groups)
      ()
      ((createPeerTutoringCLScenario! ?goals ?groups)))
 
   (:method (createPeerTutoringCLScenario! ((?oc ?ol) (?ec ?el)) (?tutors ?tutees))
      ((hasKnowledgeType ?oc Auxiliary)
       (equivalent (any tuning) ?ol)
       (hasKnowledgeType ?ec Auxiliary)
       (equivalent (any accretion) ?el))
      ((createLDPeerTutoringPhase ((?oc ?ol) (?ec ?el)) (?tutors ?tutees))))
   
   ;; fall-back
   (:method (createPeerTutoringCLScenario ?goals ?groups)
      ()
      ((!!addInWorldState (createPeerTutoringCLScenario fall-back ?goals ?groups))))
   
