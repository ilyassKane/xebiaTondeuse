package com.xebia.xebia_tondeuse;

public class TondeuseProgrammeValidation {
	
	//regex pour recuperer les dimensions de la pelouse
    private String pelousepattern="^\\d+\\s\\d+$";

    //regex pour recuperer la position de la tondeuse
    private String positionInitpattern="^\\d+\\s\\d+\\s\\w$";
    
  //regex pour recuperer les instructions
    private String instructionpattern="(A*G*D*)+";
    
    //0 aucune ligne n'a ete lu, 1 la premiere ligne est lu, 2 les coordonnees sont lus, 3 les instructions
    private int statutLignePrecedente=0;
    
    public void validate(int lineType) {
    	if(lineType==1 && statutLignePrecedente!=0) {
    		throw new InvalidFileException("Le fichier n'est pas bien forme, ligne de type dimension pelouse n'est pas attendu [(X Y)]");
    	}
    	if(lineType==2 && (statutLignePrecedente!=1 && statutLignePrecedente!=3)) {
    		throw new InvalidFileException("Le fichier n'est pas bien forme, ligne de type coordonnee Tondeuse n'est pas attendu [X Y O]");
    	}
    	if(lineType==3 && statutLignePrecedente!=2) {
    		throw new InvalidFileException("Le fichier n'est pas bien forme, ligne de type Instruction n'est pas attendu [GDAA...]");
    	}
    	setStatutLignePrecedente(lineType);
    }

	public String getPelousepattern() {
		return pelousepattern;
	}

	public String getPositionInitpattern() {
		return positionInitpattern;
	}

	public String getInstructionpattern() {
		return instructionpattern;
	}

	public int getStatutLignePrecedente() {
		return statutLignePrecedente;
	}

	public void setStatutLignePrecedente(int statutLignePrecedente) {
		this.statutLignePrecedente = statutLignePrecedente;
	}
	
	
    
    

}
