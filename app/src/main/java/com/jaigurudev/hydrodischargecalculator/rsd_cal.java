package com.jaigurudev.hydrodischargecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import static java.lang.String.format;

public class rsd_cal extends AppCompatActivity {
    private EditText rp,rh,rd,hl,hr,tr,kw;
    private TextView disch,gh,nh,n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rp=findViewById(R.id.et_1);
        rh=findViewById(R.id.et_2);
        rd=findViewById(R.id.et_3);
        hl=findViewById(R.id.et_4);
        hr=findViewById(R.id.et_5);
        tr=findViewById(R.id.et_6);
        kw=findViewById(R.id.et_7);
        Button btn = findViewById(R.id.btn_1);
        disch=findViewById(R.id.tv_r12);
        gh=findViewById(R.id.tv_r22);
        nh=findViewById(R.id.tv_r32);
        n=findViewById(R.id.tv_r42);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (rp.getText().toString().length() == 0) { rp.setText(R.string.ip_1);}
                if (rh.getText().toString().length() == 0) { rh.setText(R.string.ip_2);}
                if (rd.getText().toString().length() == 0) { rd.setText(R.string.ip_3);}
                if (hl.getText().toString().length() == 0) { hl.setText(R.string.ip_4);}
                if (hr.getText().toString().length() == 0) { hr.setText(R.string.ip_5);}
                if (tr.getText().toString().length() == 0) { tr.setText(R.string.ip_6);}
                if (kw.getText().toString().length() == 0) { kw.setText(R.string.ip_7);}


                double P = Double.parseDouble(rp.getText().toString());
                double H = Double.parseDouble(rh.getText().toString());
                double D = Double.parseDouble(rd.getText().toString());
                double L = Double.parseDouble(hl.getText().toString());
                double h1 = Double.parseDouble(hr.getText().toString());
                double h2 = Double.parseDouble(tr.getText().toString());
                double p = Double.parseDouble(kw.getText().toString());

                double h=(h1-h2)*(100-L)/100;
                double N=P*35.28/(D*9.8*H);
                double d= p*35.28/(N*h*9.8);
                disch.setText(format(Locale.US,"%s",Math.round( d*100.0/100.0)));

                gh.setText(format(Locale.US,"%s",Math.round((h1-h2)*100.0)/100.0));
                nh.setText(format(Locale.US,"%s",Math.round(h*100.0)/100.0));
                n.setText(format(Locale.US,"%s",Math.round((N*100)*1000.0)/1000.0));


            }
        });



    }
}