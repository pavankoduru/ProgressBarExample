package com.example.progressbarex;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.ProgressBar;

public class MyAsync extends AsyncTask {

    private Context context;
    ProgressDialog progressDialog;

    public MyAsync(Context context) {
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        for(int i=0;i<=10;i++)
        {
            try {
                Thread.sleep(2000);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Hi");
        progressDialog.setMessage("eating");
        progressDialog.setMax(10);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        progressDialog.setProgress((Integer) values[0]);
    }
}
