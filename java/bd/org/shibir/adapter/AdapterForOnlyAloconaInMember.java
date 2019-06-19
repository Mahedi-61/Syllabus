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
import java.util.ArrayList;

public class AdapterForOnlyAloconaInMember extends BaseAdapter {
    private ArrayList<String> aloconaList;
    private Context context;
    private String keyName;
    private SharedPreferences member;

    public AdapterForOnlyAloconaInMember(Context context, ArrayList<String> arrayAlocona, String keyName) {
        this.context = context;
        this.aloconaList = arrayAlocona;
        this.keyName = keyName;
        this.member = context.getSharedPreferences("member", 0);
    }

    public int getCount() {
        return this.aloconaList.size();
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
            v = inflater.inflate(R.layout.li_alocona, null);
     //       v = LayoutInflater.from(context).inflate(R.layout.li_alocona,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvAloconaSerial)).setText(new StringBuilder(String.valueOf(position + 1)).toString());
        ((TextView) v.findViewById(R.id.tvTopicNameAlocona)).setText((CharSequence) this.aloconaList.get(position));
        CheckBox cb = (CheckBox) v.findViewById(R.id.cbAlocona);
        int num = this.member.getInt(this.keyName + position, 0);
        if (num == 0) {
            cb.setChecked(false);
        } else if (num == 1) {
            cb.setChecked(true);
        }
        return v;
    }
}
