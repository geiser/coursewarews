
import java.util.*;

import com.gamalocus.jshop2rt.Plan;

public class gui{
	public static void main(String[] args) {
		LinkedList<Plan> plans = problem.getPlans();
		ListIterator<Plan> it = plans.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString(problem.owner));
		}      
		//new JSHOP2GUI();
	} 
}
