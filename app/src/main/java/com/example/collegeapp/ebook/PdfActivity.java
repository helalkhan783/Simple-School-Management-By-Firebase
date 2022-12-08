package com.example.collegeapp.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfActivity extends AppCompatActivity {

    private  String url;
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        pdfView = findViewById(R.id.pdfView);
        url = getIntent().getStringExtra("pdfUrl");//adpter clas theke url ta intent kore niye aseci
         new pdfDownload(PdfActivity.this).execute(url);//url ta ke parameter through te send kore diyechi


    }


    public class pdfDownload extends AsyncTask<String,Void, InputStream> {

        private Context context;
        public pdfDownload(Context context ) {
            this.context = context;

        }

        @Override
        protected InputStream doInBackground(String... strings) {

            InputStream inputStream = null;
            try {

                URL url = new URL(strings[0]);//ekhane string er modde adapter class er url ta ache jeta amra mara intent kore pdf activity hoya akhane peyechi
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();


                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }


            } catch (IOException e) {
                Toast.makeText(PdfActivity.this,"inputSteam: " +e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {

            try {
                pdfView.fromStream(inputStream).load(); // stream is written to bytearray -
            } catch (Exception e) {
                Toast.makeText(PdfActivity.this,"  " +e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
}}