package dsa_code_java.data_structures;

public class SegmentTree {
    int sum;
    SegmentTree left;
    SegmentTree right;
    int L;
    int R;

    public SegmentTree(int total, int L, int R) {
        this.sum = total;
        this.left = null;
        this.right = null;
        this.L = L;
        this.R = R;
    }
    // 初始化的实际上是一个子树，树真的很神奇，它和递归总是相关

    // O(n)
    public static SegmentTree build(int[] nums, int L, int R) {
        if (L == R) {
            return new SegmentTree(nums[0], L, R);
        }

        int M = (L + R) / 2;
        SegmentTree root = new SegmentTree(0, L, R);
        root.left = build(nums, L, M);
        root.right = build(nums, M + 1, R);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    // O(logn)
    public void update(int index, int value) {
        if (this.L == this.R) {
            this.sum = value;
            return;
        }

        int M = (this.L + this.R) / 2;
        if (index <= M) {
            this.left.update(index, value);
        } else {
            this.right.update(index, value);
        }
        this.sum = this.left.sum + this.right.sum;
    }

    // O(logn)
    public int rangeQuery(int L, int R) {
        if (L == this.L && R == this.R) {
            return this.sum;
        }

        int M = (this.L + this.R) / 2;

        if (R <= M) {
            return this.left.rangeQuery(L, R);
        } else if (L > M) {
            return this.right.rangeQuery(L, R);
        } else {
            return this.left.rangeQuery(L, M) + this.right.rangeQuery(M, R);
        }
    }
}
