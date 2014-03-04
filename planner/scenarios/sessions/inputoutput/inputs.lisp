   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling clarifying-problem                ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDInputs () ?learners)
      ()
      ())
   
   (:method (createLDInputs ?inputs ?learners)
      ()
      ((!startLDElement prerequisites)
       (createInputs ?inputs ?learners)
       (!endLDElement prerequisites)))
   
   ;;
   (:method (createInputs ?inputs ?learners)
      ()
      ((distributeItem ?inputs ?learners)))
    
