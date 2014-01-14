package projet.arboretum;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.panoramagl.PLView;
import com.panoramagl.loaders.PLILoader;
import com.panoramagl.loaders.PLJSONLoader;
import com.panoramagl.transitions.PLTransitionBlend;

public class Navigation_Virtuelle extends PLView {
	// References to the sounds
	MediaPlayer player;
	AudioManager audioManager;

	// Attribut de la classe pour calculer l'orientation
	float[] acceleromterVector = new float[3];
	float[] magneticVector = new float[3];
	float[] resultMatrix = new float[9];
	float[] values = new float[3];

	// Gestionnaire de capteurs
	SensorManager sensorManager;
	// Capteurs
	Sensor accelerometer, magnetic;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onPause() {
		super.onPause();
		this.player.pause();
		finish();
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.player.start();
	}

	@Override
	protected void onStop() {
		super.onStop();
		this.player.stop();
		this.player = null;
		finish();
	}

	/**
	 * Methode appelee lorsque le content view est creee et initialise les images panoramique et le gestionnaire de
	 * musique
	 */
	@Override
	protected View onContentViewCreated(View contentView) {
		// Charger le layout
		ViewGroup mainView = (ViewGroup) this.getLayoutInflater().inflate(R.layout.activity_main, null);
		// Ajouter la 360 view
		mainView.addView(contentView, 0);

		chargerPanorama();

		// Creation du media player pour l'environnement d'oiseaux
		this.player = MediaPlayer.create(this, R.raw.oiseaux);
		this.player.setLooping(true); // Loop lorsque le son est fini
		this.player.start(); // Demarrer le son

		return super.onContentViewCreated(mainView);
	}

	/**
	 * Methode appelee lorsqu'un sensor a detecte un changement
	 */
	@Override
	public void onSensorChanged(SensorEvent event) {
		float x;

		super.onSensorChanged(event);

		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
			this.acceleromterVector = event.values;

		else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
			this.magneticVector = event.values;

		// Demande au sensorManager la matric de Rotation (resultMatric)
		SensorManager.getRotationMatrix(this.resultMatrix, null, this.acceleromterVector, this.magneticVector);

		// Demande au SensorManager le vecteur d'orientation associe (values)
		SensorManager.getOrientation(this.resultMatrix, this.values);

		// l'azimuth
		x = (float) Math.toDegrees(this.values[0]);

		Log.d("x", Float.toString(x));

		// Regule le volume en fonction de l'orientation de l'appareil
		this.player.setVolume(Math.abs(x / 180), 1 - Math.abs(x / 180));
	}

	/**
	 * Charge la premiere image panoramique du virtual tour
	 */
	private void chargerPanorama() {
		try {
			PLILoader loader = null;

			loader = new PLJSONLoader("res://raw/pano1_info");

			if (loader != null)
				this.load(loader, true, new PLTransitionBlend(2.0f));
		} catch (Throwable e) {
			Toast.makeText(this.getApplicationContext(), "Error: " + e, Toast.LENGTH_SHORT).show();
		}
	}

}