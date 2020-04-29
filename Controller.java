package sample;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.util.function.Function;

public class Controller {
    /*
    simple bottons, text, and label
     */
    @FXML
    public Tab simple;
    @FXML
    public Tab scientific;
    @FXML
    private Tab graph;
    @FXML
    public Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button zero;
    @FXML
    private Button dzero;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button multi;
    @FXML
    private Button divid;
    @FXML
    private Button point;
    @FXML
    private Button clear;
    @FXML
    private Button delete;
    @FXML
    private Button pandn;
    @FXML
    private Button equal;
    @FXML
    private TextField simple_input;
    @FXML
    private Label simple_label;
    boolean simple_answer = false; //true for equal is pressed
    private Simple s;

    /*
    collect the event on simple page and calculate when the equal is pressed
     */
    public void setSimple(ActionEvent event){
        if(event.getSource() == one) {
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"1");
        }
        else if(event.getSource() == two){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"2");
        }
        else if(event.getSource() == three){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"3");
        }
        else if(event.getSource() == four){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"4");
        }
        else if(event.getSource() == five){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"5");
        }
        else if(event.getSource() == six){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"6");
        }
        else if(event.getSource() == seven){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"7");
        }
        else if(event.getSource() == eight){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"8");
        }
        else if(event.getSource() == nine){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"9");
        }
        else if(event.getSource() == zero){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            simple_input.setText(simple_input.getText()+"0");
        }
        else if(event.getSource() == dzero){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            if(simple_input.getText().equals("")){
                simple_input.setText("0");
            }
            else {
                simple_input.setText(simple_input.getText() + "00");
            }
        }
        else if(event.getSource() == pandn){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            if(!simple_input.getText().equals("")) {
                if (simple_input.getText().charAt(0) != '-'){
                    simple_input.setText("-" + simple_input.getText());
                }
                 else{
                    simple_input.setText(simple_input.getText().substring(1, simple_input.getText().length()));
                }
            }
        }
        else if(event.getSource() == plus){
            if(simple_answer){
                simple_label.setText(simple_input.getText());
                simple_input.setText("");
                simple_answer = false;
            }
            if(couldAddOperator(simple_input.getText(), simple_label.getText())) {
                simple_label.setText(simple_label.getText() + simple_input.getText() + " + ");
                simple_input.setText("");
            }

        }
        else if(event.getSource() == minus){
            if(simple_answer){
                simple_label.setText(simple_input.getText());
                simple_input.setText("");
                simple_answer = false;
            }
            if(couldAddOperator(simple_input.getText(), simple_label.getText())) {
                simple_label.setText(simple_label.getText() + simple_input.getText() + " - ");
                simple_input.setText("");
            }
        }
        else if(event.getSource() == multi){
            if(simple_answer){
                simple_label.setText(simple_input.getText());
                simple_input.setText("");
                simple_answer = false;
            }
            if(couldAddOperator(simple_input.getText(), simple_label.getText())) {
                simple_label.setText(simple_label.getText() + simple_input.getText() + " * ");
                simple_input.setText("");
            }
        }
        else if(event.getSource() == divid){
            if(simple_answer){
                simple_label.setText(simple_input.getText());
                simple_input.setText("");
                simple_answer = false;
            }
            if(couldAddOperator(simple_input.getText(), simple_label.getText())) {
                simple_label.setText(simple_label.getText() + simple_input.getText() + " / ");
                simple_input.setText("");
            }
        }
        else if(event.getSource() == point){
            if(simple_answer){
                simple_input.setText("");
                simple_label.setText("");
                simple_answer = false;
            }
            if(simple_input.getText().equals("")){
                simple_input.setText("0.");
            }
            else {
                simple_input.setText(simple_input.getText() + ".");
            }
        }
        else if(event.getSource() == equal){
            if(!simple_input.getText().equals("") && !simple_label.getText().equals("")) {
                simple_answer = true;
                simple_label.setText(simple_label.getText() + simple_input.getText());
                s = new Simple();
                simple_input.setText(s.calculate(simple_label.getText()));
            }
        }
        else if(event.getSource() == delete){
            if(simple_input.getText().length() > 1) {
                simple_input.setText(simple_input.getText().substring(0, simple_input.getText().length() - 1));
            }
            else{
                simple_input.setText("");
            }
        }
        else if(event.getSource() == clear){
            if(simple_answer || simple_input.getText().equals("")){
                simple_label.setText("");
                simple_input.setText("");
                simple_answer = false;
            }
            else {
                simple_input.setText("");
            }
        }

    }

    /*
    simple bottons, text, and label
     */

    @FXML
    public Button s_one;
    @FXML
    private Button s_two;
    @FXML
    private Button s_three;
    @FXML
    private Button s_four;
    @FXML
    private Button s_five;
    @FXML
    private Button s_six;
    @FXML
    private Button s_seven;
    @FXML
    private Button s_eight;
    @FXML
    private Button s_nine;
    @FXML
    private Button s_zero;
    @FXML
    private Button s_dzero;
    @FXML
    private Button s_plus;
    @FXML
    private Button s_minus;
    @FXML
    private Button s_multi;
    @FXML
    private Button s_divid;
    @FXML
    private Button s_point;
    @FXML
    private Button s_clear;
    @FXML
    private Button s_delete;
    @FXML
    private Button s_pandn;
    @FXML
    private Button s_equal;
    @FXML
    private Button s_sin;
    @FXML
    private Button s_cos;
    @FXML
    private Button s_tan;
    @FXML
    private Button s_square;
    @FXML
    private Button s_cube;
    @FXML
    private Button s_sroot;
    @FXML
    private Button s_log;
    @FXML
    private Button s_ln;
    @FXML
    private Button s_leftb;
    @FXML
    private Button s_rightb;
    @FXML
    private TextField scientific_input;
    @FXML
    private Label scientific_label;
    boolean scientific_answer = false; //true for equal is pressed
    boolean bracket = false; //true when ( is pressed and false when ) is pressed
    private Scientific ss;

    public void setScientific(ActionEvent event){
        if(event.getSource() == s_one) {
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"1");
        }
        else if(event.getSource() == s_two){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"2");
        }
        else if(event.getSource() == s_three){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"3");
        }
        else if(event.getSource() == s_four){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"4");
        }
        else if(event.getSource() == s_five){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"5");
        }
        else if(event.getSource() == s_six){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"6");
        }
        else if(event.getSource() == s_seven){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"7");
        }
        else if(event.getSource() == s_eight){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"8");
        }
        else if(event.getSource() == s_nine){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"9");
        }
        else if(event.getSource() == s_zero){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            scientific_input.setText(scientific_input.getText()+"0");
        }
        else if(event.getSource() == s_dzero){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            if(scientific_input.getText().equals("")){
                scientific_input.setText("0");
            }
            else {
                scientific_input.setText(scientific_input.getText() + "00");
            }
        }
        else if(event.getSource() == s_pandn){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            if(!scientific_input.getText().equals("")) {
                if(bracket){
                    if(Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                        int i = scientific_input.getText().length()-1;
                        while(Character.isDigit(scientific_input.getText().charAt(i))){
                            i--;
                        }
                        scientific_input.setText(scientific_input.getText().substring(0, i+1)+"-"+scientific_input.getText().substring(i+1));
                    }
                }
                else if (scientific_input.getText().charAt(0) != '-'){
                    scientific_input.setText("-" + scientific_input.getText());
                }
                else{
                    scientific_input.setText(scientific_input.getText().substring(1));
                }
            }
        }
        else if(event.getSource() == s_plus){
            if(scientific_answer){
                scientific_label.setText(simple_input.getText());
                scientific_input.setText("");
                scientific_answer = false;
            }
            if(bracket){
                if(Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                    scientific_input.setText(scientific_input.getText()+" + ");
                }
            }
            else if(couldAddOperator(scientific_input.getText(), scientific_label.getText())) {
                scientific_label.setText(scientific_label.getText() + scientific_input.getText() + " + ");
                scientific_input.setText("");
            }

        }
        else if(event.getSource() == s_minus){
            if(scientific_answer){
                scientific_label.setText(simple_input.getText());
                scientific_input.setText("");
                scientific_answer = false;
            }
            if(bracket){
                if(Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                    scientific_input.setText(scientific_input.getText()+" - ");
                }
            }
            else if(couldAddOperator(scientific_input.getText(), scientific_label.getText())) {
                scientific_label.setText(scientific_label.getText() + scientific_input.getText() + " - ");
                scientific_input.setText("");
            }
        }
        else if(event.getSource() == s_multi){
            if(scientific_answer){
                scientific_label.setText(simple_input.getText());
                scientific_input.setText("");
                scientific_answer = false;
            }
            if(bracket){
                if(Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                    scientific_input.setText(scientific_input.getText()+" * ");
                }
            }
            else if(couldAddOperator(scientific_input.getText(), scientific_label.getText())) {
                scientific_label.setText(scientific_label.getText() + scientific_input.getText() + " * ");
                scientific_input.setText("");
            }
        }
        else if(event.getSource() == s_divid){
            if(scientific_answer){
                scientific_label.setText(simple_input.getText());
                scientific_input.setText("");
                scientific_answer = false;
            }
            if(bracket){
                if(Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                    scientific_input.setText(scientific_input.getText()+" - ");
                }
            }
            else if(couldAddOperator(scientific_input.getText(), scientific_label.getText())) {
                scientific_label.setText(scientific_label.getText() + scientific_input.getText() + " - ");
                scientific_input.setText("");
            }
        }
        else if(event.getSource() == s_point){
            if(scientific_answer){
                scientific_input.setText("");
                scientific_label.setText("");
                scientific_answer = false;
            }
            if(bracket && !Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                scientific_input.setText(scientific_input.getText()+"0.");
            }
            else {
                scientific_input.setText(scientific_input.getText() + ".");
            }
        }
        else if(event.getSource() == s_equal){
            if(!scientific_input.getText().equals("") && !bracket) {
                scientific_answer = true;
                scientific_label.setText(scientific_label.getText() + scientific_input.getText());
                ss = new Scientific();
                scientific_input.setText(ss.calculate(scientific_label.getText()));
            }
        }
        else if(event.getSource() == s_delete){
            if(bracket){
                if(scientific_input.getText().equals("( ")){
                    scientific_input.setText("");
                    bracket = false;
                }
                else if(Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                    scientific_input.setText(scientific_input.getText().substring(0, scientific_input.getText().length()-1));
                }
                else{
                    scientific_input.setText(scientific_input.getText().substring(0, scientific_input.getText().length()-3));
                }
            }
            else if(scientific_input.getText().length() > 1) {
                if(Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                    scientific_input.setText(scientific_input.getText().substring(0, scientific_input.getText().length()-1));
                }
                else{
                    scientific_input.setText(scientific_input.getText().substring(0, scientific_input.getText().length()-3));
                }
            }
            else{
                scientific_input.setText("");
            }
        }
        else if(event.getSource() == s_clear){
            if(scientific_answer || scientific_input.getText().equals("")){
                scientific_label.setText("");
                scientific_input.setText("");
                scientific_answer = false;
            }
            else if(bracket){
                scientific_input.setText("");
                bracket = false;
            }
            else {
                scientific_input.setText("");
            }
        }
        else if(event.getSource() == s_sin){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText("sin "+scientific_input);
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + "sin " + scientific_input.getText().substring(i + 1));
                }
            }
            else{
                scientific_input.setText("sin "+scientific_input.getText());
            }
        }
        else if(event.getSource() == s_cos){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText("cos "+scientific_input);
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + "cos " + scientific_input.getText().substring(i + 1));
                }
            }
            else{
                scientific_input.setText("cos "+scientific_input.getText());
            }
        }
        else if(event.getSource() == s_tan){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText("tan "+scientific_input);
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + "tan " + scientific_input.getText().substring(i + 1));
                }
            }
            else{
                scientific_input.setText("tan "+scientific_input.getText());
            }
        }
        else if(event.getSource() == s_log){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText("log "+scientific_input);
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + "log " + scientific_input.getText().substring(i + 1));
                }
            }
            else{
                scientific_input.setText("log "+scientific_input.getText());
            }
        }
        else if(event.getSource() == s_ln){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText("ln "+scientific_input);
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + "ln " + scientific_input.getText().substring(i + 1));
                }
            }
            else{
                scientific_input.setText("ln "+scientific_input.getText());
            }

        }
        else if(event.getSource() == s_square){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText(scientific_input+" ^2");
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + scientific_input.getText().substring(i + 1)+ " ^2");
                }
            }
            else{
                scientific_input.setText(scientific_input.getText()+" ^2");
            }
        }
        else if(event.getSource() == s_cube){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText(scientific_input+" ^3");
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + scientific_input.getText().substring(i + 1) + " ^3");
                }
            }
            else{
                scientific_input.setText(scientific_input.getText()+" ^3");
            }
        }
        else if(event.getSource() == s_sroot){
            if(scientific_answer){
                scientific_label.setText("");
                scientific_input.setText("√ "+scientific_input);
                scientific_answer = false;
            }
            else if(bracket) {
                if (Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length() - 1))) {
                    int i = scientific_input.getText().length() - 1;
                    while (Character.isDigit(scientific_input.getText().charAt(i))) {
                        i--;
                    }
                    scientific_input.setText(scientific_input.getText().substring(0, i + 1) + "√ " + scientific_input.getText().substring(i + 1));
                }
            }
            else{
                scientific_input.setText("√ "+scientific_input.getText());
            }

        }
        else if(event.getSource() == s_leftb){
            scientific_input.setText("( ");
            bracket = true;

        }
        else if(event.getSource() == s_rightb){
            if(bracket && Character.isDigit(scientific_input.getText().charAt(scientific_input.getText().length()-1))){
                scientific_input.setText(scientific_input.getText()+" )");
                bracket = false;
            }
        }
    }

    @FXML
    private LineChart lineGraph1;
    @FXML
    public Button g_one;
    @FXML
    private Button g_two;
    @FXML
    private Button g_three;
    @FXML
    private Button g_four;
    @FXML
    private Button g_five;
    @FXML
    private Button g_six;
    @FXML
    private Button g_seven;
    @FXML
    private Button g_eight;
    @FXML
    private Button g_nine;
    @FXML
    private Button g_zero;
    @FXML
    private Button g_m;
    @FXML
    private Button g_point;
    @FXML
    private Button g_clear;
    @FXML
    private Button g_pandn;
    @FXML
    private Button g_b;


    @FXML
    private Button lineGraph;
    @FXML
    private Button lineClear;

    @FXML
    private Label line1;

    int edit = 0;
    String m = "m";
    String b = "b";

    public void setGraph(ActionEvent event){
        if(edit == 1){
            if(m.equals("m")){
                m = "";
            }
            if(event.getSource() == g_one){
                m+="1";
            }
            else if(event.getSource() == g_two){
                m+="2";
            }
            else if(event.getSource() == g_three){
                m+="3";
            }
            else if(event.getSource() == g_four){
                m+="4";
            }
            else if(event.getSource() == g_five){
                m+="5";
            }
            else if(event.getSource() == g_six){
                m+="6";
            }
            else if(event.getSource() == g_seven){
                m+="7";
            }
            else if(event.getSource() == g_eight){
                m+="8";
            }
            else if(event.getSource() == g_nine){
                m+="9";
            }
            else if(event.getSource() == g_zero){
                m+="0";
            }
            else if(event.getSource() == g_point){
                if(m.equals("")){
                    m+="0.";
                }
                else{
                    m+=".";
                }
            }
            else if(event.getSource() == g_pandn){
                if(!m.equals("")) {
                    if (m.charAt(0) == '-') {
                        m = m.substring(1);
                    } else {
                        m = "-" + m;
                    }
                }
            }
            else if(event.getSource() == g_clear){
                m = "m";
            }
            line1.setText("y="+m+"x+"+b);
        }
        else if(edit == 2){
            if(b.equals("b")){
                b = "";
            }
            if(event.getSource() == g_one){
                b+="1";
            }
            else if(event.getSource() == g_two){
                b+="2";
            }
            else if(event.getSource() == g_three){
                b+="3";
            }
            else if(event.getSource() == g_four){
                b+="4";
            }
            else if(event.getSource() == g_five){
                b+="5";
            }
            else if(event.getSource() == g_six){
                b+="6";
            }
            else if(event.getSource() == g_seven){
                b+="7";
            }
            else if(event.getSource() == g_eight){
                b+="8";
            }
            else if(event.getSource() == g_nine){
                b+="9";
            }
            else if(event.getSource() == g_zero){
                b+="0";
            }
            else if(event.getSource() == g_point){
                if(b.equals("")){
                    b+="0.";
                }
                else{
                    b+=".";
                }
            }
            else if(event.getSource() == g_pandn){
                if(!b.equals("")) {
                    if (b.charAt(0) == '-') {
                        b = b.substring(1);
                    } else {
                        b = "-" + b;
                    }
                }
            }
            else if(event.getSource() == g_clear){
                b = "b";
            }
            line1.setText("y="+m+"x+"+b);
        }
    }
    public void graph(ActionEvent event){
        if(!m.equals("m") && !b.equals("b")) {
            Graph line = new Graph(lineGraph1, 10);
            if (event.getSource() == lineGraph) {
                double tempm = Double.parseDouble(m);
                double tempb = Double.parseDouble(b);
                line.plotLine(x -> x * tempm + tempb);
            }
            else if (event.getSource() == lineClear) {
                line.clear();
                m = "m";
                b = "b";
                line1.setText("y="+m+"x+"+b);
            }
        }
    }
    public void editing(ActionEvent event) {
        if(event.getSource() == g_m){
            edit = 1;
        }
        else if(event.getSource() == g_b){
            if(b.equals("b")){
                b = "";
            }
            edit = 2;
        }
    }
    private boolean couldAddOperator(String input, String label){
        if(input.length() != 0){
            return true;
        }
        else if(label.charAt(label.length()-1) != ' '){
            return true;
        }
        else
            return false;
    }

}
