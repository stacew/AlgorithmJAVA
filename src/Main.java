//이클립스 = Ctrl + F11
//KeyMap(인텔리 J) = Shift + F10

public class Main {
	public static void main(String[] args) {
			System.out.println("--- start ---");
			
			CoinChange_322 oSol = new CoinChange_322();
			int[] nums = {1,2,5};
			oSol.coinChange(nums , 11);
			

			int[] nums2 = {1,-1,0};
			System.out.println(SubarraySumEqualsK_560.subarraySum(nums2, 0) );
			
			 RandomizedSet obj = new RandomizedSet();
			 obj.insert(0);
			 obj.insert(1);
			 obj.remove(0);
			 obj.insert(2);
			 System.out.println(obj.remove(1));
			 System.out.println(obj.getRandom());
			 
			System.out.println("--- end ---");
	}
};
