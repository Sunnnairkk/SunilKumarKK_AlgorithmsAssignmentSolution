package AlgorithmsAssignmentSolutionPart2;

public class BinarySearch {
	
	public int binarySearchValue(double[] dArr, double searchKey) {
		int left = 0;
		int right = dArr.length - 1;
		int foundValueAt = 0;
		
		while(left <= right) {

			int mid = (left + right) / 2; 
			
			System.out.print(" " + dArr[mid]);
			
			if (dArr[mid] < searchKey) {
				left = mid + 1;
			}
			else if (dArr[mid] == searchKey) {
				foundValueAt = mid;
				//System.out.println("Found value at " + mid);
				break;
			}
			else {
				right = mid - 1;
			}
		}
		return foundValueAt;
	}
	

}
