import java.util.Scanner;

public class App{
    public static void main(String[] args){
        //속성
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        //기능
        while(true){
            Integer num1 = Calculator.getNumberInput(sc);
            if(num1 == null){
                break;
            }
            OperatorType operatorType = Calculator.getOperatorInput(sc);
            if(operatorType == null){
                break;
            }
            Integer num2;
            while(true){
                num2 = Calculator.getNumberInput(sc);
                if(num2 == null){
                    return;
                }
                if(operatorType == OperatorType.DIV && num2 == 0){
                    System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                    continue;
                }
                break;
            }
            int result = calculator.calculate(num1,num2,operatorType);
            Calculator.printResult(calculator,result);
        }
    }

}