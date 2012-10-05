package com.povilas.sid.ktu.views;

import com.povilas.sid.ktu.tvarkarastis.R;
import com.povilas.sid.ktu.tvarkarastis.objects.SheduleColumn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LectureListAdapter extends BaseAdapter{

    private Activity activity;
	private SheduleColumn ll = null;
	private static LayoutInflater inflater = null;
	
	public LectureListAdapter(Activity a, SheduleColumn ll) {
		activity = a;
		this.ll = ll;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
	}
	
    public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		
		if (convertView == null) {
		    v = inflater.inflate(R.layout.list_item, null);
		
		    String time = ll.getTime(position);
		    String subject = ll.getSubject(position);
		    String place = ll.getLocation(position);
		    TextView tt = (TextView) v.findViewById(R.id.toptext);
		    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
		    TextView rt = (TextView) v.findViewById(R.id.righttext);
		    tt.setText(subject);                            
		    bt.setText(time);
		    rt.setText(place);
		}
            
        // TODO Change color while touched
        v.setOnTouchListener( new TextView.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
		        switch(event.getAction()) {
			        case MotionEvent.ACTION_DOWN:
			            v.setBackgroundColor(Color.RED); 
			            //Toast.makeText(c, "DOWN", Toast.LENGTH_SHORT).show();
			            break;
			        case MotionEvent.ACTION_UP:
			        	v.setBackgroundColor(Color.WHITE);
			            //Toast.makeText(c, "UP", Toast.LENGTH_SHORT).show();
			            break;
		        }

				return false;
			}
        });
            
        return v;
    }

	public int getCount() {
		return ll.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}
}
