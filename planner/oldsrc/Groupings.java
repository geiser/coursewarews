
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.gamalocus.jshop2rt.Calculate;
import com.gamalocus.jshop2rt.List;
import com.gamalocus.jshop2rt.Term;
import com.gamalocus.jshop2rt.TermList;
import com.gamalocus.jshop2rt.TermNumber;


public class Groupings implements Calculate {
    
    private int sumOfIntegers(int[] array) {
        int result = 0;
        for (int element : array) {
            result += element;
        }
        return result;
    }
    
    private int[] generateGrayCode(int value, int base, int digits) {
        int[] baseN = new int[digits];
        int[] gray = new int[digits];
        
        int tempvalue = value;
        for (int i = 0; i < digits; i++) {
            baseN[i] = tempvalue % base;
            tempvalue = tempvalue / base;
        }
        
        int shift = 0;
        for (int i = digits - 1; i >= 0; i--) {
            gray[i] = (baseN[i] - shift) % base;
            shift += gray[i] - base;
        }
        
        return gray;
    }
    
    @SuppressWarnings("unchecked")
	private Set<Set<Set<Term>>> getAllGroupings(Term[] objects, int[] groups) {
    
        Set<Set<Set<Term>>> groupings = new HashSet<Set<Set<Term>>>();
    
        // .. calculate nro total of elements
        int nro = 0;
        for (int i = 0; i < groups.length; i++) {
            nro += groups[i];
        }
        if (objects.length != nro) {
           throw new IllegalArgumentException("The number of objects " + objects + "must be equals to sum of groups number" + groups);
        }
    
        // .. obtaing gray code
        int size = (int) Math.pow(groups.length, (nro - 1));
        int[][] grayCode = new int[size][nro];
        for (int i = 0; i < size; i++) {
            grayCode[i] = generateGrayCode(i , groups.length, nro);
        }
        
        // .. evaluate gray code to find groupings
        java.util.List<Integer> hashCodes = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            
            int[] groupsCopy = new int[groups.length];
            System.arraycopy(groups, 0, groupsCopy, 0, groups.length);
            for (int j = 0; j < grayCode[i].length; j++) {
                int idxGroup = grayCode[i][j];
                if (groupsCopy[idxGroup] > 0) {
                    groupsCopy[idxGroup] = groupsCopy[idxGroup] - 1;
                }
            }
      
            if (sumOfIntegers(groupsCopy) == 0) {
                int[] sum = new int[groups.length];
                for (int j = 0; j < sum.length; j++) {
                    sum[j] = 0;
                }
                
                for (int j = 0; j < grayCode[i].length; j++) {
                    sum[grayCode[i][j]] += objects[j].hashCode();
                }
                
                int prod = 1;
                for (int j = 0; j < sum.length; j++) {
                    prod *= sum[j];
                }
                if (!hashCodes.contains(new Integer(prod))) {
                    hashCodes.add(new Integer(prod));
                    
                    Set[] grouping = new Set[groups.length];
                    for (int j = 0; j < grouping.length; j++) {
                        grouping[j] = new HashSet<Term>();
                    }
                    
                    for (int j = 0; j < grayCode[i].length; j++) {
                        grouping[grayCode[i][j]].add(objects[j]);
                    }
          
                    groupings.add(new HashSet(Arrays.asList(grouping)));
                }
            }
        }
        return groupings;
    }
    
    @Override
    public Term call(List args) {
        
        List listOfElements = ((TermList) args.getHead()).getList();
        ArrayList<Term> set = new ArrayList<Term>();
        while (listOfElements != null) {
            set.add(listOfElements.getHead());
            listOfElements = listOfElements.getRest();
        }
        Term[] elements = new Term[set.size()];
        for (int i = 0;  i < set.size(); i++) {
            elements[i] = set.get(i);
        }

        int[] groups = new int[0];
        if (args.getRest().getHead() instanceof TermNumber) {
            int n = (int) ((TermNumber) args.getRest().getHead()).getNumber();
          
            groups = new int[n];
            for (int i = 0; i <  n - (elements.length % n); i++) {
                groups[i] = elements.length / n;
            }
            if (elements.length % n != 0) {
                for (int i = n - (elements.length % n); i < n; i++) {
                    groups[i] = (elements.length / n) + 1;
                }
            }
        } else {
            // args.getRest().getHead is list
            int i = 0;
            List listOfGroups = ((TermList) args.getRest().getHead()).getList();
            while (listOfGroups != null) {
                int[] dest = new int[i + 1];
                if (i != 0) System.arraycopy(groups, 0, dest, 0, i); 
                dest[i] = (int) ((TermNumber) listOfGroups.getHead()).getNumber();
                groups = dest;
                i = i + 1;
                listOfGroups = listOfGroups.getRest();
            } 
        }

        // obtain results
        Set<Set<Set<Term>>> groupings = getAllGroupings(elements, groups);
        TermList result = TermList.NIL;
        for (Set<Set<Term>> grouping : groupings) {
            TermList groupingList = TermList.NIL;
            for (Set<Term> group : grouping) {
                TermList groupList = TermList.NIL;
                for (Term element : group) {
                    groupList = new TermList(element, groupList);
                }
                groupingList = new TermList(groupList, groupingList);
            }
            result = new TermList(groupingList, result);
        }
        
        return result;
    }

}

