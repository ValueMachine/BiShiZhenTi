package 腾讯音乐230413;


public class 第一题 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param root TreeNode类
         * @return TreeNode类
         */
        public void valueOfTree (TreeNode root) {
            TreeNode node = new TreeNode(1);
             dfs(node);
        }
         static void dfs(TreeNode node){
            if(node.left==null&&node.right==null) return ;
            int v1 = node.left==null? 0:node.left.val;
            int v2 = node.right==null? 0:node.right.val;
            int v = v1*v2;
             String s = Integer.toString(v);
             int count = 0;
             for (int i = 0; i < s.length(); i++) {
                 if (s.charAt(i)=='0')
                     count++;
             }
            node.val = count;
             dfs(node.left);
             dfs(node.right);
        }

    }

