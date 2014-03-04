   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to integrate clfp script - clscenario         ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  
   ;; Axiom to gather goal and learners using strategy
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getGoalLearnersFromCLGrouping ?goal ?learners ?e ?strategy ?goals)
       ((getPropertyValue ?cgoal ?e hasCLGroupingGoal ?strategy)
        (exist ?cgoal ?goals)
        (assign ?goal ?cgoal)
        (getPropertyValue ?learners ?e hasCLGroupingLearners ?strategy))
       ;; fall-back
       ((getPropertyValue ?cgoal ?e hasCLGroupingGoal ?strategy)
        (last ?clevel ?cgoal)
        (filterGoalsByLevel ?fgoals ?goals ?clevel)
        (assignIterator ?goal ?fgoals)
        (getPropertyValue ?learners ?e hasCLGroupingLearners ?strategy)))
   
   ;; Method to integrate macro and micro scripts
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDScriptCLScenario ?goals ?groups)
      ()
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; mandatory (create macrorroteiro)
   (:method (createLDScriptCLScenario! ?goals ?groups)
      ()
      ((createLDScriptCLScenario!! ?goals ?groups)))

   ;;
   (:method (createLDScriptCLScenario!! ?goals ?groups)
      ()
      ((createLDScript! ?goals ?groups)))
      ;((getElement ?e ((class CurrentLDElement)))
      ; (getRelateds ?scripts (?e) -1 isPartOf
      ;              ((class Script)))
      ; (length ?nroscripts ?scripts)
      ; (call <= ?nroscripts (call GetDefaultValue hasMacroDepth)))
   
   ;; fall-back
   (:method (createLDScriptCLScenario! ?goals ?groups)
      ()
      ((createLDCLScenario! ?goals ?groups)))
      ;((getElement ?e ((class CurrentLDElement)))
      ; (getPropertyValues ?ts ?e hasCLGroupingTheory)
      ; (different ?ts ())
      ; (call <= 0 (call GetDefaultValue hasMicroDepth)))
   
   ;; fall-back
   (:method (createLDScriptCLScenario ?goals ?groups)
      ()
      ((!!addInWorldState (createLDScriptCLScenario fall-back ?goals ?groups))))
   
   ;; Method to create Script
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
   (:method (createLDScript ?goals ?groups)
      ()
      ((createLDScript! ?goals ?groups)))
   
   ;; fall-back
   (:method (createLDScript ?goals ?groups)
      ()
      ((!!addInWorldState (createLDScript fall-back ?goal ?groups))))
   
   ;; Method to create CLScenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
   (:method (createLDCLScenario ?goals ?groups)
      ()
      ((createLDCLScenario! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDCLScenario! ?goals ?groups)
      anchored-instruction
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue anchored-instruction ?e hasCLGroupingTheory)
       (getGoalLearnersFromCLGrouping ?igoal ?instructors ?e learning-by-diagnosing ?goals)
       (getGoalLearnersFromCLGrouping ?hgoal ?holders ?e learning-by-being-taught-anchor-holder ?goals))
      ((createLDAnchoredInstructionCLScenario (?igoal ?hgoal) (?instructors ?holders)))
      
      cognitive-apprenticeship
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue cognitive-apprenticeship ?e hasCLGroupingTheory)
       (getGoalLearnersFromCLGrouping ?mgoal ?masters ?e learning-by-guiding ?goals)
       (getGoalLearnersFromCLGrouping ?agoal ?apprentices ?e learning-by-apprenticeship ?goals))
      ((createLDCogApprenticeshipCLScenario (?mgoal ?agoal) (?masters ?apprentices)))
      
      cognitive-flexibility
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue cognitive-flexibility ?e hasCLGroupingTheory)
       (getGoalLearnersFromCLGrouping ?pgoal ?panelists ?e learning-by-selfexpression ?goals)
       (getGoalLearnersFromCLGrouping ?agoal ?audiences ?e learning-by-reflection ?goals))
      ((createLDCogFlexibilityCLScenario (?pgoal ?agoal) (?panelists ?audiences)))
      
      distributed-cognition
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue distributed-cognition ?e hasCLGroupingTheory)
       (getGoalLearnersFromCLGrouping ?fgoal ?fulls ?e learning-by-discussion ?goals)
       (divide ?grouping ?fulls 2))
      ((createLDDistCognitionCLScenario (?fgoal ?fgoal) ?grouping))
      
      lpp
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue lpp ?e hasCLGroupingTheory)
       (getGoalLearnersFromCLGrouping ?fgoal ?fulls ?e learning-by-discussion ?goals)
       (getGoalLearnersFromCLGrouping ?pgoal ?peripherals ?e learning-by-practice ?goals))
      ((createLDLPPCLScenario (?fgoal ?pgoal) (?fulls ?peripherals)))
      
      peer-tutoring
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue peer-tutoring ?e hasCLGroupingTheory)
       (getGoalLearnersFromCLGrouping ?ogoal ?tutors ?e learning-by-teaching ?goals)
       (getGoalLearnersFromCLGrouping ?egoal ?tutees ?e learning-by-being-taught-peer-tutee ?goals))
      ((createLDPeerTutoringCLScenario (?ogoal ?egoal) (?tutors ?tutees)))
   )
   
   ;; fall-back (TODO)
   (:method (createLDCLScenario ?goals ?groups)
      ()
      ((!!addInWorldState (createLDCLScenario fall-back ?goals ?groups))))
   
