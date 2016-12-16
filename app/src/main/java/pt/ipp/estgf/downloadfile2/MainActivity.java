package pt.ipp.estgf.downloadfile2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button startDowloadBtn;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar) findViewById(R.id.ProgressBar);
        startDowloadBtn = (Button) findViewById(R.id.DownloadButton);

        startDowloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyTask().execute();
            }
        });
    }

    class MyTask extends AsyncTask<String,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Toast.makeText(getApplicationContext(),"Inicializando o Download...",Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... params) {

            //String url = params[0];

            for(int i=0;i<100;i++){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                publishProgress(i);
            }


            return "Download Acabado!!!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            pb.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
        }
    }
}
