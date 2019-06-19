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

public class AdapterForHigherSyllabus extends BaseAdapter {
    private String[] arrayBooks;
    private String[] arrayWriter;
    private Context context;
    private SharedPreferences higher;
    private String keyName;

    public AdapterForHigherSyllabus(Context context, String[] arrayBooks, String[] arrayWriter, String keyName) {
        this.context = context;
        this.arrayBooks = arrayBooks;
        this.arrayWriter = arrayWriter;
        this.keyName = keyName;
        this.higher = context.getSharedPreferences("higher", 0);
    }

    public int getCount() {
        return this.arrayBooks.length;
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
            v = inflater.inflate(R.layout.list_item_for_books_with_number, null);
            // v = LayoutInflater.from(context).inflate(R.layout.list_item_for_books_with_number,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvBooksSerial)).setText(new StringBuilder(String.valueOf(position + 1)).toString());
        ((TextView) v.findViewById(R.id.tvBooksName)).setText(this.arrayBooks[position]);
        ((TextView) v.findViewById(R.id.tvWriterName)).setText(this.arrayWriter[position]);
        CheckBox cb = (CheckBox) v.findViewById(R.id.cbBookStatus);
        int num = this.higher.getInt(this.keyName + position, 0);
        if (num == 0) {
            cb.setChecked(false);
        } else if (num == 1) {
            cb.setChecked(true);
        }
        return v;
    }
}
