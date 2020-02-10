package com.example.toolbar_actionbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    TextView text;
    WebView webView;
    String value = "<h1> First header </h1>\n" + "<h2> Second header </h2>\n" +
                    "<h3> Third header </h3>\n" + "<p> Paragraph </p>\n" +
                    "<p><u> Underlined paragraph </u></p>\n" +
                    "<p><strong> Bold paragraph </strong></p>\n" +
                    "(a+b)<sup>2</sup> = a<sup>2</sup> + 2ab + b<sup>2</sup>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        webView = findViewById(R.id.webViewID1);
        webView.loadDataWithBaseURL(null, value, "text/html", "utf-8", null);

        text = findViewById(R.id.textViewID);
        text.setText(Html.fromHtml(value));
    }
///////////// অথবা manifest এ Second activity এর ভিতরে parent হিসেবে MainActivity দিলেও back বাটোন কাজ করবে ////////
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId()==android.R.id.home){
//            this.finish();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
