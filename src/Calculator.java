import java.util.*;

public class Calculator {
    private int result;
    private List<Integer> resultList = new ArrayList<>();

    //사칙연산 수행 후에 결과값 반환하는 메서드
    public int calculate(int num1, int num2, char cal) {
        switch (cal) {
            case '+':
                result = num1 + num2;
                resultList.add(result);
                break;
            case '-':
                result = num1 - num2;
                resultList.add(result);
                break;
            case '*':
                result = num1 * num2;
                resultList.add(result);
                break;
            case '/':
                result = num1 / num2;
                resultList.add(result);
                break;
            default:
                System.out.println("예상치못한 오류");
                break;
        }
        return result;
    }
    //가장 처음 리스트에 저장된 값 출력 -------------------------------
    public void printFirstList() {
        System.out.println(resultList.get(0));
    }
    //가장 나중에 리스트에 저장된 값 출력 -------------------------------
    public void printLastList() {
        System.out.println(resultList.get(resultList.size()-1));
    }
    //리스트에 저장된 모든 값 출력 -------------------------------
    public void printAllList() {
        for(int i = 0; i < resultList.size(); i++){
            System.out.println(resultList.get(i));
        }
    }
    //리스트에 저장된 원하는 값 출력 -------------------------------
    public void printList(int index) {
        System.out.println(resultList.get(index-1));
    }
    //가장 처음 리스트에 저장된 값 삭제 -------------------------------
    public void removeFirst() {
        resultList.remove(0);
    }
    //가장 나중에 리스트에 저장된 값 삭제 -------------------------------
    public void removeLastList() {
        resultList.remove(resultList.size()-1);
    }
    //컬렉션 초기화 -------------------------------
    public void clearList() {
        resultList.clear();
    }


    // 케터 세터 -------------------------------
    public List<Integer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Integer> resultList) {
        this.resultList = resultList;
    }
}
