import java.util.List;
import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class SegmentTree<T> {
    private List<T> tree;
    private int n;
    private BinaryOperator<T> f;

    public SegmentTree(List<T> data, BinaryOperator<T> f) {
        this.f = f;
        n = data.size();
        tree = new ArrayList<>(n*2);

        for(int i = 0; i < n; i++) {
            tree.add(null);
        }

        for(int i = 0; i < n; i++) {
            tree.add(data.get(i));
        }

        for(int i = n - 1; i > 0; i--) {
            tree.set(i, f.apply(tree.get(2*i), tree.get(2*i+1)));
        }
    }

    public void update(int index, T val) {
        index += n;

        tree.set(index, val);

        while(index > 1) {
            index >>= 1;
            T newVal = f.apply(tree.get(index*2+1), tree.get(index*2));
            if(newVal == tree.get(index)) {
                return;
            } else {
                tree.set(index, newVal);
            }
        }
    }

    public T get(int l, int r) {
        l += n;
        r += n;

        T val = null;
        while(l <= r) {
            if(l % 2 == 1) {
                if(val == null) {
                    val = tree.get(l);
                } else {
                    val = f.apply(val, tree.get(l));
                }
                l++;
            }

            if(r % 2 == 0) {
                if(val == null) {
                    val = tree.get(r);
                } else {
                    val = f.apply(val, tree.get(r));
                }
                r--;
            }
            l >>= 1;
            r >>= 1;
        }

        return val;
    }
}
