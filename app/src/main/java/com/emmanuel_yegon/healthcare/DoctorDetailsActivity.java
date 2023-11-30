package com.emmanuel_yegon.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 = {
            {"Doctor name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 646356323", "600"},
            {"Doctor name : Joe Kibut", "Hospital Address : Hawaii", "Exp : 15yrs", "Mobile No : 646556323", "900"},
            {"Doctor name : Mane Mane", "Hospital Address : Florida", "Exp : 25yrs", "Mobile No : 646356323", "1600"},
            {"Doctor name : Junior Junior", "Hospital Address : DC", "Exp : 10yrs", "Mobile No : 646356323", "400"},
            {"Doctor name : Stevo Kimani", "Hospital Address : Austin", "Exp : 7yrs", "Mobile No : 646356323", "450"},
    };

    private String[][] doctor_details2 = {
            {"Doctor name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 643356323", "600"},
            {"Doctor name : Joe Kibut", "Hospital Address : Hawaii", "Exp : 15yrs", "Mobile No : 6766356323", "900"},
            {"Doctor name : Mane Mane", "Hospital Address : Florida", "Exp : 25yrs", "Mobile No : 646396323", "1600"},
            {"Doctor name : Junior Junior", "Hospital Address : DC", "Exp : 10yrs", "Mobile No : 6400356323", "400"},
            {"Doctor name : Stevo Kimani", "Hospital Address : Austin", "Exp : 7yrs", "Mobile No : 646356323", "450"},
    };
    private String[][] doctor_details3 = {
            {"Doctor name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 6465356323", "600"},
            {"Doctor name : Joe Kibut", "Hospital Address : Hawaii", "Exp : 15yrs", "Mobile No : 6465356323", "900"},
            {"Doctor name : Mane Mane", "Hospital Address : Florida", "Exp : 25yrs", "Mobile No : 621356323", "1600"},
            {"Doctor name : Junior Junior", "Hospital Address : DC", "Exp : 10yrs", "Mobile No : 646426323", "400"},
            {"Doctor name : Stevo Kimani", "Hospital Address : Austin", "Exp : 7yrs", "Mobile No : 644356323", "450"},
    };
    private String[][] doctor_details4 = {
            {"Doctor name : Kigen Kevin", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 946356323", "600"},
            {"Doctor name : Jun Joy", "Hospital Address : Hawaii", "Exp : 15yrs", "Mobile No : 446356323", "900"},
            {"Doctor name : Jaymo Jay", "Hospital Address : Florida", "Exp : 25yrs", "Mobile No : 246356323", "1600"},
            {"Doctor name : Senior Senior", "Hospital Address : DC", "Exp : 10yrs", "Mobile No : 116356323", "400"},
            {"Doctor name : Stevo Kimani", "Hospital Address : Austin", "Exp : 7yrs", "Mobile No : 0046356323", "450"},
    };
    private String[][] doctor_details5 = {
            {"Doctor name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 2346356323", "600"},
            {"Doctor name : Joe Kibut", "Hospital Address : Hawaii", "Exp : 15yrs", "Mobile No : 4346356323", "900"},
            {"Doctor name : Mane Mane", "Hospital Address : Florida", "Exp : 25yrs", "Mobile No : 7846356323", "1600"},
            {"Doctor name : Junior Junior", "Hospital Address : DC", "Exp : 10yrs", "Mobile No : 8946356323", "400"},
            {"Doctor name : Stevo Kimani", "Hospital Address : Austin", "Exp : 7yrs", "Mobile No :3446356323", "450"},
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0) {
            doctor_details = doctor_details1;
        } else if (title.compareTo("Dietician") == 0) {
            doctor_details = doctor_details2;
        } else if (title.compareTo("Dentist") == 0) {
            doctor_details = doctor_details3;
        } else if (title.compareTo("Surgeon") == 0) {
            doctor_details = doctor_details4;
        } else {
            doctor_details = doctor_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });


        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa = new  SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
    }

}