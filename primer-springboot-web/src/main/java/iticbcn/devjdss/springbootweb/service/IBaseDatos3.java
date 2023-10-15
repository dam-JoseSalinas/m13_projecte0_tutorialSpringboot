package iticbcn.devjdss.springbootweb.service;
import java.util.ArrayList;

import iticbcn.devjdss.springbootweb.bean.Libro3;

public interface IBaseDatos3 {
	public ArrayList<Libro3> getLibros();
	public Libro3 getLibro(int id);
	public void inserta(Libro3 libro);
	public void modifica(Libro3 libro);
	public void borrar(int id);
	
	public boolean compruebaUsuario(String usuario, String password);
}
