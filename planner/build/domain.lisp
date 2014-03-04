(defdomain domain(
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axioms and operators (domain-independend)                             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; General axioms
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (same ?x ?x) ())
   (:- (different ?x ?y) ((not (same ?x ?y))))
   
   (:- (first ?head (?head . ?tail))())
   
   (:- (last ?last (?last)) ())
   (:- (last ?last (?element . ?list)) ((last ?last ?list)))
   
   (:- (rest ?tail (?head . ?tail))())
   
   (:- (length ?length ?list) ((assign ?length (call Length ?list))))   
   
   (:- (exist ?element (?element . ?rest)) ())
   (:- (exist ?element (?head . ?rest)) ((exist ?element ?rest)))
   
   (:- (assignIterator ?var (?head . ?tail)) ((assign ?var ?head)))
   (:- (assignIterator ?var (?head . ?tail)) ((assignIterator ?var ?tail)))
  
   (:- (remove ?result ?list1 ?list2)
       ((assign ?result (call Remove ?list1 ?list2))))
   
   (:- (removeDuplicateH ?result () ?tmpResult)
       ((assign ?result (call Reverse ?tmpResult))))
   
   (:- (removeDuplicateH ?result (?l . ?rest) ?tmpResult)
       ((exist ?l ?tmpResult)
        (removeDuplicateH ?result ?rest ?tmpResult))
       ((removeDuplicateH ?result ?rest (?l . ?tmpResult))))
   
   (:- (removeDuplicate ?result ?list)
       ((removeDuplicateH ?result ?list ())))
   
   (:- (divide ?result ?list ?nro)
       ((assign ?result (call DivideList ?list ?nro))))
   
   (:- (duplicate ?result ?list) ((assign ?result (?list ?list))))
   
   (:- (duplicate (?list) ?list 1) ())
   
   (:- (duplicate ?result ?list ?nro)
       ((duplicate ?tmpResult ?list (call - ?nro 1))
        (assign ?result (?list . ?tmpResult))))

   ;; Get nro elements from list
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;   
   (:- (sublistH ?result ?elements 0 ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (sublistH ?result () ?nro ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (sublistH ?result (?e . ?elements) ?nro ?tmpResult)
       ((sublistH ?result ?elements (call - ?nro 1) (?e . ?tmpResult))))
   
   (:- (sublist ?result ?list ?nro)
       ((sublistH ?result ?list ?nro ())))
   
   ;; Operators for update atoms in current state
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!addInWorldState ?atom)
      ()
      ()
      (?atom))
   
   (:operator (!!removeFromWorldState ?atom)
      ()
      (?atom)
      ())
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axioms to gather learner and domain models informations               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  
   ;; Axioms to gather inverse of values
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (inverseOf isPartOf inverseIsPartOf) ())
   (:- (inverseOf isRequiredBy inverseIsRequiredBy) ())
   (:- (inverseOf isVariantOf inverseIsVariantOf) ())
   
   ;; Axiom to evaluate is simbol is a goal (isGoal - internal)
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (isGoal (?comp s0k0)) ()) (:- (isGoal (?comp s0k1)) ())
   (:- (isGoal (?comp s0k2)) ()) (:- (isGoal (?comp s0k3)) ())
   (:- (isGoal (?comp s1k0)) ()) (:- (isGoal (?comp s1k1)) ())
   (:- (isGoal (?comp s1k2)) ()) (:- (isGoal (?comp s1k3)) ())
   (:- (isGoal (?comp s2k0)) ()) (:- (isGoal (?comp s2k1)) ())
   (:- (isGoal (?comp s2k2)) ()) (:- (isGoal (?comp s2k3)) ())
   (:- (isGoal (?comp s3k0)) ()) (:- (isGoal (?comp s3k1)) ())
   (:- (isGoal (?comp s3k2)) ()) (:- (isGoal (?comp s3k3)) ())  
   (:- (isGoal (?comp s4k0)) ()) (:- (isGoal (?comp s4k1)) ())
   (:- (isGoal (?comp s4k2)) ()) (:- (isGoal (?comp s4k3)) ())
   
   ;; Axiom to filter element from current state by class
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterElement ?e ()) ())
   
   (:- (filterElement ?e ((class ?types) . ?query))
       (:first ((assignIterator ?t ?types)
                (class ?t ?e)
                (filterElement ?e ?query)))
       ;; fall-back
       ((assignIterator ?t (call GetType ?e))
        (exist ?t ?types)
        (filterElement ?e ?query)))
   
   (:- (filterElement ?e ((class ?t) . ?query))
       (:first ((class ?t ?e)
                (filterElement ?e ?query)))
       ;; fall-back
       ((assign ?types (call GetType ?e))
        (exist ?t ?types)
        (filterElement ?e ?query)))
   
   ;; Axiom to filter element from current state by relation
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterElement ?e ((relation ?relation ?dests) . ?query))
       (:first ((assignIterator ?d ?dests)
                (relation ?e ?relation ?d)
                (filterElement ?e ?query)))
       ;; fall-back
       ((assignIterator ?d (call GetRelated ?e ?relation))
        (exist ?d ?dests)
        (filterElement ?e ?query)))

   (:- (filterElement ?e ((relation ?relation ?d) . ?query))
       (:first ((relation ?e ?relation ?d)
                (filterElement ?e ?query)))
       ;; fall-back
       ((assign ?dests (call GetRelated ?e ?relation))
        (exist ?d ?dests)
        (filterElement ?e ?query)))
   
   ;; Axiom to filter element from current state by property
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterElement ?e ((property ?property ?destValues) . ?query))
       (:first ((not (isGoal ?destValues))
                (assignIterator ?dv ?destValues)
                (property ?e ?property ?dv)
                (filterElement ?e ?query)))
       ;; fall-back
       ((not (isGoal ?destValues))
        (assignIterator ?dv (call GetPropertyValue ?e ?property))
        (exist ?dv ?destValues)
        (filterElement ?e ?query)))
   
   (:- (filterElement ?e ((property ?property ?dv) . ?query))
       (:first ((property ?e ?relation ?dv)
                (filterElement ?e ?query)))
       ;;fall-back
       ((assign ?destValues (call GetPropertyValue ?e ?property))
        (exist ?dv ?destValues)
        (filterElement ?e ?query)))
   
   ;; Axiom to filter element from current state by property with dest
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterElement ?e ((property ?property ?dest ?values) . ?query))
       (:first ((not (isGoal ?values))
                (assignIterator ?v ?values)
                (property ?e ?property ?v)
                (filterElement ?e ?query)))
       ;;fall-back
       ((not (isGoal ?values))
        (assignIterator ?v (call GetPropertyValue ?e ?property ?dest))
        (exist ?v ?values)
        (filterElement ?e ?query)))
   
   (:- (filterElement ?e ((property ?property ?dest ?v) . ?query))
       (:first ((property ?e ?property (?dest ?v))
                (filterElement ?e ?query)))
       ;; fall-back
       ((assign ?values (call GetPropertyValue ?e ?property ?dest))
        (exist ?v ?values)
        (filterElement ?e ?query)))
   
   ;; Axiom to filter elements by query
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterByQueryH ?result () ?query ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterByQueryH ?result (?e . ?elements) ?query ?tmpResult)
       ((filterElement ?e ?query)
        (filterByQueryH ?result ?elements ?query (?e . ?tmpResult)))
       ;; fall-back
       ((filterByQueryH ?result ?elements ?query ?tmpResult)))
   
   ;;
   (:- (filterByQuery () () ?query) ())
   
   (:- (filterByQuery ?result ?elements ?query)
       ((filterByQueryH ?result ?elements ?query ())))
   
   ;; Axiom to gather elements by types
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getElementsByTypeFromCurrentStateH ?result () ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getElementsByTypeFromCurrentStateH ?result (?t . ?types) ?tmpResult)
       ((getElementsByTypeFromCurrentState ?elements ?t)
        (getElementsByTypeFromCurrentStateH ?result ?types (?elements . ?tmpResult))))
   
   ;;
   (:- (getElementsByTypeFromCurrentStateH ?result ?t ?tmpResult)
       ((forall (?e) ((class ?t ?e))
                ((exist ?e ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((class ?t ?e)
          (not (exist ?e ?tmpResult))
          (getElementsByTypeFromCurrentStateH ?result ?t (?e . ?tmpResult)))))
   
   (:- (getElementsByTypeFromCurrentState ?result ?t)
       ((getElementsByTypeFromCurrentStateH ?result ?t ())))
   
   ;; Axiom to gather elements by property and/or values
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getElementsByPropertyFromCurrentStateH ?result ?property () ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getElementsByPropertyFromCurrentStateH ?result ?property (?dv . ?destValues) ?tmpResult)
       ((getElementsByPropertyFromCurrentState ?elements ?property ?dv)
        (getElementsByPropertyFromCurrentStateH ?result ?property ?destValues (?elements . ?tmpResult))))
   
   ;;
   (:- (getElementsByPropertyFromCurrentStateH ?result ?property ?dv ?tmpResult)
       ((forall (?e) ((property ?e ?property ?dv))
                ((exist ?e ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((property ?e ?property ?dv)
          (not (exist ?e ?tmpResult))
          (getElementsByPropertyFromCurrentStateH ?result ?property ?dv (?e . ?tmpResult)))))
   
   (:- (getElementsByPropertyFromCurrentState ?result ?property ?dv)
       ((getElementsByPropertyFromCurrentStateH ?result ?property ?dv ())))
   
   ;; Axiom to gather elements by property, destination and values
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getElementsByPropertyDestValueFromCurrentStateH ?result ?property ?d () ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getElementsByPropertyDestValueFromCurrentStateH ?result ?property ?d (?v . ?values) ?tmpResult)
       ((getElementsByPropertyDestValueFromCurrentState ?elements ?property ?d ?v)
        (getElementsByPropertyDestValueFromCurrentStateH ?result ?property ?d ?values (?elements . ?tmpResult))))
   
   ;;
   (:- (getElementsByPropertyDestValueFromCurrentStateH ?result ?property ?d ?v ?tmpResult)
       ((forall (?e) ((property ?e ?property (?d ?v)))
                ((exist ?e ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((property ?e ?property (?d ?v))
          (not (exist ?e ?tmpResult))
          (getElementsByPropertyDestValueFromCurrentStateH ?result ?property ?d ?v (?e . ?tmpResult)))))
   
   (:- (getElementsByPropertyDestValueFromCurrentState ?result ?property ?d ?v)
       ((getElementsByPropertyDestValueFromCurrentStateH ?result ?property ?d ?v ())))
   
   ;; Axiom to gather elements by relation and destinations
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getElementsByRelationFromCurrentStateH ?result ?relation () ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getElementsByRelationFromCurrentStateH ?result ?relation (?d . ?dests) ?tmpResult)
       ((getElementsByRelationFromCurrentState ?elements ?relation ?d)
        (getElementsByRelationFromCurrentStateH ?result ?relation ?dests (?elements . ?tmpResult))))
   
   ;;
   (:- (getElementsByRelationFromCurrentStateH ?result ?relation ?d ?tmpResult)
       ((forall (?e) ((relation ?e ?relation ?d))
                ((exist ?e ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((relation ?e ?relation ?d)
          (not (exist ?e ?tmpResult))
          (getElementsByRelationFromCurrentStateH ?result ?relation ?d (?e . ?tmpResult)))))
   
   (:- (getElementsByInvRelationFromCurrentStateH ?result ?relation ?d ?tmpResult)
       ((forall (?e) ((relation ?d ?relation ?e))
                ((exist ?e ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((relation ?d ?relation ?e)
          (not (exist ?e ?tmpResult))
          (getElementsByInvRelationFromCurrentStateH ?result ?relation ?d (?e . ?tmpResult)))))
   
   (:- (getElementsByRelationFromCurrentState ?result ?relation ?d)
       ((inverseOf ?invRelation ?relation)
        (getElementsByInvRelationFromCurrentStateH ?result ?invRelation ?d ()))
       ((getElementsByRelationFromCurrentStateH ?result ?relation ?d ())))
    
   ;; Axiom to gather elements by query
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getElementsFromCurrentStateH ?result (class ?types))
       ((getElementsByTypeFromCurrentState ?result ?types)))
   
   (:- (getElementsFromCurrentStateH ?result (property ?property ?dvs))
       ((getElementsByPropertyFromCurrentState ?result ?property ?dvs)))
   
   (:- (getElementsFromCurrentStateH ?result (property ?property ?d ?values))
       ((getElementsByPropertyDestValueFromCurrentState ?result ?property ?d ?values)))
   
   (:- (getElementsFromCurrentStateH ?result (relation ?relation ?dests))
       ((getElementsByRelationFromCurrentState ?result ?relation ?dests)))
   
   ;;
   (:- (getElementsFromCurrentState ?result (?cond . ?query))
       ((getElementsFromCurrentStateH ?tmpResult ?cond)
        (filterByQuery ?result ?tmpResult ?query)))
   
   (:- (getElements ?result ?query)
       ((getElementsFromCurrentState ?tmpResult ?query)
        (assign ?result (call ConcatList (?tmpResult (call GetElements ?query))))))
   
   ;;
   (:- (getElement ?result ?query)
       ((getElements ?tmpResult ?query)
        (assignIterator ?result ?tmpResult)))
   
   ;; Axiom to gather type(s)
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getTypesH ?result () ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getTypesH ?result (?e . ?elements) ?tmpResult)
       ((getTypes ?types ?e)
        (getTypesH ?result ?elements (?types . ?tmpResult))))
   
   (:- (getTypes ?result ?elements)
       ((getTypesH ?result ?elements ())))
   
   ;;
   (:- (getTypesFromCurrentStateH ?result ?e ?tmpResult)
       ((forall (?t) ((class ?t ?e))
                ((exist ?t ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((class ?t ?e)
          (not (exist ?t ?tmpResult))
          (getTypesFromCurrentStateH ?result ?e (?t . ?tmpResult)))))
   
   (:- (getTypesFromCurrentState ?result ?e)
       ((getTypesFromCurrentStateH ?tmpResult ?e ())
        (different ?tmpResult ())
        (assign ?result ?tmpResult)))
   
   (:- (getTypes ?result ?e)
       (:first (getTypesFromCurrentState ?result ?e))
       ((assign ?result (call GetType ?e))))
   
   ;;
   (:- (getType ?type ?e)
       (:first (class ?type ?e))
       ((assignIterator ?type (call GetType ?e))))
   
   ;; Axiom to gather property value(s)
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getPropertyValuesH ?result () ?property ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getPropertyValuesH ?result (?e . ?elements) ?property ?tmpResult)
       ((getPropertyValues ?values ?e ?property)
        (getPropertyValuesH ?result ?elements ?property (?values . ?tmpResult))))
   
   (:- (getPropertyValues ?result ?elements ?property)
       ((getPropertyValuesH ?result ?elements ?property ())))
   
   ;;
   (:- (getPropertyValuesFromCurrentStateH ?result ?e ?property ?tmpResult)
       ((forall (?v) ((property ?e ?property ?v))
                ((exist ?v ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((property ?e ?property ?v)
          (not (exist ?v ?tmpResult))
          (getPropertyValuesFromCurrentStateH ?result ?e ?property (?v . ?tmpResult)))))
   
   (:- (getPropertyValuesFromCurrentState ?result ?e ?property)
       ((getPropertyValuesFromCurrentStateH ?tmpResult ?e ?property ())
        (different ?tmpResult ())
        (assign ?result ?tmpResult)))
   
   (:- (getPropertyValues ?result ?e ?property)
       (:first (getPropertyValuesFromCurrentState ?result ?e ?property))
       ((assign ?result (call GetPropertyValue ?e ?property))))
   
   ;;
   (:- (getPropertyValue ?result ?e ?property)
       (:first (property ?e ?property ?result))
       ((assignIterator ?result (call GetPropertyValue ?e ?property))))
   
   ;; Axiom to gather property value(s) from with dest
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;   
   (:- (getPropertyValuesH ?result () ?property ?d ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getPropertyValuesH ?result (?e . ?elements) ?property ?d ?tmpResult)
       ((getPropertyValues ?values ?e ?property ?d)
        (getPropertyValuesH ?result ?elements ?property ?d (?values . ?tmpResult))))
   
   (:- (getPropertyValues ?result ?elements ?property ?d)
       ((getPropertyValuesH ?result ?elements ?property ?d ())))
   
   ;;
   (:- (getPropertyValuesFromCurrentStateH ?result ?e ?property ?d ?tmpResult)
       ((forall (?v) ((property ?e ?property (?d ?v)))
                ((exist ?v ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((property ?e ?property (?d ?v))
          (not (exist ?v ?tmpResult))
          (getPropertyValuesFromCurrentStateH ?result ?e ?property ?d (?v . ?tmpResult)))))
   
   (:- (getPropertyValuesFromCurrentState ?result ?e ?property ?d)
       ((getPropertyValuesFromCurrentStateH ?tmpResult ?e ?property ?d ())
        (different ?tmpResult ())
        (assign ?result ?tmpResult)))
   
   (:- (getPropertyValues ?result ?e ?property ?d)
       (:first (getPropertyValuesFromCurrentState ?result ?e ?property ?d))
       ((assign ?result (call GetPropertyValue ?e ?property ?d))))
   
   ;;
   (:- (getPropertyValue ?result ?e ?property ?d)
       (:first (property ?e ?property (?d ?result)))
       ((assignIterator ?result (call GetPropertyValue ?e ?property ?d))))
   
   ;; Axiom to gather related(s)
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getRelatedsH ?result () ?relation ?tmpResult)
       ((assign ?result (call ConcatList ?tmpResult))))
   
   (:- (getRelatedsH ?result (?e . ?elements) ?relation ?tmpResult)
       ((getRelateds ?relateds ?e ?relation)
        (getRelatedsH ?result ?elements ?relation (?relateds . ?tmpResult))))
   
   (:- (getRelateds ?result ?elements ?relation)
       ((getRelatedsH ?result ?elements ?relation ())))
     
   ;;
   (:- (getInvRelatedsFromCurrentStateH ?result ?e ?relation ?tmpResult)
       ((forall (?d) ((relation ?d ?relation ?e))
                ((exist ?d ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((relation ?d ?relation ?e)
          (not (exist ?d ?tmpResult))
          (getInvRelatedsFromCurrentStateH ?result ?e ?relation (?d . ?tmpResult)))))
   
   (:- (getRelatedsFromCurrentStateH ?result ?e ?relation ?tmpResult)
       ((forall (?d) ((relation ?e ?relation ?d))
                ((exist ?d ?tmpResult)))
        (assign ?result ?tmpResult))
       ;; fall-back
       (:first
         ((relation ?e ?relation ?d)
          (not (exist ?d ?tmpResult))
          (getRelatedsFromCurrentStateH ?result ?e ?relation (?d . ?tmpResult)))))
   
   (:- (getRelatedsFromCurrentState ?result ?e ?relation)
       ((inverseOf ?invRelation ?relation)
        (getInvRelatedsFromCurrentStateH ?tmpResult ?e ?invRelation ())
        (different ?tmpResult ())
        (assign ?result ?tmpResult))
       ;; fall-back
       ((getRelatedsFromCurrentStateH ?tmpResult ?e ?relation ())
        (different ?tmpResult ())
        (assign ?result ?tmpResult)))
   
   (:- (getRelateds ?result ?e ?relation)
       (:first (getRelatedsFromCurrentState ?result ?e ?relation))
       ((assign ?result (call GetRelated ?e ?relation))))
   
   ;;
   (:- (getRelated ?result ?e ?relation)
       (:first ((inverseOf ?invRelation ?relation)
                (relation ?result ?invRelation ?e)))
       (:first (relation ?e ?relation ?result))
       ((assignIterator ?result (call GetRelated ?e ?relation))))
   
   ;; Select elements related for multiple elements with distance
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getRelatedsH ?result ?elements 0 ?relation ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getRelatedsH ?result () ?d ?relation ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (getRelatedsH ?result (?e . ?elements) ?d ?relation ?tmpResult)
       ((different ?d 0)
        (getRelateds ?tmpResult2 ?e ?relation)
        (getRelateds ?tmpResult3 ?tmpResult2 (call - ?d 1) ?relation)
        (getRelatedsH ?result ?elements ?d ?relation
                      (call ConcatList (?tmpResult ?tmpResult2 ?tmpResult3)))))
   
   (:- (getRelateds ?result ?elements ?d ?relation)
       ((getRelatedsH ?result ?elements ?d ?relation ())))
   
   ;; Select elements related for multiple elements with distance and query
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (getRelateds ?result ?elements ?d ?relation ?query)
       ((getRelateds ?tmpResult ?elements ?d ?relation)
        (filterByQuery ?result ?tmpResult ?query)))
      
   ;; Axiom to filter goals by competences 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:- (filterGoalsByCompetencesH ?result () ?comps ?tmpResult)
       ((assign ?result ?tmpResult)))
   
   (:- (filterGoalsByCompetencesH ?result (?goal . ?goals) ?comps ?tmpResult)
       ((first ?comp ?goal)
        (exist ?comp ?comps)
        (filterGoalsByCompetencesH ?result ?goals ?comps (?goal . ?tmpResult)))
       ;; fall-back
       ((filterGoalsByCompetencesH ?result ?goals ?comps ?tmpResult)))
   
   (:- (filterGoalsByCompetences ?result ?goals ?comps)
       ((filterGoalsByCompetencesH ?result ?goals ?comps ())))
   
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
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Operators and methods to modeling edition phase                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:operator (!startLDElement ?tag)
      ()
      ()
      ())
   
   (:operator (!startLDElement ?tag ?params)
      ()
      ()
      ())
   
   (:operator (!endLDElement ?tag)
      ()
      ()
      ())
   
   (:operator (!startLDElement ?tag ?params (?types ?id ?goals ?groups))
      ;; preconditions
      ((assign ?learners (call ConcatList ?groups))
       (getElements ?parents ((class CurrentLDElement))))
      ;; remove atoms
      ((forall (?e) ((class CurrentLDElement ?e))
               ((class CurrentLDElement ?e))))
      ;; add atoms
      ((forall (?t) ((exist ?t ?types))
               ((class ?t ?id)))
       (forall (?g) ((exist ?g ?goals) (first ?c ?g))
               ((property ?id hasGoal ?g)
                (property ?id hasCompetency ?c)))
       (forall (?l) ((exist ?l ?learners))
               ((property ?id hasParticipant ?l)))
       ;; parent fundamental competencies
       (forall (?p ?c) ((exist ?p ?parents)
                        (property ?p hasFundCompetency ?c))
               ((property ?id hasFundCompetency ?c)))
       ;; parent learning resource type
       (forall (?p ?t) ((exist ?p ?parents)
                        (property ?p hasLearningResourceType ?t))
               ((property ?id hasLearningResourceType ?t)))
       ;; parent clgrouping
       (forall (?p ?cn ?sn ?g ?ls)
               ((exist ?p ?parents)
                (property ?p hasCLGroupingTheory ?cn)
                (property ?p hasCLGroupingStrategy ?sn)
                (property ?p hasCLGroupingGoal (?sn ?g))
                (property ?p hasCLGroupingLearners (?sn ?ls)))
               ((property ?id hasCLGroupingTheory ?cn)
                (property ?id hasCLGroupingStrategy ?sn)
                (property ?id hasCLGroupingGoal (?sn ?g))
                (property ?id hasCLGroupingLearners (?sn ?ls))))
       ;; current uol
       (forall (?p ?u) ((exist ?p ?parents)
                        (property ?p hasCurrentUoL ?u))
               ((property ?id hasCurrentUoL ?u)))
       ;; relation
       (forall (?p) ((exist ?p ?parents))
               ((relation ?id isPartOf ?p)))
       (class CurrentLDElement ?id)))
   
   (:operator (!startLDElement ?tag ?params (?types ?id ?goals ?skills ?attits ?groups))
      ;; preconditions
      ((assign ?learners (call ConcatList ?groups))
       (getElements ?parents ((class CurrentLDElement))))
      ;; remove atoms
      ((forall (?e) ((class CurrentLDElement ?e))
               ((class CurrentLDElement ?e))))
      ;; add ld information
      ((forall (?t) ((exist ?t ?types))
               ((class ?t ?id)))
       (forall (?g) ((exist ?g ?goals) (first ?c ?g))
               ((property ?id hasGoal ?g)
                (property ?id hasCompetency ?c)))
       (forall (?l) ((exist ?l ?learners))
               ((property ?id hasParticipant ?l)))
       ;; parent fundamental competencies
       (forall (?p ?c) ((exist ?p ?parents)
                        (property ?p hasFundCompetency ?c))
               ((property ?id hasFundCompetency ?c)))
       ;; parent learning resource type
       (forall (?p ?t) ((exist ?p ?parents)
                        (property ?p hasLearningResourceType ?t))
               ((property ?id hasLearningResourceType ?t)))
       ;; parent clgrouping
       (forall (?p ?cn ?sn ?g ?ls)
               ((exist ?p ?parents)
                (property ?p hasCLGroupingTheory ?cn)
                (property ?p hasCLGroupingStrategy ?sn)
                (property ?p hasCLGroupingGoal (?sn ?g))
                (property ?p hasCLGroupingLearners (?sn ?ls)))
               ((property ?id hasCLGroupingTheory ?cn)
                (property ?id hasCLGroupingStrategy ?sn)
                (property ?id hasCLGroupingGoal (?sn ?g))
                (property ?id hasCLGroupingLearners (?sn ?ls))))
       ;; skills and attitudes
       (forall (?s) ((exist ?s ?skills))
               ((property ?id hasSkill ?s)))
       (forall (?a) ((exist ?a ?attits))
               ((property ?id hasAttitude ?a)))
       ;; current uol
       (property ?id hasCurrentUoL ?id)
       ;; relation
       (forall (?p) ((exist ?p ?parents))
               ((relation ?id isPartOf ?p)))
       (class CurrentLDElement ?id))) 
   
   (:operator (!endLDElement ?tagname ?id)
      ;; preconditions
      ((getPropertyValues ?indGoals ?id hasIndGoal)
       (getPropertyValues ?ts ?id hasCLGroupingTheory)
       (getPropertyValues ?ss ?id hasCLGroupingStrategy)
       (getPropertyValues ?gs ?id hasCLGroupingGoal)
       (getPropertyValues ?Ps ?id hasCLGroupingLearners))
      ;; remove atoms
      ((forall (?cig) ((exist ?cig ?indGoals))
               ((property ?id hasIndGoal ?cig)))
       (forall (?l ?c ?is) ((exist ?lig ?indGoals)
                            (first ?l ?lig) (last ?ig ?lig) (first ?c ?ig)
                            (property ?l hasCompetencyLevel (?c ?is)))
               ((property ?l hasCompetencyLevel (?c ?is))))
       ;; cl grouping
       (forall (?t ?s ?g ?P) ((exist ?t ?ts) (exist ?s ?ss)
                              (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?id hasCLGroupingTheory ?t)
                (property ?id hasCLGroupingStrategy ?s)
                (property ?id hasCLGroupingGoal ?g)
                (property ?id hasCLGroupingLearners ?P)))
       ;; relation
       (forall (?e) ((class CurrentLDElement ?e))
               ((class CurrentLDElement ?e))))
      ;; add atoms
      ((forall (?l ?c ?s) ((exist ?lig ?indGoals)
                           (first ?l ?lig) (last ?ig ?lig)
                           (first ?c ?ig) (last ?g ?ig)
                           (getPropertyValue ?s ?g hasGoalStage))
               ((property ?l hasCompetencyLevel (?c ?s))))
       ;; relation
       (forall (?p) ((relation ?id isPartOf ?p))
               ((class CurrentLDElement ?p)))))
   
   ;; Method to start ld element included ind-goals
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (startLDElement! ?tag ?params (?types ?id ?goals ?groups))
      ((getIndGoals ?indGoals ?goals ?groups))
      ((!startLDElement ?tag ?params (?types ?id ?goals ?groups))
       ;(!!addInWorldState (changeIndGoals ?indGoals))
       (!!changeIndGoals ?indGoals)
       ))
   
   (:operator (!!changeIndGoals ?indGoals)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?cigs ?e hasIndGoal))
      ((forall (?cig) ((exist ?cig ?cigs))
               ((property ?e hasIndGoal ?cig))))
      ((forall (?ig) ((exist ?ig ?indGoals))
               ((property ?e hasIndGoal ?ig)))))
  
   ;; Operator to change the current ld element   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!changeCurrentLDElement ?elements)
      ((getElements ?currents ((class CurrentLDElement))))
      ((forall (?c) ((exist ?c ?currents))
               ((class CurrentLDElement ?c))))
      ((forall (?e) ((exist ?e ?elements))
               ((class CurrentLDElement ?e)))))

   ;; Operator to change learning resource type
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!changeLearningResourceType ?types)
      ((getElements ?elements ((class CurrentLDElement)))
       (getPropertyValues ?ctypes ?elements hasLearningResourceType))
      ((forall (?e ?ct) ((exist ?e ?elements) (exist ?ct ?ctypes))
               ((property ?e hasLearningResourceType ?ct))))
      ((forall (?e ?t) ((exist ?e ?elements) (exist ?t ?types))
               ((property ?e hasLearningResourceType ?t)))))
   
   ;; Operator to change fundamental competences
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!changeFundCompetency ?comp)
      ((getElements ?elements ((class CurrentLDElement))))
      ((forall (?e ?c) ((exist ?e ?elements)
                        (property ?e hasFundCompetency ?c))
               ((property ?e hasFundCompetency ?c))))
      ((forall (?e) ((exist ?e ?elements))
               ((property ?e hasFundCompetency ?comp)))))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Operators and methods to modeling configuration phase                 ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; Methods and operator to add/remove user to/from groups
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (addUsersToGroup () ?group)
      ()
      ())
   
   (:method (addUsersToGroup (?user . ?users) ?group)
      ()
      ((!addUserToGroup ?user ?group)
       (addUsersToGroup ?users ?group)))
   
   (:operator (!addUserToGroup ?user ?group)
      ((not (property ?user hasGroup ?group)))
      ()
      ((property ?user hasGroup ?group)))
   
   ;;
   (:method (removeUsersFromGroup () ?group)
      ()
      ())
   
   (:method (removeUsersFromGroup (?user . ?users) ?group)
      ()
      ((!removeUserFromGroup ?user ?group)
       (removeUsersFromGroup ?users ?group)))
   
   (:operator (!removeUserFromGroup ?user ?group)
      ((property ?user hasGroup ?group))
      ((property ?user hasGroup ?group))
      ())
   
   ;; Method and operators for add/remove user to/from roles
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
   (:method (addUsersToRole () ?role)
      ()
      ())
   
   (:method (addUsersToRole (?user . ?users) ?role)
      ()
      ((!addUserToRole ?user ?role)
       (addUsersToRole ?users ?role)))

   (:operator (!addUserToRole ?learner ?role)
      ((not (property ?learner hasRole ?role)))
      ()
      ((property ?learner hasRole ?role)))

   ;;
   (:method (removeUsersFromRole () ?role)
      ()
      ())
   
   (:method (removeUsersFromRole (?user . ?users) ?role)
      ()
      ((!removeUserFromRole ?user ?role)
       (removeUsersFromRole ?users ?role)))
   
   (:operator (!removeUserFromRole ?user ?role)
      ((property ?user hasRole ?role))
      ((property ?user hasRole ?role))
      ())
   
   ;; Operator to change cl grouping information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:operator (!!changeCLGrouping ())
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?ts ?e hasCLGroupingTheory)
       (getPropertyValues ?ss ?e hasCLGroupingStrategy)
       (getPropertyValues ?gs ?e hasCLGroupingGoal)
       (getPropertyValues ?Ps ?e hasCLGroupingLearners))
      ((forall (?t ?s ?g ?P)
               ((exist ?t ?ts) (exist ?s ?ss)
                (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal ?g)
                (property ?e hasCLGroupingLearners ?P))))
      ())
   
   (:operator (!!changeCLGrouping (independent ?sgPs))
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?ts ?e hasCLGroupingTheory)
       (getPropertyValues ?ss ?e hasCLGroupingStrategy)
       (getPropertyValues ?gs ?e hasCLGroupingGoal)
       (getPropertyValues ?Ps ?e hasCLGroupingLearners))
      ((forall (?t ?s ?g ?P)
               ((exist ?t ?ts) (exist ?s ?ss)
                (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal ?g)
                (property ?e hasCLGroupingLearners ?P))))
      ())
   
   (:operator (!!changeCLGrouping (?t ?sgPs))
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?cts ?e hasCLGroupingTheory)
       (getPropertyValues ?css ?e hasCLGroupingStrategy)
       (getPropertyValues ?cgs ?e hasCLGroupingGoal)
       (getPropertyValues ?cPs ?e hasCLGroupingLearners))
      ((forall (?ct ?cs ?cg ?cP)
               ((exist ?ct ?cts) (exist ?cs ?css)
                (exist ?cg ?cgs) (exist ?cP ?cPs))
               ((property ?e hasCLGroupingTheory ?ct)
                (property ?e hasCLGroupingStrategy ?cs)
                (property ?e hasCLGroupingGoal ?cg)
                (property ?e hasCLGroupingLearners ?cP))))
      ((forall (?s ?g ?P)
               ((exist ?sgP ?sgPs)
                (first ?s ?sgP) (rest ?gP ?sgP)
                (first ?g ?gP)  (last ?P ?gP))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal (?s ?g))
                (property ?e hasCLGroupingLearners (?s ?P))))))
   
   (:operator (!!changeCLGrouping ?id)
      ((getPropertyValues ?ts ?id hasCLGroupingTheory)
       (getPropertyValues ?ss ?id hasCLGroupingStrategy)
       (getPropertyValues ?gs ?id hasCLGroupingGoal)
       (getPropertyValues ?Ps ?id hasCLGroupingLearners)
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?cts ?e hasCLGroupingTheory)
       (getPropertyValues ?css ?e hasCLGroupingStrategy)
       (getPropertyValues ?cgs ?e hasCLGroupingGoal)
       (getPropertyValues ?cPs ?e hasCLGroupingLearners))
      ((forall (?ct ?cs ?cg ?cP)
               ((exist ?ct ?cts) (exist ?cs ?css)
                (exist ?cg ?cgs) (exist ?cP ?cPs))
               ((property ?e hasCLGroupingTheory ?ct)
                (property ?e hasCLGroupingStrategy ?cs)
                (property ?e hasCLGroupingGoal ?cg)
                (property ?e hasCLGroupingLearners ?cP))))
      ((forall (?t ?s ?g ?P)
               ((exist ?t ?ts) (exist ?s ?ss)
                (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal ?g)
                (property ?e hasCLGroupingLearners ?P)))))
    
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Operators and methods to modeling instation phase***                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; Operator to insert plain text
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!text ?types ?fparameters ?sparameters)
      ()
      ()
      ())
   
   ;; Methods and operator to insert elements
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!insertElement ?e ?learners)
      ()
      ()
      ((forall (?l) ((exist ?l ?learners))
               ((property ?e hasBeenSeen ?l)
                (property ?l hasAlreadySeen (?e true))))))
   
   ;; Methods and operator to insert a resource
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!insertResource ?r ?attributes)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL))
      ()
      ((insertedIn ?r ?u)))
   
   ;; Method to insert resource once only for resource
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (insertResourceOnce ?r)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (not (insertedIn ?r ?u))
       ;;
       (getPropertyValue ?type ?r hasType)
       (getPropertyValue ?href ?r hasHref))
      ((!insertResource ?r ((type ?type) (href ?href))))
      
      ;; fall-back
      ()
      ())
   
   ;; Operator to insert as already seen atoms
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!addInWorldStateAsAlreadySeen ?elements ?learners)
      ()        
      ()
      ((forall (?l ?e) ((exist ?e ?elements)
                        (exist ?l ?learners))
               ((property ?e hasBeenSeen ?l)
                (property ?l hasAlreadySeen (?e true))))))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Common axions and methods used to modeling clscenarios                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; Method to create ilevents conditions to show or hiden items
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDILEventConditions ?groups)
      ()
      ((createLDILEventConditions! ?groups)))
   
   ;; fall-back
   (:method (createLDILEventConditions ?groups)
      ()
      ())
   
   (:method (createLDILEventConditions! ?groups)
      ()
      ((!startLDElement conditions)
       (createLDTitle (ILEvent Conditions) ())
       (createILEventConditions ?groups)
       (!endLDElement conditions)))
   
   (:method (createILEventConditions (?instructors ?learners))
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?unInstRoles ?instructors hasRole)
       (filterByQuery ?instRoles ?unInstRoles ((class Role)
                                               (property hasCurrentUoL ?u)
                                               (class Instructional)))
       (getPropertyValues ?unLearRoles ?learners hasRole)
       (filterByQuery ?learRoles ?unLearRoles ((class Role)
                                               (property hasCurrentUoL ?u)
                                               (class Learning)))
       (buildPropertyQuery ?instQuery hasParticipant ?instructors ())
       (getElements ?instItems ((class ILEventItem)
                                (class Instructional) (class Item)
                                (property hasCurrentUoL ?u) . ?instQuery))
       (buildPropertyQuery ?learQuery hasParticipant ?learners ())
       (getElements ?learItems ((class ILEventItem) 
                                (class Learning) (class Item)
                                (property hasCurrentUoL ?u) . ?learQuery))
       (different ?instRoles ())
       (different ?learRoles ())
       (different ?instItems ())
       (different ?learItems ()))
      ((!startLDElement if)
       (distributeLDMemberOfRole ?instRoles)
       (!endLDElement if)
       (!startLDElement then)
       (!startLDElement show)
       (distributeItemRef ?instItems)
       (!endLDElement show)
       (!startLDElement hide)
       (distributeItemRef ?learItems)
       (!endLDElement hide)
       (!endLDElement then)
       (!startLDElement else)
       (!startLDElement if)
       (distributeLDMemberOfRole ?learRoles)
       (!endLDElement if)
       (!startLDElement then)
       (!startLDElement show)
       (distributeItemRef ?learItems)
       (!endLDElement show)
       (!startLDElement hide)
       (distributeItemRef ?instItems)
       (!endLDElement hide)
       (!endLDElement then)
       (!endLDElement else)))
   
   (:method (distributeLDMemberOfRole ?roles)
      ((length ?nroRoles ?roles)
       (call > ?nroRoles 1))
      ((!startLDElement _or)
       (distributeMemberOfRole ?roles)
       (!endLDElement _or))
      ;; fall-back
      ((length ?nroRoles ?roles)
       (call = ?nroRoles 1))
      ((distributeMemberOfRole ?roles)))
   
   ;;
   (:method (distributeMemberOfRole ())
      ()
      ())

   (:method (distributeMemberOfRole (?role . ?roles))
      ()
      ((!startLDElement is-member-of-role ((ref ?role)))
       (!endLDElement is-member-of-role)
       (distributeMemberOfRole ?roles)))
   
   ;;
   (:method (distributeItemRef ())
      ()
      ())

   (:method (distributeItemRef (?item . ?items))
      ()
      ((!startLDElement item-ref ((ref ?item)))
       (!endLDElement item-ref)
       (distributeItemRef ?items)))

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling ld conference-service             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDConferenceService ?goals ?groups)
      ()
      ((!startLDElement service ((identifier (call GetUUID serv))
                                 (isvisible true)))
       (createConferenceService ?goals ?groups)
       (!endLDElement service)))
   
   (:method (createConferenceService ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nro ?learners)
       (filterByQuery ?introverts ?learners
                      ((property hasPersonality introversion)))
       (length ?nrointroverts ?introverts)
       (call > ?nrointroverts (call / ?nro 2)))
      ((createLDAsynchronousConference ?goals ?learners))
      
      ()
      ((createLDSynchronousConference ?goals (call ConcatList ?groups))))
   
   ;; Method to create asynchronous conference
   ;; (TODO) - optional and mandatory
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDAsynchronousConference ?goals ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (assign ?service (call BuildElement ((class Service)
                                            (property hasCurrentUoL ?u)
                                            (property hasType asynchronous) . ?query))))
      ((!startLDElement conference ((conference-type asynchronous)))
       (createLDTitle (Asynchronous Conference) ?goals)
       (createConference ?goals ?learners)
       (createLDItem ?service)
       (!endLDElement conference)))
   
   ;; Method to create synchronous conference
   ;; (TODO) - optional and mandatory
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDSynchronousConference ?goals ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (assign ?service (call BuildElement ((class Service)
                                            (property hasCurrentUoL ?u)
                                            (property hasType synchronous) . ?query))))
      ((!startLDElement conference ((conference-type synchronous)))
       (createLDTitle (Synchronous Conference) ?goals)
       (createConference ?goals ?learners)
       (createLDItem ?service)
       (!endLDElement conference)))
   
   ;;
   (:method (createConference ?goals ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?ungroups ?learner hasGroup)
       (filterByQuery ?groups ?ungroups ((class Group)
                                         (property hasCurrentUoL ?u)))
       (getPropertyValues ?unroles ?learner hasRole)
       (filterByQuery ?roles ?unroles ((class Role)
                                       (class LDLearner)
                                       (property hasCurrentUoL ?u)))
       (assign ?refs (call Union (?groups ?roles))))
      ((distributeParticipants ?refs)))
   
   ;;
   (:method (distributeParticipants ())
      ()
      ())
   
   (:method (distributeParticipants (?ref . ?refs))
      ()
      ((!startLDElement participant ((role-ref ?ref)))
       (!endLDElement participant)
       (distributeParticipants ?refs)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling ld environment                    ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Environment) ?id ?goals ?groups))
       (createLDTitle (Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   (:method (createEnvironment ?goals ?groups)
      ()
      ((distributeLearningObject ?goals ?groups)
       (createLDConferenceService ?goals ?groups)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axioms and methods to build ld group                                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDGroup ?goals ?groups)
      ()
      ((createLDGroup! ?goals ?groups)))
   
   ;; mandatory
   (:method (createLDGroup! ?goals ?lgroups)
      ((assign ?learners (call ConcatList ?lgroups))
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (first ?learner ?learners)
       (getPropertyValues ?groups ?learner hasGroup)
       (buildPropertyQuery ?query hasParticipant ?learners ())
       (filterByQuery ?ids ?groups ((class Group)
                                    (property hasCurrentUoL ?u) . ?query))
       (assignIterator ?id ?ids)
       (forall (?l) ((exist ?l ?learners))
               ((property ?l hasGroup ?id))))
      ((!startLDElement role-ref ((ref ?id)))
       (!endLDElement role-ref)))
   
   ;; fall-back
   (:method (createLDGroup ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (assign ?id (call GetUUID group)))
      ((!startLDElement role-ref ((ref ?id)))
       (!startLDElement learner ((identifier ?id))
                        ((Group) ?id () (?learners)))
       (createLDTitle (Group) ())
       (createGroup ?id ?learners)
       (!endLDElement learner ?id)
       (!endLDElement role-ref)))
   
   (:method (createGroup ?group ?learners)
      ()
      ((addUsersToGroup ?learners ?group)
       ;(createLDInformation ?group ?learners)
       ))
   
   (:method (createLDInformation ?group ?learners)
      ()
      ((!startLDElement information)
       (distributeItem ?learners)
       (!endLDElement information)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to create ld item                             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDItem ?e)
      ()
      ((createLDItem! ?e)))
   
   (:method (createLDItem! ?e)
      ((getPropertyValue ?r ?e hasResource))
      ((!startLDElement item ((identifier (call GetUUID item))
                              (identifierref ?r)))
       (createLDTitle (Resource) () (?e))
       (insertResourceOnce ?r)
       (!endLDElement item)))

   (:method (createLDItem ?e)
      ()
      ((createLDItem fall-back ?e)))
   
   ;;
   (:method (distributeItem ())
      ()
      ())
   
   (:method (distributeItem (?e . ?elements))
      ()
      ((createLDItem ?e)
       (distributeItem ?elements)))
   
   ;; Method to create ld item with learners
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDItem ?e ?learners)
      ((getPropertyValue ?r ?e hasResource))
      ((!startLDElement item ((identifier (call GetUUID item))
                              (identifierref ?r)))
       (createLDTitle (Resource) () (?e))
       (!insertElement ?e ?learners)
       (insertResourceOnce ?r)
       (!endLDElement item)))
   
   ;;
   (:method (distributeItem () ?learners)
      ()
      ())
   
   (:method (distributeItem (?e . ?elements) ?learners)
      ()
      ((createLDItem ?e ?learners)
       (distributeItem ?elements ?learners)))
   
   ;; Method to create instructional item
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDInstructItem ?e ?learners)
      ((getPropertyValue ?r ?e hasResource)
       (assign ?id (call GetUUID item)))
      ((!startLDElement item ((identifier ?id) (identifierref ?r))
                        ((ILEventItem Instructional Item) ?id () (?learners)))
       (createLDTitle (Instructional Item) () (?e))
       (insertResourceOnce ?r)
       (!endLDElement item ?id)))
   
   ;; Method to create learning item
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDLearningItem ?e ?learners)
      ((getPropertyValue ?r ?e hasResource)
       (assign ?id (call GetUUID item)))
      ((!startLDElement item ((identifier ?id) (identifierref ?r))
                        ((ILEventItem Learning Item) ?id () (?learners)))
       (createLDTitle (Learning Item) () (?e))
       (insertResourceOnce ?r)
       (!endLDElement item ?id)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling ld learning objects               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (distributeLearningObject () ())
      ()
      ())
    
   (:method (distributeLearningObject (?goal . ?goals) (?group . ?groups))
      ()
      ((createLDLearningObject ?goal ?group)
       (distributeLearningObject ?goals ?groups)))
  
   ;; Method to create one learning object for learners
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDLearningObject ?goal ?learners)
      ()
      ((createLDLearningObject! ?goal ?learners)))
   
   ;; mandatory (auxiliary)
   (:method (createLDLearningObject! (?c ?l) ?learners)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?lobjects (?e) 1 inverseIsPartOf
                    ((class LearningObject)
                     (property hasCompetency ?c)))
       (different ?lobjects ())
       (getPropertyValues ?auxs ?lobjects hasKnowledge))
      ((!!addInWorldStateAsAlreadySeen ?auxs ?learners)))
   
   ;; fall-back
   (:method (createLDLearningObject ?goal ?learners)
      ((assign ?id (call GetUUID lo)))
      ((!startLDElement learning-object ((identifier ?id))
                        ((LearningObject) ?id (?goal) (?learners)))
       (createLDTitle (LearningObject) (?goal))
       (createLearningObject ?goal ?learners)
       (!endLDElement learning-object ?id)))
   
   ;;
   (:method (createLearningObject (?c ?l) ?learners)
      ((getPropertyValue ?aux ?c hasKnowledge)
       (getRelateds ?variants (?aux) -1 isVariantOf
                    ((class Auxiliary)
                     (property hasLearningObjective ?c ?l))))
      ((createLDItem ?aux ?learners)
       (distributeItem ?variants ?learners)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axioms and methods to build ld title                                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:- (getTitlesH ?result () ?tmpResult)
       ((assign ?result (call Reverse ?tmpResult))))
   
   (:- (getTitlesH ?result (?e . ?elements) ?tmpResult)
       ((getPropertyValue ?title ?e hasTitle)
        (getTitlesH ?result ?elements (?title . ?tmpResult)))
       ;; fall-back
       ((getTitlesH ?result ?elements (?e . ?tmpResult))))
   
   (:- (getTitles ?result ?elements)
       ((getTitlesH ?result ?elements ())))
   
   ;(:- (getTitles ?result ?result) ())
   
   ;; create LD title
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDTitle ?types ?goals)
      ((getCompsFromGoals ?comps ?goals)
       (getTitles ?gtitles ?comps))
      ((!startLDElement title)
       (!text ?types ?gtitles ())
       (!endLDElement title)))
   
   (:method (createLDTitle ?types ?goals ?elements)
      ((getCompsFromGoals ?comps ?goals)
       (getTitles ?gtitles ?comps)
       (getTitles ?etitles ?elements))
      ((!startLDElement title)
       (!text ?types ?gtitles ?etitles)
       (!endLDElement title)))
   
   (:method (createLDTitle ?types ?goals ?elements ?texts)
      ((getCompsFromGoals ?comps ?goals)
       (getTitles ?gtitles ?comps)
       (getTitles ?etitles ?elements))
      ((!startLDElement title)
       (!text ?types ?gtitles (call ConcatList (?etitles ?texts)))
       (!endLDElement title)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice group activity           ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDConcludeGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Conclude GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Conclude GroupActivity) ?goals)
       (createConcludeGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createConcludeGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDConcludeWithSummarySession ?goals ?groups)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling develop group activity            ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDevelopGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Develop GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Develop GroupActivity) ?goals)
       (createDevelopGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createDevelopGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (!!addInWorldState (createLDDevelopSession ?goals ?groups))
       ))
 


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice group activity           ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIllustrateGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Illustrate GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Illustrate GroupActivity) ?goals)
       (createIllustrateGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createIllustrateGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling introduction group activity       ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIntroductionGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Introduction GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Introduction GroupActivity) ?goals)
       (createIntroductionGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createIntroductionGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDIntroductionSessions ?goals ?groups)))
   
   ;;
   (:method (createLDIntroductionSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Introduction Sessions) ?id ?goals ?groups))
       (createLDTitle (Introduction Sessions) ?goals)
       (createIntroductionSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createIntroductionSessions ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (length ?nro ?learners)
       (filterByQuery ?notanxious ?learners
                      ((property hasPersonality (very-low low medium))))
       (length ?nronotanxious ?notanxious)
       (call > ?nronotanxious (call / ?nro 2)))
      ((createLDMotivationSession ?goals ?groups)
       (createLDShowProblemSession ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
   (:method (createIntroductionSessions ?goals ?groups)
      ()
      ((createLDShowProblemSession ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice group activity           ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((Practice GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Practice GroupActivity) ?goals)
       (createPracticeGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createPracticeGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDPracticeWithExercisesUoL ?goals ?groups)))

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Methods used to modeling practice-with-exercise group activity        ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeWithExerciseGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((PracticeWithExercise GroupActivity) ?id ?goals ?groups))
       (createLDTitle (PracticeWithExercise GroupActivity) ?goals)
       (createPracticeWithExerciseGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createPracticeWithExerciseGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDPracticeWithExerciseSession ?goals ?groups)))

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling show connections group activity   ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDShowConnectionsGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((startLDElement! role-part ((identifier ?id))
                        ((ShowConnections GroupActivity) ?id ?goals ?groups))
       (createLDTitle (ShowConnections GroupActivity) ?goals)
       (createShowConnectionsGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createShowConnectionsGroupActivity ?goals ?groups)
      ((getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getElements ?theorems ((class Fundamental)
                               (property hasLearningResourceType theorem)
                               (relation inverseIsRequiredBy ?c)))
       (different ?theorems ())
       (length ?nro ?theorems)
       (assign ?learners (call ConcatList ?groups))
       (assign ?tgoals (call GetProduct ?theorems (?l)))
       (duplicate ?tgroups ?learners ?nro))
      ((createLDGroup ?goals ?groups)
       (createLDShowConnectionsByTheoremWithProofSessions ?tgoals ?tgroups)))
   
   (:method (createShowConnectionsGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDShowConnectionsByCMapSession ?goals ?groups)))
   
   ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowConnectionsByTheoremWithProofSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((ShowConnectionsByTheoremWithProof Sessions) ?id ?goals ?groups))
       (createLDTitle (ShowConnectionsByTheoremWithProof Sessions) ?goals)
       (createShowConnectionsByTheoremWithProofSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createShowConnectionsByTheoremWithProofSessions ?goals ?groups)
      ()
      ((distributeShowTheoremWithProofSessions ?goals ?groups)))
  
   ;; 
   (:method (distributeShowTheoremWithProofSessions () ())
      ()
      ())
   
   (:method (distributeShowTheoremWithProofSessions (?goal . ?goals) (?group . ?groups))
      ()
      ((createLDDevelopConnectionSessions (?goal) (?group))     
       (distributeShowTheoremWithProofSessions ?goals ?groups)))
   
   ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDevelopConnectionSessions ?goals ?groups)
      ()
      ((!startLDElement ativity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((DevelopConnection Sessions) ?id ?goals ?groups))
       (createDevelopConnectionSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createDevelopConnectionSessions ?goals ?groups)
      ()
      ((createLDDevelopSession ?goals ?groups)
       (createLDIllustrateWithExampleSession ?goals ?groups)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling conclude phase                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDConcludePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Conclude Phase) ?id () ?groups))
       (createLDTitle (Conclude Phase) ?goals)
       (createConcludePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createConcludePhase ?goals ?groups)
      ()
      ((createLDConcludeGroupActivity ?goals ?groups)))
 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling develop phase                     ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDevelopPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Develop Phase) ?id () ?groups))
       (createLDTitle (Develop Phase) ?goals)
       (createDevelopPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createDevelopPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getLearnerCompetencyLevels ?levels ?learners ?c))
      ((distributeDevelopGroupActivityByLevels (?c ?l) ?learners ?levels)))
   
   (:method (distributeDevelopGroupActivityByLevels ?goal ?learners ())
      ()
      ())
   
   (:method (distributeDevelopGroupActivityByLevels ?goal ?learners (?l . ?levels))
      ((first ?c ?goal)
       (filterLearnersByCompetencyLevel ?group ?learners ?c ?l)
       (remove ?rest ?learners ?group))
      ((createLDDevelopGroupActivity (?goal) (?group))
       (distributeDevelopGroupActivityByLevels ?goal ?rest ?levels)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling illustrate phase                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIllustratePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Illustrate Phase) ?id () ?groups))
       (createLDTitle (Illustrate Phase) ?goals)
       (createIllustratePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createIllustratePhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getLearnerCompetencyLevels ?levels ?learners ?c))
      ((distributeIllustrateGroupActivityByLevels (?c ?l) ?learners ?levels)))
   
   (:method (distributeIllustrateGroupActivityByLevels ?goal ?learners ())
      ()
      ())
   
   (:method (distributeIllustrateGroupActivityByLevels ?goal ?learners (?l . ?levels))
      ((first ?c ?goal)
       (filterLearnersByCompetencyLevel ?group ?learners ?c ?l)
       (remove ?rest ?learners ?group))
      ((createLDIllustrateGroupActivity (?goal) (?group))
       (distributeIllustrateGroupActivityByLevels ?goal ?rest ?levels)))
 
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling introduction phase                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIntroductionPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Introduction Phase) ?id () ?groups))
       (createLDTitle (Introduction Phase) ?goals)
       (createIntroductionPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createIntroductionPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompFromGoals ?c ?goals)
       (getLevelFromGoals ?l ?goals)
       (getLearnerCompetencyLevels ?levels ?learners ?c))
      ((distributeIntroductionGroupActivityByLevels (?c ?l) ?learners ?levels)))
   
   (:method (distributeIntroductionGroupActivityByLevels ?goal ?learners ())
      ()
      ())
   
   (:method (distributeIntroductionGroupActivityByLevels ?goal ?learners (?l . ?levels))
      ((first ?c ?goal)
       (filterLearnersByCompetencyLevel ?group ?learners ?c ?l)
       (remove ?rest ?learners ?group))
      ((createLDIntroductionGroupActivity (?goal) (?group))
       (distributeIntroductionGroupActivityByLevels ?goal ?rest ?levels)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice phase                    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Practice Phase) ?id () ?groups))
       (createLDTitle (Practice Phase) ?goals)
       (createPracticePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createPracticePhase ?goals ?groups)
      ()
      ((createLDPracticeGroupActivity ?goals ?groups)))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice-with-exercise phase      ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDPracticeWithExercisePhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Practice Phase) ?id () ?groups))
       (createLDTitle (Practice Phase) ?goals)
       (createPracticeWithExercisePhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createPracticeWithExercisePhase ?goals ?groups)
      ((getIndGoals ?indGoals ?goals ?groups)
       (assign ?clgrouping (call GetCLGrouping ?indGoals)))
      ((distributePracticeWithExerciseGroupActivityByCLGroups ?clgrouping)))
   
   ;;
   (:method (distributePracticeWithExerciseGroupActivityByCLGroups ())
      ()
      ())
   
   (:method (distributePracticeWithExerciseGroupActivityByCLGroups (?clg . ?clgroups))
      ((getGoalsFromCLGrouping ?goals ?clg)
       (getGroupsFromCLGrouping ?groups ?clg))
      ((!!changeCLGrouping ?clg)
       (createLDPracticeWithExerciseGroupActivity ?goals ?groups)
       (distributePracticeWithExerciseGroupActivityByCLGroups ?clgroups)))

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling show connections phase            ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDShowConnectionsPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((ShowConnections Phase) ?id () ?groups))
       (createLDTitle (ShowConnections Phase) ?goals)
       (createShowConnectionsPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createShowConnectionsPhase ?goals ?groups)
      ()
      ((createLDShowConnectionsGroupActivity ?goals ?groups)))
     
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
 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice-with-exercises script    ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPracticeWithExercisesScript ?goals ?groups)
      ((getCompFromGoals ?comp ?goals)
       (assign ?id (call GetUUID play)))
      ((!startLDElement play ((identifier ?id))
                        ((PracticeWithExercises Script) ?id ?goals ?groups))
       (createLDTitle (PracticeWithExercises Script) ?goals)
       (createPracticeWithExercisesScript ?goals ?groups)
       (!endLDElement play ?id)))
   
   (:method (createPracticeWithExercisesScript ?goals ?groups)
      ()
      ((distributePracticeWithExercisePhase ?goals ?groups)))
   
   ;;
   (:method (distributePracticeWithExercisePhase ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?phases (?e) 1 inverseIsPartOf
                    ((class Phase)
                     (class PracticeWithExercise)))
       (length ?nro ?phases)
       (or (reachedGoals ?goals ?groups)
           (call >= ?nro 2)))
      ()
      ;;fall-back
      ()
      ((createLDPracticeWithExercisePhase ?goals ?groups)
       (distributePracticeWithExercisePhase ?goals ?groups)))
 
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Methods to modeling uol first automated learning-design               ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDFundamentalUoL ?goals ?skills ?attits ?groups)
      ((assign ?id (call BuildElement ((class UoL)
                                       (class Fundamental))
                         (call GetUUID (call GetUUID ld))))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
                        ((Fundamental UoL) ?id ?goals ?skills ?attits ?groups))
       (createLDTitle (Fundamental UoL) ?goals)
       (!startLDElement method)
       (createFundamentalUoL ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)))
   
   (:method (createFundamentalUoL ?goals ?groups)
      ((getCompsFromGoals ?unsortComps ?goals)
       (sortBy ?comps ?unsortComps isRequiredBy))
      ((distributeFundamentalScriptByComps ?goals ?groups ?comps)))
   
   ;;
   (:method (distributeFundamentalScriptByComps ?goals ?groups ())
      ()
      ())
   
   (:method (distributeFundamentalScriptByComps ?goals ?groups (?c . ?comps))
      ((filterGoalsByComp ?fgoals ?goals ?c)
       (filterGroupsByComp ?fgroups ?goals ?groups ?c))
      ((createLDFundamentalScript ?fgoals ?fgroups)
       (distributeFundamentalScriptByComps ?goals ?groups ?comps)))

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling practice-with-exercises uol       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDPracticeWithExercisesUoL ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class PracticeWithExercises))
                           (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
            ((PracticeWithExercises UoL) ?id ?goals ?skills ?attits ?groups))
       (!!changeLearningResourceType (exercise))
       (createLDTitle (PracticeWithExercises UoL) ?goals)
       (!startLDElement method)
       (createPracticeWithExercisesUoL ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))

   (:method (createPracticeWithExercisesUoL ?goals ?groups)
      ()
      ((createLDPracticeWithExercisesScript ?goals ?groups)))
 
))
