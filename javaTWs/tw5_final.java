import java.util.Arrays;

class NumberProcessor extends Thread {
    private int[] numbers;
    private long result;

    public NumberProcessor(int[] numbers) {
        this.numbers = numbers;
        this.result = 0;
    }

    public long getResult() {
        return result;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("SumThread")) {
            calculateSum();
        } else if (Thread.currentThread().getName().equals("ProductThread")) {
            calculateProduct();
        }
    }

    private void calculateSum() {
        for (int num : numbers) {
            result += num;
        }
    }

    private void calculateProduct() {
        result = 1;
        for (int num : numbers) {
            result *= num;
        }
    }
}

public class tw5_final{

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        NumberProcessor sumThread = new NumberProcessor(numbers);
        NumberProcessor productThread = new NumberProcessor(numbers);

        sumThread.setName("SumThread");
        productThread.setName("ProductThread");

        sumThread.start();
        productThread.start();

        try {
            sumThread.join();
            productThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long sumResult = sumThread.getResult();
        long productResult = productThread.getResult();

        System.out.println("Sum: " + sumResult);
        System.out.println("Product: " + productResult);
    }
}
 