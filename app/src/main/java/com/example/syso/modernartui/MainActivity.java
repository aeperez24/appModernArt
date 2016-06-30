package com.example.syso.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;


public class MainActivity extends Activity {
    static final int cl1 = 0x444156;
    static final int cl2 = 0xddd156;
    static final int cl3 = 0x7581F5;
    static final int cl4 = 0x2DB999;
    static final int cl5 = 0xF78508;


    static final String url="http://www.moma.org/";
    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    private int progres;
    private RelativeLayout rl1, rl2, rl3, rl4, rl5;
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_main);
        //LayoutInflater inflater =   (LayoutInflater)this.getLayoutInflater();;

        //inflater.inflate(R.layout.ui_main, null);
        rl1 = (RelativeLayout) findViewById(R.id.layout1);
        rl2 = (RelativeLayout) findViewById(R.id.layout2);
        rl3 = (RelativeLayout) findViewById(R.id.layout3);
        rl4 = (RelativeLayout) findViewById(R.id.layout4);
        rl5 = (RelativeLayout) findViewById(R.id.layout5);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progres = i;
                changeColor(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
        Log.i("menu","afuera del if");
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.i("menu","entre aqui");
            createSimpleDialog().show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeColor(int position) {
        Log.i("position", "" + position);
        rl1.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(cl1 + position * 25)));
        rl2.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(cl2 + position * 25)));

        rl3.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(cl3 - position * 25)));

        rl4.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(cl4 - position * 50)));
        rl5.setBackgroundColor(Color.parseColor("#"+Integer.toHexString(cl5 - position * 50)));


    }

    public AlertDialog createSimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Inspired by the work of artists such as Piet Mondrian and Ben Nicholson")
                .setMessage("click below for mor information")
                .setPositiveButton("View MOMA",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("dialog", "ok");
                                Intent intend = new Intent();
                                intend.setAction(Intent.ACTION_VIEW);
                                intend.setData(Uri.parse(url));
                                startActivity(intend);

                            }
                        })
                .setNegativeButton("Not Now",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("dialog", "cancelar");
                                dialog.cancel();
                            }
                        });

        return builder.create();
    }


}