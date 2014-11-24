package com.example.testesqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDao {
	private SQLiteDatabase db;
	public UsuarioDao( Context context) {
		DBCore auxdb = new  DBCore(context);
		db = auxdb.getWritableDatabase();		
	}
	
	public void inserir(Usuario usuario) {
		ContentValues values = new ContentValues();
		values.put("nome", usuario.getNome());
		values.put("telefone", usuario.getTelefone());
		values.put("email", usuario.getEmail());
		
		db.insert("usuario", null, values);
	}
	public void atualizar(Usuario usuario) {
		ContentValues values = new ContentValues();
		values.put("nome", usuario.getNome());
		values.put("telefone", usuario.getTelefone());
		values.put("email", usuario.getEmail());
		
		db.update("usuario", values, "_id = ?", new String[]{""+usuario.getId()});
	}
	
	public void deletar(Usuario usuario) {
		db.delete("usuario", "_id = ?", new String[]{""+usuario.getId()});
	}

	public  List<Usuario> buscar() {
		List<Usuario> list = new ArrayList<Usuario>();
		String[] columns = {"_id","nome","telefone","email"};
		Cursor cursor = db.query("usuario", columns, null, null, null, null, "_id");
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			
			do {
				Usuario usuario = new Usuario();
				usuario.setId(cursor.getLong(0));
				usuario.setNome(cursor.getString(1));
				usuario.setTelefone(cursor.getString(2));
				usuario.setEmail(cursor.getString(3));
				
				list.add(usuario);
			} while (cursor.moveToNext());
		}
		return(list);
	}
}
