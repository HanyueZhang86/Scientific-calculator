package sample;


import java.util.ArrayList;

public class Scientific extends Simple {
    private ArrayList<Object> set;
    private ArrayList<Object> ordered;

    Scientific(){
        set = new ArrayList<>();
        ordered = new ArrayList<>();
    }
    public String calculate(String s){
        System.out.println(s);
        set = breakUp(s);
        System.out.println(set);
        ordered = setOrdered(set);
        System.out.println(ordered);
        int i;
        Double first;
        Double second;
        String o;
        while(ordered.size() != 1) {
            i = 0;
            while (ordered.get(i) instanceof Double) {
                i++;
            }
            System.out.println(i);
            if(isScientiftic(ordered.get(i).toString())){
                first = Double.parseDouble(ordered.get(i - 1).toString());
                o = ordered.get(i).toString();
                if (scientifticMatch(first, o).toString().equals("ERROR")) {
                    return "ERROR";
                } else {
                    double temp = Double.parseDouble((scientifticMatch(first, o)).toString());
                    ordered.remove(i);
                    ordered.remove(i - 1);
                    ordered.add(i - 1, temp);
                }
            }
            else {
                first = Double.parseDouble(ordered.get(i - 2).toString());
                second = Double.parseDouble(ordered.get(i - 1).toString());
                o = ordered.get(i).toString();
                if (match(first, second, o).toString().equals("ERROR")) {
                    return "ERROR";
                } else {
                    double temp = Double.parseDouble((match(first, second, o)).toString());
                    ordered.remove(i);
                    ordered.remove(i - 1);
                    ordered.remove(i - 2);
                    ordered.add(i - 2, temp);
                }
            }
            System.out.println(ordered);
        }
        String result = ordered.get(0).toString();
        double r = Double.parseDouble(ordered.get(0).toString());
        if(r%1 ==0){
            result = Long.toString((long)r);
        }


        return result;
    }
    private boolean isScientiftic(String s){
        if(s.equals("sin") || s.equals("cos") || s.equals("tan") || s.equals("log") || s.equals("ln") || s.equals("^2")
        || s.equals("^3") || s.equals("√"))
            return true;
        else {
            return false;
        }

    }
    private Object scientifticMatch(double num, String operator){
        double result = 0;
        switch(operator){
            case "sin":
                result = Math.sin(num);
                break;
            case "cos":
                result = Math.cos(num);
                break;
            case "tan":
                if(num% (Math.PI/2) == 0){
                    return "ERROR";
                }
                else {
                    result = Math.tan(num);
                }
                break;
            case "log":
                if(num <= 0){
                    return "ERROR";
                }
                else {
                    result = Math.log10(num);
                }
                break;
            case "ln":
                if(num <= 0){
                    return "ERROR";
                }
                else {
                    result = Math.log(num);
                }
                break;
            case "^2":
                result = Math.pow(num, 2);
                break;
            case "^3":
                result = Math.pow(num, 3);
                break;
            case "√":
                if(num < 0){
                    return "ERROR";
                }
                else{
                    result = Math.sqrt(num);
                }
                break;
        }
        return result;
    }
}
