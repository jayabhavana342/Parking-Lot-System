package maps.parking.txstate.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


/***
 * 
 * @author Mehak Agarwal
 *
 */

class Edge
{
    public final MapsUtil.Vertex target;
    public final double weight;
    public Edge(MapsUtil.Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class MapsUtil
{
	
	public static class Vertex implements Comparable<Vertex>
	{
	    public final String name;
	    public Edge[] adjacencies;
	    public double minDistance = Double.POSITIVE_INFINITY;
	    public Vertex previous;
		private int x;
		private int y;
	    public Vertex(String argName) { 
	    	name = argName; 
	    	MapsUtil.vMap.put(name, this);
	    }
	    public Vertex(String string, int i, int j) {
			this(string);
			x=i;
			y=j;
		}
		public String toString() { return name; }
	    public int compareTo(Vertex other)
	    {
	        return Double.compare(minDistance, other.minDistance);
	    }
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
	
    private static final Edge[] EDGE = new Edge[] {};
    
    static Map<String,Vertex> vMap= new HashMap<String,Vertex>();
    
	public static Vertex v1 = new Vertex("1", 75,585);
	

	public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

	public static List<Vertex> init(Vertex v, String t) {
		
		
		
		Vertex v5 = new Vertex("5", 75,545);
		Vertex v6 = new Vertex("6", 127, 545);
		Vertex v7 = new Vertex("7", 127, 480);
		Vertex v10 = new Vertex("10", 127, 460);
		Vertex v13 = new Vertex("13", 127, 440);
		Vertex v16 = new Vertex("16", 127, 420);
		Vertex v19 = new Vertex("19", 127, 400);
		Vertex v22 = new Vertex("22", 127, 380);
		Vertex v25 = new Vertex("25", 127, 360);
		Vertex v28 = new Vertex("28", 127, 360);
		Vertex v31 = new Vertex("31", 127, 340);
		Vertex v34 = new Vertex("34", 127, 320);
		Vertex v37 = new Vertex("37", 127, 300);
		Vertex v40 = new Vertex("40", 127, 280);
		Vertex v43 = new Vertex("43", 127, 260);
		Vertex v46 = new Vertex("46", 127, 240);
		Vertex v49 = new Vertex("49", 127, 220);
		Vertex v52 = new Vertex("52", 127, 200);
		Vertex v55 = new Vertex("55", 127, 180);;
		Vertex v58 = new Vertex("58", 127, 160);
		Vertex v61 = new Vertex("61", 127, 140);
		Vertex v63 = new Vertex("63", 127, 120);
		Vertex v66 = new Vertex("66", 155, 120);
		Vertex v68 = new Vertex("68", 175, 120);
		Vertex v70 = new Vertex("70", 195, 120);
		Vertex v72 = new Vertex("72", 215, 120);
		Vertex v74 = new Vertex("74", 235, 120);
		Vertex v76 = new Vertex("76", 255, 120);
		Vertex v78 = new Vertex("78", 275, 120);
		Vertex v80 = new Vertex("80", 295, 120);
		Vertex v82 = new Vertex("82", 315, 120);
		Vertex v84 = new Vertex("84", 335, 120);
		Vertex v86 = new Vertex("86", 355, 120);
		Vertex v88 = new Vertex("88", 375, 120);
		Vertex v90 = new Vertex("90", 395, 120);
		Vertex v92 = new Vertex("92", 415, 120);
		Vertex v94 = new Vertex("94", 435, 120);
		Vertex v96 = new Vertex("96", 455, 120);
		Vertex v98 = new Vertex("98", 475, 120);
		Vertex v100 = new Vertex("100", 495, 120);
		Vertex v102 = new Vertex("102", 515, 120);
		Vertex v104 = new Vertex("104", 535, 120);
		Vertex v106 = new Vertex("106", 555, 120);
		Vertex v108 = new Vertex("108", 575, 120);
		Vertex v110 = new Vertex("110", 595, 120);
		Vertex v112 = new Vertex("112", 615, 120);
		Vertex v114 = new Vertex("114", 635, 120);
		Vertex v116 = new Vertex("116", 655, 120);
		Vertex v118 = new Vertex("118", 675, 120);
		Vertex v120 = new Vertex("120", 695, 120);
		Vertex v122 = new Vertex("122", 715, 120);
		Vertex v124 = new Vertex("124", 735, 120);
		Vertex v126 = new Vertex("126", 755, 120);
		Vertex v128 = new Vertex("128", 775, 120);
		Vertex v130 = new Vertex("130", 795, 120);
		Vertex v132 = new Vertex("132", 815, 120);
		Vertex v134 = new Vertex("134", 835, 120);
		Vertex v136 = new Vertex("136", 855, 120);
		Vertex v138 = new Vertex("136", 875, 120);
		Vertex v140 = new Vertex("140", 895, 120);
		Vertex v142 = new Vertex("142", 915, 120);
		Vertex v144 = new Vertex("144", 935, 120);
		Vertex v146 = new Vertex("146");
		Vertex v148 = new Vertex("148");
		Vertex v150 = new Vertex("150");
		Vertex v152 = new Vertex("152");
		Vertex v154 = new Vertex("154");
		Vertex v156 = new Vertex("156");
		Vertex v158 = new Vertex("158");
		Vertex v161 = new Vertex("161");
		Vertex v164 = new Vertex("164");
		Vertex v167 = new Vertex("167");
		Vertex v170 = new Vertex("170");
		Vertex v173 = new Vertex("173");
		Vertex v176 = new Vertex("176");
		Vertex v179 = new Vertex("179");
		Vertex v182 = new Vertex("182");
		Vertex v185 = new Vertex("180");
		Vertex v188 = new Vertex("188");
		Vertex v191 = new Vertex("191");
		Vertex v194 = new Vertex("194");
		Vertex v197 = new Vertex("197");
		Vertex v200 = new Vertex("200");
		Vertex v203 = new Vertex("203");
		Vertex v206 = new Vertex("206");
		Vertex v209 = new Vertex("209");
		Vertex v212 = new Vertex("212");
		Vertex v215 = new Vertex("215");
		Vertex v230 = new Vertex("230");
		Vertex v233 = new Vertex("233");
		Vertex v236 = new Vertex("236");
		Vertex v239 = new Vertex("239");
		Vertex v242 = new Vertex("242");
		Vertex v245 = new Vertex("245");
		Vertex v248 = new Vertex("248");
		Vertex v251 = new Vertex("251");
		Vertex v254 = new Vertex("254");
		Vertex v257 = new Vertex("257");
		Vertex v260 = new Vertex("260");
		Vertex v263 = new Vertex("263");
		Vertex v266 = new Vertex("266");
		Vertex v269 = new Vertex("269");
		Vertex v272 = new Vertex("272");
		Vertex v275 = new Vertex("275");
		Vertex v278 = new Vertex("278");
		Vertex v281 = new Vertex("281");
		

		Vertex v218 = new Vertex("218");
		Vertex v219 = new Vertex("219");
		Vertex v222 = new Vertex("222");

		v1.adjacencies = new Edge[] { new Edge(v5, 40) };
		v5.adjacencies = new Edge[] { new Edge(v1, 40), new Edge(v6, 20) };

		v6.adjacencies = new Edge[] { new Edge(v5, 20), new Edge(v7, 40), new Edge(v219, 40) };
		v7.adjacencies = new Edge[] { new Edge(v6, 7.5), new Edge(v10, 7.5), new Edge(v10, 7.5), };
		v10.adjacencies = new Edge[] { new Edge(v7, 7.5), new Edge(v13, 7.5) };
		v13.adjacencies = new Edge[] { new Edge(v10, 7.5), new Edge(v16, 7.5) };
		v16.adjacencies = new Edge[] { new Edge(v13, 7.5), new Edge(v19, 7.5) };
		v19.adjacencies = new Edge[] { new Edge(v16, 7.5), new Edge(v22, 7.5) };
		v22.adjacencies = new Edge[] { new Edge(v19, 7.5), new Edge(v25, 7.5) };
		v25.adjacencies = new Edge[] { new Edge(v22, 7.5), new Edge(v28, 7.5) };
		v28.adjacencies = new Edge[] { new Edge(v25, 7.5), new Edge(v31, 7.5) };
		v31.adjacencies = new Edge[] { new Edge(v28, 7.5), new Edge(v34, 7.5) };
		v34.adjacencies = new Edge[] { new Edge(v31, 7.5), new Edge(v37, 7.5) };
		v37.adjacencies = new Edge[] { new Edge(v34, 7.5), new Edge(v40, 7.5) };
		v40.adjacencies = new Edge[] { new Edge(v37, 7.5), new Edge(v43, 7.5) };
		v43.adjacencies = new Edge[] { new Edge(v40, 7.5), new Edge(v46, 7.5) };
		v46.adjacencies = new Edge[] { new Edge(v43, 7.5), new Edge(v49, 7.5) };
		v49.adjacencies = new Edge[] { new Edge(v46, 7.5), new Edge(v52, 7.5) };
		v52.adjacencies = new Edge[] { new Edge(v49, 7.5), new Edge(v55, 7.5) };
		v55.adjacencies = new Edge[] { new Edge(v52, 7.5), new Edge(v58, 7.5) };
		v58.adjacencies = new Edge[] { new Edge(v55, 7.5), new Edge(v61, 7.5) };
		v61.adjacencies = new Edge[] { new Edge(v58, 7.5), new Edge(v63, 7.5) };
		Vertex p1 = new Vertex("P1", 115, 80);
		p1.adjacencies = EDGE;
		
		Vertex p2 = new Vertex("P2", 135, 80);
		p2.adjacencies = EDGE;
		Vertex p51 = new Vertex("P51");
		p51.adjacencies = EDGE;
		Vertex p52 = new Vertex("P52");
		p52.adjacencies = EDGE;
		v63.adjacencies = new Edge[] { new Edge(v61, 7.5), new Edge(v66, 7.5), new Edge(p1, 1), new Edge(p2, 1),
				new Edge(p51, 1), new Edge(p52, 1) };
		Vertex p3 = new Vertex("P3", 155, 80);
		p3.adjacencies = EDGE;
		v66.adjacencies = new Edge[] { new Edge(v63, 7.5), new Edge(v68, 7.5), new Edge(p3, 1) };
		Vertex p4 = new Vertex("P4", 175, 80 );
		p4.adjacencies = EDGE;
		v68.adjacencies = new Edge[] { new Edge(v66, 7.5), new Edge(v70, 7.5), new Edge(p4, 1) };
		Vertex p5 = new Vertex("P5", 195, 80);
		p5.adjacencies = EDGE;
		v70.adjacencies = new Edge[] { new Edge(v68, 7.5), new Edge(v72, 7.5), new Edge(p5, 1) };
		Vertex p6 = new Vertex("P6", 215, 80);
		p6.adjacencies = EDGE;
		v72.adjacencies = new Edge[] { new Edge(v70, 7.5), new Edge(v74, 7.5), new Edge(p6, 1) };
		Vertex p7 = new Vertex("P7", 235, 80 );
		p7.adjacencies = EDGE;
		v74.adjacencies = new Edge[] { new Edge(v72, 7.5), new Edge(v76, 7.5), new Edge(p7, 1) };
		Vertex p8 = new Vertex("P8", 255, 80);
		p8.adjacencies = EDGE;
		v76.adjacencies = new Edge[] { new Edge(v74, 7.5), new Edge(v78, 7.5), new Edge(p8, 1) };
		Vertex p9 = new Vertex("P9", 275, 80);
		p9.adjacencies = EDGE;
		v78.adjacencies = new Edge[] { new Edge(v76, 7.5), new Edge(v80, 7.5), new Edge(p9, 1) };;
		Vertex p10 = new Vertex("P10", 295, 80);
		p10.adjacencies = EDGE;
		v80.adjacencies = new Edge[] { new Edge(v78, 7.5), new Edge(v82, 7.5), new Edge(p10, 1) };
		Vertex p11 = new Vertex("P11", 315, 80);
		p11.adjacencies = EDGE;
		v82.adjacencies = new Edge[] { new Edge(v80, 7.5), new Edge(v84, 7.5), new Edge(v158, 15), new Edge(p11, 1) };
		Vertex p12 = new Vertex("P12", 335, 80);
		p12.adjacencies = EDGE;
		v84.adjacencies = new Edge[] { new Edge(v82, 7.5), new Edge(v86, 7.5), new Edge(v158, 15), new Edge(p12, 1) };
		Vertex p13 = new Vertex("P13", 355, 80);
		p13.adjacencies = EDGE;
		v86.adjacencies = new Edge[] { new Edge(v84, 7.5), new Edge(v88, 7.5), new Edge(p13, 1) };
		Vertex p14 = new Vertex("P14", 375, 80);
		p14.adjacencies = EDGE;
		v88.adjacencies = new Edge[] { new Edge(v90, 7.5), new Edge(v88, 7.5), new Edge(p14, 1) };
		Vertex p15 = new Vertex("P15", 395, 80);
		p15.adjacencies = EDGE;
		v90.adjacencies = new Edge[] { new Edge(v92, 7.5), new Edge(v90, 7.5), new Edge(p15, 1) };
		Vertex p16 = new Vertex("P16", 415, 80);
		p16.adjacencies = EDGE;
		v92.adjacencies = new Edge[] { new Edge(v94, 7.5), new Edge(v92, 7.5), new Edge(p16, 1) };
		Vertex p17 = new Vertex("P17", 435, 80);
		p17.adjacencies = EDGE;
		v94.adjacencies = new Edge[] { new Edge(v96, 7.5), new Edge(v94, 7.5), new Edge(p17, 1) };
		Vertex p18 = new Vertex("P18", 455, 80);
		p18.adjacencies = EDGE;
		v96.adjacencies = new Edge[] { new Edge(v98, 7.5), new Edge(v100, 7.5), new Edge(p18, 1) };
		Vertex p19 = new Vertex("P19", 475, 80);
		p19.adjacencies = EDGE;
		v98.adjacencies = new Edge[] { new Edge(v96, 7.5), new Edge(v100, 7.5), new Edge(p19, 1) };
		Vertex p20 = new Vertex("P20", 495, 80);
		p20.adjacencies = EDGE;
		v100.adjacencies = new Edge[] { new Edge(v98, 7.5), new Edge(v102, 7.5), new Edge(p20, 1) };
		Vertex p21 = new Vertex("P21", 515, 80);
		p21.adjacencies = EDGE;
		v102.adjacencies = new Edge[] { new Edge(v100, 7.5), new Edge(v104, 7.5) ,new Edge(p21, 1) };
		Vertex p22 = new Vertex("P22", 535, 80);
		p22.adjacencies = EDGE;
		v104.adjacencies = new Edge[] { new Edge(v102, 7.5), new Edge(v106, 7.5), new Edge(p22, 1) };
		Vertex p23 = new Vertex("P23", 555, 80);
		p23.adjacencies = EDGE;
		v106.adjacencies = new Edge[] { new Edge(v104, 7.5), new Edge(v108, 7.5), new Edge(p23, 1) };
		Vertex p24 = new Vertex("P24", 575, 80);
		p24.adjacencies = EDGE;
		v108.adjacencies = new Edge[] { new Edge(v106, 7.5), new Edge(v110, 7.5), new Edge(p24, 1) };
		Vertex p25 = new Vertex("P25", 595, 80);
		p25.adjacencies = EDGE;
		v110.adjacencies = new Edge[] { new Edge(v108, 7.5), new Edge(v112, 7.5), new Edge(p25, 1) };
		Vertex p26 = new Vertex("P26", 615, 80);
		p26.adjacencies = EDGE;
		v112.adjacencies = new Edge[] { new Edge(v110, 7.5), new Edge(v114, 7.5), new Edge(p26, 1) };
		Vertex p27 = new Vertex("P27", 635, 80);
		p27.adjacencies = EDGE;
		v114.adjacencies = new Edge[] { new Edge(v112, 7.5), new Edge(v116, 7.5), new Edge(p27, 1) };
		Vertex p28 = new Vertex("P28", 655, 80);
		p28.adjacencies = EDGE;
		v116.adjacencies = new Edge[] { new Edge(v114, 7.5), new Edge(v118, 7.5), new Edge(p28, 1) };
		Vertex p29 = new Vertex("P29", 675, 80);
		p29.adjacencies = EDGE;
		v118.adjacencies = new Edge[] { new Edge(v116, 7.5), new Edge(v120, 7.5), new Edge(p29, 1) };
		Vertex p30 = new Vertex("P30", 695, 80);
		p30.adjacencies = EDGE;
		v120.adjacencies = new Edge[] { new Edge(v118, 7.5), new Edge(v122, 7.5), new Edge(p30, 1) };
		Vertex p31 = new Vertex("P31", 715, 80);
		p31.adjacencies = EDGE;
		v122.adjacencies = new Edge[] { new Edge(v120, 7.5), new Edge(v124, 7.5), new Edge(p31, 1) };
		Vertex p32 = new Vertex("P32", 735, 80);
		p32.adjacencies = EDGE;
		v124.adjacencies = new Edge[] { new Edge(v122, 7.5), new Edge(v126, 7.5), new Edge(p32, 1) };
		Vertex p33 = new Vertex("P33", 755, 80);
		p33.adjacencies = EDGE;
		v126.adjacencies = new Edge[] { new Edge(v124, 7.5), new Edge(v128, 7.5) ,new Edge(p33, 1) };
		Vertex p34 = new Vertex("P34", 775, 80);
		p34.adjacencies = EDGE;
		v128.adjacencies = new Edge[] { new Edge(v126, 7.5), new Edge(v130, 7.5) ,new Edge(p34, 1) };
		Vertex p35 = new Vertex("P35", 795, 80);
		p35.adjacencies = EDGE;
		v130.adjacencies = new Edge[] { new Edge(v128, 7.5), new Edge(v132, 7.5) ,new Edge(p35, 1) };
		Vertex p36 = new Vertex("P36", 815, 80);
		p36.adjacencies = EDGE;
		v132.adjacencies = new Edge[] { new Edge(v130, 7.5), new Edge(v134, 7.5) ,new Edge(p36, 1) };
		Vertex p37 = new Vertex("P37", 835, 80);
		p37.adjacencies = EDGE;
		v134.adjacencies = new Edge[] { new Edge(v132, 7.5), new Edge(v136, 7.5) ,new Edge(p37, 1) };
		Vertex p38 = new Vertex("P38", 855, 80);
		p38.adjacencies = EDGE;
		v136.adjacencies = new Edge[] { new Edge(v134, 7.5), new Edge(v138, 7.5), new Edge(p38, 1) };
		Vertex p39 = new Vertex("P39");
		p39.adjacencies = EDGE;
		v138.adjacencies = new Edge[] { new Edge(v136, 7.5), new Edge(v140, 7.5) };
		Vertex p40 = new Vertex("P40");
		p40.adjacencies = EDGE;
		v140.adjacencies = new Edge[] { new Edge(v138, 7.5), new Edge(v142, 7.5) };
		Vertex p41 = new Vertex("P41");
		p41.adjacencies = EDGE;
		v142.adjacencies = new Edge[] { new Edge(v140, 7.5), new Edge(v144, 7.5) };
		Vertex p42 = new Vertex("P42");
		p42.adjacencies = EDGE;
		v144.adjacencies = new Edge[] { new Edge(v142, 7.5), new Edge(v146, 7.5) };
		Vertex p43 = new Vertex("P43");
		p43.adjacencies = EDGE;
		v146.adjacencies = new Edge[] { new Edge(v144, 7.5), new Edge(v148, 7.5) };
		Vertex p44 = new Vertex("P44");
		p44.adjacencies = EDGE;
		v148.adjacencies = new Edge[] { new Edge(v146, 7.5), new Edge(v150, 7.5) };
		Vertex p45 = new Vertex("P45");
		p45.adjacencies = EDGE;
		v150.adjacencies = new Edge[] { new Edge(v148, 7.5), new Edge(v152, 7.5) };
		Vertex p46 = new Vertex("P46");
		p46.adjacencies = EDGE;
		v152.adjacencies = new Edge[] { new Edge(v150, 7.5), new Edge(v154, 7.5) };
		Vertex p47 = new Vertex("P47");
		p40.adjacencies = EDGE;
		v154.adjacencies = new Edge[] { new Edge(v152, 7.5), new Edge(v156, 7.5) };
		Vertex p48 = new Vertex("P48");
		p48.adjacencies = EDGE;
		v156.adjacencies = new Edge[] { new Edge(v154, 8), new Edge(p48, 1) };

		v158.adjacencies = new Edge[] { new Edge(v82, 15), new Edge(v84, 15), new Edge(v161, 6.75) };
		v161.adjacencies = new Edge[] { new Edge(v158, 6.75), new Edge(v164, 6.75) };
		v164.adjacencies = new Edge[] { new Edge(v161, 6.75), new Edge(v167, 6.75) };
		v167.adjacencies = new Edge[] { new Edge(v164, 6.75), new Edge(v170, 6.75) };
		v170.adjacencies = new Edge[] { new Edge(v167, 6.75), new Edge(v173, 6.75) };
		v173.adjacencies = new Edge[] { new Edge(v170, 6.75), new Edge(v176, 6.75) };
		v176.adjacencies = new Edge[] { new Edge(v173, 6.75), new Edge(v179, 6.75) };
		v179.adjacencies = new Edge[] { new Edge(v176, 6.75), new Edge(v182, 6.75) };
		v182.adjacencies = new Edge[] { new Edge(v179, 6.75), new Edge(v185, 6.75) };
		v185.adjacencies = new Edge[] { new Edge(v182, 6.75), new Edge(v188, 6.75) };
		v188.adjacencies = new Edge[] { new Edge(v185, 6.75), new Edge(v191, 6.75) };
		v191.adjacencies = new Edge[] { new Edge(v188, 6.75), new Edge(v194, 6.75) };
		v194.adjacencies = new Edge[] { new Edge(v191, 6.75), new Edge(v197, 6.75) };
		v197.adjacencies = new Edge[] { new Edge(v194, 6.75), new Edge(v200, 6.75) };
		v200.adjacencies = new Edge[] { new Edge(v197, 6.75), new Edge(v203, 6.75) };
		v203.adjacencies = new Edge[] { new Edge(v200, 6.75), new Edge(v206, 6.75) };
		v206.adjacencies = new Edge[] { new Edge(v203, 6.75), new Edge(v209, 6.75) };
		v209.adjacencies = new Edge[] { new Edge(v206, 6.75), new Edge(v212, 6.75) };
		v212.adjacencies = new Edge[] { new Edge(v209, 6.75), new Edge(v215, 6.75) };
		v215.adjacencies = new Edge[] { new Edge(v212, 6.75), new Edge(v218, 40) };

		v218.adjacencies = new Edge[] { new Edge(v215, 40), new Edge(v206, 40), new Edge(v219, 50) };
		v219.adjacencies = new Edge[] { new Edge(v6, 50), new Edge(v6, 50) };

		v230.adjacencies = new Edge[] { new Edge(v222, 40), new Edge(v233, 7.5) };
		v230.adjacencies = new Edge[] { new Edge(v222, 40), new Edge(v233, 7.5) };
		v233.adjacencies = new Edge[] { new Edge(v230, 7.5), new Edge(v236, 7.5) };
		v236.adjacencies = new Edge[] { new Edge(v233, 7.5), new Edge(v239, 7.5) };
		v239.adjacencies = new Edge[] { new Edge(v236, 7.5), new Edge(v242, 7.5) };
		v242.adjacencies = new Edge[] { new Edge(v239, 7.5), new Edge(v245, 7.5) };
		v245.adjacencies = new Edge[] { new Edge(v242, 7.5), new Edge(v248, 7.5) };
		v248.adjacencies = new Edge[] { new Edge(v245, 7.5), new Edge(v251, 7.5) };
		v251.adjacencies = new Edge[] { new Edge(v248, 7.5), new Edge(v254, 7.5) };
		v254.adjacencies = new Edge[] { new Edge(v251, 7.5), new Edge(v257, 7.5) };
		v257.adjacencies = new Edge[] { new Edge(v254, 7.5), new Edge(v260, 7.5) };
		v260.adjacencies = new Edge[] { new Edge(v257, 7.5), new Edge(v263, 7.5) };
		v263.adjacencies = new Edge[] { new Edge(v260, 7.5), new Edge(v266, 7.5) };
		v266.adjacencies = new Edge[] { new Edge(v263, 7.5), new Edge(v269, 7.5) };
		v269.adjacencies = new Edge[] { new Edge(v266, 7.5), new Edge(v272, 7.5) };
		v272.adjacencies = new Edge[] { new Edge(v269, 7.5), new Edge(v275, 7.5) };
		v275.adjacencies = new Edge[] { new Edge(v272, 7.5), new Edge(v278, 7.5) };
		v278.adjacencies = new Edge[] { new Edge(v275, 7.5), new Edge(v281, 7.5) };
		v281.adjacencies = new Edge[] { new Edge(v278, 7.5), new Edge(v104, 15) };

		computePaths(v);
		Vertex t1 = vMap.get(t);
		return getShortestPathTo(t1);
	}
}