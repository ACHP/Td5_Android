package com.example.td5;
import org.json.*;
import org.apache.http.Header;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b1 =(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				
				
					get();
			
			}
			
		});
		
	}
	
	
	public void post() throws JSONException{
		AsyncHttpClient client = new AsyncHttpClient();
		client.get("statuses/public_timeline.json", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
            }
            
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline){
                // Pull out the first event on the public timeline
                JSONObject firstEvent;
				try {
					firstEvent = (JSONObject) timeline.get(0);
					String tweetText = firstEvent.getString("text");
					System.out.println(tweetText);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                

                // Do something with the response
               
            }
        });

		
	}
	
	public void get(){
		AsyncHttpClient client = new AsyncHttpClient();
	client.get("http://infoweb.iut-nantes.univ-nantes.prive", new TextHttpResponseHandler(){

		@Override
		public void onFailure(int arg0, Header[] arg1, String arg2,
				Throwable arg3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onSuccess(int arg0, Header[] arg1, String arg2) {
			System.out.print(arg2);
			
		}

	   
	});
	}
}
