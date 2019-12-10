package com.example.mycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private Button[] numbers;
    private Button[] function;
    private Button equals;
    private double first;
    private double second;
    private String operation;
    ArrayList<String> temp = new ArrayList<>();
    ArrayList<String> results = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbers = new Button[10];
        function = new Button[4];
        equals = findViewById(R.id.equals);

        first = -1;
        second = -1;

        numbers[0] = findViewById(R.id.zero);
        numbers[1] = findViewById(R.id.one);
        numbers[2] = findViewById(R.id.two);
        numbers[3] = findViewById(R.id.three);
        numbers[4] = findViewById(R.id.four);
        numbers[5] = findViewById(R.id.five);
        numbers[6] = findViewById(R.id.six);
        numbers[7] = findViewById(R.id.seven);
        numbers[8] = findViewById(R.id.eight);
        numbers[9] = findViewById(R.id.nine);

        function[0] = findViewById(R.id.plus);
        function[1] = findViewById(R.id.minus);
        function[2] = findViewById(R.id.multiply);
        function[3] = findViewById(R.id.divide);

        numbers[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(0);
                temp.add("0");
            }
        });

        numbers[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(1);
                temp.add("1");
            }
        });

        numbers[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(2);
                temp.add("2");
            }
        });

        numbers[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(3);
                temp.add("3");
            }
        });

        numbers[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(4);
                temp.add("4");
            }
        });

        numbers[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(5);
                temp.add("5");
            }
        });

        numbers[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(6);
                temp.add("6");
            }
        });

        numbers[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(7);
                temp.add("7");
            }
        });

        numbers[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(8);
                temp.add("8");
            }
        });

        numbers[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addValue(9);
                temp.add("9");
            }
        });

        function[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperation("+");
                temp.add("+");
            }
        });

        function[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperation("-");
                temp.add("-");
            }
        });

        function[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperation("X");
                temp.add("X");
            }
        });

        function[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addOperation("/");
                temp.add("/");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (first > -1 && second >  -1 && operation != null) {
                    calculate();
                }
                temp.add("=");
            }
        });

        Button clear = findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first = -1;
                second = -1;
                operation = null;
            }
        });

        Button load = findViewById(R.id.button2);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDesmos(v);
            }
        });
    }


    public void addValue(double num) {
        if (first == -1) {
            first = num;
        } else if (second == -1) {
            second = num;
        }
    }

    public void addOperation(String func) {
        if (operation == null) {
            operation = func;
        }
    }

    public void addToFinal() {
        for (int i = 0; i < temp.size(); i++) {
            results.add(temp.remove(i));
        }
    }

    public void loadDesmos(View v) {
        Intent intent = new Intent(this, WebActivity.class);
        startActivity(intent);
    }


    public void calculate() {
        TextView solve = findViewById(R.id.Answer);

        if (operation.equals("+")) {
            solve.setText((first + second) + "");
        }

        if (operation.equals("-")) {
            solve.setText((first - second) + "");
        }

        if (operation.equals("X")) {
            solve.setText((first * second) + "");
        }

        if (operation.equals("/")) {
            solve.setText((first / second) + "");
        }
    }
}

