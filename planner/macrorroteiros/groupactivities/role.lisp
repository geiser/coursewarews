   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling expert group activity             ;;
   ;; (TODO) - optional and mandatory for ld                                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDRoleGroupActivity ?goals ?groups)
      ((assign ?id (call GetUUID rp)))
      ((!startLDElement role-part ((identifier ?id))
                        ((Role GroupActivity) ?id ?goals ?groups))
       (createLDTitle (Role GroupActivity) ?goals)
       (createRoleGroupActivity ?goals ?groups)
       (!endLDElement role-part ?id)))
   
   (:method (createRoleGroupActivity ?goals ?groups)
      ()
      ((createLDGroup ?goals ?groups)
       (createLDRoleSessions ?goals ?groups)))
   
   ;;
   (:method (createLDRoleSessions ?goals ?groups)
      ((assign ?id (call GetUUID as)))
      ((!startLDElement activity-structure-ref ((ref ?id)))
       (!startLDElement activity-structure ((identifier ?id)
                                            (structure-type sequence))
                        ((Role Sessions) ?id ?goals ?groups))
       (createLDTitle (Role Sessions) ?goals)
       (createRoleSessions ?goals ?groups)
       (!endLDElement activity-structure ?id)
       (!endLDElement activity-structure-ref)))
   
   (:method (createRoleSessions ?goals ?groups)
      ()
      ((createLDRoleSession ?goals ?groups)))
   
