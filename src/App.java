import java.util.Scanner;

public class App{
    public static void main(String[] args){
        //속성
        Scanner sc = new Scanner(System.in);
        Calculator<Number> calculator = new Calculator<>();
        Command command = new Command();
        boolean switchprogram = true; //true(계산기) false(lamda모드)
        //기능
        while(true){
            if(switchprogram){
                System.out.println("[계산기] 숫자 입력(exit-종료,lamda-명령어 모드전환) ");
                Number num1 = Calculator.getNumberOrSwitchMode(sc);
                if(num1 == null){
                    switchprogram=false;
                    continue;
                }
                OperatorType operatorType = Calculator.getOperatorInput(sc);
                if(operatorType == null){
                    break;
                }
                Number num2;
                while(true){
                    num2 = Calculator.getNumberOrSwitchMode(sc);
                    if(num2 == null){
                        switchprogram=false;
                        return;
                    }
                    if(operatorType == OperatorType.DIV && num2.doubleValue() == 0){
                        System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
                        continue;
                    }
                    break;
                }
                Number result = calculator.calculate(num1,num2,operatorType);
                Command.printResult(command,result);
            }else{
                System.out.println("[명령어 모드] 명령어 입력");
                System.out.println("exit-종료/calculator-계산기 전환/printfirstlist-리스트에 맨 앞에 저장된 값/printlastlist-리스트에 맨 뒤에 저장된 값/printalllist-리스트에 저장된 모든 값 출력");
                System.out.println("/removefirst-가장 처음 리스트에 저장된 값 삭제/removelastlist-리스트에 맨 뒤에 저장된 값 삭제");
                System.out.println("/inputhigh-저장된 수들 중 몇보다 큰 수/inputlow-저장된 수들 중 몇보다 작은 수");
                switchprogram = Command.lamdaCommand(sc,calculator);
            }
        }
    }

}