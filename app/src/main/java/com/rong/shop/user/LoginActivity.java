package com.rong.shop.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rong.shop.MainActivity;
import com.rong.shop.R;


public class LoginActivity extends AppCompatActivity {
    private Context context = null;
    private User loginUser = null;
    private User user = null;
    private UserManager userManager = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_ui);


        userManager=new UserManager();

        final EditText edtUserId = (EditText) findViewById(R.id.edtUserId);
        final EditText edtPassWord = (EditText) findViewById(R.id.edtPassWord);

        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loginUser =userManager.Login(edtUserId.getText().toString(), edtPassWord.getText().toString());
                if (loginUser!= null) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Tool.showMessage(getApplicationContext(), "账号或密码错误");
                   /* Tool.showMessage(context(), "账号或密码错误");*/
                }
            }

        });

        TextView linkReg = (TextView)findViewById(R.id.linkReg);
        linkReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent regIntent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(regIntent);
            }
        });


    }
}
