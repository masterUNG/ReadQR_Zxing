package com.example.administrator.project_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity  implements ZXingScannerView.ResultHandler{

    private ZXingScannerView zXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void scaner (View view){
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.startCamera();
    }

    @Override
    public void handleResult(Result result) {

        String resultString = result.getText().toString();
        Log.d("11JanV1", "result ==> " + resultString);

        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_LONG).show();
        zXingScannerView.resumeCameraPreview(this);
    }
}

