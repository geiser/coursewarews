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
   
