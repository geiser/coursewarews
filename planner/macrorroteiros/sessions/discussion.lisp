   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to modeling discussion session                ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:method (createLDDiscussionSession ?goals ?groups)
      ()
      ((createLDDiscussionSession! ?goals ?groups)))

   ;; mandatory
   (:method (createLDDiscussionSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (getPropertyValues ?skills ?u hasSkill)
       (getPropertyValues ?attits ?u hasAttitude) 
       (assign ?id (call BuildElement ((class UoL)
                                       (class DiscussionSession))
                         (call GetUUID ld)))
       (getPropertyValue ?res ?id hasResource)
       (getPropertyValue ?href ?res hasHref))
      ((!startLDElement unit-of-learning-href ((ref ?href)))
       (!startLDElement learning-design ((uri ?href) (level B) (identifier ?id))
               ((DiscussionSession UoL) ?id ?goals ?skills ?attits ?groups))
       (createLDTitle (DiscussionSession UoL) ?goals)
       (!startLDElement method)
       (createDiscussionSession ?goals ?groups)
       (!endLDElement method)
       (!endLDElement learning-design ?id)
       (!endLDElement unit-of-learning-href)))
   
   ;; fall-back
   (:method (createLDDiscussionSession ?goals ?groups)
      ((assign ?id (call GetUUID la)))
      ((!startLDElement learning-activity-ref ((ref ?id)))
       (startLDElement! learning-activity ((identifier ?id))
                        ((Discussion Session) ?id ?goals ?groups))
       (createLDTitle (Discussion Session) ?goals)
       (createDiscussionSession ?goals ?groups)
       (!endLDElement learning-activity ?id)
       (!endLDElement learning-activity-ref)))
   
   ;; Method to create session (TODO mandatory)
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createDiscussionSession ?goals ?groups)
      ()
      ((createDiscussionSession! ?goals ?groups)))
   
   ;; mandatory (in discussion phase)
   (:method (createDiscussionSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getRelateds ?cphases (?e) 3 isPartOf
                    ((class Phase)
                     (class Discussion)))
       (different ?cphases ())
       (getRelateds ?scripts ?cphases 1 isPartOf
                    ((class Script)))
       (getRelateds ?allphases ?scripts 1 inverseIsPartOf
                    ((class Phase)
                     (class Discussion)))
       (remove ?phases ?allphases ?cphases)
       (different ?phases ())
       ;; get resume discussion outputs
       (assign ?learners (call ConcatList ?groups))
       (getRelateds ?allresumes ?phases 4 inverseIsPartOf
                    ((class Output)
                     (class ResumeDiscussion)
                     (property hasParticipant ?learners)))
       (filterByQuery ?insertedresumes ?allresumes
                      ((property hasBeenSeen ?learners)))
       (remove ?resumes ?allresumes ?insertedresumes))
      ((createLDResumeDiscussionOutput ?goals ?groups)
       (createLDInputs ?resumes ?learners)
       (createDiscussionActivity ?goals ?groups)))
   
   ;; mandatory (in jigsaw phase)
   (:method (createDiscussionSession! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (assign ?learners (call ConcatList ?groups))
       (getRelateds ?cphases (?e) 3 isPartOf
                    ((class Phase)
                     (class Jigsaw)))
       (different ?cphases ())
       ;; get resumes from expert phase
       (getRelateds ?scripts ?cphases 1 isPartOf
                    ((class Script)))
       (getRelateds ?expphases ?scripts 1 inverseIsPartOf
                    ((class Phase)
                     (class Expert)))
       (getRelateds ?expresumes ?expphases 4 inverseIsPartOf
                    ((class Output)
                     (class ResumeDiscussion)
                     (property hasParticipant ?learners)))
       ;; get resumes from discussion session in jigsaw phase
       (getRelateds ?all-disresumes ?cphases 4 inverseIsPartOf
                    ((class Output)
                     (class ResumeDiscussion)
                     (property hasParticipant ?learners)))
       (filterByQuery ?inserted-disresumes ?all-disresumes
                      ((property hasBeenSeen ?learners)))
       (remove ?disresumes ?all-disresumes ?inserted-disresumes)
       (assign ?resumes (call ConcatList (?expresumes ?disresumes))))
      ((createLDResumeDiscussionOutput ?goals ?groups)
       (createLDInputs ?resumes ?learners)
       (createDiscussionActivity ?goals ?groups)))
   
   ;; fall-back
   (:method (createDiscussionSession ?goals ?groups)
      ()
      ((createLDResumeDiscussionOutput ?goals ?groups)
       (createDiscussionActivity ?goals ?groups)))
   
   ;; Method to create activity in ld
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createDiscussionActivity ?goals ?groups)
      ()
      ((createDiscussionActivity! ?goals ?groups)))
   
   ;; mandatory 
   (:method (createDiscussionActivity! ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType UoL ?e))
      ((createLDScriptCLScenario! ?goals ?groups)))
   
   ;; fall-back
   (:method (createDiscussionActivity ?goals ?groups)
      ((getElement ?e ((class CurrentLDElement)))
       (getType Session ?e))
      ((createLDDiscussionEnvironment ?goals ?groups)
       (createLDDiscussionSessionDescription ?goals ?groups)))
   
   ;; Method to create environment
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDiscussionEnvironment ?goals ?groups)
      ((assign ?id (call GetUUID env)))
      ((!startLDElement environment-ref ((ref ?id)))
       (!startLDElement environment ((identifier ?id))
                        ((Discussion Environment) ?id ?goals ?groups))
       (createLDTitle (Discussion Environment) ?goals)
       (createEnvironment ?goals ?groups)
       (!endLDElement environment ?id)
       (!endLDElement environment-ref)))
   
   ;; Method to create activity description
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDDiscussionSessionDescription ?goals ?groups)
      ()
      ((!startLDElement activity-description)
       (createDiscussionSessionDescription ?goals ?groups)
       (!endLDElement activity-description)))
   
   (:method (createDiscussionSessionDescription ?goals ?groups)
      ()
      ((createDiscussionSessionDescription! ?goals ?groups)))
   
   ;; mandatory
   (:method (createDiscussionSessionDescription! ?goals ?groups)
      ((getElement ?activity ((class DiscussionActivity)
                              (class SessionDescription))))
      ((createLDItem ?activity)))
   
   ;; fall-back
   (:method (createDiscussionSessionDescription ?goals ?groups)
      ((assign ?activity (call BuildElement ((class DiscussionActivity)
                                             (class SessionDescription)))))
      ((createLDItem ?activity)))
   
