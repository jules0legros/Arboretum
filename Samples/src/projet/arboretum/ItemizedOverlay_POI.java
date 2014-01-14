package projet.arboretum;

import org.mapsforge.android.maps.overlay.ArrayItemizedOverlay;
import org.mapsforge.android.maps.overlay.OverlayItem;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;

public class ItemizedOverlay_POI extends ArrayItemizedOverlay {

	private final Context context;

	ItemizedOverlay_POI(Drawable defaultMarker, Context context) {
		super(defaultMarker);
		this.context = context;
	}

	CharSequence POI[] = { "Soleil", "Mare", "Mercure", "Venus", "Terre", "Mars", "Jupiter", "Saturne", "Uranus",
			"Meleze", "Mahonia" };
	CharSequence Soleil[] = { "Soleil" };
	CharSequence Mare[] = { "Mare" };
	CharSequence Mercure[] = { "Mercure" };
	CharSequence Venus[] = { "Venus" };
	CharSequence Terre[] = { "Terre" };
	CharSequence Mars[] = { "Mars" };
	CharSequence Jupiter[] = { "Jupiter" };
	CharSequence Saturne[] = { "Saturne" };
	CharSequence Uranus[] = { "Uranus" };
	CharSequence Meleze[] = { "Meleze" };
	CharSequence Mahonia[] = { "Mahonia" };
	CharSequence choices[] = { "View in the arboretum", "Show information from internet" };

	String path = "file:///sdcard/Arboretum/";

	/**
	 * Handles a tap event on the given item.
	 */
	@SuppressLint("NewApi")
	@Override
	protected boolean onTap(int index) {
		// Declaration de l'item qui est déclenché et de l'intent
		OverlayItem item = createItem(index);
		final Intent intent = new Intent(context, WebActivity.class);

		if (item != null) {
			if (item.getPoint() == Description.getSoleil()) {

				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "soleil.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/58-the-sun-formation-facts-and-characteristics.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.sun);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();

			} else if (item.getPoint() == Description.getMarre()) {

				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "mare.html");
							context.startActivity(intent);
						} else {
							Description.setNomFichier("http://en.wikipedia.org/wiki/Pond");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.location);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getMercure()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "mercure.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/36-mercury-the-suns-closest-planetary-neighbor.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.mercury);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getVenus()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "venus.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/44-venus-second-planet-from-the-sun-brightest-planet-in-solar-system.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.venus);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getTerre()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "terre.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/54-earth-history-composition-and-atmosphere.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.earth);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getMars()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "mars.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/47-mars-the-red-planet-fourth-planet-from-the-sun.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.mars);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getJupiter()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "jupiter.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/7-jupiter-largest-planet-solar-system.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.jupiter);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getSaturne()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "saturne.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/48-saturn-the-solar-systems-major-ring-bearer.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.saturn);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getUranus()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "uranus.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://www.space.com/45-uranus-seventh-planet-in-earths-solar-system-was-first-discovered-planet.html");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.uranus);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getMeleze()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "meleze.html");
							context.startActivity(intent);
						} else {
							Description.setNomFichier("http://en.wikipedia.org/wiki/Larix_kaempferi");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.location);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();
			} else if (item.getPoint() == Description.getMahonia()) {
				// Declaration de la boite de dialogue ainsi que les actions disponibles
				Builder builder = new AlertDialog.Builder(this.context, AlertDialog.THEME_HOLO_DARK);

				builder.setItems(choices, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						if (item == 0) {
							Description.setNomFichier(path + "mahonia.html");
							context.startActivity(intent);
						} else {
							Description
									.setNomFichier("http://en.wikipedia.org/wiki/Mahonia_japonica#Mahonia_japonica_.22Bealei.22");
							context.startActivity(intent);
						}
					}
				});

				builder.setIcon(R.drawable.location);
				builder.setTitle("More information about : " + item.getTitle());
				builder.setPositiveButton("Back", null);
				builder.show();

			}
		}
		return true;
	}

}
