import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //속성
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        //기능
        while(true){
            Integer num1 = getNumberInput(sc);
            if(num1 == null){
                break;
            }
            char oper = getOperatorInput(sc);
            if(oper == 'e'){
                break;
            }
            Integer num2;
            while(true){
                num2 = getNumberInput(sc);
                if(num2 == null){
                    return;
                }
                if(oper == '/' && num2 == 0){
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                    continue;
                }
                break;
            }
            int result = calculator.calculate(num1,num2,oper);
            printResult(calculator,result);
        }
    }
    
    // 숫자 입력 받는 메서드
    private static Integer getNumberInput(Scanner sc){
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
    private static char getOperatorInput(Scanner sc){
        while(true){
            System.out.println("사칙연산(+,-,*,/) 중 하나 선택 입력 (exit입력 시 종료):");
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                return 'e';
            }
            if(input.length() == 1 && "+-*/".contains(input)){
                return input.charAt(0);
            }
            System.out.println("사칙연산(+,-,*,/)을 입력해주세요.");
        }
    }
    
    //결과 출력 메서드
    private static void printResult(Calculator calculator,int result){
        System.out.println("결과 :"+result);
        System.out.println("가장 처음 리스트에 저장된 값 :"+calculator.printFirstList());
        System.out.println("가장 나중에 리스트에 저장된 값 :"+calculator.printLastList());
        System.out.println("리스트에 저장된 모든 값 출력");
        calculator.printAllList();
    }
}