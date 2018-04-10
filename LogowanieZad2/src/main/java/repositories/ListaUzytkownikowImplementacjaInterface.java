package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.DaneRejestracji;

public class ListaUzytkownikowImplementacjaInterface 
	implements InterfaceListaUzytRepozytorium {
	
	public static List<DaneRejestracji> db = new ArrayList<DaneRejestracji>();
	
	@Override																	//nadpisywanie metod interface 
	public DaneRejestracji getUserByEmailAddress(String email){
		for(DaneRejestracji uzytkownik: db){
			if(uzytkownik.getEmail().equalsIgnoreCase(email)){
				return uzytkownik;
			}
		}
		return null;
	}
	
	@Override 												//nadpisywanie metod interface 
	public void add(DaneRejestracji uzytkownik){
		db.add(uzytkownik);
	}
	
	@Override												//nadpisywanie metod interface 
	public int count(){
		return db.size();
	}
	
	@Override												//nadpisywanie metod interface 
	public String idUsername(int i){
		String Username = db.get(i).getUsername();
		return Username;
	}
	
	@Override											
	public String idPassword(int i){
		String Password = db.get(i).getPassword();
		return Password;
	}
	
	@Override												
	public String idEmail(int i){
		String Email = db.get(i).getEmail();
		return Email;
	}
	
	@Override												
	public void zmienUprPremium(int idUprPremium, DaneRejestracji uprPremium){
		db.set(idUprPremium, uprPremium);
	}
	
	@Override												
	public boolean idUprPremium(int i){
		boolean UprPremium = db.get(i).isUprPremium();
		return UprPremium;
	}
	
	@Override												
	public void zmienUprAdmin(int idUprAdmin, DaneRejestracji uprAdmin){
		db.set(idUprAdmin, uprAdmin);
	}
	
	@Override												
	public boolean idUprAdmin(int i){
		boolean UprAdmin = db.get(i).isUprAdmin();
		return UprAdmin;
	}
	
	@Override 												
	public boolean contains(Object objektListy){
		return db.contains(objektListy);
	}
	
	
}
