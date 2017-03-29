package com.example.nikita.lesson_4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz extends Activity {
    private RadioGroup groupA1;
    private RadioGroup groupB1;
    private RadioGroup groupC1;
    private RadioGroup groupD1;
    private RadioGroup groupE1;
    private Button submitA1;
    private Button submitB1;
    private Button submitC1;
    private Button submitD1;
    private Button submitE1;
    private Button result;
    private int result_answers, sign, isClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        groupA1 = (RadioGroup) findViewById(R.id.group_a1);
        groupB1 = (RadioGroup) findViewById(R.id.group_b1);
        groupC1 = (RadioGroup) findViewById(R.id.group_c1);
        groupD1 = (RadioGroup) findViewById(R.id.group_d1);
        groupE1 = (RadioGroup) findViewById(R.id.group_e1);
        submitA1 = (Button) findViewById(R.id.result_a1);
        submitB1 = (Button) findViewById(R.id.result_b1);
        submitC1 = (Button) findViewById(R.id.result_c1);
        submitD1 = (Button) findViewById(R.id.result_d1);
        submitE1 = (Button) findViewById(R.id.result_e1);
        result = (Button) findViewById(R.id.buton_result);

        result_answers = 0; sign = 0;
        groupA1.setOnCheckedChangeListener(groupListener);
        groupB1.setOnCheckedChangeListener(groupListener);
        groupC1.setOnCheckedChangeListener(groupListener);
        groupD1.setOnCheckedChangeListener(groupListener);
        groupE1.setOnCheckedChangeListener(groupListener);
        submitA1.setOnClickListener(buttonClick);
        submitB1.setOnClickListener(buttonClick);
        submitC1.setOnClickListener(buttonClick);
        submitD1.setOnClickListener(buttonClick);
        submitE1.setOnClickListener(buttonClick);

        result.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your result is "+result_answers+"/5", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private RadioButton findSelectedButton(RadioGroup group) {
        int selectedId = group.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selectedId);
        return radioButton;
    }

    private int checkAnswer(RadioButton radioButton, String word) {
        if(radioButton.getText().equals(word)) {
            result_answers++; return 1;
        } return 0;
    }

    RadioGroup.OnCheckedChangeListener groupListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            RadioGroup radioGroup = group;
            switch (radioGroup.getId()) {
                case R.id.group_a1: {
                    sign = checkAnswer(findSelectedButton(radioGroup), "New York");
                    isClicked = 1;
                } break;
                case R.id.group_b1: {
                    sign = checkAnswer(findSelectedButton(radioGroup), "Paris");
                    isClicked = 2;
                } break;
                case R.id.group_c1: {
                    sign = checkAnswer(findSelectedButton(radioGroup), "Rome");
                    isClicked = 3;
                } break;
                case R.id.group_d1: {
                    sign = checkAnswer(findSelectedButton(radioGroup), "London");
                    isClicked = 4;
                } break;
                case R.id.group_e1: {
                    sign = checkAnswer(findSelectedButton(radioGroup), "Berlin");
                    isClicked = 5;
                } break;
                default: break;
            }
        }
    };

    View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(sign == 0) Toast.makeText(getApplicationContext(), "Wrong! 0", Toast.LENGTH_SHORT).show();
            else Toast.makeText(getApplicationContext(), "Well done! +1", Toast.LENGTH_SHORT).show();
        }
    };
}
