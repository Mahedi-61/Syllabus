package bd.org.shibir.syllabus;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final String TAG ="MainActivity" ;
    Button bAssociate;
    Button bHigher;
    Button bMember;
    Button bSchool;
    Button bWorker;
    private int id;
    private SharedPreferences profile;


    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.profile = getSharedPreferences("profile", 0);
        this.id = getIntent().getIntExtra("id", 0);
        getSupportActionBar().setTitle(Html.fromHtml("<h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<b><font color=\"#0000FF\">User Profile</font></b></h3>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#AFEEEE")));
        this.bWorker = (Button) findViewById(R.id.bWorkerSyllabus);
        this.bAssociate = (Button) findViewById(R.id.bAssociateSyllabus);
        this.bMember = (Button) findViewById(R.id.bMemberSyllabus);
        this.bSchool = (Button) findViewById(R.id.bSchoolSyllabus);
        this.bHigher = (Button) findViewById(R.id.bHigherSyllabus);
        Typeface tfs = Typeface.createFromAsset(getAssets(), "fonts/Durga_03-09-2005.ttf");
        this.bWorker.setTypeface(tfs);
        this.bAssociate.setTypeface(tfs);
        this.bMember.setTypeface(tfs);
        this.bSchool.setTypeface(tfs);
        this.bHigher.setTypeface(tfs);
        this.bWorker.setText("কর্মী সিলেবাস");
        this.bAssociate.setText("সাথী সিলেবাস");
        this.bMember.setText("সদস্য সিলেবাস");
        this.bSchool.setText("স্কুল পাঠ্য");
        this.bHigher.setText("উচ্চতর সিলেবাস");
        this.bWorker.setOnClickListener(this);
        this.bAssociate.setOnClickListener(this);
        this.bMember.setOnClickListener(this);
        this.bSchool.setOnClickListener(this);
        this.bHigher.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bWorkerSyllabus /*2131034174*/:
                Intent iw = new Intent(this, WorkerSyllabusOverview.class);
                iw.putExtra("id", this.id);
                Log.i(TAG, "MyClass.getView() — get id number " + this.id);
                startActivity(iw);
                return;
            case R.id.bAssociateSyllabus /*2131034175*/:
                Intent ia = new Intent(this, AssociateSyllabusOverview.class);
                ia.putExtra("id", this.id);
                startActivity(ia);
                return;
            case R.id.bMemberSyllabus /*2131034176*/:
                Intent im = new Intent(this, MemberSyllabusOverview.class);
                im.putExtra("id", this.id);
                startActivity(im);
                return;
            case R.id.bSchoolSyllabus /*2131034177*/:
                Intent is = new Intent(this, SchoolSyllabusOverview.class);
                is.putExtra("id", this.id);
                startActivity(is);
                return;
            case R.id.bHigherSyllabus /*2131034178*/:
                startActivity(new Intent(this, HigherSyllabusOverview.class));
                return;
            default:
                return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        final Dialog dialog;
        Button bCancelPasswordSettings;
        switch (item.getItemId()) {
            case R.id.menuAboutMe /*2131034271*/:
                dialog = new Dialog(this);
                dialog.setTitle("About Me");
                dialog.setContentView(R.layout.dl_about_me);
                final EditText userName = (EditText) dialog.findViewById(R.id.etUserNameSettings);
                userName.setText(this.profile.getString("user_name", ""));
                final EditText branchName = (EditText) dialog.findViewById(R.id.etBranchNameSettings);
                branchName.setText(this.profile.getString("user_branch", ""));
                final EditText responsibility = (EditText) dialog.findViewById(R.id.etResponsibilitySettings);
                responsibility.setText(this.profile.getString("user_responsibility", ""));
                final EditText department = (EditText) dialog.findViewById(R.id.etDepartmentSettings);
                department.setText(this.profile.getString("user_department", ""));
                bCancelPasswordSettings = (Button) dialog.findViewById(R.id.bCancelProfileSettings);
                final Dialog dialog2 = dialog;
                ((Button) dialog.findViewById(R.id.bSaveProfileSettings)).setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Editor edit = MainActivity.this.profile.edit();
                        edit.putString("user_name", userName.getText().toString());
                        edit.putString("user_branch", branchName.getText().toString());
                        edit.putString("user_responsibility", responsibility.getText().toString());
                        edit.putString("user_department", department.getText().toString());
                        edit.commit();
                        dialog2.dismiss();
                        Toast.makeText(MainActivity.this.getApplicationContext(), "Your profile is saved successfully !", 0).show();
                    }
                });
                bCancelPasswordSettings.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.menuChangePassword /*2131034272*/:
                dialog = new Dialog(this);
                dialog.setTitle("Change Password");
                dialog.setContentView(R.layout.dl_change_password);
                final EditText etHint = (EditText) dialog.findViewById(R.id.etPasswordHintSettings);
                etHint.setText(this.profile.getString("hint", ""));
                final EditText etOldPasswordSettings = (EditText) dialog.findViewById(R.id.etOldPasswordSettings);
                final EditText etNewPasswordSettings = (EditText) dialog.findViewById(R.id.etNewPasswordSettings);
                bCancelPasswordSettings = (Button) dialog.findViewById(R.id.bCancelPasswordSettings);
                ((Button) dialog.findViewById(R.id.bSavePasswordSettings)).setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        String givenPassword = etOldPasswordSettings.getText().toString();
                        String savePassword = MainActivity.this.profile.getString("password", "");
                        if (etHint.getText().toString().trim().equals("")) {
                            Toast.makeText(MainActivity.this.getApplicationContext(), "Enter New Password Hint !!",Toast.LENGTH_SHORT).show();
                        } else if (!savePassword.equals(givenPassword)) {
                            Toast.makeText(MainActivity.this.getApplicationContext(), "Present Password doesn't match !!", Toast.LENGTH_SHORT).show();
                        } else if (etNewPasswordSettings.getText().toString().trim().equals("")) {
                            Toast.makeText(MainActivity.this.getApplicationContext(), "Enter New Password !!", Toast.LENGTH_SHORT).show();
                        } else {
                            Editor edit = MainActivity.this.profile.edit();
                            edit.putString("hint", etHint.getText().toString());
                            edit.putString("password", etNewPasswordSettings.getText().toString());
                            edit.commit();
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this.getApplicationContext(), "New Password saved successfully !!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                bCancelPasswordSettings.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.menuBackupPassword /*2131034273*/:
                dialog = new Dialog(this);
                dialog.setContentView(R.layout.dl_mobile_number_settings);
                dialog.setTitle("Sms your password !!");
                Button bCancelMobile = (Button) dialog.findViewById(R.id.bCancelMobileSettings);
                Button bSaveMobile = (Button) dialog.findViewById(R.id.bSaveMobileSettings);
                EditText etMobileNumber = (EditText) dialog.findViewById(R.id.etMobileNumberSettings);
                etMobileNumber.setText(this.profile.getString("user_mobile_number", ""));
                final EditText editText = etMobileNumber;
                bSaveMobile.setOnClickListener(new OnClickListener() {
                    public void onClick(View v2) {
                        if (editText.getText().toString().trim().equals("")) {
                            Toast.makeText(MainActivity.this, "backup password service is disabled", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(MainActivity.this, "Your mobile number is saved successfully", Toast.LENGTH_SHORT).show();
                        Editor edit = MainActivity.this.profile.edit();
                        edit.putString("user_mobile_number", editText.getText().toString());
                        edit.commit();
                        dialog.dismiss();
                    }
                });
                bCancelMobile.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
        return true;
    }
}
