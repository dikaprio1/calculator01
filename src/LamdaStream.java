import java.util.List;
import java.util.Scanner;

public class LamdaStream{

    //람다식 스트림을 활용한 메서드 예제 (저장된 결과들 중 스캐너로 입력받은 값보다 큰 결과값 출력) -------------------------------
    public static void inputHigh(Scanner sc){
        System.out.println("저장된 수들 중 몇보다 큰 수들만 출력하시겠습니까?");
        String input = sc.next();
        Number num= Double.parseDouble(input);
        List<Number> ls = Calculator.resultList.stream()
                .filter(num1 -> num1.doubleValue() > num.doubleValue())
                .toList();
        System.out.println("스캐너로 입력받은 값보다 큰 수 :"+ls);
    }

    //람다식 스트림을 활용한 메서드 예제 (저장된 결과들 중 스캐너로 입력받은 값보다 큰 결과값 출력)
    public static void inputLow(Scanner sc){
        System.out.println("저장된 수들 중 몇보다 작은 수들만 출력하시겠습니까?");
        String input = sc.next();
        Number num= Double.parseDouble(input);
        List<Number> ls = Calculator.resultList.stream()
                .filter(num1 -> num1.doubleValue() < num.doubleValue())
                .toList();
        System.out.println("스캐너로 입력받은 값보다 큰 수 :"+ls);
    }
}
