import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Tester {
    public static void main(String[] args) {
        AVLNode tree = new AVLNode(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);
        tree.insert(47);
        tree.insert(60);
        tree.insert(70);

        tree.delete(47);
        tree.delete(50);
        //tree.delete(40);
        System.out.println("finished");
        //tree.printInOrder();
    }
}
