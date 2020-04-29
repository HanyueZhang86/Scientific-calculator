package sample;


import java.util.ArrayList;

public class Simple {
    private ArrayList<Object> _set;
    private ArrayList<Object> _ordered;

    Simple(){
        _set = new ArrayList<>();
        _ordered = new ArrayList<>();
    }

    public String calculate(String s){
        _set = breakUp(s);
        _ordered = setOrdered(_set);
        int i;
        Double first;
        Double second;
        String o;
        while(_ordered.size() != 1) {
            i = 0;
            while (_ordered.get(i) instanceof Double) {
                i++;
            }
            System.out.println(i);
            first = Double.parseDouble(_ordered.get(i-2).toString());
            second = Double.parseDouble(_ordered.get(i-1).toString());
            o = _ordered.get(i).toString();
            if(match(first, second, o).toString().equals("ERROR")){
                return "ERROR";
            }
            else{
                double temp = Double.parseDouble((match(first, second, o)).toString());
                _ordered.remove(i);
                _ordered.remove(i-1);
                _ordered.remove(i-2);
                _ordered.add(i-2, temp);
            }
            System.out.println(_ordered);
        }
        String result = _ordered.get(0).toString();
        double r = Double.parseDouble(_ordered.get(0).toString());
        if(r%1 ==0){
            result = Long.toString((long)r);
        }


        return result;
    }
    /*
    break up the string into arraylist and change the number to double
     */
    public ArrayList<Object> breakUp(String s){
        ArrayList<Object> set = new ArrayList<>();;
        int n=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                if(!isOperator(s.substring(n, i))){
                    set.add(Double.parseDouble(s.substring(n, i))); //change number to double
                    System.out.println(set);
                }
                else{
                    set.add(s.substring(n, i)); //keep operator as String
                    System.out.println(set);
                }
                n=i+1;
            }
        }
        if(!isOperator(s.substring(n))){
            set.add(Double.parseDouble(s.substring(n)));
            System.out.println(set);
        }
        else{
            set.add(s.substring(n));
            System.out.println(set);
        }
        return set;
    }
    public boolean isOperator(String s){
        if(s.equals("sin") || s.equals("cos") || s.equals("tan") || s.equals("log") || s.equals("ln") || s.equals("^2")
                || s.equals("^3") || s.equals("√") || s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")
                || s.equals("(") || s.equals(")"))
            return true;
        else return false;
    }
    /*
    change the order of arraylist to be ready to calculate
    the assaylist come in must have the number as double and operator as string
     */
    public ArrayList<Object> setOrdered(ArrayList a){
        ArrayList<Object> ordered = new ArrayList<>();
        ArrayList<String> operator = new ArrayList<>(); //for temporary save operator
        for(int i=0; i<a.size(); i++){
            if(a.get(i) instanceof Double){ //for number
                ordered.add(a.get(i));
                //System.out.println(ordered+" "+operator);
            }
            else{ //for operator
                if(operator.isEmpty()){ //first operator
                    operator.add(a.get(i).toString());
                    //System.out.println(ordered+" "+operator);
                }
                else if(operatorLevel((a.get(i).toString())) == 0){
                    operator.add("(");
                }
                else if(operatorLevel(a.get(i).toString()) == 5){ //for )
                    while(!operator.get(operator.size()-1).equals("(")){
                        ordered.add(operator.get(operator.size()-1));
                        operator.remove(operator.size()-1);
                    }
                    operator.remove(operator.size()-1);
                }
                else if(operatorLevel(a.get(i).toString()) > operatorLevel(operator.get(operator.size()-1))){ //for high level operator
                    operator.add(a.get(i).toString());
                    //System.out.println(ordered+" "+operator);
                }
                else{ //for low or same level operator
                    ordered.add(operator.get(operator.size()-1));
                    operator.remove(operator.size()-1);
                    operator.add(a.get(i).toString());
                    //System.out.println(ordered+" "+operator);
                }
            }
        }
        while (!operator.isEmpty()){ //save the rest operators to the ordered arraylist
            ordered.add(operator.get(operator.size()-1));
            operator.remove(operator.size()-1);
            //System.out.println(ordered+" "+operator);
        }
        return ordered;
    }
    /*
    return the level of operators
     */
    public int operatorLevel(String s){
        int level;
        switch (s){
            case "(":
                level = 0;
                break;
            case "+":
            case "-":
                level = 1;
                break;
            case "*":
            case "/":
                level = 2;
                break;
            case "^2":
            case "^3":
            case "√":
                level = 3;
                break;
            case "sin":
            case "cos":
            case "tan":
            case "log":
            case "ln":
                level = 4;
                break;
            case ")":
                level = 5;
                break;
                default:
                    level = -1;
                    break;
        }
        return level;
    }
    public Object match(double first, double second, String operator){
        double result = 0;
        switch (operator){
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if(second == 0) return "ERROR";
                else result = first / second;
                break;
        }
        return result;
    }

}
