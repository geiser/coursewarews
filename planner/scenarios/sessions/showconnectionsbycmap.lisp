   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling illustrate-with-example           ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowConnectionsByCMapSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (!startLDElement learning-activity ((identifier ?id))
                        ((ShowConnections ByCMap Session) ?id ?goals ?groups))
       (createLDTitle (ShowConnections ByCMap Session) ?goals)
       (createShowConnectionsByCMapSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; (TODO) - optional and mandatory
   (:method (createShowConnectionsByCMapSession ?goals ?groups)
      ()
      ((createShowConnectionsByCMapActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createShowConnectionsByCMapActivity ?goals ?groups)
      ()
      ((createLDShowConnectionsByCMapSessionDescription ?goals ?groups)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShowConnectionsByCMapSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createShowConnectionsByCMapSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   ;; optional
   (:method (createShowConnectionsByCMapSessionDescription ?goals ?groups)
      ()
      ((createShowConnectionsByCMapSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createShowConnectionsByCMapSessionDescription! ?goals ?groups)
      ((getCompsFromGoals ?comps ?goals)
       (getRelateds ?requieres ?comps isRequiredBy)
       (getRelateds ?invRequieres ?comps inverseIsRequiredBy)
       (buildPropertyQuery ?tmpQuery hasConnection ?c ?invRequieres ())
       (buildPropertyQuery ?query hasConnection ?c ?requieres
                     ((class ShowConnectionsByCMap)
                      (class SessionDescription) . ?tmpQuery))
       (getElement ?activity ?query))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createShowConnectionsByCMapSessionDescription ?goals ?groups)
      ((getCompsFromGoals ?comps ?goals)
       (getRelateds ?requieres ?comps isRequiredBy)
       (getRelateds ?invRequieres ?comps inverseIsRequiredBy)
       (buildPropertyQuery ?tmpQuery hasConnection ?c ?invRequieres ())
       (buildPropertyQuery ?query hasConnection ?c ?requieres
                     ((class ShowConnectionsByCMap)
                      (class SessionDescription) . ?tmpQuery))
       (assign ?activity (call BuildElement ?query)))
      ((createLDItem ?activity)))

