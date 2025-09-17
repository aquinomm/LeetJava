import java.util.ArrayList;

public class CreateTargetArrayInTheGivenOrder1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        ArrayList<Integer> aL = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            aL.add(index[i], nums[i]);
        }

        int[] target = new int[n];
        for(int i = 0; i < n; i++) {
            target[i] = aL.get(i);
        }
        return target;
    }

    public void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        System.out.println(createTargetArray(nums, index));
    }
}
