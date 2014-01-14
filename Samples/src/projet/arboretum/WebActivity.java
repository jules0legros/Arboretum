package projet.arboretum;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Mise à jour du ContentView
		setContentView(R.layout.activity_webview);

		// Declaration de la webview
		WebView objetview;

		// On donne à la vue ce qu'elle doit afficher
		objetview = (WebView) findViewById(R.id.eltWebView);
		objetview.loadUrl(Description.getNomFichier());
	}

}
