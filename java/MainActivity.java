package com.example.btpii;

import android.os.Build;
import android.os.Bundle;


import android.os.VibrationEffect;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Vibrator;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    Vibrator vibrator;

    Button btnOne, btnTwo, btnThree, btnFour, btnFive,
            btnSix, btnSeven, btnEight, btnNine, btnZero,
            btnDecimal;
    Button btnClear, btnEqual, btnDivide, btnMultiply,
            btnMinus, btnAdd;
    TextView tvExpression, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);       /*enabling the activity to use system vibrator*/

        /* Number Buttons */
        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);

        btnDecimal = (Button) findViewById(R.id.btnDecimal);

        /* Operator Buttons */
        btnClear = (Button) findViewById(R.id.btnClear);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEqual = (Button) findViewById(R.id.btnEqual);

        /*The input and output text fields*/
        tvExpression = (TextView) findViewById(R.id.tvExpression);
        tvResult = (TextView) findViewById(R.id.tvResult);


        clearScreen();

        /* The various buttons and their calculator and vibration functionalities described*/
        btnClear.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 20, 0, 60, 0, 20};
                    long[] interv = new long[]{0, 300, 100, 100, 100, 300, 100, 100};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression(".");
                    clearScreen();
                }
                return true;
            }
        });


        btnEqual.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               if (event.getAction() == MotionEvent.ACTION_DOWN){

                   int[] ampli = new int[]{0, 60, 0, 20, 0, 20, 0, 20, 0, 60};
                   long[] interv = new long[]{0, 300, 100, 100, 100, 100, 100, 100, 100, 300};
                   VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                   vibrator.vibrate(vib1);
                   
                   String expression = tvExpression.getText().toString();

                   /*Parsing the input string using rhino and caluclating the arithmetic expression*/
                   Context rhino = Context.enter();

                   rhino.setOptimizationLevel(-1);

                   String finalResult = "";

                   try {
                       Scriptable scriptable = rhino.initStandardObjects();
                       finalResult = rhino.evaluateString(scriptable,expression,"javascript",1,null).toString();
                   }catch (Exception e){
                       finalResult="0";
                   }

                   tvResult.setText(finalResult);
               }

               return true;
            }
        });

        btnOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 20, 0, 60, 0, 60, 0, 60, 0, 60};
                    long[] interv = new long[]{0, 100, 100, 300, 100, 300, 100, 300, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("1");
                }
                return true;
            }
        });
        btnTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 20, 0, 20, 0, 60, 0, 60, 0, 60};
                    long[] interv = new long[]{0, 100, 100, 100, 100, 300, 100, 300, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("2");
                }
                return true;
            }
        });
        btnThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 20, 0, 20, 0, 20, 0, 60, 0, 60};
                    long[] interv = new long[]{0, 100, 100, 100, 100, 100, 100, 300, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("3");
                }
                return true;
            }
        });
        btnFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 20, 0, 20, 0, 20, 0, 20, 0, 60};
                    long[] interv = new long[]{0, 100, 100, 100, 100, 100, 100, 100, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("4");
                }
                return true;
            }
        });
        btnFive.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 20, 0, 20, 0, 20, 0, 20, 0, 20};
                    long[] interv = new long[]{0, 100, 100, 100, 100, 100, 100, 100, 100, 100};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("5");
                }
                return true;
            }
        });
        btnSix.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 20, 0, 20, 0, 20, 0, 20};
                    long[] interv = new long[]{0, 300, 100, 100, 100, 100, 100, 100, 100, 100};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("6");
                }
                return true;
            }
        });
        btnSeven.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 60, 0, 20, 0, 20, 0, 20};
                    long[] interv = new long[]{0, 300, 100, 300, 100, 100, 100, 100, 100, 100};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("7");
                }
                return true;
            }
        });
        btnEight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 60, 0, 60, 0, 20, 0, 20};
                    long[] interv = new long[]{0, 300, 100, 300, 100, 300, 100, 100, 100, 100};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("8");
                }
                return true;
            }
        });
        btnNine.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 60, 0, 60, 0, 60, 0, 20};
                    long[] interv = new long[]{0, 300, 100, 300, 100, 300, 100, 300, 100, 100};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("9");
                }
                return true;
            }
        });
        btnZero.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 60, 0, 60, 0, 60, 0, 60};
                    long[] interv = new long[]{0, 300, 100, 300, 100, 300, 100, 300, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("0");
                }
                return true;
            }
        });

        btnDecimal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 20, 0, 60, 0, 20, 0, 60, 0, 20, 0, 60};
                    long[] interv = new long[]{0, 100, 100, 300, 100, 100, 100, 300, 100, 100, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression(".");
                }
                return true;
            }
        });

        btnDivide.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 20, 0, 20, 0, 60, 0, 20};
                    long[] interv = new long[]{0, 300, 100, 100, 100, 100, 100, 300, 100, 100};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("/");
                }
                return true;
            }
        });
        btnMultiply.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 20, 0, 20, 0, 60};
                    long[] interv = new long[]{0, 300, 100, 100, 100, 100, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("*");
                }
                return true;
            }
        });
        btnMinus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 60, 0, 20, 0, 20, 0, 20, 0, 20, 0, 60};
                    long[] interv = new long[]{0, 300, 100, 100, 100, 100, 100, 100, 100, 100, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("-");
                }
                return true;
            }
        });
        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.O)
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    int[] ampli = new int[]{0, 20, 0, 60, 0, 20, 0, 60, 0, 20};
                    long[] interv = new long[]{0, 100, 100, 300, 100, 100, 100, 300, 100, 100, 100, 300};
                    VibrationEffect vib1 = VibrationEffect.createWaveform(interv, ampli, -1);
                    vibrator.vibrate(vib1);
                    writeExpression("+");
                }
                return true;
            }
        });








    };

    /*converting input from user to string*/
    void writeExpression(String value){
        String expression = tvExpression.getText().toString();
        expression = expression + value;

        tvExpression.setText(expression);
    }

    /*clear the input text field*/
    void clearScreen(){
        tvExpression.setText("");
        tvResult.setText("0");
    }
}