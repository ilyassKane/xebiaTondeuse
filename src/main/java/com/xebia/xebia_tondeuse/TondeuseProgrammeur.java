package com.xebia.xebia_tondeuse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TondeuseProgrammeur {

    //regex pour recuperer les dimensions de la pelouse
    private String pelousepattern="^\\d+\\s\\d+$";

    //regex pour recuperer la position de la tondeuse
    private String positionInitpattern="^\\d+\\s\\d+\\s\\w$";

    private Pelouse pelouse=null;

    private Position position = null;

    List<Tondeuse> listTondeuse = new ArrayList<>();

public List<Tondeuse> programme(String fileName){

    try(Stream<String> rows = Files.lines(Paths.get(fileName))){
        rows.forEach(line -> programmeTonDeuse(line));
    }catch (Exception e){
        //faut logger l'erreur et retourner un code d'erreur si necessaire
        System.out.println("Erreur : "+e);
    }

    return listTondeuse;
}

    private void programmeTonDeuse(String line) {
        Pattern patternPosition = Pattern.compile(positionInitpattern);
        Pattern patternPelouse = Pattern.compile(pelousepattern);
        if(patternPelouse.matcher(line).find()){
            //recuperation des dimmension de la pelouse
            pelouse=new Pelouse(Integer.parseInt(line.trim().split("\\s")[0]),Integer.parseInt(line.trim().split("\\s")[1]));
        }
        else if(patternPosition.matcher(line).find()){
            //recuperation des coordonnees de la Tondeuse
            position = new Position();
            position.setX(Integer.parseInt(line.trim().split("\\s")[0]));
            position.setY(Integer.parseInt(line.trim().split("\\s")[1]));
            position.setOrientation(line.trim().split("\\s")[2]);
        }else{
            //On suppose que le fichier est valide (normalement, il faut creer un valideur du fichier en entree)
            //donc on recupere forcement les instructions.
            Tondeuse tondeuse= new Tondeuse(position,line);
            listTondeuse.add(tondeuse);
        }
    }

    public Pelouse getPelouse(){
    return pelouse;
    }
}
