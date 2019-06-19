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
import bd.org.shibir.adapter.AdapterForQuranSuraSyllabus;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.MemberSyllabus;

public class MemberQuranSuraSyllabus extends Activity implements OnItemClickListener {
    private int id;
    private String keyName;
    private ListView lvMemberQuranSuraSyllabus;
    private SharedPreferences member;
    private TextView tvMemberQuanSuraSyllabus;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_overview);
        this.id = getIntent().getIntExtra("id", 0);
        this.keyName = this.id + "member_quran_sura";
        this.member = getSharedPreferences("member", 0);
        this.tvMemberQuanSuraSyllabus = (TextView) findViewById(R.id.tvSyllabusOverview);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.tvMemberQuanSuraSyllabus.setText("কুরআন তেলাওয়াত(অর্থসহ)");
        this.tvTotalNo.setText("114");
        this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
        this.lvMemberQuranSuraSyllabus = (ListView) findViewById(R.id.lvSyllabusOverview);
        this.lvMemberQuranSuraSyllabus.setAdapter(new AdapterForQuranSuraSyllabus(this, MemberSyllabus.memberQuranSuraList, this.keyName, this.id));
        this.lvMemberQuranSuraSyllabus.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long ld) {
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbSuraSyllabus);
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

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent i7 = new Intent(this, MemberSyllabusSubCategory.class);
        i7.putExtra("id", this.id);
        i7.putExtra("from", "memeber_overview_5");
        startActivity(i7);
    }
}
