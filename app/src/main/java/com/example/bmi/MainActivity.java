package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn;
        EditText edtHt,edtWt;
        TextView result;


        edtHt=findViewById(R.id.edtHt);
        edtWt=findViewById(R.id.edtWt);
        result=findViewById(R.id.txtResult);
        btn=findViewById(R.id.calBMI);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWt.getText().toString());
                int ht=Integer.parseInt(edtHt.getText().toString());

                double mtr= (double) ht /100;

                int bmi= (int) (wt/(mtr*mtr));
                if (bmi>25){
                    result.setText(getResources().getString(R.string.overWt));
                    result.setBackgroundColor(getResources().getColor(R.color.red));
                }else if (bmi<18){
                    result.setText(getResources().getString(R.string.underWt));
                    result.setBackgroundColor(getResources().getColor(R.color.blue));
                }else{
                    result.setText(getResources().getString(R.string.helthyWt));
                    result.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });
    }
}