   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling jigsaw session                    ;;
   ;; (TODO) - optional and mandatory                                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
  
   (:method (createLDShareSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Share Session) ?id ?goals ?groups))
       (createLDTitle (Share Session) ?goals)
       (createShareSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createShareSession ?goals ?groups)
      ()
      ((createShareSession! ?goals ?groups)))
   
   ;; mandatory (simulation)
   (:method (createShareSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?sessions (?e) 1 isPartOf
                    ((class Simulation)
                     (class Sessions)))
       (different ?sessions ())
       (assign ?learners (call ConcatList ?groups))
       (getRelateds ?results ?sessions 3 inverseIsPartOf
                    ((class Output)
                     (class Simulation)
                     (property hasParticipant ?learners)))) 
      ((createLDInputs ?results ?learners)
       (createShareActivity ?goals ?groups)))
   
   ;; mandatory (share)
   (:method (createShareSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (assign ?learners (call ConcatList ?groups))
       (getRelateds ?cphases (?e) 3 isPartOf
                    ((class Phase)
                     (class Share)))
       (different ?cphases ())
       ;; get solutions from pair phase
       (getRelateds ?scripts ?cphases 1 isPartOf
                    ((class Script)))
       (getRelateds ?pairphases ?scripts 1 inverseIsPartOf
                    ((class Pair)
                     (class Phase)))
       (getRelateds ?solutions ?pairphases 4 inverseIsPartOf
                    ((class Output)
                     (class Solution)
                     (property hasParticipant ?learners))))
      ((createLDInputs ?solutions ?learners)
       (createShareActivity ?goals ?groups)))
   
   ;; fall-back
   (:method (createShareSession ?goals ?groups)
      ()
      ((createShareActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;; (TODO) - optional and mandatory
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createShareActivity ?goals ?groups)
      ()
      ((createLDShareEnvironment ?goals ?groups)
       (createLDShareSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShareEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Share Environment) ?id ?goals ?groups))
       (createLDTitle (Share Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDShareSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createShareSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createShareSessionDescription ?goals ?groups)
      ()
      ((createShareSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createShareSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class ShareActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createShareSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class ShareActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
