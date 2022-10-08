import java.util.List;
import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class SparseTable<T> {
    private BinaryOperator<T> f;
    private List<List<T>> table;
    private boolean canOverlap = true;

    public SparseTable(List<T> data, BinaryOperator<T> f, boolean canOverlap) {
        this.f = f;
        this.canOverlap = canOverlap;
        int numRows = log2(data.size())+1;
        table = new ArrayList<>(numRows);
        table.add(new ArrayList<>(data));
        
        for(int r = 1; r < numRows; r++) {
            int rowSize = data.size() - (1 << r) + 1; 
            List<T> row = new ArrayList<>(rowSize);
            for(int c = 0; c < rowSize; c++) {
                T val1 = table.get(r-1).get(c);
                T val2 = table.get(r-1).get(c + (1 << (r-1)));
                row.add(c, f.apply(val1, val2));                
            }
            table.add(row);
        }
    }

    public SparseTable(List<T> data, BinaryOperator<T> f) {
        this(data, f, true);
    }

    private T queryOverlap(int l, int r) {
        int range = r - l + 1;

        int exp = 0;
        while(1 << (exp+1) <= range) {
            exp++;
        }

        return f.apply(table.get(exp).get(l), table.get(exp).get(l + range - (1 << exp)));
    }

    private T queryRecursive(int l, int r) {
        int range = r - l + 1;

        int exp = 0;
        while(1 << (exp+1) <= range) {
            exp++;
        }

        if(1 << exp == range) {
            return table.get(exp).get(l);
        }

        T val1 = table.get(exp).get(l);
        T val2 = queryRecursive(l + (1 << exp), r);
        return f.apply(val1, val2);        
    }

    public T query(int l, int r) {
        if(canOverlap) {
            return queryOverlap(l, r);
        } else {
            return queryRecursive(l, r);
        }
    }

    private int log2(int n) {
        return (int)(Math.log(n) / Math.log(2));
    }
}
