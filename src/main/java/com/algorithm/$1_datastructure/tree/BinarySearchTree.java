package com.algorithm.$1_datastructure.tree;

/**
 * 二叉查找树查询元素.
 *
 * @author fuwb
 * @since 2021-03-01
 */
public class BinarySearchTree {
    private Node tree;

    public Node find(int data) {
        Node p = tree;

        while (p != null) {
            if (p.data == data) {
                return p;
            } else if (data < p.data) {
                // 遍历左子树
                p = p.left;
            } else if (data > p.data) {
                // 遍历右子树
                p = p.right;
            }
        }
        return null;
    }

    /**
     * 插入数据.
     * @param data
     */
    public void insert(int data) {
        // 把数据插入结点
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                // 右结点为空时，把数据插入到右节点
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                // 右节点不为空，则继续遍历右子树
                p = p.right;
            } else {
                // data <= p.data
                // 左结点为空时，把数据插入到左节点
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }

    }

    /**
     * 删除节点.
     * 第一种情况是，如果要删除的节点没有子节点，我们只需要直接将父节点中，指向要删除节 点的指针置为 null。
     * 第二种情况是，如果要删除的节点只有一个子节点（只有左子节点或者右子节点），我们只需要更新父节点中，指向要删除节点的指针，让它指向要删除节点的子节点就可以了。
     * 第三种情况是，如果要删除的节点有两个子节点，这就比较复杂了。我们需要找到这个节点的右子树中的最小节点，把它替换到要删除的节点上。
     * 然后再删除掉这个最小节点，因为最 小节点肯定没有左子节点（如果有左子结点，那就不是最小节点了），所以，我们可以应用上面两条规则来删除这个最小节点。比如图中的删除节点 18。
     * @param data
     */
    public void delete(int data) {
        Node p = tree; // p 指向要删除的节点，初始化指向根节点
        Node pp = null; // pp 记录的是 p 的父节点 4
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {
            return; // 没有找到
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            // 查找右子树中最小节点
            Node minP = p.right;
            // minPP 表示 minP 的父节点
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 将 minP 的数据替换到 p 中
            p.data = minP.data;
            // 下面就变成了删除 minP 了
            p = minP;
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p 的子节点
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        // 删除的是根节点
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
