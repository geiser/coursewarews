   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Axions and methods used to create ld item                             ;;
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDItem ?e)
      ()
      ((createLDItem! ?e)))
   
   (:method (createLDItem! ?e)
      ((getPropertyValue ?r ?e hasResource))
      ((!startLDElement item ((identifier (call GetUUID item))
                              (identifierref ?r)))
       (createLDTitle (Resource) () (?e))
       (insertResourceOnce ?r)
       (!endLDElement item)))

   (:method (createLDItem ?e)
      ()
      ((createLDItem fall-back ?e)))
   
   ;;
   (:method (distributeItem ())
      ()
      ())
   
   (:method (distributeItem (?e . ?elements))
      ()
      ((createLDItem ?e)
       (distributeItem ?elements)))
   
   ;; Method to create ld item with learners
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDItem ?e ?learners)
      ((getPropertyValue ?r ?e hasResource))
      ((!startLDElement item ((identifier (call GetUUID item))
                              (identifierref ?r)))
       (createLDTitle (Resource) () (?e))
       (!insertElement ?e ?learners)
       (insertResourceOnce ?r)
       (!endLDElement item)))
   
   ;;
   (:method (distributeItem () ?learners)
      ()
      ())
   
   (:method (distributeItem (?e . ?elements) ?learners)
      ()
      ((createLDItem ?e ?learners)
       (distributeItem ?elements ?learners)))
   
   ;; Method to create instructional item
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDInstructItem ?e ?learners)
      ((getPropertyValue ?r ?e hasResource)
       (assign ?id (call GetUUID item)))
      ((!startLDElement item ((identifier ?id) (identifierref ?r))
                        ((ILEventItem Instructional Item) ?id () (?learners)))
       (createLDTitle (Instructional Item) () (?e))
       (insertResourceOnce ?r)
       (!endLDElement item ?id)))
   
   ;; Method to create learning item
   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   (:method (createLDLearningItem ?e ?learners)
      ((getPropertyValue ?r ?e hasResource)
       (assign ?id (call GetUUID item)))
      ((!startLDElement item ((identifier ?id) (identifierref ?r))
                        ((ILEventItem Learning Item) ?id () (?learners)))
       (createLDTitle (Learning Item) () (?e))
       (insertResourceOnce ?r)
       (!endLDElement item ?id)))
   
