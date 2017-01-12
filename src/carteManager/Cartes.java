package carteManager;

import java.util.ArrayList;
import java.util.Random;

import carteModule.*;
import carteModule.Guide.*;
import carteModule.croyant.*;
import carteModule.deuxEx.*;


public class Cartes {
	private ArrayList<CarteAction> cartes;
	private int nbCartes;
	private static Cartes pile;
	
	private Cartes() {
		cartes = new ArrayList<CarteAction>();
		
		//Croyant
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		cartes.add(new Travailleurs1());
		cartes.add(new Travailleurs2());
		cartes.add(new Travailleurs3());
		cartes.add(new Aliene1());
		cartes.add(new Aliene2());
		cartes.add(new Aliene3());
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Paladin());
		cartes.add(new Paladin());
		cartes.add(new Paladin());
		cartes.add(new Paladin());
		cartes.add(new Paladin());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		cartes.add(new Moine());
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		//Croyant
		
		
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		cartes.add(new Demon());
		
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		cartes.add(new Esprits());
		
		cartes.add(new Ermite());
		cartes.add(new Ermite());
		
		cartes.add(new Travailleurs1());
		
		cartes.add(new Aliene1());
		
		cartes.add(new Vampire());
		cartes.add(new Vampire());
		
		cartes.add(new Revolutionnaires());
		cartes.add(new Integristes());
		cartes.add(new GuerriersSaints());
		cartes.add(new Lycanthropes());
		cartes.add(new Diplomates());
		cartes.add(new Revenant());
		cartes.add(new Pilladrs());
		cartes.add(new Illusionnistes());
		cartes.add(new Nibillistes());
		
		//Guide Spirituel
		cartes.add(new Anarchiste());
		cartes.add(new Ascete());
		cartes.add(new ClercJour1());
		cartes.add(new ClercJour2());
		cartes.add(new ClercJour3());
		cartes.add(new ClercNuit1());
		cartes.add(new ClercNuit2());
		cartes.add(new ClercNuit3());
		cartes.add(new ClercNeant1());
		cartes.add(new ClercNeant2());
		cartes.add(new Devin());
		cartes.add(new Exorciste());
		cartes.add(new Martyr1());
		cartes.add(new Martyr2());
		cartes.add(new Martyr3());
		cartes.add(new Messie());
		cartes.add(new Shaman());
		cartes.add(new Sorcier());
		cartes.add(new Tyran());
		
		//Deus Ex
		cartes.add(new ColereDivineJour());
		cartes.add(new ColereDivineNuit());
		cartes.add(new Concentration());
		cartes.add(new Diversion());
		cartes.add(new Fourberie());
		cartes.add(new Inquisition());
		cartes.add(new OrdreCeleste());
		cartes.add(new Phoenix());
		
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		cartes.add(new Apocalypse());
		
		nbCartes = cartes.size();
	}
	public void melanger() {
		
	}
	public CarteAction returnCarte() {
		return cartes.get(new Random().nextInt(cartes.size()));
	}
	
	
	/*-----------------------------------*/
	public static Cartes getInstance() {
		if(pile == null) {
			pile = new Cartes();
		}
		return pile;
	}
	public int getNbCartes() {
		return this.nbCartes;
	}
	public ArrayList<CarteAction> getCartes() {
		return this.cartes;
	}
	
	
}
