package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private TextView Screen;
    private Button AC, Power, Back, Div, Mul, Add, Min, Ans, Equal, Point, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero;
    private String input, answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main2);
        Screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);

        Mul = findViewById(R.id.mul);
        Add = findViewById(R.id.add);
        Min = findViewById(R.id.min);
        Ans = findViewById(R.id.ans);
        Equal = findViewById(R.id.equal);
        Point = findViewById(R.id.point);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Zero = findViewById(R.id.zero);
    }

    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = "";
                break;
            case "ANS":
                input += answer;
                break;
          /*  case "X":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input +="^";
                    break;  */
            case "=":
                Solve();
                answer = input;
                break;
            case "B":
                String newText = input.substring(0, input.length() - 1);
                input = newText;
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/") || data.equals("X") || data.equals("P")) {
                    Solve();
                }
                input += data;

        }
        Screen.setText(input);

    }

    private void Solve() {
        if (input.split("X").length == 2) {
            String number[] = input.split("X");
            try {
                double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input += " = ";
                input += mul;
            } catch (Exception e) {
                //regular
            }
        } else if (input.split("/").length == 2) {
            String number[] = input.split("/");
            try {
                double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input += " = ";
                input += div;
            } catch (Exception e) {
                //regular
            }
        } else if (input.split("P").length == 2) {
            String number[] = input.split("P");
            try {
                double pow = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
                input += " = ";
                input += pow;
            } catch (Exception e) {
                //regular
            }
        } else if (input.split("\\+").length == 2) {
            String number[] = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input += " = ";
                input += sum;
            } catch (Exception e) {
                //regular
            }
        } else if (input.split("-").length == 2) {
            String number[] = input.split("-");
            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                input += " = ";
                input += sub;
            } catch (Exception e) {
                //regular
            }
        }
        String n[] = input.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                input = n[0];
            }
        }
        Screen.setText(input);

    }


}