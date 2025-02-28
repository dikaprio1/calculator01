import java.util.Scanner;

public class ArithmeticCalculator {

    // 숫자 입력 받는 메서드
    protected static Integer getNumberInput(Scanner sc){
        while(true){
            System.out.println("숫자 입력(exit입력 시 종료) :");
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                return null;
            }
            try{
                return Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
            }

        }
    }

    // 사칙연산 입력받는 메서드
    protected static OperatorType getOperatorInput(Scanner sc){
        while(true){
            System.out.println("사칙연산(+,-,*,/) 중 하나 선택 입력 (exit입력 시 종료):");
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                return null;
            }
            if(input.length() == 1 && "+-*/".contains(input)){
                return OperatorType.fromchar(input.charAt(0));
            }
            System.out.println("사칙연산(+,-,*,/)을 입력해주세요.");
        }
    }

    //결과 출력 메서드
    protected static void printResult(Calculator calculator,int result){
        System.out.println("결과 :"+result);
        System.out.println("가장 처음 리스트에 저장된 값 :"+calculator.printFirstList());
        System.out.println("가장 나중에 리스트에 저장된 값 :"+calculator.printLastList());
        System.out.println("리스트에 저장된 모든 값 출력");
        calculator.printAllList();
    }
}
