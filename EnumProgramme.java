package gg.sim.mzevallos.projet_1;

public enum EnumProgramme {
	SCIENCESINFOMATH("Sciences informatiques et mathematiques"),
	INFORMATIQUE ("Techniques de l'informatique"),
	ELECTRONIQUE("Electronique programmable et robotique"),
	COMPTABILITE("Comptabilit�"),
	SOINSINFIRMIERS("Soins Infirmiers"),
	EDUCATIONENFANCE("Techniques de l'�ducation � l'enfance"),
	SCIENCESNATURES("Sciences de la nature"),
	SCIENCESHUMAINES("Sciences Humaines"),
	ARTSETLETTRES("Arts et Lettres");
	
	private String description = null;
	
	EnumProgramme(String desc) {
		this.description = desc;
	}
	
    public String getDescription() {
        return this.description;
    }
    
    public static EnumProgramme getEnum(String s) {
//    	System.out.println("input: " + s);
    	for (EnumProgramme e : EnumProgramme.values()) {
//    	   	System.out.println("e: " + e + "des: " + e.description);
    		if (e.description.equals(s)) {
    			return e;
    		}
    	}
    	return null;
    }
    
}
