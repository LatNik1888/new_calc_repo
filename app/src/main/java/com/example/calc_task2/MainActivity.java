package com.example.calc_task2;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//Код неоптимальный, но время, увы, поджимает. Все размеры в ресурсы занесу к следующему дз. Плюс, попробую покурить мануалы по Data Binding.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inputField;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnAdd;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivision;
    Button btnEquals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputField = (EditText) findViewById(R.id.inputField);
        listener();

    }


    private void listener() {
        btn0 = (Button) findViewById(R.id.button_0);
        btn0.setOnClickListener(this);

        btn1 = (Button) findViewById(R.id.button_1);
        btn1.setOnClickListener(this);


        btn2 = (Button) findViewById(R.id.button_2);
        btn2.setOnClickListener(this);

        btn3 = (Button) findViewById(R.id.button_3);
        btn3.setOnClickListener(this);

        btn4 = (Button) findViewById(R.id.button_4);
        btn4.setOnClickListener(this);

        btn5 = (Button) findViewById(R.id.button_5);
        btn5.setOnClickListener(this);

        btn6 = (Button) findViewById(R.id.button_6);
        btn6.setOnClickListener(this);

        btn7 = (Button) findViewById(R.id.button_7);
        btn7.setOnClickListener(this);

        btn8 = (Button) findViewById(R.id.button_8);
        btn8.setOnClickListener(this);

        btn9 = (Button) findViewById(R.id.button_9);
        btn9.setOnClickListener(this);

        btnDivision = (Button) findViewById(R.id.button_division);
        btnDivision.setOnClickListener(this);

        btnMultiply = (Button) findViewById(R.id.button_multiply);
        btnMultiply.setOnClickListener(this);

        btnMinus = (Button) findViewById(R.id.button_minus);
        btnMinus.setOnClickListener(this);


        btnAdd = (Button) findViewById(R.id.button_plus);
        btnAdd.setOnClickListener(this);

        btnEquals = (Button) findViewById(R.id.button_equal);
        btnEquals.setOnClickListener(this);

        inputField = (EditText) findViewById(R.id.inputField);
    }

    private boolean isMathSign;
    private String lastSign = "";

    private double num1 = 0D;
    private double num2 = 0D;


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void onClick(View v) {
        String currentText = inputField.getText().toString();
        String operatorNum = "";
        if (currentText.equals("0")) {
            inputField.setText("");
        }
        operatorNum = inputField.getText().toString();
        if (!lastSign.equals("")) {
            int index = operatorNum.lastIndexOf(lastSign);
            operatorNum = operatorNum.substring(index + 1);
        }


        switch (v.getId()) {
            case R.id.button_0:
                inputField.setText(inputField.getText() + "0");
                isMathSign = false;
                break;
            case R.id.button_1:
                inputField.setText(inputField.getText() + "1");
                isMathSign = false;
                break;
            case R.id.button_2:
                inputField.setText(inputField.getText() + "2");
                isMathSign = false;
                break;
            case R.id.button_3:
                inputField.setText(inputField.getText() + "3");
                isMathSign = false;
                break;
            case R.id.button_4:
                inputField.setText(inputField.getText() + "4");
                isMathSign = false;
                break;
            case R.id.button_5:
                inputField.setText(inputField.getText() + "5");
                isMathSign = false;
                break;
            case R.id.button_6:
                inputField.setText(inputField.getText() + "6");
                isMathSign = false;
                break;
            case R.id.button_7:
                inputField.setText(inputField.getText() + "7");
                isMathSign = false;
                break;
            case R.id.button_8:
                inputField.setText(inputField.getText() + "8");
                isMathSign = false;
                break;
            case R.id.button_9:
                inputField.setText(inputField.getText() + "9");
                isMathSign = false;
                break;
            case R.id.button_division:
                if ((TextUtils.isEmpty(inputField.getText())
                        || isMathSign) && !lastSign.equals("=")) {
                    return;
                }
                opratorCalc(operatorNum, "÷");
                isMathSign = true;
                inputField.setText(inputField.getText() + "÷");
                lastSign = "÷";
                break;
            case R.id.button_multiply:
                if ((TextUtils.isEmpty(inputField.getText())
                        || isMathSign) && !lastSign.equals("=")) {
                    return;
                }
                opratorCalc(operatorNum, "*");
                isMathSign = true;
                inputField.setText(inputField.getText() + "*");
                lastSign = "*";
                break;
            case R.id.button_minus:
                if ((TextUtils.isEmpty(inputField.getText())
                        || isMathSign) && !lastSign.equals("=")) {
                    return;
                }
                opratorCalc(operatorNum, "-");
                isMathSign = true;
                inputField.setText(inputField.getText() + "-");
                lastSign = "-";
                break;
            case R.id.button_plus:
                if ((TextUtils.isEmpty(inputField.getText())
                        || isMathSign) && !lastSign.equals("=")) {
                    return;
                }
                opratorCalc(operatorNum, "+");
                isMathSign = true;
                inputField.setText(inputField.getText() + "+");
                lastSign = "+";
                break;
            case R.id.button_equal:
                double result = 0D;
                if (TextUtils.isEmpty(lastSign)) {
                    return;
                }
                resultNum(operatorNum);
                num2 = 0D;
                lastSign = "=";
                isMathSign = true;
                inputField.setText(inputField.getText() + "\n=" + String.valueOf(num1));
                break;
        }
    }


    private void operate(String operatorNum) {
        if (num2 != 0D) {
            if (lastSign.equals("÷")) {
                num2 = num2 / Double.parseDouble(operatorNum);
                num1 = num1 / num2;
            } else if (lastSign.equals("*")) {
                num2 = num2 * Double.parseDouble(operatorNum);
                num1 = num1 * num2;
            } else if (lastSign.equals("+")) {
                num2 = Double.parseDouble(operatorNum);
                num1 = num1 + num2;
            } else if (lastSign.equals("-")) {
                num2 = Double.parseDouble(operatorNum);
                num1 = num1 - num2;
            }
        } else // Расчетный случай 2: число, введенное во второй раз, равно 0
        {
            if (lastSign.equals("÷")) {
                num1 = num1 / Double.parseDouble(operatorNum);
            } else if (lastSign.equals("*")) {
                num1 = num1 * Double.parseDouble(operatorNum);
            } else if (lastSign.equals("+")) {
                num1 = num1 + Double.parseDouble(operatorNum);
            } else if (lastSign.equals("-")) {
                num1 = num1 - Double.parseDouble(operatorNum);
            }
        }
    }

    // Возвращаем результаты расчета отдельно
    public void resultNum(String operatorNumber) {
        operate(operatorNumber);

    }

    // По результатам текущего расчета для следующего ввода данных и расчета
    public void opratorCalc(String signNum, String currentNum) {
        if (TextUtils.isEmpty(lastSign)) {
            num1 = Double.parseDouble(signNum);
            return;
        }

        if (lastSign.equals(currentNum)) {
            if (lastSign.equals("÷")) {
                num1 = num1 / Double.parseDouble(signNum);
            } else if (lastSign.equals("*")) {
                num1 = num1 * Double.parseDouble(signNum);
            } else if (lastSign.equals("+")) {
                num1 = num1 + Double.parseDouble(signNum);
            } else if (lastSign.equals("-")) {
                num1 = num1 - Double.parseDouble(signNum);
            }

            return;
        }
        operate(signNum);

    }

}
