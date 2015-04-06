package io;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import model.MetroEdge;

import org.xml.sax.SAXException;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.decorators.StringLabeller;

public class ViennaTravelTimes {

	private ArrayList<Triple> triples = new ArrayList<Triple>();

	public ViennaTravelTimes() {

		this.triples.add(new Triple("Leopoldau", "Gro�feldsiedlung", 120));
		this.triples.add(new Triple("Gro�feldsiedlung", "Aderklaaer Stra�e", 60));
		this.triples.add(new Triple("Aderklaaer Stra�e", "Rennbahnweg", 60));
		this.triples.add(new Triple("Rennbahnweg", "Kagraner Platz", 120));
		this.triples.add(new Triple("Kagraner Platz", "Kagran", 120));
		this.triples.add(new Triple("Kagran", "Alte Donau", 60));
		this.triples.add(new Triple("Alte Donau", "VIC Kaiserm�hlen", 120));
		this.triples.add(new Triple("VIC Kaiserm�hlen", "Donauinsel", 60));
		this.triples.add(new Triple("Donauinsel", "Vorgartenstra�e", 120));
		this.triples.add(new Triple("Vorgartenstra�e", "Praterstern", 60));
		this.triples.add(new Triple("Praterstern", "Nestroyplatz", 60));
		this.triples.add(new Triple("Nestroyplatz", "Schwedenplatz", 60));
		this.triples.add(new Triple("Schwedenplatz", "Stephansplatz", 60));
		this.triples.add(new Triple("Stephansplatz", "Karlsplatz", 120));
		this.triples.add(new Triple("Karlsplatz", "Taubstummengasse", 120));
		this.triples.add(new Triple("Taubstummengasse", "S�dtiroler Platz", 60));
		this.triples.add(new Triple("S�dtiroler Platz", "Keplerplatz", 120));
		this.triples.add(new Triple("Keplerplatz", "Reumannplatz", 60));
		this.triples.add(new Triple("Aspernstra�e", "Donauspital", 60));
		this.triples.add(new Triple("Donauspital", "Hardeggasse", 120));
		this.triples.add(new Triple("Hardeggasse", "Stadlau Bahnhst", 60));
		this.triples.add(new Triple("Stadlau Bahnhst", "Donaustadtbr�cke", 60));
		this.triples.add(new Triple("Donaustadtbr�cke", "Donaumarina", 120));
		this.triples.add(new Triple("Donaumarina", "Stadion", 60));
		this.triples.add(new Triple("Stadion", "Trabrennstra�e", 120));
		this.triples.add(new Triple("Trabrennstra�e", "Messe", 60));
		this.triples.add(new Triple("Messe", "Praterstern", 120));
		this.triples.add(new Triple("Praterstern", "Taborstra�e", 120));
		this.triples.add(new Triple("Taborstra�e", "Schottenring", 60));
		this.triples.add(new Triple("Schottenring", "Schottentor", 60));
		this.triples.add(new Triple("Schottentor", "Rathaus", 120));
		this.triples.add(new Triple("Rathaus", "Volkstheater", 120));
		this.triples.add(new Triple("Volkstheater", "Museumsquartier", 60));
		this.triples.add(new Triple("Museumsquartier", "Karlsplatz", 120));
		this.triples.add(new Triple("Ottakring", "Kendlerstra�e", 60));
		this.triples.add(new Triple("Kendlerstra�e", "H�tteldorfer Stra�e", 60));
		this.triples.add(new Triple("H�tteldorfer Stra�e", "Johnstra�e", 60));
		this.triples.add(new Triple("Johnstra�e", "Schweglerstra�e", 120));
		this.triples.add(new Triple("Schweglerstra�e", "Westbahnhof", 60));
		this.triples.add(new Triple("Westbahnhof", "Zieglergasse", 60));
		this.triples.add(new Triple("Zieglergasse", "Neubaugasse", 60));
		this.triples.add(new Triple("Neubaugasse", "Volkstheater", 120));
		this.triples.add(new Triple("Volkstheater", "Herrengasse", 60));
		this.triples.add(new Triple("Herrengasse", "Stephansplatz", 120));
		this.triples.add(new Triple("Stephansplatz", "Stubentor", 60));
		this.triples.add(new Triple("Stubentor", "Landstra�e", 60));
		this.triples.add(new Triple("Landstra�e", "Rochusgasse", 120));
		this.triples.add(new Triple("Rochusgasse", "Kardinal-Nagel-Platz", 60));
		this.triples.add(new Triple("Kardinal-Nagel-Platz", "Schlachthausgasse", 60));
		this.triples.add(new Triple("Schlachthausgasse", "Erdberg", 60));
		this.triples.add(new Triple("Erdberg", "Gasometer", 120));
		this.triples.add(new Triple("Gasometer", "Zippererstra�e", 60));
		this.triples.add(new Triple("Zippererstra�e", "Enkplatz", 60));
		this.triples.add(new Triple("Enkplatz", "Simmering", 60));
		this.triples.add(new Triple("Heiligenstadt", "Spittelau", 120));
		this.triples.add(new Triple("Spittelau", "Friedensbr�cke", 60));
		this.triples.add(new Triple("Friedensbr�cke", "Ro�auer L�nde", 60));
		this.triples.add(new Triple("Ro�auer L�nde", "Schottenring", 120));
		this.triples.add(new Triple("Schottenring", "Schwedenplatz", 60));
		this.triples.add(new Triple("Schwedenplatz", "Landstra�e", 120));
		this.triples.add(new Triple("Landstra�e", "Stadtpark", 60));
		this.triples.add(new Triple("Stadtpark", "Karlsplatz", 120));
		this.triples.add(new Triple("Karlsplatz", "Kettenbr�ckengasse", 120));
		this.triples.add(new Triple("Kettenbr�ckengasse", "Pilgramgasse", 60));
		this.triples.add(new Triple("Pilgramgasse", "Margareteng�rtel", 120));
		this.triples.add(new Triple("Margareteng�rtel", "L�ngenfeldgasse", 120));
		this.triples.add(new Triple("L�ngenfeldgasse", "Meidling Hauptstra�e", 60));
		this.triples.add(new Triple("Meidling Hauptstra�e", "Sch�nbrunn", 60));
		this.triples.add(new Triple("Sch�nbrunn", "Hietzing", 120));
		this.triples.add(new Triple("Hietzing", "Braunschweiggasse", 60));
		this.triples.add(new Triple("Braunschweiggasse", "Unter St. Veit", 120));
		this.triples.add(new Triple("Unter St. Veit", "Ober St. Veit", 60));
		this.triples.add(new Triple("Ober St. Veit", "H�tteldorf", 120));
		this.triples.add(new Triple("Floridsdorf", "Neue Donau", 120));
		this.triples.add(new Triple("Neue Donau", "Handelskai", 60));
		this.triples.add(new Triple("Handelskai", "Dresdner Stra�e", 60));
		this.triples.add(new Triple("Dresdner Stra�e", "J�gerstra�e", 60));
		this.triples.add(new Triple("J�gerstra�e", "Spittelau", 60));
		this.triples.add(new Triple("Spittelau", "Nu�dorfer Stra�e", 120));
		this.triples.add(new Triple("Nu�dorfer Stra�e", "W�hringer Stra�e Volksoper", 60));
		this.triples.add(new Triple("W�hringer Stra�e Volksoper", "Michelbeuern AKH", 120));
		this.triples.add(new Triple("Michelbeuern AKH", "Alser Stra�e", 60));
		this.triples.add(new Triple("Alser Stra�e", "Josefst�dter Stra�e", 120));
		this.triples.add(new Triple("Josefst�dter Stra�e", "Thaliastra�e", 120));
		this.triples.add(new Triple("Thaliastra�e", "Burggasse Stadthalle", 60));
		this.triples.add(new Triple("Burggasse Stadthalle", "Westbahnhof", 120));
		this.triples.add(new Triple("Westbahnhof", "Gumpendorfer Stra�e", 60));
		this.triples.add(new Triple("Gumpendorfer Stra�e", "L�ngenfeldgasse", 120));
		this.triples.add(new Triple("L�ngenfeldgasse", "Niederhofstra�e", 60));
		this.triples.add(new Triple("Niederhofstra�e", "Philadelphiabr�cke", 120));
		this.triples.add(new Triple("Philadelphiabr�cke", "Tscherttegasse", 120));
		this.triples.add(new Triple("Tscherttegasse", "Am Sch�pfwerk", 60));
		this.triples.add(new Triple("Am Sch�pfwerk", "Alterlaa", 180));
		this.triples.add(new Triple("Alterlaa", "Erlaaer Stra�e", 120));
		this.triples.add(new Triple("Erlaaer Stra�e", "Perfektastra�e", 60));
		this.triples.add(new Triple("Perfektastra�e", "Siebenhirten", 60));
		
		try {
			this.process();
		} catch (SAXException | ParserConfigurationException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean process() throws SAXException, ParserConfigurationException, IOException {
			
		GraphMLReader reader = new GraphMLReader();
		Graph g = reader.loadGraph("resources/graphml/Vienna");
		
		String output = "";
		
		int edgeCounter = 0;
		int error = 0;
		for(Object e : g.getEdges()) {
			MetroEdge edge = (MetroEdge) e;
			
			Boolean[] lineArray = (Boolean[]) edge.getUserDatum("lineArray");
			StringLabeller VertexIDs = StringLabeller.getLabeller(g);
			String labelFirst = VertexIDs.getLabel(edge.getFirst());
			String labelSecond = VertexIDs.getLabel(edge.getSecond());
			output += "<edge id=\"e" + edgeCounter + "\" source=\"" + labelFirst + "\" target=\"" + labelSecond + "\">\r\n";
			int i = 0;
			for(Boolean b : lineArray) {
				if(b == true) {
					int time = Integer.MAX_VALUE;
					boolean timeFound = false;
					for(Triple t : this.triples) {
						if( (t.from.equals(edge.getFirst().getName()) && t.to.equals(edge.getSecond().getName())) || (t.to.equals(edge.getFirst().getName()) && t.from.equals(edge.getSecond().getName())) ) {
							time = t.time;
							timeFound = true;
							break;
						}
					}
					if(!timeFound) {
						System.err.println("No time found for edge " + edge.getFirst().getName() + "~" + edge.getSecond().getName() + " in line l" + i);
						error++;
					} else {
						//System.out.println("Time found for edge " + edge.getFirst().getName() + "~" + edge.getSecond().getName() + ": " + time + " seconds");
					}
					output += "\t<data key=\"l" + i + "\">true</data>\r\n";
					output += "\t<data key=\"time\" line=\"l" + i + "\">" + time + "</data>\r\n";
				}
				i++;
			}
			output += "</edge>\r\n";
			edgeCounter++;
		}
		System.err.println(error + " errors");
		
		System.out.println(output);
		
		return true;
	}
	
	public static void main(String argv[]) {
		
		ViennaTravelTimes vtt = new ViennaTravelTimes();
		
	}

}

class Triple {
	
	public String from;
	public String to;
	public int time;
	
	public Triple(String from, String to, int time) {
		this.from = from;
		this.to = to;
		this.time = time;
	}
	
	public String toString() {
		return "{" + this.from + "," + this.to + "," + this.time + "}";
	}
	
}