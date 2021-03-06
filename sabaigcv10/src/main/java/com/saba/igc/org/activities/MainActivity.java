package com.saba.igc.org.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.saba.igc.org.R;
import com.saba.igc.org.adapters.ProgramsArrayAdapter;
import com.saba.igc.org.application.SabaApplication;
import com.saba.igc.org.application.SabaClient;
import com.saba.igc.org.listeners.SabaServerResponseListener;
import com.saba.igc.org.models.SabaProgram;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Aftab Naqvi
 * @create December, 2014
 * @version 1.0
 */
public class MainActivity extends Activity implements SabaServerResponseListener{

	private SabaClient mSabaClient;
	private ProgramsArrayAdapter mAdapter;
	private ArrayList<SabaProgram> mPrograms;
	private ListView mLvUpcomingPrograms;
	private ProgressBar mProgramsProgressBar;
	private SwipeRefreshLayout mSwipeRefreshLayout = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSabaClient = SabaApplication.getSabaClient();
		mSabaClient.getUpcomingPrograms(this);
		
		mProgramsProgressBar = (ProgressBar) findViewById(R.id.programsProgressBar);
        mLvUpcomingPrograms = (ListView) findViewById(R.id.lvUpcomingPrograms);
        
		mPrograms = new ArrayList<SabaProgram>();
		mAdapter = new ProgramsArrayAdapter(this, mPrograms);
		mLvUpcomingPrograms.setAdapter(mAdapter);
		
		//OnItemClickListener
		mLvUpcomingPrograms.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
			}
		});

		//Initialize swipe to refresh view
		mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
		mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
			@Override
			public void onRefresh() {
				//Refreshing data on server
			}
		});
	}

	@Override
	public void processJsonObject(String programName, JSONObject response) {
		mProgramsProgressBar.setVisibility(View.GONE);
		if(response == null){
			// display error.
			return;
		}

		try{
			JSONArray upcomingProgramsJson = response.getJSONArray("entry");
			ArrayList<SabaProgram> programs = SabaProgram.fromJSONArray(programName, upcomingProgramsJson);
			addAll(programs);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Delegate the adding to the internal adapter. // most recommended approach... minimize the code... 
		// 
	public void addAll(ArrayList<SabaProgram> programs){
		mAdapter.addAll(programs);
	}

	//@Override
	public void processPrograms(String programName, List<SabaProgram> programs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processJsonObject(String programName, JSONArray response) {
		// TODO Auto-generated method stub
		
	}
}