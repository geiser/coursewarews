   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling individual phase                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDIndividualPhase ?goals ?groups)
      ((assign ?id (call GetUUID act)))
      ((!startLDElement act ((identifier ?id))
                        ((Individual Phase) ?id () ?groups))
       (!!changeCLGrouping ())
       (createLDTitle (Individual Phase) ?goals)
       (createIndividualPhase ?goals ?groups)
       (!endLDElement act ?id)))
   
   (:method (createIndividualPhase ?goals ?groups)
      ((assign ?learners (call ConcatList ?groups))
       (getCompsFromGoals ?comps ?goals)
       (length ?nro ?comps)
       (divide ?grouping ?learners ?nro))
      ((distributeIndGroupActivityByComps ?grouping ?comps)))
   
   ;;
   (:method (distributeIndGroupActivityByComps () ())
      ()
      ())
   
   (:method (distributeIndGroupActivityByComps (?group . ?groups) (?c . ?comps))
      ()
      ((createLDIndividualGroupActivity ((?c s0k0)) (?group))
       (distributeIndGroupActivityByComps ?groups ?comps)))
   
