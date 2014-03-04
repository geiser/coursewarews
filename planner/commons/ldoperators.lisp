   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Operators and methods to modeling edition phase                       ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   (:operator (!startLDElement ?tag)
      ()
      ()
      ())
   
   (:operator (!startLDElement ?tag ?params)
      ()
      ()
      ())
   
   (:operator (!endLDElement ?tag)
      ()
      ()
      ())
   
   (:operator (!startLDElement ?tag ?params (?types ?id ?goals ?groups))
      ;; preconditions
      ((assign ?learners (call ConcatList ?groups))
       (getElements ?parents ((class CurrentLDElement))))
      ;; remove atoms
      ((forall (?e) ((class CurrentLDElement ?e))
               ((class CurrentLDElement ?e))))
      ;; add atoms
      ((forall (?t) ((exist ?t ?types))
               ((class ?t ?id)))
       (forall (?g) ((exist ?g ?goals) (first ?c ?g))
               ((property ?id hasGoal ?g)
                (property ?id hasCompetency ?c)))
       (forall (?l) ((exist ?l ?learners))
               ((property ?id hasParticipant ?l)))
       ;; parent fundamental competencies
       (forall (?p ?c) ((exist ?p ?parents)
                        (property ?p hasFundCompetency ?c))
               ((property ?id hasFundCompetency ?c)))
       ;; parent learning resource type
       (forall (?p ?t) ((exist ?p ?parents)
                        (property ?p hasLearningResourceType ?t))
               ((property ?id hasLearningResourceType ?t)))
       ;; parent clgrouping
       (forall (?p ?cn ?sn ?g ?ls)
               ((exist ?p ?parents)
                (property ?p hasCLGroupingTheory ?cn)
                (property ?p hasCLGroupingStrategy ?sn)
                (property ?p hasCLGroupingGoal (?sn ?g))
                (property ?p hasCLGroupingLearners (?sn ?ls)))
               ((property ?id hasCLGroupingTheory ?cn)
                (property ?id hasCLGroupingStrategy ?sn)
                (property ?id hasCLGroupingGoal (?sn ?g))
                (property ?id hasCLGroupingLearners (?sn ?ls))))
       ;; current uol
       (forall (?p ?u) ((exist ?p ?parents)
                        (property ?p hasCurrentUoL ?u))
               ((property ?id hasCurrentUoL ?u)))
       ;; relation
       (forall (?p) ((exist ?p ?parents))
               ((relation ?id isPartOf ?p)))
       (class CurrentLDElement ?id)))
   
   (:operator (!startLDElement ?tag ?params (?types ?id ?goals ?skills ?attits ?groups))
      ;; preconditions
      ((assign ?learners (call ConcatList ?groups))
       (getElements ?parents ((class CurrentLDElement))))
      ;; remove atoms
      ((forall (?e) ((class CurrentLDElement ?e))
               ((class CurrentLDElement ?e))))
      ;; add ld information
      ((forall (?t) ((exist ?t ?types))
               ((class ?t ?id)))
       (forall (?g) ((exist ?g ?goals) (first ?c ?g))
               ((property ?id hasGoal ?g)
                (property ?id hasCompetency ?c)))
       (forall (?l) ((exist ?l ?learners))
               ((property ?id hasParticipant ?l)))
       ;; parent fundamental competencies
       (forall (?p ?c) ((exist ?p ?parents)
                        (property ?p hasFundCompetency ?c))
               ((property ?id hasFundCompetency ?c)))
       ;; parent learning resource type
       (forall (?p ?t) ((exist ?p ?parents)
                        (property ?p hasLearningResourceType ?t))
               ((property ?id hasLearningResourceType ?t)))
       ;; parent clgrouping
       (forall (?p ?cn ?sn ?g ?ls)
               ((exist ?p ?parents)
                (property ?p hasCLGroupingTheory ?cn)
                (property ?p hasCLGroupingStrategy ?sn)
                (property ?p hasCLGroupingGoal (?sn ?g))
                (property ?p hasCLGroupingLearners (?sn ?ls)))
               ((property ?id hasCLGroupingTheory ?cn)
                (property ?id hasCLGroupingStrategy ?sn)
                (property ?id hasCLGroupingGoal (?sn ?g))
                (property ?id hasCLGroupingLearners (?sn ?ls))))
       ;; skills and attitudes
       (forall (?s) ((exist ?s ?skills))
               ((property ?id hasSkill ?s)))
       (forall (?a) ((exist ?a ?attits))
               ((property ?id hasAttitude ?a)))
       ;; current uol
       (property ?id hasCurrentUoL ?id)
       ;; relation
       (forall (?p) ((exist ?p ?parents))
               ((relation ?id isPartOf ?p)))
       (class CurrentLDElement ?id))) 
   
   (:operator (!endLDElement ?tagname ?id)
      ;; preconditions
      ((getPropertyValues ?indGoals ?id hasIndGoal)
       (getPropertyValues ?ts ?id hasCLGroupingTheory)
       (getPropertyValues ?ss ?id hasCLGroupingStrategy)
       (getPropertyValues ?gs ?id hasCLGroupingGoal)
       (getPropertyValues ?Ps ?id hasCLGroupingLearners))
      ;; remove atoms
      ((forall (?cig) ((exist ?cig ?indGoals))
               ((property ?id hasIndGoal ?cig)))
       (forall (?l ?c ?is) ((exist ?lig ?indGoals)
                            (first ?l ?lig) (last ?ig ?lig) (first ?c ?ig)
                            (property ?l hasCompetencyLevel (?c ?is)))
               ((property ?l hasCompetencyLevel (?c ?is))))
       ;; cl grouping
       (forall (?t ?s ?g ?P) ((exist ?t ?ts) (exist ?s ?ss)
                              (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?id hasCLGroupingTheory ?t)
                (property ?id hasCLGroupingStrategy ?s)
                (property ?id hasCLGroupingGoal ?g)
                (property ?id hasCLGroupingLearners ?P)))
       ;; relation
       (forall (?e) ((class CurrentLDElement ?e))
               ((class CurrentLDElement ?e))))
      ;; add atoms
      ((forall (?l ?c ?s) ((exist ?lig ?indGoals)
                           (first ?l ?lig) (last ?ig ?lig)
                           (first ?c ?ig) (last ?g ?ig)
                           (getPropertyValue ?s ?g hasGoalStage))
               ((property ?l hasCompetencyLevel (?c ?s))))
       ;; relation
       (forall (?p) ((relation ?id isPartOf ?p))
               ((class CurrentLDElement ?p)))))
   
   ;; Method to start ld element included ind-goals
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (startLDElement! ?tag ?params (?types ?id ?goals ?groups))
      ((getIndGoals ?indGoals ?goals ?groups))
      ((!startLDElement ?tag ?params (?types ?id ?goals ?groups))
       ;(!!addInWorldState (changeIndGoals ?indGoals))
       (!!changeIndGoals ?indGoals)
       ))
   
   (:operator (!!changeIndGoals ?indGoals)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?cigs ?e hasIndGoal))
      ((forall (?cig) ((exist ?cig ?cigs))
               ((property ?e hasIndGoal ?cig))))
      ((forall (?ig) ((exist ?ig ?indGoals))
               ((property ?e hasIndGoal ?ig)))))
  
   ;; Operator to change the current ld element   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!changeCurrentLDElement ?elements)
      ((getElements ?currents ((class CurrentLDElement))))
      ((forall (?c) ((exist ?c ?currents))
               ((class CurrentLDElement ?c))))
      ((forall (?e) ((exist ?e ?elements))
               ((class CurrentLDElement ?e)))))

   ;; Operator to change learning resource type
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!changeLearningResourceType ?types)
      ((getElements ?elements ((class CurrentLDElement)))
       (getPropertyValues ?ctypes ?elements hasLearningResourceType))
      ((forall (?e ?ct) ((exist ?e ?elements) (exist ?ct ?ctypes))
               ((property ?e hasLearningResourceType ?ct))))
      ((forall (?e ?t) ((exist ?e ?elements) (exist ?t ?types))
               ((property ?e hasLearningResourceType ?t)))))
   
   ;; Operator to change fundamental competences
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!changeFundCompetency ?comp)
      ((getElements ?elements ((class CurrentLDElement))))
      ((forall (?e ?c) ((exist ?e ?elements)
                        (property ?e hasFundCompetency ?c))
               ((property ?e hasFundCompetency ?c))))
      ((forall (?e) ((exist ?e ?elements))
               ((property ?e hasFundCompetency ?comp)))))
   
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Operators and methods to modeling configuration phase                 ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; Methods and operator to add/remove user to/from groups
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (addUsersToGroup () ?group)
      ()
      ())
   
   (:method (addUsersToGroup (?user . ?users) ?group)
      ()
      ((!addUserToGroup ?user ?group)
       (addUsersToGroup ?users ?group)))
   
   (:operator (!addUserToGroup ?user ?group)
      ((not (property ?user hasGroup ?group)))
      ()
      ((property ?user hasGroup ?group)))
   
   ;;
   (:method (removeUsersFromGroup () ?group)
      ()
      ())
   
   (:method (removeUsersFromGroup (?user . ?users) ?group)
      ()
      ((!removeUserFromGroup ?user ?group)
       (removeUsersFromGroup ?users ?group)))
   
   (:operator (!removeUserFromGroup ?user ?group)
      ((property ?user hasGroup ?group))
      ((property ?user hasGroup ?group))
      ())
   
   ;; Method and operators for add/remove user to/from roles
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;; 
   (:method (addUsersToRole () ?role)
      ()
      ())
   
   (:method (addUsersToRole (?user . ?users) ?role)
      ()
      ((!addUserToRole ?user ?role)
       (addUsersToRole ?users ?role)))

   (:operator (!addUserToRole ?learner ?role)
      ((not (property ?learner hasRole ?role)))
      ()
      ((property ?learner hasRole ?role)))

   ;;
   (:method (removeUsersFromRole () ?role)
      ()
      ())
   
   (:method (removeUsersFromRole (?user . ?users) ?role)
      ()
      ((!removeUserFromRole ?user ?role)
       (removeUsersFromRole ?users ?role)))
   
   (:operator (!removeUserFromRole ?user ?role)
      ((property ?user hasRole ?role))
      ((property ?user hasRole ?role))
      ())
   
   ;; Operator to change cl grouping information
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

   (:operator (!!changeCLGrouping ())
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?ts ?e hasCLGroupingTheory)
       (getPropertyValues ?ss ?e hasCLGroupingStrategy)
       (getPropertyValues ?gs ?e hasCLGroupingGoal)
       (getPropertyValues ?Ps ?e hasCLGroupingLearners))
      ((forall (?t ?s ?g ?P)
               ((exist ?t ?ts) (exist ?s ?ss)
                (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal ?g)
                (property ?e hasCLGroupingLearners ?P))))
      ())
   
   (:operator (!!changeCLGrouping (independent ?sgPs))
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?ts ?e hasCLGroupingTheory)
       (getPropertyValues ?ss ?e hasCLGroupingStrategy)
       (getPropertyValues ?gs ?e hasCLGroupingGoal)
       (getPropertyValues ?Ps ?e hasCLGroupingLearners))
      ((forall (?t ?s ?g ?P)
               ((exist ?t ?ts) (exist ?s ?ss)
                (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal ?g)
                (property ?e hasCLGroupingLearners ?P))))
      ())
   
   (:operator (!!changeCLGrouping (?t ?sgPs))
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?cts ?e hasCLGroupingTheory)
       (getPropertyValues ?css ?e hasCLGroupingStrategy)
       (getPropertyValues ?cgs ?e hasCLGroupingGoal)
       (getPropertyValues ?cPs ?e hasCLGroupingLearners))
      ((forall (?ct ?cs ?cg ?cP)
               ((exist ?ct ?cts) (exist ?cs ?css)
                (exist ?cg ?cgs) (exist ?cP ?cPs))
               ((property ?e hasCLGroupingTheory ?ct)
                (property ?e hasCLGroupingStrategy ?cs)
                (property ?e hasCLGroupingGoal ?cg)
                (property ?e hasCLGroupingLearners ?cP))))
      ((forall (?s ?g ?P)
               ((exist ?sgP ?sgPs)
                (first ?s ?sgP) (rest ?gP ?sgP)
                (first ?g ?gP)  (last ?P ?gP))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal (?s ?g))
                (property ?e hasCLGroupingLearners (?s ?P))))))
   
   (:operator (!!changeCLGrouping ?id)
      ((getPropertyValues ?ts ?id hasCLGroupingTheory)
       (getPropertyValues ?ss ?id hasCLGroupingStrategy)
       (getPropertyValues ?gs ?id hasCLGroupingGoal)
       (getPropertyValues ?Ps ?id hasCLGroupingLearners)
       (getElement ?e ((class CurrentLDElement)))
       (getPropertyValues ?cts ?e hasCLGroupingTheory)
       (getPropertyValues ?css ?e hasCLGroupingStrategy)
       (getPropertyValues ?cgs ?e hasCLGroupingGoal)
       (getPropertyValues ?cPs ?e hasCLGroupingLearners))
      ((forall (?ct ?cs ?cg ?cP)
               ((exist ?ct ?cts) (exist ?cs ?css)
                (exist ?cg ?cgs) (exist ?cP ?cPs))
               ((property ?e hasCLGroupingTheory ?ct)
                (property ?e hasCLGroupingStrategy ?cs)
                (property ?e hasCLGroupingGoal ?cg)
                (property ?e hasCLGroupingLearners ?cP))))
      ((forall (?t ?s ?g ?P)
               ((exist ?t ?ts) (exist ?s ?ss)
                (exist ?g ?gs) (exist ?P ?Ps))
               ((property ?e hasCLGroupingTheory ?t)
                (property ?e hasCLGroupingStrategy ?s)
                (property ?e hasCLGroupingGoal ?g)
                (property ?e hasCLGroupingLearners ?P)))))
    
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Operators and methods to modeling instation phase***                  ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   
   ;; Operator to insert plain text
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!text ?types ?fparameters ?sparameters)
      ()
      ()
      ())
   
   ;; Methods and operator to insert elements
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!insertElement ?e ?learners)
      ()
      ()
      ((forall (?l) ((exist ?l ?learners))
               ((property ?e hasBeenSeen ?l)
                (property ?l hasAlreadySeen (?e true))))))
   
   ;; Methods and operator to insert a resource
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!insertResource ?r ?attributes)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL))
      ()
      ((insertedIn ?r ?u)))
   
   ;; Method to insert resource once only for resource
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (insertResourceOnce ?r)
      ((getElement ?e ((class CurrentLDElement)))
       (getPropertyValue ?u ?e hasCurrentUoL)
       (not (insertedIn ?r ?u))
       ;;
       (getPropertyValue ?type ?r hasType)
       (getPropertyValue ?href ?r hasHref))
      ((!insertResource ?r ((type ?type) (href ?href))))
      
      ;; fall-back
      ()
      ())
   
   ;; Operator to insert as already seen atoms
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:operator (!!addInWorldStateAsAlreadySeen ?elements ?learners)
      ()        
      ()
      ((forall (?l ?e) ((exist ?e ?elements)
                        (exist ?l ?learners))
               ((property ?e hasBeenSeen ?l)
                (property ?l hasAlreadySeen (?e true))))))
   
