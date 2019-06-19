package bd.org.shibir.syllabus;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import bd.org.shibir.adapter.AdapterForOnlyAloconaInAssociate;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.AssociateSyllabus;
import java.util.ArrayList;

public class AssociateSyllabusAlocona extends Activity implements OnClickListener, OnItemClickListener {
    private SharedPreferences associate;
    private ArrayList<String> associateAloconaList;
    private Button bAddNewAlocona;
    private int id;
    private String keyName;
    private String keyNew;
    private String keyNewNo;
    private ListView lvSyllabusList;
    private int newKeyNo;
    private TextView tvSyllabusName;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_pattern_alocona);
        this.associate = getSharedPreferences("associate", 0);
        this.id = getIntent().getIntExtra("id", 0);
        this.tvSyllabusName = (TextView) findViewById(R.id.tvSyllabusAlocona);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvSyllabusList = (ListView) findViewById(R.id.lvSyllabusAlocona);
        this.bAddNewAlocona = (Button) findViewById(R.id.bAddNewSyllabusAlocona);
        if (getIntent().getStringExtra("from").equals("associate_overview_0")) {
            this.keyNew = this.id + "new_associate_darsul_quran";
            this.keyName = this.id + "associate_darsul_quran";
            this.keyNewNo = this.id + "new_associate_darsul_quran_no";
            this.associateAloconaList = new ArrayList();
            for (String s : AssociateSyllabus.associateDarsulQuranList) {
                this.associateAloconaList.add(s);
            }
            this.newKeyNo = this.associate.getInt(this.keyNewNo, 0);
            for (i = 1; i <= this.newKeyNo; i++) {
                this.associateAloconaList.add(this.associate.getString(this.keyNew + i, ""));
            }
            this.tvTotalNo.setText("2");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInAssociate(this, this.associateAloconaList, this.keyName));
            this.tvSyllabusName.setText("দারসুল কুরআন");
        }
        if (getIntent().getStringExtra("from").equals("associate_overview_1")) {
            this.keyNew = this.id + "new_associate_darsul_hadith";
            this.keyName = this.id + "associate_darsul_hadith";
            this.keyNewNo = this.id + "new_associate_darsul_hadith_no";
            this.associateAloconaList = new ArrayList();
            for (String s2 : AssociateSyllabus.associateDarsulHadithList) {
                this.associateAloconaList.add(s2);
            }
            this.newKeyNo = this.associate.getInt(this.keyNewNo, 0);
            for (i = 1; i <= this.newKeyNo; i++) {
                this.associateAloconaList.add(this.associate.getString(this.keyNew + i, ""));
            }
            this.tvTotalNo.setText("1");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInAssociate(this, this.associateAloconaList, this.keyName));
            this.tvSyllabusName.setText("দারসুল হাদীস");
        }
        if (getIntent().getStringExtra("from").equals("associate_overview_2")) {
            this.keyNew = this.id + "new_associate_alocona_note";
            this.keyName = this.id + "associate_alocona_note";
            this.keyNewNo = this.id + "new_associate_alocona_no";
            this.associateAloconaList = new ArrayList();
            for (String s22 : AssociateSyllabus.associateAloconaList) {
                this.associateAloconaList.add(s22);
            }
            this.newKeyNo = this.associate.getInt(this.keyNewNo, 0);
            for (i = 1; i <= this.newKeyNo; i++) {
                this.associateAloconaList.add(this.associate.getString(this.keyNew + i, ""));
            }
            this.tvTotalNo.setText("2");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInAssociate(this, this.associateAloconaList, this.keyName));
            this.tvSyllabusName.setText("আলোচনা নোট");
        }
        this.bAddNewAlocona.setOnClickListener(this);
        this.lvSyllabusList.setOnItemClickListener(this);
    }

    public void onClick(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Enter new topic");
        dialog.setContentView(R.layout.dl_syllabus_pattern_alocona);
        final EditText etTopicName = (EditText) dialog.findViewById(R.id.dl_syllabus_alocona_etTopicName);
        Button bCancel = (Button) dialog.findViewById(R.id.bCancelSyllabusAlocoan);
        ((Button) dialog.findViewById(R.id.bSaveSyllabusAlocona)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (etTopicName.getText().toString().trim().equals("")) {
                    Toast.makeText(AssociateSyllabusAlocona.this.getApplicationContext(), "Please enter a topic name !", 0).show();
                    return;
                }
                AssociateSyllabusAlocona associateSyllabusAlocona;
                Editor edit;
                dialog.dismiss();
                if (AssociateSyllabusAlocona.this.getIntent().getStringExtra("from").equals("associate_overview_0")) {
                    AssociateSyllabusAlocona.this.associateAloconaList.add(etTopicName.getText().toString());
                    associateSyllabusAlocona = AssociateSyllabusAlocona.this;
                    associateSyllabusAlocona.newKeyNo = associateSyllabusAlocona.newKeyNo + 1;
                    edit = AssociateSyllabusAlocona.this.associate.edit();
                    edit.putString(new StringBuilder(String.valueOf(AssociateSyllabusAlocona.this.keyNew)).append(AssociateSyllabusAlocona.this.newKeyNo).toString(), etTopicName.getText().toString());
                    edit.putInt(AssociateSyllabusAlocona.this.keyNewNo, AssociateSyllabusAlocona.this.newKeyNo);
                    edit.commit();
                    AssociateSyllabusAlocona.this.lvSyllabusList = (ListView) AssociateSyllabusAlocona.this.findViewById(R.id.lvSyllabusAlocona);
                    AssociateSyllabusAlocona.this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInAssociate(AssociateSyllabusAlocona.this, AssociateSyllabusAlocona.this.associateAloconaList, AssociateSyllabusAlocona.this.keyName));
                }
                if (AssociateSyllabusAlocona.this.getIntent().getStringExtra("from").equals("associate_overview_1")) {
                    AssociateSyllabusAlocona.this.associateAloconaList.add(etTopicName.getText().toString());
                    associateSyllabusAlocona = AssociateSyllabusAlocona.this;
                    associateSyllabusAlocona.newKeyNo = associateSyllabusAlocona.newKeyNo + 1;
                    edit = AssociateSyllabusAlocona.this.associate.edit();
                    edit.putString(new StringBuilder(String.valueOf(AssociateSyllabusAlocona.this.keyNew)).append(AssociateSyllabusAlocona.this.newKeyNo).toString(), etTopicName.getText().toString());
                    edit.putInt(AssociateSyllabusAlocona.this.keyNewNo, AssociateSyllabusAlocona.this.newKeyNo);
                    edit.commit();
                    AssociateSyllabusAlocona.this.lvSyllabusList = (ListView) AssociateSyllabusAlocona.this.findViewById(R.id.lvSyllabusAlocona);
                    AssociateSyllabusAlocona.this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInAssociate(AssociateSyllabusAlocona.this, AssociateSyllabusAlocona.this.associateAloconaList, AssociateSyllabusAlocona.this.keyName));
                }
                if (AssociateSyllabusAlocona.this.getIntent().getStringExtra("from").equals("associate_overview_2")) {
                    AssociateSyllabusAlocona.this.associateAloconaList.add(etTopicName.getText().toString());
                    associateSyllabusAlocona = AssociateSyllabusAlocona.this;
                    associateSyllabusAlocona.newKeyNo = associateSyllabusAlocona.newKeyNo + 1;
                    edit = AssociateSyllabusAlocona.this.associate.edit();
                    edit.putString(new StringBuilder(String.valueOf(AssociateSyllabusAlocona.this.keyNew)).append(AssociateSyllabusAlocona.this.newKeyNo).toString(), etTopicName.getText().toString());
                    edit.putInt(AssociateSyllabusAlocona.this.keyNewNo, AssociateSyllabusAlocona.this.newKeyNo);
                    edit.commit();
                    AssociateSyllabusAlocona.this.lvSyllabusList = (ListView) AssociateSyllabusAlocona.this.findViewById(R.id.lvSyllabusAlocona);
                    AssociateSyllabusAlocona.this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInAssociate(AssociateSyllabusAlocona.this, AssociateSyllabusAlocona.this.associateAloconaList, AssociateSyllabusAlocona.this.keyName));
                }
            }
        });
        bCancel.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbAlocona);
        Editor edit = this.associate.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
    }
}
