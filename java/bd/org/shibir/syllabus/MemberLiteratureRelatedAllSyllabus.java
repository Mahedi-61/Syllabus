package bd.org.shibir.syllabus;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import bd.org.shibir.adapter.AdapterForOnlyBooksInMember;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.MemberSyllabus;

public class MemberLiteratureRelatedAllSyllabus extends Activity implements OnItemClickListener {
    private int id;
    private String keyName;
    private ListView lvMemberStudySyllabus;
    private SharedPreferences member;
    private TextView tvMemberStudySyllabus;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.id = getIntent().getIntExtra("id", 0);
        this.member = getSharedPreferences("member", 0);
        this.tvMemberStudySyllabus = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvMemberStudySyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        if (getIntent().getStringExtra("from").equals("member_literature_0")) {
            this.keyName = this.id + "member_ls_quran";
            this.tvMemberStudySyllabus.setText("আল-কুরআন");
            this.tvTotalNo.setText("5");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSQuranBooks, MemberSyllabus.memberLSQuranWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("member_literature_1")) {
            this.keyName = this.id + "member_ls_hadith";
            this.tvMemberStudySyllabus.setText("আল-হাদীস");
            this.tvTotalNo.setText("4");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSHadithBooks, MemberSyllabus.memberLSHadithWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("member_literature_2")) {
            this.keyName = this.id + "member_ls_principle";
            this.tvMemberStudySyllabus.setText("মৌলিক তত্ত্ব");
            this.tvTotalNo.setText("7");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSPrincipleTheory, MemberSyllabus.memberLSPrincipleTheoryWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("member_literature_3")) {
            this.keyName = this.id + "member_ls_movement";
            this.tvMemberStudySyllabus.setText("ইসলামী আন্দোলন");
            this.tvTotalNo.setText("30");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSIslamicMovement, MemberSyllabus.memberLSIslamicMovementWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("member_literature_4")) {
            this.keyName = this.id + "member_ls_organization";
            this.tvMemberStudySyllabus.setText("সংগঠন ও দাওয়াত ");
            this.tvTotalNo.setText("10");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSOrganization, MemberSyllabus.memberLSOrganizationWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("member_literature_5")) {
            this.keyName = this.id + "member_ls_life";
            this.tvMemberStudySyllabus.setText("ইসলামী জীবন ব্যবস্থা");
            this.tvTotalNo.setText("22");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSIslamicLifeStyle, MemberSyllabus.memberLSIslamicLifeStyleWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("member_literature_6")) {
            this.keyName = this.id + "member_ls_fikah";
            this.tvMemberStudySyllabus.setText("ফিকাহ ও প্রাথমিক উসূলে ফিকাহ");
            this.tvTotalNo.setText("6");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSFikah, MemberSyllabus.memberLSFikahWriters, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("member_literature_7")) {
            this.keyName = this.id + "member_ls_other";
            this.tvMemberStudySyllabus.setText("অন্যান্য মতবাদ");
            this.tvTotalNo.setText("5");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
            this.lvMemberStudySyllabus.setAdapter(new AdapterForOnlyBooksInMember(this, MemberSyllabus.memberLSOtherTheory, MemberSyllabus.memberLSOtherTheoryWriters, this.keyName, this.id));
        }
        this.lvMemberStudySyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbBookStatus);
        Editor edit = this.member.edit();
        if (cb.isChecked()) {
            cb.setChecked(false);
            edit.putInt(this.keyName + position, 0);
        } else {
            cb.setChecked(true);
            edit.putInt(this.keyName + position, 1);
        }
        edit.commit();
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletedNumberForMemberLiterature(this, this.keyName, this.id))).toString());
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent i7 = new Intent(this, MemberSyllabusSubCategory.class);
        i7.putExtra("id", this.id);
        i7.putExtra("from", "memeber_overview_7");
        startActivity(i7);
    }
}
