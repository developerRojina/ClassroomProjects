package com.aadim.classroom.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aadim.classroom.R;


public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnClear, btnBrackets, btnPercentage, btnDivide, btn7, btn8, btn9, btnMultiply, btn4, btn5, btn6, btnMinus, btnOne, btnTwo, btnThree, btnPlus, btnZero, btnDoubleZero, btnDecimal, btnEquals;

    String firstNumber = "", secondNumber = "", outputText = "";

    CalculatorAction calculatorAction;

    TextView tvCalculationResult;

    Boolean isResultCalculated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvCalculationResult = findViewById(R.id.tv_calculation_result);
        btnDivide = findViewById(R.id.btn_divide);
        btn7 = findViewById(R.id.btn_seven);
        btn8 = findViewById(R.id.btn_eight);
        btn9 = findViewById(R.id.btn_nine);
        btnMultiply = findViewById(R.id.btn_multiply);
        btn4 = findViewById(R.id.btn_four);
        btn5 = findViewById(R.id.btn_five);
        btn6 = findViewById(R.id.btn_six);
        btnMinus = findViewById(R.id.btn_subtract);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnPlus = findViewById(R.id.btn_plus);
        btnZero = findViewById(R.id.btn_zero);
        btnDoubleZero = findViewById(R.id.btn_double_zero);
        btnDecimal = findViewById(R.id.btn_dot);
        btnEquals = findViewById(R.id.btn_equals);


        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnDoubleZero.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEquals.setOnClickListener(this);
        btnDecimal.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        switch (view.getId()) {
            case R.id.btn_one:
            case R.id.btn_two:
            case R.id.btn_three:
            case R.id.btn_four:
            case R.id.btn_five:
            case R.id.btn_six:
            case R.id.btn_seven:
            case R.id.btn_eight:
            case R.id.btn_nine:
            case R.id.btn_zero:
            case R.id.btn_double_zero:
            case R.id.btn_dot: {

                if (isResultCalculated) {
                    isResultCalculated = false;
                    clearPreviousInput();
                }

                if (calculatorAction == null) {
                    firstNumber = firstNumber + clickedButton.getText();
                    outputText = outputText + clickedButton.getText();
                    setOutputText();
                } else {

                    secondNumber = secondNumber + clickedButton.getText();
                    outputText = outputText + clickedButton.getText();
                    setOutputText();
                }

                break;
            }


            case R.id.btn_plus: {

                if (calculatorAction != null) {
                    handelMoreThanTwoNumbers();
                }

                calculatorAction = CalculatorAction.ADD;
                outputText = outputText + "+";
                setOutputText();
                break;
            }
            case R.id.btn_multiply: {
                if (calculatorAction != null) {
                    handelMoreThanTwoNumbers();
                }
                calculatorAction = CalculatorAction.MULTIPLY;
                outputText = outputText + "*";
                setOutputText();
                break;
            }
            case R.id.btn_divide: {
                if (calculatorAction != null) {
                    handelMoreThanTwoNumbers();
                }
                calculatorAction = CalculatorAction.DIVIDE;
                outputText = outputText + "/";
                setOutputText();
                break;
            }
            case R.id.btn_subtract: {
                if (calculatorAction != null) {
                    handelMoreThanTwoNumbers();
                }
                calculatorAction = CalculatorAction.SUBTRACT;
                outputText = outputText + "-";
                setOutputText();
                break;
            }

            case R.id.btn_equals: {
                outputText = outputText + "=";
                calculateResult();
                break;

            }


        }
    }

    private float getFirstNumber() {
        return Float.parseFloat(firstNumber);
    }

    private float getSecondNumber() {
        return Float.parseFloat(secondNumber);
    }


    private void setOutputText() {
        tvCalculationResult.setText(outputText);
    }

    private void clearPreviousInput() {
        calculatorAction = null;
        firstNumber = "";
        secondNumber = "";
        outputText = "";
        tvCalculationResult.setText("");
    }

    private float calculateResult() {
        isResultCalculated = true;
        float result;
        if (calculatorAction == CalculatorAction.ADD) {
            result = getFirstNumber() + getSecondNumber();
            outputText = outputText + result;

        } else if (calculatorAction == CalculatorAction.SUBTRACT) {
            result = getFirstNumber() - getSecondNumber();
            outputText = outputText + result;

        } else if (calculatorAction == CalculatorAction.MULTIPLY) {
            result = getFirstNumber() * getSecondNumber();
            outputText = outputText + result;

        } else if (calculatorAction == CalculatorAction.DIVIDE) {
            result = getFirstNumber() / getSecondNumber();
            outputText = outputText + result;

        } else {
            result = 0f;
        }
        setOutputText();
        return result;
    }

    private void handelMoreThanTwoNumbers() {
        float result = calculateResult();
        firstNumber = "" + result;
        secondNumber = "";
        outputText = firstNumber;
        setOutputText();
        isResultCalculated = false;
    }

}