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

public class AdapterForWorkerSyllabus extends BaseAdapter {
    private String[] arrayBooks;
    private String[] arrayWriter;
    private Context context;
    private int id;
    private String keyName;
    private SharedPreferences worker;

    public AdapterForWorkerSyllabus(Context context, String[] arrayBooks, String[] arrayWriter, String keyName, int id) {
        this.context = context;
        this.arrayBooks = arrayBooks;
        this.arrayWriter = arrayWriter;
        this.keyName = keyName;
        this.id = id;
        this.worker = context.getSharedPreferences("worker", 0);
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
            v = new View(this.context);v = inflater.inflate(R.layout.list_item_for_books_with_number, null);
//            v = LayoutInflater.from(context).inflate(R.layout.list_item_for_books_with_number,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvBooksSerial)).setText(setSerialNumber(position));
        ((TextView) v.findViewById(R.id.tvBooksName)).setText(this.arrayBooks[position]);
        ((TextView) v.findViewById(R.id.tvWriterName)).setText(this.arrayWriter[position]);
        CheckBox cb = (CheckBox) v.findViewById(R.id.cbBookStatus);
        int num = this.worker.getInt(this.keyName + position, 0);
        if (num == 0) {
            cb.setChecked(false);
        } else if (num == 1) {
            cb.setChecked(true);
        }
        return v;
    }

    public String setSerialNumber(int position) {
        if (this.keyName.equals(this.id + "worker_quran") || this.keyName.equals(this.id + "worker_hadith") || this.keyName.equals(this.id + "worker_organization") || this.keyName.equals(this.id + "worker_islamic_ideology") || this.keyName.equals(this.id + "worker_miscellaneous")) {
            return new StringBuilder(String.valueOf(position + 1)).toString();
        }
        if (this.keyName.equals(this.id + "worker_masyala")) {
            if (position == 0) {
                return "1";
            }
            if (position == 1) {
                return "or";
            }
        }
        return "";
    }
}
