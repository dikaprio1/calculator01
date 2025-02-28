enum OperatorType {
    ADD('+'), SUB('-'), MUL('*'), DIV('/');

    private final char symbol;

    OperatorType(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public static OperatorType fromchar(char symbol){
        OperatorType[] operatorTypes = values();
        for(int i =0;i<operatorTypes.length;i++){
            if(operatorTypes[i].symbol == symbol){
                return operatorTypes[i];
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다.: "+symbol);
    }
}


