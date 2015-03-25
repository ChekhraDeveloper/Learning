package com.phani.learning;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
//http://codetheory.in/understanding-and-populating-android-spinners/
public class SpinnerDemo extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Spinner countryView = (Spinner) findViewById(R.id.country);
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.country_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		countryView.setAdapter(adapter);
		
		countryView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
		    @Override
		    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		    	//String country = countryView.getSelectedItem().toString().trim();
		        String country = parent.getItemAtPosition(position).toString();
		        Toast.makeText(SpinnerDemo.this, country, Toast.LENGTH_SHORT).show();
		    }
		 
		    @Override
		    public void onNothingSelected(AdapterView<?> parent) {
		 
		    }
		});
		
		
		
		Spinner countryView2 = (Spinner) findViewById(R.id.country2);
		
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("Australia");
		countries.add("Canada");
		countries.add("China");
		countries.add("India");
		countries.add("Sri Lanka");
		countries.add("United States");
		 
		ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, countries);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 
		countryView2.setAdapter(adapter2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
