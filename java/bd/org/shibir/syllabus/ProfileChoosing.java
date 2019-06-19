package bd.org.shibir.syllabus;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import bd.org.shibir.adapter.AdapterForProfileList;
import bd.org.shibir.model.AllSyllabus;
import java.io.Serializable;
import java.util.ArrayList;

public class ProfileChoosing extends AppCompatActivity implements OnItemClickListener, OnClickListener {
    private Button bMyProfile;
    private Button bNewProfile;
    private ListView lvProfileList;
    private SharedPreferences profile;
    private ArrayList<Integer> profileIdList = new ArrayList();
    private ArrayList<String> profileNameList = new ArrayList();
    private ArrayList<String> profileStatusList = new ArrayList();
    private int targetStatus;
    private int totalAddedTarget;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_profile_choosing);
        this.profile = getSharedPreferences("profile", 0);
        this.bMyProfile = (Button) findViewById(R.id.bMyProfilePC);
        this.bNewProfile = (Button) findViewById(R.id.bAddNewProfilePC);
        this.bMyProfile.setOnClickListener(this);
        this.bNewProfile.setOnClickListener(this);
        this.totalAddedTarget = this.profile.getInt("total_added_target", 0);
        getSupportActionBar().setTitle(Html.fromHtml("<h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<b><font color=\"#0000FF\">Syllabus</font></b></h3>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#AFEEEE")));
        for (int i = 1; i <= this.totalAddedTarget; i++) {
            if (this.profile.getInt("target_exist_" + i, 0) != 0) {
                this.profileNameList.add(this.profile.getString("target_name_" + i, ""));
                this.profileStatusList.add(String.valueOf(this.profile.getInt("target_status_" + i, 0)));
                this.profileIdList.add(Integer.valueOf(i));
            }
        }
        this.lvProfileList = (ListView) findViewById(R.id.lvProfileListPC);
        this.lvProfileList.setAdapter(new AdapterForProfileList(this, this.profileNameList, this.profileStatusList, this.profileIdList));
        this.lvProfileList.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(this, ProfileActivity.class);
        i.putExtra("target_id", (Serializable) this.profileIdList.get(position));
        finish();
        startActivity(i);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bMyProfilePC /*2131034182*/:
                Intent myIntent = new Intent(this, MainActivity.class);
                myIntent.putExtra("id", 30000);
                startActivity(myIntent);
                return;
            case R.id.bAddNewProfilePC /*2131034184*/:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.dl_add_new_target);
                dialog.setTitle("Enter New Target");
                Button bCancelTarget = (Button) dialog.findViewById(R.id.bCancelAddNewTarget);
                Button bSaveTarget = (Button) dialog.findViewById(R.id.bSaveAddNewTarget);
                Spinner spSuraList = (Spinner) dialog.findViewById(R.id.spTargetStatus);
                final EditText etTargetName = (EditText) dialog.findViewById(R.id.etTargetName);
                spSuraList.setAdapter(new ArrayAdapter(this, R.layout.li_spinner, AllSyllabus.statusArray));
                spSuraList.setOnItemSelectedListener(new OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long arg3) {
                        ProfileChoosing.this.targetStatus = position;
                    }

                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
                bCancelTarget.setOnClickListener(new OnClickListener() {
                    public void onClick(View v2) {
                        dialog.dismiss();
                    }
                });
                bSaveTarget.setOnClickListener(new OnClickListener() {
                    public void onClick(View v2) {
                        Intent i1 = new Intent(ProfileChoosing.this, ProfileChoosing.class);
                        if (etTargetName.getText().toString().trim().equals("")) {
                            Toast.makeText(ProfileChoosing.this, "Pelase enter a target name", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        ProfileChoosing profileChoosing = ProfileChoosing.this;
                        profileChoosing.totalAddedTarget = profileChoosing.totalAddedTarget + 1;
                        Editor edit = ProfileChoosing.this.profile.edit();
                        edit.putString("target_name_" + ProfileChoosing.this.totalAddedTarget, etTargetName.getText().toString());
                        edit.putInt("target_exist_" + ProfileChoosing.this.totalAddedTarget, 1);
                        edit.putInt("target_status_" + ProfileChoosing.this.totalAddedTarget, ProfileChoosing.this.targetStatus);
                        edit.putInt(new StringBuilder(String.valueOf(ProfileChoosing.this.totalAddedTarget)).append("_condition_").append(ProfileChoosing.this.targetStatus).toString(), 1);
                        edit.putInt("total_added_target", ProfileChoosing.this.totalAddedTarget);
                        edit.commit();
                        Toast.makeText(ProfileChoosing.this, "Your target is added successufully", Toast.LENGTH_SHORT).show();
                        ProfileChoosing.this.startActivity(i1);
                        ProfileChoosing.this.finish();
                        dialog.dismiss();
                    }
                });
                dialog.show();
                return;
            default:
                return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_choosing_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAboutSyllaubs /*2131034276*/:
                startActivity(new Intent(this, About.class));
                break;
        }
        return true;
    }

    public void onBackPressed() {
        Builder alert = new Builder(this);
        alert.setTitle("Exit Syllabus");
        alert.setMessage("Are you sure to exit ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                ProfileChoosing.this.finish();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        alert.show();
    }
}
