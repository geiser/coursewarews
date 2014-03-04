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
   
