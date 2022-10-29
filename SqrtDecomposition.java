public class SqrtDecomposition {
    private int data[];
    private int seg[];

    private int segSize;

    public SqrtDecomposition(int[] array) {
        segSize = (int)Math.sqrt(array.length);    
        seg = new int[ceilDiv(array.length, segSize)];
        this.data = array;
        int runningSum = 0;
        int segIndex = 0;
        for(int i = 0; i < data.length; i++) {
            if(i % segSize == 0 && i != 0) {
                seg[segIndex] = runningSum;
                segIndex++;
                runningSum = 0;
            }
            runningSum += data[i];
        }
        seg[segIndex] = runningSum;
        System.out.println(segSize);
        System.out.println(seg.length);
    }

    public int get(int l, int r) {
        if(l == r) return data[l];
        int sum = 0;
        while(l <= r && l % segSize != 0) {
            sum += data[l];
            l++;
            System.out.println("STEP BEFORE");
        }

        while(l + segSize - 1 <= r) {
            sum += seg[l / segSize];
            l += segSize;
            System.out.println("STEP BLOCK");
        }

        while(l <= r) {
            sum += data[l];
            l++;
            System.out.println("STEP AFTER");
        }
        
        return sum;        
    }

    public void update(int index, int val) {
        int diff = val - data[index];
        data[index] = val;
        seg[index / segSize] += diff;
    }

    // 0 1 2 3 4 5 6 7 8 9
    //     0 .   1 .   2 .
    private int ceilDiv(int a, int b) {
        return (a + b - 1) / b;
    }
}
