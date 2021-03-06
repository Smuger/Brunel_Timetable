package brunel.kwietniewski.december_project_2.Activity;


import android.app.Activity;
import android.app.ActionBar;
import android.app.FragmentTransaction;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import brunel.kwietniewski.december_project_2.R;

public class DayTimetableActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_timetable);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // JSON READER

        String json = null;
        try {
            InputStream inputStream = getAssets().open("days.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json);

        // Variables JSON
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        JSONObject jsonObjectDay = null;

        try {

            // Assign a main object to jsonObject var
            jsonObject = new JSONObject(json);

            jsonArray = jsonObject.names();

            Toast.makeText(this, jsonArray.toString(), Toast.LENGTH_SHORT).show();

            /**
             * for (int i=0; jsonArray.length()<i;i++){

             }
             */


        }
        catch (JSONException e){
            e.printStackTrace();
            Toast.makeText(this, "I couldn't read timetable correctly", Toast.LENGTH_SHORT).show();

        }

        /**
         // CHANGE JSON STRING TO JSON OBJECT
         JSONObject jsonObject = null;
         JSONArray Monday = null;
         JSONArray Tuesday = null;
         JSONArray Wednesday = null;
         JSONArray Thursday = null;
         JSONArray Friday = null;
         try {
         jsonObject = new JSONObject(json);
         Monday = jsonObject.getJSONArray("Monday");
         Tuesday = jsonObject.getJSONArray("Tuesday");
         Wednesday = jsonObject.getJSONArray("Wednesday");
         Thursday = jsonObject.getJSONArray("Thursday");
         Friday = jsonObject.getJSONArray("Friday");
         }
         catch (JSONException e){
         e.printStackTrace();
         Toast.makeText(this, "No timetable found", Toast.LENGTH_SHORT).show();

         }

         JSONObject CS2004_Lecture = null;
         JSONObject CS2002_Lecture = null;
         JSONObject CS2002_Lab = null;
         JSONObject CS2004_Lab = null;
         JSONObject CS2554_Lecture = null;
         JSONObject CS2005_Lecture = null;
         JSONObject CS2005_Lab = null;
         JSONObject CS2001_Lab = null;
         // READ DATA FROM LOCAL JSON OBJECT

         try{
         for (int j=0; j < Monday.length(); j++) {
         JSONObject currentJson = jsonObject;
         CS2004_Lecture = currentJson.getJSONObject("CS2004_Lecture");
         CS2002_Lecture = currentJson.getJSONObject("CS2002_Lecture");
         CS2002_Lab = currentJson.getJSONObject("CS2002_Lab");
         CS2004_Lab = currentJson.getJSONObject("CS2004_Lab");
         CS2554_Lecture = currentJson.getJSONObject("CS2554_Lecture");
         CS2005_Lecture = currentJson.getJSONObject("CS2005_Lecture");
         CS2005_Lab = currentJson.getJSONObject("CS2005_Lab");
         CS2001_Lab = currentJson.getJSONObject("CS2001_Lab");

         }
         }
         catch (JSONException e) {
         e.printStackTrace();
         }
         catch (NullPointerException ex){
         Toast.makeText(this, "Null pointer exception", Toast.LENGTH_SHORT).show();
         }
         }
         String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
         String[] classes = {"CS2002_Lecture", "CS2004_Lecture", "CS2005_Lecture", "CS2554_Lecture",
         "CS2001_Lab", "CS2002_Lab", "CS2004_Lab", "CS2005_Lab"};

         public JSONArray whatClassesToday(JSONObject day) throws JSONException {
         JSONArray thisClassesWillBeHappeningToday = null;
         for (int i=0; day.length() > i; i++){
         if (day.getJSONObject(classes[i]) == null){
         System.out.println("Class " + day + " will not be conducted today.");
         }
         else {
         thisClassesWillBeHappeningToday.put(day);
         }
         }

         return thisClassesWillBeHappeningToday;
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day_timetable, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_day_timetable, container, false);
            TextView dayOfTheWeekTextView = (TextView) rootView.findViewById(R.id.dayOfTheWeek);
            String theDay = "";
            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1:
                    theDay = "Monday";
                    break;
                case 2:
                    theDay = "Tuesday";
                    break;
                case 3:
                    theDay = "Wednesday";
                    break;
                case 4:
                    theDay = "Thursday";
                    break;
                case 5:
                    theDay = "Friday";
                    break;
                case 6:
                    theDay = "Saturday";
                    break;
                case 7:
                    theDay = "Sunday";
                    break;

            }
            System.out.println(theDay + " " + getArguments().getInt(ARG_SECTION_NUMBER));
            dayOfTheWeekTextView.setText(theDay);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
