package com.example.jugador_rating;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class login extends AppCompatActivity {

    Button logout, about, exit, livesoccer1, livesoccer2;
    ListView listview;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        livesoccer1 = findViewById(R.id.liveFootballID1);
        livesoccer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(login.this, LiveStream1.class);
                login.this.startActivity(intt);
            }
        });

        livesoccer2 = findViewById(R.id.liveFootballID2);
        livesoccer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(login.this, LiveStream2.class);
                login.this.startActivity(intt);
            }
        });

        logout = findViewById(R.id.logoutID);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(login.this, MainActivity.class);
                login.this.startActivity(intt);
            }
        });
        about = findViewById(R.id.aboutID);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(login.this, AboutActivity.class);
                login.this.startActivity(intt);
            }
        });

        final String players[] = getResources().getStringArray(R.array.players_array);

        listview = findViewById(R.id.listViewID1);
        final ArrayAdapter<String> adpt = new ArrayAdapter<String>(login.this, R.layout.array_adapter, R.id.playerID1, players);
        listview.setAdapter(adpt);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Intent intent1 = new Intent(login.this, Eden_Hazard.class);
                    startActivity(intent1);
                }
                if(position==1) {
                    Intent intent2 = new Intent(login.this, Karim_Benzema.class);
                    startActivity(intent2);
                }
                if(position==2) {
                    Intent intent3 = new Intent(login.this, Zlatan_Ibrahimovic.class);
                    startActivity(intent3);
                }
                if(position==3) {
                    Intent intent1 = new Intent(login.this, reus.class);
                    startActivity(intent1);
                }
                if(position==4) {
                    Intent intent2 = new Intent(login.this, totti.class);
                    startActivity(intent2);
                }
                if(position==5) {
                    Intent intent3 = new Intent(login.this, ramos.class);
                    startActivity(intent3);
                }
                if(position==6) {
                    Intent intent1 = new Intent(login.this, marcelo.class);
                    startActivity(intent1);
                }
                if(position==7) {
                    Intent intent2 = new Intent(login.this, modric.class);
                    startActivity(intent2);
                }
                if(position==8) {
                    Intent intent3 = new Intent(login.this, asensio.class);
                    startActivity(intent3);
                }
                if(position==9) {
                    Intent intent1 = new Intent(login.this, navas.class);
                    startActivity(intent1);
                }
                if(position==10) {
                    Intent intent2 = new Intent(login.this, casillas.class);
                    startActivity(intent2);
                }
                if(position==11) {
                    Intent intent3 = new Intent(login.this, buffon.class);
                    startActivity(intent3);
                }
                if(position==12) {
                    Intent intent1 = new Intent(login.this, rakitic.class);
                    startActivity(intent1);
                }
                if(position==13) {
                    Intent intent2 = new Intent(login.this, neuer.class);
                    startActivity(intent2);
                }
                if(position==14) {
                    Intent intent3 = new Intent(login.this, salah.class);
                    startActivity(intent3);
                }
                if(position==15) {
                    Intent intent1 = new Intent(login.this, ribery.class);
                    startActivity(intent1);
                }
                if(position==16) {
                    Intent intent2 = new Intent(login.this, mbappe.class);
                    startActivity(intent2);
                }
                if(position==17) {
                    Intent intent3 = new Intent(login.this, messi.class);
                    startActivity(intent3);
                }
                if(position==18) {
                    Intent intent1 = new Intent(login.this, ronaldo.class);
                    startActivity(intent1);
                }
            }
        });

//        SearchView searchView = findViewById(R.id.searchID1);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adpt.getFilter().filter(newText);
//                return true;
//            }
//        });

        exit = findViewById(R.id.exitID);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogBuilder = new AlertDialog.Builder(login.this);

                alertDialogBuilder.setTitle(R.string.alert_title);
                alertDialogBuilder.setMessage(R.string.alert_message);
                alertDialogBuilder.setIcon(R.drawable.exit);
                alertDialogBuilder.setCancelable(false);

                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
