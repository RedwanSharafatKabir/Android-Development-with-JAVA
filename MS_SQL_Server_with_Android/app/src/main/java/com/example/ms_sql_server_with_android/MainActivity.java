package com.example.ms_sql_server_with_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private TextView institute;
    private static String ip = "192.168.0.100";
    private static String port = "1433";
    private static String Classes = "net.sourceforge.jtds.jdbc.Driver";
    private static String Database = "First_DB_Android";
    private static String databaseUsername = "Redwan_Sharafat";
    private static String databasePassword = "sharafat1997";
    private static String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+Database;
    private Connection connection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        institute = findViewById(R.id.instituteID);

        ////////////////////// Short-cut method //////////////////////
        try{
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName(Classes).newInstance();
            connection = DriverManager.getConnection(url, databaseUsername, databasePassword);

        }catch (Exception e){institute.setText("Connection failure");}

        ////////////////////// Another method //////////////////////
//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//        try {
//            Class.forName(Classes);
//            connection = DriverManager.getConnection(url, databaseUsername, databasePassword);
//            institute.setText("SUCCESS");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            institute.setText("ERROR");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            institute.setText("FAILURE");
//        }
    }

    public void sqlButton(View view){
        ////////////////////// Another method //////////////////////
//        if(connection!=null){
//            Statement statement = null;
//            try {
//                statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("select * from User_Information;");
//                while(resultSet.next()){
//                    institute.setText(resultSet.getString(1));
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            institute.setText("NULL");
//        }

        ////////////////////// Short-cut method //////////////////////
        try {
            if(connection==null){
                institute.setText("NULL");
            }
            if(connection!=null){
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from User_Information;");
                while(resultSet.next()){
                    institute.setText(resultSet.getString("institute"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
