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

public class AdapterForBookNote extends BaseAdapter {
    private ArrayList<String> arrayBooks;
    private ArrayList<String> arrayWriter;
    private SharedPreferences associate;
    private Context context;
    private int id;
    private String keyName;
    private SharedPreferences member;

    public AdapterForBookNote(Context context, ArrayList<String> arrayBooks, ArrayList<String> arrayWriter, String keyName, int id) {
        this.context = context;
        this.arrayBooks = arrayBooks;
        this.arrayWriter = arrayWriter;
        this.keyName = keyName;
        this.id = id;
        this.member = context.getSharedPreferences("member", 0);
        this.associate = context.getSharedPreferences("associate", 0);
    }

    public int getCount() {
        return this.arrayBooks.size();
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
            v = inflater.inflate(R.layout.list_item_for_books_with_number, null);
            //v = LayoutInflater.from(context).inflate(R.layout.list_item_for_books_with_number,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvBooksSerial)).setText(new StringBuilder(String.valueOf(position + 1)).toString());
        ((TextView) v.findViewById(R.id.tvBooksName)).setText((CharSequence) this.arrayBooks.get(position));
        ((TextView) v.findViewById(R.id.tvWriterName)).setText((CharSequence) this.arrayWriter.get(position));
        CheckBox cb = (CheckBox) v.findViewById(R.id.cbBookStatus);
        if (this.keyName.equals(this.id + "member_book_note")) {
            num = this.member.getInt(this.keyName + position, 0);
            if (num == 0) {
                cb.setChecked(false);
            } else if (num == 1) {
                cb.setChecked(true);
            }
        }
        if (this.keyName.equals(this.id + "associate_book_note")) {
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
