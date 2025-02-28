import java.util.*;

public class Calculator {
    private final List<Integer> resultList = new ArrayList<>();

    //사칙연산 수행 후에 결과값 반환하는 메서드
    public int calculate(int num1, int num2, OperatorType operatorType) {
        int result;
        switch (operatorType) {
            case ADD: result = num1 + num2; break;
            case SUB:result = num1 - num2;break;
            case MUL:result = num1 * num2;break;
            case DIV:result = num1 / num2;break;
            default:
                System.out.println("예상치못한 오류");
                return 0;
        }
        resultList.add(result);
        return result;
    }
    //가장 처음 리스트에 저장된 값 반환 -------------------------------
    public int printFirstList() {
        if(resultList.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return 0;
        }
        return resultList.get(0);
    }
    //가장 나중에 리스트에 저장된 값 반환 -------------------------------
    public int printLastList() {
        if(resultList.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return 0;
        }
        return resultList.get(resultList.size()-1);
    }
    //리스트에 저장된 모든 값 출력 -------------------------------
    public void printAllList() {
        if(resultList.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        for(int i=0; i<resultList.size(); i++){
            System.out.printf("%d번째 값 : %d \n",i+1,resultList.get(i));
        }
    }
    //리스트에 저장된 원하는 값 출력 -------------------------------
    public int printList(int index) {
        if(index < 1 || index > resultList.size()){
            System.out.println("잘못된 번호 입니다.");
            return 0;
        }
        return resultList.get(index-1);
    }
    //가장 처음 리스트에 저장된 값 삭제 -------------------------------
    public void removeFirst() {
        if(!resultList.isEmpty()){
            resultList.remove(0);
        }else{
            System.out.println("리스트가 비어있습니다.");
        }
    }
    //가장 나중에 리스트에 저장된 값 삭제 -------------------------------
    public void removeLastList() {
        if(!resultList.isEmpty()){
            resultList.remove(resultList.size()-1);
        }else{
           System.out.println("리스트가 비어있습니다.");
        }
    }
    //컬렉션 초기화 -------------------------------
    public void clearList() {
        resultList.clear();
    }

    // 숫자 입력 받는 메서드
    public static Integer getNumberInput(Scanner sc){
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
    public static OperatorType getOperatorInput(Scanner sc){
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
    public static void printResult(Calculator calculator,int result){
        System.out.println("결과 :"+result);
        System.out.println("가장 처음 리스트에 저장된 값 :"+calculator.printFirstList());
        System.out.println("가장 나중에 리스트에 저장된 값 :"+calculator.printLastList());
        System.out.println("리스트에 저장된 모든 값 출력");
        calculator.printAllList();
    }

    // 케터 세터(값 저장용이기때문에 세터는 필요없음) -------------------------------
    public List<Integer> getResultList() {
        return resultList;
    }
}
