package bd.org.shibir.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import bd.org.shibir.syllabus.R;
import java.util.ArrayList;

public class AdapterForAHM extends BaseAdapter {
    private SharedPreferences associate;
    private Context context;
    private int id;
    private String keyAyatMemorization;
    private String keyHadithMemorization;
    private String keyName;
    private SharedPreferences member;
    private ArrayList<String> viewList;

    public AdapterForAHM(Context context, ArrayList<String> viewList, String keyName, int id) {
        this.context = context;
        this.viewList = viewList;
        this.keyName = keyName;
        this.member = context.getSharedPreferences("member", 0);
        this.associate = context.getSharedPreferences("associate", 0);
        this.id = id;
    }

    public int getCount() {
        return this.viewList.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
      LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            v = new View(this.context);
            v = inflater.inflate(R.layout.li_ayat_hadith, null);
           // v = LayoutInflater.from(context).inflate(R.layout.li_ayat_hadith,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvAloconaSerial)).setText(new StringBuilder(String.valueOf(position + 1)).toString());
        ((TextView) v.findViewById(R.id.tvTopicNameAlocona)).setText((CharSequence) this.viewList.get(position));
        if (this.keyName.equals(this.id + "member_ayat_hadith")) {
            this.keyAyatMemorization = this.id + "member_ayat_memorization";
            this.keyHadithMemorization = this.id + "member_hadith_memorization";
            ((TextView) v.findViewById(R.id.tvAyatHadithNo)).setText(new StringBuilder(String.valueOf(this.member.getString(this.keyAyatMemorization + position, "0"))).append("/").append(this.member.getString(this.keyHadithMemorization + position, "0")).toString());
        }
        if (this.keyName.equals(this.id + "associate_ayat_hadith")) {
            this.keyAyatMemorization = this.id + "associate_ayat_memorization";
            this.keyHadithMemorization = this.id + "associate_hadith_memorization";
            ((TextView) v.findViewById(R.id.tvAyatHadithNo)).setText(new StringBuilder(String.valueOf(this.associate.getString(this.keyAyatMemorization + position, "0"))).append("/").append(this.associate.getString(this.keyHadithMemorization + position, "0")).toString());
        }
        return v;
    }
}
