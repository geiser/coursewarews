
import java.util.*;

public class GrayCode {

  public static int[] generateGrayCode(int value, int base, int digits) {
    int[] baseN = new int[digits];
    int[] gray = new int[digits];

    int tempvalue = value;
    for(int i = 0; i < digits; i++) {
      baseN[i] = tempvalue % base;
      tempvalue = tempvalue / base;
    }
    
    int shift = 0;
    for(int i = digits - 1; i >= 0; i--) {
      gray[i] = (baseN[i] - shift) % base;
      shift += gray[i] - base;
    }
    
    return gray;
  }

  public static int sumOfIntegers(int[] array) {
    int result = 0;
    for (int element : array) {
      result += element;
    }
    return result;
  }

  public static Set<Set<Set<Object>>> getAllGroupings(Object[] objects, int[] groups) {
    
    Set<Set<Set<Object>>> groupings = new HashSet<Set<Set<Object>>>();
    
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
    List<Integer> hashCodes = new ArrayList<Integer>();
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
                
        int res = 1;
        for (int j = 0; j < sum.length; j++) {
          res *= sum[j];
        }
        if (!hashCodes.contains(new Integer(res))) {
          hashCodes.add(new Integer(res));
           
          Set[] grouping = new Set[groups.length];
          for (int j = 0; j < grouping.length; j++) {
            grouping[j] = new HashSet<Object>();
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

  public static void printArray(int[] array) {
    System.out.print("[");
    for (int element : array) {
      System.out.print("," + element);
    }
    System.out.print("]");
  }

  public static void main(String[] args) {
    String[] objects = new String[125];
    for (int i = 0; i < 125; i++) {
        objects[i] = "ele" + i;
    }
    int[] groups = {5, 10, 5, 10, 8, 2, 7, 3, 10, 10, 10, 10, 10, 7, 3, 10, 5};
    Set<Set<Set<Object>>> groupings = getAllGroupings(objects, groups);
    for (Set<Set<Object>> grouping : groupings) {
      for (Set<Object> group : grouping) {
        System.out.print("(");
        for (Object element : group) {
          System.out.print(element + ",");
        }
        System.out.print("),");
      }
      System.out.println("");
    }

  }

}
