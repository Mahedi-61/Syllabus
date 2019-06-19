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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import bd.org.shibir.adapter.AdapterForAHM;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.MemberSyllabus;
import java.util.ArrayList;

public class MemberAyatHadithMemorization extends Activity implements OnClickListener, OnItemClickListener {
    private Button bSaveAyatHadith;
    private int id;
    private String keyAyatMemorization;
    private String keyHadithMemorization;
    private String keyName;
    private String keyNew;
    private ListView lvSyllabusAlocona;
    private SharedPreferences member;
    private int totalNewAddition;
    private String totalNewAdditionKey;
    private TextView tvHeading;
    private TextView tvTotalAyatNo;
    private TextView tvTotalCompletedAyat;
    private TextView tvTotalCompletedHadith;
    private TextView tvTotalHadithNo;
    private ArrayList<String> viewArrayList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_pattern_ayat_hadith);
        this.id = getIntent().getIntExtra("id", 0);
        this.member = getSharedPreferences("member", 0);
        this.keyAyatMemorization = this.id + "member_ayat_memorization";
        this.keyHadithMemorization = this.id + "member_hadith_memorization";
        this.keyName = this.id + "member_ayat_hadith";
        this.keyNew = this.id + "new_member_ayat_hadith";
        this.totalNewAdditionKey = this.id + "new_member_ayat_hadith_no";
        this.viewArrayList = new ArrayList();
        this.tvHeading = (TextView) findViewById(R.id.tvSyllabusAlocona);
        this.tvTotalAyatNo = (TextView) findViewById(R.id.tvTotalAyatPAH);
        this.tvTotalCompletedAyat = (TextView) findViewById(R.id.tvTotalCompletedAyatPAH);
        this.tvTotalHadithNo = (TextView) findViewById(R.id.tvTotalHadithPAH);
        this.tvTotalCompletedHadith = (TextView) findViewById(R.id.tvTotalCompletedHadithPAH);
        this.tvHeading.setText("বিষয় ভিত্তিক  আয়াত ও হাদীস");
        this.tvTotalAyatNo.setText("100");
        this.tvTotalCompletedAyat.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyAyatMemorization, this.id))).toString());
        this.tvTotalHadithNo.setText("35");
        this.tvTotalCompletedHadith.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyHadithMemorization, this.id))).toString());
        this.lvSyllabusAlocona = (ListView) findViewById(R.id.lvSyllabusAlocona);
        this.bSaveAyatHadith = (Button) findViewById(R.id.bAddNewSyllabusAlocona);
        for (String s : MemberSyllabus.memberSubjectWiseAyatHadith) {
            this.viewArrayList.add(s);
        }
        this.totalNewAddition = this.member.getInt(this.totalNewAdditionKey, 0);
        for (int i = 1; i <= this.totalNewAddition; i++) {
            this.viewArrayList.add(this.member.getString(this.keyNew + i, ""));
        }
        this.lvSyllabusAlocona.setAdapter(new AdapterForAHM(this, this.viewArrayList, this.keyName, this.id));
        this.lvSyllabusAlocona.setOnItemClickListener(this);
        this.bSaveAyatHadith.setOnClickListener(this);
    }

    public void onClick(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dl_new_ayat_hadith_memorization);
        dialog.setTitle("Enter new topic");
        final EditText etTopicName = (EditText) dialog.findViewById(R.id.dl_etTopicNameAHM);
        final EditText etAyat = (EditText) dialog.findViewById(R.id.dl_etAyatAHM);
        final EditText etHadith = (EditText) dialog.findViewById(R.id.dl_etHadithAHM);
        Button bCancel = (Button) dialog.findViewById(R.id.bCancelNewAHM);
        ((Button) dialog.findViewById(R.id.bSaveNewAHM)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (etTopicName.getText().toString().trim().equals("")) {
                    Toast.makeText(MemberAyatHadithMemorization.this.getApplicationContext(), "Please enter a topic name !", Toast.LENGTH_SHORT).show();
                    return;
                }
                dialog.dismiss();
                MemberAyatHadithMemorization memberAyatHadithMemorization = MemberAyatHadithMemorization.this;
                memberAyatHadithMemorization.totalNewAddition = memberAyatHadithMemorization.totalNewAddition + 1;
                Editor edit = MemberAyatHadithMemorization.this.member.edit();
                edit.putString(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.keyNew)).append(MemberAyatHadithMemorization.this.totalNewAddition).toString(), etTopicName.getText().toString());
                edit.putInt(MemberAyatHadithMemorization.this.totalNewAdditionKey, MemberAyatHadithMemorization.this.totalNewAddition);
                edit.putString(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.keyAyatMemorization)).append(MemberAyatHadithMemorization.this.viewArrayList.size()).toString(), etAyat.getText().toString());
                edit.putString(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.keyHadithMemorization)).append(MemberAyatHadithMemorization.this.viewArrayList.size()).toString(), etHadith.getText().toString());
                edit.commit();
                MemberAyatHadithMemorization.this.viewArrayList.add(etTopicName.getText().toString());
                MemberAyatHadithMemorization.this.lvSyllabusAlocona = (ListView) MemberAyatHadithMemorization.this.findViewById(R.id.lvSyllabusAlocona);
                MemberAyatHadithMemorization.this.lvSyllabusAlocona.setAdapter(new AdapterForAHM(MemberAyatHadithMemorization.this, MemberAyatHadithMemorization.this.viewArrayList, MemberAyatHadithMemorization.this.keyName, MemberAyatHadithMemorization.this.id));
                MemberAyatHadithMemorization.this.tvTotalCompletedAyat.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(MemberAyatHadithMemorization.this, MemberAyatHadithMemorization.this.keyAyatMemorization, MemberAyatHadithMemorization.this.id))).toString());
                MemberAyatHadithMemorization.this.tvTotalCompletedHadith.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(MemberAyatHadithMemorization.this, MemberAyatHadithMemorization.this.keyHadithMemorization, MemberAyatHadithMemorization.this.id))).toString());
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
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dl_old_ayat_hadith_memorization);
        ((TextView) dialog.findViewById(R.id.dl_tvTopicNameOAHM)).setText((CharSequence) this.viewArrayList.get(position));
        final EditText etAyat = (EditText) dialog.findViewById(R.id.dl_etAyatOAHM);
        etAyat.setText(this.member.getString(this.keyAyatMemorization + position, ""));
        final EditText etHadith = (EditText) dialog.findViewById(R.id.dl_etHadithOAHM);
        etHadith.setText(this.member.getString(this.keyHadithMemorization + position, ""));
        Button bCancel = (Button) dialog.findViewById(R.id.bCancelOldAHM);
        final int i = position;
        final View view2 = view;
        ((Button) dialog.findViewById(R.id.bSaveOldAHM)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                Editor edit = MemberAyatHadithMemorization.this.member.edit();
                edit.putString(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.keyAyatMemorization)).append(i).toString(), etAyat.getText().toString());
                edit.putString(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.keyHadithMemorization)).append(i).toString(), etHadith.getText().toString());
                edit.commit();
                ((TextView) view2.findViewById(R.id.tvAyatHadithNo)).setText(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.member.getString(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.keyAyatMemorization)).append(i).toString(), "0"))).append("/").append(MemberAyatHadithMemorization.this.member.getString(new StringBuilder(String.valueOf(MemberAyatHadithMemorization.this.keyHadithMemorization)).append(i).toString(), "0")).toString());
                MemberAyatHadithMemorization.this.tvTotalCompletedAyat.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(MemberAyatHadithMemorization.this, MemberAyatHadithMemorization.this.keyAyatMemorization, MemberAyatHadithMemorization.this.id))).toString());
                MemberAyatHadithMemorization.this.tvTotalCompletedHadith.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(MemberAyatHadithMemorization.this, MemberAyatHadithMemorization.this.keyHadithMemorization, MemberAyatHadithMemorization.this.id))).toString());
            }
        });
        bCancel.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
