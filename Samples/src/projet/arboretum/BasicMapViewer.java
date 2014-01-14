package projet.arboretum;

import java.io.File;

import org.mapsforge.android.maps.MapActivity;
import org.mapsforge.android.maps.MapView;
import org.mapsforge.android.maps.overlay.ArrayItemizedOverlay;
import org.mapsforge.android.maps.overlay.ItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;
import org.mapsforge.core.GeoPoint;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

public class BasicMapViewer extends MapActivity implements LocationListener {

	// Declaration des variables necessaires
	private MapView mapView;
	private LocationManager location;
	private OverlayItem MarkerLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Creation de notre map et mise en place des options liées
		File map = new File(Environment.getExternalStorageDirectory().toString() + "/campus.map");

		mapView = new MapView(this);
		mapView.setMapFile(map);
		mapView.setClickable(true);
		mapView.setBuiltInZoomControls(true);

		setContentView(mapView);

		// Creation des markers pour la position courante et pour les points d'interets
		Drawable location = getResources().getDrawable(R.drawable.location_oriented);
		Drawable draw_poi = getResources().getDrawable(R.drawable.location);

		// On le stock dans un tableau seul car on ne le veut pas cliquable
		ArrayItemizedOverlay itemizedOverlay_location = new ArrayItemizedOverlay(location);

		// Initialisation du GPS au niveau du soleil
		GeoPoint myPos = new GeoPoint(45.194218, 5.777244);

		// Creation du tableau de marker pour les points d'interets
		ArrayItemizedOverlay itemizedOverlay_POI = new ItemizedOverlay_POI(ItemizedOverlay.boundCenter(draw_poi), this);

		// Mise à jour du marker de position courante
		MarkerLocation = new OverlayItem(myPos, "Moi", "Je suis ici");
		MarkerLocation.setMarker(ItemizedOverlay.boundCenter(location));

		itemizedOverlay_location.addItem(MarkerLocation);
		mapView.setCenter(MarkerLocation.getPoint());

		// On ajoute ici les planètes et les plantes dans le itemized Overlay une par une
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getSoleil(), "Soleil", "Emplacement du Soleil"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getMarre(), "Mare", "Emplacement de la Mare"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getMercure(), "Mercure", "Emplacement de Mercure"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getVenus(), "Venus", "Emplacement de Venus"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getTerre(), "Terre", "Emplacement de Terre"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getMars(), "Mars", "Emplacement de Mars"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getJupiter(), "Jupiter", "Emplacement de Jupiter"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getSaturne(), "Saturne", "Emplacement de Saturne"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getUranus(), "Uranus", "Emplacement de Uranus"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getMeleze(), "Meleze", "Emplacement de Meleze"));
		itemizedOverlay_POI.addItem(new OverlayItem(Description.getMahonia(), "Mahonia", "Emplacement de Mahonia"));

		// Mise en place de l'utilisation du GPS
		this.location = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		this.location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, this);

		// On ajoute les markers dans la mapview
		mapView.getOverlays().add(itemizedOverlay_POI);
		mapView.getOverlays().add(itemizedOverlay_location);
	}

	@Override
	protected void onResume() {
		super.onResume();
		// Mise à jour de la position
		this.location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this);
		this.location.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0, this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Suppression des mise à jour
		this.location.removeUpdates(this);
	}

	@Override
	public void onLocationChanged(Location arg0) {
		// Mise à jour du marker si ma position sur le GPS change
		GeoPoint my_pos = new GeoPoint(arg0.getLatitude(), arg0.getLongitude());
		MarkerLocation.setPoint(my_pos);
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
		Context context = getApplicationContext();
		CharSequence text = "Veuillez activer le GPS";
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODv Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

	}

}
