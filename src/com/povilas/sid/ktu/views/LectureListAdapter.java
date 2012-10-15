package com.povilas.sid.ktu.views;

import com.povilas.sid.ktu.tvarkarastis.R;
import com.povilas.sid.ktu.tvarkarastis.objects.SheduleColumn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
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
		    String color = ll.getColor(position);
		    TextView tt = (TextView) v.findViewById(R.id.toptext);
		    TextView bt = (TextView) v.findViewById(R.id.bottomtext);
		    TextView rt = (TextView) v.findViewById(R.id.righttext);
		    tt.setText(subject);                            
		    bt.setText(time);
		    rt.setText(place);
		    
		    StateListDrawable states = new StateListDrawable();
		    int backgroundColor = Color.parseColor("#"+color);
		    states.addState(new int[] { -android.R.attr.state_focused,
		    		android.R.attr.state_pressed,
		    		-android.R.attr.state_selected,
		    		-android.R.attr.state_drag_hovered}, new ColorDrawable(backgroundColor)); 
		    v.setBackground(states);
		}
		

        // TODO Change color while touched           
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
