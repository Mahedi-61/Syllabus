package bd.org.shibir.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import bd.org.shibir.syllabus.R;

public class AdapterForQuranSuraSyllabus extends BaseAdapter {
    private SharedPreferences associate;
    private Context context;
    private int id;
    private String keyName;
    private SharedPreferences member;
    private String[] viewList;

    public AdapterForQuranSuraSyllabus(Context context, String[] viewList, String keyName, int id) {
        this.context = context;
        this.viewList = viewList;
        this.associate = context.getSharedPreferences("associate", 0);
        this.member = context.getSharedPreferences("member", 0);
        this.keyName = keyName;
        this.id = id;
    }

    public int getCount() {
        return this.viewList.length;
    }

    public Object getItem(int arg0) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        int num;
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            v = new View(this.context);
          v = inflater.inflate(R.layout.list_item_sura_syllabus, null);
  //        v = LayoutInflater.from(context).inflate(R.layout.list_item_sura_syllabus,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvSuraSerial)).setText(new StringBuilder(String.valueOf(position + 1)).toString());
        ((TextView) v.findViewById(R.id.tvSuraName)).setText(this.viewList[position]);
        CheckBox cb = (CheckBox) v.findViewById(R.id.cbSuraSyllabus);
        if (this.keyName.equals(this.id + "member_quran_sura")) {
            num = this.member.getInt(this.keyName + position, 0);
            if (num == 0) {
                cb.setChecked(false);
            } else if (num == 1) {
                cb.setChecked(true);
            }
        }
        if (this.keyName.equals(this.id + "associate_quran_sura")) {
            num = this.associate.getInt(this.keyName + position, 0);
            if (num == 0) {
                cb.setChecked(false);
            } else if (num == 1) {
                cb.setChecked(true);
            }
        }
        return v;
    }
}
