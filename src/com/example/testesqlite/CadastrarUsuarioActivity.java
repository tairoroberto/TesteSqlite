package com.example.testesqlite;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarUsuarioActivity extends ActionBarActivity {
	Usuario usuario = new Usuario();
	EditText edtNome, edtTelefone, edtEmail;
	Button btnSalvar,btnAtualizar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar);
		
		//linka java com xml
		edtNome = (EditText)findViewById(R.id.edtNome);
		edtTelefone = (EditText)findViewById(R.id.edtTelefone);
		edtEmail = (EditText)findViewById(R.id.edtEmail);
		btnSalvar = (Button)findViewById(R.id.btnSalvar);
		btnAtualizar = (Button)findViewById(R.id.btnAtualizar);
		
		Intent intent = getIntent();
		
		if (intent != null) {
			Bundle bundle = intent.getExtras();
			
			if (bundle != null) {
				usuario.setId(bundle.getLong("id"));
				usuario.setNome(bundle.getString("nome"));
				usuario.setTelefone(bundle.getString("telefone"));
				usuario.setEmail(bundle.getString("email"));
				
				edtNome.setText(usuario.getNome());
				edtTelefone.setText(usuario.getTelefone());
				edtEmail.setText(usuario.getEmail());
				
				btnSalvar.setVisibility(View.GONE);
				btnAtualizar.setVisibility(View.VISIBLE);
			}
		}
		
		
		btnSalvar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		
				salvarUsuario();
			}
		});
		
		btnAtualizar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {		
				editarUsuario();
			}
		});
		
	}
	
	public void salvarUsuario() {
		usuario.setNome(edtNome.getText().toString());
		usuario.setTelefone(edtTelefone.getText().toString());
		usuario.setEmail(edtEmail.getText().toString());
		UsuarioDao usuarioDao = new UsuarioDao(this);
		usuarioDao.inserir(usuario);
		Toast.makeText(this, "usuário salvo com sucesso..!!",Toast.LENGTH_SHORT).show();
	}
	
	public void editarUsuario() {
		usuario.setNome(edtNome.getText().toString());
		usuario.setTelefone(edtTelefone.getText().toString());
		usuario.setEmail(edtEmail.getText().toString());
		UsuarioDao usuarioDao = new UsuarioDao(this);
		usuarioDao.atualizar(usuario);
		
		Toast.makeText(this, "usuário "+ usuario.getNome()+" salvo com sucesso..!!",Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
