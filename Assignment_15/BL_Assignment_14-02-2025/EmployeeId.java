import java.util.*;
class EmployeeId{
	public static void insertionsort(int employeeId[]){
		int n=employeeId.length;
		for(int i=1;i<n-1;i++){
			int key=employeeId[i];
			int j=i-1;
			while(j>=0 && employeeId[j]>key){
				employeeId[j+1]=employeeId[j];
				j--;
			}
			employeeId[j+1]=key;
		}
	}
		public static void main(String args[]){
		   int employeeId[]={4,5,1,8,7,9};
		   System.out.println("unsorted array "+Arrays.toString(employeeId));
		   insertionsort(employeeId);
		   System.out.println("Sorted array "+Arrays.toString(employeeId));
		}
}
