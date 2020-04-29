package com.example.kalkulator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //xdxdxdzmiant
        
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static double result;
    //saves previous version of result, helps with multiplication
    public static double previousResult;
    public static double previousPreviousResult;


    public String operation = "";

    public void click(View view) throws Exception {
        TextView wynik = findViewById(R.id.operation);
        TextView eqal = findViewById(R.id.equals);


        switch (view.getId()) {
            case R.id.button9:
                operation += "9";
                wynik.setText(operation);
                break;
            case R.id.button8:
                operation += "8";
                wynik.setText(operation);
                break;
            case R.id.button7:
                operation += "7";
                wynik.setText(operation);
                break;
            case R.id.button6:
                operation += "6";
                wynik.setText(operation);
                break;
            case R.id.button5:
                operation += "5";
                wynik.setText(operation);
                break;
            case R.id.button4:
                operation += "4";
                wynik.setText(operation);
                break;
            case R.id.button3:
                operation += "3";
                wynik.setText(operation);
                break;
            case R.id.button2:
                operation += "2";
                wynik.setText(operation);
                break;
            case R.id.button1:
                operation += "1";
                wynik.setText(operation);
                break;
            case R.id.button0:
                operation += "0";
                wynik.setText(operation);
                break;
            case R.id.buttonPlus:
                operation += "+";
                wynik.setText(operation);
                functionResult(operation);
                eqal.setText(String.valueOf(result));
                break;
            case R.id.buttonMinus:
                operation += "-";
                wynik.setText(operation);
                functionResult(operation);
                eqal.setText(String.valueOf(result));
                break;
            case R.id.buttonMultiplication:
                operation += "x";
                wynik.setText(operation);
                functionResult(operation);
                eqal.setText(String.valueOf(result));
                break;
            case R.id.buttonDivide:
                operation += "÷";
                wynik.setText(operation);
                functionResult(operation);
                eqal.setText(String.valueOf(result));
                break;
            case R.id.buttonNawR:
                operation += ")";
                wynik.setText(operation);
                break;
            case R.id.buttonNawL:
                operation += "(";
                wynik.setText(operation);
                break;
            case R.id.buttonEq:
                String eoperation = operation + "=";
                wynik.setText(eoperation);
                functionResult(eoperation);
                eqal.setText(String.valueOf(result));
                break;
            case R.id.buttonClear:
                clear();
                break;
        }
    }

    //2+3=
    public String functionResult(String line) {
        String[] tab = line.split("");
        int number = tab.length;

        if(number==4) {
            double a = Double.parseDouble(tab[number - 4]);
            double b = Double.parseDouble(tab[number - 2]);
///////////////////////xd
            if (tab[number - 3].equals("+")) {
                previousResult = a;
                result += a + b;
            } else if (tab[number - 3].equals("-")) {
                previousResult = a;
                result += a - b;
            } else if (tab[number - 3].equals("x")) {
                result += a * b;
                previousResult = result;
            } else if (tab[number - 3].equals("÷")) {
                result += a / b;
                previousResult = result;
            }
        }
        else if(number >4) {
        double a = Double.parseDouble(tab[number - 4]);
        double b = Double.parseDouble(tab[number - 2]);
        if (tab[number - 3].equals("+")) {
            previousResult = result;
            result += b;
        } else if (tab[number - 3].equals("-")) {
            previousResult = result;
            result -= b;
        }
        //multiplication
        else if (tab[number - 3].equals("x")) {

            if (tab[number - 5].equals("x")) {
                double c = Double.parseDouble(tab[number - 6]);
                result = previousResult;
                if (tab[number - 5].equals("-")) {
                    result -= c * a * b;
                } else {
                    result += c * a * b;
                }

            } else {
                result = previousResult;
                if (tab[number - 5].equals("-")) {
                    result -= a * b;
                } else {
                    result += a * b;
                }
            }
            //division
        } else if (tab[number - 3].equals("÷")) {

            if (tab[number - 5].equals("÷")) {
                double c = Double.parseDouble(tab[number - 6]);
                result = previousResult;
                if (tab[number - 5].equals("-")) {
                    result -= c / a / b;
                } else {
                    result += c / a / b;
                }

            } else {
                result = previousResult;
                if (tab[number - 5].equals("-")) {
                    result -= a / b;
                } else {
                    result += a / b;
                }
            }

        }
    }

        return line;
}


    public void clear() {
        operation = "";
        result = 0;
        TextView eqal2 = findViewById(R.id.equals);
        TextView wynik = findViewById(R.id.operation);
        eqal2.setText("");
        wynik.setText("");

    }


}
