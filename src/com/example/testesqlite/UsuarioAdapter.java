package com.example.testesqlite;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UsuarioAdapter extends BaseAdapter{
	
	private Context context;
	private List<Usuario> list;
	
	public UsuarioAdapter(Context context, List<Usuario> list) {
		this.context = context;
		this.list = list;
	}
	
	



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return list.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final int auxposition = position;
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		
		final LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.usuario,null);
		TextView txtNomeUsuario = (TextView) layout.findViewById(R.id.txtNomeUsuario);
		Button btnEditarUsusario = (Button) layout.findViewById(R.id.btnEditarUsuario);
		Button btnDeletarUsuario = (Button) layout.findViewById(R.id.btnDeletarUsuario);
		
		txtNomeUsuario.setText(list.get(auxposition).getNome());
		
		btnEditarUsusario.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(context,CadastrarUsuarioActivity.class);
				intent.putExtra("id", list.get(auxposition).getId());
				intent.putExtra("nome", list.get(auxposition).getNome());
				intent.putExtra("telefone", list.get(auxposition).getTelefone());
				intent.putExtra("email", list.get(auxposition).getEmail());
				context.startActivity(intent);
								
			}
		});
		btnDeletarUsuario.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				UsuarioDao usuarioDao = new UsuarioDao(context);
				usuarioDao.deletar(list.get(auxposition));
				layout.setVisibility(View.GONE);
			}
		});
		
		return layout;
	}

}
