package br.com.questionario.enumerate;

public enum Alfabeto {
    
	A("{alfabeto.A}",0),
	B("{alfabeto.B}",1),
	C("{alfabeto.C}",2),
	D("{alfabeto.D}",3),
	E("{alfabeto.E}",4),
	F("{alfabeto.F}",5),
	G("{alfabeto.G}",6),
	H("{alfabeto.H}",7),
	I("{alfabeto.I}",8),
	J("{alfabeto.J}",9),
	K("{alfabeto.K}",10),
	L("{alfabeto.L}",11),
	M("{alfabeto.M}",12),
	N("{alfabeto.N}",13),
	O("{alfabeto.O}",14),
	P("{alfabeto.P}",15),
	Q("{alfabeto.Q}",16),
	R("{alfabeto.R}",17),
	S("{alfabeto.S}",18),
	T("{alfabeto.T}",19),
	U("{alfabeto.U}",20),
	V("{alfabeto.V}",21),
	W("{alfabeto.W}",22),
	X("{alfabeto.X}",23),
	Z("{alfabeto.Z}",24);

	
    /**
     * @return Retorna o codigo.
     */
	private Integer codigo;
	private String label;
    
    private Alfabeto(String label, Integer codigo) {
    	this.label = label;
    	this.codigo = codigo;
    }
     
    public String getLabel() {
        return label;
    }

	public Integer getCodigo() {
		return codigo;
	}
	
	public static Alfabeto getByCodigo(Integer codigo){
		Alfabeto alfabeto = null;
		for(Alfabeto a : Alfabeto.values()){
			if(a.getCodigo() == codigo){
				alfabeto = a;
			}
		}
		return alfabeto;		
	}
    
	
}

