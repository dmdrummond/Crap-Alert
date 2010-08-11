package uk.co.dmdrummond.crapalert;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.view.MenuInflater;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;


public class CrapAlert extends Activity {
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ImageButton button = (ImageButton)findViewById(R.id.crapalertbutton);
        
        
        button.setOnClickListener(new OnClickListener(){
        	
        	public void onClick(View view) {
        		MediaPlayer mp = MediaPlayer.create(CrapAlert.this, R.raw.crapalert);
        		mp.start();
        		while (mp.isPlaying()) {
        		
        		}
        		mp.release();
        	}
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.launchlo:
            //Launch www.linuxoutlaws.com
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getText(R.string.LOUrl).toString()));
            startActivity(intent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
