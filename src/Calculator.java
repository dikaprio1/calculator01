import java.util.*;

public class Calculator {
    int result;
    Scanner sc = new Scanner(System.in);
    private Queue<Integer> resultQueue = new LinkedList<>();

    public int calculate(int num1, int num2, char cal) {
        switch (cal) {
            case '+':
                result = num1 + num2;
                resultQueue.add(result);
                break;
            case '-':
                result = num1 - num2;
                resultQueue.add(result);
                break;
            case '*':
                result = num1 * num2;
                resultQueue.add(result);
                break;
            case '/':
                result = num1 / num2;
                resultQueue.add(result);
                break;
            default:
                System.out.println("예상치못한 오류");
                break;
        }
        return result;
    }
    public void selectLastQueue() {
        System.out.println(resultQueue.peek());
    }

    public void printAllQueue() {
        while(!resultQueue.isEmpty()) {
            System.out.println(resultQueue.poll());
        }
    }
    public void printQueue() {
        System.out.println(resultQueue.poll());
    }










    // 케터 세터
    public Queue<Integer> getResultQueue() {
        return resultQueue;
    }

    public void setResultQueue(Queue<Integer> resultQueue) {
        this.resultQueue = resultQueue;
    }
}
