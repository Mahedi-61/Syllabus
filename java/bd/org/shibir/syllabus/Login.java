package bd.org.shibir.syllabus;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
//    Button bForgetPassword;
    Button bLogin;
    EditText etPassword;
    EditText etPasswordHint;
    String givenPassword;
    Intent intent;
    SharedPreferences profile;
    String savePassword;
    String savePasswordHint;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.etPasswordHint = (EditText) findViewById(R.id.etPasswordHint);
        this.bLogin = (Button) findViewById(R.id.bLogin);
//        this.bForgetPassword = (Button) findViewById(R.id.bForgottenPassword);
        this.bLogin.setOnClickListener(this);
//        this.bForgetPassword.setOnClickListener(this);
        this.profile = getSharedPreferences("profile", 0);
        this.savePassword = this.profile.getString("password", "");
        this.savePasswordHint = this.profile.getString("hint", "");
        this.intent = new Intent(this, SplashActivity.class);
        this.etPasswordHint.setText(this.savePasswordHint);
        this.etPasswordHint.setEnabled(false);
        if (this.profile.getInt("first_time", 0) == 0) {
            startActivity(new Intent(this, CreateAccount.class));
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogin /*2131034258*/:
                this.givenPassword = this.etPassword.getText().toString();
                if (this.savePassword.equals(this.givenPassword)) {
                    startActivity(this.intent);
                    return;
                } else {
                    Toast.makeText(this, "Wrong Password. Try Again !!", Toast.LENGTH_SHORT).show();
                    return;
                }
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        finish();
    }
}
