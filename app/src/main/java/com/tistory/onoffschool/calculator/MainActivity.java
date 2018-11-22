package com.tistory.onoffschool.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 1. 변수 선언
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    // 10개 숫자 버튼 배열
    Button[] numButtons= new Button[10];
    // 10개 숫자 버튼의 id값 배열
    Integer[] numBtnIds = {R.id.BtnNum0, R.id.BtnNum1,R.id.BtnNum2,R.id.BtnNum3,R.id.BtnNum4,R.id.BtnNum5,R.id.BtnNum6,R.id.BtnNum7,R.id.BtnNum8,R.id.BtnNum9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_main);

        setTitle("사칙연산 계산기");
        //2.
        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        // 0~9 숫자 버튼 대입
        for(int i=0; i < numBtnIds.length; i++){
            numButtons[i] = (Button) findViewById(numBtnIds[i]);
        }
        // 0~9 숫자 버튼 이벤트 처리

        for( int i = 0; i < numBtnIds.length ; i++ ){
            final int INDEX;
            INDEX = i;
            numButtons[INDEX].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    // focus number -> editText에 setting
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString() + numButtons[INDEX].getText().toString();
                        edit1.setText
                                (num1);
                    }else if (edit2.isFocused() == true){
                        num2 = edit2.getText().toString() + numButtons[INDEX].getText().toString();
                        edit2.setText(num2);
;                    }else{
                        Toast.makeText(getApplicationContext(),"~",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // 3. 덧셈버튼, 뺄샘버튼, 곱셈버튼, 나눗셈버튼 이벤트 처리
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
            }
        });
        //뺄셈 버튼 이벤트 처리 문장
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
            }
        });
        // 곱셈 버튼 이벤트 처리
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
            }
        });
        // 나눗셈 버튼 이벤트 처리
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : "+ result.toString());
            }
        });

    }
}