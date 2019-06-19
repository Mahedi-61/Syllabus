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

public class AdapterForOnlyBooksInMember extends BaseAdapter {
    private String[] arrayBooks;
    private String[] arrayWriter;
    private Context context;
    private int id;
    private String keyName;
    private SharedPreferences member;

    public AdapterForOnlyBooksInMember(Context context, String[] arrayBooks, String[] arrayWriter, String keyName, int id) {
        this.context = context;
        this.arrayBooks = arrayBooks;
        this.arrayWriter = arrayWriter;
        this.keyName = keyName;
        this.id = id;
        this.member = context.getSharedPreferences("member", 0);
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
      //      v = LayoutInflater.from(context).inflate(R.layout.list_item_for_books_with_number,parent,false);
        } else {
            v = convertView;
        }
        ((TextView) v.findViewById(R.id.tvBooksSerial)).setText(setSerialNumber(position));
        ((TextView) v.findViewById(R.id.tvBooksName)).setText(this.arrayBooks[position]);
        ((TextView) v.findViewById(R.id.tvWriterName)).setText(this.arrayWriter[position]);
        CheckBox cb = (CheckBox) v.findViewById(R.id.cbBookStatus);
        int num = this.member.getInt(this.keyName + position, 0);
        if (num == 0) {
            cb.setChecked(false);
        } else if (num == 1) {
            cb.setChecked(true);
        }
        return v;
    }

    public String setSerialNumber(int position) {
        if (this.keyName.equals(this.id + "member_ls_quran")) {
            if (position == 0) {
                return "1";
            }
            if (position == 1) {
                return "2";
            }
            if (position == 2) {
                return "or";
            }
            if (position == 3) {
                return "3";
            }
            if (position == 4) {
                return "or";
            }
            if (position == 5) {
                return "4";
            }
            if (position == 6) {
                return "or";
            }
            if (position == 7) {
                return "5";
            }
        }
        if (this.keyName.equals(this.id + "member_ls_hadith") || this.keyName.equals(this.id + "member_ls_principle") || this.keyName.equals(this.id + "member_ls_organization") || this.keyName.equals(this.id + "member_ls_other") || this.keyName.equals(this.id + "member_quran_tafsir") || this.keyName.equals(this.id + "member_hadith_study") || this.keyName.equals(this.id + "member_book_note")) {
            return new StringBuilder(String.valueOf(position + 1)).toString();
        }
        if (this.keyName.equals(this.id + "member_ls_movement")) {
            if (position == 0) {
                return "1";
            }
            if (position == 1) {
                return "2";
            }
            if (position == 2) {
                return "3";
            }
            if (position == 3) {
                return "4";
            }
            if (position == 4) {
                return "or";
            }
            if (position == 5) {
                return "5";
            }
            if (position == 6) {
                return "6";
            }
            if (position == 7) {
                return "7";
            }
            if (position == 8) {
                return "or";
            }
            if (position == 9) {
                return "or";
            }
            if (position == 10) {
                return "or";
            }
            if (position == 11) {
                return "8";
            }
            if (position > 11) {
                return new StringBuilder(String.valueOf(position - 3)).toString();
            }
        }
        if (this.keyName.equals(this.id + "member_ls_life")) {
            if (position == 0) {
                return "1";
            }
            if (position == 1) {
                return "2";
            }
            if (position == 2) {
                return "3";
            }
            if (position == 3) {
                return "4";
            }
            if (position == 4) {
                return "or";
            }
            if (position == 5) {
                return "5";
            }
            if (position == 6) {
                return "6";
            }
            if (position == 7) {
                return "7";
            }
            if (position == 8) {
                return "8";
            }
            if (position == 9) {
                return "or";
            }
            if (position > 9) {
                return new StringBuilder(String.valueOf(position - 1)).toString();
            }
        }
        if (this.keyName.equals(this.id + "member_ls_fikah")) {
            if (position == 0) {
                return "1";
            }
            if (position == 1) {
                return "or";
            }
            if (position == 2) {
                return "2";
            }
            if (position == 3) {
                return "3";
            }
            if (position == 4) {
                return "or";
            }
            if (position == 5) {
                return "4";
            }
            if (position == 6) {
                return "5";
            }
            if (position == 7) {
                return "6";
            }
        }
        return null;
    }
}
