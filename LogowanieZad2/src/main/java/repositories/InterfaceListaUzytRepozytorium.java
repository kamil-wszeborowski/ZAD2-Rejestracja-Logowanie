package repositories;


import domain.DaneRejestracji;

public interface InterfaceListaUzytRepozytorium {
	DaneRejestracji getUserByEmailAddress(String email);
	void add(DaneRejestracji uzytkownik);
	int count();
	
	
	String idUsername(int i);
	String idPassword(int i);
	String idEmail(int i);
	void zmienUprPremium(int username, DaneRejestracji uprPremium);
    boolean idUprPremium(int i);
    public boolean idUprAdmin(int i);
    public void zmienUprAdmin(int idUprAdmin, DaneRejestracji uprAdmin);
    boolean contains(Object objektListy);
}
