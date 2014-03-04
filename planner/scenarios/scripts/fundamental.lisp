   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling fundamental script                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 
   (:method (createLDFundamentalScript ?goals ?groups)
      ((getCompFromGoals ?comp ?goals)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((Fundamental Script) ?id ?goals ?groups))
       (!!changeFundCompetency ?comp)
       (createLDTitle (Fundamental Script) ?goals)
       (createFundamentalScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling rehearse script                   ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createFundamentalScript ?goals ?groups)
      scenario-rehearse
      ((getCompFromGoals ?comp ?goals)
       (getLevelFromGoals ?level ?goals)
       (getNumericalLevel (?sl ?kl) ?level)
       (call >= ?kl 2)
       (assign ?learners (call ConcatList ?groups))
       (getLearnerCompetencyLevels ?levels ?group ?comp)
       (forall (?ckl) ((exist ?ckl ?levels)) ((call >= ?ckl 1)))
       ;; get previous goals
       (slevel ?sl ?slevel)
       (klevel (call - ?kl 1) ?klevel)
       (getLevel ?plevel (?slevel ?klevel))
       (assign ?pgoals ((?comp ?plevel))))
      ((createLDDevelopPhase ?pgoals ?groups)
       ;(createLDShowConnectionsPhase ?pgoals ?groups)
       ;(createLDPracticePhase ?pgoals ?groups)
       ;(createLDIllustratePhase ?goals ?groups)
       ;(createLDPracticePhase ?goals ?groups)
       (!!addInWorldState (scenario-rehearse pgoals ?pgoals))
       ))
    
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling guided tour script                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; Axiom to filter learners that have low or equal skill level
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterLearnersByCompetencyLowEqualSkillLevelH ?result ?c (?sl ?kl) () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterLearnersByCompetencyLowEqualSkillLevelH ?result ?c (0 ?kl) ?learners ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterLearnersByCompetencyLowEqualSkillLevelH ?result ?c (?sl ?kl) ?learners ?tmpResult)
       ((slevel ?kl ?klevel)
        (klevel ?sl ?slevel)
        (getLevel ?level (?slevel ?klevel))
        (filterLearnersByCompetencyLevel ?select ?learners ?c ?level)
        (remove ?rest ?learners ?select)
        (filterLearnersByCompetencyLowEqualSkillLevelH ?result ?c
                                    ((call - ?sl 1) ?kl) ?rest (?select . ?tmpResult))))
   ;;
   (:- (filterLearnersByCompetencyLowEqualSkillLevel ?result ?c ?nlevel ?learners)
       ((filterLearnersByCompetencyLowEqualSkillLevelH ?result ?c ?nlevel ?learners ())))
   
   ;; Axiom to filter learners that have low or equal knowledge level
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterLearnersByCompetencyLowEqualKnowledgeLevelH ?result ?c (?sl ?kl) () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterLearnersByCompetencyLowEqualKnowledgeLevelH ?result ?c (?sl 0) ?learners ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterLearnersByCompetencyLowEqualKnowledgeLevelH ?result ?c (?sl ?kl) ?learners ?tmpResult)
       ((slevel ?kl ?klevel)
        (klevel ?sl ?slevel)
        (getLevel ?level (?slevel ?klevel))
        (filterLearnersByCompetencyLevel ?select ?learners ?c ?level)
        (remove ?rest ?learners ?select)
        (filterLearnersByCompetencyLowEqualKnowledgeLevelH ?result ?c
                                    (?sl (call - ?kl 1)) ?rest (?select . ?tmpResult))))
   ;;
   (:- (filterLearnersByCompetencyLowEqualKnowledgeLevel ?result ?c ?nlevel ?learners)
       ((filterLearnersByCompetencyLowEqualKnowledgeLevelH ?result ?c ?nlevel ?learners ())))
   
   ;; Axiom to filter learners that have low or equal competency level 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterLearnersByCompetencyLowEqualLevel ?result ?c ?nlevel ?learners)
       ((filterLearnersByCompetencyLowEqualSkillLevel ?sresult ?c ?nlevel ?learners)
        (filterLearnersByCompetencyLowEqualKnowledgeLevel ?kresult ?c ?nlevel ?learners)
        (assign ?result (call ConcatList (?sresult ?kresult)))))
   
   ;; Method to build guided-tour scenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createFundamentalScript ?goals ?groups)
      scenario-guided-tour
      ((getLevelFromGoals ?level ?goals)
       (getNumericalLevel (?sl ?kl) ?level)
       (call = ?kl 4) (call = ?sl 4)
       ;; 
       (getCompFromGoals ?c ?goals)
       (assign ?learners (call ConcatList ?groups))
       (length ?nro ?learners)
       (filterLearnersByCompetencyLowEqualLevel ?result ?c (1 1) ?learners)
       (length ?nrofilters ?result)
       (call > ?nrofilters (call / ?nro 2)))
      (;(createLDIntroductionPhase ?goals ?groups)
       ;(createLDDevelopPhase ?goals ?groups)
       ;(createLDIllustratePhase ?goals ?groups)
       ;(createLDPracticePhase ?goals ?groups)
       ;(createLDConcludePhase ?dgoals ?groups)
       (!!addInWorldState (scenario-guided-tour goals ?goals))
       ))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling discover script                   ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createFundamentalScript ?goals ?groups)
      scenario-discover
      ((getLevelFromGoals ?level ?goals)
       (getNumericalLevel (?sl ?kl) ?level)
       (call = ?kl 3)
       (call >= ?sl 3))
      (;(createLDIntroductionPhase ?goals ?groups)
       ;(createLDDevelopPhase ?goals ?groups)
       ;(createLDPracticePhase ?goals ?groups)
       ;(createLDShowConnectionsPhase ?goals ?groups)
       (!!addInWorldState (scenario-discover goals ?goals))
       ))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to train script                               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 
   ;; Axiom to get goals with increased knowledge levels
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getGoalsWithIncreasedKnowledgesH ?result ?c ?sl -1 ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getGoalsWithIncreasedKnowledgesH ?result ?c ?sl ?kl ?tmpResult)
       ((slevel ?sl ?slevel) (klevel ?kl ?klevel)
        (getLevel ?level (?slevel ?klevel))
        (getGoalsWithIncreasedKnowledgesH ?result ?c ?sl
                              (call - ?kl 1) ((?c ?level) . ?tmpResult))))
   ;;
   (:- (getGoalsWithIncreasedKnowledges ?result (?c ?level))
       ((getNumericalLevel (?sl ?kl) ?level)
        (getGoalsWithIncreasedKnowledgesH ?result ?c ?sl ?kl ())))

   ;; Method to build train scenario
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createFundamentalScript ?goals ?groups)
      scenario-train
      ((first ?goal ?goals)
       (getGoalsWithIncreasedKnowledges ?igoals ?goal))
      (;(createLDDevelopPhase ?goals ?groups)
       ;(distributePracticePhase ?igoals ?groups)
       (!!addInWorldState (scenario-train igoals ?igoals))
       ))
   
   (:method (distributePracticePhase () ?groups)
      ()
      ())
   
   (:method (distributePracticePhase (?goal . ?goals) ?groups)
      ()
      ((createLDPracticePhase (?goal) ?groups)
       (distributePracticePhase ?goals ?groups)))
 
