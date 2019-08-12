package com.xebia.xebia_tondeuse;
public class Tondeuse {

    private Position position;

    private String instructions;


    public Tondeuse(Position position, String instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    public String tondre(Pelouse pelouse) {
        //verifier que la pelouse a de bonne dimension et que les coordonnees de la Tondeuse sont dans la pelouse
        if (!isValidePelouse(pelouse) || !isTondeuseInsidePelouse(pelouse))
            throw new PelouseDimentionException("verifier les dimensions de votre pelouse (" + pelouse.getLongeur() + "," + pelouse.getLargeur() + ") ou les coordonnees de votre tondeuse (" + position.getX() + "," + position.getY() + ")");
        for (int i = 0; i < instructions.length(); i++) {
            String directive = String.valueOf(instructions.charAt(i));
            if ("A".equals(directive))
                position.avanceVersDirection(pelouse);
            else
                position.changeOrientation(directive);
        }
        return position.toString();
    }

    public Position getPosition() {
        return position;
    }

    private boolean isValidePelouse(Pelouse pelouse) {
        if (pelouse.getLargeur() < 1 || pelouse.getLongeur() < 1)
            return false;
        return true;
    }

    private boolean isTondeuseInsidePelouse(Pelouse pelouse) {
        if (pelouse.getLargeur() < position.getX() || pelouse.getLongeur() < position.getY())
            return false;
        return true;
    }

}
