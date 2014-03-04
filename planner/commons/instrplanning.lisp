   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axioms to gather instructional planning informations                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   ;; Axiom to compare pair (skill-level knowledge-level) with level
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (equivalent (?sl any) ?level)
       ((getElements ?levels ((class Level)
                              (property hasSkillLevel ?sl)))
        (exist ?level ?levels)))
   
   (:- (equivalent (any ?kl) ?level)
       ((getElements ?levels ((class Level)
                              (property hasKnowledgeLevel ?kl)))
        (exist ?level ?levels)))
   
   (:- (equivalent (?sl ?kl) ?level)
       ((getElements ?levels ((class Level)
                              (property hasSkillLevel ?sl)
                              (property hasKnowledgeLevel ?kl)))
        (exist ?level ?levels)))
   
   ;; Axiom to gather a level from (skill-level knowledge-level)
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getLevel s0k0 (nothing nothing)) ())
   (:- (getLevel s0k1 (nothing accretion)) ())
   (:- (getLevel s0k2 (nothing tuning)) ())
   (:- (getLevel s0k3 (nothing restructuring)) ())
   
   (:- (getLevel s1k0 (rough nothing)) ())
   (:- (getLevel s1k1 (rough accretion)) ())
   (:- (getLevel s1k2 (rough tuning)) ())
   (:- (getLevel s1k3 (rough restructuring)) ())
 
   (:- (getLevel s2k0 (explanatory nothing)) ())
   (:- (getLevel s2k1 (explanatory accretion)) ())
   (:- (getLevel s2k2 (explanatory tuning)) ())
   (:- (getLevel s2k3 (explanatory restructuring)) ())

   (:- (getLevel s3k0 (associative nothing)) ())
   (:- (getLevel s3k1 (associative accretion)) ())
   (:- (getLevel s3k2 (associative tuning)) ())
   (:- (getLevel s3k3 (associative restructuring)) ())

   (:- (getLevel s4k0 (autonomous nothing)) ())
   (:- (getLevel s4k1 (autonomous accretion)) ())
   (:- (getLevel s4k2 (autonomous tuning)) ())
   (:- (getLevel s4k3 (autonomous restructuring)) ())

   ;; Axiom to gather numerical leve from level
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:- (slevel 0 nothing) ())
   (:- (slevel 1 rough) ())
   (:- (slevel 2 explanatory) ())
   (:- (slevel 3 associative) ())
   (:- (slevel 4 autonomous) ())
   (:- (slevel 5 autonomous) ())
   
   (:- (klevel 0 nothing) ())
   (:- (klevel 1 accretion) ())
   (:- (klevel 2 tuning) ())
   (:- (klevel 3 restructuring) ())
   (:- (klevel 4 restructuring) ())
   
   (:- (getNumericalLevel (?sl ?kl) ?level)
       ((getLevel ?level (?slevel ?klevel))
        (slevel ?sl ?slevel)
        (klevel ?kl ?klevel)))
   
   ;; Axiom to bind the type of knowledge/competency 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (hasKnowledgeType ?comp ?type)
       ((getPropertyValue ?knowl ?comp hasKnowledge)
        (getTypes ?types ?knowl)
        (exist ?type ?types)))
   
   ;; Axiom to gather elements without relation
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getElementsWithoutRelationH ?result () ?relation ?with ?without)
       ((assign ?result ?without)))
   
   (:- (getElementsWithoutRelationH ?result (?e . ?elements) ?relation ?with ?without)
       ;; inverseIsPartOf, inverseIsRequiredBy, inverseIsVariantOf
       ((inverseOf ?invRelation ?relation)
        (getType ?type ?e)
        (same ?type Competency)
        (or ((getPropertyValue ?knowl ?e hasKnowledge)
             (getPropertyValues ?knowls ?elements hasKnowledge)
             (getPropertyValues ?withKnowls ?with hasKnowledge)
             (getPropertyValues ?withoutKnowls ?without hasKnowledge)
             (getRelated ?r1 ?knowl ?invRelation)
             (or (exist ?r1 ?knowls)
                 (exist ?r1 ?withKnowls)
                 (exist ?r1 ?withoutKnowls)))
            ;;
            ((getPropertyValue ?skill ?e hasSkill)
             (getPropertyValues ?skills ?elements hasSkill)
             (getPropertyValues ?withSkills ?with hasSkill)
             (getPropertyValues ?withoutSkills ?without hasSkill)
             (getRelated ?r2 ?skill ?invRelation)
             (or (exist ?r2 ?skills)
                 (exist ?r2 ?withSkills)
                 (exist ?r2 ?withoutSkills))))
        (getElementsWithoutRelationH ?result ?elements ?relation (?e . ?with) ?without))
       ;;
       ((getType ?type ?e)
        (same ?type Competency)
        (or ((getPropertyValue ?knowl ?e hasKnowledge)
             (getPropertyValues ?knowls ?elements hasKnowledge)
             (getPropertyValues ?withKnowls ?with hasKnowledge)
             (getPropertyValues ?withoutKnowls ?without hasKnowledge)
             (getRelated ?r1 ?knowl ?relation)
             (or (exist ?r1 ?knowls)
                 (exist ?r1 ?withKnowls)
                 (exist ?r1 ?withoutKnowls)))
            ;;
            ((getPropertyValue ?skill ?e hasSkill)
             (getPropertyValues ?skills ?elements hasSkill)
             (getPropertyValues ?withSkills ?with hasSkill)
             (getPropertyValues ?withoutSkills ?without hasSkill)
             (getRelated ?r2 ?skill ?relation)
             (or (exist ?r2 ?skills)
                 (exist ?r2 ?withSkills)
                 (exist ?r2 ?withoutSkills))))
        (getElementsWithoutRelationH ?result ?elements ?relation (?e . ?with) ?without))
       ;; not is competency
       ;; inverseIsPartOf, inverseIsRequiredBy, inverseIsVariantOf
       ((inverseOf ?invRelation ?relation)
        (getRelated ?related ?e ?invRelation)
        (or (exist ?related ?elements)
            (exist ?related ?with)
            (exist ?related ?without))
        (getElementsWithoutRelationH ?result ?elements ?relation (?e . ?with) ?without))
       ;;
       ((getRelated ?related ?e ?relation)
        (or (exist ?related ?elements)
            (exist ?related ?with)
            (exist ?related ?without))
        (getElementsWithoutRelationH ?result ?elements ?relation (?e . ?with) ?without))
       ;; fall-back
       ((getElementsWithoutRelationH ?result ?elements ?relation ?with (?e . ?without))))
   
   (:- (getElementsWithoutRelation ?result ?elements ?relation)
       ((getElementsWithoutRelationH ?result ?elements ?relation () ())))
   
   ;; Axiom to sorted elements by relation
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (sortByH ?result () ?relation ?tmpResult)
       ((assign ?result (call Reverse (call ConcatList ?tmpResult)))))
   
   (:- (sortByH ?result ?elements ?relation ?tmpResult)
       ((getElementsWithoutRelation ?without ?elements ?relation)
        (remove ?rest ?elements ?without)
        (sortByH ?result ?rest ?relation (?without . ?tmpResult))))
   
   (:- (sortBy ?result ?elements ?relation)
       ((sortByH ?result ?elements ?relation ())))
   
   ;(:- (sortBy ?result ?result ?relation) ())   
   
   ;; Axiom to sort elements from not seen to seen
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (alreadySeenByLearners ?e (?l . ?learners))
       ((getPropertyValue ?seen ?l hasAlreadySeen ?e)
        (same ?seen true))
       ((alreadySeenByLearners ?e ?learners)))
   
   ;;
   (:- (sortByAlreadySeenH ?result () ?seen ?notseen ?learners)
       ((assign ?result (call ConcatList (?notseen ?seen)))))
   
   (:- (sortByAlreadySeenH ?result (?e . ?elements) ?seen ?notseen ?learners)
       ((alreadySeenByLearners ?e ?learners)
        (sortByAlreadySeenH ?result ?elements (?e . ?seen) ?notseen ?learners))
       ((sortByAlreadySeenH ?result ?elements ?seen (?e . ?notseen) ?learners)))
   
   (:- (sortByAlreadySeen ?result ?elements ?learners)
       ((sortByAlreadySeenH ?result ?elements () () ?learners)))

   ;(:- (sortByAlreadySeen ?result ?result ?learners) ())
      
   ;; Axiom to build properties list of query
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (buildPropertyQueryH ?result ?name () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (buildPropertyQueryH ?result ?name (?v . ?values) ?tmpResult)
       ((buildPropertyQueryH ?result ?name ?values
                             ((property ?name ?v) . ?tmpResult))))
   
   (:- (buildPropertyQuery ?result ?name ?values ?query)
       ((buildPropertyQueryH ?result ?name ?values ?query)))
   
   ;;
   (:- (buildPropertyQueryH ?result ?name ?dest () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (buildPropertyQueryH ?result ?name ?dest (?v . ?values) ?tmpResult)
       ((buildPropertyQueryH ?result ?name ?dest ?values
                             ((property ?name ?dest ?v) . ?tmpResult))))
   
   (:- (buildPropertyQuery ?result ?name ?dest ?values ?query)
       ((buildPropertyQueryH ?result ?name ?dest ?values ?query)))
   
   ;; Axiom to build relations list of query
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (buildRelationQueryH ?result ?name () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (buildRelationQueryH ?result ?name (?v . ?values) ?tmpResult)
       ((buildRelationQueryH ?result ?name ?values
                             ((relation ?name ?v) . ?tmpResult))))
   
   (:- (buildRelationQuery ?result ?name ?values ?query)
       ((buildRelationQueryH ?result ?name ?values ?query)))
   
   ;; Axiom to gather competency level for learners
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;   
   (:- (getLearnerFundCompetencyLevel ?result ?learner ?comp)
       ((getPropertyValue ?result ?learner hasCompetencyLevel ?comp))
       ((assign ?result s0k0)))
   
   (:- (getLearnerAuxCompetencyLevel ?result ?learner ?comp)
       ((getPropertyValue ?result ?learner hasCompetencyLevel ?comp))
       ((getElement ?e ((class CurrentLDElement)))
        (getPropertyValue ?c ?e hasFundCompetency)
        (getLearnerFundCompetencyLevel ?result ?learner ?c)))
   
   (:- (getLearnerCompetencyLevel ?result ?learner ?comp)
       ((hasKnowledgeType ?comp Auxiliary)
        (getLearnerAuxCompetencyLevel ?result ?learner ?comp))
       ((getLearnerFundCompetencyLevel ?result ?learner ?comp)))
   
   ;;
   (:- (getLearnerCompetencyLevelsH ?result () ?comp ?tmpResult)
       ((removeDuplicate ?result ?tmpResult)))
   
   (:- (getLearnerCompetencyLevelsH ?result (?l . ?learners) ?comp ?tmpResult)
       ((getLearnerCompetencyLevel ?level ?l ?comp)
        (getLearnerCompetencyLevelsH ?result ?learners ?comp (?level . ?tmpResult))))
   
   (:- (getLearnerCompetencyLevels ?result ?learners ?comp)
       ((getLearnerCompetencyLevelsH ?result ?learners ?comp ())))
   
   ;; Axiom to filter learners by competency levels
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterLearnersByCompetencyLevelH ?result () ?c (?sl ?kl) ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterLearnersByCompetencyLevelH ?result (?l . ?learners) ?c (?sl ?kl) ?tmpResult)
       ((getLearnerCompetencyLevel ?clevel ?l ?c)
        (getNumericalLevel (?csl ?ckl) ?clevel)
        (call >= ?csl ?sl) (call >= ?ckl ?kl)
        (filterLearnersByCompetencyLevelH ?result ?learners ?c (?sl ?kl) (?l . ?tmpResult)))
       ;; fall-back
       ((filterLearnersByCompetencyLevelH ?result ?learners ?c (?sl ?kl) ?tmpResult)))
   
   (:- (filterLearnersByCompetencyLevel ?result ?learners ?c ?level)
       ((getNumericalLevel (?sl ?kl) ?level)
        (filterLearnersByCompetencyLevelH ?result ?learners ?c (?sl ?kl) ())))
   
   ;; Axiom to evaluate ready of auxiliary
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (reachedCompetencyLevels () ?learners) ())
   
   (:- (reachedCompetencyLevels ((?c ?l) . ?pres) ?learners)
       ((filterLearnersByCompetencyLevel ?flearners ?learners ?c ?l)
        (length ?nroLearners ?learners)
        (length ?nroFiltereds ?flearners)
        (call >= ?nroFiltereds (call / ?nroLearners 2))
        (reachedCompetencyLevels ?pres ?learners)))
   
   ;;
   (:- (readyAux ?result (?aux . ?auxs) ?learners)
       ;(:first
       ((getPropertyValues ?prerequisite ?aux hasPrerequisite)
        (reachedCompetencyLevels ?prerequisite ?learners)
        (assign ?result ?aux))
       ;)
       ;; fall-back
       ((readyAux ?result ?auxs ?learners)))
   
   (:- (getReadyAux ?result ?query ?learners)
       ((getElements ?unsortAuxs ?query)
        (sortByAlreadySeen ?auxs ?unsortAuxs ?learners)
        (readyAux ?result ?auxs ?learners)
        ))
   
   ;; Axiom to get one auxiliar or build auxiliary
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getOrBuildReadyAux ?aux ?query ?learners)
       ((getReadyAux ?aux ?query ?learners))
       ;; fall-back
       ((assign ?aux (call BuildElement
                ((property hasTitle temporarily-auxiliary) . ?query)))))
   
   ;; Axiom to get properties used in query
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getLearnerPropertyQuery ?result ?learners ?difficults)
       ;; common
       ((first ?learner ?learners)
        (getPropertyValue ?context ?learner hasEducationalLevel)
        (forall (?l) ((exist ?l ?learners))
                ((getPropertyValues ?contexts ?l hasEducationalLevel)
                 (exist ?context ?contexts)))
        (assign ?result ((property hasContext ?context)
                         (property hasDifficult ?difficults))))
       ;; not-common
       ((assign ?result ((property hasDifficult ?difficults)))))
   
   (:- (getLearnerPropertyQuery ?result ?learners ?comp ?property)
       ;; high
       ((length ?nro ?learners)
        (filterByQuery ?highlearners ?learners
                       ((property ?property ?comp (very-high high))))
        (length ?nrohighlearners ?highlearners)
        (call > ?nrohighlearners (call / ?nro 2))
        (getLearnerPropertyQuery ?result ?learners (very-difficult difficult)))
       ;; medium
       ((length ?nro ?learners)
        (filterByQuery ?mediumlearners ?learners
                       ((property ?property ?comp (medium low))))
        (length ?nromediumlearners ?mediumlearners)
        (call > ?nromediumlearners (call / ?nro 2))
        (getLearnerPropertyQuery ?result ?learners (medium easy)))
       ;; low motivated
       ((getLearnerPropertyQuery ?result ?learners (easy very-easy))))
   
   ;; Axiom to gather a list of competences from goals
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getCompsFromGoalsH ?result () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getCompsFromGoalsH ?result (?goal . ?goals) ?tmpResult)
       ((first ?comp ?goal)
        (not (exist ?comp ?tmpResult))
        (getCompsFromGoalsH ?result ?goals (?comp . ?tmpResult)))
       ;; fall-back
       ((getCompsFromGoalsH ?result ?goals ?tmpResult)))
   
   (:- (getCompsFromGoals ?result ?goals)
       ((getCompsFromGoalsH ?result ?goals ())))
   
   ;;
   (:- (getCompFromGoals ?comp ((?comp ?level) . ?goals)) ())
   
   ;; Axiom to gather a list of levels from goals
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getLevelsFromGoalsH ?result () ?tmpResult)
       ((assign ?result (call Reverse ?tmpResult))))
   
   (:- (getLevelsFromGoalsH ?result (?goal . ?goals) ?tmpResult)
       ((last ?level ?goal)
        (getLevelsFromGoalsH ?result ?goals (?level . ?tmpResult))))
   
   (:- (getLevelsFromGoals ?result ?goals)
       ((getLevelsFromGoalsH ?result ?goals ())))
   
   ;;
   (:- (getLevelFromGoals ?result ?goals)
       ((getLevelsFromGoals ?levels ?goals)
        (assignIterator ?result ?levels)))
   
   ;; Axiom to gather goal by auxiliary from competency and level
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getGoalFromAuxiliary ?goal ?aux ?comp ?level)
       ((getPropertyValue ?skill ?comp hasSkill)
        (getElement ?compAux ((class Competency)
                              (class ForAuxiliary)
                              (property hasSkill ?skill)
                              (property hasKnowledge ?aux)))
        (assign ?goal (?compAux ?level)))
       ;; fall-back
       ((getPropertyValue ?skill ?comp hasSkill)
        (getPropertyValue ?stitle ?skill hasTitle)
        (getPropertyValue ?ktitle ?aux hasTitle)
        (assign ?compAux (call BuildElement ((class Competency)
                                             (class ForAuxiliary)
                                             (property hasTitle (call ConcatText ?stitle ?ktitle))
                                             (property hasSkill ?skill)
                                             (property hasKnowledge ?aux))))
        (assign ?goal (?compAux ?level))))
   
   ;;
   (:- (getGoalsFromAuxiliaryHH ?goals ?aux ?comp () ?tmpResult)
       ((assign ?goals (call Reverse ?tmpResult))))
   
   (:- (getGoalsFromAuxiliaryHH ?goals ?aux ?comp (?l . ?levels) ?tmpResult)
       ((getGoalFromAuxiliary ?goal ?aux ?comp ?l)
        (getGoalsFromAuxiliaryHH ?goals ?aux ?comp ?levels (?goal . ?tmpResult))))
   
   (:- (getGoalsFromAuxiliary ?goals ?aux ?comp ?levels)
       ((getGoalsFromAuxiliaryHH ?goals ?aux ?comp ?levels ())))
   
   ;;
   (:- (getGoalsFromAuxiliariesH ?result () ?comp ?tmpResult)
       ((assign ?result (call Reverse ?tmpResult))))
   
   (:- (getGoalsFromAuxiliariesH ?result (?aux . ?auxs) ?comp ?tmpResult)
       ((getPropertyValue ?skill ?comp hasSkill)
        (getElement ?auxComp ((class Competency)
                              (class ForAuxiliary)
                              (property hasSkill ?skill)
                              (property hasKnowledge ?aux)))
        (getPropertyValue ?auxLevel ?aux hasLearningObjective ?comp)
        (getGoalsFromAuxiliariesH ?result ?auxs ?comp ((?auxComp ?auxLevel) . ?tmpResult))))
   
   (:- (getGoalsFromAuxiliaries ?result ?auxs ?comp)
       ((getGoalsFromAuxiliariesH ?result ?auxs ?comp ())))
    
   ;; Axiom to gather individual goals
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
   (:- (getIndGoalsHH ?result ?goal () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getIndGoalsHH ?result (?c ?gstage) (?l . ?learners) ?tmpResult)
       ((getLearnerCompetencyLevel ?istage ?l ?c)
        (assign ?ig (call GetIndGoal ?istage ?gstage))
        (getIndGoalsHH ?result (?c ?gstage) ?learners ((?l (?c ?ig)) . ?tmpResult))))
   
   ;;
   (:- (getIndGoalsH ?result () () ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getIndGoalsH ?result (?goal . ?goals) (?group . ?groups) ?tmpResult)
       ((getIndGoalsHH ?indGoals ?goal ?group ())
        (getIndGoalsH ?result ?goals ?groups (?indGoals . ?tmpResult))))
   
   ;;
   (:- (getIndGoals () () ?groups) ())
   
   (:- (getIndGoals ?result ?goals ?groups)
       ((getIndGoalsH ?result ?goals ?groups ())))
   
   ;; Axiom to gather individual goals filter by competences
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getIndGoalsByCompHH ?result ?goal () ?comps ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getIndGoalsByCompHH ?result (?c ?gstage) (?l . ?learners) ?comps ?tmpResult)
       ((exist ?c ?comps)
        (getLearnerCompetencyLevel ?istage ?l ?c)
        (assign ?ig (call GetIndGoal ?istage ?gstage))
        (getIndGoalsByCompHH ?result (?c ?gstage) ?learners ?comps ((?l (?c ?ig)) . ?tmpResult)))
       ;; fall-back
       ((getIndGoalsByCompHH ?result (?c ?gstage) ?learners ?comps ?tmpResult)))
   
   ;;
   (:- (getIndGoalsByCompH ?result () () ?comps ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getIndGoalsByCompH ?result (?goal . ?goals) (?group . ?groups) ?comps ?tmpResult)
       ((getIndGoalsByCompHH ?indGoals ?goal ?group ?comps ())
        (getIndGoalsByCompH ?result ?goals ?groups ?comps (?indGoals . ?tmpResult))))
   
   ;;
   (:- (getIndGoals () () ?groups ?comps) ())
   
   (:- (getIndGoals ?result ?goals ?groups ?comps)
       ((getIndGoalsByCompH ?result ?goals ?groups ?comps ())))
   
   ;; Axiom to gather individual goals filter by competences and learners
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getIndGoalsByCompLearnersHH ?result ?goal () ?comps ?learners ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getIndGoalsByCompLearnersHH ?result (?c ?gstage)  (?l . ?learners) ?comps ?group ?tmpResult)
       ((exist ?c ?comps)
        (exist ?l ?group)
        (getLearnerCompetencyLevel ?istage ?l ?c)
        (assign ?ig (call GetIndGoal ?istage ?gstage))
        (getIndGoalsByCompLearnersHH ?result (?c ?gstage) ?learners ?comps ?group ((?l (?c ?ig)) . ?tmpResult)))
       ;; fall-back
       ((getIndGoalsByCompLearnersHH ?result (?c ?gstage) ?learners ?comps ?group ?tmpResult)))
    
   ;;
   (:- (getIndGoalsByCompLearnersH ?result () () ?comps ?learners ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getIndGoalsByCompLearnersH ?result (?goal . ?goals)
                                   (?group . ?groups) ?comps ?learners ?tmpResult)
       ((getIndGoalsByCompLearnersHH ?indGoals ?goal ?group ?comps ?learners ())
        (getIndGoalsByCompLearnersH ?result ?goals
                                 ?groups ?comps ?learners (?indGoals . ?tmpResult))))
   
   ;;
   (:- (getIndGoals () () ?groups ?comps ?learners) ())
   
   (:- (getIndGoals ?result ?goals ?groups ?comps ?learners)
       ((getIndGoalsByCompLearnersH ?result ?goals ?groups ?comps ?learners ())))
 
   ;; Axiom to filter goals by competency
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterGoalsByCompH ?result () ?c ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterGoalsByCompH ?result (?goal . ?goals) ?c ?tmpResult)
       ((first ?c ?goal)
        (filterGoalsByCompH ?result ?goals ?c (?goal . ?tmpResult)))
       ;; fall-back
       ((filterGoalsByCompH ?result ?goals ?c ?tmpResult)))
   
   (:- (filterGoalsByComp ?result ?goals ?c)
       ((filterGoalsByCompH ?result ?goals ?c ())))

   ;; Axiom to filter goal by group 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterGoalByGroup ?goal (?goal . ?goals) (?group . ?groups) ?group) ())
   
   (:- (filterGoalByGroup ?result (?goal . ?goals) (?group . ?groups) ?learners)
       ((filterGoalByGroup ?result ?goals ?groups ?learners))
       ;; fall-back
       ((forall (?l) ((exist ?l ?learners)) ((exist ?l ?group)))
        (assign ?result ?goal)))
    
   ;; Axiom to filter goals by level
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterGoalsByLevelH ?result () ?level ?tmpResult)
       ((assign ?result (call Reverse ?tmpResult))))
   
   (:- (filterGoalsByLevelH ?result (?goal . ?goals) ?level ?tmpResult)
       ((last ?level ?goal)
        (filterGoalsByLevelH ?result ?goals ?level (?goal . ?tmpResult)))
       ;; fall-back
       ((filterGoalsByLevelH ?result ?goals ?level ?tmpResult)))
   
   (:- (filterGoalsByLevel ?result ?goals ?level)
       ((filterGoalsByLevelH ?result ?goals ?level ())))
   
   ;; Axiom to filter groups by competency
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterGroupsByCompH ?result () () ?c ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterGroupsByCompH ?result (?goal . ?goals) (?group . ?groups) ?c ?tmpResult)
       ((first ?c ?goal)
        (filterGroupsByCompH ?result ?goals ?groups ?c (?group . ?tmpResult)))
       ;; fall-back
       ((filterGroupsByCompH ?result ?goals ?groups ?c ?tmpResult)))
   
   (:- (filterGroupsByComp ?result ?goals ?groups ?c)
       ((filterGroupsByCompH ?result ?goals ?groups ?c ())))
  
   ;; Axiom to gather learning resource types
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getCurrentLearningResourceType ?types)
       ((getElement ?e ((class CurrentLDElement)))
        (getPropertyValues ?types ?e hasLearningResourceType))
       ;; fall-back
       ((assign ?types (call GetDefaultValue hasLearningResourceType))))
   
   ;; Axiom to evaluate is groups reached goals 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
   (:- (reachedGoals () ()) ())
   
   (:- (reachedGoals ((?comp ?level) . ?goals) (?group . ?groups))
       ((getNumericalLevel (?gsl ?gkl) ?level)
        (getLearnerCompetencyLevels ?levels ?group ?comp)
        (forall (?sl ?kl ?cl) ((exist ?cl ?levels)
                               (getNumericalLevel (?sl ?kl) ?cl))
                ((call >= ?sl ?gsl)
                 (call >= ?kl ?gkl)))
        (reachedGoals ?goals ?groups)))
   
   ;; Axiom to gather goals from clgrouping
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getGoalsFromCLStrategiesH ?result () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getGoalsFromCLStrategiesH ?result ((?s ?g ?P) . ?sgPs) ?tmpResult)
       ((getGoalsFromCLStrategiesH ?result ?sgPs (?g . ?tmpResult))))
   
   (:- (getGoalsFromCLStrategies ?result ?sgPs)
       ((getGoalsFromCLStrategiesH ?result ?sgPs ())))
   
   ;;
   (:- (getGoalsFromCLGrouping ?result (?t ?sgPs))
       ((getGoalsFromCLStrategies ?result ?sgPs)))
   
   ;; Axiom to gather groups from clgrouping
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getGroupsFromCLStrategiesH ?result () ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getGroupsFromCLStrategiesH ?result ((?s ?g ?P) . ?sgPs) ?tmpResult)
       ((getGroupsFromCLStrategiesH ?result ?sgPs (?P . ?tmpResult))))
   
   (:- (getGroupsFromCLStrategies ?result ?sgPs)
       ((getGroupsFromCLStrategiesH ?result ?sgPs ())))
  
   ;;
   (:- (getGroupsFromCLGrouping ?result (?t ?sgPs))
       ((getGroupsFromCLStrategies ?result ?sgPs)))
 
   ;; Axiom to eliminate datas
   (:- (getEducationalLevelHH ?result hasEducationalLevel hasMotivation hasAnxiety)
       ((assignIterator ?result (training higher-education school other
                                 very-high high very-difficult difficult
                                 medium low medium easy))))
   
