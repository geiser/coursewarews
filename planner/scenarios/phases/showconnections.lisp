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
     
