class Solution {
    public boolean verifyPostorder(int[] postorder) {
		if(postorder.length <= 1) {
			return true;
		}
		int rootVal = postorder[postorder.length-1];
		int rightBeginIndex = postorder.length - 1;
		for(int i = 0; i < postorder.length ; i ++) {
			if(postorder[i] > rootVal) {
				rightBeginIndex = i;
				break;
			}
		}
		int [] leftPostorder = Arrays.copyOfRange(postorder, 0, rightBeginIndex);
		int [] rightPostorder = Arrays.copyOfRange(postorder, rightBeginIndex, postorder.length-1);
		for(int i = 0; i < leftPostorder.length ; i ++) {
			if(leftPostorder[i] > rootVal ) {
				return false;
			}
		}
		for(int i = 0; i < rightPostorder.length ; i ++) {
			if(rightPostorder[i] < rootVal) {
				return false;
			}
		}
		return verifyPostorder(leftPostorder) && verifyPostorder(rightPostorder);
    }
}