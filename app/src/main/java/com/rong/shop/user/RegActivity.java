package com.rong.shop.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rong.shop.R;



/**
 * Created by Administrator on 2016/7/30.
 */
public class RegActivity extends AppCompatActivity {
    private Context context = null;
    private User register = null;
    private UserManager userManager = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_ui);


        userManager=new UserManager();

        final EditText edtRegU= (EditText)findViewById(R.id.edtRegU);
        final EditText edtRegP = (EditText)findViewById(R.id.edtRegP);
        final EditText edtRegC = (EditText)findViewById(R.id.edtRegC);
        final TextView txtChkCode = (TextView)findViewById(R.id.txtChkCode);
        txtChkCode.setText("456");

      /*  private String getCheckCode(){
            String strInt = " ";
            Integer i = new Integer((int) (Math.random() * 100000000));
            strInt = String.valueOf(i);
            if (strInt.length() != 8) {
                return getCheckCode();
            } else {
                return strInt;
            }
        }

        txtChkCode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((TextView) v).setText(getCheckCode());
            }
        });*/
        Button btnReg = (Button)findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

              /*  register = new User(edtRegU.getText().toString(),
                        edtRegP.getText().toString());
                User result= userManager.Register(register);*/
                if (!txtChkCode.getText().toString()
                        .equals(edtRegC.getText().toString())) {
                    Tool.showMessage(getApplicationContext(), "验证码错误");
                   /* String chkCode = getCheckCode();
                    txtChkCode.setText(chkCode);*/

                } else {
                    if (edtRegU.getText().toString().length()==0  ||
                            edtRegP.getText().toString().length()==0){
                        Tool.showMessage(getApplicationContext(), "账号或密码不能为空");

                    }else {
                        Tool.showMessage(getApplicationContext(), "注册成功");
                        Intent intent = new Intent(RegActivity.this, LoginActivity.class);
                        startActivity(intent);
                    /*String chkcode = getCheckCode();
                    txtChkCode.setText(chkcode);*/
                    }
                }


            }
        });
    }
}
