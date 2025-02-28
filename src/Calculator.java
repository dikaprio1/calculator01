import java.util.*;

public class Calculator<T extends Number> {
    public static final List<Number> resultList = new ArrayList<>();

    //사칙연산 수행 후에 결과값 반환하는 메서드 ------------------------------- ------------------------------- -------------------------------
    public Number calculate(T num1, T num2, OperatorType operatorType) {
        double result;
        switch (operatorType) {
            case ADD: result = num1.doubleValue() + num2.doubleValue(); break;
            case SUB:result = num1.doubleValue() - num2.doubleValue();break;
            case MUL:result = num1.doubleValue() * num2.doubleValue();break;
            case DIV:result = num1.doubleValue() / num2.doubleValue();break;
            default:
                System.out.println("예상치못한 오류");
                return 0;
        }
        if (result % 1 == 0) {
            resultList.add((int) result); // 정수 변환 후 저장
            return (int) result;
        } else {
            resultList.add(result);     // 실수 그대로 저장
            return result;
        }
    }

    // 입력 받는 메서드 ------------------------------- ------------------------------- -------------------------------
    public static Number getNumberOrSwitchMode(Scanner sc){
        while(true){
            System.out.println("[계산기 모드]입력 :");
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                System.exit(0);
            }
            if(input.equalsIgnoreCase("lamda")){
                System.out.println("명령어 모드 전환");
                return null;
            }
            if(input.equalsIgnoreCase("calculator")){
                System.out.println("계산기 모드 전환");
                return null;
            }
            try{
                if(input.contains(".")){
                    return Double.parseDouble(input);
                }
                return Integer.parseInt(input);
            }catch(NumberFormatException e){
                System.out.println("올바른 숫자 또는 모드전환 명령어를 입력해주세요.");
            }

        }
    }

    // 사칙연산 입력받는 메서드 ------------------------------- ------------------------------- -------------------------------
    public static OperatorType getOperatorInput(Scanner sc){
        while(true){
            System.out.println("사칙연산(+,-,*,/) 중 하나 선택 입력 (exit입력 시 종료):");
            String input = sc.next();
            if(input.equalsIgnoreCase("exit")){
                System.exit(0);
            }
            if(input.length() == 1 && "+-*/".contains(input)){
                return OperatorType.fromchar(input.charAt(0));
            }
            System.out.println("사칙연산(+,-,*,/)을 입력해주세요.");
        }
    }


    // 케터 세터(값 저장용이기때문에 세터는 필요없음) ------------------------------- -------------------------------
    public List<Number> getResultList() {
        return resultList;
    }
}
