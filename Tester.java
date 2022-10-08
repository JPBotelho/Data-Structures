import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Tester {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1, 2, 0, 4, 5, 6, 7, 8);

        BinaryOperator<Integer> minOp = (a, b) -> a+b;
        SparseTable<Integer> table = new SparseTable<Integer>(data, minOp, false);
        System.out.println(table.query(0, 5));
    }
}
