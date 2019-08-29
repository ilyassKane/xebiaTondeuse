package com.xebia.xebia_tondeuse;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TondeuseProgrammeur {

	private Pelouse pelouse = null;

	private Position position = null;

	List<Tondeuse> listTondeuse = new ArrayList<>();

	private TondeuseProgrammeValidation tondeuseProgrammeValidation;

	public TondeuseProgrammeur(TondeuseProgrammeValidation tondeuseProgrammeValidation) {
		this.tondeuseProgrammeValidation = tondeuseProgrammeValidation;
	}

	public List<Tondeuse> programme(String fileName) {

		try (Stream<String> rows = Files.lines(Paths.get(fileName))) {
			rows.forEach(line -> programmeTonDeuse(line));
		} catch (Exception e) {
			// faut logger l'erreur et retourner un code d'erreur si necessaire
			System.out.println("Erreur : " + e);
		}

		return listTondeuse;
	}

	private void programmeTonDeuse(String line) {
		Pattern patternPosition = Pattern.compile(tondeuseProgrammeValidation.getPositionInitpattern());
		Pattern patternPelouse = Pattern.compile(tondeuseProgrammeValidation.getPelousepattern());
		Pattern patterninstruction = Pattern.compile(tondeuseProgrammeValidation.getInstructionpattern());
		if (patternPelouse.matcher(line).matches()) {
			// recuperation des dimmension de la pelouse
			pelouse = new Pelouse(Integer.parseInt(line.trim().split("\\s")[0]),
					Integer.parseInt(line.trim().split("\\s")[1]));
			tondeuseProgrammeValidation.validate(1);
		} else if (patternPosition.matcher(line).matches()) {
			// recuperation des coordonnees de la Tondeuse
			position = new Position();
			position.setX(Integer.parseInt(line.trim().split("\\s")[0]));
			position.setY(Integer.parseInt(line.trim().split("\\s")[1]));
			position.setOrientation(getOrientation(line.trim().split("\\s")[2]));
			tondeuseProgrammeValidation.validate(2);

		} else if (patterninstruction.matcher(line).matches()) {
			// recuperation des instructions.
			Tondeuse tondeuse = new Tondeuse(position, line);
			listTondeuse.add(tondeuse);
			tondeuseProgrammeValidation.validate(3);
		} else {
			throw new InvalidFileException("this line is not valide : " + line);
		}
	}

	private OrientationTondeuse getOrientation(String orientation) {
		if ("N".equals(orientation))
			return OrientationTondeuse.NORTH;
		if ("E".equals(orientation))
			return OrientationTondeuse.EAST;
		if ("W".equals(orientation))
			return OrientationTondeuse.WEST;
		if ("S".equals(orientation))
			return OrientationTondeuse.SOUTH;
		return null;
	}

	public Pelouse getPelouse() {
		return pelouse;
	}
}
