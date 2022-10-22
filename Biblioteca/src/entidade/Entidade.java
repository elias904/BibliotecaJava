package entidade;

public abstract class Entidade {
	public Integer id; 
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String toString(int x) 
	{
		String str = Integer.toString(x);
		return str;
	}
	public String toString(float x) 
	{
		String str = Float.toString(x);
		return str;
	}
	public String toString(Double x) 
	{
		String str = Double.toString(x);
		return str;
	}
	public abstract String getNomeLivro();
	public String getMatriculaAluno() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
