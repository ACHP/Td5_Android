package com.example.td5;
import org.apache.http.Header;
import org.json.JSONException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
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
						//post2();
				
			}
			
		});
		
	}
	
	

	
	public void get(){
		AsyncHttpClient client = new AsyncHttpClient();
	client.get("http://infoweb-ens.iut-nantes.univ-nantes.prive/~remm-jf/testFormulaire.php", new TextHttpResponseHandler(){

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
	
	
	public void post2(){
		
		 RequestParams params = new RequestParams();
		 params.put("q", "ACHP");
		 
		 
		AsyncHttpClient client = new AsyncHttpClient();
		client.post("http://infoweb.iut-nantes.univ-nantes.prive",params, new TextHttpResponseHandler(){

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
