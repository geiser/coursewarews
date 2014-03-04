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

