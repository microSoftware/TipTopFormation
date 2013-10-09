package com.example.p1;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.example.p1.R.id;

public class MainActivity extends Activity {
	
	//EDIT TEXT
	private EditText prenom = null;
	private EditText nom = null;
	private EditText age = null;
	
	private EditText editAutre = null;
	
	//RADIOBOUTON & RADIOGROUp
	private RadioGroup sexe = null;
	private RadioButton autre = null;
	private RadioGroup rg = null;
	
	//BOUTON SUBMIT
	private Button envoyer = null;
	


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Resources ressource = getResources();
		
		prenom = (EditText) findViewById(id.prenom);
		nom = (EditText) findViewById(id.nom);
		age = (EditText) findViewById(id.age);
		
		rg = (RadioGroup) findViewById(id.groupBac);
		autre = (RadioButton) findViewById(id.bacAutre);
		editAutre = (EditText) findViewById(id.editAutre);
		
		sexe = (RadioGroup) findViewById(id.groupSexe);
		

		
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId == R.id.bacAutre){
					editAutre.setVisibility(1);
				}
				else {
					editAutre.setVisibility(-1);
				}
			}
		});
		
		
		envoyer = (Button) findViewById(id.envoyer);
		
		envoyer.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if (prenom.getText().toString().isEmpty()){
					Toast.makeText(MainActivity.this, "Veuillez renseignez votre prénom", Toast.LENGTH_SHORT).show();
				}
				else if (nom.getText().toString().isEmpty()){
					Toast.makeText(MainActivity.this, "Veuillez renseignez votre nom", Toast.LENGTH_SHORT).show();
				}
				else if (age.getText().toString().isEmpty()){
					Toast.makeText(MainActivity.this, "Veuillez renseignez votre age", Toast.LENGTH_SHORT).show();
				}
				else {
					Toast.makeText(MainActivity.this, "Les données ont bien été enregistrées", Toast.LENGTH_SHORT).show();
					prenom.getText().clear();
					nom.getText().clear();
					age.getText().clear();
					
					rg.clearCheck();
					
					sexe.clearCheck();
					
				}
			}
		});
		
	}

	
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}