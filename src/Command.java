import java.util.Scanner;

public class Command extends Calculator{
    public static boolean lamdaCommand(Scanner sc, Calculator<Number> calculator) {
        while(true){
            System.out.println("[명령어 모드]입력 :");
            String input = sc.next().toLowerCase();
            switch (input){
                case "exit":
                    System.exit(0);
                    break;
                case "calculator":
                    return true;
                case "printfirstlist":
                    Command.printFirstList();
                    System.out.println("리스트에 맨 앞에 저장된 값 :");
                    break;
                case "printlastlist":
                    Command.printLastList();
                    System.out.println("리스트에 맨 뒤에 저장된 값 :");
                    break;
                case "removefirst":
                    Command.removeFirst();
                    System.out.println("리스트에 맨 앞 저장된 값 삭제완료");
                    break;
                case "removelastlist":
                    Command.removeLastList();
                    System.out.println("리스트에 맨 뒤에 저장된 값 삭제완료");
                    break;
                case "printalllist":
                    System.out.println("-저장된 모든 결과 값 리스트-");
                    Command.printAllList();
                    break;
                case "inputhigh":
                    LamdaStream.inputHigh(sc);
                    break;
                case "inputlow":
                    LamdaStream.inputLow(sc);
                    break;
                default:
                    System.out.println("올바른 명령어를 입력해주세요.");
            }
        }
    }

    //결과 출력 메서드 ------------------------------- ------------------------------- -------------------------------
    public static void printResult(Command command,Number result){
        System.out.println("결과 :"+result);
        System.out.println("가장 처음 리스트에 저장된 값 :"+command.printFirstList());
        System.out.println("가장 나중에 리스트에 저장된 값 :"+command.printLastList());
        System.out.println("리스트에 저장된 모든 값 출력");
        command.printAllList();
    }

    //가장 처음 리스트에 저장된 값 반환 ------------------------------- -------------------------------
    public static Number printFirstList() {
        if(Calculator.resultList.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return 0;
        }
        return Calculator.resultList.get(0);
    }



    //가장 나중에 리스트에 저장된 값 반환 ------------------------------- -------------------------------
    public static Number printLastList() {
        if(resultList.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return 0;
        }
        return resultList.get(resultList.size()-1);
    }

    //리스트에 저장된 모든 값 출력 ------------------------------- ------------------------------- -------------------------------
    public static void printAllList() {
        if(resultList.isEmpty()){
            System.out.println("리스트가 비어있습니다.");
            return;
        }
        for(int i=0; i<resultList.size(); i++){
            System.out.println(i+1+"번째 값 : "+resultList.get(i));
        }
    }

    //리스트에 저장된 원하는 값 출력 ------------------------------- ------------------------------- -------------------------------
    public static Number printList(int index) {
        if(index < 1 || index > resultList.size()){
            System.out.println("잘못된 번호 입니다.");
            return 0;
        }
        return resultList.get(index-1);
    }

    //가장 처음 리스트에 저장된 값 삭제 ------------------------------- ------------------------------- -------------------------------
    public static void removeFirst() {
        if(!resultList.isEmpty()){
            resultList.remove(0);
        }else{
            System.out.println("리스트가 비어있습니다.");
        }
    }

    //가장 나중에 리스트에 저장된 값 삭제 ------------------------------- ------------------------------- -------------------------------
    public static void removeLastList() {
        if(!resultList.isEmpty()){
            resultList.remove(resultList.size()-1);
        }else{
            System.out.println("리스트가 비어있습니다.");
        }
    }

    //컬렉션 초기화 ------------------------------- ------------------------------- -------------------------------
    public void clearList() {
        resultList.clear();
    }
}
