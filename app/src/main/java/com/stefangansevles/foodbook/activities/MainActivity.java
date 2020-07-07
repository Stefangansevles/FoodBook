package com.stefangansevles.foodbook.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.stefangansevles.foodbook.R;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatBtn;
    MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instance = this;

        //Stop tinting the images on country flags
        NavigationView navigationView = findViewById(R.id.drawer_right);
        navigationView.setItemIconTintList(null);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Config for the floating action button
        setFabClick();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if (requestCode == 111) //GRANT_WRITE_EXTERNAL_STORAGE
        {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent i = new Intent(getApplicationContext(), CreateRecipeActivity.class);
                startActivity(i);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void setFabClick() {
        floatBtn = findViewById(R.id.fabCreate);
        floatBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //  Permission check
                if (!hasPermissions(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE))
                {
                    // Permission ask
                    ActivityCompat.requestPermissions(instance, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 111);
                } else
                {
                    //Permission already granted
                    Intent i = new Intent(getApplicationContext(), CreateRecipeActivity.class);
                    startActivity(i);
                }

            }
        });
    }

    /**
     * Checks wether the user has already given permission
     * @param context
     * @param permissions The permission to be checked
     * @return True if the permission has already been granted. False if not.
     */
    private boolean hasPermissions(Context context, String... permissions)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null)
        {
            for (String permission : permissions)
            {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                    return false;
            }
        }
        return true;
    }
}
