package com.example.firebaselogin.activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebaselogin.R;

public class ListActivity extends AppCompatActivity {
    private Button btnNext, LL, CPA, doheny, Pe, bookStore, markHall, kaprielianHall, salHall, jep, sgm, ronaldTutorHall, zumbergeHall, studentUnion, ADM, powellHall, lyonCenter;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Button btnChekIn, btnViewRisk, btnViewStats,  back, riskDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        LL = findViewById(R.id.leavyLibrary);
        CPA = findViewById(R.id.cpa);
        doheny = findViewById(R.id.doheny);
        Pe = findViewById(R.id.pe);
        bookStore = findViewById(R.id.bookstore);
        markHall = findViewById(R.id.markhall2);
        kaprielianHall = findViewById(R.id.KaprielHall);
        salHall = findViewById(R.id.sal);
        jep = findViewById(R.id.jep);
        ronaldTutorHall = findViewById(R.id.tutorhall);
        sgm = findViewById(R.id.sgm);
        zumbergeHall= findViewById(R.id.zhs);
        studentUnion = findViewById(R.id.studentUnion);
        ADM = findViewById(R.id.adm);
        powellHall = findViewById(R.id.powellHall);
        lyonCenter = findViewById(R.id.LyonCenter);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListActivity.this, MainActivity.class));

            }
        });

        LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });

        CPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });

        doheny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });


        Pe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });

        bookStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }

        });

        markHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });

        kaprielianHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });


        salHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });


        jep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });

        ronaldTutorHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });

        sgm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }


        });


        zumbergeHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }

        });

        studentUnion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }

        });

        ADM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }

        });


        powellHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }

        });


        lyonCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }

        });



    }

    public void createNewContactDialog() {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.activity_popup, null);
        btnChekIn = popup.findViewById(R.id.checkIn);
        btnViewRisk = popup.findViewById(R.id.viewRisk);
        btnViewStats = popup.findViewById(R.id.viewStats);
        back = popup.findViewById(R.id.back);
        // show the popup window
        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


}


