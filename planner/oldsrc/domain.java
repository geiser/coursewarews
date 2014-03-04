import com.gamalocus.jshop2rt.*;

public class domain extends Domain
{
	private static final long serialVersionUID = 5886858055961168911L;


	/**
	 * Operator #-1 for primitive task !startLDElement
	 * Source: (line:62, col:4) to (line:65, col:9)
	 */
	public static class Operator0 extends Operator
{
	/**
	 * Operator #-1 for primitive task !startLDElement
	 */
		public Operator0(Domain owner)
		{
			super(owner, new Predicate(0, 1, new TermList(owner.getTermVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[0];

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[0];

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !startLDElement [line:62,4 to 65,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNil(1)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !startLDElement
	 * Source: (line:67, col:4) to (line:70, col:9)
	 */
	public static class Operator1 extends Operator
{
	/**
	 * Operator #-1 for primitive task !startLDElement
	 */
		public Operator1(Domain owner)
		{
			super(owner, new Predicate(0, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[0];

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[0];

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !startLDElement [line:67,4 to 70,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNil(2)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !endLDElement
	 * Source: (line:72, col:4) to (line:75, col:9)
	 */
	public static class Operator2 extends Operator
{
	/**
	 * Operator #-1 for primitive task !endLDElement
	 */
		public Operator2(Domain owner)
		{
			super(owner, new Predicate(1, 1, new TermList(owner.getTermVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[0];

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[0];

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !endLDElement [line:72,4 to 75,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNil(1)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !startLDElement
	 * Source: (line:77, col:4) to (line:84, col:31)
	 */
	public static class Operator3 extends Operator
{
	/**
	 * Operator #-1 for primitive task !startLDElement
	 */
		public Operator3(Domain owner)
		{
			super(owner, new Predicate(0, 9, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(5), TermList.NIL)))), TermList.NIL)))), -1, -1, new TermNumber(1.0));

			Term[] unifier;


			DelAddElement[] delIn = new DelAddElement[1];
			delIn[0] = new DelAddAtomic(new Predicate(15, 9, new TermList(owner.getTermVariable(6), TermList.NIL)));

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[5];
			addIn[0] = new DelAddAtomic(new Predicate(16, 9, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))));
			addIn[1] = new DelAddAtomic(new Predicate(18, 9, new TermList(owner.getTermVariable(3), new TermList(owner.getTermConstant(17) /*isPartOf*/, new TermList(owner.getTermVariable(6), TermList.NIL)))));
		// Add list of DelAddElement #3 of Operator #-1 for primitive task !startLDElement
		unifier = new Term[9];

		unifier[0] = null;
		unifier[1] = null;
		unifier[2] = null;
		unifier[3] = null;
		unifier[4] = null;
		unifier[5] = null;
		unifier[6] = null;
		unifier[7] = null;
		unifier[8] = null;

		Predicate[] atoms0 = {
			new Predicate(20, 9, new TermList(owner.getTermVariable(3), new TermList(owner.getTermConstant(19) /*hasGoal*/, new TermList(owner.getTermVariable(7), TermList.NIL)))) };
			addIn[2] = new DelAddForAll(new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(7), new TermList(owner.getTermVariable(4), TermList.NIL))), unifier), atoms0);
		// Add list of DelAddElement #4 of Operator #-1 for primitive task !startLDElement
		unifier = new Term[9];

		unifier[0] = null;
		unifier[1] = null;
		unifier[2] = null;
		unifier[3] = null;
		unifier[4] = null;
		unifier[5] = null;
		unifier[6] = null;
		unifier[7] = null;
		unifier[8] = null;

		Predicate[] atoms1 = {
			new Predicate(20, 9, new TermList(owner.getTermVariable(3), new TermList(owner.getTermConstant(21) /*hasParticipant*/, new TermList(owner.getTermVariable(8), TermList.NIL)))) };
			addIn[3] = new DelAddForAll(new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(5), TermList.NIL))), unifier), atoms1);
			addIn[4] = new DelAddAtomic(new Predicate(15, 9, new TermList(owner.getTermVariable(3), TermList.NIL)));

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !startLDElement [line:77,4 to 84,31]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionAtomic(new Predicate(15, 9, new TermList(owner.getTermVariable(6), TermList.NIL)), unifier)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Precondition of Operator #-1 for primitive task !endLDElement
	 * Source: (line:87, col:7) to (line:88, col:34)
	 */
	public static class Precondition4 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition4(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:87, col:8) to (line:87, col:29)
			p[1] = new PreconditionAtomic(new Predicate(15, 5, new TermList(owner.getTermVariable(1), TermList.NIL)), unifier);
			// Source: (line:88, col:8) to (line:88, col:33)
			p[2] = new PreconditionAtomic(new Predicate(18, 5, new TermList(owner.getTermVariable(1), new TermList(owner.getTermConstant(17) /*isPartOf*/, new TermList(owner.getTermVariable(3), TermList.NIL)))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of Operator #-1 for primitive task !endLDElement [line:87,7 to 88,34]";
		}
	}

	/**
	 * Operator #-1 for primitive task !endLDElement
	 * Source: (line:86, col:4) to (line:91, col:30)
	 */
	public static class Operator4 extends Operator
{
	/**
	 * Operator #-1 for primitive task !endLDElement
	 */
		public Operator4(Domain owner)
		{
			super(owner, new Predicate(1, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), -1, -1, new TermNumber(1.0));

			Term[] unifier;


			DelAddElement[] delIn = new DelAddElement[1];
			delIn[0] = new DelAddAtomic(new Predicate(15, 5, new TermList(owner.getTermVariable(1), TermList.NIL)));

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[2];
		// Add list of DelAddElement #1 of Operator #-1 for primitive task !endLDElement
		unifier = new Term[5];

		unifier[0] = null;
		unifier[1] = null;
		unifier[2] = null;
		unifier[3] = null;
		unifier[4] = null;

		Predicate[] atoms2 = {
			new Predicate(20, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermConstant(22) /*hasAlreadySeen*/, new TermList(owner.getTermVariable(1), TermList.NIL)))) };
			addIn[0] = new DelAddForAll(new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier), atoms2);
			addIn[1] = new DelAddAtomic(new Predicate(15, 5, new TermList(owner.getTermVariable(3), TermList.NIL)));

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !endLDElement [line:86,4 to 91,30]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new Precondition4(owner, unifier)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !text
	 * Source: (line:93, col:4) to (line:96, col:9)
	 */
	public static class Operator5 extends Operator
{
	/**
	 * Operator #-1 for primitive task !text
	 */
		public Operator5(Domain owner)
		{
			super(owner, new Predicate(2, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[0];

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[0];

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !text [line:93,4 to 96,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNil(2)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !addUserToGroup
	 * Source: (line:106, col:4) to (line:109, col:41)
	 */
	public static class Operator6 extends Operator
{
	/**
	 * Operator #-1 for primitive task !addUserToGroup
	 */
		public Operator6(Domain owner)
		{
			super(owner, new Predicate(3, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[0];

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[1];
			addIn[0] = new DelAddAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(23) /*hasGroup*/, new TermList(owner.getTermVariable(1), TermList.NIL)))));

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !addUserToGroup [line:106,4 to 109,41]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNegation(new PreconditionAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(23) /*hasGroup*/, new TermList(owner.getTermVariable(1), TermList.NIL)))), unifier), 2)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !removeUserFromGroup
	 * Source: (line:117, col:4) to (line:120, col:9)
	 */
	public static class Operator7 extends Operator
{
	/**
	 * Operator #-1 for primitive task !removeUserFromGroup
	 */
		public Operator7(Domain owner)
		{
			super(owner, new Predicate(4, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[1];
			delIn[0] = new DelAddAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(23) /*hasGroup*/, new TermList(owner.getTermVariable(1), TermList.NIL)))));

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[0];

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !removeUserFromGroup [line:117,4 to 120,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(23) /*hasGroup*/, new TermList(owner.getTermVariable(1), TermList.NIL)))), unifier)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !addUserToRole
	 * Source: (line:130, col:4) to (line:133, col:42)
	 */
	public static class Operator8 extends Operator
{
	/**
	 * Operator #-1 for primitive task !addUserToRole
	 */
		public Operator8(Domain owner)
		{
			super(owner, new Predicate(5, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[0];

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[1];
			addIn[0] = new DelAddAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(24) /*hasRole*/, new TermList(owner.getTermVariable(1), TermList.NIL)))));

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !addUserToRole [line:130,4 to 133,42]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNegation(new PreconditionAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(24) /*hasRole*/, new TermList(owner.getTermVariable(1), TermList.NIL)))), unifier), 2)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !removeUserFromRole
	 * Source: (line:141, col:4) to (line:144, col:9)
	 */
	public static class Operator9 extends Operator
{
	/**
	 * Operator #-1 for primitive task !removeUserFromRole
	 */
		public Operator9(Domain owner)
		{
			super(owner, new Predicate(6, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[1];
			delIn[0] = new DelAddAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(24) /*hasRole*/, new TermList(owner.getTermVariable(1), TermList.NIL)))));

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[0];

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !removeUserFromRole [line:141,4 to 144,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionAtomic(new Predicate(20, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(24) /*hasRole*/, new TermList(owner.getTermVariable(1), TermList.NIL)))), unifier)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !!addInWorldState
	 * Source: (line:148, col:4) to (line:151, col:14)
	 */
	public static class Operator10 extends Operator
{
	/**
	 * Operator #-1 for primitive task !!addInWorldState
	 */
		public Operator10(Domain owner)
		{
			super(owner, new Predicate(7, 1, new TermList(owner.getTermVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[0];

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[1];
			addIn[0] = new DelAddAtomic(new Predicate(0, 1));

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !!addInWorldState [line:148,4 to 151,14]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNil(1)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Operator #-1 for primitive task !!removeFromWorldState
	 * Source: (line:153, col:4) to (line:156, col:9)
	 */
	public static class Operator11 extends Operator
{
	/**
	 * Operator #-1 for primitive task !!removeFromWorldState
	 */
		public Operator11(Domain owner)
		{
			super(owner, new Predicate(8, 1, new TermList(owner.getTermVariable(0), TermList.NIL)), -1, -1, new TermNumber(1.0));


			DelAddElement[] delIn = new DelAddElement[1];
			delIn[0] = new DelAddAtomic(new Predicate(0, 1));

			setDel(delIn);

			DelAddElement[] addIn = new DelAddElement[0];

			setAdd(addIn);
		}

		@Override
		public String toString()
		{
			return "Operator #-1 for primitive task !!removeFromWorldState [line:153,4 to 156,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			p = (new PreconditionNil(1)).setComparator(null);
			p.reset(state);

			return p;
		}
	}

	/**
	 * Method -1 for compound task addUsersToGroup
	 * Source: (line:100, col:4) to (line:100, col:45)
	 */
	public static class Method0 extends Method
	{
	/**
	 * Method -1 for compound task addUsersToGroup
	 */
		public Method0(Domain owner)
		{
			super(owner, new Predicate(0, 1, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task addUsersToGroup [line:100,4 to 100,45]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method0Branch0(text:addUsersToGroup,line:100,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task addUsersToGroup
	 * Source: (line:101, col:4) to (line:104, col:40)
	 */
	public static class Method1 extends Method
	{
	/**
	 * Method -1 for compound task addUsersToGroup
	 */
		public Method1(Domain owner)
		{
			super(owner, new Predicate(0, 3, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(3, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task addUsersToGroup [line:101,4 to 104,40]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method1Branch0(text:addUsersToGroup,line:101,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task removeUsersFromGroup
	 * Source: (line:111, col:4) to (line:111, col:50)
	 */
	public static class Method2 extends Method
	{
	/**
	 * Method -1 for compound task removeUsersFromGroup
	 */
		public Method2(Domain owner)
		{
			super(owner, new Predicate(1, 1, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task removeUsersFromGroup [line:111,4 to 111,50]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method2Branch0(text:removeUsersFromGroup,line:111,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task removeUsersFromGroup
	 * Source: (line:112, col:4) to (line:115, col:45)
	 */
	public static class Method3 extends Method
	{
	/**
	 * Method -1 for compound task removeUsersFromGroup
	 */
		public Method3(Domain owner)
		{
			super(owner, new Predicate(1, 3, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(4, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task removeUsersFromGroup [line:112,4 to 115,45]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method3Branch0(text:removeUsersFromGroup,line:112,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task addUsersToRole
	 * Source: (line:124, col:4) to (line:124, col:43)
	 */
	public static class Method4 extends Method
	{
	/**
	 * Method -1 for compound task addUsersToRole
	 */
		public Method4(Domain owner)
		{
			super(owner, new Predicate(2, 1, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task addUsersToRole [line:124,4 to 124,43]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method4Branch0(text:addUsersToRole,line:124,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task addUsersToRole
	 * Source: (line:125, col:4) to (line:128, col:38)
	 */
	public static class Method5 extends Method
	{
	/**
	 * Method -1 for compound task addUsersToRole
	 */
		public Method5(Domain owner)
		{
			super(owner, new Predicate(2, 3, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(5, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task addUsersToRole [line:125,4 to 128,38]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method5Branch0(text:addUsersToRole,line:125,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task removeUsersFromRole
	 * Source: (line:135, col:4) to (line:135, col:48)
	 */
	public static class Method6 extends Method
	{
	/**
	 * Method -1 for compound task removeUsersFromRole
	 */
		public Method6(Domain owner)
		{
			super(owner, new Predicate(3, 1, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task removeUsersFromRole [line:135,4 to 135,48]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method6Branch0(text:removeUsersFromRole,line:135,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task removeUsersFromRole
	 * Source: (line:136, col:4) to (line:139, col:43)
	 */
	public static class Method7 extends Method
	{
	/**
	 * Method -1 for compound task removeUsersFromRole
	 */
		public Method7(Domain owner)
		{
			super(owner, new Predicate(3, 3, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(6, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(3, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task removeUsersFromRole [line:136,4 to 139,43]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method7Branch0(text:removeUsersFromRole,line:136,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createLDUoL
	 * Source: (line:469, col:4) to (line:475, col:54)
	 */
	public static class Method8 extends Method
	{
	/**
	 * Method -1 for compound task createLDUoL
	 */
		public Method8(Domain owner)
		{
			super(owner, new Predicate(5, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(5, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(58) /*learning-design*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(60) /*UoL*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(61) /*method*/, TermList.NIL)), false, true));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(4, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(61) /*method*/, TermList.NIL)), false, true));
			retVal.subtasks[4] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(58) /*learning-design*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDUoL [line:469,4 to 475,54]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method8Branch0(text:createLDUoL,line:469,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createUoL
	 * Source: (line:478, col:7) to (line:482, col:60)
	 */
	public static class Precondition34 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition34(Domain owner, Term[] unifier)
		{
			p = new Precondition[6];
			// Source: (line:478, col:8) to (line:478, col:53)
			p[1] = new PreconditionAtomic(new Predicate(29, 7, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(0), new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(62) /*Skill*/, TermList.NIL)), TermList.NIL), TermList.NIL)))), unifier);
			// Source: (line:479, col:8) to (line:479, col:59)
			p[2] = new PreconditionAtomic(new Predicate(29, 7, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(0), new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(63) /*Attitude*/, TermList.NIL)), TermList.NIL), TermList.NIL)))), unifier);
			// Source: (line:480, col:8) to (line:480, col:73)
			p[3] = new PreconditionAssign(new TermCall(new List(new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), unifier, 4);
			// Source: (line:481, col:8) to (line:481, col:66)
			p[4] = new PreconditionAtomic(new Predicate(10, 7, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			// Source: (line:482, col:8) to (line:482, col:59)
			p[5] = new PreconditionAtomic(new Predicate(56, 7, new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(5), new TermList(owner.getTermConstant(43) /*isRequiredBy*/, TermList.NIL)))), unifier);
			b = new Term[6][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[5] == null)
			{
				boolean b4changed = false;
				while (b[4] == null)
				{
					boolean b3changed = false;
					while (b[3] == null)
					{
						boolean b2changed = false;
						while (b[2] == null)
						{
							boolean b1changed = false;
							while (b[1] == null)
							{
								b[1] = p[1].nextBinding(state);
								if (b[1] == null)
									return null;
								else
									bestMatch = Math.max(bestMatch, 1);
								b1changed = true;
							}
							if ( b1changed ) {
								p[2].reset(state);
								p[2].bind(Term.merge(b, 2));
							}
							b[2] = p[2].nextBinding(state);
							if (b[2] == null)
								b[1] = null;
							else
								bestMatch = Math.max(bestMatch, 2);
							b2changed = true;
						}
						if ( b2changed ) {
							p[3].reset(state);
							p[3].bind(Term.merge(b, 3));
						}
						b[3] = p[3].nextBinding(state);
						if (b[3] == null)
							b[2] = null;
						else
							bestMatch = Math.max(bestMatch, 3);
						b3changed = true;
					}
					if ( b3changed ) {
						p[4].reset(state);
						p[4].bind(Term.merge(b, 4));
					}
					b[4] = p[4].nextBinding(state);
					if (b[4] == null)
						b[3] = null;
					else
						bestMatch = Math.max(bestMatch, 4);
					b4changed = true;
				}
				if ( b4changed ) {
					p[5].reset(state);
					p[5].bind(Term.merge(b, 5));
				}
				b[5] = p[5].nextBinding(state);
				if (b[5] == null)
					b[4] = null;
				else
					bestMatch = Math.max(bestMatch, 5);
			}

			Term[] retVal = Term.merge(b, 6);
			b[5] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			p[5].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createUoL [line:478,7 to 482,60]";
		}
	}

	/**
	 * Method -1 for compound task createUoL
	 * Source: (line:477, col:4) to (line:483, col:64)
	 */
	public static class Method9 extends Method
	{
	/**
	 * Method -1 for compound task createUoL
	 */
		public Method9(Domain owner)
		{
			super(owner, new Predicate(4, 7, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(1, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(6, 7, new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(1), TermList.NIL)))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createUoL [line:477,4 to 483,64]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition34(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method9Branch0(text:createUoL,line:477,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task distributeUoL
	 * Source: (line:485, col:4) to (line:485, col:64)
	 */
	public static class Method10 extends Method
	{
	/**
	 * Method -1 for compound task distributeUoL
	 */
		public Method10(Domain owner)
		{
			super(owner, new Predicate(6, 2, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task distributeUoL [line:485,4 to 485,64]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(2)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method10Branch0(text:distributeUoL,line:485,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task distributeUoL
	 * Source: (line:486, col:4) to (line:489, col:60)
	 */
	public static class Method11 extends Method
	{
	/**
	 * Method -1 for compound task distributeUoL
	 */
		public Method11(Domain owner)
		{
			super(owner, new Predicate(6, 4, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(7, 4, new TermList(new TermCall(new List(owner.getTermConstant(64) /*play*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(2)), new TermList(owner.getTermVariable(3), TermList.NIL)))), false, false));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(6, 4, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL)))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task distributeUoL [line:486,4 to 489,60]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(4)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method11Branch0(text:distributeUoL,line:486,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createLDScript
	 * Source: (line:493, col:4) to (line:498, col:43)
	 */
	public static class Method12 extends Method
	{
	/**
	 * Method -1 for compound task createLDScript
	 */
		public Method12(Domain owner)
		{
			super(owner, new Predicate(7, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 4, new TermList(owner.getTermConstant(64) /*play*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(65) /*Script*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(8, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 4, new TermList(owner.getTermConstant(64) /*play*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDScript [line:493,4 to 498,43]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(2, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(1), TermList.NIL))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method12Branch0(text:createLDScript,line:493,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task distributeGroupActivity
	 * Source: (line:502, col:4) to (line:504, col:9)
	 */
	public static class Method13 extends Method
	{
	/**
	 * Method -1 for compound task distributeGroupActivity
	 */
		public Method13(Domain owner)
		{
			super(owner, new Predicate(9, 1, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task distributeGroupActivity [line:502,4 to 504,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method13Branch0(text:distributeGroupActivity,line:502,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task distributeGroupActivity
	 * Source: (line:506, col:4) to (line:509, col:49)
	 */
	public static class Method14 extends Method
	{
	/**
	 * Method -1 for compound task distributeGroupActivity
	 */
		public Method14(Domain owner)
		{
			super(owner, new Predicate(9, 3, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(10, 3, new TermList(new TermCall(new List(owner.getTermConstant(66) /*rp*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL)))), false, false));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(9, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task distributeGroupActivity [line:506,4 to 509,49]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method14Branch0(text:distributeGroupActivity,line:506,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createLDGroupActivity
	 * Source: (line:514, col:7) to (line:515, col:38)
	 */
	public static class Precondition35 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition35(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:514, col:8) to (line:514, col:43)
			p[1] = new PreconditionAssign(new TermCall(new List(owner.getTermConstant(67) /*group*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), unifier, 3);
			// Source: (line:515, col:8) to (line:515, col:37)
			p[2] = new PreconditionAssign(new TermCall(new List(owner.getTermConstant(68) /*as*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), unifier, 4);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createLDGroupActivity [line:514,7 to 515,38]";
		}
	}

	/**
	 * Method -1 for compound task createLDGroupActivity
	 * Source: (line:513, col:4) to (line:525, col:48)
	 */
	public static class Method15 extends Method
	{
	/**
	 * Method -1 for compound task createLDGroupActivity
	 */
		public Method15(Domain owner)
		{
			super(owner, new Predicate(10, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(10, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 5, new TermList(owner.getTermConstant(69) /*role-part*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(70) /*GroupActivity*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 5, new TermList(owner.getTermConstant(71) /*role-ref*/, new TermList(new TermList(new TermList(owner.getTermConstant(72) /*ref*/, new TermList(owner.getTermVariable(3), TermList.NIL)), TermList.NIL), TermList.NIL))), false, true));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(0, 5, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))), false, false));
			retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(owner.getTermConstant(71) /*role-ref*/, TermList.NIL)), false, true));
			retVal.subtasks[4] = new TaskList(new TaskAtom(new Predicate(0, 5, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, new TermList(new TermList(new TermList(owner.getTermConstant(72) /*ref*/, new TermList(owner.getTermVariable(4), TermList.NIL)), TermList.NIL), TermList.NIL))), false, true));
			retVal.subtasks[5] = new TaskList(new TaskAtom(new Predicate(0, 5, new TermList(owner.getTermConstant(74) /*activity-structure*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(4), TermList.NIL)), TermList.NIL), TermList.NIL))), false, true));
			retVal.subtasks[6] = new TaskList(new TaskAtom(new Predicate(11, 5, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[7] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(owner.getTermConstant(74) /*activity-structure*/, TermList.NIL)), false, true));
			retVal.subtasks[8] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, TermList.NIL)), false, true));
			retVal.subtasks[9] = new TaskList(new TaskAtom(new Predicate(1, 5, new TermList(owner.getTermConstant(69) /*role-part*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDGroupActivity [line:513,4 to 525,48]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition35(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method15Branch0(text:createLDGroupActivity,line:513,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createGroupActivity
	 * Source: (line:527, col:4) to (line:527, col:52)
	 */
	public static class Method16 extends Method
	{
	/**
	 * Method -1 for compound task createGroupActivity
	 */
		public Method16(Domain owner)
		{
			super(owner, new Predicate(11, 1, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createGroupActivity [line:527,4 to 527,52]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method16Branch0(text:createGroupActivity,line:527,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createGroupActivity
	 * Source: (line:529, col:7) to (line:531, col:45)
	 */
	public static class Precondition36 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition36(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:529, col:8) to (line:529, col:29)
			p[1] = new PreconditionAtomic(new Predicate(1, 4, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, TermList.NIL))), unifier);
			// Source: (line:530, col:8) to (line:530, col:63)
			p[2] = new PreconditionAtomic(new Predicate(54, 4, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(43) /*isRequiredBy*/, TermList.NIL)))), unifier);
			// Source: (line:531, col:8) to (line:531, col:44)
			p[3] = new PreconditionAtomic(new Predicate(10, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createGroupActivity [line:529,7 to 531,45]";
		}
	}

	/**
	 * Method -1 for compound task createGroupActivity
	 * Source: (line:528, col:4) to (line:533, col:46)
	 */
	public static class Method17 extends Method
	{
	/**
	 * Method -1 for compound task createGroupActivity
	 */
		public Method17(Domain owner)
		{
			super(owner, new Predicate(11, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(12, 4, new TermList(new TermCall(new List(owner.getTermConstant(68) /*as*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(1), TermList.NIL)))), false, false));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(11, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(1), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createGroupActivity [line:528,4 to 533,46]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition36(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method17Branch0(text:createGroupActivity,line:528,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createLDSessions
	 * Source: (line:537, col:4) to (line:542, col:47)
	 */
	public static class Method18 extends Method
	{
	/**
	 * Method -1 for compound task createLDSessions
	 */
		public Method18(Domain owner)
		{
			super(owner, new Predicate(12, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(4, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 4, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, new TermList(new TermList(new TermList(owner.getTermConstant(72) /*ref*/, new TermList(owner.getTermVariable(3), TermList.NIL)), TermList.NIL), TermList.NIL))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 4, new TermList(owner.getTermConstant(74) /*activity-structure*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), new TermList(new TermList(owner.getTermConstant(75) /*structure-type*/, new TermList(owner.getTermConstant(76) /*selection*/, TermList.NIL)), TermList.NIL)), TermList.NIL))), false, true));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(13, 4, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(1, 4, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, TermList.NIL)), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDSessions [line:537,4 to 542,47]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermConstant(68) /*as*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), unifier, 3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method18Branch0(text:createLDSessions,line:537,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createSessions
	 * Source: (line:544, col:4) to (line:544, col:47)
	 */
	public static class Method19 extends Method
	{
	/**
	 * Method -1 for compound task createSessions
	 */
		public Method19(Domain owner)
		{
			super(owner, new Predicate(13, 1, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createSessions [line:544,4 to 544,47]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method19Branch0(text:createSessions,line:544,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createSessions
	 * Source: (line:545, col:4) to (line:548, col:42)
	 */
	public static class Method20 extends Method
	{
	/**
	 * Method -1 for compound task createSessions
	 */
		public Method20(Domain owner)
		{
			super(owner, new Predicate(13, 3, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(14, 3, new TermList(new TermCall(new List(owner.getTermConstant(68) /*as*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, false));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(13, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createSessions [line:545,4 to 548,42]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method20Branch0(text:createSessions,line:545,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createLDSession
	 * Source: (line:554, col:7) to (line:558, col:38)
	 */
	public static class Precondition37 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition37(Domain owner, Term[] unifier)
		{
			p = new Precondition[5];
			// Source: (line:554, col:8) to (line:555, col:58)
			p[1] = new PreconditionAtomic(new Predicate(35, 7, new TermList(owner.getTermVariable(4), new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(77) /*CognitiveCompetency*/, TermList.NIL)), new TermList(new TermList(owner.getTermConstant(18) /*relation*/, new TermList(owner.getTermConstant(17) /*isPartOf*/, new TermList(owner.getTermVariable(1), TermList.NIL))), TermList.NIL)), TermList.NIL))), unifier);
			// Source: (line:556, col:8) to (line:556, col:31)
			p[2] = new PreconditionAtomic(new Predicate(1, 7, new TermList(owner.getTermVariable(4), new TermList(TermList.NIL, TermList.NIL))), unifier);
			// Source: (line:557, col:8) to (line:557, col:66)
			p[3] = new PreconditionAssign(new TermCall(new List(owner.getTermVariable(4), new TermList(new TermList(owner.getTermVariable(2), TermList.NIL), TermList.NIL)), ((domain)owner).calculateGetProduct, "((domain)owner).calculateGetProduct"), unifier, 5);
			// Source: (line:558, col:8) to (line:558, col:37)
			p[4] = new PreconditionAssign(new TermCall(new List(owner.getTermConstant(68) /*as*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), unifier, 6);
			b = new Term[5][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[4] == null)
			{
				boolean b3changed = false;
				while (b[3] == null)
				{
					boolean b2changed = false;
					while (b[2] == null)
					{
						boolean b1changed = false;
						while (b[1] == null)
						{
							b[1] = p[1].nextBinding(state);
							if (b[1] == null)
								return null;
							else
								bestMatch = Math.max(bestMatch, 1);
							b1changed = true;
						}
						if ( b1changed ) {
							p[2].reset(state);
							p[2].bind(Term.merge(b, 2));
						}
						b[2] = p[2].nextBinding(state);
						if (b[2] == null)
							b[1] = null;
						else
							bestMatch = Math.max(bestMatch, 2);
						b2changed = true;
					}
					if ( b2changed ) {
						p[3].reset(state);
						p[3].bind(Term.merge(b, 3));
					}
					b[3] = p[3].nextBinding(state);
					if (b[3] == null)
						b[2] = null;
					else
						bestMatch = Math.max(bestMatch, 3);
					b3changed = true;
				}
				if ( b3changed ) {
					p[4].reset(state);
					p[4].bind(Term.merge(b, 4));
				}
				b[4] = p[4].nextBinding(state);
				if (b[4] == null)
					b[3] = null;
				else
					bestMatch = Math.max(bestMatch, 4);
			}

			Term[] retVal = Term.merge(b, 5);
			b[4] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createLDSession [line:554,7 to 558,38]";
		}
	}

	/**
	 * Method -1 for compound task createLDSession
	 * Source: (line:552, col:4) to (line:581, col:61)
	 */
	public static class Method21 extends Method
	{
	/**
	 * Method -1 for compound task createLDSession
	 */
		public Method21(Domain owner)
		{
			super(owner, new Predicate(14, 7, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), new TermList(owner.getTermVariable(3), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[2];

			subsIn[0] = createTaskList0();
			subsIn[1] = createTaskList1();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(10, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, new TermList(new TermList(new TermList(owner.getTermConstant(72) /*ref*/, new TermList(owner.getTermVariable(6), TermList.NIL)), TermList.NIL), TermList.NIL))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(owner.getTermConstant(74) /*activity-structure*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(6), TermList.NIL)), new TermList(new TermList(owner.getTermConstant(75) /*structure-type*/, new TermList(owner.getTermConstant(78) /*sequence*/, TermList.NIL)), TermList.NIL)), TermList.NIL))), false, true));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(11, 7, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(3), TermList.NIL))), false, false));
			retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, new TermList(new TermList(new TermList(owner.getTermConstant(72) /*ref*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(79) /*Session*/, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), new TermList(owner.getTermVariable(3), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[4] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(owner.getTermConstant(74) /*activity-structure*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), new TermList(new TermList(owner.getTermConstant(75) /*structure-type*/, new TermList(owner.getTermConstant(76) /*selection*/, TermList.NIL)), TermList.NIL)), TermList.NIL))), false, true));
			retVal.subtasks[5] = new TaskList(new TaskAtom(new Predicate(7, 7, new TermList(new TermList(owner.getTermConstant(80) /*createSession*/, new TermList(new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), new TermList(owner.getTermVariable(3), TermList.NIL))), TermList.NIL)), false, true));
			retVal.subtasks[6] = new TaskList(new TaskAtom(new Predicate(1, 7, new TermList(owner.getTermConstant(74) /*activity-structure*/, TermList.NIL)), false, true));
			retVal.subtasks[7] = new TaskList(new TaskAtom(new Predicate(1, 7, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(3), TermList.NIL)))), false, true));
			retVal.subtasks[8] = new TaskList(new TaskAtom(new Predicate(1, 7, new TermList(owner.getTermConstant(74) /*activity-structure*/, TermList.NIL)), false, true));
			retVal.subtasks[9] = new TaskList(new TaskAtom(new Predicate(1, 7, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, TermList.NIL)), false, true));

			return retVal;
		}

		TaskList createTaskList1()
		{
			TaskList retVal;

			retVal = new TaskList(5, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, new TermList(new TermList(new TermList(owner.getTermConstant(72) /*ref*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(79) /*Session*/, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), new TermList(owner.getTermVariable(3), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(0, 7, new TermList(owner.getTermConstant(74) /*activity-structure*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), new TermList(new TermList(owner.getTermConstant(75) /*structure-type*/, new TermList(owner.getTermConstant(76) /*selection*/, TermList.NIL)), TermList.NIL)), TermList.NIL))), false, true));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(7, 7, new TermList(new TermList(owner.getTermConstant(80) /*createSession*/, new TermList(new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), new TermList(owner.getTermVariable(3), TermList.NIL))), TermList.NIL)), false, true));
			retVal.subtasks[3] = new TaskList(new TaskAtom(new Predicate(1, 7, new TermList(owner.getTermConstant(74) /*activity-structure*/, TermList.NIL)), false, true));
			retVal.subtasks[4] = new TaskList(new TaskAtom(new Predicate(1, 7, new TermList(owner.getTermConstant(73) /*activity-structure-ref*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(3), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDSession [line:552,4 to 581,61]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition37(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionNil(7)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method21Branch0(text:createLDSession,line:552,col:14)";
				case 1: return "Method21Branch1(text:createLDSession,line:552,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task text
	 * Source: (line:601, col:7) to (line:602, col:35)
	 */
	public static class Precondition38 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition38(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:601, col:8) to (line:601, col:25)
			p[1] = new PreconditionAtomic(new Predicate(0, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(81) /*title*/, TermList.NIL))), unifier);
			// Source: (line:602, col:8) to (line:602, col:34)
			p[2] = new PreconditionAtomic(new Predicate(82, 3, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(1), TermList.NIL))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task text [line:601,7 to 602,35]";
		}
	}

	/**
	 * Method -1 for compound task text
	 * Source: (line:600, col:4) to (line:610, col:30)
	 */
	public static class Method22 extends Method
	{
	/**
	 * Method -1 for compound task text
	 */
		public Method22(Domain owner)
		{
			super(owner, new Predicate(15, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))));
			TaskList[] subsIn = new TaskList[2];

			subsIn[0] = createTaskList0();
			subsIn[1] = createTaskList1();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(81) /*title*/, TermList.NIL)), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 3, new TermList(owner.getTermConstant(83) /*none*/, new TermList(owner.getTermVariable(2), TermList.NIL))), false, true));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(81) /*title*/, TermList.NIL)), false, true));

			return retVal;
		}

		TaskList createTaskList1()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(81) /*title*/, TermList.NIL)), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(2, 3, new TermList(new TermList(owner.getTermConstant(84) /*scenario*/, new TermList(owner.getTermVariable(0), TermList.NIL)), new TermList(owner.getTermVariable(1), TermList.NIL))), false, true));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(81) /*title*/, TermList.NIL)), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task text [line:600,4 to 610,30]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition38(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionAtomic(new Predicate(0, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermConstant(81) /*title*/, TermList.NIL))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method22Branch0(text:text,line:600,col:14)";
				case 1: return "Method22Branch1(text:text,line:600,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createLDIndividualPhase
	 * Source: (line:614, col:4) to (line:619, col:42)
	 */
	public static class Method23 extends Method
	{
	/**
	 * Method -1 for compound task createLDIndividualPhase
	 */
		public Method23(Domain owner)
		{
			super(owner, new Predicate(17, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(86) /*IndividualPhase*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(16, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDIndividualPhase [line:614,4 to 619,42]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method23Branch0(text:createLDIndividualPhase,line:614,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createIndividualPhase
	 * Source: (line:622, col:7) to (line:624, col:45)
	 */
	public static class Precondition39 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition39(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:622, col:8) to (line:622, col:32)
			p[1] = new PreconditionAtomic(new Predicate(4, 5, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(0), TermList.NIL))), unifier);
			// Source: (line:623, col:8) to (line:623, col:63)
			p[2] = new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGroupings, "((domain)owner).calculateGroupings"), unifier, 3);
			// Source: (line:624, col:8) to (line:624, col:44)
			p[3] = new PreconditionAtomic(new Predicate(7, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createIndividualPhase [line:622,7 to 624,45]";
		}
	}

	/**
	 * Method -1 for compound task createIndividualPhase
	 * Source: (line:621, col:4) to (line:625, col:59)
	 */
	public static class Method24 extends Method
	{
	/**
	 * Method -1 for compound task createIndividualPhase
	 */
		public Method24(Domain owner)
		{
			super(owner, new Predicate(16, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(1, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(18, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(4), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createIndividualPhase [line:621,4 to 625,59]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition39(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method24Branch0(text:createIndividualPhase,line:621,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createIndividualGroupActivities
	 * Source: (line:627, col:4) to (line:629, col:9)
	 */
	public static class Method25 extends Method
	{
	/**
	 * Method -1 for compound task createIndividualGroupActivities
	 */
		public Method25(Domain owner)
		{
			super(owner, new Predicate(18, 0, new TermList(TermList.NIL, new TermList(TermList.NIL, TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createIndividualGroupActivities [line:627,4 to 629,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method25Branch0(text:createIndividualGroupActivities,line:627,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createIndividualGroupActivities
	 * Source: (line:632, col:7) to (line:633, col:42)
	 */
	public static class Precondition40 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition40(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:632, col:8) to (line:632, col:27)
			p[1] = new PreconditionAtomic(new Predicate(4, 6, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			// Source: (line:633, col:8) to (line:633, col:41)
			p[2] = new PreconditionAtomic(new Predicate(12, 6, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createIndividualGroupActivities [line:632,7 to 633,42]";
		}
	}

	/**
	 * Method -1 for compound task createIndividualGroupActivities
	 * Source: (line:631, col:4) to (line:635, col:57)
	 */
	public static class Method26 extends Method
	{
	/**
	 * Method -1 for compound task createIndividualGroupActivities
	 */
		public Method26(Domain owner)
		{
			super(owner, new Predicate(18, 6, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(new TermList(owner.getTermVariable(2), owner.getTermVariable(3)), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(9, 6, new TermList(new TermList(owner.getTermVariable(0), TermList.NIL), new TermList(owner.getTermVariable(5), TermList.NIL))), false, false));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(18, 6, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(3), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createIndividualGroupActivities [line:631,4 to 635,57]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition40(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method26Branch0(text:createIndividualGroupActivities,line:631,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createLDSharePhase
	 * Source: (line:639, col:4) to (line:644, col:42)
	 */
	public static class Method27 extends Method
	{
	/**
	 * Method -1 for compound task createLDSharePhase
	 */
		public Method27(Domain owner)
		{
			super(owner, new Predicate(20, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(87) /*SharePhase*/, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), TermList.NIL), new TermList(owner.getTermVariable(2), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(19, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDSharePhase [line:639,4 to 644,42]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method27Branch0(text:createLDSharePhase,line:639,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createSharePhase
	 * Source: (line:646, col:4) to (line:648, col:68)
	 */
	public static class Method28 extends Method
	{
	/**
	 * Method -1 for compound task createSharePhase
	 */
		public Method28(Domain owner)
		{
			super(owner, new Predicate(19, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(1, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(10, 2, new TermList(new TermCall(new List(owner.getTermConstant(66) /*rp*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(new TermList(owner.getTermVariable(0), TermList.NIL), new TermList(owner.getTermVariable(1), TermList.NIL)))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createSharePhase [line:646,4 to 648,68]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(2)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method28Branch0(text:createSharePhase,line:646,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Disjunct #1 of Conjunct #9 of Precondition #0 of Method -1 for compound task createScript
	 * Source: (line:668, col:12) to (line:669, col:50)
	 */
	public static class Precondition41 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition41(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:668, col:13) to (line:668, col:70)
			p[1] = new PreconditionAtomic(new Predicate(48, 15, new TermList(owner.getTermVariable(10), new TermList(owner.getTermVariable(9), new TermList(new TermNumber(-1.0), new TermList(owner.getTermConstant(45) /*isVariantOf*/, new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(63) /*Attitude*/, TermList.NIL)), TermList.NIL), TermList.NIL)))))), unifier);
			// Source: (line:669, col:13) to (line:669, col:49)
			p[2] = new PreconditionAtomic(new Predicate(6, 15, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(10), TermList.NIL))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Disjunct #1 of Conjunct #9 of Precondition #0 of Method -1 for compound task createScript [line:668,12 to 669,50]";
		}
	}

	/**
	 * Conjunct #9 of Precondition #0 of Method -1 for compound task createScript
	 * Source: (line:667, col:8) to (line:669, col:51)
	 */
	public static class Precondition42 extends Precondition
	{
		Precondition[] p;
		Term[] b;
		int whichClause;

		public Precondition42(Domain owner, Term[] unifier)
		{
			p = new Precondition[2];
			p[0] = new PreconditionAtomic(new Predicate(6, 15, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(9), TermList.NIL))), unifier);

			p[1] = new Precondition41(owner, unifier);

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			p[0].bind(binding);
			p[1].bind(binding);
		}

		protected Term[] nextBindingHelper(State state)
		{
			while (whichClause < 2)
			{
				b = p[whichClause].nextBinding(state);
				if (b != null)
					 return b;
				whichClause++;
			}

			return null;
		}

		@Override
		public String toString()
		{
			return "Conjunct #9 of Precondition #0 of Method -1 for compound task createScript [line:667,8 to 669,51]";
		}
		protected void resetHelper(State state)
		{
			p[0].reset(state);
			p[1].reset(state);
			whichClause = 0;
		}
	}

	/**
	 * Disjunct #1 of Conjunct #10 of Precondition #0 of Method -1 for compound task createScript
	 * Source: (line:671, col:12) to (line:672, col:51)
	 */
	public static class Precondition43 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition43(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:671, col:13) to (line:671, col:70)
			p[1] = new PreconditionAtomic(new Predicate(48, 15, new TermList(owner.getTermVariable(11), new TermList(owner.getTermVariable(9), new TermList(new TermNumber(-1.0), new TermList(owner.getTermConstant(45) /*isVariantOf*/, new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(63) /*Attitude*/, TermList.NIL)), TermList.NIL), TermList.NIL)))))), unifier);
			// Source: (line:672, col:13) to (line:672, col:50)
			p[2] = new PreconditionAtomic(new Predicate(6, 15, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(11), TermList.NIL))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Disjunct #1 of Conjunct #10 of Precondition #0 of Method -1 for compound task createScript [line:671,12 to 672,51]";
		}
	}

	/**
	 * Conjunct #10 of Precondition #0 of Method -1 for compound task createScript
	 * Source: (line:670, col:8) to (line:672, col:52)
	 */
	public static class Precondition44 extends Precondition
	{
		Precondition[] p;
		Term[] b;
		int whichClause;

		public Precondition44(Domain owner, Term[] unifier)
		{
			p = new Precondition[2];
			p[0] = new PreconditionAtomic(new Predicate(6, 15, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(9), TermList.NIL))), unifier);

			p[1] = new Precondition43(owner, unifier);

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			p[0].bind(binding);
			p[1].bind(binding);
		}

		protected Term[] nextBindingHelper(State state)
		{
			while (whichClause < 2)
			{
				b = p[whichClause].nextBinding(state);
				if (b != null)
					 return b;
				whichClause++;
			}

			return null;
		}

		@Override
		public String toString()
		{
			return "Conjunct #10 of Precondition #0 of Method -1 for compound task createScript [line:670,8 to 672,52]";
		}
		protected void resetHelper(State state)
		{
			p[0].reset(state);
			p[1].reset(state);
			whichClause = 0;
		}
	}

	/**
	 * consequence of Conjunct #11 of Precondition #0 of Method -1 for compound task createScript
	 * Source: (line:675, col:16) to (line:676, col:42)
	 */
	public static class Precondition45 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition45(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:675, col:17) to (line:675, col:72)
			p[1] = new PreconditionAtomic(new Predicate(27, 15, new TermList(owner.getTermVariable(13), new TermList(owner.getTermVariable(12), new TermList(owner.getTermConstant(91) /*hasExperience*/, TermList.NIL)))), unifier);
			// Source: (line:676, col:17) to (line:676, col:41)
			p[2] = new PreconditionAtomic(new Predicate(6, 15, new TermList(owner.getTermConstant(92) /*high*/, new TermList(owner.getTermVariable(13), TermList.NIL))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "consequence of Conjunct #11 of Precondition #0 of Method -1 for compound task createScript [line:675,16 to 676,42]";
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createScript
	 * Source: (line:655, col:7) to (line:678, col:67)
	 */
	public static class Precondition46 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition46(Domain owner, Term[] unifier)
		{
			p = new Precondition[14];
			// Source: (line:655, col:8) to (line:655, col:79)
			p[1] = new PreconditionAssign(new TermCall(new List(owner.getTermConstant(88) /*positive-interdependence*/, TermList.NIL), ((domain)owner).calculateGetId, "((domain)owner).calculateGetId"), unifier, 3);
			// Source: (line:656, col:8) to (line:656, col:81)
			p[2] = new PreconditionAssign(new TermCall(new List(owner.getTermConstant(89) /*individual-accountability*/, TermList.NIL), ((domain)owner).calculateGetId, "((domain)owner).calculateGetId"), unifier, 4);
			// Source: (line:658, col:8) to (line:658, col:47)
			p[3] = new PreconditionAtomic(new Predicate(0, 15, new TermList(owner.getTermConstant(90) /*knowledge-construction*/, new TermList(owner.getTermVariable(1), TermList.NIL))), unifier);
			// Source: (line:659, col:8) to (line:660, col:58)
			p[4] = new PreconditionAtomic(new Predicate(35, 15, new TermList(owner.getTermVariable(5), new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(77) /*CognitiveCompetency*/, TermList.NIL)), new TermList(new TermList(owner.getTermConstant(18) /*relation*/, new TermList(owner.getTermConstant(17) /*isPartOf*/, new TermList(owner.getTermVariable(0), TermList.NIL))), TermList.NIL)), TermList.NIL))), unifier);
			// Source: (line:661, col:8) to (line:661, col:38)
			p[5] = new PreconditionAtomic(new Predicate(4, 15, new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(5), TermList.NIL))), unifier);
			// Source: (line:662, col:8) to (line:662, col:38)
			p[6] = new PreconditionAtomic(new Predicate(4, 15, new TermList(owner.getTermVariable(7), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			// Source: (line:663, col:8) to (line:663, col:53)
			p[7] = new PreconditionCall(new TermCall(new List(owner.getTermVariable(7), new TermList(new TermCall(new List(new TermNumber(2.0), new TermList(owner.getTermVariable(6), TermList.NIL)), StdLib.mult, "StdLib.mult"), TermList.NIL)), StdLib.moreEq, "StdLib.moreEq"), unifier);
			// Source: (line:665, col:8) to (line:665, col:28)
			p[8] = new PreconditionAtomic(new Predicate(15, 15, new TermList(owner.getTermVariable(8), TermList.NIL)), unifier);
			// Source: (line:666, col:8) to (line:666, col:44)
			p[9] = new PreconditionAtomic(new Predicate(38, 15, new TermList(owner.getTermVariable(9), new TermList(owner.getTermConstant(19) /*hasGoal*/, new TermList(owner.getTermVariable(8), TermList.NIL)))), unifier);
			// Source: (line:667, col:8) to (line:669, col:51)
			p[10] = new Precondition42(owner, unifier) /*Conjunct 10 of Precondition #0 of Method -1 for compound task createScript*/;
			// Source: (line:670, col:8) to (line:672, col:52)
			p[11] = new Precondition44(owner, unifier) /*Conjunct 11 of Precondition #0 of Method -1 for compound task createScript*/;
			// Source: (line:674, col:8) to (line:676, col:43)
			p[12] = new PreconditionForAll(new PreconditionAtomic(new Predicate(6, 15, new TermList(owner.getTermVariable(12), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier), new Precondition45(owner, unifier), 15);
			// Source: (line:678, col:8) to (line:678, col:66)
			p[13] = new PreconditionAssign(new TermCall(new List(owner.getTermVariable(5), new TermList(new TermList(owner.getTermVariable(1), TermList.NIL), TermList.NIL)), ((domain)owner).calculateGetProduct, "((domain)owner).calculateGetProduct"), unifier, 14);
			b = new Term[14][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
			b[6] = null;
			b[7] = null;
			b[8] = null;
			b[9] = null;
			b[10] = null;
			b[11] = null;
			b[12] = null;
			b[13] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[13] == null)
			{
				boolean b12changed = false;
				while (b[12] == null)
				{
					boolean b11changed = false;
					while (b[11] == null)
					{
						boolean b10changed = false;
						while (b[10] == null)
						{
							boolean b9changed = false;
							while (b[9] == null)
							{
								boolean b8changed = false;
								while (b[8] == null)
								{
									boolean b7changed = false;
									while (b[7] == null)
									{
										boolean b6changed = false;
										while (b[6] == null)
										{
											boolean b5changed = false;
											while (b[5] == null)
											{
												boolean b4changed = false;
												while (b[4] == null)
												{
													boolean b3changed = false;
													while (b[3] == null)
													{
														boolean b2changed = false;
														while (b[2] == null)
														{
															boolean b1changed = false;
															while (b[1] == null)
															{
																b[1] = p[1].nextBinding(state);
																if (b[1] == null)
																	return null;
																else
																	bestMatch = Math.max(bestMatch, 1);
																b1changed = true;
															}
															if ( b1changed ) {
																p[2].reset(state);
																p[2].bind(Term.merge(b, 2));
															}
															b[2] = p[2].nextBinding(state);
															if (b[2] == null)
																b[1] = null;
															else
																bestMatch = Math.max(bestMatch, 2);
															b2changed = true;
														}
														if ( b2changed ) {
															p[3].reset(state);
															p[3].bind(Term.merge(b, 3));
														}
														b[3] = p[3].nextBinding(state);
														if (b[3] == null)
															b[2] = null;
														else
															bestMatch = Math.max(bestMatch, 3);
														b3changed = true;
													}
													if ( b3changed ) {
														p[4].reset(state);
														p[4].bind(Term.merge(b, 4));
													}
													b[4] = p[4].nextBinding(state);
													if (b[4] == null)
														b[3] = null;
													else
														bestMatch = Math.max(bestMatch, 4);
													b4changed = true;
												}
												if ( b4changed ) {
													p[5].reset(state);
													p[5].bind(Term.merge(b, 5));
												}
												b[5] = p[5].nextBinding(state);
												if (b[5] == null)
													b[4] = null;
												else
													bestMatch = Math.max(bestMatch, 5);
												b5changed = true;
											}
											if ( b5changed ) {
												p[6].reset(state);
												p[6].bind(Term.merge(b, 6));
											}
											b[6] = p[6].nextBinding(state);
											if (b[6] == null)
												b[5] = null;
											else
												bestMatch = Math.max(bestMatch, 6);
											b6changed = true;
										}
										if ( b6changed ) {
											p[7].reset(state);
											p[7].bind(Term.merge(b, 7));
										}
										b[7] = p[7].nextBinding(state);
										if (b[7] == null)
											b[6] = null;
										else
											bestMatch = Math.max(bestMatch, 7);
										b7changed = true;
									}
									if ( b7changed ) {
										p[8].reset(state);
										p[8].bind(Term.merge(b, 8));
									}
									b[8] = p[8].nextBinding(state);
									if (b[8] == null)
										b[7] = null;
									else
										bestMatch = Math.max(bestMatch, 8);
									b8changed = true;
								}
								if ( b8changed ) {
									p[9].reset(state);
									p[9].bind(Term.merge(b, 9));
								}
								b[9] = p[9].nextBinding(state);
								if (b[9] == null)
									b[8] = null;
								else
									bestMatch = Math.max(bestMatch, 9);
								b9changed = true;
							}
							if ( b9changed ) {
								p[10].reset(state);
								p[10].bind(Term.merge(b, 10));
							}
							b[10] = p[10].nextBinding(state);
							if (b[10] == null)
								b[9] = null;
							else
								bestMatch = Math.max(bestMatch, 10);
							b10changed = true;
						}
						if ( b10changed ) {
							p[11].reset(state);
							p[11].bind(Term.merge(b, 11));
						}
						b[11] = p[11].nextBinding(state);
						if (b[11] == null)
							b[10] = null;
						else
							bestMatch = Math.max(bestMatch, 11);
						b11changed = true;
					}
					if ( b11changed ) {
						p[12].reset(state);
						p[12].bind(Term.merge(b, 12));
					}
					b[12] = p[12].nextBinding(state);
					if (b[12] == null)
						b[11] = null;
					else
						bestMatch = Math.max(bestMatch, 12);
					b12changed = true;
				}
				if ( b12changed ) {
					p[13].reset(state);
					p[13].bind(Term.merge(b, 13));
				}
				b[13] = p[13].nextBinding(state);
				if (b[13] == null)
					b[12] = null;
				else
					bestMatch = Math.max(bestMatch, 13);
			}

			Term[] retVal = Term.merge(b, 14);
			b[13] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			p[5].reset(state);
			p[6].reset(state);
			p[7].reset(state);
			p[8].reset(state);
			p[9].reset(state);
			p[10].reset(state);
			p[11].reset(state);
			p[12].reset(state);
			p[13].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
			b[6] = null;
			b[7] = null;
			b[8] = null;
			b[9] = null;
			b[10] = null;
			b[11] = null;
			b[12] = null;
			b[13] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createScript [line:655,7 to 678,67]";
		}
	}

	/**
	 * Method -1 for compound task createScript
	 * Source: (line:653, col:4) to (line:682, col:78)
	 */
	public static class Method29 extends Method
	{
	/**
	 * Method -1 for compound task createScript
	 */
		public Method29(Domain owner)
		{
			super(owner, new Predicate(8, 15, new TermList(new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL)), new TermList(owner.getTermVariable(2), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(17, 15, new TermList(new TermCall(new List(owner.getTermConstant(85) /*act*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(owner.getTermVariable(14), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, false));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(21, 15, new TermList(new TermCall(new List(owner.getTermConstant(85) /*act*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(owner.getTermVariable(14), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, false));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(22, 15, new TermList(new TermCall(new List(owner.getTermConstant(85) /*act*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL)), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createScript [line:653,4 to 682,78]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition46(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "create-jigsaw";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createLDExpertPhase
	 * Source: (line:686, col:4) to (line:691, col:42)
	 */
	public static class Method30 extends Method
	{
	/**
	 * Method -1 for compound task createLDExpertPhase
	 */
		public Method30(Domain owner)
		{
			super(owner, new Predicate(21, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(93) /*ExpertPhase*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(23, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDExpertPhase [line:686,4 to 691,42]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method30Branch0(text:createLDExpertPhase,line:686,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createExpertPhase
	 * Source: (line:693, col:4) to (line:695, col:9)
	 */
	public static class Method31 extends Method
	{
	/**
	 * Method -1 for compound task createExpertPhase
	 */
		public Method31(Domain owner)
		{
			super(owner, new Predicate(23, 1, new TermList(TermList.NIL, new TermList(owner.getTermVariable(0), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = TaskList.empty;

			setSubs(subsIn);
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createExpertPhase [line:693,4 to 695,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method31Branch0(text:createExpertPhase,line:693,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition #0 of Method -1 for compound task createExpertPhase
	 * Source: (line:698, col:7) to (line:704, col:73)
	 */
	public static class Precondition47 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition47(Domain owner, Term[] unifier)
		{
			p = new Precondition[6];
			// Source: (line:698, col:8) to (line:698, col:28)
			p[1] = new PreconditionAtomic(new Predicate(15, 8, new TermList(owner.getTermVariable(3), TermList.NIL)), unifier);
			// Source: (line:699, col:8) to (line:699, col:61)
			p[2] = new PreconditionAtomic(new Predicate(48, 8, new TermList(owner.getTermVariable(4), new TermList(new TermList(owner.getTermVariable(3), TermList.NIL), new TermList(new TermNumber(1.0), new TermList(owner.getTermConstant(17) /*isPartOf*/, new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(65) /*Script*/, TermList.NIL)), TermList.NIL), TermList.NIL)))))), unifier);
			// Source: (line:700, col:8) to (line:700, col:40)
			p[3] = new PreconditionAtomic(new Predicate(7, 8, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(4), TermList.NIL))), unifier);
			// Source: (line:701, col:8) to (line:703, col:46)
			p[4] = new PreconditionAtomic(new Predicate(48, 8, new TermList(owner.getTermVariable(6), new TermList(new TermList(owner.getTermVariable(5), TermList.NIL), new TermList(new TermNumber(-1.0), new TermList(owner.getTermConstant(41) /*inverseIsPartOf*/, new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermConstant(70) /*GroupActivity*/, TermList.NIL)), new TermList(new TermList(owner.getTermConstant(20) /*property*/, new TermList(owner.getTermConstant(19) /*hasGoal*/, new TermList(owner.getTermVariable(0), TermList.NIL))), TermList.NIL)), TermList.NIL)))))), unifier);
			// Source: (line:704, col:8) to (line:704, col:72)
			p[5] = new PreconditionAtomic(new Predicate(30, 8, new TermList(owner.getTermVariable(7), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(6), TermList.NIL)))), unifier);
			b = new Term[6][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[5] == null)
			{
				boolean b4changed = false;
				while (b[4] == null)
				{
					boolean b3changed = false;
					while (b[3] == null)
					{
						boolean b2changed = false;
						while (b[2] == null)
						{
							boolean b1changed = false;
							while (b[1] == null)
							{
								b[1] = p[1].nextBinding(state);
								if (b[1] == null)
									return null;
								else
									bestMatch = Math.max(bestMatch, 1);
								b1changed = true;
							}
							if ( b1changed ) {
								p[2].reset(state);
								p[2].bind(Term.merge(b, 2));
							}
							b[2] = p[2].nextBinding(state);
							if (b[2] == null)
								b[1] = null;
							else
								bestMatch = Math.max(bestMatch, 2);
							b2changed = true;
						}
						if ( b2changed ) {
							p[3].reset(state);
							p[3].bind(Term.merge(b, 3));
						}
						b[3] = p[3].nextBinding(state);
						if (b[3] == null)
							b[2] = null;
						else
							bestMatch = Math.max(bestMatch, 3);
						b3changed = true;
					}
					if ( b3changed ) {
						p[4].reset(state);
						p[4].bind(Term.merge(b, 4));
					}
					b[4] = p[4].nextBinding(state);
					if (b[4] == null)
						b[3] = null;
					else
						bestMatch = Math.max(bestMatch, 4);
					b4changed = true;
				}
				if ( b4changed ) {
					p[5].reset(state);
					p[5].bind(Term.merge(b, 5));
				}
				b[5] = p[5].nextBinding(state);
				if (b[5] == null)
					b[4] = null;
				else
					bestMatch = Math.max(bestMatch, 5);
			}

			Term[] retVal = Term.merge(b, 6);
			b[5] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			p[5].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition #0 of Method -1 for compound task createExpertPhase [line:698,7 to 704,73]";
		}
	}

	/**
	 * Method -1 for compound task createExpertPhase
	 * Source: (line:697, col:4) to (line:706, col:45)
	 */
	public static class Method32 extends Method
	{
	/**
	 * Method -1 for compound task createExpertPhase
	 */
		public Method32(Domain owner)
		{
			super(owner, new Predicate(23, 8, new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(2, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(10, 8, new TermList(new TermCall(new List(owner.getTermConstant(66) /*rp*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(new TermList(owner.getTermVariable(0), TermList.NIL), new TermList(owner.getTermVariable(7), TermList.NIL)))), false, false));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(23, 8, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createExpertPhase [line:697,4 to 706,45]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition47(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method32Branch0(text:createExpertPhase,line:697,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createLDJigsawPhase
	 * Source: (line:779, col:4) to (line:784, col:42)
	 */
	public static class Method33 extends Method
	{
	/**
	 * Method -1 for compound task createLDJigsawPhase
	 */
		public Method33(Domain owner)
		{
			super(owner, new Predicate(22, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(3, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(0, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(new TermList(new TermList(owner.getTermConstant(59) /*identifier*/, new TermList(owner.getTermVariable(0), TermList.NIL)), TermList.NIL), new TermList(new TermList(owner.getTermConstant(94) /*JigsawPhase*/, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), TermList.NIL), new TermList(owner.getTermVariable(2), TermList.NIL)))), TermList.NIL)))), false, true));
			retVal.subtasks[1] = new TaskList(new TaskAtom(new Predicate(24, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), false, false));
			retVal.subtasks[2] = new TaskList(new TaskAtom(new Predicate(1, 3, new TermList(owner.getTermConstant(85) /*act*/, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL)))), false, true));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createLDJigsawPhase [line:779,4 to 784,42]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(3)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method33Branch0(text:createLDJigsawPhase,line:779,col:14)";
				default: return null;
			}
		}
	}

	/**
	 * Method -1 for compound task createJigsawPhase
	 * Source: (line:786, col:5) to (line:788, col:69)
	 */
	public static class Method34 extends Method
	{
	/**
	 * Method -1 for compound task createJigsawPhase
	 */
		public Method34(Domain owner)
		{
			super(owner, new Predicate(24, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))));
			TaskList[] subsIn = new TaskList[1];

			subsIn[0] = createTaskList0();

			setSubs(subsIn);
		}

		TaskList createTaskList0()
		{
			TaskList retVal;

			retVal = new TaskList(1, true);
			retVal.subtasks[0] = new TaskList(new TaskAtom(new Predicate(10, 2, new TermList(new TermCall(new List(owner.getTermConstant(66) /*rp*/, TermList.NIL), ((domain)owner).calculateGetUUID, "((domain)owner).calculateGetUUID"), new TermList(new TermList(owner.getTermVariable(0), TermList.NIL), new TermList(owner.getTermVariable(1), TermList.NIL)))), false, false));

			return retVal;
		}

		@Override
		public String toString()
		{
			return "Method -1 for compound task createJigsawPhase [line:786,5 to 788,69]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(2)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Method34Branch0(text:createJigsawPhase,line:786,col:15)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom same
	 * Source: (line:8, col:4) to (line:8, col:8)
	 */
	public static class Axiom0 extends Axiom
{
	/**
	 * Branch -1 for axiom same
	 */
		public Axiom0(Domain owner)
		{
			super(owner, new Predicate(0, 1, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(0), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom same [line:8,4 to 8,8]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom0Branch0(line:8,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom different
	 * Source: (line:9, col:4) to (line:9, col:9)
	 */
	public static class Axiom1 extends Axiom
{
	/**
	 * Branch -1 for axiom different
	 */
		public Axiom1(Domain owner)
		{
			super(owner, new Predicate(1, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom different [line:9,4 to 9,9]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNegation(new PreconditionAtomic(new Predicate(0, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), unifier), 2)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom1Branch0(line:9,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom first
	 * Source: (line:11, col:4) to (line:11, col:11)
	 */
	public static class Axiom2 extends Axiom
{
	/**
	 * Branch -1 for axiom first
	 */
		public Axiom2(Domain owner)
		{
			super(owner, new Predicate(2, 2, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom first [line:11,4 to 11,11]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(2)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom2Branch0(line:11,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom first
	 * Source: (line:12, col:4) to (line:12, col:12)
	 */
	public static class Axiom3 extends Axiom
{
	/**
	 * Branch -1 for axiom first
	 */
		public Axiom3(Domain owner)
		{
			super(owner, new Predicate(2, 0, new TermList(TermList.NIL, new TermList(TermList.NIL, TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom first [line:12,4 to 12,12]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom3Branch0(line:12,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom rest
	 * Source: (line:13, col:4) to (line:13, col:13)
	 */
	public static class Axiom4 extends Axiom
{
	/**
	 * Branch -1 for axiom rest
	 */
		public Axiom4(Domain owner)
		{
			super(owner, new Predicate(3, 2, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(0)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom rest [line:13,4 to 13,13]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(2)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom4Branch0(line:13,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom rest
	 * Source: (line:14, col:4) to (line:14, col:14)
	 */
	public static class Axiom5 extends Axiom
{
	/**
	 * Branch -1 for axiom rest
	 */
		public Axiom5(Domain owner)
		{
			super(owner, new Predicate(3, 0, new TermList(TermList.NIL, new TermList(TermList.NIL, TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom rest [line:14,4 to 14,14]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom5Branch0(line:14,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom length
	 * Source: (line:16, col:4) to (line:16, col:16)
	 */
	public static class Axiom6 extends Axiom
{
	/**
	 * Branch -1 for axiom length
	 */
		public Axiom6(Domain owner)
		{
			super(owner, new Predicate(4, 1, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom length [line:16,4 to 16,16]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(new TermNumber(0.0), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom6Branch0(line:16,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom length
	 * Source: (line:17, col:41) to (line:18, col:74)
	 */
	public static class Precondition0 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition0(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:17, col:42) to (line:17, col:60)
			p[1] = new PreconditionAtomic(new Predicate(4, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			// Source: (line:18, col:42) to (line:18, col:73)
			p[2] = new PreconditionAssign(new TermCall(new List(new TermNumber(1.0), new TermList(owner.getTermVariable(3), TermList.NIL)), StdLib.plus, "StdLib.plus"), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom length [line:17,41 to 18,74]";
		}
	}

	/**
	 * Branch -1 for axiom length
	 * Source: (line:17, col:4) to (line:18, col:17)
	 */
	public static class Axiom7 extends Axiom
{
	/**
	 * Branch -1 for axiom length
	 */
		public Axiom7(Domain owner)
		{
			super(owner, new Predicate(4, 4, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom length [line:17,4 to 18,17]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition0(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom7Branch0(line:17,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom last
	 * Source: (line:20, col:4) to (line:20, col:20)
	 */
	public static class Axiom8 extends Axiom
{
	/**
	 * Branch -1 for axiom last
	 */
		public Axiom8(Domain owner)
		{
			super(owner, new Predicate(5, 1, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(0), TermList.NIL), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom last [line:20,4 to 20,20]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom8Branch0(line:20,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom last
	 * Source: (line:21, col:4) to (line:21, col:21)
	 */
	public static class Axiom9 extends Axiom
{
	/**
	 * Branch -1 for axiom last
	 */
		public Axiom9(Domain owner)
		{
			super(owner, new Predicate(5, 3, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom last [line:21,4 to 21,21]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(5, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom9Branch0(line:21,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom exist
	 * Source: (line:23, col:4) to (line:23, col:23)
	 */
	public static class Axiom10 extends Axiom
{
	/**
	 * Branch -1 for axiom exist
	 */
		public Axiom10(Domain owner)
		{
			super(owner, new Predicate(6, 2, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(0), owner.getTermVariable(1)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom exist [line:23,4 to 23,23]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(2)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom10Branch0(line:23,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom exist
	 * Source: (line:24, col:4) to (line:24, col:24)
	 */
	public static class Axiom11 extends Axiom
{
	/**
	 * Branch -1 for axiom exist
	 */
		public Axiom11(Domain owner)
		{
			super(owner, new Predicate(6, 3, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom exist [line:24,4 to 24,24]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(6, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom11Branch0(line:24,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom assignIterator
	 * Source: (line:26, col:4) to (line:26, col:26)
	 */
	public static class Axiom12 extends Axiom
{
	/**
	 * Branch -1 for axiom assignIterator
	 */
		public Axiom12(Domain owner)
		{
			super(owner, new Predicate(7, 3, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom assignIterator [line:26,4 to 26,26]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(1), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom12Branch0(line:26,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom assignIterator
	 * Source: (line:27, col:4) to (line:27, col:27)
	 */
	public static class Axiom13 extends Axiom
{
	/**
	 * Branch -1 for axiom assignIterator
	 */
		public Axiom13(Domain owner)
		{
			super(owner, new Predicate(7, 3, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom assignIterator [line:27,4 to 27,27]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(7, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom13Branch0(line:27,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom removeElement
	 * Source: (line:31, col:4) to (line:32, col:31)
	 */
	public static class Axiom14 extends Axiom
{
	/**
	 * Branch -1 for axiom removeElement
	 */
		public Axiom14(Domain owner)
		{
			super(owner, new Predicate(8, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom removeElement [line:31,4 to 32,31]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(9, 3, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom14Branch0(line:31,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom removeH
	 * Source: (line:33, col:4) to (line:34, col:33)
	 */
	public static class Axiom15 extends Axiom
{
	/**
	 * Branch -1 for axiom removeH
	 */
		public Axiom15(Domain owner)
		{
			super(owner, new Predicate(9, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom removeH [line:33,4 to 34,33]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), TermList.NIL), ((domain)owner).calculateReverse, "((domain)owner).calculateReverse"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom15Branch0(line:33,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom removeH
	 * Source: (line:35, col:4) to (line:36, col:35)
	 */
	public static class Axiom16 extends Axiom
{
	/**
	 * Branch -1 for axiom removeH
	 */
		public Axiom16(Domain owner)
		{
			super(owner, new Predicate(9, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(new TermList(owner.getTermVariable(2), owner.getTermVariable(3)), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom removeH [line:35,4 to 36,35]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(9, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom16Branch0(line:35,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom removeH
	 * Source: (line:38, col:8) to (line:39, col:63)
	 */
	public static class Precondition1 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition1(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:38, col:9) to (line:38, col:35)
			p[1] = new PreconditionAtomic(new Predicate(1, 5, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			// Source: (line:39, col:9) to (line:39, col:62)
			p[2] = new PreconditionAtomic(new Predicate(9, 5, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(3), owner.getTermVariable(1)), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(4), TermList.NIL))))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom removeH [line:38,8 to 39,63]";
		}
	}

	/**
	 * Branch -1 for axiom removeH
	 * Source: (line:37, col:4) to (line:39, col:37)
	 */
	public static class Axiom17 extends Axiom
{
	/**
	 * Branch -1 for axiom removeH
	 */
		public Axiom17(Domain owner)
		{
			super(owner, new Predicate(9, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(new TermList(owner.getTermVariable(3), owner.getTermVariable(4)), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom removeH [line:37,4 to 39,37]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition1(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom17Branch0(line:37,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom removeElements
	 * Source: (line:41, col:4) to (line:42, col:41)
	 */
	public static class Axiom18 extends Axiom
{
	/**
	 * Branch -1 for axiom removeElements
	 */
		public Axiom18(Domain owner)
		{
			super(owner, new Predicate(10, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom removeElements [line:41,4 to 42,41]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(11, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom18Branch0(line:41,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom removeElementsH
	 * Source: (line:43, col:4) to (line:44, col:43)
	 */
	public static class Axiom19 extends Axiom
{
	/**
	 * Branch -1 for axiom removeElementsH
	 */
		public Axiom19(Domain owner)
		{
			super(owner, new Predicate(11, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom removeElementsH [line:43,4 to 44,43]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), TermList.NIL), ((domain)owner).calculateReverse, "((domain)owner).calculateReverse"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom19Branch0(line:43,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom removeElementsH
	 * Source: (line:46, col:8) to (line:47, col:52)
	 */
	public static class Precondition2 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition2(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:46, col:9) to (line:46, col:42)
			p[1] = new PreconditionAtomic(new Predicate(8, 6, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier);
			// Source: (line:47, col:9) to (line:47, col:51)
			p[2] = new PreconditionAtomic(new Predicate(11, 6, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(4), TermList.NIL))))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom removeElementsH [line:46,8 to 47,52]";
		}
	}

	/**
	 * Branch -1 for axiom removeElementsH
	 * Source: (line:45, col:4) to (line:47, col:45)
	 */
	public static class Axiom20 extends Axiom
{
	/**
	 * Branch -1 for axiom removeElementsH
	 */
		public Axiom20(Domain owner)
		{
			super(owner, new Predicate(11, 6, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(new TermList(owner.getTermVariable(3), owner.getTermVariable(4)), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom removeElementsH [line:45,4 to 47,45]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition2(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom20Branch0(line:45,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom divideList
	 * Source: (line:49, col:4) to (line:50, col:49)
	 */
	public static class Axiom21 extends Axiom
{
	/**
	 * Branch -1 for axiom divideList
	 */
		public Axiom21(Domain owner)
		{
			super(owner, new Predicate(12, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom divideList [line:49,4 to 50,49]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateDivideList, "((domain)owner).calculateDivideList"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom21Branch0(line:49,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom divideLists
	 * Source: (line:52, col:4) to (line:53, col:52)
	 */
	public static class Axiom22 extends Axiom
{
	/**
	 * Branch -1 for axiom divideLists
	 */
		public Axiom22(Domain owner)
		{
			super(owner, new Predicate(13, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom divideLists [line:52,4 to 53,52]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(14, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom22Branch0(line:52,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom divideListsH
	 * Source: (line:54, col:4) to (line:55, col:54)
	 */
	public static class Axiom23 extends Axiom
{
	/**
	 * Branch -1 for axiom divideListsH
	 */
		public Axiom23(Domain owner)
		{
			super(owner, new Predicate(14, 3, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom divideListsH [line:54,4 to 55,54]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(2), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom23Branch0(line:54,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom divideListsH
	 * Source: (line:57, col:8) to (line:58, col:66)
	 */
	public static class Precondition3 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition3(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:57, col:9) to (line:57, col:39)
			p[1] = new PreconditionAtomic(new Predicate(12, 6, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(3), TermList.NIL)))), unifier);
			// Source: (line:58, col:9) to (line:58, col:65)
			p[2] = new PreconditionAtomic(new Predicate(14, 6, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(new TermList(owner.getTermVariable(5), owner.getTermVariable(4)), TermList.NIL))))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom divideListsH [line:57,8 to 58,66]";
		}
	}

	/**
	 * Branch -1 for axiom divideListsH
	 * Source: (line:56, col:4) to (line:58, col:56)
	 */
	public static class Axiom24 extends Axiom
{
	/**
	 * Branch -1 for axiom divideListsH
	 */
		public Axiom24(Domain owner)
		{
			super(owner, new Predicate(14, 6, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom divideListsH [line:56,4 to 58,56]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition3(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom24Branch0(line:56,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getLearnerPropertyFromCurrentStateH
	 * Source: (line:165, col:8) to (line:167, col:36)
	 */
	public static class Precondition5 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition5(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:165, col:9) to (line:166, col:44)
			p[1] = new PreconditionForAll(new PreconditionAtomic(new Predicate(20, 5, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier), new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:167, col:9) to (line:167, col:35)
			p[2] = new PreconditionAssign(owner.getTermVariable(3), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getLearnerPropertyFromCurrentStateH [line:165,8 to 167,36]";
		}
	}

	/**
	 * Precondition of branch #1 of Branch -1 for axiom getLearnerPropertyFromCurrentStateH
	 * Source: (line:170, col:10) to (line:173, col:70)
	 */
	public static class Precondition6 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition6(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:170, col:11) to (line:170, col:46)
			p[1] = new PreconditionAtomic(new Predicate(20, 5, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			// Source: (line:171, col:11) to (line:171, col:41)
			p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:172, col:11) to (line:173, col:69)
			p[3] = new PreconditionAtomic(new Predicate(25, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(new TermList(owner.getTermVariable(4), owner.getTermVariable(3)), TermList.NIL))))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #1 of Branch -1 for axiom getLearnerPropertyFromCurrentStateH [line:170,10 to 173,70]";
		}
	}

	/**
	 * Branch -1 for axiom getLearnerPropertyFromCurrentStateH
	 * Source: (line:164, col:4) to (line:173, col:164)
	 */
	public static class Axiom25 extends Axiom
{
	/**
	 * Branch -1 for axiom getLearnerPropertyFromCurrentStateH
	 */
		public Axiom25(Domain owner)
		{
			super(owner, new Predicate(25, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getLearnerPropertyFromCurrentStateH [line:164,4 to 173,164]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition5(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new Precondition6(owner, unifier)).setComparator(null);
					p.setFirst(true);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom25Branch0(line:164,col:5)";
				case 1: return "Axiom25Branch1(line:164,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getLearnerPropertyFromCurrentState
	 * Source: (line:176, col:8) to (line:178, col:78)
	 */
	public static class Precondition7 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition7(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:176, col:9) to (line:176, col:78)
			p[1] = new PreconditionAtomic(new Predicate(25, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), unifier);
			// Source: (line:177, col:9) to (line:178, col:77)
			p[2] = new PreconditionAssign(new TermCall(new List(new TermList(owner.getTermVariable(3), new TermList(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGetLearnerProperty, "((domain)owner).calculateGetLearnerProperty"), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getLearnerPropertyFromCurrentState [line:176,8 to 178,78]";
		}
	}

	/**
	 * Branch -1 for axiom getLearnerPropertyFromCurrentState
	 * Source: (line:175, col:4) to (line:178, col:175)
	 */
	public static class Axiom26 extends Axiom
{
	/**
	 * Branch -1 for axiom getLearnerPropertyFromCurrentState
	 */
		public Axiom26(Domain owner)
		{
			super(owner, new Predicate(26, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getLearnerPropertyFromCurrentState [line:175,4 to 178,175]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition7(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom26Branch0(line:175,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getLearnerProperty
	 * Source: (line:180, col:4) to (line:182, col:180)
	 */
	public static class Axiom27 extends Axiom
{
	/**
	 * Branch -1 for axiom getLearnerProperty
	 */
		public Axiom27(Domain owner)
		{
			super(owner, new Predicate(27, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getLearnerProperty [line:180,4 to 182,180]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(26, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGetLearnerProperty, "((domain)owner).calculateGetLearnerProperty"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom27Branch0(line:180,col:5)";
				case 1: return "Axiom27Branch1(line:180,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAnyH
	 * Source: (line:228, col:4) to (line:229, col:228)
	 */
	public static class Axiom28 extends Axiom
{
	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAnyH
	 */
		public Axiom28(Domain owner)
		{
			super(owner, new Predicate(28, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(TermList.NIL, new TermList(owner.getTermVariable(2), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getLearnersHaveAlreadySeenAnyH [line:228,4 to 229,228]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(2), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom28Branch0(line:228,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAnyH
	 * Source: (line:230, col:4) to (line:231, col:230)
	 */
	public static class Axiom29 extends Axiom
{
	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAnyH
	 */
		public Axiom29(Domain owner)
		{
			super(owner, new Predicate(28, 3, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getLearnersHaveAlreadySeenAnyH [line:230,4 to 231,230]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(2), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom29Branch0(line:230,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getLearnersHaveAlreadySeenAnyH
	 * Source: (line:234, col:8) to (line:237, col:84)
	 */
	public static class Precondition8 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition8(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:234, col:9) to (line:234, col:82)
			p[1] = new PreconditionAtomic(new Predicate(29, 7, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(1), new TermList(new TermList(new TermList(owner.getTermConstant(20) /*property*/, new TermList(owner.getTermConstant(22) /*hasAlreadySeen*/, new TermList(owner.getTermVariable(2), TermList.NIL))), TermList.NIL), TermList.NIL)))), unifier);
			// Source: (line:235, col:9) to (line:235, col:52)
			p[2] = new PreconditionAtomic(new Predicate(10, 7, new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(5), TermList.NIL)))), unifier);
			// Source: (line:236, col:9) to (line:237, col:83)
			p[3] = new PreconditionAtomic(new Predicate(28, 7, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(3), new TermList(new TermCall(new List(new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(4), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), TermList.NIL))))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getLearnersHaveAlreadySeenAnyH [line:234,8 to 237,84]";
		}
	}

	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAnyH
	 * Source: (line:232, col:4) to (line:237, col:232)
	 */
	public static class Axiom30 extends Axiom
{
	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAnyH
	 */
		public Axiom30(Domain owner)
		{
			super(owner, new Predicate(28, 7, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(new TermList(owner.getTermVariable(2), owner.getTermVariable(3)), new TermList(owner.getTermVariable(4), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getLearnersHaveAlreadySeenAnyH [line:232,4 to 237,232]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition8(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom30Branch0(line:232,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAny
	 * Source: (line:239, col:4) to (line:240, col:239)
	 */
	public static class Axiom31 extends Axiom
{
	/**
	 * Branch -1 for axiom getLearnersHaveAlreadySeenAny
	 */
		public Axiom31(Domain owner)
		{
			super(owner, new Predicate(30, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getLearnersHaveAlreadySeenAny [line:239,4 to 240,239]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(28, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom31Branch0(line:239,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getElementsByTypeFromCurrentStateH
	 * Source: (line:263, col:8) to (line:265, col:36)
	 */
	public static class Precondition9 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition9(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:263, col:9) to (line:264, col:46)
			p[1] = new PreconditionForAll(new PreconditionAtomic(new Predicate(32, 4, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), new PreconditionAtomic(new Predicate(6, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier), 4);
			// Source: (line:265, col:9) to (line:265, col:35)
			p[2] = new PreconditionAssign(owner.getTermVariable(2), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getElementsByTypeFromCurrentStateH [line:263,8 to 265,36]";
		}
	}

	/**
	 * Precondition of branch #1 of Branch -1 for axiom getElementsByTypeFromCurrentStateH
	 * Source: (line:268, col:10) to (line:271, col:71)
	 */
	public static class Precondition10 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition10(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:268, col:11) to (line:268, col:32)
			p[1] = new PreconditionAtomic(new Predicate(32, 4, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier);
			// Source: (line:269, col:11) to (line:269, col:43)
			p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(6, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier), 4);
			// Source: (line:270, col:11) to (line:271, col:70)
			p[3] = new PreconditionAtomic(new Predicate(31, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(new TermList(owner.getTermVariable(3), owner.getTermVariable(2)), TermList.NIL)))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #1 of Branch -1 for axiom getElementsByTypeFromCurrentStateH [line:268,10 to 271,71]";
		}
	}

	/**
	 * Branch -1 for axiom getElementsByTypeFromCurrentStateH
	 * Source: (line:262, col:4) to (line:271, col:262)
	 */
	public static class Axiom32 extends Axiom
{
	/**
	 * Branch -1 for axiom getElementsByTypeFromCurrentStateH
	 */
		public Axiom32(Domain owner)
		{
			super(owner, new Predicate(31, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getElementsByTypeFromCurrentStateH [line:262,4 to 271,262]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition9(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new Precondition10(owner, unifier)).setComparator(null);
					p.setFirst(true);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom32Branch0(line:262,col:5)";
				case 1: return "Axiom32Branch1(line:262,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getElementsByTypeFromCurrentState
	 * Source: (line:273, col:4) to (line:274, col:273)
	 */
	public static class Axiom33 extends Axiom
{
	/**
	 * Branch -1 for axiom getElementsByTypeFromCurrentState
	 */
		public Axiom33(Domain owner)
		{
			super(owner, new Predicate(33, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getElementsByTypeFromCurrentState [line:273,4 to 274,273]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(31, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(TermList.NIL, TermList.NIL)))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom33Branch0(line:273,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getElementsFromCurrentState
	 * Source: (line:277, col:8) to (line:278, col:50)
	 */
	public static class Precondition11 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition11(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:277, col:9) to (line:277, col:60)
			p[1] = new PreconditionAtomic(new Predicate(33, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(1), TermList.NIL))), unifier);
			// Source: (line:278, col:9) to (line:278, col:49)
			p[2] = new PreconditionAtomic(new Predicate(29, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getElementsFromCurrentState [line:277,8 to 278,50]";
		}
	}

	/**
	 * Branch -1 for axiom getElementsFromCurrentState
	 * Source: (line:276, col:4) to (line:278, col:276)
	 */
	public static class Axiom34 extends Axiom
{
	/**
	 * Branch -1 for axiom getElementsFromCurrentState
	 */
		public Axiom34(Domain owner)
		{
			super(owner, new Predicate(34, 4, new TermList(owner.getTermVariable(0), new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermVariable(1), TermList.NIL)), owner.getTermVariable(2)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getElementsFromCurrentState [line:276,4 to 278,276]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition11(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom34Branch0(line:276,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getElements
	 * Source: (line:280, col:4) to (line:282, col:280)
	 */
	public static class Axiom35 extends Axiom
{
	/**
	 * Branch -1 for axiom getElements
	 */
		public Axiom35(Domain owner)
		{
			super(owner, new Predicate(35, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getElements [line:280,4 to 282,280]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(34, 2, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), TermList.NIL))), unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), TermList.NIL), ((domain)owner).calculateGetElements, "((domain)owner).calculateGetElements"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom35Branch0(line:280,col:5)";
				case 1: return "Axiom35Branch1(line:280,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getPropertyValueFromCurrentStateH
	 * Source: (line:287, col:8) to (line:289, col:30)
	 */
	public static class Precondition12 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition12(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:287, col:9) to (line:288, col:38)
			p[1] = new PreconditionForAll(new PreconditionAtomic(new Predicate(20, 5, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier), new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:289, col:9) to (line:289, col:29)
			p[2] = new PreconditionAssign(owner.getTermVariable(3), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getPropertyValueFromCurrentStateH [line:287,8 to 289,30]";
		}
	}

	/**
	 * Precondition of branch #1 of Branch -1 for axiom getPropertyValueFromCurrentStateH
	 * Source: (line:292, col:10) to (line:294, col:89)
	 */
	public static class Precondition13 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition13(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:292, col:11) to (line:292, col:46)
			p[1] = new PreconditionAtomic(new Predicate(20, 5, new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			// Source: (line:293, col:11) to (line:293, col:35)
			p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:294, col:11) to (line:294, col:88)
			p[3] = new PreconditionAtomic(new Predicate(36, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(new TermList(owner.getTermVariable(4), owner.getTermVariable(3)), TermList.NIL))))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #1 of Branch -1 for axiom getPropertyValueFromCurrentStateH [line:292,10 to 294,89]";
		}
	}

	/**
	 * Branch -1 for axiom getPropertyValueFromCurrentStateH
	 * Source: (line:286, col:4) to (line:294, col:286)
	 */
	public static class Axiom36 extends Axiom
{
	/**
	 * Branch -1 for axiom getPropertyValueFromCurrentStateH
	 */
		public Axiom36(Domain owner)
		{
			super(owner, new Predicate(36, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getPropertyValueFromCurrentStateH [line:286,4 to 294,286]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition12(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new Precondition13(owner, unifier)).setComparator(null);
					p.setFirst(true);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom36Branch0(line:286,col:5)";
				case 1: return "Axiom36Branch1(line:286,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getPropertyValueFromCurrentState
	 * Source: (line:297, col:8) to (line:299, col:76)
	 */
	public static class Precondition14 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition14(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:297, col:9) to (line:297, col:71)
			p[1] = new PreconditionAtomic(new Predicate(36, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), unifier);
			// Source: (line:298, col:9) to (line:299, col:75)
			p[2] = new PreconditionAssign(new TermCall(new List(new TermList(owner.getTermVariable(3), new TermList(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGetPropertyValue, "((domain)owner).calculateGetPropertyValue"), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getPropertyValueFromCurrentState [line:297,8 to 299,76]";
		}
	}

	/**
	 * Branch -1 for axiom getPropertyValueFromCurrentState
	 * Source: (line:296, col:4) to (line:299, col:296)
	 */
	public static class Axiom37 extends Axiom
{
	/**
	 * Branch -1 for axiom getPropertyValueFromCurrentState
	 */
		public Axiom37(Domain owner)
		{
			super(owner, new Predicate(37, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getPropertyValueFromCurrentState [line:296,4 to 299,296]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition14(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom37Branch0(line:296,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getPropertyValue
	 * Source: (line:301, col:4) to (line:303, col:301)
	 */
	public static class Axiom38 extends Axiom
{
	/**
	 * Branch -1 for axiom getPropertyValue
	 */
		public Axiom38(Domain owner)
		{
			super(owner, new Predicate(38, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getPropertyValue [line:301,4 to 303,301]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(37, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGetPropertyValue, "((domain)owner).calculateGetPropertyValue"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom38Branch0(line:301,col:5)";
				case 1: return "Axiom38Branch1(line:301,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getRelatedFromCurrentStateH
	 * Source: (line:309, col:8) to (line:311, col:36)
	 */
	public static class Precondition15 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition15(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:309, col:9) to (line:310, col:44)
			p[1] = new PreconditionForAll(new PreconditionAtomic(new Predicate(18, 5, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier), new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:311, col:9) to (line:311, col:35)
			p[2] = new PreconditionAssign(owner.getTermVariable(3), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getRelatedFromCurrentStateH [line:309,8 to 311,36]";
		}
	}

	/**
	 * Precondition of branch #1 of Branch -1 for axiom getRelatedFromCurrentStateH
	 * Source: (line:314, col:10) to (line:317, col:62)
	 */
	public static class Precondition16 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition16(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:314, col:11) to (line:314, col:46)
			p[1] = new PreconditionAtomic(new Predicate(18, 5, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			// Source: (line:315, col:11) to (line:315, col:41)
			p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:316, col:11) to (line:317, col:61)
			p[3] = new PreconditionAtomic(new Predicate(39, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(new TermList(owner.getTermVariable(4), owner.getTermVariable(3)), TermList.NIL))))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #1 of Branch -1 for axiom getRelatedFromCurrentStateH [line:314,10 to 317,62]";
		}
	}

	/**
	 * Branch -1 for axiom getRelatedFromCurrentStateH
	 * Source: (line:308, col:4) to (line:317, col:308)
	 */
	public static class Axiom39 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelatedFromCurrentStateH
	 */
		public Axiom39(Domain owner)
		{
			super(owner, new Predicate(39, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelatedFromCurrentStateH [line:308,4 to 317,308]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition15(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new Precondition16(owner, unifier)).setComparator(null);
					p.setFirst(true);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom39Branch0(line:308,col:5)";
				case 1: return "Axiom39Branch1(line:308,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getInvRelatedFromCurrentStateH
	 * Source: (line:320, col:8) to (line:322, col:36)
	 */
	public static class Precondition17 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition17(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:320, col:9) to (line:321, col:44)
			p[1] = new PreconditionForAll(new PreconditionAtomic(new Predicate(18, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(1), TermList.NIL)))), unifier), new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:322, col:9) to (line:322, col:35)
			p[2] = new PreconditionAssign(owner.getTermVariable(3), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getInvRelatedFromCurrentStateH [line:320,8 to 322,36]";
		}
	}

	/**
	 * Precondition of branch #1 of Branch -1 for axiom getInvRelatedFromCurrentStateH
	 * Source: (line:325, col:10) to (line:328, col:65)
	 */
	public static class Precondition18 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition18(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:325, col:11) to (line:325, col:46)
			p[1] = new PreconditionAtomic(new Predicate(18, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(1), TermList.NIL)))), unifier);
			// Source: (line:326, col:11) to (line:326, col:41)
			p[2] = new PreconditionNegation(new PreconditionAtomic(new Predicate(6, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier), 5);
			// Source: (line:327, col:11) to (line:328, col:64)
			p[3] = new PreconditionAtomic(new Predicate(40, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(new TermList(owner.getTermVariable(4), owner.getTermVariable(3)), TermList.NIL))))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #1 of Branch -1 for axiom getInvRelatedFromCurrentStateH [line:325,10 to 328,65]";
		}
	}

	/**
	 * Branch -1 for axiom getInvRelatedFromCurrentStateH
	 * Source: (line:319, col:4) to (line:328, col:319)
	 */
	public static class Axiom40 extends Axiom
{
	/**
	 * Branch -1 for axiom getInvRelatedFromCurrentStateH
	 */
		public Axiom40(Domain owner)
		{
			super(owner, new Predicate(40, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getInvRelatedFromCurrentStateH [line:319,4 to 328,319]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition17(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new Precondition18(owner, unifier)).setComparator(null);
					p.setFirst(true);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom40Branch0(line:319,col:5)";
				case 1: return "Axiom40Branch1(line:319,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom inverseOf
	 * Source: (line:330, col:4) to (line:330, col:330)
	 */
	public static class Axiom41 extends Axiom
{
	/**
	 * Branch -1 for axiom inverseOf
	 */
		public Axiom41(Domain owner)
		{
			super(owner, new Predicate(42, 0, new TermList(owner.getTermConstant(17) /*isPartOf*/, new TermList(owner.getTermConstant(41) /*inverseIsPartOf*/, TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom inverseOf [line:330,4 to 330,330]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom41Branch0(line:330,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom inverseOf
	 * Source: (line:331, col:4) to (line:331, col:331)
	 */
	public static class Axiom42 extends Axiom
{
	/**
	 * Branch -1 for axiom inverseOf
	 */
		public Axiom42(Domain owner)
		{
			super(owner, new Predicate(42, 0, new TermList(owner.getTermConstant(43) /*isRequiredBy*/, new TermList(owner.getTermConstant(44) /*inverseIsRequiredBy*/, TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom inverseOf [line:331,4 to 331,331]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom42Branch0(line:331,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom inverseOf
	 * Source: (line:332, col:4) to (line:332, col:332)
	 */
	public static class Axiom43 extends Axiom
{
	/**
	 * Branch -1 for axiom inverseOf
	 */
		public Axiom43(Domain owner)
		{
			super(owner, new Predicate(42, 0, new TermList(owner.getTermConstant(45) /*isVariantOf*/, new TermList(owner.getTermConstant(46) /*inverseIsVariantOf*/, TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom inverseOf [line:332,4 to 332,332]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom43Branch0(line:332,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getRelatedFromCurrentState
	 * Source: (line:335, col:8) to (line:338, col:68)
	 */
	public static class Precondition19 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition19(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:335, col:9) to (line:335, col:42)
			p[1] = new PreconditionAtomic(new Predicate(42, 5, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			// Source: (line:336, col:9) to (line:336, col:76)
			p[2] = new PreconditionAtomic(new Predicate(40, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(3), new TermList(TermList.NIL, TermList.NIL))))), unifier);
			// Source: (line:337, col:9) to (line:338, col:67)
			p[3] = new PreconditionAssign(new TermCall(new List(new TermList(owner.getTermVariable(4), new TermList(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGetRelated, "((domain)owner).calculateGetRelated"), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), unifier, 0);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getRelatedFromCurrentState [line:335,8 to 338,68]";
		}
	}

	/**
	 * Precondition of branch #1 of Branch -1 for axiom getRelatedFromCurrentState
	 * Source: (line:340, col:8) to (line:342, col:68)
	 */
	public static class Precondition20 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition20(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:340, col:9) to (line:340, col:70)
			p[1] = new PreconditionAtomic(new Predicate(39, 5, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), unifier);
			// Source: (line:341, col:9) to (line:342, col:67)
			p[2] = new PreconditionAssign(new TermCall(new List(new TermList(owner.getTermVariable(4), new TermList(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGetRelated, "((domain)owner).calculateGetRelated"), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #1 of Branch -1 for axiom getRelatedFromCurrentState [line:340,8 to 342,68]";
		}
	}

	/**
	 * Branch -1 for axiom getRelatedFromCurrentState
	 * Source: (line:334, col:4) to (line:342, col:334)
	 */
	public static class Axiom44 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelatedFromCurrentState
	 */
		public Axiom44(Domain owner)
		{
			super(owner, new Predicate(47, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelatedFromCurrentState [line:334,4 to 342,334]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition19(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new Precondition20(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom44Branch0(line:334,col:5)";
				case 1: return "Axiom44Branch1(line:334,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getRelated
	 * Source: (line:344, col:4) to (line:346, col:344)
	 */
	public static class Axiom45 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelated
	 */
		public Axiom45(Domain owner)
		{
			super(owner, new Predicate(48, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelated [line:344,4 to 346,344]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(47, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateGetRelated, "((domain)owner).calculateGetRelated"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom45Branch0(line:344,col:5)";
				case 1: return "Axiom45Branch1(line:344,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getRelatedH
	 * Source: (line:350, col:4) to (line:351, col:350)
	 */
	public static class Axiom46 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelatedH
	 */
		public Axiom46(Domain owner)
		{
			super(owner, new Predicate(49, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(new TermNumber(0.0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL)))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelatedH [line:350,4 to 351,350]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(3), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom46Branch0(line:350,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getRelatedH
	 * Source: (line:353, col:4) to (line:354, col:353)
	 */
	public static class Axiom47 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelatedH
	 */
		public Axiom47(Domain owner)
		{
			super(owner, new Predicate(49, 4, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL)))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelatedH [line:353,4 to 354,353]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(3), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom47Branch0(line:353,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getRelatedH
	 * Source: (line:357, col:8) to (line:361, col:75)
	 */
	public static class Precondition21 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition21(Domain owner, Term[] unifier)
		{
			p = new Precondition[5];
			// Source: (line:357, col:9) to (line:357, col:24)
			p[1] = new PreconditionAtomic(new Predicate(1, 8, new TermList(owner.getTermVariable(3), new TermList(new TermNumber(0.0), TermList.NIL))), unifier);
			// Source: (line:358, col:9) to (line:358, col:49)
			p[2] = new PreconditionAtomic(new Predicate(48, 8, new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			// Source: (line:359, col:9) to (line:359, col:66)
			p[3] = new PreconditionAtomic(new Predicate(48, 8, new TermList(owner.getTermVariable(7), new TermList(owner.getTermVariable(6), new TermList(new TermCall(new List(owner.getTermVariable(3), new TermList(new TermNumber(1.0), TermList.NIL)), StdLib.minus, "StdLib.minus"), new TermList(owner.getTermVariable(4), TermList.NIL))))), unifier);
			// Source: (line:360, col:9) to (line:361, col:74)
			p[4] = new PreconditionAtomic(new Predicate(49, 8, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), new TermList(new TermCall(new List(new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(7), TermList.NIL))), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), TermList.NIL)))))), unifier);
			b = new Term[5][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[4] == null)
			{
				boolean b3changed = false;
				while (b[3] == null)
				{
					boolean b2changed = false;
					while (b[2] == null)
					{
						boolean b1changed = false;
						while (b[1] == null)
						{
							b[1] = p[1].nextBinding(state);
							if (b[1] == null)
								return null;
							else
								bestMatch = Math.max(bestMatch, 1);
							b1changed = true;
						}
						if ( b1changed ) {
							p[2].reset(state);
							p[2].bind(Term.merge(b, 2));
						}
						b[2] = p[2].nextBinding(state);
						if (b[2] == null)
							b[1] = null;
						else
							bestMatch = Math.max(bestMatch, 2);
						b2changed = true;
					}
					if ( b2changed ) {
						p[3].reset(state);
						p[3].bind(Term.merge(b, 3));
					}
					b[3] = p[3].nextBinding(state);
					if (b[3] == null)
						b[2] = null;
					else
						bestMatch = Math.max(bestMatch, 3);
					b3changed = true;
				}
				if ( b3changed ) {
					p[4].reset(state);
					p[4].bind(Term.merge(b, 4));
				}
				b[4] = p[4].nextBinding(state);
				if (b[4] == null)
					b[3] = null;
				else
					bestMatch = Math.max(bestMatch, 4);
			}

			Term[] retVal = Term.merge(b, 5);
			b[4] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getRelatedH [line:357,8 to 361,75]";
		}
	}

	/**
	 * Branch -1 for axiom getRelatedH
	 * Source: (line:356, col:4) to (line:361, col:356)
	 */
	public static class Axiom48 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelatedH
	 */
		public Axiom48(Domain owner)
		{
			super(owner, new Predicate(49, 8, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(5), TermList.NIL)))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelatedH [line:356,4 to 361,356]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition21(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom48Branch0(line:356,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getRelated
	 * Source: (line:363, col:4) to (line:364, col:363)
	 */
	public static class Axiom49 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelated
	 */
		public Axiom49(Domain owner)
		{
			super(owner, new Predicate(48, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelated [line:363,4 to 364,363]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(49, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(TermList.NIL, TermList.NIL)))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom49Branch0(line:363,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom filterElement
	 * Source: (line:368, col:4) to (line:368, col:368)
	 */
	public static class Axiom50 extends Axiom
{
	/**
	 * Branch -1 for axiom filterElement
	 */
		public Axiom50(Domain owner)
		{
			super(owner, new Predicate(50, 1, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterElement [line:368,4 to 368,368]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionNil(1)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom50Branch0(line:368,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom filterElement
	 * Source: (line:371, col:8) to (line:372, col:40)
	 */
	public static class Precondition22 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition22(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:371, col:9) to (line:371, col:30)
			p[1] = new PreconditionAtomic(new Predicate(32, 3, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(0), TermList.NIL))), unifier);
			// Source: (line:372, col:9) to (line:372, col:39)
			p[2] = new PreconditionAtomic(new Predicate(50, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom filterElement [line:371,8 to 372,40]";
		}
	}

	/**
	 * Branch -1 for axiom filterElement
	 * Source: (line:370, col:4) to (line:372, col:370)
	 */
	public static class Axiom51 extends Axiom
{
	/**
	 * Branch -1 for axiom filterElement
	 */
		public Axiom51(Domain owner)
		{
			super(owner, new Predicate(50, 3, new TermList(owner.getTermVariable(0), new TermList(new TermList(new TermList(owner.getTermConstant(32) /*class*/, new TermList(owner.getTermVariable(1), TermList.NIL)), owner.getTermVariable(2)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterElement [line:370,4 to 372,370]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition22(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom51Branch0(line:370,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom filterElement
	 * Source: (line:375, col:8) to (line:376, col:40)
	 */
	public static class Precondition23 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition23(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:375, col:9) to (line:375, col:44)
			p[1] = new PreconditionAtomic(new Predicate(18, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier);
			// Source: (line:376, col:9) to (line:376, col:39)
			p[2] = new PreconditionAtomic(new Predicate(50, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom filterElement [line:375,8 to 376,40]";
		}
	}

	/**
	 * Branch -1 for axiom filterElement
	 * Source: (line:374, col:4) to (line:376, col:374)
	 */
	public static class Axiom52 extends Axiom
{
	/**
	 * Branch -1 for axiom filterElement
	 */
		public Axiom52(Domain owner)
		{
			super(owner, new Predicate(50, 4, new TermList(owner.getTermVariable(0), new TermList(new TermList(new TermList(owner.getTermConstant(18) /*relation*/, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), owner.getTermVariable(3)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterElement [line:374,4 to 376,374]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition23(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom52Branch0(line:374,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom filterElement
	 * Source: (line:379, col:8) to (line:380, col:40)
	 */
	public static class Precondition24 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition24(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:379, col:9) to (line:379, col:44)
			p[1] = new PreconditionAtomic(new Predicate(20, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier);
			// Source: (line:380, col:9) to (line:380, col:39)
			p[2] = new PreconditionAtomic(new Predicate(50, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom filterElement [line:379,8 to 380,40]";
		}
	}

	/**
	 * Branch -1 for axiom filterElement
	 * Source: (line:378, col:4) to (line:380, col:378)
	 */
	public static class Axiom53 extends Axiom
{
	/**
	 * Branch -1 for axiom filterElement
	 */
		public Axiom53(Domain owner)
		{
			super(owner, new Predicate(50, 5, new TermList(owner.getTermVariable(0), new TermList(new TermList(new TermList(owner.getTermConstant(20) /*property*/, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))), owner.getTermVariable(3)), TermList.NIL))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterElement [line:378,4 to 380,378]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition24(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom53Branch0(line:378,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom filterByQueryFromCurrentStateH
	 * Source: (line:383, col:4) to (line:384, col:383)
	 */
	public static class Axiom54 extends Axiom
{
	/**
	 * Branch -1 for axiom filterByQueryFromCurrentStateH
	 */
		public Axiom54(Domain owner)
		{
			super(owner, new Predicate(51, 3, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterByQueryFromCurrentStateH [line:383,4 to 384,383]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(2), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom54Branch0(line:383,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom filterByQueryFromCurrentStateH
	 * Source: (line:388, col:8) to (line:389, col:90)
	 */
	public static class Precondition25 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition25(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:388, col:9) to (line:388, col:39)
			p[1] = new PreconditionAtomic(new Predicate(50, 5, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier);
			// Source: (line:389, col:9) to (line:389, col:89)
			p[2] = new PreconditionAtomic(new Predicate(51, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(4)), TermList.NIL))))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom filterByQueryFromCurrentStateH [line:388,8 to 389,90]";
		}
	}

	/**
	 * Branch -1 for axiom filterByQueryFromCurrentStateH
	 * Source: (line:386, col:4) to (line:391, col:386)
	 */
	public static class Axiom55 extends Axiom
{
	/**
	 * Branch -1 for axiom filterByQueryFromCurrentStateH
	 */
		public Axiom55(Domain owner)
		{
			super(owner, new Predicate(51, 5, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), TermList.NIL))))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterByQueryFromCurrentStateH [line:386,4 to 391,386]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition25(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionAtomic(new Predicate(51, 5, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), TermList.NIL))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom55Branch0(line:386,col:5)";
				case 1: return "Axiom55Branch1(line:386,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom filterByQueryFromCurrentState
	 * Source: (line:394, col:8) to (line:396, col:71)
	 */
	public static class Precondition26 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition26(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:394, col:9) to (line:394, col:71)
			p[1] = new PreconditionAtomic(new Predicate(51, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), unifier);
			// Source: (line:395, col:9) to (line:396, col:70)
			p[2] = new PreconditionAssign(new TermCall(new List(new TermList(owner.getTermVariable(3), new TermList(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateFilterByQuery, "((domain)owner).calculateFilterByQuery"), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), unifier, 0);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom filterByQueryFromCurrentState [line:394,8 to 396,71]";
		}
	}

	/**
	 * Branch -1 for axiom filterByQueryFromCurrentState
	 * Source: (line:393, col:4) to (line:396, col:393)
	 */
	public static class Axiom56 extends Axiom
{
	/**
	 * Branch -1 for axiom filterByQueryFromCurrentState
	 */
		public Axiom56(Domain owner)
		{
			super(owner, new Predicate(52, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterByQueryFromCurrentState [line:393,4 to 396,393]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition26(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom56Branch0(line:393,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom filterByQuery
	 * Source: (line:398, col:4) to (line:400, col:398)
	 */
	public static class Axiom57 extends Axiom
{
	/**
	 * Branch -1 for axiom filterByQuery
	 */
		public Axiom57(Domain owner)
		{
			super(owner, new Predicate(29, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 2);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom filterByQuery [line:398,4 to 400,398]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(52, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier)).setComparator(null);
				break;
				case 1:
					p = (new PreconditionAssign(new TermCall(new List(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)), ((domain)owner).calculateFilterByQuery, "((domain)owner).calculateFilterByQuery"), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom57Branch0(line:398,col:5)";
				case 1: return "Axiom57Branch1(line:398,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getRelated
	 * Source: (line:405, col:8) to (line:406, col:50)
	 */
	public static class Precondition27 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition27(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			// Source: (line:405, col:9) to (line:405, col:54)
			p[1] = new PreconditionAtomic(new Predicate(48, 6, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), unifier);
			// Source: (line:406, col:9) to (line:406, col:49)
			p[2] = new PreconditionAtomic(new Predicate(29, 6, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			b = new Term[3][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[2] == null)
			{
				boolean b1changed = false;
				while (b[1] == null)
				{
					b[1] = p[1].nextBinding(state);
					if (b[1] == null)
						return null;
					else
						bestMatch = Math.max(bestMatch, 1);
					b1changed = true;
				}
				if ( b1changed ) {
					p[2].reset(state);
					p[2].bind(Term.merge(b, 2));
				}
				b[2] = p[2].nextBinding(state);
				if (b[2] == null)
					b[1] = null;
				else
					bestMatch = Math.max(bestMatch, 2);
			}

			Term[] retVal = Term.merge(b, 3);
			b[2] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			b[1] = null;
			b[2] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getRelated [line:405,8 to 406,50]";
		}
	}

	/**
	 * Branch -1 for axiom getRelated
	 * Source: (line:404, col:4) to (line:406, col:404)
	 */
	public static class Axiom58 extends Axiom
{
	/**
	 * Branch -1 for axiom getRelated
	 */
		public Axiom58(Domain owner)
		{
			super(owner, new Predicate(48, 6, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), TermList.NIL)))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getRelated [line:404,4 to 406,404]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition27(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom58Branch0(line:404,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getElementsWithoutRelationH
	 * Source: (line:410, col:4) to (line:412, col:410)
	 */
	public static class Axiom59 extends Axiom
{
	/**
	 * Branch -1 for axiom getElementsWithoutRelationH
	 */
		public Axiom59(Domain owner)
		{
			super(owner, new Predicate(53, 4, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL)))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getElementsWithoutRelationH [line:410,4 to 412,410]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(3), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom59Branch0(line:410,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Conjunct #3 of Precondition of branch #0 of Branch -1 for axiom getElementsWithoutRelationH
	 * Source: (line:420, col:9) to (line:422, col:46)
	 */
	public static class Precondition28 extends Precondition
	{
		Precondition[] p;
		Term[] b;
		int whichClause;

		public Precondition28(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			p[0] = new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);

			p[1] = new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(4), TermList.NIL))), unifier);

			p[2] = new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(5), TermList.NIL))), unifier);

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			p[0].bind(binding);
			p[1].bind(binding);
			p[2].bind(binding);
		}

		protected Term[] nextBindingHelper(State state)
		{
			while (whichClause < 3)
			{
				b = p[whichClause].nextBinding(state);
				if (b != null)
					 return b;
				whichClause++;
			}

			return null;
		}

		@Override
		public String toString()
		{
			return "Conjunct #3 of Precondition of branch #0 of Branch -1 for axiom getElementsWithoutRelationH [line:420,9 to 422,46]";
		}
		protected void resetHelper(State state)
		{
			p[0].reset(state);
			p[1].reset(state);
			p[2].reset(state);
			whichClause = 0;
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getElementsWithoutRelationH
	 * Source: (line:417, col:8) to (line:424, col:82)
	 */
	public static class Precondition29 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition29(Domain owner, Term[] unifier)
		{
			p = new Precondition[6];
			// Source: (line:417, col:9) to (line:417, col:42)
			p[1] = new PreconditionAtomic(new Predicate(42, 9, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(6), TermList.NIL))), unifier);
			// Source: (line:418, col:9) to (line:418, col:52)
			p[2] = new PreconditionAtomic(new Predicate(48, 9, new TermList(owner.getTermVariable(7), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(6), TermList.NIL)))), unifier);
			// Source: (line:419, col:9) to (line:419, col:43)
			p[3] = new PreconditionAtomic(new Predicate(7, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(7), TermList.NIL))), unifier);
			// Source: (line:420, col:9) to (line:422, col:46)
			p[4] = new Precondition28(owner, unifier) /*Conjunct 4 of Precondition of branch #0 of Branch -1 for axiom getElementsWithoutRelationH*/;
			// Source: (line:423, col:9) to (line:424, col:81)
			p[5] = new PreconditionAtomic(new Predicate(53, 9, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(4)), new TermList(owner.getTermVariable(5), TermList.NIL)))))), unifier);
			b = new Term[6][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[5] == null)
			{
				boolean b4changed = false;
				while (b[4] == null)
				{
					boolean b3changed = false;
					while (b[3] == null)
					{
						boolean b2changed = false;
						while (b[2] == null)
						{
							boolean b1changed = false;
							while (b[1] == null)
							{
								b[1] = p[1].nextBinding(state);
								if (b[1] == null)
									return null;
								else
									bestMatch = Math.max(bestMatch, 1);
								b1changed = true;
							}
							if ( b1changed ) {
								p[2].reset(state);
								p[2].bind(Term.merge(b, 2));
							}
							b[2] = p[2].nextBinding(state);
							if (b[2] == null)
								b[1] = null;
							else
								bestMatch = Math.max(bestMatch, 2);
							b2changed = true;
						}
						if ( b2changed ) {
							p[3].reset(state);
							p[3].bind(Term.merge(b, 3));
						}
						b[3] = p[3].nextBinding(state);
						if (b[3] == null)
							b[2] = null;
						else
							bestMatch = Math.max(bestMatch, 3);
						b3changed = true;
					}
					if ( b3changed ) {
						p[4].reset(state);
						p[4].bind(Term.merge(b, 4));
					}
					b[4] = p[4].nextBinding(state);
					if (b[4] == null)
						b[3] = null;
					else
						bestMatch = Math.max(bestMatch, 4);
					b4changed = true;
				}
				if ( b4changed ) {
					p[5].reset(state);
					p[5].bind(Term.merge(b, 5));
				}
				b[5] = p[5].nextBinding(state);
				if (b[5] == null)
					b[4] = null;
				else
					bestMatch = Math.max(bestMatch, 5);
			}

			Term[] retVal = Term.merge(b, 6);
			b[5] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			p[5].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getElementsWithoutRelationH [line:417,8 to 424,82]";
		}
	}

	/**
	 * Conjunct #3 of Precondition of branch #1 of Branch -1 for axiom getElementsWithoutRelationH
	 * Source: (line:429, col:9) to (line:431, col:46)
	 */
	public static class Precondition30 extends Precondition
	{
		Precondition[] p;
		Term[] b;
		int whichClause;

		public Precondition30(Domain owner, Term[] unifier)
		{
			p = new Precondition[3];
			p[0] = new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);

			p[1] = new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(4), TermList.NIL))), unifier);

			p[2] = new PreconditionAtomic(new Predicate(6, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(5), TermList.NIL))), unifier);

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			p[0].bind(binding);
			p[1].bind(binding);
			p[2].bind(binding);
		}

		protected Term[] nextBindingHelper(State state)
		{
			while (whichClause < 3)
			{
				b = p[whichClause].nextBinding(state);
				if (b != null)
					 return b;
				whichClause++;
			}

			return null;
		}

		@Override
		public String toString()
		{
			return "Conjunct #3 of Precondition of branch #1 of Branch -1 for axiom getElementsWithoutRelationH [line:429,9 to 431,46]";
		}
		protected void resetHelper(State state)
		{
			p[0].reset(state);
			p[1].reset(state);
			p[2].reset(state);
			whichClause = 0;
		}
	}

	/**
	 * Precondition of branch #1 of Branch -1 for axiom getElementsWithoutRelationH
	 * Source: (line:426, col:8) to (line:433, col:82)
	 */
	public static class Precondition31 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition31(Domain owner, Term[] unifier)
		{
			p = new Precondition[6];
			// Source: (line:426, col:9) to (line:426, col:42)
			p[1] = new PreconditionAtomic(new Predicate(42, 9, new TermList(owner.getTermVariable(6), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier);
			// Source: (line:427, col:9) to (line:427, col:52)
			p[2] = new PreconditionAtomic(new Predicate(48, 9, new TermList(owner.getTermVariable(7), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(6), TermList.NIL)))), unifier);
			// Source: (line:428, col:9) to (line:428, col:43)
			p[3] = new PreconditionAtomic(new Predicate(7, 9, new TermList(owner.getTermVariable(8), new TermList(owner.getTermVariable(7), TermList.NIL))), unifier);
			// Source: (line:429, col:9) to (line:431, col:46)
			p[4] = new Precondition30(owner, unifier) /*Conjunct 4 of Precondition of branch #1 of Branch -1 for axiom getElementsWithoutRelationH*/;
			// Source: (line:432, col:9) to (line:433, col:81)
			p[5] = new PreconditionAtomic(new Predicate(53, 9, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(4)), new TermList(owner.getTermVariable(5), TermList.NIL)))))), unifier);
			b = new Term[6][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[5] == null)
			{
				boolean b4changed = false;
				while (b[4] == null)
				{
					boolean b3changed = false;
					while (b[3] == null)
					{
						boolean b2changed = false;
						while (b[2] == null)
						{
							boolean b1changed = false;
							while (b[1] == null)
							{
								b[1] = p[1].nextBinding(state);
								if (b[1] == null)
									return null;
								else
									bestMatch = Math.max(bestMatch, 1);
								b1changed = true;
							}
							if ( b1changed ) {
								p[2].reset(state);
								p[2].bind(Term.merge(b, 2));
							}
							b[2] = p[2].nextBinding(state);
							if (b[2] == null)
								b[1] = null;
							else
								bestMatch = Math.max(bestMatch, 2);
							b2changed = true;
						}
						if ( b2changed ) {
							p[3].reset(state);
							p[3].bind(Term.merge(b, 3));
						}
						b[3] = p[3].nextBinding(state);
						if (b[3] == null)
							b[2] = null;
						else
							bestMatch = Math.max(bestMatch, 3);
						b3changed = true;
					}
					if ( b3changed ) {
						p[4].reset(state);
						p[4].bind(Term.merge(b, 4));
					}
					b[4] = p[4].nextBinding(state);
					if (b[4] == null)
						b[3] = null;
					else
						bestMatch = Math.max(bestMatch, 4);
					b4changed = true;
				}
				if ( b4changed ) {
					p[5].reset(state);
					p[5].bind(Term.merge(b, 5));
				}
				b[5] = p[5].nextBinding(state);
				if (b[5] == null)
					b[4] = null;
				else
					bestMatch = Math.max(bestMatch, 5);
			}

			Term[] retVal = Term.merge(b, 6);
			b[5] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			p[5].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
			b[5] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #1 of Branch -1 for axiom getElementsWithoutRelationH [line:426,8 to 433,82]";
		}
	}

	/**
	 * Branch -1 for axiom getElementsWithoutRelationH
	 * Source: (line:414, col:4) to (line:436, col:414)
	 */
	public static class Axiom60 extends Axiom
{
	/**
	 * Branch -1 for axiom getElementsWithoutRelationH
	 */
		public Axiom60(Domain owner)
		{
			super(owner, new Predicate(53, 9, new TermList(owner.getTermVariable(0), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(2)), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(5), TermList.NIL)))))), 3);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getElementsWithoutRelationH [line:414,4 to 436,414]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition29(owner, unifier)).setComparator(null);
				break;
				case 1:
					p = (new Precondition31(owner, unifier)).setComparator(null);
				break;
				case 2:
					p = (new PreconditionAtomic(new Predicate(53, 9, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(4), new TermList(new TermList(owner.getTermVariable(1), owner.getTermVariable(5)), TermList.NIL)))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom60Branch0(line:414,col:5)";
				case 1: return "Axiom60Branch1(line:414,col:5)";
				case 2: return "Axiom60Branch2(line:414,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getElementsWithoutRelation
	 * Source: (line:438, col:4) to (line:439, col:438)
	 */
	public static class Axiom61 extends Axiom
{
	/**
	 * Branch -1 for axiom getElementsWithoutRelation
	 */
		public Axiom61(Domain owner)
		{
			super(owner, new Predicate(54, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getElementsWithoutRelation [line:438,4 to 439,438]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(53, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, new TermList(TermList.NIL, TermList.NIL)))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom61Branch0(line:438,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getSortByH
	 * Source: (line:443, col:4) to (line:444, col:443)
	 */
	public static class Axiom62 extends Axiom
{
	/**
	 * Branch -1 for axiom getSortByH
	 */
		public Axiom62(Domain owner)
		{
			super(owner, new Predicate(55, 3, new TermList(owner.getTermVariable(0), new TermList(TermList.NIL, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getSortByH [line:443,4 to 444,443]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAssign(owner.getTermVariable(2), unifier, 0)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom62Branch0(line:443,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getSortByH
	 * Source: (line:447, col:8) to (line:451, col:61)
	 */
	public static class Precondition32 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition32(Domain owner, Term[] unifier)
		{
			p = new Precondition[5];
			// Source: (line:447, col:9) to (line:447, col:32)
			p[1] = new PreconditionAtomic(new Predicate(1, 6, new TermList(owner.getTermVariable(1), new TermList(TermList.NIL, TermList.NIL))), unifier);
			// Source: (line:448, col:9) to (line:448, col:65)
			p[2] = new PreconditionAtomic(new Predicate(54, 6, new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), unifier);
			// Source: (line:449, col:9) to (line:449, col:49)
			p[3] = new PreconditionAtomic(new Predicate(10, 6, new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(4), TermList.NIL)))), unifier);
			// Source: (line:450, col:9) to (line:451, col:60)
			p[4] = new PreconditionAtomic(new Predicate(55, 6, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(5), new TermList(owner.getTermVariable(2), new TermList(new TermCall(new List(new TermList(owner.getTermVariable(4), new TermList(owner.getTermVariable(3), TermList.NIL)), TermList.NIL), ((domain)owner).calculateConcatList, "((domain)owner).calculateConcatList"), TermList.NIL))))), unifier);
			b = new Term[5][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[4] == null)
			{
				boolean b3changed = false;
				while (b[3] == null)
				{
					boolean b2changed = false;
					while (b[2] == null)
					{
						boolean b1changed = false;
						while (b[1] == null)
						{
							b[1] = p[1].nextBinding(state);
							if (b[1] == null)
								return null;
							else
								bestMatch = Math.max(bestMatch, 1);
							b1changed = true;
						}
						if ( b1changed ) {
							p[2].reset(state);
							p[2].bind(Term.merge(b, 2));
						}
						b[2] = p[2].nextBinding(state);
						if (b[2] == null)
							b[1] = null;
						else
							bestMatch = Math.max(bestMatch, 2);
						b2changed = true;
					}
					if ( b2changed ) {
						p[3].reset(state);
						p[3].bind(Term.merge(b, 3));
					}
					b[3] = p[3].nextBinding(state);
					if (b[3] == null)
						b[2] = null;
					else
						bestMatch = Math.max(bestMatch, 3);
					b3changed = true;
				}
				if ( b3changed ) {
					p[4].reset(state);
					p[4].bind(Term.merge(b, 4));
				}
				b[4] = p[4].nextBinding(state);
				if (b[4] == null)
					b[3] = null;
				else
					bestMatch = Math.max(bestMatch, 4);
			}

			Term[] retVal = Term.merge(b, 5);
			b[4] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			p[4].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
			b[4] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getSortByH [line:447,8 to 451,61]";
		}
	}

	/**
	 * Branch -1 for axiom getSortByH
	 * Source: (line:446, col:4) to (line:451, col:446)
	 */
	public static class Axiom63 extends Axiom
{
	/**
	 * Branch -1 for axiom getSortByH
	 */
		public Axiom63(Domain owner)
		{
			super(owner, new Predicate(55, 6, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(owner.getTermVariable(3), TermList.NIL))))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getSortByH [line:446,4 to 451,446]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition32(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom63Branch0(line:446,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Branch -1 for axiom getSortBy
	 * Source: (line:453, col:4) to (line:454, col:453)
	 */
	public static class Axiom64 extends Axiom
{
	/**
	 * Branch -1 for axiom getSortBy
	 */
		public Axiom64(Domain owner)
		{
			super(owner, new Predicate(56, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getSortBy [line:453,4 to 454,453]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new PreconditionAtomic(new Predicate(55, 3, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), new TermList(TermList.NIL, TermList.NIL))))), unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom64Branch0(line:453,col:5)";
				default: return null;
			}
		}
	}

	/**
	 * Precondition of branch #0 of Branch -1 for axiom getSkillAndKnowledgeLevels
	 * Source: (line:459, col:8) to (line:461, col:26)
	 */
	public static class Precondition33 extends Precondition
	{
		Precondition[] p;
		Term[][] b;

		public Precondition33(Domain owner, Term[] unifier)
		{
			p = new Precondition[4];
			// Source: (line:459, col:9) to (line:459, col:26)
			p[1] = new PreconditionAtomic(new Predicate(2, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			// Source: (line:460, col:9) to (line:460, col:27)
			p[2] = new PreconditionAtomic(new Predicate(3, 4, new TermList(owner.getTermVariable(3), new TermList(owner.getTermVariable(2), TermList.NIL))), unifier);
			// Source: (line:461, col:9) to (line:461, col:25)
			p[3] = new PreconditionAtomic(new Predicate(2, 4, new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(3), TermList.NIL))), unifier);
			b = new Term[4][];
			b[0] = unifier;
			b[0] = Term.merge( b, 1 );

			setFirst(false);
		}

		public void bind(Term[] binding)
		{
			b[0] = binding;
			b[0] = Term.merge( b, 1 );
			p[1].bind(binding);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}

		protected Term[] nextBindingHelper(State state)
		{
			bestMatch = 0;
			while (b[3] == null)
			{
				boolean b2changed = false;
				while (b[2] == null)
				{
					boolean b1changed = false;
					while (b[1] == null)
					{
						b[1] = p[1].nextBinding(state);
						if (b[1] == null)
							return null;
						else
							bestMatch = Math.max(bestMatch, 1);
						b1changed = true;
					}
					if ( b1changed ) {
						p[2].reset(state);
						p[2].bind(Term.merge(b, 2));
					}
					b[2] = p[2].nextBinding(state);
					if (b[2] == null)
						b[1] = null;
					else
						bestMatch = Math.max(bestMatch, 2);
					b2changed = true;
				}
				if ( b2changed ) {
					p[3].reset(state);
					p[3].bind(Term.merge(b, 3));
				}
				b[3] = p[3].nextBinding(state);
				if (b[3] == null)
					b[2] = null;
				else
					bestMatch = Math.max(bestMatch, 3);
			}

			Term[] retVal = Term.merge(b, 4);
			b[3] = null;
			return retVal;
		}

		protected void resetHelper(State state)
		{
			p[1].reset(state);
			p[2].reset(state);
			p[3].reset(state);
			b[1] = null;
			b[2] = null;
			b[3] = null;
		}
		@Override
		public String toString()
		{
			return "Precondition of branch #0 of Branch -1 for axiom getSkillAndKnowledgeLevels [line:459,8 to 461,26]";
		}
	}

	/**
	 * Branch -1 for axiom getSkillAndKnowledgeLevels
	 * Source: (line:458, col:4) to (line:461, col:458)
	 */
	public static class Axiom65 extends Axiom
{
	/**
	 * Branch -1 for axiom getSkillAndKnowledgeLevels
	 */
		public Axiom65(Domain owner)
		{
			super(owner, new Predicate(57, 4, new TermList(owner.getTermVariable(0), new TermList(owner.getTermVariable(1), new TermList(owner.getTermVariable(2), TermList.NIL)))), 1);
		}

		@Override
		public String toString()
		{
			return "Branch -1 for axiom getSkillAndKnowledgeLevels [line:458,4 to 461,458]";
		}
		public Precondition getIterator(State state, Term[] unifier, int which)
		{
			Precondition p;

			switch (which)
			{
				case 0:
					p = (new Precondition33(owner, unifier)).setComparator(null);
				break;
				default:
					return null;
			}

			p.reset(state);

			return p;
		}

		public String getLabel(int which)
		{
			switch (which)
			{
				case 0: return "Axiom65Branch0(line:458,col:5)";
				default: return null;
			}
		}
	}

	public static final String sourcePath = "/Users/gcc/workspace/automated-learning-design/planner/build/domain.lisp";
	public static final long sourceLastModified = 1328745883000L;

	public Reverse calculateReverse = new Reverse();

	public DivideList calculateDivideList = new DivideList();

	public GetLearnerProperty calculateGetLearnerProperty = new GetLearnerProperty();

	public ConcatList calculateConcatList = new ConcatList();

	public GetElements calculateGetElements = new GetElements();

	public GetPropertyValue calculateGetPropertyValue = new GetPropertyValue();

	public GetRelated calculateGetRelated = new GetRelated();

	public FilterByQuery calculateFilterByQuery = new FilterByQuery();

	public GetUUID calculateGetUUID = new GetUUID();

	public GetProduct calculateGetProduct = new GetProduct();

	public Groupings calculateGroupings = new Groupings();

	public GetId calculateGetId = new GetId();

	public domain()
	{
		constants = new String[95];
		constants[0] = "same";
		constants[1] = "different";
		constants[2] = "first";
		constants[3] = "rest";
		constants[4] = "length";
		constants[5] = "last";
		constants[6] = "exist";
		constants[7] = "assignIterator";
		constants[8] = "removeElement";
		constants[9] = "removeH";
		constants[10] = "removeElements";
		constants[11] = "removeElementsH";
		constants[12] = "divideList";
		constants[13] = "divideLists";
		constants[14] = "divideListsH";
		constants[15] = "currentLDElement";
		constants[16] = "Class";
		constants[17] = "isPartOf";
		constants[18] = "relation";
		constants[19] = "hasGoal";
		constants[20] = "property";
		constants[21] = "hasParticipant";
		constants[22] = "hasAlreadySeen";
		constants[23] = "hasGroup";
		constants[24] = "hasRole";
		constants[25] = "getLearnerPropertyFromCurrentStateH";
		constants[26] = "getLearnerPropertyFromCurrentState";
		constants[27] = "getLearnerProperty";
		constants[28] = "getLearnersHaveAlreadySeenAnyH";
		constants[29] = "filterByQuery";
		constants[30] = "getLearnersHaveAlreadySeenAny";
		constants[31] = "getElementsByTypeFromCurrentStateH";
		constants[32] = "class";
		constants[33] = "getElementsByTypeFromCurrentState";
		constants[34] = "getElementsFromCurrentState";
		constants[35] = "getElements";
		constants[36] = "getPropertyValueFromCurrentStateH";
		constants[37] = "getPropertyValueFromCurrentState";
		constants[38] = "getPropertyValue";
		constants[39] = "getRelatedFromCurrentStateH";
		constants[40] = "getInvRelatedFromCurrentStateH";
		constants[41] = "inverseIsPartOf";
		constants[42] = "inverseOf";
		constants[43] = "isRequiredBy";
		constants[44] = "inverseIsRequiredBy";
		constants[45] = "isVariantOf";
		constants[46] = "inverseIsVariantOf";
		constants[47] = "getRelatedFromCurrentState";
		constants[48] = "getRelated";
		constants[49] = "getRelatedH";
		constants[50] = "filterElement";
		constants[51] = "filterByQueryFromCurrentStateH";
		constants[52] = "filterByQueryFromCurrentState";
		constants[53] = "getElementsWithoutRelationH";
		constants[54] = "getElementsWithoutRelation";
		constants[55] = "getSortByH";
		constants[56] = "getSortBy";
		constants[57] = "getSkillAndKnowledgeLevels";
		constants[58] = "learning-design";
		constants[59] = "identifier";
		constants[60] = "UoL";
		constants[61] = "method";
		constants[62] = "Skill";
		constants[63] = "Attitude";
		constants[64] = "play";
		constants[65] = "Script";
		constants[66] = "rp";
		constants[67] = "group";
		constants[68] = "as";
		constants[69] = "role-part";
		constants[70] = "GroupActivity";
		constants[71] = "role-ref";
		constants[72] = "ref";
		constants[73] = "activity-structure-ref";
		constants[74] = "activity-structure";
		constants[75] = "structure-type";
		constants[76] = "selection";
		constants[77] = "CognitiveCompetency";
		constants[78] = "sequence";
		constants[79] = "Session";
		constants[80] = "createSession";
		constants[81] = "title";
		constants[82] = "getTitles";
		constants[83] = "none";
		constants[84] = "scenario";
		constants[85] = "act";
		constants[86] = "IndividualPhase";
		constants[87] = "SharePhase";
		constants[88] = "positive-interdependence";
		constants[89] = "individual-accountability";
		constants[90] = "knowledge-construction";
		constants[91] = "hasExperience";
		constants[92] = "high";
		constants[93] = "ExpertPhase";
		constants[94] = "JigsawPhase";

		compoundTasks = new String[25];
		compoundTasks[0] = "addUsersToGroup";
		compoundTasks[1] = "removeUsersFromGroup";
		compoundTasks[2] = "addUsersToRole";
		compoundTasks[3] = "removeUsersFromRole";
		compoundTasks[4] = "createUoL";
		compoundTasks[5] = "createLDUoL";
		compoundTasks[6] = "distributeUoL";
		compoundTasks[7] = "createLDScript";
		compoundTasks[8] = "createScript";
		compoundTasks[9] = "distributeGroupActivity";
		compoundTasks[10] = "createLDGroupActivity";
		compoundTasks[11] = "createGroupActivity";
		compoundTasks[12] = "createLDSessions";
		compoundTasks[13] = "createSessions";
		compoundTasks[14] = "createLDSession";
		compoundTasks[15] = "text";
		compoundTasks[16] = "createIndividualPhase";
		compoundTasks[17] = "createLDIndividualPhase";
		compoundTasks[18] = "createIndividualGroupActivities";
		compoundTasks[19] = "createSharePhase";
		compoundTasks[20] = "createLDSharePhase";
		compoundTasks[21] = "createLDExpertPhase";
		compoundTasks[22] = "createLDJigsawPhase";
		compoundTasks[23] = "createExpertPhase";
		compoundTasks[24] = "createJigsawPhase";

		primitiveTasks = new String[9];
		primitiveTasks[0] = "!startLDElement";
		primitiveTasks[1] = "!endLDElement";
		primitiveTasks[2] = "!text";
		primitiveTasks[3] = "!addUserToGroup";
		primitiveTasks[4] = "!removeUserFromGroup";
		primitiveTasks[5] = "!addUserToRole";
		primitiveTasks[6] = "!removeUserFromRole";
		primitiveTasks[7] = "!!addInWorldState";
		primitiveTasks[8] = "!!removeFromWorldState";

		initializeTermVariables(15);

		initializeTermConstants();

		methods = new Method[25][];

		methods[0] = new Method[2];
		methods[0][0] = new Method0(this);
		methods[0][1] = new Method1(this);

		methods[1] = new Method[2];
		methods[1][0] = new Method2(this);
		methods[1][1] = new Method3(this);

		methods[2] = new Method[2];
		methods[2][0] = new Method4(this);
		methods[2][1] = new Method5(this);

		methods[3] = new Method[2];
		methods[3][0] = new Method6(this);
		methods[3][1] = new Method7(this);

		methods[4] = new Method[1];
		methods[4][0] = new Method9(this);

		methods[5] = new Method[1];
		methods[5][0] = new Method8(this);

		methods[6] = new Method[2];
		methods[6][0] = new Method10(this);
		methods[6][1] = new Method11(this);

		methods[7] = new Method[1];
		methods[7][0] = new Method12(this);

		methods[8] = new Method[1];
		methods[8][0] = new Method29(this);

		methods[9] = new Method[2];
		methods[9][0] = new Method13(this);
		methods[9][1] = new Method14(this);

		methods[10] = new Method[1];
		methods[10][0] = new Method15(this);

		methods[11] = new Method[2];
		methods[11][0] = new Method16(this);
		methods[11][1] = new Method17(this);

		methods[12] = new Method[1];
		methods[12][0] = new Method18(this);

		methods[13] = new Method[2];
		methods[13][0] = new Method19(this);
		methods[13][1] = new Method20(this);

		methods[14] = new Method[1];
		methods[14][0] = new Method21(this);

		methods[15] = new Method[1];
		methods[15][0] = new Method22(this);

		methods[16] = new Method[1];
		methods[16][0] = new Method24(this);

		methods[17] = new Method[1];
		methods[17][0] = new Method23(this);

		methods[18] = new Method[2];
		methods[18][0] = new Method25(this);
		methods[18][1] = new Method26(this);

		methods[19] = new Method[1];
		methods[19][0] = new Method28(this);

		methods[20] = new Method[1];
		methods[20][0] = new Method27(this);

		methods[21] = new Method[1];
		methods[21][0] = new Method30(this);

		methods[22] = new Method[1];
		methods[22][0] = new Method33(this);

		methods[23] = new Method[2];
		methods[23][0] = new Method31(this);
		methods[23][1] = new Method32(this);

		methods[24] = new Method[1];
		methods[24][0] = new Method34(this);


		ops = new Operator[9][];

		ops[0] = new Operator[3];
		ops[0][0] = new Operator0(this);
		ops[0][1] = new Operator1(this);
		ops[0][2] = new Operator3(this);

		ops[1] = new Operator[2];
		ops[1][0] = new Operator2(this);
		ops[1][1] = new Operator4(this);

		ops[2] = new Operator[1];
		ops[2][0] = new Operator5(this);

		ops[3] = new Operator[1];
		ops[3][0] = new Operator6(this);

		ops[4] = new Operator[1];
		ops[4][0] = new Operator7(this);

		ops[5] = new Operator[1];
		ops[5][0] = new Operator8(this);

		ops[6] = new Operator[1];
		ops[6][0] = new Operator9(this);

		ops[7] = new Operator[1];
		ops[7][0] = new Operator10(this);

		ops[8] = new Operator[1];
		ops[8][0] = new Operator11(this);

		axioms = new Axiom[95][];

		axioms[0] = new Axiom[1];
		axioms[0][0] = new Axiom0(this);

		axioms[1] = new Axiom[1];
		axioms[1][0] = new Axiom1(this);

		axioms[2] = new Axiom[2];
		axioms[2][0] = new Axiom2(this);
		axioms[2][1] = new Axiom3(this);

		axioms[3] = new Axiom[2];
		axioms[3][0] = new Axiom4(this);
		axioms[3][1] = new Axiom5(this);

		axioms[4] = new Axiom[2];
		axioms[4][0] = new Axiom6(this);
		axioms[4][1] = new Axiom7(this);

		axioms[5] = new Axiom[2];
		axioms[5][0] = new Axiom8(this);
		axioms[5][1] = new Axiom9(this);

		axioms[6] = new Axiom[2];
		axioms[6][0] = new Axiom10(this);
		axioms[6][1] = new Axiom11(this);

		axioms[7] = new Axiom[2];
		axioms[7][0] = new Axiom12(this);
		axioms[7][1] = new Axiom13(this);

		axioms[8] = new Axiom[1];
		axioms[8][0] = new Axiom14(this);

		axioms[9] = new Axiom[3];
		axioms[9][0] = new Axiom15(this);
		axioms[9][1] = new Axiom16(this);
		axioms[9][2] = new Axiom17(this);

		axioms[10] = new Axiom[1];
		axioms[10][0] = new Axiom18(this);

		axioms[11] = new Axiom[2];
		axioms[11][0] = new Axiom19(this);
		axioms[11][1] = new Axiom20(this);

		axioms[12] = new Axiom[1];
		axioms[12][0] = new Axiom21(this);

		axioms[13] = new Axiom[1];
		axioms[13][0] = new Axiom22(this);

		axioms[14] = new Axiom[2];
		axioms[14][0] = new Axiom23(this);
		axioms[14][1] = new Axiom24(this);

		axioms[15] = new Axiom[0];

		axioms[16] = new Axiom[0];

		axioms[17] = new Axiom[0];

		axioms[18] = new Axiom[0];

		axioms[19] = new Axiom[0];

		axioms[20] = new Axiom[0];

		axioms[21] = new Axiom[0];

		axioms[22] = new Axiom[0];

		axioms[23] = new Axiom[0];

		axioms[24] = new Axiom[0];

		axioms[25] = new Axiom[1];
		axioms[25][0] = new Axiom25(this);

		axioms[26] = new Axiom[1];
		axioms[26][0] = new Axiom26(this);

		axioms[27] = new Axiom[1];
		axioms[27][0] = new Axiom27(this);

		axioms[28] = new Axiom[3];
		axioms[28][0] = new Axiom28(this);
		axioms[28][1] = new Axiom29(this);
		axioms[28][2] = new Axiom30(this);

		axioms[29] = new Axiom[1];
		axioms[29][0] = new Axiom57(this);

		axioms[30] = new Axiom[1];
		axioms[30][0] = new Axiom31(this);

		axioms[31] = new Axiom[1];
		axioms[31][0] = new Axiom32(this);

		axioms[32] = new Axiom[0];

		axioms[33] = new Axiom[1];
		axioms[33][0] = new Axiom33(this);

		axioms[34] = new Axiom[1];
		axioms[34][0] = new Axiom34(this);

		axioms[35] = new Axiom[1];
		axioms[35][0] = new Axiom35(this);

		axioms[36] = new Axiom[1];
		axioms[36][0] = new Axiom36(this);

		axioms[37] = new Axiom[1];
		axioms[37][0] = new Axiom37(this);

		axioms[38] = new Axiom[1];
		axioms[38][0] = new Axiom38(this);

		axioms[39] = new Axiom[1];
		axioms[39][0] = new Axiom39(this);

		axioms[40] = new Axiom[1];
		axioms[40][0] = new Axiom40(this);

		axioms[41] = new Axiom[0];

		axioms[42] = new Axiom[3];
		axioms[42][0] = new Axiom41(this);
		axioms[42][1] = new Axiom42(this);
		axioms[42][2] = new Axiom43(this);

		axioms[43] = new Axiom[0];

		axioms[44] = new Axiom[0];

		axioms[45] = new Axiom[0];

		axioms[46] = new Axiom[0];

		axioms[47] = new Axiom[1];
		axioms[47][0] = new Axiom44(this);

		axioms[48] = new Axiom[3];
		axioms[48][0] = new Axiom45(this);
		axioms[48][1] = new Axiom49(this);
		axioms[48][2] = new Axiom58(this);

		axioms[49] = new Axiom[3];
		axioms[49][0] = new Axiom46(this);
		axioms[49][1] = new Axiom47(this);
		axioms[49][2] = new Axiom48(this);

		axioms[50] = new Axiom[4];
		axioms[50][0] = new Axiom50(this);
		axioms[50][1] = new Axiom51(this);
		axioms[50][2] = new Axiom52(this);
		axioms[50][3] = new Axiom53(this);

		axioms[51] = new Axiom[2];
		axioms[51][0] = new Axiom54(this);
		axioms[51][1] = new Axiom55(this);

		axioms[52] = new Axiom[1];
		axioms[52][0] = new Axiom56(this);

		axioms[53] = new Axiom[2];
		axioms[53][0] = new Axiom59(this);
		axioms[53][1] = new Axiom60(this);

		axioms[54] = new Axiom[1];
		axioms[54][0] = new Axiom61(this);

		axioms[55] = new Axiom[2];
		axioms[55][0] = new Axiom62(this);
		axioms[55][1] = new Axiom63(this);

		axioms[56] = new Axiom[1];
		axioms[56][0] = new Axiom64(this);

		axioms[57] = new Axiom[1];
		axioms[57][0] = new Axiom65(this);

		axioms[58] = new Axiom[0];

		axioms[59] = new Axiom[0];

		axioms[60] = new Axiom[0];

		axioms[61] = new Axiom[0];

		axioms[62] = new Axiom[0];

		axioms[63] = new Axiom[0];

		axioms[64] = new Axiom[0];

		axioms[65] = new Axiom[0];

		axioms[66] = new Axiom[0];

		axioms[67] = new Axiom[0];

		axioms[68] = new Axiom[0];

		axioms[69] = new Axiom[0];

		axioms[70] = new Axiom[0];

		axioms[71] = new Axiom[0];

		axioms[72] = new Axiom[0];

		axioms[73] = new Axiom[0];

		axioms[74] = new Axiom[0];

		axioms[75] = new Axiom[0];

		axioms[76] = new Axiom[0];

		axioms[77] = new Axiom[0];

		axioms[78] = new Axiom[0];

		axioms[79] = new Axiom[0];

		axioms[80] = new Axiom[0];

		axioms[81] = new Axiom[0];

		axioms[82] = new Axiom[0];

		axioms[83] = new Axiom[0];

		axioms[84] = new Axiom[0];

		axioms[85] = new Axiom[0];

		axioms[86] = new Axiom[0];

		axioms[87] = new Axiom[0];

		axioms[88] = new Axiom[0];

		axioms[89] = new Axiom[0];

		axioms[90] = new Axiom[0];

		axioms[91] = new Axiom[0];

		axioms[92] = new Axiom[0];

		axioms[93] = new Axiom[0];

		axioms[94] = new Axiom[0];

	}
}