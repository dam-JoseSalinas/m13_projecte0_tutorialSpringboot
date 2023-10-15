package iticbcn.devjdss.springbootweb.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iticbcn.devjdss.springbootweb.bean.Libro3;
import iticbcn.devjdss.springbootweb.repository.BaseDatos3;

@Service
public class BaseDatos3Service implements IBaseDatos3 {
	@Autowired
	BaseDatos3 bd;	
	@Override
	public void inserta(Libro3 libro) {bd.save(libro);}
	@Override
	public void borrar(int id) {bd.deleteById(id);}
	@Override
	public void modifica(Libro3 libro) {bd.save(libro);}
	@Override
	public Libro3 getLibro(int id) {
		Optional<Libro3> l = bd.findById(id);
		return l.get();
		}
	@Override
	public ArrayList<Libro3> getLibros() {return (ArrayList<Libro3>) bd.findAll();}
	@Override
	public boolean compruebaUsuario(String usuario, String password) {
		boolean check=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String conex="jdbc:mysql://localhost:3306/biblioteca"; //
			Connection conexion = DriverManager.getConnection(conex, "root", "");
			Statement s = conexion.createStatement();
			String sql = "SELECT count(*) FROM usuarios WHERE usuario='"+usuario+"' "
					+ "and password='"+password+"'";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			if (rs.getInt(1)>0) {
				check = true;
			}
		} catch (Exception ex) {
			System.out.print(ex.getMessage());
		}
		return check;
	}
}