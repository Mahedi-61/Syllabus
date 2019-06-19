package bd.org.shibir.syllabus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends Activity implements OnClickListener {
    EditText etPasswordCreate;
    EditText etPasswordHintCreate;
    EditText etRePasswordCreate;
    EditText etYourEmailCreate;
    EditText etYourNameCreate;
    SharedPreferences profile;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        this.profile = getSharedPreferences("profile", 0);
        initialize();
    }

    private void initialize() {
        Button bSaveCreateAccount = (Button) findViewById(R.id.bSaveCreateAccount);
        this.etYourNameCreate = (EditText) findViewById(R.id.etYourNameCreate);
        this.etPasswordCreate = (EditText) findViewById(R.id.etPasswordCreate);
        this.etRePasswordCreate = (EditText) findViewById(R.id.etRePasswordCreate);
        this.etPasswordHintCreate = (EditText) findViewById(R.id.etPasswordHintCreate);
        bSaveCreateAccount.setOnClickListener(this);
    }

    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        finish();
    }

    public void onClick(View v) {
        if (this.etYourNameCreate.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter your name", 0).show();
        } else if (this.etPasswordCreate.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter your password", 0).show();
        } else if (this.etRePasswordCreate.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please re-enter your password", 0).show();
        } else if (this.etPasswordHintCreate.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Please enter your password hint", 0).show();
        } else if (this.etPasswordCreate.getText().toString().equals(this.etRePasswordCreate.getText().toString())) {
            Editor edit = this.profile.edit();
            edit.putString("password", this.etPasswordCreate.getText().toString());
            edit.putString("hint", this.etPasswordHintCreate.getText().toString());
            edit.putInt("first_time", 1);
            edit.putString("user_name", this.etYourNameCreate.getText().toString());
            edit.commit();
            startActivity(new Intent(this, SplashActivity.class));
        } else {
            Toast.makeText(this, "Password doesn't match. Try again !!", Toast.LENGTH_SHORT).show();
        }
    }
}
