package tn.edu.BookStoreSpring.DOA;

public class bookFilterByCategory {
String CategorieName;
String Pourcentage;
public String getCategorieName() {
	return CategorieName;
}
public void setCategorieName(String categorieName) {
	CategorieName = categorieName;
}
public String getPourcentage() {
	return Pourcentage;
}
public void setPourcentage(String pourcentage) {
	Pourcentage = pourcentage;
}
public bookFilterByCategory() {
	super();
	// TODO Auto-generated constructor stub
}
public bookFilterByCategory(String categorieName, String pourcentage) {
	super();
	CategorieName = categorieName;
	Pourcentage = pourcentage;
}
@Override
public String toString() {
	return "bookFilterByCategory [CategorieName=" + CategorieName + ", Pourcentage=" + Pourcentage + "]";
}

}
