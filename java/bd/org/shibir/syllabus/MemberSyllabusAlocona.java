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
import bd.org.shibir.adapter.AdapterForOnlyAloconaInMember;
import bd.org.shibir.adapter.AdapterForOnlyBooksInMember;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.MemberSyllabus;
import java.util.ArrayList;

public class MemberSyllabusAlocona extends Activity implements OnClickListener, OnItemClickListener {
    private Button bAddNewAlocona;
    private int id;
    private String keyName;
    private String keyNew;
    private ListView lvSyllabusList;
    private SharedPreferences member;
    private ArrayList<String> memberAloconaList;
    private int totalNewAddition;
    private String totalNewAdditionKey;
    private TextView tvSyllabusName;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_pattern_alocona);
        this.member = getSharedPreferences("member", 0);
        this.id = getIntent().getIntExtra("id", 0);
        this.tvSyllabusName = (TextView) findViewById(R.id.tvSyllabusAlocona);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvSyllabusList = (ListView) findViewById(R.id.lvSyllabusAlocona);
        this.bAddNewAlocona = (Button) findViewById(R.id.bAddNewSyllabusAlocona);
        if (getIntent().getStringExtra("from").equals("memeber_overview_0")) {
            this.keyName = this.id + "member_darsul_quran";
            this.keyNew = this.id + "new_member_darsul_quran";
            this.totalNewAdditionKey = this.id + "new_member_darsul_quran_no";
            this.memberAloconaList = new ArrayList();
            for (String s : MemberSyllabus.memberDarsulQuranList) {
                this.memberAloconaList.add(s);
            }
            this.totalNewAddition = this.member.getInt(this.totalNewAdditionKey, 0);
            for (i = 1; i <= this.totalNewAddition; i++) {
                this.memberAloconaList.add(this.member.getString(this.keyNew + i, ""));
            }
            this.tvTotalNo.setText("10");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInMember(this, this.memberAloconaList, this.keyName));
            this.tvSyllabusName.setText("দারসুল কুরআন");
        }
        if (getIntent().getStringExtra("from").equals("memeber_overview_1")) {
            this.keyName = this.id + "member_darsul_hadith";
            this.keyNew = this.id + "new_member_darsul_hadith";
            this.totalNewAdditionKey = this.id + "new_member_darsul_hadith_no";
            this.memberAloconaList = new ArrayList();
            for (String s2 : MemberSyllabus.memberDarsulHadithList) {
                this.memberAloconaList.add(s2);
            }
            this.totalNewAddition = this.member.getInt(this.totalNewAdditionKey, 0);
            for (i = 1; i <= this.totalNewAddition; i++) {
                this.memberAloconaList.add(this.member.getString(this.keyNew + i, ""));
            }
            this.tvTotalNo.setText("7");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInMember(this, this.memberAloconaList, this.keyName));
            this.tvSyllabusName.setText("দারসুল  হাদীস");
        }
        if (getIntent().getStringExtra("from").equals("memeber_overview_2")) {
            this.keyName = this.id + "member_alocona_note";
            this.keyNew = this.id + "new_member_alocona_note";
            this.totalNewAdditionKey = this.id + "new_member_alcona_note_no";
            this.memberAloconaList = new ArrayList();
            for (String s22 : MemberSyllabus.memberAloconaList) {
                this.memberAloconaList.add(s22);
            }
            this.totalNewAddition = this.member.getInt(this.totalNewAdditionKey, 0);
            for (i = 1; i <= this.totalNewAddition; i++) {
                this.memberAloconaList.add(this.member.getString(this.keyNew + i, ""));
            }
            this.tvTotalNo.setText("10");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInMember(this, this.memberAloconaList, this.keyName));
            this.tvSyllabusName.setText("আলোচনা নোট");
        }
        if (getIntent().getStringExtra("from").equals("memeber_overview_4")) {
            this.keyName = this.id + "member_book_note";
            this.tvTotalNo.setText("12");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
            this.tvSyllabusName.setText("বই নোট");
            this.lvSyllabusList.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberBookNoteList, MemberSyllabus.memberBookNoteWriterList, this.keyName, this.id));
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
                    Toast.makeText(MemberSyllabusAlocona.this.getApplicationContext(), "Please enter a topic name !", 0).show();
                    return;
                }
                MemberSyllabusAlocona memberSyllabusAlocona;
                Editor edit;
                dialog.dismiss();
                if (MemberSyllabusAlocona.this.getIntent().getStringExtra("from").equals("memeber_overview_0")) {
                    MemberSyllabusAlocona.this.memberAloconaList.add(etTopicName.getText().toString());
                    memberSyllabusAlocona = MemberSyllabusAlocona.this;
                    memberSyllabusAlocona.totalNewAddition = memberSyllabusAlocona.totalNewAddition + 1;
                    edit = MemberSyllabusAlocona.this.member.edit();
                    edit.putString(new StringBuilder(String.valueOf(MemberSyllabusAlocona.this.keyNew)).append(MemberSyllabusAlocona.this.totalNewAddition).toString(), etTopicName.getText().toString());
                    edit.putInt(MemberSyllabusAlocona.this.totalNewAdditionKey, MemberSyllabusAlocona.this.totalNewAddition);
                    edit.commit();
                    MemberSyllabusAlocona.this.lvSyllabusList = (ListView) MemberSyllabusAlocona.this.findViewById(R.id.lvSyllabusAlocona);
                    MemberSyllabusAlocona.this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInMember(MemberSyllabusAlocona.this, MemberSyllabusAlocona.this.memberAloconaList, MemberSyllabusAlocona.this.keyName));
                }
                if (MemberSyllabusAlocona.this.getIntent().getStringExtra("from").equals("memeber_overview_1")) {
                    MemberSyllabusAlocona.this.memberAloconaList.add(etTopicName.getText().toString());
                    memberSyllabusAlocona = MemberSyllabusAlocona.this;
                    memberSyllabusAlocona.totalNewAddition = memberSyllabusAlocona.totalNewAddition + 1;
                    edit = MemberSyllabusAlocona.this.member.edit();
                    edit.putString(new StringBuilder(String.valueOf(MemberSyllabusAlocona.this.keyNew)).append(MemberSyllabusAlocona.this.totalNewAddition).toString(), etTopicName.getText().toString());
                    edit.putInt(MemberSyllabusAlocona.this.totalNewAdditionKey, MemberSyllabusAlocona.this.totalNewAddition);
                    edit.commit();
                    MemberSyllabusAlocona.this.lvSyllabusList = (ListView) MemberSyllabusAlocona.this.findViewById(R.id.lvSyllabusAlocona);
                    MemberSyllabusAlocona.this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInMember(MemberSyllabusAlocona.this, MemberSyllabusAlocona.this.memberAloconaList, MemberSyllabusAlocona.this.keyName));
                }
                if (MemberSyllabusAlocona.this.getIntent().getStringExtra("from").equals("memeber_overview_2")) {
                    MemberSyllabusAlocona.this.memberAloconaList.add(etTopicName.getText().toString());
                    memberSyllabusAlocona = MemberSyllabusAlocona.this;
                    memberSyllabusAlocona.totalNewAddition = memberSyllabusAlocona.totalNewAddition + 1;
                    edit = MemberSyllabusAlocona.this.member.edit();
                    edit.putString(new StringBuilder(String.valueOf(MemberSyllabusAlocona.this.keyNew)).append(MemberSyllabusAlocona.this.totalNewAddition).toString(), etTopicName.getText().toString());
                    edit.putInt(MemberSyllabusAlocona.this.totalNewAdditionKey, MemberSyllabusAlocona.this.totalNewAddition);
                    edit.commit();
                    MemberSyllabusAlocona.this.lvSyllabusList = (ListView) MemberSyllabusAlocona.this.findViewById(R.id.lvSyllabusAlocona);
                    MemberSyllabusAlocona.this.lvSyllabusList.setAdapter(new AdapterForOnlyAloconaInMember(MemberSyllabusAlocona.this, MemberSyllabusAlocona.this.memberAloconaList, MemberSyllabusAlocona.this.keyName));
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
        Editor edit = this.member.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
    }
}
