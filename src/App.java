import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char cal = ' ';
        String input;
        int result = 0;
        int num1,num2;
        exitwhile:
        while (true) {
            System.out.println("숫자 입력 (exit 입력시 종료) :");
            input = sc.next();
            if(input.equals("exit")){
                break exitwhile;
            }
            try {
                num1 = Integer.parseInt(input);
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요");
                continue;
            }
            if (num1 >= 0) {
                exitwhile2:
                while (true) {
                    System.out.println("사칙연산 중 하나 선택 입력 (exit 입력시 종료) :");
                    input = sc.next();
                    if(input.equals("exit")){
                        break exitwhile;
                    }
                    cal = input.charAt(0);
                    if (cal == '+' || cal == '-' || cal == '*' || cal == '/') {
                        while (true) {
                            System.out.println("숫자 입력 (exit 입력시 종료):");
                            input = sc.next();
                            if(input.equals("exit")){
                                break exitwhile;
                            }
                            try {
                                num2 = Integer.parseInt(input);
                            }catch (NumberFormatException e){
                                System.out.println("숫자를 입력해주세요");
                                continue;
                            }
                            if (num2 >= 0) {
                                if(cal == '/' && num2 == 0){
                                    System.out.println("0으로 나눌수없습니다 다시입력해주세요");
                                    continue;
                                }
                                result = new Calculator().calculate(num1, num2, cal);
                            }else{
                                System.out.println("양의 정수를 입력해주세요");
                            }
                            break exitwhile2;
                        }
                    } else {
                        System.out.println("사칙연산(+,-,*,/)을 입력해주세요");
                    }
                }
            } else {
                System.out.println("양의 정수를 입력해주세요");
            }
            System.out.println("결과 :"+result);
        }
    }
}