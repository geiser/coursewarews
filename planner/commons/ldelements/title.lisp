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
   
