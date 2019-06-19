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
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import bd.org.shibir.adapter.AdapterForActivityProfile;
import bd.org.shibir.model.AllSyllabus;
import java.util.ArrayList;
import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity implements OnItemClickListener {
    private ListView lvTargetStatusList;
    private SharedPreferences profile;
    private ArrayList<String> statusItemCick;
    private int status_id;
    private ArrayList<String> targetSyllabusList = new ArrayList();
    private int target_id;
    private TextView tvName;
    private TextView tvStatus;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_profile);
        this.profile = getSharedPreferences("profile", 0);
        this.lvTargetStatusList = (ListView) findViewById(R.id.lvTargetStatusList);
        this.tvName = (TextView) findViewById(R.id.tvTargetNameAP);
        this.tvStatus = (TextView) findViewById(R.id.tvTargetStatusAP);
        this.target_id = getIntent().getIntExtra("target_id", 0);
        this.status_id = this.profile.getInt("target_status_" + this.target_id, 0);
        getSupportActionBar().setTitle(Html.fromHtml("<h3>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<b><font color=\"#0000FF\">Target Profile</font></b></h3>"));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#AFEEEE")));
        this.tvName.setText(this.profile.getString("target_name_" + this.target_id, ""));
        this.tvStatus.setText(AllSyllabus.statusArray[this.status_id]);
        this.lvTargetStatusList.setAdapter(new AdapterForActivityProfile(this, getStatusList()));
        this.lvTargetStatusList.setOnItemClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuEditTarget /*2131034274*/:
                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.dl_target_info);
                dialog.setTitle("About " + this.tvName.getText());
                Button bSaveTargetTI = (Button) dialog.findViewById(R.id.bSaveTargetTI);
                ((TextView) dialog.findViewById(R.id.tvTargetNameTI)).setText(this.tvName.getText());
                ((TextView) dialog.findViewById(R.id.tvTargetStatusTI)).setText(this.tvStatus.getText());
                ((EditText) dialog.findViewById(R.id.etLastStatusImprovedTI)).setText(this.profile.getString("last_improve_day_" + this.target_id, ""));
                final EditText etTargetResponsibilityTI = (EditText) dialog.findViewById(R.id.etTargetResponsibilityTI);
                etTargetResponsibilityTI.setText(this.profile.getString("target_responsibility_" + this.target_id, ""));
                final EditText etTargetMobileTI = (EditText) dialog.findViewById(R.id.etTargetMobileTI);
                etTargetMobileTI.setText(this.profile.getString("target_mobile_" + this.target_id, ""));
                final EditText etTargetAddressTI = (EditText) dialog.findViewById(R.id.etTargetAddressTI);
                etTargetAddressTI.setText(this.profile.getString("target_address_" + this.target_id, ""));
                ((TextView) dialog.findViewById(R.id.tvTargetFor)).setText(this.profile.getString("target_for_" + this.target_id, "Target For: "));
                bSaveTargetTI.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Editor edit = ProfileActivity.this.profile.edit();
                        edit.putString("target_responsibility_" + ProfileActivity.this.target_id, etTargetResponsibilityTI.getText().toString());
                        edit.putString("target_mobile_" + ProfileActivity.this.target_id, etTargetMobileTI.getText().toString());
                        edit.putString("target_address_" + ProfileActivity.this.target_id, etTargetAddressTI.getText().toString());
                        edit.commit();
                        Toast.makeText(ProfileActivity.this.getApplicationContext(), "Target info is updated", 0).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
            case R.id.menuImproveTargetStatus /*2131034275*/:
                final int i = this.status_id;
                if (i > 2) {
                    if (i == 3) {
                        Editor edit = this.profile.edit();
                        edit.putString("target_for_" + this.target_id, "Status: ");
                        edit.commit();
                        Toast.makeText(this, "Your target person's status is improved to member !!", 0).show();
                        break;
                    }
                }
                Builder alert = new Builder(this);
                alert.setTitle("Improve Status");
                alert.setMessage("Are you sure to improve your target person's status ?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ProfileActivity.this.imporveTargetStatus(i);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
                alert.show();
                break;

               default:
                   break;
        }
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        if (position == 0) {
            getSyllabusForStatusId(Integer.valueOf((String) this.statusItemCick.get(0)).intValue());
        }
        if (position == 1) {
            getSyllabusForStatusId(Integer.valueOf((String) this.statusItemCick.get(1)).intValue());
        }
        if (position == 2) {
            getSyllabusForStatusId(Integer.valueOf((String) this.statusItemCick.get(2)).intValue());
        }
    }

    private void getSyllabusForStatusId(int status_id) {
        Intent i = null;
        switch (status_id) {
            case 0:
                i = new Intent(this, WorkerSyllabusOverview.class);
                break;
            case 1:
                i = new Intent(this, SchoolSyllabusOverview.class);
                break;
            case 2:
                i = new Intent(this, AssociateSyllabusOverview.class);
                break;
            case 3:
                i = new Intent(this, MemberSyllabusOverview.class);
                break;
        }
        i.putExtra("id", this.target_id);
        startActivity(i);
    }

    private String[] getStatusList() {
        int i;
        this.targetSyllabusList = new ArrayList();
        this.statusItemCick = new ArrayList();
        for (i = 0; i <= 3; i++) {
            if (this.profile.getInt(this.target_id + "_condition_" + i, 0) == 1) {
                this.targetSyllabusList.add(AllSyllabus.syllabusArray[i]);
                this.statusItemCick.add(new StringBuilder(String.valueOf(i)).toString());
            }
        }
        String[] array = new String[this.targetSyllabusList.size()];
        for (i = 0; i < this.targetSyllabusList.size(); i++) {
            array[i] = (String) this.targetSyllabusList.get(i);
        }
        return array;
    }

    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, ProfileChoosing.class));
    }

    public void imporveTargetStatus(int i) {
        String dayId = "";
        Editor edit = this.profile.edit();
        dayId = DateFormat.format("EE, dd MMMM yyyy", Calendar.getInstance()).toString();
        if (i == 0) {
            edit.putInt("target_status_" + this.target_id, i + 2);
            edit.putInt(this.target_id + "_condition_" + (i + 2), 1);
            this.status_id = i + 2;
        } else {
            edit.putInt("target_status_" + this.target_id, i + 1);
            edit.putInt(this.target_id + "_condition_" + (i + 1), 1);
            this.status_id = i + 1;
        }
        edit.putString("last_improve_day_" + this.target_id, dayId);
        edit.commit();
        this.tvStatus.setText(AllSyllabus.statusArray[this.status_id]);
        this.lvTargetStatusList = (ListView) findViewById(R.id.lvTargetStatusList);
        this.lvTargetStatusList.setAdapter(new AdapterForActivityProfile(this, getStatusList()));
    }
}
