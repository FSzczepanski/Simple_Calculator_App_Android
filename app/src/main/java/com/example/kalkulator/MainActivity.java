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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String operation = "";

    public void click(View view) throws Exception {
        TextView wynik = findViewById(R.id.operation);
        int equals;
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
                break;
            case R.id.buttonMinus:
                operation += "-";
                wynik.setText(operation);
                break;
            case R.id.buttonEq:

                wynik.setText(operation + "=");


                String[] tab = operation.split("[+]");

                equals = 0;
                for (int i = 0; i < tab.length; i++) {
                    if (!isInteger(tab[i])) {
                        String[] tab2 = tab[i].split("-");

                        int a = Integer.parseInt(tab2[0]);
                        int b = Integer.parseInt(tab2[1]);
                        equals = equals + a - b;
                    } else {
                        int a = Integer.parseInt(tab[i]);
                        equals += a;
                    }

                }
                TextView eqal = findViewById(R.id.equals);
                eqal.setText(Integer.toString(equals));
                break;
            case R.id.buttonClear:
                operation = "";
                equals = 0;
                TextView eqal2 = findViewById(R.id.equals);
                eqal2.setText("");
                wynik.setText("");
                break;
        }

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }


}
