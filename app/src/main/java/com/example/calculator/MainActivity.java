package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    double fn;
    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      Button one=findViewById(R.id.one);
        Button two=findViewById(R.id.two);
        Button three=findViewById(R.id.three);
        Button four=findViewById(R.id.four);
        Button five=findViewById(R.id.five);
        Button six=findViewById(R.id.six);
        Button seven=findViewById(R.id.seven);
        Button eigth=findViewById(R.id.eigth);
        Button nine=findViewById(R.id.nine);
        Button zero=findViewById(R.id.zero);
        Button minus=findViewById(R.id.subtraction);
        Button plus=findViewById(R.id.add);
        Button mul=findViewById(R.id.multiplication);
        Button divide=findViewById(R.id.division);

        Button equal=findViewById(R.id.equal);
        Button dot=findViewById(R.id.dot);
        Button on=findViewById(R.id.onn);
        Button off=findViewById(R.id.off);
        Button ac=findViewById(R.id.acc);
        Button del=findViewById(R.id.del);
//        String operation;

        TextView screen=findViewById(R.id.l1);
//        TextView screeninput=findViewById(R.id.screeninput);

        ArrayList<Button> b =new ArrayList<>();
        b.add(one);
        b.add(two);
        b.add(three);
        b.add(four);
        b.add(five);
        b.add(six);
        b.add(seven);
        b.add(eigth);
        b.add(nine);
        b.add(zero);

        for (int j = 0; j < b.size(); j++) {
            Button i = b.get(j);
            i.setOnClickListener(v -> {
                if(!screen.getText().toString().equals("0"))
                {
                    screen.setText(screen.getText().toString() + i.getText().toString());
                }
                else
                {
                    screen.setText(i.getText().toString());
                }
            });
        }

        ArrayList<Button> op=new ArrayList<>();
        op.add(plus);
        op.add(minus);
        op.add(divide);
        op.add(mul);
        for (int j = 0; j <op.size(); j++) {
            Button p = op.get(j);
            p.setOnClickListener(v -> {
                fn = Double.parseDouble(screen.getText().toString());

                 operation = p.getText().toString();
                screen.setText("0");
            });
        }
        equal.setOnClickListener(v1 -> {
                    double sn = Double.parseDouble(screen.getText().toString());
                    double result=calculate(operation,fn,sn);
                    screen.setText(String.valueOf(result));
                    fn=result;
        });





        del.setOnClickListener(v -> {
            String t=screen.getText().toString();
            if (t.length()>1)
            {
                screen.setText(t.substring(0,t.length()-1));
            }
            else {
                screen.setText("0");
            }
        });

        dot.setOnClickListener(v -> {
            if(!screen.getText().toString().contains("."))
            {
                screen.setText(screen.getText().toString()+".");
            }
        });
        on.setOnClickListener(v -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });

        off.setOnClickListener(v -> screen.setVisibility(View.GONE));

        ac.setOnClickListener(v -> screen.setText("0"));


    }

    private double calculate(String operation, double fn,double sn) {

        double result;
        switch (operation)
        {
            case "+":
                result= fn + sn;
                break;
            case "-":
                result=fn-sn;
                break;
            case "*":
                result=fn*sn;
                break;
            case "/":
                result=fn/sn;
                break;
            default:
                result=fn%sn;
        }

        return result;

    }

}
