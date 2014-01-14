/*
 * Copyright 2010, 2011, 2012 mapsforge.org
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package projet.arboretum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * A simple start screen for the sample activities.
 */
public class Arboretum extends Activity {

	Button Nav_reel;
	Button Nav_virtuelle;
	Button Options;
	Button Credits;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_samples);

		this.Nav_reel = (Button) findViewById(R.id.button_nav_reel);
		this.Nav_reel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Arboretum.this, BasicMapViewer.class);
				startActivity(intent);
			}
		});

		this.Nav_virtuelle = (Button) findViewById(R.id.button_nav_virt);
		this.Nav_virtuelle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Arboretum.this, Navigation_Virtuelle.class);
				startActivity(intent);
			}
		});

		this.Credits = (Button) findViewById(R.id.button_credits);
		this.Credits.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Arboretum.this, Credits.class);
				startActivity(intent);
			}
		});
	}
}
