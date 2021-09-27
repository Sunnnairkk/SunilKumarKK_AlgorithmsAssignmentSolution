package AlgorithmsAssignmentSolutionPart2;

public class BinarySearch {
	
	public int binarySearchValue(double[] dArr, double searchKey) {
		int left = 0;
		int right = dArr.length - 1;
		int foundValueAt = 0;
		
		while(left <= right) {

			int mid = (left + right) / 2; 
			
			if (dArr[mid] > searchKey) {
				left = mid + 1;
			}
			else if (dArr[mid] == searchKey) {
				foundValueAt = mid;
				break;
			}
			else {
				right = mid - 1;
			}
		}
		return foundValueAt;
	}
	

}
