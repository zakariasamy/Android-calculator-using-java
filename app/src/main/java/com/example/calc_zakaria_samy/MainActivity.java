package com.example.calc_zakaria_samy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String text = "";
    TextView v; // Screen

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = findViewById(R.id.cal_screen);
    }


    public void clickAny(View view){


        String tag = view.getTag().toString();


        if( (tag.equals("0")) || (tag.equals("1")) || (tag.equals("2")) || (tag.equals("3")) || (tag.equals("4")) ||
                (tag.equals("5")) || (tag.equals("6"))
                || (tag.equals("7")) || (tag.equals("8")) || (tag.equals("9")) ) {
            text+= tag;
        }
        else if( (tag.equals("+")) || (tag.equals("-")) || (tag.equals("x")) || (tag.equals("/")) ){
            if( !text.equals("") && !text.endsWith("+") && !text.endsWith("-") && !text.endsWith("*") &&
                    !text.endsWith("/") && !text.endsWith(".")  ){
                if((tag.equals("x")))
                    text+= "*";
                else
                    text += tag;
            }
        }
        else if ( tag.equals("dot")) {
            if(!text.endsWith("."))
                text += ".";
        }


        v.setText(text);
    }

    public void clickEqual(View view){

         double output = EvaluateString.evaluate(text);

          v.setText(text + " = " + output);
          text = String.valueOf(output);
    }

    public void clearAll(View view){
        text = "";
        v.setText(text);
    }

    public void clearOnce(View view){
        if (text != null && text.length() > 0)
            text = text.substring(0, text.length() - 1);
        v.setText(text);

    }
}