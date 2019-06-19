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
import bd.org.shibir.adapter.AdapterForBookNote;
import bd.org.shibir.model.AllCompletedNoData;
import bd.org.shibir.model.AssociateSyllabus;
import bd.org.shibir.model.MemberSyllabus;
import java.util.ArrayList;

public class SyllabusForBookNote extends Activity implements OnClickListener, OnItemClickListener {
    private SharedPreferences associate;
    private Button bAddNewAlocona;
    private ArrayList<String> bookList;
    private Editor edit;
    private int id;
    private String keyName;
    private String keyNewForBook;
    private String keyNewForWriter;
    private ListView lvSyllabusList;
    private SharedPreferences member;
    private int totalNewAddition;
    private String totalNewAdditionKey;
    private TextView tvSyllabusName;
    private TextView tvTotalCompleted;
    private TextView tvTotalNo;
    private ArrayList<String> writerList;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        int i;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.syllabus_pattern_alocona);
        this.id = getIntent().getIntExtra("id", 0);
        this.member = getSharedPreferences("member", 0);
        this.associate = getSharedPreferences("associate", 0);
        this.tvSyllabusName = (TextView) findViewById(R.id.tvSyllabusAlocona);
        this.tvTotalNo = (TextView) findViewById(R.id.tvTotalNoSO);
        this.tvTotalCompleted = (TextView) findViewById(R.id.tvTotalCompletedSO);
        this.lvSyllabusList = (ListView) findViewById(R.id.lvSyllabusAlocona);
        this.bAddNewAlocona = (Button) findViewById(R.id.bAddNewSyllabusAlocona);
        if (getIntent().getStringExtra("from").equals("associate_overview_4")) {
            this.keyName = this.id + "associate_book_note";
            this.keyNewForBook = this.id + "new_associate_book_note";
            this.keyNewForWriter = this.id + "new_associate_writer";
            this.totalNewAdditionKey = this.id + "new_associate_book_note_no";
            this.bookList = new ArrayList();
            this.writerList = new ArrayList();
            for (String s : AssociateSyllabus.associateBookNoteList) {
                this.bookList.add(s);
            }
            for (String s2 : AssociateSyllabus.associateBookNoteWriterList) {
                this.writerList.add(s2);
            }
            this.totalNewAddition = this.associate.getInt(this.totalNewAdditionKey, 0);
            for (i = 1; i <= this.totalNewAddition; i++) {
                this.bookList.add(this.associate.getString(this.keyNewForBook + i, ""));
                this.writerList.add(this.associate.getString(this.keyNewForWriter + i, ""));
            }
            this.tvSyllabusName.setText("বই নোট");
            this.tvTotalNo.setText("4");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForBookNote(this, this.bookList, this.writerList, this.keyName, this.id));
        }
        if (getIntent().getStringExtra("from").equals("memeber_overview_4")) {
            this.keyName = this.id + "member_book_note";
            this.keyNewForBook = this.id + "new_member_book_note";
            this.keyNewForWriter = this.id + "new_member_writer";
            this.totalNewAdditionKey = this.id + "new_member_book_note_no";
            this.bookList = new ArrayList();
            this.writerList = new ArrayList();
            for (String s22 : MemberSyllabus.memberBookNoteList) {
                this.bookList.add(s22);
            }
            for (String s222 : MemberSyllabus.memberBookNoteWriterList) {
                this.writerList.add(s222);
            }
            this.totalNewAddition = this.member.getInt(this.totalNewAdditionKey, 0);
            for (i = 1; i <= this.totalNewAddition; i++) {
                this.bookList.add(this.member.getString(this.keyNewForBook + i, ""));
                this.writerList.add(this.member.getString(this.keyNewForWriter + i, ""));
            }
            this.tvSyllabusName.setText("বই নোট");
            this.tvTotalNo.setText("12");
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
            this.lvSyllabusList.setAdapter(new AdapterForBookNote(this, this.bookList, this.writerList, this.keyName, this.id));
        }
        this.bAddNewAlocona.setOnClickListener(this);
        this.lvSyllabusList.setOnItemClickListener(this);
    }

    public void onClick(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setTitle("Enter new Book");
        dialog.setContentView(R.layout.dl_new_book_note);
        final EditText etBookName = (EditText) dialog.findViewById(R.id.dl_etBookName_BookNote);
        final EditText etWriterName = (EditText) dialog.findViewById(R.id.dl_etWriterName_BookNote);
        Button bCancel = (Button) dialog.findViewById(R.id.bCancelBookNote);
        ((Button) dialog.findViewById(R.id.bSaveBookNote)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (etBookName.getText().toString().trim().equals("")) {
                    Toast.makeText(SyllabusForBookNote.this.getApplicationContext(), "Please enter a book name !", Toast.LENGTH_SHORT).show();
                    return;
                }
                SyllabusForBookNote syllabusForBookNote;
                dialog.dismiss();
                if (SyllabusForBookNote.this.getIntent().getStringExtra("from").equals("memeber_overview_4")) {
                    SyllabusForBookNote.this.bookList.add(etBookName.getText().toString());
                    SyllabusForBookNote.this.writerList.add(etWriterName.getText().toString());
                    syllabusForBookNote = SyllabusForBookNote.this;
                    syllabusForBookNote.totalNewAddition = syllabusForBookNote.totalNewAddition + 1;
                    SyllabusForBookNote.this.edit = SyllabusForBookNote.this.member.edit();
                    SyllabusForBookNote.this.edit.putString(new StringBuilder(String.valueOf(SyllabusForBookNote.this.keyNewForBook)).append(SyllabusForBookNote.this.totalNewAddition).toString(), etBookName.getText().toString());
                    SyllabusForBookNote.this.edit.putString(new StringBuilder(String.valueOf(SyllabusForBookNote.this.keyNewForWriter)).append(SyllabusForBookNote.this.totalNewAddition).toString(), etWriterName.getText().toString());
                    SyllabusForBookNote.this.edit.putInt(SyllabusForBookNote.this.totalNewAdditionKey, SyllabusForBookNote.this.totalNewAddition);
                    SyllabusForBookNote.this.edit.commit();
                    SyllabusForBookNote.this.lvSyllabusList = (ListView) SyllabusForBookNote.this.findViewById(R.id.lvSyllabusAlocona);
                    SyllabusForBookNote.this.lvSyllabusList.setAdapter(new AdapterForBookNote(SyllabusForBookNote.this, SyllabusForBookNote.this.bookList, SyllabusForBookNote.this.writerList, SyllabusForBookNote.this.keyName, SyllabusForBookNote.this.id));
                }
                if (SyllabusForBookNote.this.getIntent().getStringExtra("from").equals("associate_overview_4")) {
                    SyllabusForBookNote.this.bookList.add(etBookName.getText().toString());
                    SyllabusForBookNote.this.writerList.add(etWriterName.getText().toString());
                    syllabusForBookNote = SyllabusForBookNote.this;
                    syllabusForBookNote.totalNewAddition = syllabusForBookNote.totalNewAddition + 1;
                    SyllabusForBookNote.this.edit = SyllabusForBookNote.this.associate.edit();
                    SyllabusForBookNote.this.edit.putString(new StringBuilder(String.valueOf(SyllabusForBookNote.this.keyNewForBook)).append(SyllabusForBookNote.this.totalNewAddition).toString(), etBookName.getText().toString());
                    SyllabusForBookNote.this.edit.putString(new StringBuilder(String.valueOf(SyllabusForBookNote.this.keyNewForWriter)).append(SyllabusForBookNote.this.totalNewAddition).toString(), etWriterName.getText().toString());
                    SyllabusForBookNote.this.edit.putInt(SyllabusForBookNote.this.totalNewAdditionKey, SyllabusForBookNote.this.totalNewAddition);
                    SyllabusForBookNote.this.edit.commit();
                    SyllabusForBookNote.this.lvSyllabusList = (ListView) SyllabusForBookNote.this.findViewById(R.id.lvSyllabusAlocona);
                    SyllabusForBookNote.this.lvSyllabusList.setAdapter(new AdapterForBookNote(SyllabusForBookNote.this, SyllabusForBookNote.this.bookList, SyllabusForBookNote.this.writerList, SyllabusForBookNote.this.keyName, SyllabusForBookNote.this.id));
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
        CheckBox cb = (CheckBox) view.findViewById(R.id.cbBookStatus);
        if (getIntent().getStringExtra("from").equals("memeber_overview_4")) {
            this.edit = this.member.edit();
            if (cb.isChecked()) {
                cb.setChecked(false);
                this.edit.putInt(this.keyName + position, 0);
            } else {
                cb.setChecked(true);
                this.edit.putInt(this.keyName + position, 1);
            }
            this.edit.commit();
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForMember(this, this.keyName, this.id))).toString());
        }
        if (getIntent().getStringExtra("from").equals("associate_overview_4")) {
            this.edit = this.associate.edit();
            if (cb.isChecked()) {
                cb.setChecked(false);
                this.edit.putInt(this.keyName + position, 0);
            } else {
                cb.setChecked(true);
                this.edit.putInt(this.keyName + position, 1);
            }
            this.edit.commit();
            this.tvTotalCompleted.setText(new StringBuilder(String.valueOf(AllCompletedNoData.getCompletdNumberForAssociate(this, this.keyName, this.id))).toString());
        }
    }
}
