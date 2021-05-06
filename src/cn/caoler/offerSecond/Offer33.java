package cn.caoler.offerSecond;

/**
 * @author keji
 * @desc
 * @date 2021/3/16 5:00 下午
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null || postorder.length == 0) return true;
        return dfs(postorder,0,postorder.length - 1);
    }

    public boolean dfs(int[] postorder,int start,int end){
        if(start >= end) return true;//分到只剩下一个数了，只有一个树节点肯定可以构成二叉搜索树
        int root = postorder[end];//当前子结构的根节点
        int i = start;//i用于找到第一个大于子结构根节点的值
        while(i < end && postorder[i] < root) i++;
        //从i到end-1就应该是右子树了，所有的值都应该大于root
        //如果有不大于root的，说明无法构成二叉搜索树
        for(int j = i;j < end;j++){
            if(postorder[j] < root){
                return false;
            }
        }
        //递归判断左右子树是否也符合二叉搜索树的性质
        return dfs(postorder,start,i - 1) && dfs(postorder,i,end - 1);
    }
}
