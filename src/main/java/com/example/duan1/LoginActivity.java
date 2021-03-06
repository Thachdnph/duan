package com.example.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.duan1.dao.NhavienDAO;


public class LoginActivity extends AppCompatActivity {
    private EditText edUsername;
    private EditText edPassword;
    private CheckBox chkRemeber;
    private Button btnDangnhap;
    private Button btnHuy;
    NhavienDAO nhavienDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername =findViewById(R.id.tendangnhap);
        edPassword =findViewById(R.id.pwd);
        chkRemeber =findViewById(R.id.checkBox);
        btnDangnhap =findViewById(R.id.btn_dangnhap);
        btnHuy =findViewById(R.id.btn_huy);

        nhavienDAO = new NhavienDAO(LoginActivity.this);

        //lay du lieu tu SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        edUsername.setText(sharedPreferences.getString("USERNAME",""));
        edPassword.setText(sharedPreferences.getString("PASS",""));
        chkRemeber.setChecked(sharedPreferences.getBoolean("REMEMBER",false));



        //cac event
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

    }



    private void checkLogin() {
        String user = edUsername.getText().toString();
        String pass = edPassword.getText().toString();
        if (user.isEmpty()||pass.isEmpty()){
            Toast.makeText(getApplicationContext(), "T??n ????ng nh???p v?? m???t kh???u kh??ng ???????c ????? tr???ng", Toast.LENGTH_LONG).show();
        }else {
            if (nhavienDAO.checkLogin(user,pass)>0 || (user.equals("admin") && pass.equals("admin"))){
                Toast.makeText(getApplicationContext(), "????ng nh???p th??nh c??ng", Toast.LENGTH_LONG).show();
                rememberUser(user,pass,chkRemeber.isChecked());
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
                finish();

            }else {
                Toast.makeText(getApplicationContext(), "T??n ????ng nh???p ho???c m???t kh???u kh??ng ????ng", Toast.LENGTH_SHORT).show();
            }

        }

  }

    private void rememberUser(String user, String pass, boolean checked) {

        SharedPreferences sharedPreferences = getSharedPreferences("USER_FILE",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(!checked){
            editor.clear();
        }else {
            editor.putString("USERNAME",user);
            editor.putString("PASS",pass);
            editor.putBoolean("REMEMBER",checked);
        }
        //commit
        editor.commit();

    }
}
