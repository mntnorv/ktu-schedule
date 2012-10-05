package com.povilas.sid.ktu.tvarkarastis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.povilas.sid.ktu.tvarkarastis.data.*;
import com.povilas.sid.ktu.tvarkarastis.objects.Shedule;
import com.povilas.sid.ktu.tvarkarastis.objects.SheduleColumn;
import com.povilas.sid.ktu.views.LectureListAdapter;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * sections. We use a {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will
     * keep every loaded fragment in memory. If this becomes too memory intensive, it may be best
     * to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    
    static Shedule shedule = new Shedule();
    static int pageCount;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        
		try {
			AssetManager assetManager = this.getAssets();
		    InputStream is = assetManager.open("schedule.xml");
			try {
				shedule = XmlParser.parseShedule(is);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
		pageCount = shedule.size();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DummySectionFragment();
            Bundle args = new Bundle();
            args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return pageCount;
        }
        
        public void setCount(int pageCount){
        	MainActivity.pageCount = pageCount;        	
        }

        @Override
        public CharSequence getPageTitle(int position) {
        	Resources res = getResources();
        	String[] titles = res.getStringArray(R.array.titles);
            if(position < titles.length){
                return titles[position].toUpperCase();
            }
            return null;
        }
    }
    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    public static class DummySectionFragment extends Fragment {
    	XmlElement ele = null;
    	ArrayList<String> keys = new ArrayList<String>();
    	ArrayList<String> value = new ArrayList<String>();
    	String hash;
    	
        public DummySectionFragment() {
        }
        
        public static final String ARG_SECTION_NUMBER = "section_number";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
//        	ArrayList<Day> week = new ArrayList<Day>();

//    		try {
//    			
//    			/** Handling XML */
//    			SAXParserFactory spf = SAXParserFactory.newInstance();
//    			SAXParser sp = spf.newSAXParser();
//    			XMLReader xr = sp.getXMLReader();
//
//    			/** Send URL to parse XML Tags */
//    			URL sourceUrl = new URL(
//    					"http://www.daukantas.kaunas.lm.lt/min/schedule.xml");
//
//    			/** Create handler to handle XML Tags ( extends DefaultHandler ) */
//    			XMLHandler XMLHandler = new XMLHandler();
//    			xr.setContentHandler(XMLHandler);
//    			xr.parse(new InputSource(sourceUrl.openStream()));
//    			
//    		} catch (Exception e) {
//    			System.out.println("XML Pasing Excpetion = " + e);
//    		}
//
//    		/** Get result from MyXMLHandler SitlesList Object */
//    		week = XMLHandler.week;
        	
//			try {
//				//String Url = "http://www.spymek.com/php/display.xml";
//				AssetManager assetManager = getActivity().getAssets();
//			    InputStream is = assetManager.open("display.xml");
//			    XmlElement ele = null;
//				try {
//					//ele = XmlParser.parse(Url.toString().trim().replaceAll(" ", "%20"));
//					ele = XmlParser.parse(is);
//					for (int i = 0; i < ele.getElements().size(); i++) {
//						keys.add(ele.getElements().get(i).getKey().toString());
//						value.add(ele.getElements().get(i).getValue().toString());
//
//			            	   Log.v(ele.getElements().get(i).getKey().toString(),ele.getElements().get(i).getValue().toString());
//						//insertData(temp);
//						//Utils.xmlData.add(temp);
//					}
//				} catch (IllegalStateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ParserConfigurationException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SAXException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
        	
//        	String date = null;
//			try {
//				String Url = "http://www.daukantas.kaunas.lm.lt/min/schedule.xml";
//				URL validUrl = new URL(Url.toString().trim().replaceAll(" ", "%20"));
//				URLConnection connection = validUrl.openConnection();
//				HttpURLConnection httpConn = (HttpURLConnection)connection;
//				httpConn.setDoInput(true);
//				httpConn.setRequestProperty("charset", "utf-8");
//				int responseCode = httpConn.getResponseCode();
//				AssetManager assetManager = getActivity().getAssets();
//			    //InputStream is = assetManager.open("schedule.xml");
//				try {
//					date = XmlParser.parseDate(httpConn.getInputStream());
//					//date = XmlParser.parseDate(is);
//
//				} catch (IllegalStateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ParserConfigurationException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SAXException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            ListView listView = new ListView(getActivity());
            Bundle args = getArguments();
            
//            try {
//                // Create a URL for the desired page
//                URL url = new URL("http://www.daukantas.kaunas.lm.lt/min/schedule.hash");
//
//                // Read all the text returned by the server
//                InputStream is =  url.openConnection().getInputStream();
//                InputStreamReader isr = new InputStreamReader(is);
//                BufferedReader in = new BufferedReader(isr);
//                str = in.readLine();
//                in.close();
//            } catch (MalformedURLException e) {
//            	e.printStackTrace();
//            } catch (IOException e) {
//            	e.printStackTrace();
//            }

       
//			AssetManager assetManager = getActivity().getAssets();
//		    InputStream is = null;
//			try {
//				is = assetManager.open("schedule.xml");
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//		    try {
//				hash = sha1(is);
//			} catch (NoSuchAlgorithmException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    try {
//				is.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
           
            getHash hashThread =  new getHash();
            hashThread.execute(new String[] {"http://www.daukantas.kaunas.lm.lt/min/schedule.hash"});
            
            LectureListAdapter lla = new LectureListAdapter(getActivity(), 
                    shedule.getShe(args.getInt(ARG_SECTION_NUMBER)-1));

            listView.setAdapter(lla);

            return listView;
        }
        
        public static String sha1(InputStream fis) throws IOException, NoSuchAlgorithmException{
        	MessageDigest md = MessageDigest.getInstance("SHA");
            byte[] dataBytes = new byte[1024];
            
            int nread = 0; 
         
            while ((nread = fis.read(dataBytes)) != -1) {
              md.update(dataBytes, 0, nread);
            };
         
            byte[] mdbytes = md.digest();
         
            //convert the byte to hex format
            StringBuffer sb = new StringBuffer("");
            for (int i = 0; i < mdbytes.length; i++) {
            	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        
        private class getHash extends AsyncTask<String, Void, String>{
        	@Override
        	protected String doInBackground(String... params) {
        		String str = null;
                try {
                    // Create a URL for the desired page
                    URL url = new URL(params[0]);

                    // Read all the text returned by the server
                    InputStream is =  url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader in = new BufferedReader(isr);
                    str = in.readLine();
                    is.close();
                    isr.close();
                    in.close();
                } catch (MalformedURLException e) {
                	e.printStackTrace();
                } catch (IOException e) {
                	e.printStackTrace();
                }
                hash = str;
        		return str;
        	}
        	
            @Override
            protected void onPostExecute(String result) {
            	hash = result;
            }
        }
    }
}
