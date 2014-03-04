package br.usp.ime.lapessc.courseware.planner;

import br.usp.ime.lapessc.courseware.model.LDElement;
import br.usp.ime.lapessc.courseware.model.PublicTask;

public interface Solver {

	public LDElement solve(PublicTask initialTask, String initialState);
	
	public void setMediatorURL(String URL);

}
