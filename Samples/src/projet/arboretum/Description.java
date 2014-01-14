package projet.arboretum;

import org.mapsforge.core.GeoPoint;

public class Description {

	// Points d'interet
	private static GeoPoint mare = new GeoPoint(45.193389, 5.778929);
	private static GeoPoint soleil = new GeoPoint(45.194218, 5.777244);
	private static GeoPoint mercure = new GeoPoint(45.194279, 5.777405);
	private static GeoPoint venus = new GeoPoint(45.19426, 5.777419);
	private static GeoPoint terre = new GeoPoint(45.19429, 5.777483);
	private static GeoPoint mars = new GeoPoint(45.194313, 5.777558);
	private static GeoPoint jupiter = new GeoPoint(45.194521, 5.778277);
	private static GeoPoint saturne = new GeoPoint(45.194332, 5.779071);
	private static GeoPoint uranus = new GeoPoint(45.193228, 5.778835);
	private static GeoPoint meleze = new GeoPoint(45.193389, 5.778929);
	private static GeoPoint mahonia = new GeoPoint(45.193389, 5.778929);

	private static String nomFichier;

	// Setters and Getters
	protected static String getNomFichier() {
		return nomFichier;
	}

	protected static void setNomFichier(String nomFichier) {
		Description.nomFichier = nomFichier;
	}

	public static GeoPoint getMarre() {
		return mare;
	}

	public static void setMarre(GeoPoint marre) {
		Description.mare = marre;
	}

	public static GeoPoint getSoleil() {
		return soleil;
	}

	public static void setSoleil(GeoPoint soleil) {
		Description.soleil = soleil;
	}

	public static GeoPoint getMercure() {
		return mercure;
	}

	public static void setMercure(GeoPoint mercure) {
		Description.mercure = mercure;
	}

	public static GeoPoint getVenus() {
		return venus;
	}

	public static void setVenus(GeoPoint venus) {
		Description.venus = venus;
	}

	public static GeoPoint getTerre() {
		return terre;
	}

	public static void setTerre(GeoPoint terre) {
		Description.terre = terre;
	}

	public static GeoPoint getMars() {
		return mars;
	}

	public static void setMars(GeoPoint mars) {
		Description.mars = mars;
	}

	public static GeoPoint getJupiter() {
		return jupiter;
	}

	public static void setJupiter(GeoPoint jupiter) {
		Description.jupiter = jupiter;
	}

	public static GeoPoint getSaturne() {
		return saturne;
	}

	public static void setSaturne(GeoPoint saturne) {
		Description.saturne = saturne;
	}

	public static GeoPoint getUranus() {
		return uranus;
	}

	public static void setUranus(GeoPoint uranus) {
		Description.uranus = uranus;
	}

	public static GeoPoint getMeleze() {
		return meleze;
	}

	public static void setMeleze(GeoPoint meleze) {
		Description.meleze = meleze;
	}

	public static GeoPoint getMahonia() {
		return mahonia;
	}

	public static void setMahonia(GeoPoint mahonia) {
		Description.mahonia = mahonia;
	}

}
