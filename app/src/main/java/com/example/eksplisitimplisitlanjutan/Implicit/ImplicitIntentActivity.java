git copackage com.example.eksplisitimplisitlanjutan.Implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eksplisitimplisitlanjutan.R;

public class ImplicitIntentActivity extends AppCompatActivity {

    Button maps,wa,telegram,ig,fb,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        findViewById(R.id.btnCamera).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivity(i);
        });

        EditText et = findViewById(R.id.etNo);
        findViewById(R.id.btnGallery).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://media/external/images/media/"));
            startActivity(i);
        });

        findViewById(R.id.btnBrowser).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("http://www.google.com/"));
            startActivity(i);
        });

        findViewById(R.id.btnContact).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_VIEW);
            i.setData(Uri.parse("content://contacts/people/"));
            startActivity(i);
        });

        findViewById(R.id.btnDial).setOnClickListener(v -> {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:" +et.getText()));
            startActivity(i);

            Intent intent = new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:" +et.getText()));
            startActivity(i);

            startActivity(new Intent(Intent.ACTION_DIAL, Uri
                    .parse("tel:" +et.getText())));
        });

        maps = findViewById(R.id.btnMaps);
        wa = findViewById(R.id.btnWA);
        telegram = findViewById(R.id.btnTelegram);
        ig = findViewById(R.id.btnIG);
        fb = findViewById(R.id.btnFB);
        email = findViewById(R.id.btnEmail);

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.google.com/maps/place/TeamUp+Studio/@-7.7413202,110.4120538,17z/data=!3m1!4b1!4m5!3m4!1s0x2e7a592153d31b31:0x451121519763b557!8m2!3d-7.7413174!4d110.4142282");
            }
        });
        wa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotoUrl("https://api.whatsapp.com/send/?phone=%2B6287839953366&text&app_absent=0");
            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://telegram.me/jitc_yk");
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/aqsaldpa/");
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://web.facebook.com/infojitc");
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"jitcyk.official@gmail.com"});
                intent.putExtra(Intent.EXTRA_CC,new String[]{""});
                intent.putExtra(Intent.EXTRA_SUBJECT,"");
                intent.putExtra(Intent.EXTRA_TEXT,"");
                try {
                    startActivity(Intent.createChooser(intent,"Ingin Mengirim Email?"));
                } catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(ImplicitIntentActivity.this,"Tidak Ada aplikasi mendukung", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void gotoUrl(String string) {
        Uri uri = Uri.parse(string);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}