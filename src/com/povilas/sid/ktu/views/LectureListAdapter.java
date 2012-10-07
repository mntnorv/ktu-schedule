package com.povilas.sid.ktu.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.povilas.sid.ktu.tvarkarastis.R;
import com.povilas.sid.ktu.tvarkarastis.objects.SheduleColumn;

public class LectureListAdapter extends BaseAdapter{

    private Activity activity;
	private SheduleColumn ll = null;
	private static LayoutInflater inflater = null;
	
	public LectureListAdapter(Activity a, SheduleColumn ll) {
		activity = a;
		this.ll = ll;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		    tt.setTextColor(Color.parseColor("#" + ll.getColor(position)));
		}
		
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Animation anim = new DropDownAnimation(v, v.getHeight()*2, true);
				anim.setDuration(500);
				v.startAnimation(anim);
			}
		});
		
		/*v.setOnTouchListener( new TextView.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				switch(event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					Animation anim = new DropDownAnimation(v, v.getHeight()*2, true);
					//anim.setInterpolator(new AccelerateInterpolator());
					anim.setDuration(500);
					v.startAnimation(anim);
					break;
				}

				return false;
			}
		});*/
            
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
